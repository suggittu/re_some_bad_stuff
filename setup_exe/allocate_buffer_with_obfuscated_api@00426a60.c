
undefined4 allocate_buffer_with_obfuscated_api(undefined4 *param_1,undefined4 *param_2)

{
  uint8_t uVar1;
  short *psVar2;
  int iVar3;
  int iVar4;
  code *pcVar5;
  undefined1 *puVar6;
  uint in_ECX;
  uint8_t *buf;
  uint in_EDX;
  int iVar7;
  int iVar8;
  int iVar9;
  uint uVar10;
  int unaff_FS_OFFSET;
  int *local_8;
  
  *param_2 = 0;
  *param_1 = 0;
  if ((uint)(0xffffffff / (ulonglong)in_EDX) < in_ECX) {
    return 0x216;
  }
  iVar9 = in_ECX * in_EDX;
  psVar2 = *(short **)
            (*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) +
            0x18);
  if ((((psVar2 != (short *)0x0) && (*psVar2 == 0x5a4d)) &&
      (*(int *)(*(int *)(psVar2 + 0x1e) + (int)psVar2) == 0x4550)) &&
     (iVar8 = *(int *)(*(int *)(psVar2 + 0x1e) + 0x78 + (int)psVar2) + (int)psVar2, iVar8 != 0)) {
    iVar3 = *(int *)(iVar8 + 0x1c);
    uVar10 = 0;
    iVar4 = *(int *)(iVar8 + 0x20);
    local_8 = (int *)(*(int *)(iVar8 + 0x24) + (int)psVar2);
    if (*(int *)(iVar8 + 0x18) != 0) {
      do {
        iVar7 = 0;
        buf = (uint8_t *)(*(int *)((int)psVar2 + uVar10 * 4 + iVar4) + (int)psVar2);
        if (buf != (uint8_t *)0x0) {
          uVar1 = *buf;
          while (uVar1 != '\0') {
            iVar7 = iVar7 + 1;
            uVar1 = buf[iVar7];
          }
        }
        iVar7 = hasher(buf,iVar7);
        if (iVar7 == 0x7fdb33b8) {
          pcVar5 = (code *)(*(int *)((int)psVar2 +
                                    (uint)*(ushort *)((int)local_8 + uVar10 * 2) * 4 + iVar3) +
                           (int)psVar2);
          goto LAB_00426b3b;
        }
        uVar10 = uVar10 + 1;
      } while (uVar10 < *(uint *)(iVar8 + 0x18));
    }
  }
  pcVar5 = (code *)0x0;
LAB_00426b3b:
  puVar6 = (undefined1 *)(*pcVar5)(0,iVar9,0x3000,4);
  if (puVar6 == (undefined1 *)0x0) {
    return 8;
  }
  *param_1 = puVar6;
  for (iVar8 = iVar9; iVar8 != 0; iVar8 = iVar8 + -1) {
    *puVar6 = 0;
    puVar6 = puVar6 + 1;
  }
  *local_8 = iVar9;
  return 0;
}

