
undefined4 main(void)

{
  uint8_t uVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  uint8_t *buffer;
  int hash_function;
  code *sleep;
  uint uVar7;
  int unaff_FS_OFFSET;
  short *table_export;
  
  execute_function_at_random();
  execute_function_at_random();
  execute_function_at_random();
  iVar5 = get_system_information(); //probabilmente cerca se si è in una macchina virtuale perché alcune chiamate di sistema si possono fare solo là
  if (iVar5 != 0) {
    execute_function_at_random();
    execute_function_at_random();
    return 0xc0000005;
  }
  execute_function_at_random();
  execute_function_at_random();
  table_export = *(short **)
                  (*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc)
                  + 0x18);
  execute_function_at_random();
  execute_function_at_random();
  if ((((table_export != (short *)0x0) && (*table_export == 0x5a4d)) &&
      (*(int *)(*(int *)(table_export + 0x1e) + (int)table_export) == 0x4550)) &&
     (iVar5 = *(int *)(*(int *)(table_export + 0x1e) + 0x78 + (int)table_export) + (int)table_export
     , iVar5 != 0)) {
    iVar2 = *(int *)(iVar5 + 0x1c);
    uVar7 = 0;
    iVar3 = *(int *)(iVar5 + 0x20);
    iVar4 = *(int *)(iVar5 + 0x24);
    if (*(int *)(iVar5 + 0x18) != 0) {
      do {
        hash_function = 0;
        buffer = (uint8_t *)(*(int *)((int)table_export + uVar7 * 4 + iVar3) + (int)table_export);
        if (buffer != (uint8_t *)0x0) {
          uVar1 = *buffer;
          while (uVar1 != '\0') {
            hash_function = hash_function + 1;
            uVar1 = buffer[hash_function];
          }
        }
        hash_function = hasher(buffer,hash_function);
        if (hash_function == -0x49489fb2) //sleep
        {
          sleep = (code *)(*(int *)((int)table_export +
                                    (uint)*(ushort *)((int)table_export + uVar7 * 2 + iVar4) * 4 +
                                    iVar2) + (int)table_export);
          goto LAB_0042693a;
        }
        uVar7 = uVar7 + 1;
      } while (uVar7 < *(uint *)(iVar5 + 0x18));
    }
  }
LAB_0042693a:
  execute_function_at_random();
  execute_function_at_random();
  (*sleep)(5000);


  iVar5 = other_api_call1(); //non so cosa faccia



  if (iVar5 == 0) {
    execute_function_at_random();
    execute_function_at_random();
    (*sleep)(1000);
    execute_function_at_random();
    if (((table_export != (short *)0x0) && (*table_export == 0x5a4d)) &&
       ((*(int *)(*(int *)(table_export + 0x1e) + (int)table_export) == 0x4550 &&
        (iVar5 = *(int *)(*(int *)(table_export + 0x1e) + 0x78 + (int)table_export) +
                 (int)table_export, iVar5 != 0)))) {
      iVar2 = *(int *)(iVar5 + 0x1c);
      uVar7 = 0;
      iVar3 = *(int *)(iVar5 + 0x20);
      iVar4 = *(int *)(iVar5 + 0x24);
      if (*(int *)(iVar5 + 0x18) != 0) {
        do {
          hash_function = 0;
          buffer = (uint8_t *)(*(int *)((int)table_export + uVar7 * 4 + iVar3) + (int)table_export);
          if (buffer != (uint8_t *)0x0) {
            uVar1 = *buffer;
            while (uVar1 != '\0') {
              hash_function = hash_function + 1;
              uVar1 = buffer[hash_function];
            }
          }
          hash_function = hasher(buffer,hash_function);
          if (hash_function == 0x4ffe230) {
            if (*(int *)((int)table_export +
                        (uint)*(ushort *)((int)table_export + uVar7 * 2 + iVar4) * 4 + iVar2) +
                (int)table_export != 0) {
              return 0xc0000005;
            }
            break;
          }
          uVar7 = uVar7 + 1;
        } while (uVar7 < *(uint *)(iVar5 + 0x18));
      }
    }
    execute_function_at_random();
    execute_function_at_random();
    (*sleep)(1000);
    execute_function_at_random();
    execute_function_at_random();
    other_api_call2();
  }
  return 0xc0000005;
}

