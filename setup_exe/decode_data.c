#include <stdint.h>

extern uint8_t DAT_0042a010[32];
extern uint8_t DAT_0042a030[32];

static inline uint8_t u8(int x) {
    return (uint8_t)x;
}

void decode_data(
    uint8_t *outA,     // param_1
    uint8_t *state,    // param_2 (256 bytes)
    uint8_t *key,      // param_3 (>= 128 bytes)
    uint8_t *outB,     // ECX
    uint8_t *work      // EDX
) {
    if (!outA || !state || !key || !outB || !work)
        return;

    /* ============================================================
       Phase 0 — Global key byte
       ============================================================ */
    uint8_t global_key =
        key[0x7F] ^ key[0x40] ^ key[0x2A] ^ key[0x00] ^ 0xBC;

    /* ============================================================
       Phase 1 — Initialize 256-byte state buffer
       ============================================================ */
    for (int i = 0; i < 256; i++) {
        uint8_t base =
            key[i & 0x7F] ^
            DAT_0042a030[i & 0x1F] ^
            DAT_0042a010[i & 0x1F] ^
            u8(i);

        uint8_t mix =
            (key[(i + 1) & 0x7F] << 3) ^
            (DAT_0042a010[(i + 2) & 0x1F] >> 2);

        state[i] = base ^ mix;
    }

    /* ============================================================
       Phase 2 — 16 rounds of state diffusion
       ============================================================ */
    for (int round = 0; round < 16; round++) {
        for (int i = 0; i < 256; i++) {
            uint8_t idx = state[i] + global_key + round;
            state[i] ^= state[idx] ^ key[(i + round) & 0x7F];
        }
    }

    /* ============================================================
       Phase 3 — Generate streams into outA / outB / work
       ============================================================ */
    for (int i = 1; i < 0x400; i++) {
        uint8_t s = state[i & 0xFF];
        uint8_t n = u8(i - 1);

        /* outB stream */
        outB[i - 1] = global_key ^ n ^ s ^ 0xBC;

        /* work stream */
        uint8_t k =
            (key[(i + 1) & 0x7F] >> 2) ^
            (key[(i - 1) & 0x7F] << 3) ^
            DAT_0042a030[n & 0x1F] ^
            DAT_0042a010[n & 0x1F] ^
            n;

        work[i - 1] = k ^ outB[i - 1] ^ s;

        /* outA stream */
        outA[i - 1] =
            key[(i + 3) & 0x7F] ^
            DAT_0042a010[n & 0x1F] ^
            (work[i - 1] >> 1) ^
            k ^
            global_key ^
            s ^
            0xBC;
    }

    /* ============================================================
       Phase 4 — Large permutation / swapping engine
       ============================================================ */
    uint16_t idx1 = 0, idx2 = 0;

    for (int outer = 2; outer < 0x8000; outer++) {
        uint8_t c1 = DAT_0042a010[(outer - 2) & 0x1F];
        uint8_t c2 = DAT_0042a030[(outer - 2) & 0x1F];

        for (int i = 0; i < 0x400; i++) {

            uint8_t a = outB[idx1];
            uint8_t b = outB[idx2];

            /* swap */
            outB[idx1] = b;
            outB[idx2] = a;

            uint8_t x =
                key[(outer + i) & 0x7F] ^
                work[idx2] ^
                global_key ^
                a ^
                c2 ^
                c1 ^
                state[(outer - 2) & 0xFF] ^
                outA[(outer - 2) & 0x7F] ^
                0xBC;

            work[i] ^= x;

            idx1 = (idx1 + 1) & 0x3FF;
            idx2 = (idx2 + 1) & 0x3FF;
        }
    }

    /* ============================================================
       Phase 5 — Final nonlinear whitening (9 rounds)
       ============================================================ */
    uint16_t acc1 = 0, acc2 = 0;

    for (int round = 0; round < 9; round++) {
        for (int i = 0; i < 0x400; i++) {

            uint8_t v =
                work[i] ^
                key[(round + i) & 0x7F] ^
                outA[(i + round) & 0x7F] ^
                DAT_0042a030[(round + i) & 0x1F] ^
                DAT_0042a010[(i + round) & 0x1F];

            acc1 = (acc1 + v * 0x9D + outB[i] * 0xFB) & 0x3FF;
            acc2 = (acc2 + v * 0x83 + outB[acc1] * 0xB3) & 0x3FF;

            uint8_t t1 = outB[acc1];
            uint8_t t2 = outB[acc2];

            outB[i]       = t1 + v ^ state[(i + round) & 0xFF];
            outB[acc1]    = t2 - v ^ work[(i + round) & 0xFF];
            outB[acc2]    = t1 ^ v ^ outA[(i + round) & 0x7F];
        }
    }
}