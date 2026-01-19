
void Java_ru_anna_chinagame_TJEjihIIS_rLAWCqQOc(_JNIEnv *env, _jclass *target_object, _jobject *object_passed)

{
    char cVar1;
    int iVar2;
    undefined8 uVar3;
    undefined8 uVar4;
    undefined8 uVar5;
    _jobject *p_Var6;
    _jobject *p_Var7;
    _jstring *p_Var8;
    char *pcVar9;
    char *pcVar10;
    _jobject *p_Var11;
    _jmethodID *p_Var12;
    _jobjectArray *p_Var13;

    if (object_passed == (_jobject *)0x0)
    {
        utils_throw_by_name(env, "java/lang/NullPointerException", "Context is null.");
        return;
    }
    unpacker_init(env, target_object, object_passed);
    iVar2 = utils_get_sdk_version(env);
    uVar3 = (**(code **)(*(long *)env + 0xf8))(env, object_passed);
    uVar4 = replaceStringForInt(1);
    uVar5 = replaceStringForInt(2);
    uVar3 = (**(code **)(*(long *)env + 0x108))(env, uVar3, uVar4, uVar5);
    p_Var6 = (_jobject *)_JNIEnv::CallObjectMethod((_jobject *)env, (_jmethodID *)object_passed, uVar3, 0);
    p_Var7 = (_jobject *)utils_context_get_dir(env, object_passed, "outdex", 0);
    p_Var8 = (_jstring *)utils_get_package_name(env, object_passed);
    pcVar9 = (char *)utils_java_string_to_c_string(env, p_Var8);
    pcVar10 = (char *)replaceStringForInt(0x1c);
    pcVar9 = (char *)make_name(pcVar9, pcVar10);
    p_Var11 = (_jobject *)get_extra_path_entities(env, object_passed, pcVar9);
    uVar3 = replaceStringForInt(0);
    uVar3 = (**(code **)(*(long *)env + 0x30))(env, uVar3);
    uVar4 = replaceStringForInt(0x29);
    uVar5 = replaceStringForInt(0x2a);
    p_Var12 = (_jmethodID *)(**(code **)(*(long *)env + 0x108))(env, uVar3, uVar4, uVar5);
    cVar1 = call_exist_method(env, p_Var11, p_Var12);
    if (cVar1 == '\0')
    {
        prepare_entity(env, object_passed, p_Var11);
    }
    p_Var13 = (_jobjectArray *)(**(code **)(*(long *)env + 0x560))(env, 1, uVar3, p_Var11);
    if (0x16 < iVar2)
    {
        installV23(env, target_object, p_Var6, p_Var13, p_Var7);
        return;
    }
    if (0x12 < iVar2)
    {
        installV19(env, target_object, p_Var6, p_Var13, p_Var7);
        return;
    }
    if (iVar2 < 0xe)
    {
        if (iVar2 < 9)
        {
            return;
        }
        installV4(env, target_object, p_Var6, p_Var13);
        return;
    }
    installV14(env, target_object, p_Var6, p_Var13, p_Var7);
    return;
}
