package com.google.android.gms.internal;

import android.os.StrictMode;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class zzpl {
    public static Object zzb(Callable callable) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
            Object objCall = callable.call();
            StrictMode.setThreadPolicy(threadPolicy);
            return objCall;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicy);
            throw th;
        }
    }
}
