
void FUN_001499fc(undefined8 param_1)

{
  undefined8 uVar1;
  undefined1 auStack_18 [8];
  undefined1 auStack_10 [8];
  long local_8;
  
  uVar1 = __cxa_allocate_exception(0x10);
                    /* try { // try from 00149a28 to 00149a2b has its CatchHandler @ 00149a74 */
  FUN_0014d980(&local_8,param_1,auStack_18);
                    /* try { // try from 00149a34 to 00149a37 has its CatchHandler @ 00149a88 */
  FUN_001579fc(uVar1,&local_8);
  if ((undefined8 *)(local_8 + -0x18) != &DAT_001ad720) {
    FUN_001496ec((undefined8 *)(local_8 + -0x18),auStack_10);
  }
                    /* WARNING: Subroutine does not return */
  __cxa_throw(uVar1,&PTR_PTR_001aad90,FUN_0015776c);
}

