
/* utils_get_package_name(_JNIEnv*, _jobject*) */

void utils_get_package_name(_JNIEnv *param_1,_jobject *param_2)

{
  undefined8 uVar1;
  
  uVar1 = (**(code **)(*(long *)param_1 + 0xf8))();
  uVar1 = (**(code **)(*(long *)param_1 + 0x108))
                    (param_1,uVar1,"getPackageName","()Ljava/lang/String;");
  _JNIEnv::CallObjectMethod((_jobject *)param_1,(_jmethodID *)param_2,uVar1,0);
  return;
}

