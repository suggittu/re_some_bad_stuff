
uint __fastcall hasher(uint8_t *buf,int len)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  uint uVar4;
  undefined1 *puVar5;
  uint *puVar6;
  int iVar7;
  uint uVar8;
  uint uVar9;
  uint uVar10;
  uint uVar11;
  uint local_4c;
  int local_48;
  uint local_38;
  uint local_30;
  uint uStack_2c;
  uint uStack_28;
  undefined4 uStack_24;
  uint local_20;
  uint uStack_1c;
  uint uStack_18;
  uint uStack_14;
  uint local_10;
  uint uStack_c;
  uint uStack_8;
  undefined4 uStack_4;
  
  if ((buf != (uint8_t *)0x0) && (0 < len)) {
    local_30 = 0x1eca950c;
    uStack_2c = 0x24aa7021;
    uVar8 = 0x100;
    if (len < 0x101) {
      uVar8 = len;
    }
    uStack_28 = 0x6c92ea91;
    uStack_24 = 0xbf21234d;
    local_4c = 0;
    make_rotation((uint)&local_30);
    if (-1 < (int)(uVar8 - 0x10)) {
      iVar2 = (int)buf - (int)&local_10;
      puVar6 = (uint *)buf;
      do {
        puVar6 = puVar6 + 4;
        if ((uint *)buf != (uint *)0x0) {
          if ((&local_10 < buf) || (puVar6 <= &local_10)) {
            uVar4 = 0;
            do {
              puVar5 = (undefined1 *)((int)&local_10 + uVar4);
              uVar4 = uVar4 + 1;
              *puVar5 = puVar5[iVar2];
            } while (uVar4 < 0x10);
          }
          else {
            iVar3 = 0xf;
            iVar7 = 0x10;
            do {
              *(uint8_t *)((int)&local_10 + iVar3) = *(uint8_t *)((int)buf + iVar3);
              iVar3 = iVar3 + -1;
              iVar7 = iVar7 + -1;
            } while (iVar7 != 0);
          }
        }
        uStack_c = uStack_c ^ local_4c;
        local_10 = local_10 ^ uVar8;
        uStack_8 = uStack_8 ^ 0x1a6ed677;
        uStack_4 = uStack_4 ^ 0x50fc19e3;
        local_4c = local_4c + 0x10;
        uStack_2c = uStack_c + uStack_2c;
        uStack_24 = uStack_4 + uStack_24;
        uVar4 = local_10 + local_30 + uStack_2c;
        uVar9 = (uStack_2c >> 0x13 | uStack_2c * 0x2000) ^ uVar4;
        uVar1 = uStack_8 + uStack_28 + uStack_24;
        uVar10 = (uStack_24 >> 0x10 | uStack_24 * 0x10000) ^ uVar1;
        uVar1 = uVar1 + uVar9;
        uVar4 = uVar4 + uVar10;
        uVar9 = (uVar9 >> 0xf | uVar9 << 0x11) ^ uVar1;
        uVar10 = (uVar10 >> 7 | uVar10 << 0x19) ^ uVar4;
        uVar4 = uVar9 + uVar4;
        uVar1 = uVar1 + uVar10;
        uVar10 = (uVar10 >> 0x15 | uVar10 << 0xb) ^ uVar1;
        uVar11 = uVar1 ^ uVar4;
        uStack_2c = (uVar1 >> 0x17 | uVar1 * 0x200) +
                    ((uVar9 >> 0x1b | uVar9 << 5) ^ uVar10 ^ uVar4);
        uVar4 = (uVar1 >> 7 | uVar1 * 0x2000000) ^ uStack_2c;
        buf = (uint8_t *)((int)buf + 0x10);
        uStack_28 = (uVar10 >> 0xd | uVar10 << 0x13) + uVar11;
        uVar1 = (uVar11 >> 0x13 | uVar11 << 0xd) ^ uStack_28;
        uStack_28 = uStack_28 + uVar4;
        uStack_2c = uStack_2c + uVar1;
        uVar4 = (uVar4 >> 7 | uVar4 << 0x19) ^ uStack_28;
        uVar1 = (uVar1 >> 0xf | uVar1 << 0x11) ^ uStack_2c;
        uStack_28 = uStack_28 + uVar1;
        uStack_2c = uStack_2c + uVar4;
        uVar4 = (uVar4 >> 0x15 | uVar4 << 0xb) ^ uStack_2c;
        uStack_24 = uStack_2c >> 0x17 | uStack_2c * 0x200;
        uStack_2c = uStack_2c ^ uStack_28;
        uStack_28 = (uVar1 >> 0x1b | uVar1 << 5) ^ uVar4 ^ uStack_28;
        iVar2 = iVar2 + 0x10;
        local_30 = uVar4 >> 0xd | uVar4 << 0x13;
        start_as_zero = start_as_zero ^ (byte)local_4c;
      } while ((int)local_4c <= (int)(uVar8 - 0x10));
    }
    uVar4 = 0;
    uVar1 = 0;
    uVar9 = 0;
    uVar10 = 0;
    uVar11 = uVar8 - local_4c;
    local_20 = 0;
    uStack_1c = 0;
    uStack_18 = 0;
    uStack_14 = 0;
    if (0 < (int)uVar11) {
      if ((uint *)buf != (uint *)0x0) {
        if ((&local_20 < buf) || ((uint *)((int)buf + uVar11) <= &local_20)) {
          uVar4 = 0;
          if (uVar11 != 0) {
            do {
              puVar5 = (undefined1 *)((int)&local_20 + uVar4);
              uVar4 = uVar4 + 1;
              *puVar5 = puVar5[(int)buf - (int)&local_20];
            } while (uVar4 < uVar11);
          }
        }
        else {
          puVar5 = (undefined1 *)((int)&uStack_24 + uVar11 + 3);
          uVar4 = uVar11;
          do {
            *puVar5 = puVar5[(int)buf - (int)&local_20];
            uVar4 = uVar4 - 1;
            puVar5 = puVar5 + -1;
          } while (uVar4 != 0);
        }
      }
      uVar1 = uStack_1c ^ uVar8;
      start_as_zero = start_as_zero + (char)uVar11;
      uVar4 = local_20 ^ uVar11 * -0x61c88647;
      uVar9 = uStack_18 ^ local_4c;
      uVar10 = uStack_14 ^ 0x1a6ed677;
    }
    iVar2 = 0;
    local_38 = 0;
    uVar4 = uVar4 + local_30;
    uVar1 = uVar1 + uStack_2c;
    uVar9 = uVar9 + uStack_28;
    uVar10 = uVar10 + uStack_24;
    local_48 = 0;
    do {
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
    uVar8 = (uVar9 >> 0xf | uVar9 << 0x11) ^ uVar10 ^ uVar8;
    start_as_zero = start_as_zero ^ (byte)uVar8;
    return uVar8;
  }
  start_as_zero = start_as_zero ^ 0xaa;
  return 0;
}

