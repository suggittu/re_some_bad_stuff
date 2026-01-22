
code * more_api_call(void)

{
  uint8_t uVar1;
  short *psVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  code *pcVar6;
  undefined *puVar7;
  code *pcVar8;
  uint8_t *puVar9;
  undefined *puVar10;
  code *pcVar11;
  int iVar12;
  int iVar13;
  code *pcVar14;
  uint uVar15;
  int unaff_FS_OFFSET;
  code *pcVar16;
  code *pcStack_4c;
  undefined4 uStack_48;
  undefined4 uStack_44;
  code *pcStack_40;
  code *pcStack_3c;
  int iStack_38;
  undefined4 uStack_34;
  code *local_20;
  
  psVar2 = *(short **)
            (*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) +
            0x18);
  if (psVar2 != (short *)0x0) {
    if (*psVar2 == 0x5a4d) {
      if (*(int *)(*(int *)(psVar2 + 0x1e) + (int)psVar2) == 0x4550) {
        iVar13 = *(int *)(*(int *)(psVar2 + 0x1e) + 0x78 + (int)psVar2) + (int)psVar2;
        if (iVar13 == 0) {
          local_20 = (code *)0x0;
        }
        else {
          iVar3 = *(int *)(iVar13 + 0x1c);
          uVar15 = 0;
          iVar4 = *(int *)(iVar13 + 0x20);
          iVar5 = *(int *)(iVar13 + 0x24);
          if (*(int *)(iVar13 + 0x18) != 0) {
            do {
              iVar12 = 0;
              puVar9 = (uint8_t *)(*(int *)((int)psVar2 + uVar15 * 4 + iVar4) + (int)psVar2);
              if (puVar9 != (uint8_t *)0x0) {
                uVar1 = *puVar9;
                while (uVar1 != '\0') {
                  iVar12 = iVar12 + 1;
                  uVar1 = puVar9[iVar12];
                }
              }
              uStack_34 = 0x4295e2;
              iVar12 = hasher(puVar9,iVar12);
              if (iVar12 == 0x7fdb33b8) {
                local_20 = (code *)(*(int *)((int)psVar2 +
                                            (uint)*(ushort *)((int)psVar2 + uVar15 * 2 + iVar5) * 4
                                            + iVar3) + (int)psVar2);
                goto LAB_004295f5;
              }
              uVar15 = uVar15 + 1;
            } while (uVar15 < *(uint *)(iVar13 + 0x18));
          }
          local_20 = (code *)0x0;
        }
      }
      else {
        local_20 = (code *)0x0;
      }
    }
    else {
      local_20 = (code *)0x0;
    }
LAB_004295f5:
    if (((*psVar2 == 0x5a4d) && (*(int *)(*(int *)(psVar2 + 0x1e) + (int)psVar2) == 0x4550)) &&
       (iVar13 = *(int *)(*(int *)(psVar2 + 0x1e) + 0x78 + (int)psVar2) + (int)psVar2, iVar13 != 0))
    {
      iVar3 = *(int *)(iVar13 + 0x1c);
      uVar15 = 0;
      iVar4 = *(int *)(iVar13 + 0x20);
      iVar5 = *(int *)(iVar13 + 0x24);
      if (*(int *)(iVar13 + 0x18) != 0) {
        do {
          iVar12 = 0;
          puVar9 = (uint8_t *)(*(int *)((int)psVar2 + uVar15 * 4 + iVar4) + (int)psVar2);
          if (puVar9 != (uint8_t *)0x0) {
            uVar1 = *puVar9;
            while (uVar1 != '\0') {
              iVar12 = iVar12 + 1;
              uVar1 = puVar9[iVar12];
            }
          }
          uStack_34 = 0x429670;
          iVar12 = hasher(puVar9,iVar12);
          if (iVar12 == 0x1d499ba0) {
            pcVar14 = (code *)(*(int *)((int)psVar2 +
                                       (uint)*(ushort *)((int)psVar2 + uVar15 * 2 + iVar5) * 4 +
                                       iVar3) + (int)psVar2);
            goto LAB_0042967f;
          }
          uVar15 = uVar15 + 1;
        } while (uVar15 < *(uint *)(iVar13 + 0x18));
      }
    }
    pcVar14 = (code *)0x0;
LAB_0042967f:
    if (((*psVar2 == 0x5a4d) && (*(int *)(*(int *)(psVar2 + 0x1e) + (int)psVar2) == 0x4550)) &&
       (iVar13 = *(int *)(*(int *)(psVar2 + 0x1e) + 0x78 + (int)psVar2) + (int)psVar2, iVar13 != 0))
    {
      iVar3 = *(int *)(iVar13 + 0x1c);
      uVar15 = 0;
      iVar4 = *(int *)(iVar13 + 0x20);
      iVar5 = *(int *)(iVar13 + 0x24);
      if (*(int *)(iVar13 + 0x18) != 0) {
        do {
          iVar12 = 0;
          puVar9 = (uint8_t *)(*(int *)((int)psVar2 + uVar15 * 4 + iVar4) + (int)psVar2);
          if (puVar9 != (uint8_t *)0x0) {
            uVar1 = *puVar9;
            while (uVar1 != '\0') {
              iVar12 = iVar12 + 1;
              uVar1 = puVar9[iVar12];
            }
          }
          uStack_34 = 0x429707;
          iVar12 = hasher(puVar9,iVar12);
          if (iVar12 == 0x6a75788) {
            iVar13 = *(int *)((int)psVar2 +
                             (uint)*(ushort *)((int)psVar2 + uVar15 * 2 + iVar5) * 4 + iVar3) +
                     (int)psVar2;
            goto LAB_0042971e;
          }
          uVar15 = uVar15 + 1;
        } while (uVar15 < *(uint *)(iVar13 + 0x18));
      }
    }
    iVar13 = 0;
LAB_0042971e:
    if (((local_20 != (code *)0x0) && (pcVar14 != (code *)0x0)) && (iVar13 != 0)) {
      uStack_34 = 4;
      iStack_38 = 0x3000;
      pcStack_3c = (code *)0xce0;
      pcStack_40 = (code *)0x0;
      uStack_44 = 0x42974e;
      pcVar6 = (code *)(*local_20)();
      if (pcVar6 != (code *)0x0) {
        uVar15 = 0;
        do {
          pcVar6[uVar15] = (code)0x0;
          uVar15 = uVar15 + 1;
        } while (uVar15 < 0xce0);
        uStack_44 = 4;
        uStack_48 = 0x3000;
        pcStack_4c = (code *)0x80;
        puVar7 = (undefined *)(*local_20)(0);
        if (puVar7 != (undefined *)0x0) {
          uVar15 = 0;
          do {
            puVar7[uVar15] = 0;
            uVar15 = uVar15 + 1;
          } while (uVar15 < 0x80);
          if ((puVar7 < &DAT_004366e8) || ((undefined *)0x436767 < puVar7)) {
            uVar15 = 0;
            do {
              puVar7[uVar15] = (puVar7 + uVar15)[(int)&DAT_004366e8 - (int)puVar7];
              uVar15 = uVar15 + 1;
            } while (uVar15 < 0x80);
          }
          else {
            iVar13 = 0x80;
            puVar10 = puVar7 + 0x7f;
            do {
              *puVar10 = puVar10[(int)&DAT_004366e8 - (int)puVar7];
              iVar13 = iVar13 + -1;
              puVar10 = puVar10 + -1;
              pcVar14 = pcStack_3c;
            } while (iVar13 != 0);
          }
          pcVar16 = (code *)0x0;
          pcVar8 = (code *)(*pcStack_40)(0,0xce0,0x3000,4);
          if (pcVar8 != (code *)0x0) {
            if ((pcVar8 < &DAT_004367e8) || ((code *)0x4374c7 < pcVar8)) {
              uVar15 = 0;
              do {
                pcStack_40 = (code *)uVar15;
                pcVar8[(int)pcStack_40] =
                     (pcVar8 + (int)pcStack_40)[(int)&DAT_004367e8 - (int)pcVar8];
                uVar15 = (int)pcStack_40 + 1U;
              } while ((int)pcStack_40 + 1U < 0xce0);
            }
            else {
              iVar13 = 0xce0;
              pcVar14 = pcVar8 + 0xcdf;
              uVar15 = 0xcdf;
              do {
                pcStack_40 = (code *)uVar15;
                *pcVar14 = pcVar14[(int)&DAT_004367e8 - (int)pcVar8];
                iVar13 = iVar13 + -1;
                pcVar14 = pcVar14 + -1;
                uVar15 = (int)pcStack_40 - 1;
                pcVar6 = pcStack_3c;
              } while (iVar13 != 0);
            }
            FUN_00428590(puVar7,0x80);
            pcVar14 = pcStack_4c;
            if ((pcVar6 < pcVar8) || (pcVar8 + 0xce0 <= pcVar6)) {
              uVar15 = 0;
              do {
                pcStack_40 = (code *)uVar15;
                pcVar6[(int)pcStack_40] = (pcVar6 + (int)pcStack_40)[(int)pcVar8 - (int)pcVar6];
                uVar15 = (int)pcStack_40 + 1U;
              } while ((int)pcStack_40 + 1U < 0xce0);
            }
            else {
              iStack_38 = (int)pcVar8 - (int)pcVar6;
              iVar13 = 0xce0;
              pcVar11 = pcVar6 + 0xcdf;
              uVar15 = 0xcdf;
              do {
                pcStack_40 = (code *)uVar15;
                *pcVar11 = pcVar11[iStack_38];
                iVar13 = iVar13 + -1;
                pcVar11 = pcVar11 + -1;
                uVar15 = (int)pcStack_40 - 1;
                pcVar6 = pcStack_3c;
              } while (iVar13 != 0);
            }
            (*pcStack_4c)(puVar7,0,0x8000);
            (*pcVar14)(pcVar8,0,0x8000);
            (*pcVar16)(pcVar6,0xce0,0x20,&pcStack_4c);
            return pcVar6;
          }
          (*pcVar14)(puVar7,0,0x8000);
        }
        (*pcVar14)(pcVar6,0,0x8000);
      }
    }
  }
  return (code *)0x0;
}

