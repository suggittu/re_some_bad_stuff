
uint __fastcall hasher(uint8_t *buf, int len)
{
    uint uVar1;
    int iVar2;
    int iVar3;
    uint uVar4;
    undefined1 *puVar5;
    uint *buf;
    int iVar7;
    uint lenght;
    uint uVar9;
    uint uVar10;
    uint uVar11;
    uint local_4c;
    int local_48;
    uint local_38;
    uint state_0;
    uint uStack_2c;
    uint state_2;
    undefined4 state_3;
    uint local_20;
    uint uStack_1c;
    uint uStack_18;
    uint uStack_14;
    uint local_10;
    uint uStack_c;
    uint uStack_8;
    undefined4 uStack_4;

    state_0 = 0x1eca950c;
    state_1 = 0x24aa7021;
    lenght = 0x100;
    if (len < 0x101)
    {
        lenght = len;
    }
    state_2 = 0x6c92ea91;
    state_3 = 0xbf21234d;
    to_xor = 0;
    make_rotation((uint)&state_0);

    buf = buf + 4;
    for (int i = 0; i < 0x10; i++)
    {
        puVar5 = ((int)&local_10 + uVar4);
        *puVar5 = puVar5[iVar2];
    }
    do
    {
        uStack_c = uStack_c ^ to_xor;
        local_10 = local_10 ^ lenght;
        uStack_8 = uStack_8 ^ 0x1a6ed677;
        uStack_4 = uStack_4 ^ 0x50fc19e3;
        to_xor = to_xor + 0x10;
        state_1 = uStack_c + uStack_2c;
        state_3 = uStack_4 + state_3;
        uVar4 = local_10 + state_0 + uStack_2c;
        uVar9 = (state_1 >> 0x13 | state_1 * 0x2000) ^ uVar4;
        uVar1 = uStack_8 + state_2 + state_3;
        uVar10 = (state_3 >> 0x10 | state_3 * 0x10000) ^ uVar1;
        uVar1 = uVar1 + uVar9;
        uVar4 = uVar4 + uVar10;
        uVar9 = (uVar9 >> 0xf | uVar9 << 0x11) ^ uVar1;
        uVar10 = (uVar10 >> 7 | uVar10 << 0x19) ^ uVar4;
        uVar4 = uVar9 + uVar4;
        uVar1 = uVar1 + uVar10;
        uVar10 = (uVar10 >> 0x15 | uVar10 << 0xb) ^ uVar1;
        uVar11 = uVar1 ^ uVar4;
        state_1 = (uVar1 >> 0x17 | uVar1 * 0x200) +
                  ((uVar9 >> 0x1b | uVar9 << 5) ^ uVar10 ^ uVar4);
        uVar4 = (uVar1 >> 7 | uVar1 * 0x2000000) ^ uStack_2c;
        buf = (uint8_t *)((int)buf + 0x10);
        state_2 = (uVar10 >> 0xd | uVar10 << 0x13) + uVar11;
        uVar1 = (uVar11 >> 0x13 | uVar11 << 0xd) ^ state_2;
        state_2 = state_2 + uVar4;
        state_1 = state_1 + uVar1;
        uVar4 = (uVar4 >> 7 | uVar4 << 0x19) ^ state_2;
        uVar1 = (uVar1 >> 0xf | uVar1 << 0x11) ^ uStack_2c;
        state_2 = state_2 + uVar1;
        state_1 = state_1 + uVar4;
        uVar4 = (uVar4 >> 0x15 | uVar4 << 0xb) ^ uStack_2c;
        state_3 = state_1 >> 0x17 | state_1 * 0x200;
        state_1 = state_1 ^ state_2;
        state_2 = (uVar1 >> 0x1b | uVar1 << 5) ^ uVar4 ^ state_2;
        iVar2 = iVar2 + 0x10;
        state_0 = uVar4 >> 0xd | uVar4 << 0x13;
        start_as_zero = start_as_zero ^ (byte)to_xor;
    } while ((int)to_xor <= (int)(lenght - 0x10));
    uVar4 = 0;
    uVar1 = 0;
    uVar9 = 0;
    uVar10 = 0;
    uVar11 = lenght - to_xor;
    local_20 = 0;
    uStack_1c = 0;
    uStack_18 = 0;
    uStack_14 = 0;
    if (0 < (int)uVar11)
    {
        if ((uint *)buf != (uint *)0x0)
        {
            if ((&local_20 < buf) || ((uint *)((int)buf + uVar11) <= &local_20))
            {
                uVar4 = 0;
                if (uVar11 != 0)
                {
                    do
                    {
                        puVar5 = (undefined1 *)((int)&local_20 + uVar4);
                        uVar4 = uVar4 + 1;
                        *puVar5 = puVar5[(int)buf - (int)&local_20];
                    } while (uVar4 < uVar11);
                }
            }
            else
            {
                puVar5 = (undefined1 *)((int)&state_3 + uVar11 + 3);
                uVar4 = uVar11;
                do
                {
                    *puVar5 = puVar5[(int)buf - (int)&local_20];
                    uVar4 = uVar4 - 1;
                    puVar5 = puVar5 + -1;
                } while (uVar4 != 0);
            }
        }
        uVar1 = uStack_1c ^ lenght;
        start_as_zero = start_as_zero + (char)uVar11;
        uVar4 = local_20 ^ uVar11 * -0x61c88647;
        uVar9 = uStack_18 ^ to_xor;
        uVar10 = uStack_14 ^ 0x1a6ed677;
    }
    iVar2 = 0;
    local_38 = 0;
    uVar4 = uVar4 + state_0;
    uVar1 = uVar1 + uStack_2c;
    uVar9 = uVar9 + state_2;
    uVar10 = uVar10 + state_3;
    local_48 = 0;
    do
    {
        uVar11 = uVar1 + 0x243f6a88 + iVar2;
        iVar2 = iVar2 + 0x243f6a88;
        uVar4 = (uVar11 - local_48) + uVar4;
        uVar1 = (uVar10 >> 0x10 | uVar10 << 0x10) ^ uVar10 + uVar9;
        uVar11 = (uVar11 >> 0x13 | uVar11 * 0x2000) ^ uVar4;
        uVar4 = uVar1 + uVar4;
        uVar9 = uVar10 + uVar9 + uVar11;
        uVar1 = (uVar1 >> 7 | uVar1 << 0x19) ^ uVar4;
        uVar11 = (uVar11 >> 0xf | uVar11 << 0x11) ^ uVar9;
        uVar9 = uVar9 + uVar1;
        uVar10 = (uVar1 >> 0x15 | uVar1 << 0xb) ^ uVar9;
        uVar1 = uVar11 + uVar4;
        uVar4 = uVar9 ^ uVar1;
        uVar1 = (uVar11 >> 0x1b | uVar11 << 5) ^ uVar10 ^ uVar1;
        uVar9 = uVar9 >> 0x17 | uVar9 * 0x200;
        start_as_zero = start_as_zero ^ (byte)local_38;
        uVar10 = (uVar10 >> 0xd | uVar10 << 0x13) ^ local_38;
        local_38 = local_38 + 1;
        local_48 = local_48 + 0x61c88647;
    } while ((int)local_38 < 8);
    uVar1 = (uVar4 >> 0x19 | uVar4 << 7) ^ uVar1;
    uVar9 = (uVar1 >> 0x15 | uVar1 << 0xb) ^ uVar9;
    lenght = (uVar9 >> 0xf | uVar9 << 0x11) ^ uVar10 ^ lenght;
    start_as_zero = start_as_zero ^ (byte)lenght;
    return lenght;
}
