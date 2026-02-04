package com.google.android.gms.common.stats;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class zzg {
    public static String zza(PowerManager.WakeLock wakeLock, String str) {
        StringBuilder sbAppend = new StringBuilder().append(String.valueOf((Process.myPid() << 32) | System.identityHashCode(wakeLock)));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return sbAppend.append(str).toString();
    }
}
