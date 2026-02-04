package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.android.gms.internal.zzhb;

@zzhb
/* loaded from: classes2.dex */
public class zzb {
    public static void e(String str) {
        if (zzQ(6)) {
            Log.e("Ads", str);
        }
    }

    public static boolean zzQ(int i) {
        return i >= 5 || Log.isLoggable("Ads", i);
    }

    public static void zza(String str, Throwable th) {
        if (zzQ(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static void zzaI(String str) {
        if (zzQ(3)) {
            Log.d("Ads", str);
        }
    }

    public static void zzaJ(String str) {
        if (zzQ(4)) {
            Log.i("Ads", str);
        }
    }

    public static void zzaK(String str) {
        if (zzQ(5)) {
            Log.w("Ads", str);
        }
    }

    public static void zzb(String str, Throwable th) {
        if (zzQ(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void zzc(String str, Throwable th) {
        if (zzQ(4)) {
            Log.i("Ads", str, th);
        }
    }

    public static void zzd(String str, Throwable th) {
        if (zzQ(5)) {
            Log.w("Ads", str, th);
        }
    }
}
