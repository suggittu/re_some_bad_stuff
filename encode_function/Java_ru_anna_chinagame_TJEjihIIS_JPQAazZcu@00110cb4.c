
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void Java_ru_anna_chinagame_TJEjihIIS_JPQAazZcu(_JNIEnv *env, undefined8 param_2, long java_input_array)

{
	int number_elements;
	char *array_address;
	long lVar3;
	undefined8 uVar4;
	undefined1 uStack_11;
	ulong local_10;

	if (java_input_array == 0)
	{
		utils_throw_by_name(env, "java/lang/NullPointerException", "Array is null.");
		uVar4 = 0;
	}
	else
	{
	array_address = (env + 0x5c0)(env, java_input_array, &uStack_11); // GetByteArrayElements(trasforma input array in un array utilizzabile in c)
	number_elements = (env + 0x558)(env,java_input_array); //GetArrayLenght(return number element in the array)
	lVar3 = unpacker_unpack(array_address, &number_elements);
	(env + 0x600)(env, java_input_array, array_address, 0); // ReleaseByteArrayElements	Informs the VM that the native code no longer needs access to the array.
	if (lVar3 == 0)
	{
		utils_throw_by_name(env, "java/lang/IllegalArgumentException", "Bad content.");
		uVar4 = 0;
	}
	else
	{
		uVar4 = (env + 0x580)(env, number_elements & 0xffffffff);		  // NewByteArray	Creates a new array of bytes in the Java heap.
		(env + 0x680)(env, uVar4, 0, number_elements & 0xffffffff, lVar3); // SetByteArrayRegion	Copies a region of a native buffer back into the Java byte array. (riporta l'array nello stile java)
	}
	}
}
