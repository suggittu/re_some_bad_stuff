
void FUN_00427610(int param_1,byte *param_2,byte *param_3)

{
  byte *pbVar1;
  byte *pbVar2;
  byte bVar3;
  bool bVar4;
  byte bVar5;
  uint uVar6;
  byte *pbVar7;
  uint uVar8;
  uint uVar9;
  uint uVar10;
  uint uVar11;
  byte *pbVar12;
  byte *pbVar13;
  uint uVar14;
  byte bVar15;
  int in_ECX;
  uint uVar16;
  uint uVar17;
  int iVar18;
  byte bVar19;
  int in_EDX;
  uint uVar20;
  byte bVar21;
  byte bVar22;
  byte bVar23;
  int iVar24;
  uint local_68;
  uint local_64;
  uint local_60;
  uint local_5c;
  uint local_58;
  int local_54;
  int local_50;
  uint local_4c;
  uint local_48;
  uint local_44;
  uint local_40;
  int local_3c;
  int local_38;
  byte *local_34;
  uint local_30;
  uint local_1c;
  uint local_18;
  
  if ((((in_ECX != 0) && (in_EDX != 0)) && (param_1 != 0)) &&
     ((param_2 != (byte *)0x0 && (param_3 != (byte *)0x0)))) {
    bVar5 = param_3[0x7f] ^ param_3[0x40] ^ param_3[0x2a] ^ *param_3;
    bVar23 = bVar5 ^ 0xbc;
    local_30 = 0;
    do {
      pbVar7 = param_2 + local_30;
      bVar21 = param_3[local_30 & 0x7f] ^ (&DAT_0042a030)[local_30 & 0x1f] ^
               (&DAT_0042a010)[local_30 & 0x1f] ^ (byte)local_30;
      *pbVar7 = bVar21;
      uVar6 = (uint)(pbVar7 + (2 - (int)param_2) + -1) & 0x8000007f;
      if ((int)uVar6 < 0) {
        uVar6 = (uVar6 - 1 | 0xffffff80) + 1;
      }
      uVar20 = (uint)(pbVar7 + (2 - (int)param_2)) & 0x8000001f;
      if ((int)uVar20 < 0) {
        uVar20 = (uVar20 - 1 | 0xffffffe0) + 1;
      }
      local_30 = local_30 + 1;
      *pbVar7 = param_3[uVar6] * '\b' + bVar21 ^ (byte)(&DAT_0042a010)[uVar20] >> 2;
    } while ((int)local_30 < 0x100);
    local_5c = -(int)param_2;
    local_58 = 0;
    do {
      iVar24 = 0x100;
      pbVar7 = param_2;
      do {
        uVar6 = (uint)*pbVar7 + (uint)bVar23 + local_58 & 0x800000ff;
        if ((int)uVar6 < 0) {
          uVar6 = (uVar6 - 1 | 0xffffff00) + 1;
        }
        uVar20 = (uint)(pbVar7 + local_5c) & 0x8000007f;
        if ((int)uVar20 < 0) {
          uVar20 = (uVar20 - 1 | 0xffffff80) + 1;
        }
        *pbVar7 = param_2[uVar6] ^ param_3[uVar20] ^ *pbVar7;
        pbVar7 = pbVar7 + 1;
        iVar24 = iVar24 + -1;
      } while (iVar24 != 0);
      local_5c = local_5c + 1;
      local_58 = local_58 + 1;
    } while ((int)local_58 < 0x10);
    uVar20 = 0;
    uVar6 = 1;
    do {
      while( true ) {
        uVar16 = uVar20 & 0x800000ff;
        if ((int)uVar16 < 0) {
          uVar16 = (uVar16 - 1 | 0xffffff00) + 1;
        }
        pbVar7 = param_2 + uVar16;
        uVar11 = uVar6 - 1;
        bVar21 = (byte)uVar11;
        *(byte *)((uVar6 - 1) + in_ECX) = bVar5 ^ bVar21 ^ *pbVar7 ^ 0xbc;
        uVar8 = uVar6 + 1;
        if ((int)uVar11 < 0x100) {
          uVar9 = uVar11 & 0x8000007f;
          if ((int)uVar9 < 0) {
            uVar9 = (uVar9 - 1 | 0xffffff80) + 1;
          }
          uVar17 = uVar11 & 0x8000001f;
          if ((int)uVar17 < 0) {
            uVar17 = (uVar17 - 1 | 0xffffffe0) + 1;
          }
          bVar19 = (&DAT_0042a030)[uVar17];
          uVar10 = uVar6 & 0x8000007f;
          if ((int)uVar10 < 0) {
            uVar10 = (uVar10 - 1 | 0xffffff80) + 1;
          }
          bVar22 = param_3[uVar10] >> 2 ^ (param_3[uVar9] << 3 ^ bVar19) << 3 ^
                   (&DAT_0042a010)[uVar17] ^ bVar21;
          *(byte *)(in_EDX + -1 + uVar6) = bVar22;
          uVar17 = uVar6 + 2 & 0x8000007f;
          if ((int)uVar17 < 0) {
            uVar17 = (uVar17 - 1 | 0xffffff80) + 1;
          }
          uVar10 = uVar8 & 0x8000007f;
          if ((int)uVar10 < 0) {
            uVar10 = (uVar10 - 1 | 0xffffff80) + 1;
          }
          bVar19 = param_3[uVar17] >> 4 ^ param_3[uVar10] << 5 ^ bVar21 & 0xe3 ^ bVar22 ^ bVar19;
          *(byte *)(in_EDX + -1 + uVar6) = bVar19;
          uVar9 = (uint)*(byte *)(uVar16 + in_EDX) + param_3[uVar9] + uVar11 & 0x800003ff;
          if ((int)uVar9 < 0) {
            uVar9 = (uVar9 - 1 | 0xfffffc00) + 1;
          }
          *(byte *)(in_EDX + -1 + uVar6) =
               (*(byte *)(uVar9 + in_ECX) ^ bVar5 ^ 0xbc) + bVar19 ^ *pbVar7;
        }
        local_34 = (byte *)(uVar16 + in_EDX);
        if (0x7f < (int)uVar11) break;
        uVar16 = uVar11 & 0x8000001f;
        if ((int)uVar16 < 0) {
          uVar16 = (uVar16 - 1 | 0xffffffe0) + 1;
        }
        uVar11 = uVar11 & 0x8000007f;
        if ((int)uVar11 < 0) {
          uVar11 = (uVar11 - 1 | 0xffffff80) + 1;
        }
        uVar9 = uVar6 + 3 & 0x8000007f;
        if ((int)uVar9 < 0) {
          uVar9 = (uVar9 - 1 | 0xffffff80) + 1;
        }
        bVar21 = (param_3[uVar11] << 2 ^ bVar21) << 3 ^ param_3[uVar9] >> 3 ^
                 (&DAT_0042a010)[uVar16];
        *(byte *)(param_1 + -1 + uVar6) = bVar21;
        uVar11 = uVar6 + 4 & 0x8000007f;
        if ((int)uVar11 < 0) {
          uVar11 = (uVar11 - 1 | 0xffffff80) + 1;
        }
        *(byte *)(param_1 + -1 + uVar6) =
             param_3[uVar11] << 3 ^ (&DAT_0042a030)[uVar16] ^ *local_34 >> 1 ^ bVar21 ^ bVar5 ^
             *pbVar7 ^ 0xbc;
        uVar20 = uVar20 + 1;
        uVar6 = uVar8;
      }
      uVar20 = uVar20 + 1;
      bVar4 = (int)uVar6 < 0x400;
      uVar6 = uVar8;
    } while (bVar4);
    local_64 = 0;
    local_68 = 0;
    local_5c = 2;
    iVar24 = param_1 - in_EDX;
    local_40 = 0;
    local_3c = 4;
    do {
      uVar6 = local_5c - 2 & 0x1f;
      local_58 = 0;
      bVar21 = (&DAT_0042a010)[uVar6];
      bVar19 = (&DAT_0042a030)[uVar6];
      uVar6 = local_5c - 1 & 0x800000ff;
      if ((int)uVar6 < 0) {
        uVar6 = (uVar6 - 1 | 0xffffff00) + 1;
      }
      uVar20 = local_5c & 0x8000007f;
      if ((int)uVar20 < 0) {
        uVar20 = (uVar20 - 1 | 0xffffff80) + 1;
      }
      pbVar7 = (byte *)((local_5c - 2 & 0x7f) + param_1);
      uVar16 = local_5c;
      iVar18 = in_EDX;
      do {
        uVar11 = uVar16 - 2 & 0x800000ff;
        if ((int)uVar11 < 0) {
          uVar11 = (uVar11 - 1 | 0xffffff00) + 1;
        }
        bVar22 = *(byte *)(iVar18 + (in_ECX - in_EDX));
        local_64 = (uint)bVar22 +
                   param_3[local_58 & 0x7f] + local_64 +
                   ((byte)(bVar5 ^ *(byte *)(uVar11 + in_EDX) ^ param_2[local_5c - 2 & 0xff] ^
                           bVar19 ^ bVar21 ^ *pbVar7) ^ 0xbc) & 0x800003ff;
        if ((int)local_64 < 0) {
          local_64 = (local_64 - 1 | 0xfffffc00) + 1;
        }
        pbVar12 = (byte *)(local_58 + in_EDX);
        uVar8 = (uint)(pbVar12 + (2 - in_EDX)) & 0x8000007f;
        if ((int)uVar8 < 0) {
          uVar8 = (uVar8 - 1 | 0xffffff80) + 1;
        }
        local_68 = (uint)*(byte *)(local_64 + in_ECX) +
                   param_3[uVar8] + local_68 +
                   ((byte)(bVar5 ^ param_2[uVar6] ^ *(byte *)(uVar20 + param_1) ^ bVar19) ^ 0xbc ^
                   local_40) & 0x800003ff;
        if ((int)local_68 < 0) {
          local_68 = (local_68 - 1 | 0xfffffc00) + 1;
        }
        pbVar13 = pbVar12 + (in_ECX - in_EDX);
        *pbVar13 = *(byte *)(local_64 + in_ECX);
        *(undefined1 *)(local_64 + in_ECX) = *(undefined1 *)(local_68 + in_ECX);
        *(byte *)(local_68 + in_ECX) = bVar22;
        uVar8 = local_5c + local_58;
        uVar9 = uVar8 - 2 & 0x8000007f;
        if ((int)uVar9 < 0) {
          uVar9 = (uVar9 - 1 | 0xffffff80) + 1;
        }
        uVar17 = local_68 & 0x800000ff;
        if ((int)uVar17 < 0) {
          uVar17 = (uVar17 - 1 | 0xffffff00) + 1;
        }
        bVar22 = param_3[uVar9] ^ *(byte *)(uVar17 + in_EDX) ^ bVar5 ^ *(byte *)(local_64 + in_ECX)
                 ^ bVar19 ^ bVar21 ^ param_2[local_5c - 2 & 0xff] ^ *pbVar7 ^ *pbVar13 ^ 0xbc;
        pbVar1 = &DAT_0042a010 + (local_58 & 0x1f);
        uVar9 = uVar8 & 0x8000007f;
        if ((int)uVar9 < 0) {
          uVar9 = (uVar9 - 1 | 0xffffff80) + 1;
        }
        pbVar2 = &DAT_0042a030 + (local_58 & 0x1f);
        if (local_58 < 0x100) {
          bVar3 = *pbVar2;
          bVar15 = ((byte)local_58 & 0xd7 ^ param_3[local_58 & 0x7f]) + bVar22 + *pbVar12 ^
                   bVar3 >> 2 ^ *pbVar1;
          *pbVar12 = bVar15;
          uVar17 = uVar8 + (bVar23 - 2) & 0x800003ff;
          if ((int)uVar17 < 0) {
            uVar17 = (uVar17 - 1 | 0xfffffc00) + 1;
          }
          *pbVar12 = *(byte *)(uVar17 + in_ECX) >> 4 ^ *(byte *)(uVar9 + param_1) ^
                     param_2[local_58 & 0xff] ^ bVar15 ^ bVar3;
          if (local_58 < 0x80) {
            bVar22 = (((byte)local_58 | 0xb3) ^ bVar5 ^ 0xbc) + bVar22 ^ *pbVar1 ^ pbVar12[iVar24];
            pbVar12[iVar24] = bVar22;
            uVar8 = uVar8 + local_3c & 0x8000007f;
            if ((int)uVar8 < 0) {
              uVar8 = (uVar8 - 1 | 0xffffff80) + 1;
            }
            pbVar12[iVar24] =
                 param_3[uVar8] >> 3 ^ *(byte *)(uVar11 + in_EDX) * ' ' + bVar22 ^
                 param_2[local_58 & 0xff] ^ *pbVar2;
          }
        }
        uVar8 = local_58 & 0xff;
        uVar11 = (uint)*pbVar13 + (local_5c - 2) + (uint)bVar23 & 0x800000ff;
        if ((int)uVar11 < 0) {
          uVar11 = (uVar11 - 1 | 0xffffff00) + 1;
        }
        local_58 = local_58 + 1;
        *pbVar13 = *(byte *)(uVar11 + in_EDX) ^ param_3[uVar9] ^ param_2[uVar8] ^ bVar23 << 4 ^
                   *pbVar1 ^ *pbVar2 ^ *pbVar13 ^ *pbVar7;
        uVar16 = uVar16 + 1;
        iVar18 = iVar18 + 1;
      } while ((int)local_58 < 0x400);
      local_40 = local_40 + 2;
      local_3c = local_3c + -1;
      iVar18 = local_5c - 1;
      local_5c = local_5c + 1;
    } while (iVar18 < 0x8000);
    iVar24 = param_1 - in_ECX;
    iVar18 = in_EDX - in_ECX;
    local_60 = 0;
    local_34 = (byte *)0x0;
    local_38 = 0;
    local_18 = 0;
    local_1c = 0;
    local_30 = 0;
    local_5c = 0;
    local_58 = 0;
    local_54 = 0;
    do {
      uVar16 = 0;
      local_4c = local_58;
      local_48 = local_5c;
      uVar6 = local_1c;
      uVar20 = local_18;
      local_50 = in_ECX;
      local_44 = local_30;
      do {
        uVar11 = uVar6 & 0x800000ff;
        if ((int)uVar11 < 0) {
          uVar11 = (uVar11 - 1 | 0xffffff00) + 1;
        }
        uVar8 = uVar20 & 0x8000007f;
        if ((int)uVar8 < 0) {
          uVar8 = (uVar8 - 1 | 0xffffff80) + 1;
        }
        uVar9 = local_44 & 0x8000007f;
        if ((int)uVar9 < 0) {
          uVar9 = (uVar9 - 1 | 0xffffff80) + 1;
        }
        uVar17 = local_48 & 0x8000001f;
        if ((int)uVar17 < 0) {
          uVar17 = (uVar17 - 1 | 0xffffffe0) + 1;
        }
        uVar10 = local_4c & 0x8000001f;
        if ((int)uVar10 < 0) {
          uVar10 = (uVar10 - 1 | 0xffffffe0) + 1;
        }
        bVar5 = *(byte *)(uVar11 + in_EDX) ^ param_3[uVar8] ^ *(byte *)(uVar9 + param_1) ^
                (&DAT_0042a030)[uVar17] ^ (&DAT_0042a010)[uVar10];
        uVar8 = local_60 + 2 + uVar16;
        uVar11 = uVar8 - 2 & 0x800000ff;
        if ((int)uVar11 < 0) {
          uVar11 = (uVar11 - 1 | 0xffffff00) + 1;
        }
        uVar17 = (uint)bVar5;
        pbVar7 = (byte *)(in_ECX + uVar16);
        bVar23 = *pbVar7;
        uVar9 = (local_60 - 2) + uVar8 & 0x8000007f;
        if ((int)uVar9 < 0) {
          uVar9 = (uVar9 - 1 | 0xffffff80) + 1;
        }
        local_64 = (uint)bVar23 * 0xfb +
                   uVar17 * 0x9d + local_64 +
                   (uint)*(byte *)(uVar9 + param_1) + (uint)*(byte *)(uVar11 + in_EDX) * 199 &
                   0x800003ff;
        if ((int)local_64 < 0) {
          local_64 = (local_64 - 1 | 0xfffffc00) + 1;
        }
        bVar21 = *(byte *)(local_64 + in_ECX);
        uVar9 = local_54 + local_64 & 0x800000ff;
        if ((int)uVar9 < 0) {
          uVar9 = (uVar9 - 1 | 0xffffff00) + 1;
        }
        local_68 = (uint)bVar21 * 0xb3 +
                   uVar17 * 0x83 + local_68 + (uint)*(byte *)(uVar9 + in_EDX) * 0xa3 & 0x800003ff;
        if ((int)local_68 < 0) {
          local_68 = (local_68 - 1 | 0xfffffc00) + 1;
        }
        uVar9 = local_68 & 0x800003ff;
        if ((int)uVar9 < 0) {
          uVar9 = (uVar9 - 1 | 0xfffffc00) + 1;
        }
        bVar19 = *(byte *)(in_ECX + uVar9);
        uVar10 = local_60 + bVar23 & 0x800000ff;
        if ((int)uVar10 < 0) {
          uVar10 = (uVar10 - 1 | 0xffffff00) + 1;
        }
        *(byte *)(in_ECX + uVar16) = bVar21 + bVar5 ^ param_2[uVar10] ^ bVar19 * -0x17;
        uVar10 = local_60 + bVar21 & 0x800000ff;
        if ((int)uVar10 < 0) {
          uVar10 = (uVar10 - 1 | 0xffffff00) + 1;
        }
        *(byte *)(local_64 + in_ECX) = bVar19 - bVar5 ^ *(byte *)(uVar10 + in_EDX) ^ bVar23 * -0x11;
        uVar10 = bVar19 + local_60 & 0x8000007f;
        if ((int)uVar10 < 0) {
          uVar10 = (uVar10 - 1 | 0xffffff80) + 1;
        }
        *(byte *)(in_ECX + uVar9) = bVar21 * -0xf ^ *(byte *)(uVar10 + param_1) ^ bVar23 ^ bVar5;
        if (uVar16 < 0x100) {
          uVar9 = uVar8 - 1 & 0x800003ff;
          if ((int)uVar9 < 0) {
            uVar9 = (uVar9 - 1 | 0xfffffc00) + 1;
          }
          uVar10 = uVar8 - 2 & 0x800003ff;
          if ((int)uVar10 < 0) {
            uVar10 = (uVar10 - 1 | 0xfffffc00) + 1;
          }
          uVar14 = local_38 + uVar16 & 0x8000001f;
          if ((int)uVar14 < 0) {
            uVar14 = (uVar14 - 1 | 0xffffffe0) + 1;
          }
          bVar23 = (*(byte *)(uVar9 + in_ECX) >> 3 | *(char *)(uVar10 + in_ECX) << 5) +
                   (&DAT_0042a010)[uVar14] + *pbVar7 * bVar5 + *(char *)(local_50 + iVar18);
          pbVar7[iVar18] = bVar23;
          uVar9 = bVar23 + uVar17 + local_60 & 0x800000ff;
          if ((int)uVar9 < 0) {
            uVar9 = (uVar9 - 1 | 0xffffff00) + 1;
          }
          pbVar7[iVar18] = param_2[uVar9] ^ bVar23;
        }
        if (uVar16 < 0x80) {
          uVar8 = uVar8 & 0x800000ff;
          if ((int)uVar8 < 0) {
            uVar8 = (uVar8 - 1 | 0xffffff00) + 1;
          }
          uVar9 = (int)local_34 + uVar16 & 0x8000001f;
          if ((int)uVar9 < 0) {
            uVar9 = (uVar9 - 1 | 0xffffffe0) + 1;
          }
          bVar23 = (*(char *)(uVar8 + in_EDX) << 6 | *(byte *)(uVar11 + in_EDX) >> 2) +
                   (&DAT_0042a030)[uVar9] + bVar5 * '\x03' + *pbVar7 ^ pbVar7[iVar24];
          pbVar7[iVar24] = bVar23;
          uVar11 = ((bVar23 ^ bVar5) ^ local_60) & 0x800000ff;
          if ((int)uVar11 < 0) {
            uVar11 = (uVar11 - 1 | 0xffffff00) + 1;
          }
          pbVar7[iVar24] = param_2[uVar11] + bVar23;
        }
        uVar16 = uVar16 + 1;
        uVar20 = uVar20 + 1;
        local_44 = local_44 + 1;
        uVar6 = uVar6 + 1;
        local_48 = local_48 + 1;
        local_4c = local_4c + 1;
        local_50 = local_50 + 1;
      } while ((int)uVar16 < 0x400);
      local_60 = local_60 + 1;
      local_54 = local_54 + 3;
      local_1c = local_1c + 0xd;
      local_30 = local_30 + 7;
      local_18 = local_18 + 0x11;
      local_58 = local_58 + 0xb;
      local_5c = local_5c + 0x13;
      local_38 = local_38 + 0x25;
      local_34 = (byte *)((int)local_34 + 0x29);
    } while (local_54 < 9);
  }
  return;
}

