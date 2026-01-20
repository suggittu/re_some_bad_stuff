
/* get_extra_path_entities(_JNIEnv*, _jobject*, char const*) */

undefined8 get_extra_path_entities(_JNIEnv *param_1,_jobject *param_2,char *param_3)

{
  _jobject *p_Var1;
  _jobject *p_Var2;
  undefined8 uVar3;
  
  p_Var1 = (_jobject *)utils_context_get_dir(param_1,param_2,"app_apk",0);
  p_Var2 = (_jobject *)(**(code **)(*(long *)param_1 + 0x538))(param_1,param_3);
  uVar3 = create_file(param_1,p_Var1,p_Var2);
  (**(code **)(*(long *)param_1 + 0xb8))(param_1,p_Var2);
  return uVar3;
}

