
size_t * FUN_0014c7c0(size_t *param_1,undefined8 param_2,long param_3)

{
  size_t *psVar1;
  size_t *__dest;
  size_t __n;
  size_t sVar2;
  
  psVar1 = (size_t *)FUN_0014b928(param_3 + *param_1,param_1[1],param_2);
  __n = *param_1;
  __dest = psVar1 + 3;
  sVar2 = 0;
  if (__n != 0) {
    __dest = psVar1 + 3;
    if (__n == 1) {
      *(char *)(psVar1 + 3) = (char)param_1[3];
      sVar2 = *param_1;
    }
    else {
      __dest = memcpy(__dest,param_1 + 3,__n);
      sVar2 = *param_1;
    }
  }
  if (psVar1 != &DAT_001ad720) {
    *(undefined4 *)(psVar1 + 2) = 0;
    *psVar1 = sVar2;
    *(undefined1 *)((long)psVar1 + sVar2 + 0x18) = 0;
    return __dest;
  }
  return __dest;
}

