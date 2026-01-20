
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */
/* call_exist_method(_JNIEnv*, _jobject*, _jmethodID*) */

void call_exist_method(_JNIEnv *param_1,_jobject *param_2,_jmethodID *param_3)

{
  long lVar1;
  
  lVar1 = ___stack_chk_guard;
  (**(code **)(*(long *)param_1 + 0x130))();
  if (lVar1 == ___stack_chk_guard) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}

