package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.util.Log;

/* loaded from: classes2.dex */
public class zznv {
    private static int zzazC = -1;

    public static boolean zzaD(Context context) {
        return zzaG(context) == 3;
    }

    private static int zzaE(Context context) {
        return ((zzaF(context) % 1000) / 100) + 5;
    }

    private static int zzaF(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("Fitness", "Could not find package info for Google Play Services");
            return -1;
        }
    }

    public static int zzaG(Context context) {
        int i;
        if (zzazC == -1) {
            switch (zzaE(context)) {
                case 8:
                case 13:
                    i = 0;
                    break;
                case 9:
                case 11:
                case 12:
                default:
                    if (!zzaH(context)) {
                        i = 2;
                        break;
                    } else {
                        i = 1;
                        break;
                    }
                case 10:
                    i = 3;
                    break;
            }
            zzazC = i;
        }
        return zzazC;
    }

    private static boolean zzaH(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
        } catch (Resources.NotFoundException e) {
            Log.wtf("Fitness", "Unable to determine type of device, assuming phone.  Version: " + zzaF(context), e);
            return true;
        }
    }
}
