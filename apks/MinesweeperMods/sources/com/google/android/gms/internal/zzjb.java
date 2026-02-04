package com.google.android.gms.internal;

import android.os.StrictMode;
import java.util.concurrent.Callable;

@zzhb
/* loaded from: classes2.dex */
public class zzjb {
    public static Object zzb(Callable callable) {
        Object objCall;
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            try {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
                objCall = callable.call();
            } catch (Throwable th) {
                zzin.zzb("Unexpected exception.", th);
                com.google.android.gms.ads.internal.zzr.zzbF().zzb(th, true);
                StrictMode.setThreadPolicy(threadPolicy);
                objCall = null;
            }
            return objCall;
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
