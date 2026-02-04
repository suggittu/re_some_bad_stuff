package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzas;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/* loaded from: classes2.dex */
public class zzd {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME;
    public static final String KEY_CALLER_UID;
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";

    @Deprecated
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    private static final ComponentName zzVe;
    private static final ComponentName zzVf;

    interface zza {
        Object zzan(IBinder iBinder);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        KEY_CALLER_UID = "callerUid";
        int i2 = Build.VERSION.SDK_INT;
        KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
        zzVe = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
        zzVf = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
    }

    zzd() {
    }

    public static void clearToken(Context context, final String str) throws GoogleAuthException, IOException {
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        zzad(context);
        final Bundle bundle = new Bundle();
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        if (!bundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            bundle.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        zza(context, zzVe, new zza() { // from class: com.google.android.gms.auth.zzd.2
            @Override // com.google.android.gms.auth.zzd.zza
            /* renamed from: zzao, reason: merged with bridge method [inline-methods] */
            public final Void zzan(IBinder iBinder) throws GoogleAuthException {
                Bundle bundle2 = (Bundle) zzd.zzm(zzas.zza.zza(iBinder).zza(str, bundle));
                String string = bundle2.getString("Error");
                if (bundle2.getBoolean("booleanResult")) {
                    return null;
                }
                throw new GoogleAuthException(string);
            }
        });
    }

    public static List getAccountChangeEvents(Context context, final int i, final String str) throws GoogleAuthException {
        zzx.zzh(str, "accountName must be provided");
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        zzad(context);
        return (List) zza(context, zzVe, new zza() { // from class: com.google.android.gms.auth.zzd.3
            @Override // com.google.android.gms.auth.zzd.zza
            /* renamed from: zzap, reason: merged with bridge method [inline-methods] */
            public final List zzan(IBinder iBinder) {
                return ((AccountChangeEventsResponse) zzd.zzm(zzas.zza.zza(iBinder).zza(new AccountChangeEventsRequest().setAccountName(str).setEventIndex(i)))).getEvents();
            }
        });
    }

    public static String getAccountId(Context context, String str) throws GoogleAuthException {
        zzx.zzh(str, "accountName must be provided");
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        zzad(context);
        return getToken(context, str, "^^_account_id_^^", new Bundle());
    }

    public static String getToken(Context context, Account account, String str) {
        return getToken(context, account, str, new Bundle());
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) {
        return zzc(context, account, str, bundle).getToken();
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) {
        return getToken(context, new Account(str, "com.google"), str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) {
        return getToken(context, new Account(str, "com.google"), str2, bundle);
    }

    @RequiresPermission("android.permission.MANAGE_ACCOUNTS")
    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken("com.google", str);
    }

    private static Object zza(Context context, ComponentName componentName, zza zzaVar) throws IOException {
        com.google.android.gms.common.zza zzaVar2 = new com.google.android.gms.common.zza();
        zzl zzlVarZzau = zzl.zzau(context);
        try {
            if (!zzlVarZzau.zza(componentName, zzaVar2, "GoogleAuthUtil")) {
                throw new IOException("Could not bind to service.");
            }
            try {
                return zzaVar.zzan(zzaVar2.zzoJ());
            } catch (RemoteException | InterruptedException e) {
                Log.i("GoogleAuthUtil", "Error on service connection.", e);
                throw new IOException("Error on service connection.", e);
            }
        } finally {
            zzlVarZzau.zzb(componentName, zzaVar2, "GoogleAuthUtil");
        }
    }

    private static void zzad(Context context) throws GoogleAuthException {
        try {
            com.google.android.gms.common.zze.zzad(context.getApplicationContext());
        } catch (GooglePlayServicesNotAvailableException e) {
            throw new GoogleAuthException(e.getMessage());
        } catch (GooglePlayServicesRepairableException e2) {
            throw new GooglePlayServicesAvailabilityException(e2.getConnectionStatusCode(), e2.getMessage(), e2.getIntent());
        }
    }

    public static TokenData zzc(Context context, final Account account, final String str, Bundle bundle) throws GoogleAuthException {
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        zzad(context);
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle2.getString(KEY_ANDROID_PACKAGE_NAME))) {
            bundle2.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        return (TokenData) zza(context, zzVe, new zza() { // from class: com.google.android.gms.auth.zzd.1
            @Override // com.google.android.gms.auth.zzd.zza
            /* renamed from: zzam, reason: merged with bridge method [inline-methods] */
            public final TokenData zzan(IBinder iBinder) throws IOException, GoogleAuthException {
                Bundle bundle3 = (Bundle) zzd.zzm(zzas.zza.zza(iBinder).zza(account, str, bundle2));
                TokenData tokenDataZzc = TokenData.zzc(bundle3, "tokenDetails");
                if (tokenDataZzc != null) {
                    return tokenDataZzc;
                }
                String string = bundle3.getString("Error");
                Intent intent = (Intent) bundle3.getParcelable("userRecoveryIntent");
                com.google.android.gms.auth.firstparty.shared.zzd zzdVarZzbY = com.google.android.gms.auth.firstparty.shared.zzd.zzbY(string);
                if (com.google.android.gms.auth.firstparty.shared.zzd.zza(zzdVarZzbY)) {
                    throw new UserRecoverableAuthException(string, intent);
                }
                if (com.google.android.gms.auth.firstparty.shared.zzd.zzc(zzdVarZzbY)) {
                    throw new IOException(string);
                }
                throw new GoogleAuthException(string);
            }
        });
    }

    static void zzi(Intent intent) throws URISyntaxException {
        if (intent == null) {
            throw new IllegalArgumentException("Callback cannot be null.");
        }
        try {
            Intent.parseUri(intent.toUri(1), 1);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object zzm(Object obj) throws IOException {
        if (obj != null) {
            return obj;
        }
        Log.w("GoogleAuthUtil", "Binder call returned null.");
        throw new IOException("Service unavailable.");
    }
}
