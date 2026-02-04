
/* prepare_entity(_JNIEnv*, _jobject*, _jobject*) */

void prepare_entity(_JNIEnv *env, _jobject *context, _jobject *file_chinagameLjava/lang/String)

{
    _jstring *package_name_java;
    char *package_name;
    undefined8 string_io_File;
    undefined8 string_type;
    undefined8 mFiles_string;
    char *package_name;
    char *package_name_dat;

    package_name_java = (_jstring *)utils_get_package_name_java(env, context);
    package_name = (char *)utils_java_string_to_c_string(env, package_name_java);
    string_io_File = replaceStringForInt(0); // java/io/File
    io_File = (**(code **)(*(long *)env + 0x30))(env, string_io_File); //trova sempre la classe
    string_type = replaceStringForInt(0x1f); //[Ljava/lang/String;
    mFiles_string = replaceStringForInt(0x20); //mFiles (la cosa strana mFiles non esiste nella classe originaria)
    //quindi la classe java/io/File deve essere non quella originaria
    mFiles = (**(code **)(*(long *)env + 0x108))(env, io_File, string_type, mFiles_string);

    qualcosa_sospetto = (_jstring *)_JNIEnv::CallObjectMethod((_jobject *)env, (_jmethodID *)file_chinagameLjava/lang/String, mFiles); 
    //quindi chiama questo metodo sul file creato ancora non ci dovrebbe essere nulla dentro
    package_name = (char *)utils_java_string_to_c_string(env, qualcosa_sospetto);
    package_name_dat = (char *)make_name(package_name, ".dat"); //che è un file dentro assets (mod.dat)

    utils_copy_from_assets(env, context, package_name_dat, package_name); //logica dell unpacker (quindi il codice malevolo era dentro tipo packageName.dat o mod.dat)
    // e viene messo dentro package_name

    if (package_name != (char *)0x0)
    {
        operator_delete__(package_name);
    }
    if (package_name_dat != (char *)0x0)
    {
        operator_delete__(package_name_dat);
    }
    if (package_name != (char *)0x0)
    {
        operator_delete__(package_name);
        return;
    }
    return;
}
