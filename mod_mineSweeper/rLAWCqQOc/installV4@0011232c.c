
/* installV4(_JNIEnv*, _jclass*, _jobject*, _jobjectArray*) */

void installV4(_JNIEnv *param_1,_jclass *param_2,_jobject *param_3,_jobjectArray *param_4)

{
  int iVar1;
  int iVar2;
  char *pcVar3;
  char *pcVar4;
  undefined8 uVar5;
  _jobject *p_Var6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  undefined8 uVar10;
  _jobjectArray *p_Var11;
  _jobjectArray *p_Var12;
  _jobjectArray *p_Var13;
  _jobjectArray *p_Var14;
  _jobject *p_Var15;
  _jobject *p_Var16;
  _jobject *p_Var17;
  char *pcVar18;
  int iVar19;
  
  if (param_3 != (_jobject *)0x0) {
    if (param_4 != (_jobjectArray *)0x0) {
      iVar2 = (**(code **)(*(long *)param_1 + 0x558))(param_1,param_4);
      pcVar3 = (char *)replaceStringForInt(0x1d);
      pcVar4 = (char *)replaceStringForInt(0x1e);
      uVar5 = findFieldByInstance(param_1,param_3,pcVar3,pcVar4);
      p_Var6 = (_jobject *)(**(code **)(*(long *)param_1 + 0x2f8))(param_1,param_3,uVar5);
      p_Var6 = (_jobject *)create_string_builder(param_1,p_Var6);
      uVar7 = replaceStringForInt(3);
      uVar7 = (**(code **)(*(long *)param_1 + 0x30))(param_1,uVar7);
      uVar8 = replaceStringForInt((uint)(param_4 == (_jobjectArray *)0x0));
      uVar8 = (**(code **)(*(long *)param_1 + 0x30))(param_1,uVar8);
      uVar9 = replaceStringForInt(4);
      uVar9 = (**(code **)(*(long *)param_1 + 0x30))(param_1,uVar9);
      uVar10 = replaceStringForInt(5);
      uVar10 = (**(code **)(*(long *)param_1 + 0x30))(param_1,uVar10);
      p_Var11 = (_jobjectArray *)(**(code **)(*(long *)param_1 + 0x560))(param_1,iVar2,uVar7,0);
      p_Var12 = (_jobjectArray *)(**(code **)(*(long *)param_1 + 0x560))(param_1,iVar2,uVar8,0);
      p_Var13 = (_jobjectArray *)(**(code **)(*(long *)param_1 + 0x560))(param_1,iVar2,uVar9,0);
      p_Var14 = (_jobjectArray *)(**(code **)(*(long *)param_1 + 0x560))(param_1,iVar2,uVar10,0);
      uVar7 = replaceStringForInt(0x1f);
      uVar9 = replaceStringForInt(0x20);
      uVar7 = (**(code **)(*(long *)param_1 + 0x108))(param_1,uVar8,uVar7,uVar9);
      iVar19 = 0;
      if (0 < iVar2) {
        do {
          p_Var15 = (_jobject *)(**(code **)(*(long *)param_1 + 0x568))(param_1,param_4,iVar19);
          p_Var16 = (_jobject *)
                    _JNIEnv::CallObjectMethod((_jobject *)param_1,(_jmethodID *)p_Var15,uVar7);
          string_builder_append_char(param_1,p_Var6,':');
          string_builder_append_string(param_1,p_Var6,p_Var16);
          (**(code **)(*(long *)param_1 + 0x570))(param_1,p_Var11,iVar19,p_Var16);
          (**(code **)(*(long *)param_1 + 0x570))(param_1,p_Var12,iVar19,p_Var15);
          uVar8 = create_zip_file(param_1,p_Var15);
          (**(code **)(*(long *)param_1 + 0x570))(param_1,p_Var13,iVar19,uVar8);
          (**(code **)(*(long *)param_1 + 0xb8))(param_1,uVar8);
          p_Var15 = (_jobject *)create_string_builder(param_1,p_Var16);
          string_builder_append_char(param_1,p_Var15,'.');
          string_builder_append_char(param_1,p_Var15,'d');
          string_builder_append_char(param_1,p_Var15,'e');
          string_builder_append_char(param_1,p_Var15,'x');
          p_Var17 = (_jobject *)string_builder_to_string(param_1,p_Var15);
          (**(code **)(*(long *)param_1 + 0xb8))(param_1,p_Var15);
          uVar8 = load_dex(param_1,p_Var16,p_Var17,0);
          iVar1 = iVar19 + 1;
          (**(code **)(*(long *)param_1 + 0x570))(param_1,p_Var14,iVar19,uVar8);
          (**(code **)(*(long *)param_1 + 0xb8))(param_1,uVar8);
          iVar19 = iVar1;
        } while (iVar1 != iVar2);
      }
      uVar7 = string_builder_to_string(param_1,p_Var6);
      (**(code **)(*(long *)param_1 + 0x340))(param_1,param_3,uVar5,uVar7);
      pcVar3 = (char *)replaceStringForInt(0x21);
      pcVar4 = (char *)replaceStringForInt(0x22);
      pcVar18 = (char *)replaceStringForInt(3);
      expand_field_array(param_1,param_3,pcVar3,pcVar4,pcVar18,p_Var11);
      pcVar3 = (char *)replaceStringForInt(0x23);
      pcVar4 = (char *)replaceStringForInt(0x24);
      pcVar18 = (char *)replaceStringForInt(0);
      expand_field_array(param_1,param_3,pcVar3,pcVar4,pcVar18,p_Var12);
      pcVar3 = (char *)replaceStringForInt(0x25);
      pcVar4 = (char *)replaceStringForInt(0x26);
      pcVar18 = (char *)replaceStringForInt(4);
      expand_field_array(param_1,param_3,pcVar3,pcVar4,pcVar18,p_Var13);
      pcVar3 = (char *)replaceStringForInt(0x27);
      pcVar4 = (char *)replaceStringForInt(0x28);
      pcVar18 = (char *)replaceStringForInt(5);
      expand_field_array(param_1,param_3,pcVar3,pcVar4,pcVar18,p_Var14);
      (**(code **)(*(long *)param_1 + 0xb8))(param_1,p_Var13);
      (**(code **)(*(long *)param_1 + 0xb8))(param_1,p_Var12);
      (**(code **)(*(long *)param_1 + 0xb8))(param_1,p_Var11);
      (**(code **)(*(long *)param_1 + 0xb8))(param_1,p_Var6);
      return;
    }
  }
  utils_throw_by_name(param_1,"java/lang/NullPointerException","Null params.");
  return;
}

