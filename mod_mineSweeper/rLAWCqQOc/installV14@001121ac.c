
/* installV14(_JNIEnv*, _jclass*, _jobject*, _jobjectArray*, _jobject*) */

void installV14(_JNIEnv *param_1,_jclass *param_2,_jobject *param_3,_jobjectArray *param_4,
               _jobject *param_5)

{
  char *pcVar1;
  char *pcVar2;
  undefined8 uVar3;
  _jobject *p_Var4;
  _jmethodID *p_Var5;
  undefined8 uVar6;
  _jobjectArray *p_Var7;
  char *pcVar8;
  
  if ((param_4 != (_jobjectArray *)0x0 && param_5 != (_jobject *)0x0) &&
     (param_3 != (_jobject *)0x0)) {
    pcVar1 = (char *)replaceStringForInt(0x17);
    pcVar2 = (char *)replaceStringForInt(0x18);
    uVar3 = findFieldByInstance(param_1,param_3,pcVar1,pcVar2);
    p_Var4 = (_jobject *)(**(code **)(*(long *)param_1 + 0x2f8))(param_1,param_3,uVar3);
    p_Var5 = (_jmethodID *)(**(code **)(*(long *)param_1 + 0xf8))(param_1,p_Var4);
    uVar3 = replaceStringForInt(6);
    uVar6 = replaceStringForInt(7);
    uVar3 = (**(code **)(*(long *)param_1 + 0x388))(param_1,p_Var5,uVar3,uVar6);
    uVar6 = create_array_list(param_1,param_4);
    p_Var7 = (_jobjectArray *)
             _JNIEnv::CallStaticObjectMethod((_jclass *)param_1,p_Var5,uVar3,uVar6,param_5);
    pcVar1 = (char *)replaceStringForInt(0x19);
    pcVar2 = (char *)replaceStringForInt(0x1a);
    pcVar8 = (char *)replaceStringForInt(0x1b);
    expand_field_array(param_1,p_Var4,pcVar1,pcVar2,pcVar8,p_Var7);
    (**(code **)(*(long *)param_1 + 0xb8))(param_1,uVar6);
    return;
  }
  utils_throw_by_name(param_1,"java/lang/NullPointerException","Null params.");
  return;
}

