
/* prepare_entity(_JNIEnv*, _jobject*, _jobject*) */

void prepare_entity(_JNIEnv *param_1,_jobject *param_2,_jobject *param_3)

{
  _jstring *p_Var1;
  char *pcVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  char *pcVar6;
  char *pcVar7;
  
  p_Var1 = (_jstring *)utils_get_package_name(param_1,param_2);
  pcVar2 = (char *)utils_java_string_to_c_string(param_1,p_Var1);
  uVar3 = replaceStringForInt(0);
  uVar3 = (**(code **)(*(long *)param_1 + 0x30))(param_1,uVar3);
  uVar4 = replaceStringForInt(0x1f);
  uVar5 = replaceStringForInt(0x20);
  uVar3 = (**(code **)(*(long *)param_1 + 0x108))(param_1,uVar3,uVar4,uVar5);
  p_Var1 = (_jstring *)_JNIEnv::CallObjectMethod((_jobject *)param_1,(_jmethodID *)param_3,uVar3);
  pcVar6 = (char *)utils_java_string_to_c_string(param_1,p_Var1);
  pcVar7 = (char *)make_name(pcVar2,".dat");
  utils_copy_from_assets(param_1,param_2,pcVar7,pcVar6);
  if (pcVar2 != (char *)0x0) {
    operator_delete__(pcVar2);
  }
  if (pcVar7 != (char *)0x0) {
    operator_delete__(pcVar7);
  }
  if (pcVar6 != (char *)0x0) {
    operator_delete__(pcVar6);
    return;
  }
  return;
}

