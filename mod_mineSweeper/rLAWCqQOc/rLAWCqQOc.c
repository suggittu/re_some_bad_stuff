
void Java_ru_anna_chinagame_TJEjihIIS_rLAWCqQOc(_JNIEnv *env, _jclass *target_object, _jobject *context)

{
    char cVar1;
    int api_version;
    undefined8 address_method;
    undefined8 stringa1;
    undefined8 stringa2;
    _jobject *ClassLoader;
    _jobject *path_outdex;
    _jstring *package_name;
    char *package_name;
    char *pcVar10;
    _jobject *file_chinagameLjava/lang/String;
    _jmethodID *exists_method;
    _jobjectArray *p_Var13;

    if (context == (_jobject *)0x0)
    {
        utils_throw_by_name(env, "java/lang/NullPointerException", "Context is null.");
        return;
    }
    checkSignature(env, target_object, context); //controla integrità dell apk (se è stato cambiato qualcosa termina)
    api_version = utils_get_sdk_version(env);
    class_of_context = (**(*env + 0xf8))(env, context);//GetStaticMethodID	Locates a static method in a Java class so it can be called later
    stringa1 = replaceStringForInt(1);//getClassLoader (il nome del metodo)
    stringa2 = replaceStringForInt(2);//()Ljava/lang/ClassLoader;(a method that takes no arguments and returns a ClassLoader object, in pratica è il tipo della funzione)
    getClassLoader = (**(*env + 0x108))(env, class_of_context, stringa1, stringa2); //all off set 0x108 c'è probabilmente getObject (trova metodo dentro classe)

    //*env: This dereferences the JNI environment pointer to access the function table.

    ClassLoader = _JNIEnv::CallObjectMethod(env, context, getClassLoader, 0);
    path_outdex = utils_context_get_dir(env, context, "outdex", 0); //crea una directory dove solo l'app può leggere
    package_name_java = utils_get_package_name(env, context); //ritona il nome del pacchetto come una stringa java
    package_name = utils_java_string_to_c_string(env, package_name_java);
    pcVar10 = replaceStringForInt(0x1c); // Ljava/lang/String;
    package_name_formatted = make_name(package_name, pcVar10);//diventa così tipo chinagameLjava/lang/String;

    file_chinagameLjava/lang/String = get_extra_path_entities(env, context, package_name_formatted); 
    io_File_path = replaceStringForInt(0); //java/io/File (classe per interaggire con i file e directory)
    io_File = (**(code **)(*(long *)env + 0x30))(env, io_File_path); //FindClass

    stringa1 = replaceStringForInt(0x29); //forse "exists" (presupposizioni perchè queste due stringhe non le ho trovate nel binario)
    stringa2 = replaceStringForInt(0x2a); //forse "()Z" (vuol dire booleano)
    exists_method = (**(*env + 0x108))(env, io_File, stringa1, stringa2); //exist è una funzione dentro classe java.io.File 
    cVar1 = call_exist_method(env, file_chinagameLjava/lang/String, exists_method);
    if (cVar1 == '\0')
    {
        prepare_entity(env, context, file_chinagameLjava/lang/String);
    }
    p_Var13 = (_jobjectArray *)(**(code **)(*(long *)env + 0x560))(env, 1, io_File, file_chinagameLjava/lang/String);
    if (0x16 < api_version)
    {
        installV23(env, target_object, ClassLoader, p_Var13, path_outdex);
        return;
    }
    if (0x12 < api_version)
    {
        installV19(env, target_object, ClassLoader, p_Var13, path_outdex);
        return;
    }
    if (api_version < 0xe)
    {
        if (api_version < 9)
        {
            return;
        }
        installV4(env, target_object, ClassLoader, p_Var13);
        return;
    }
    installV14(env, target_object, ClassLoader, p_Var13, path_outdex);
    return;
}
