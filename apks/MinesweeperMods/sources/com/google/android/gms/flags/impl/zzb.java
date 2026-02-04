package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzpl;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class zzb {
    private static SharedPreferences zzaBZ = null;

    public static SharedPreferences zzw(final Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (zzaBZ == null) {
                zzaBZ = (SharedPreferences) zzpl.zzb(new Callable() { // from class: com.google.android.gms.flags.impl.zzb.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: zzvw, reason: merged with bridge method [inline-methods] */
                    public final SharedPreferences call() {
                        return context.getSharedPreferences("google_sdk_flags", 1);
                    }
                });
            }
            sharedPreferences = zzaBZ;
        }
        return sharedPreferences;
    }
}
