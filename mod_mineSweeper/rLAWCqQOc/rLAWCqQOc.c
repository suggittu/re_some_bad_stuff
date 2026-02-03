
void Java_ru_anna_chinagame_TJEjihIIS_rLAWCqQOc(_JNIEnv *env, _jclass *target_object, _jobject *context)

{
    char cVar1;
    int iVar2;
    undefined8 address_method;
    undefined8 stringa1;
    undefined8 stringa2;
    _jobject *ClassLoader;
    _jobject *path_outdex;
    _jstring *package_name;
    char *package_name;
    char *pcVar10;
    _jobject *p_Var11;
    _jmethodID *p_Var12;
    _jobjectArray *p_Var13;

    if (context == (_jobject *)0x0)
    {
        utils_throw_by_name(env, "java/lang/NullPointerException", "Context is null.");
        return;
    }
    checkSignature(env, target_object, context); //controla integrità dell apk (se è stato cambiato qualcosa termina)
    iVar2 = utils_get_sdk_version(env);
    class_of_context = (**(*env + 0xf8))(env, context);//GetStaticMethodID	Locates a static method in a Java class so it can be called later
    stringa1 = replaceStringForInt(1);//getClassLoader (il nome del metodo)
    stringa2 = replaceStringForInt(2);//()Ljava/lang/ClassLoader;(a method that takes no arguments and returns a ClassLoader object, in pratica è il tipo della funzione)
    getClassLoader = (**(*env + 0x108))(env, class_of_context, stringa1, stringa2);

    //*env: This dereferences the JNI environment pointer to access the function table.
    //0x108 Offset: In the standard JNIEnv table for Android/ARM, the offset 0x108 
    // usually corresponds to the getClassLoader function
    //classLoader carica il codice della applicazione
    ClassLoader = _JNIEnv::CallObjectMethod(env, context, getClassLoader, 0);
    path_outdex = utils_context_get_dir(env, context, "outdex", 0); //crea una directory dove solo l'app può leggere
    package_name_java = utils_get_package_name(env, context); //ritona il nome del pacchetto come una stringa java
    package_name = utils_java_string_to_c_string(env, package_name_java);
    pcVar10 = replaceStringForInt(0x1c); // Ljava/lang/String;
    package_name_formatted = make_name(package_name, pcVar10);//diventa così tipo chinagameLjava/lang/String;

    p_Var11 = get_extra_path_entities(env, context, package_name_formatted); //trova i file encodati dentro l'applicazione
    io_File_path = replaceStringForInt(0); //java/io/File (classe per interaggire con i file e directory)
    io_File = (**(code **)(*(long *)env + 0x30))(env, io_File_path); //FindClass
    
    stringa1 = replaceStringForInt(0x29);
    stringa2 = replaceStringForInt(0x2a);
    p_Var12 = (**(*env + 0x108))(env, io_File, stringa1, stringa2);
    cVar1 = call_exist_method(env, p_Var11, p_Var12);
    if (cVar1 == '\0')
    {
        prepare_entity(env, context, p_Var11);
    }
    p_Var13 = (_jobjectArray *)(**(code **)(*(long *)env + 0x560))(env, 1, io_File, p_Var11);
    if (0x16 < iVar2)
    {
        installV23(env, target_object, ClassLoader, p_Var13, path_outdex);
        return;
    }
    if (0x12 < iVar2)
    {
        installV19(env, target_object, ClassLoader, p_Var13, path_outdex);
        return;
    }
    if (iVar2 < 0xe)
    {
        if (iVar2 < 9)
        {
            return;
        }
        installV4(env, target_object, ClassLoader, p_Var13);
        return;
    }
    installV14(env, target_object, ClassLoader, p_Var13, path_outdex);
    return;
}
