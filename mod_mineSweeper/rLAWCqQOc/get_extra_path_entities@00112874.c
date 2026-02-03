
/* get_extra_path_entities(_JNIEnv*, _jobject*, char const*) */

undefined8 get_extra_path_entities(_JNIEnv *env,_jobject *context,char *package_name_formatted)

{
  _jobject *p_Var1;
  _jobject *p_Var2;
  undefined8 uVar3;
  
  p_Var1 = (_jobject *)utils_context_get_dir(env,context,"app_apk",0);
  p_Var2 = (_jobject *)(**(code **)(*(long *)env + 0x538))(env,package_name_formatted);
  uVar3 = create_file(env,p_Var1,p_Var2);
  (**(code **)(*(long *)env + 0xb8))(env,p_Var2);
  return uVar3;
}

