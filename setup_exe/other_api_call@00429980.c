
void other_api_call(void)

{
  uint8_t uVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  code *pcVar5;
  undefined *puVar6;
  uint8_t *puVar7;
  undefined *puVar8;
  int iVar9;
  int iVar10;
  code *pcVar11;
  uint uVar12;
  int unaff_FS_OFFSET;
  code *pcVar13;
  code *pcVar14;
  code *pcVar15;
  code *local_1c;
  short *base_address;
  
  base_address = *(short **)
                  (*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc)
                  + 0x18);
  if (base_address != (short *)0x0) {
    if (*base_address == 0x5a4d) {
      if (*(int *)(*(int *)(base_address + 0x1e) + (int)base_address) == 0x4550) {
        iVar10 = *(int *)(*(int *)(base_address + 0x1e) + 0x78 + (int)base_address) +
                 (int)base_address;
        if (iVar10 == 0) {
          local_1c = (code *)0x0;
        }
        else {
          iVar2 = *(int *)(iVar10 + 0x1c);
          uVar12 = 0;
          iVar3 = *(int *)(iVar10 + 0x20);
          iVar4 = *(int *)(iVar10 + 0x24);
          if (*(int *)(iVar10 + 0x18) != 0) {
            do {
              iVar9 = 0;
              puVar7 = (uint8_t *)
                       (*(int *)((int)base_address + uVar12 * 4 + iVar3) + (int)base_address);
              if (puVar7 != (uint8_t *)0x0) {
                uVar1 = *puVar7;
                while (uVar1 != '\0') {
                  iVar9 = iVar9 + 1;
                  uVar1 = puVar7[iVar9];
                }
              }
              iVar9 = hasher(puVar7,iVar9);
              if (iVar9 == 0x7fdb33b8) {
                local_1c = (code *)(*(int *)((int)base_address +
                                            (uint)*(ushort *)
                                                   ((int)base_address + uVar12 * 2 + iVar4) * 4 +
                                            iVar2) + (int)base_address);
                goto LAB_00429a45;
              }
              uVar12 = uVar12 + 1;
            } while (uVar12 < *(uint *)(iVar10 + 0x18));
          }
          local_1c = (code *)0x0;
        }
      }
      else {
        local_1c = (code *)0x0;
      }
    }
    else {
      local_1c = (code *)0x0;
    }
LAB_00429a45:
    if (((*base_address == 0x5a4d) &&
        (*(int *)(*(int *)(base_address + 0x1e) + (int)base_address) == 0x4550)) &&
       (iVar10 = *(int *)(*(int *)(base_address + 0x1e) + 0x78 + (int)base_address) +
                 (int)base_address, iVar10 != 0)) {
      iVar2 = *(int *)(iVar10 + 0x1c);
      uVar12 = 0;
      iVar3 = *(int *)(iVar10 + 0x20);
      iVar4 = *(int *)(iVar10 + 0x24);
      if (*(int *)(iVar10 + 0x18) != 0) {
        do {
          iVar9 = 0;
          puVar7 = (uint8_t *)(*(int *)((int)base_address + uVar12 * 4 + iVar3) + (int)base_address)
          ;
          if (puVar7 != (uint8_t *)0x0) {
            uVar1 = *puVar7;
            while (uVar1 != '\0') {
              iVar9 = iVar9 + 1;
              uVar1 = puVar7[iVar9];
            }
          }
          iVar9 = hasher(puVar7,iVar9);
          if (iVar9 == 0x1d499ba0) {
            pcVar11 = (code *)(*(int *)((int)base_address +
                                       (uint)*(ushort *)((int)base_address + uVar12 * 2 + iVar4) * 4
                                       + iVar2) + (int)base_address);
            goto LAB_00429acf;
          }
          uVar12 = uVar12 + 1;
        } while (uVar12 < *(uint *)(iVar10 + 0x18));
      }
    }
    pcVar11 = (code *)0x0;
LAB_00429acf:
    if (((*base_address == 0x5a4d) &&
        (*(int *)(*(int *)(base_address + 0x1e) + (int)base_address) == 0x4550)) &&
       (iVar10 = *(int *)(*(int *)(base_address + 0x1e) + 0x78 + (int)base_address) +
                 (int)base_address, iVar10 != 0)) {
      iVar2 = *(int *)(iVar10 + 0x1c);
      uVar12 = 0;
      iVar3 = *(int *)(iVar10 + 0x20);
      iVar4 = *(int *)(iVar10 + 0x24);
      if (*(int *)(iVar10 + 0x18) != 0) {
        do {
          iVar9 = 0;
          puVar7 = (uint8_t *)(*(int *)((int)base_address + uVar12 * 4 + iVar3) + (int)base_address)
          ;
          if (puVar7 != (uint8_t *)0x0) {
            uVar1 = *puVar7;
            while (uVar1 != '\0') {
              iVar9 = iVar9 + 1;
              uVar1 = puVar7[iVar9];
            }
          }
          iVar9 = hasher(puVar7,iVar9);
          if (iVar9 == 0x6a75788) {
            iVar10 = *(int *)((int)base_address +
                             (uint)*(ushort *)((int)base_address + uVar12 * 2 + iVar4) * 4 + iVar2)
                     + (int)base_address;
            goto LAB_00429b6e;
          }
          uVar12 = uVar12 + 1;
        } while (uVar12 < *(uint *)(iVar10 + 0x18));
      }
    }
    iVar10 = 0;
LAB_00429b6e:
    if (((local_1c != (code *)0x0) && (pcVar11 != (code *)0x0)) && (iVar10 != 0)) {
      pcVar15 = (code *)0x57000;
      pcVar14 = (code *)0x0;
      pcVar5 = (code *)(*local_1c)(0,0x57000,0x3000,4);
      if (pcVar5 != (code *)0x0) {
        uVar12 = 0;
        do {
          pcVar5[uVar12] = (code)0x0;
          uVar12 = uVar12 + 1;
        } while (uVar12 < 0x57000);
        pcVar13 = (code *)0x80;
        puVar6 = (undefined *)(*local_1c)(0,0x80,0x3000,4);
        if (puVar6 != (undefined *)0x0) {
          uVar12 = 0;
          do {
            puVar6[uVar12] = 0;
            uVar12 = uVar12 + 1;
          } while (uVar12 < 0x80);
          if ((puVar6 < &DAT_00436768) || ((undefined *)0x4367e7 < puVar6)) {
            uVar12 = 0;
            do {
              puVar6[uVar12] = (puVar6 + uVar12)[(int)&DAT_00436768 - (int)puVar6];
              uVar12 = uVar12 + 1;
              pcVar15 = pcVar11;
            } while (uVar12 < 0x80);
          }
          else {
            iVar10 = 0x80;
            puVar8 = puVar6 + 0x7f;
            do {
              *puVar8 = puVar8[(int)&DAT_00436768 - (int)puVar6];
              iVar10 = iVar10 + -1;
              puVar8 = puVar8 + -1;
            } while (iVar10 != 0);
          }
          pcVar11 = (code *)(*pcVar14)(0,0x57000,0x3000,4);
          if (pcVar11 != (code *)0x0) {
            if ((pcVar11 < &DAT_004374c8) || ((code *)0x48e4c7 < pcVar11)) {
              uVar12 = 0;
              do {
                pcVar11[uVar12] = (pcVar11 + uVar12)[(int)&DAT_004374c8 - (int)pcVar11];
                uVar12 = uVar12 + 1;
              } while (uVar12 < 0x57000);
            }
            else {
              iVar10 = 0x57000;
              pcVar15 = pcVar11 + 0x56fff;
              do {
                *pcVar15 = pcVar15[(int)&DAT_004374c8 - (int)pcVar11];
                iVar10 = iVar10 + -1;
                pcVar15 = pcVar15 + -1;
                pcVar5 = pcVar14;
              } while (iVar10 != 0);
            }
            FUN_00428590(puVar6,0x80);
            if ((pcVar5 < pcVar11) || (pcVar11 + 0x57000 <= pcVar5)) {
              uVar12 = 0;
              do {
                pcVar5[uVar12] = (pcVar5 + uVar12)[(int)pcVar11 - (int)pcVar5];
                uVar12 = uVar12 + 1;
                pcVar14 = pcVar5;
              } while (uVar12 < 0x57000);
            }
            else {
              iVar10 = 0x57000;
              pcVar15 = pcVar5 + 0x56fff;
              do {
                *pcVar15 = pcVar15[(int)pcVar11 - (int)pcVar5];
                iVar10 = iVar10 + -1;
                pcVar15 = pcVar15 + -1;
              } while (iVar10 != 0);
            }
            (*pcVar13)(puVar6,0,0x8000);
            (*pcVar13)(pcVar11,0,0x8000);
            pcVar11 = (code *)more_api_call();
            (*pcVar11)(pcVar14);
            (*pcVar13)(pcVar14,0,0x8000);
            return;
          }
          (*pcVar15)(puVar6,0,0x8000);
          pcVar11 = pcVar15;
        }
        (*pcVar11)(pcVar5,0,0x8000);
        return;
      }
    }
  }
  return;
}

