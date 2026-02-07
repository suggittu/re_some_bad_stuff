

void call_exist_method(_JNIEnv *env,_jobject *param_2,_jmethodID *param_3) 
//0x130 (CallBooleanMethod): This is the JNI 
//function that actually executes a Java method that returns a true or false.

{
  long lVar1;
  
  lVar1 = ___stack_chk_guard;
  (**(code **)(*(long *)env + 0x130))();
  if (lVar1 == ___stack_chk_guard) {
    return;
  }
  
  __stack_chk_fail();
}

