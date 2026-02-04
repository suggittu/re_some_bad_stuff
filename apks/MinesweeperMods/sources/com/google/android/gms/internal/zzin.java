package com.google.android.gms.internal;

import android.util.Log;

@zzhb
/* loaded from: classes2.dex */
public final class zzin extends com.google.android.gms.ads.internal.util.client.zzb {
    public static void v(String str) {
        if (zzhp()) {
            Log.v("Ads", str);
        }
    }

    public static boolean zzho() {
        return ((Boolean) zzbt.zzwK.get()).booleanValue();
    }

    private static boolean zzhp() {
        return zzQ(2) && zzho();
    }
}
