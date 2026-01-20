
void Java_ru_anna_chinagame_TJEjihIIS_rLAWCqQOc(_JNIEnv *env, _jclass *target_object, _jobject *method_id)

{
    char cVar1;
    int iVar2;
    undefined8 address_method;
    undefined8 stringa1;
    undefined8 stringa2;
    _jobject *p_Var6;
    _jobject *p_Var7;
    _jstring *p_Var8;
    char *pcVar9;
    char *pcVar10;
    _jobject *p_Var11;
    _jmethodID *p_Var12;
    _jobjectArray *p_Var13;

    if (method_id == (_jobject *)0x0)
    {
        utils_throw_by_name(env, "java/lang/NullPointerException", "Context is null.");
        return;
    }
    unpacker_init(env, target_object, method_id); //controla integrità dell apk
    iVar2 = utils_get_sdk_version(env);
    address_method = (**(*env + 0xf8))(env, method_id);//GetStaticMethodID	Locates a static method in a Java class so it can be called later
    stringa1 = replaceStringForInt(1);//l'indirizzo di alcune stringhe questa dovrebbe essere j%/io/Fil
    stringa2 = replaceStringForInt(2);//g'(lassLoader//fanno altre manipolazione oltre a base64 però è forse comprensibile
    address_method = (**(*env + 0x108))(env, address_method, stringa1, stringa2);
    p_Var6 = _JNIEnv::CallObjectMethod(env, method_id, address_method, 0);
    p_Var7 = utils_context_get_dir(env, method_id, "outdex", 0);
    p_Var8 = utils_get_package_name(env, method_id);
    pcVar9 = utils_java_string_to_c_string(env, p_Var8);
    pcVar10 = replaceStringForInt(0x1c);
    pcVar9 = make_name(pcVar9, pcVar10);
    p_Var11 = get_extra_path_entities(env, method_id, pcVar9);
    address_method = replaceStringForInt(0);
    address_method = (**(code **)(*(long *)env + 0x30))(env, address_method);
    stringa1 = replaceStringForInt(0x29);
    stringa2 = replaceStringForInt(0x2a);
    p_Var12 = (**(*env + 0x108))(env, address_method, stringa1, stringa2);
    cVar1 = call_exist_method(env, p_Var11, p_Var12);
    if (cVar1 == '\0')
    {
        prepare_entity(env, method_id, p_Var11);
    }
    p_Var13 = (_jobjectArray *)(**(code **)(*(long *)env + 0x560))(env, 1, address_method, p_Var11);
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
