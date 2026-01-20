
size_t * FUN_0014d510(undefined1 *param_1,undefined1 *param_2)

{
  size_t *psVar1;
  size_t *__dest;
  size_t __n;
  
  if (param_1 == param_2) {
    return (size_t *)&DAT_001ad738;
  }
  if ((param_1 == (undefined1 *)0x0) && (param_2 != (undefined1 *)0x0)) {
                    /* WARNING: Subroutine does not return */
    FUN_001497e0("basic_string::_S_construct null not valid");
  }
  __n = (long)param_2 - (long)param_1;
  psVar1 = (size_t *)FUN_0014b928(__n,0);
  __dest = psVar1 + 3;
  if (__n == 1) {
    *(undefined1 *)(psVar1 + 3) = *param_1;
  }
  else {
    __dest = memcpy(__dest,param_1,__n);
  }
  if (psVar1 != &DAT_001ad720) {
    *(undefined4 *)(psVar1 + 2) = 0;
    *psVar1 = __n;
    *(undefined1 *)((long)psVar1 + __n + 0x18) = 0;
  }
  return __dest;
}

