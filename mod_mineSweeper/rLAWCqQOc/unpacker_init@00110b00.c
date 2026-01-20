
/* unpacker_init(_JNIEnv*, _jclass*, _jobject*) */
//
void unpacker_init(_JNIEnv *env, _jclass *param_2, _jobject *method_id)

{
	undefined8 uVar1;
	undefined8 uVar2;
	_jmethodID *p_Var3;

	if (method_id != (_jobject *)0x0)
	{
		uVar1 = utils_get_package_name(env, method_id);
		uVar2 = (**(*env + 0xf8))(env, method_id); //GetStaticMethodID	Locates a static method in a Java class so it can be called later.
		uVar2 = (**(*env + 0x108))(env, uVar2, "getPackageManager", "()Landroid/content/pm/PackageManager;"); //CallStaticObjectMethod	Executes a static Java method that returns an object (like a String or array).
		p_Var3 = (_jmethodID *)_JNIEnv::CallObjectMethod((_jobject *)env, (_jmethodID *)method_id, uVar2, 0);
		uVar2 = (**(*env + 0xf8))(env, p_Var3);
		uVar2 = (**(*env + 0x108))(env, uVar2, "getPackageInfo", "(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;");
		uVar1 = _JNIEnv::CallObjectMethod((_jobject *)env, p_Var3, uVar2, uVar1, 0x40);
		uVar2 = (**(*env + 0xf8))(env, uVar1);
		uVar2 = (**(*env + 0x2f0))(env, uVar2, "signatures", "[Landroid/content/pm/Signature;"); //GetStaticFieldID	Locates a static variable (field) within a Java class.
		uVar1 = (**(*env + 0x2f8))(env, uVar1, uVar2);//GetStaticObjectField	Retrieves the actual value/object held in a static field.
		p_Var3 = (_jmethodID *)(**(*env + 0x568))(env, uVar1, 0); //GetStringUTFChars	Converts a Java String object into a C-style char* (UTF-8) so the native code can read it.
		uVar1 = (**(code **)(*(long *)env + 0xf8))(env, p_Var3);
		uVar1 = (**(code **)(*(long *)env + 0x108))(env, uVar1, "hashCode", &DAT_00173ca0);
		__bss_start = _JNIEnv::CallIntMethod((_jobject *)env, p_Var3, uVar1); //ghidra dice che lo mette in __bss_start perchè una variabile vicino a quella label(se fosse così anche per la funzione che fa encoding allora quella non sarebbe random)
		return;
	}
	utils_throw_by_name(env, "java/lang/NullPointerException", "Context is null.");
	return;
}
