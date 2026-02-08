
/* unpacker_init(_JNIEnv*, _jclass*, _jobject*) */
//
void unpacker_init(_JNIEnv *env, _jclass *target_object, _jobject *context)

{
	undefined8 jpackage_name;
	undefined8 packageManager;
	_jmethodID *p_Var3;

	jpackage_name = utils_get_package_name(env, context);
	packageManager = (**(*env + 0xf8))(env, context);//jclass      (*GetObjectClass)(JNIEnv*, jobject);
	packageManager = (**(*env + 0x108))(env, packageManager, "getPackageManager", "()Landroid/content/pm/PackageManager;");
	//jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
	//con PacketManager puoi prendere informazioni sulle applicazioni del dispositivo
	p_Var3 = (_jmethodID *)_JNIEnv::CallObjectMethod(env, context, packageManager, 0);
	packageManager = (**(*env + 0xf8))(env, p_Var3);
	packageManager = (**(*env + 0x108))(env, packageManager, "getPackageInfo", "(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;");
	jpackage_name = _JNIEnv::CallObjectMethod((_jobject *)env, p_Var3, packageManager, jpackage_name, 0x40);
	packageManager = (**(*env + 0xf8))(env, jpackage_name);
	packageManager = (**(*env + 0x2f0))(env, packageManager, "signatures", "[Landroid/content/pm/Signature;"); // GetStaticFieldID	Locates a static variable (field) within a Java class.
	jpackage_name = (**(*env + 0x2f8))(env, jpackage_name, packageManager);											 // GetStaticObjectField	Retrieves the actual value/object held in a static field.
	p_Var3 = (_jmethodID *)(**(*env + 0x568))(env, jpackage_name, 0);								 // GetStringUTFChars	Converts a Java String object into a C-style char* (UTF-8) so the native code can read it.
	jpackage_name = (**(code **)(*(long *)env + 0xf8))(env, p_Var3);
	jpackage_name = (**(code **)(*(long *)env + 0x108))(env, jpackage_name, "hashCode", &DAT_00173ca0);
	__bss_start = _JNIEnv::CallIntMethod((_jobject *)env, p_Var3, jpackage_name); // ghidra dice che lo mette in __bss_start perchè una variabile vicino a quella label(se fosse così anche per la funzione che fa encoding allora quella non sarebbe random)
	return;
}
