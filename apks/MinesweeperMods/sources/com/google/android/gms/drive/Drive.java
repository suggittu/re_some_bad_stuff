package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.zzaa;
import com.google.android.gms.drive.internal.zzac;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.drive.internal.zzu;
import com.google.android.gms.drive.internal.zzx;

/* loaded from: classes2.dex */
public final class Drive {
    public static final Api.zzc zzUI = new Api.zzc();
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope zzaoE = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope zzaoF = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api API = new Api("Drive.API", new zza() { // from class: com.google.android.gms.drive.Drive.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.drive.Drive.zza
        public final Bundle zza(Api.ApiOptions.NoOptions noOptions) {
            return new Bundle();
        }
    }, zzUI);
    public static final Api zzaoG = new Api("Drive.INTERNAL_API", new zza() { // from class: com.google.android.gms.drive.Drive.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.drive.Drive.zza
        public final Bundle zza(zzb zzbVar) {
            return zzbVar == null ? new Bundle() : zzbVar.zzsw();
        }
    }, zzUI);
    public static final DriveApi DriveApi = new zzs();
    public static final zzd zzaoH = new zzx();
    public static final zzf zzaoI = new zzac();
    public static final DrivePreferencesApi DrivePreferencesApi = new zzaa();

    public abstract class zza extends Api.zza {
        protected abstract Bundle zza(Api.ApiOptions apiOptions);

        @Override // com.google.android.gms.common.api.Api.zza
        public zzu zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions apiOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzu(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener, zza(apiOptions));
        }
    }

    public class zzb implements Api.ApiOptions.Optional {
        private final Bundle zzUH;

        public Bundle zzsw() {
            return this.zzUH;
        }
    }

    private Drive() {
    }
}
