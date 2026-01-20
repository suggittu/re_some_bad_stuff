
void FUN_001497e0(undefined8 param_1)

{
  undefined8 uVar1;
  undefined1 auStack_18 [8];
  undefined1 auStack_10 [8];
  long local_8;
  
  uVar1 = __cxa_allocate_exception(0x10);
                    /* try { // try from 0014980c to 0014980f has its CatchHandler @ 00149858 */
  FUN_0014d980(&local_8,param_1,auStack_18);
                    /* try { // try from 00149818 to 0014981b has its CatchHandler @ 0014986c */
  FUN_00157964(uVar1,&local_8);
  if ((undefined8 *)(local_8 + -0x18) != &DAT_001ad720) {
    FUN_001496ec((undefined8 *)(local_8 + -0x18),auStack_10);
  }
                    /* WARNING: Subroutine does not return */
  __cxa_throw(uVar1,&PTR_PTR_001aad48,FUN_0015767c);
}

