#include <stdint.h>

// Helper macro for Rotate Left
#define ROTL32(v, n) ((v << n) | (v >> (32 - n)))

void make_rotation(uint32_t* data) {
    uint32_t a = data[0]; // param_1 + 0x0
    uint32_t b = data[1]; // param_1 + 0x4
    uint32_t c = data[2]; // param_1 + 0x8
    uint32_t d = data[3]; // param_1 + 0xc

    uint32_t uVar1, uVar2, uVar3, uVar4, uVar5;

    // The logic extracted from the decompilation:
    uVar4 = d;
    uVar3 = b;
    uVar1 = c + uVar4;
    uVar2 = ROTL32(uVar4, 16) ^ uVar1;
    
    uVar4 = ROTL32(uVar3, 13) ^ (a + uVar3);
    uVar1 = uVar1 + uVar4;
    uVar5 = ROTL32(uVar4, 17) ^ uVar1;
    
    uVar4 = uVar2 + (a + uVar3);
    uVar3 = ROTL32(uVar2, 25) ^ uVar4;
    
    uVar4 = uVar5 + uVar4;
    uVar1 = uVar1 + uVar3;
    uVar3 = ROTL32(uVar3, 11) ^ uVar1;

    // Final assignments back to the pointer
    data[2] = ROTL32(uVar5, 5) ^ uVar4 ^ uVar3; // param_1 + 0x8
    data[0] = ROTL32(uVar3, 19);               // param_1 + 0x0
    data[3] = ROTL32(uVar1, 9);                // param_1 + 0xc (uVar1 * 0x200 is << 9)
    data[1] = uVar4 ^ uVar1;                   // param_1 + 0x4
}