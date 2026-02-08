


void installV23(_JNIEnv *env, _jclass *target_object, _jobject *ClassLoader, _jobjectArray *size,
                _jobject *path_outdex)

{
  char *pcVar1;
  char *pcVar2;
  undefined8 java_util;
  _jobject *p_Var4;
  _jmethodID *classLoader;
  undefined8 dex_path;
  undefined8 uVar7;
  _jobjectArray *p_Var8;
  char *pcVar9;

  pcVar1 = (char *)replaceStringForInt(0x17);//dexElements
  pcVar2 = (char *)replaceStringForInt(0x18);//[Ldalvik/system/DexPathList$Element;
  java_util = findFieldByInstance(env, ClassLoader, pcVar1, pcVar2);

  p_Var4 = (_jobject *)(**(*env + 0x2f8))(env, ClassLoader, java_util);
  //jobject     (*GetObjectField)(JNIEnv*, jobject, jfieldID);

  classLoader = (_jmethodID *)(**(*env + 0xf8))(env, p_Var4);
  //jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);

  java_util = replaceStringForInt(10);//(Ljava/util/List;Ljava/io/File;Ljava/util/List


  dex_path = replaceStringForInt(0xb);//Ldalvik/system/DexPathList;
  java_util = (**(*env + 0x388))(env, classLoader, java_util, dex_path);
  dex_path = create_array_list(env, size);
  uVar7 = create_empty_array_list(env);
  p_Var8 = (_jobjectArray *)
      _JNIEnv::CallStaticObjectMethod((_jclass *)env, classLoader, java_util, dex_path, path_outdex, uVar7);
  pcVar1 = replaceStringForInt(0x19);//dalvik/system/DexPathList$Element
  pcVar2 = replaceStringForInt(0x1a);//.dat.jar
  pcVar9 = replaceStringForInt(0x1b);//path
  expand_field_array(env, p_Var4, pcVar1, pcVar2, pcVar9, p_Var8);
  (**(code **)(*(long *)env + 0xb8))(env, dex_path);
  return;

  utils_throw_by_name(env, "java/lang/NullPointerException", "Null params.");
  return;
}
