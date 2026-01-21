
bool other_api_call(void)

{
  uint8_t *puVar4;
  int iVar5;
  uint uVar6;
  int iVar7;
  code *address_api_1;
  uint uVar8;
  code *address_api_2;
  int unaff_FS_OFFSET;
  int local_1c;
  int local_18;
  int local_14;
  undefined1 local_8 [8];
  short *base_address;
  int iVar2;
  int iVar3;
  uint8_t uVar1;
  
  base_address = *(short **)
                  (*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc)
                  + 0x18);
  if (base_address != (short *)0x0) {
    if (((*base_address == 0x5a4d) &&
        (*(int *)(*(int *)(base_address + 0x1e) + (int)base_address) == 0x4550)) &&
       (iVar7 = *(int *)(*(int *)(base_address + 0x1e) + 0x78 + (int)base_address) +
                (int)base_address, iVar7 != 0)) {
      uVar8 = 0;
      iVar2 = *(int *)(iVar7 + 0x20);
      local_18 = *(int *)(iVar7 + 0x1c) + (int)base_address;
      local_1c = *(int *)(iVar7 + 0x24) + (int)base_address;
      if (*(int *)(iVar7 + 0x18) != 0) {
        do {
          iVar5 = 0;
          puVar4 = (uint8_t *)(*(int *)((int)base_address + uVar8 * 4 + iVar2) + (int)base_address);
          if (puVar4 != (uint8_t *)0x0) {
            uVar1 = *puVar4;
            while (uVar1 != '\0') {
              iVar5 = iVar5 + 1;
              uVar1 = puVar4[iVar5];
            }
          }
          iVar5 = hasher(puVar4,iVar5);
          if (iVar5 == 0x4fca2456) {
            address_api_1 =
                 (code *)(*(int *)(local_18 + (uint)*(ushort *)(local_1c + uVar8 * 2) * 4) +
                         (int)base_address);
            goto LAB_00429e71;
          }
          uVar8 = uVar8 + 1;
        } while (uVar8 < *(uint *)(iVar7 + 0x18));
      }
    }
    address_api_1 = (code *)0x0;
LAB_00429e71:
    if (((*base_address == 0x5a4d) &&
        (*(int *)(*(int *)(base_address + 0x1e) + (int)base_address) == 0x4550)) &&
       (iVar7 = *(int *)(*(int *)(base_address + 0x1e) + 0x78 + (int)base_address) +
                (int)base_address, iVar7 != 0)) {
      uVar8 = 0;
      local_14 = *(int *)(iVar7 + 0x1c) + (int)base_address;
      local_1c = *(int *)(iVar7 + 0x20) + (int)base_address;
      iVar2 = *(int *)(iVar7 + 0x24);
      if (*(int *)(iVar7 + 0x18) != 0) {
        do {
          iVar5 = 0;
          local_18 = 0;
          puVar4 = (uint8_t *)(*(int *)(local_1c + uVar8 * 4) + (int)base_address);
          if (puVar4 != (uint8_t *)0x0) {
            uVar1 = *puVar4;
            iVar3 = iVar5;
            while (iVar5 = iVar3, uVar1 != '\0') {
              iVar3 = iVar5 + 1;
              local_18 = iVar5;
              uVar1 = puVar4[iVar5 + 1];
            }
          }
          iVar5 = hasher(puVar4,iVar5);
          if (iVar5 == -0x49489fb2) {
            address_api_2 =
                 (code *)(*(int *)(local_14 +
                                  (uint)*(ushort *)((int)base_address + uVar8 * 2 + iVar2) * 4) +
                         (int)base_address);
            goto LAB_00429f03;
          }
          uVar8 = uVar8 + 1;
        } while (uVar8 < *(uint *)(iVar7 + 0x18));
      }
    }
    address_api_2 = (code *)0x0;
LAB_00429f03:
    if ((address_api_1 != (code *)0x0) && (address_api_2 != (code *)0x0)) {
      (*address_api_1)(local_8);
      (*address_api_2)(1000);
      (*address_api_1)(&local_18);
      uVar6 = (uint)(local_1c - local_14) / 10000;
      uVar8 = uVar6 - 1000;
      if (uVar6 < 0x3e9) {
        uVar8 = 1000 - uVar6;
      }
      return 0x32 < uVar8;
    }
  }
  return false;
}

