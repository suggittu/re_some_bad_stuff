
void FUN_0014b928(ulong param_1,ulong param_2)

{
  void *pvVar1;
  
  if (0x3ffffffffffffff9 < param_1) {
                    /* WARNING: Subroutine does not return */
    FUN_001499fc("basic_string::_S_create");
  }
  if (param_2 < param_1) {
    if (param_1 < param_2 << 1) {
      param_1 = param_2 << 1;
    }
    if ((0x1000 < param_1 + 0x39) && (param_2 < param_1)) {
      param_1 = (param_1 + 0x1000) - (param_1 + 0x39 & 0xfff);
      if (0x3ffffffffffffff9 < param_1) {
        param_1 = 0x3ffffffffffffff9;
      }
    }
  }
  pvVar1 = operator_new(param_1 + 0x19);
  *(ulong *)((long)pvVar1 + 8) = param_1;
  *(undefined4 *)((long)pvVar1 + 0x10) = 0;
  return;
}

