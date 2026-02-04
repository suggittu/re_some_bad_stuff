package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzne;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class zze {

    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzoM();
    public static boolean zzafL = false;
    public static boolean zzafM = false;
    static int zzafN = -1;
    private static final Object zzqy = new Object();
    private static String zzafO = null;
    private static Integer zzafP = null;
    static final AtomicBoolean zzafQ = new AtomicBoolean();
    private static final AtomicBoolean zzafR = new AtomicBoolean();

    zze() {
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zzc.zzoK().getErrorResolutionPendingIntent(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.getStatusString(i);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) throws IOException {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build());
            try {
                String next = new Scanner(inputStreamOpenInputStream).useDelimiter("\\A").next();
                if (inputStreamOpenInputStream == null) {
                    return next;
                }
                inputStreamOpenInputStream.close();
                return next;
            } catch (NoSuchElementException e) {
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                return null;
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e1  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int isGooglePlayServicesAvailable(android.content.Context r9) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zze.isGooglePlayServicesAvailable(android.content.Context):int");
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return false;
        }
    }

    @Deprecated
    public static void zzad(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int iIsGooglePlayServicesAvailable = zzc.zzoK().isGooglePlayServicesAvailable(context);
        if (iIsGooglePlayServicesAvailable != 0) {
            Intent intentZza = zzc.zzoK().zza(context, iIsGooglePlayServicesAvailable, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + iIsGooglePlayServicesAvailable);
            if (intentZza != null) {
                throw new GooglePlayServicesRepairableException(iIsGooglePlayServicesAvailable, "Google Play Services not available", intentZza);
            }
            throw new GooglePlayServicesNotAvailableException(iIsGooglePlayServicesAvailable);
        }
    }

    @Deprecated
    public static int zzaj(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @Deprecated
    public static void zzal(Context context) {
        if (zzafQ.getAndSet(true)) {
            return;
        }
        try {
            ((NotificationManager) context.getSystemService("notification")).cancel(10436);
        } catch (SecurityException e) {
        }
    }

    private static void zzan(Context context) {
        Integer num;
        if (zzafR.get()) {
            return;
        }
        synchronized (zzqy) {
            if (zzafO == null) {
                zzafO = context.getPackageName();
                try {
                    Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        zzafP = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                    } else {
                        zzafP = null;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
                }
            } else if (!zzafO.equals(context.getPackageName())) {
                throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + zzafO + "' and this call used package '" + context.getPackageName() + "'.");
            }
            num = zzafP;
        }
        if (num == null) {
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
        if (num.intValue() != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
            throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + num + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
    }

    public static String zzao(Context context) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        String str = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    public static boolean zzap(Context context) {
        return zzne.zzsm() && context.getPackageManager().hasSystemFeature("cn.google");
    }

    @TargetApi(18)
    public static boolean zzaq(Context context) {
        Bundle applicationRestrictions;
        return zzne.zzsj() && (applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    @TargetApi(19)
    public static boolean zzb(Context context, int i, String str) {
        if (zzne.zzsk()) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (String str2 : packagesForUid) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zzb(android.content.pm.PackageManager r9) {
        /*
            r0 = 1
            r1 = 0
            java.lang.Object r2 = com.google.android.gms.common.zze.zzqy
            monitor-enter(r2)
            int r3 = com.google.android.gms.common.zze.zzafN     // Catch: java.lang.Throwable -> L39
            r4 = -1
            if (r3 != r4) goto L2a
            java.lang.String r3 = "com.google.android.gms"
            r4 = 64
            android.content.pm.PackageInfo r3 = r9.getPackageInfo(r3, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L34 java.lang.Throwable -> L39
            com.google.android.gms.common.zzf r4 = com.google.android.gms.common.zzf.zzoO()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L34 java.lang.Throwable -> L39
            r5 = 1
            com.google.android.gms.common.zzd$zza[] r5 = new com.google.android.gms.common.zzd.zza[r5]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L34 java.lang.Throwable -> L39
            r6 = 0
            com.google.android.gms.common.zzd$zza[] r7 = com.google.android.gms.common.zzd.C0046zzd.zzafK     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L34 java.lang.Throwable -> L39
            r8 = 1
            r7 = r7[r8]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L34 java.lang.Throwable -> L39
            r5[r6] = r7     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L34 java.lang.Throwable -> L39
            com.google.android.gms.common.zzd$zza r3 = r4.zza(r3, r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L34 java.lang.Throwable -> L39
            if (r3 == 0) goto L30
            r3 = 1
            com.google.android.gms.common.zze.zzafN = r3     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L34 java.lang.Throwable -> L39
        L2a:
            int r3 = com.google.android.gms.common.zze.zzafN     // Catch: java.lang.Throwable -> L39
            if (r3 == 0) goto L3c
        L2e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L39
            return r0
        L30:
            r3 = 0
            com.google.android.gms.common.zze.zzafN = r3     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L34 java.lang.Throwable -> L39
            goto L2a
        L34:
            r3 = move-exception
            r3 = 0
            com.google.android.gms.common.zze.zzafN = r3     // Catch: java.lang.Throwable -> L39
            goto L2a
        L39:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L3c:
            r0 = r1
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zze.zzb(android.content.pm.PackageManager):boolean");
    }

    @Deprecated
    public static Intent zzbv(int i) {
        return zzc.zzoK().zza(null, i, null);
    }

    static boolean zzbw(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 18:
            case 42:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzc(PackageManager packageManager) {
        return zzb(packageManager) || !zzoN();
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zzi(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        if (i == 9) {
            return zzi(context, "com.android.vending");
        }
        return false;
    }

    public static boolean zzf(Context context, int i) throws PackageManager.NameNotFoundException {
        if (!zzb(context, i, "com.google.android.gms")) {
            return false;
        }
        try {
            return zzf.zzoO().zza(context.getPackageManager(), context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException e) {
            if (!Log.isLoggable("GooglePlayServicesUtil", 3)) {
                return false;
            }
            Log.d("GooglePlayServicesUtil", "Package manager can't find google play services package, defaulting to false");
            return false;
        }
    }

    @TargetApi(21)
    static boolean zzi(Context context, String str) {
        if (zzne.zzsm()) {
            Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getAppPackageName())) {
                    return true;
                }
            }
        }
        if (zzaq(context)) {
            return false;
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 8192).enabled;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private static int zzoM() {
        return 8487000;
    }

    public static boolean zzoN() {
        return zzafL ? zzafM : "user".equals(Build.TYPE);
    }
}
