void utils_copy_from_assets(_JNIEnv *env, _jobject *context, char *package_name_dat, char *package_name)

{
    undefined8 uVar1;
    long file_reference;
    void *buf;
    void *decode_result;
    ulong uVar5;
    ulong lenght;
    long local_8;

    local_8 = ___stack_chk_guard;
    uVar1 = (**(*env + 0xf8))();
    getAssets = (**(*env + 0x108))(env, uVar1, "getAssets", "()Landroid/content/r es/AssetManager;");// AssetManager object, which is the gateway to all the files packed inside the assets/ directory of the Android app.
   AssetMenager = _JNIEnv::CallObjectMethod((_jobject *)env, (_jme thodID *)context, getAssets);
   AssetMenager_native = AAssetManager_fromJava(env,AssetMenager);
    file_reference = AAssetManager_open(AssetMenager_native, package_name_dat, 0); //apre il file
    if (file_reference == 0)
    {
        uVar5 = 0xffffffff;
    }
    else
    {
        lenght = AAsset_getLength();
        buf = operator.new[](lenght);
        AAsset_read(file_reference, buf, lenght);
        decode_result = (void *)unpacker_unpack(buf, &lenght);
        lenght = utils_save_raw(package_name, decode_result, lenght);
        if (decode_result != (void *)0x0)
        {
            operator.delete[](decode_result);
        }
        AAsset_close(file_reference);
        operator.delete[](buf);
        uVar5 = lenght & 0xffffffff;
    }
    if (local_8 == ___stack_chk_guard)
    {
        return;
    }
    /* WARNING: Subroutine does not return */
    __stack_chk_fail(uVar5);
}