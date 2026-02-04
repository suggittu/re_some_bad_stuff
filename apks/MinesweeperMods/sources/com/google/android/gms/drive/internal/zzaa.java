package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.internal.zzt;

/* loaded from: classes2.dex */
public class zzaa implements DrivePreferencesApi {

    class zza extends zzd {
        private final zza.zzb zzamC;

        private zza(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void onError(Status status) {
            this.zzamC.zzs(new zzb(status, null));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) {
            this.zzamC.zzs(new zzb(Status.zzagC, onDeviceUsagePreferenceResponse.zztp()));
        }
    }

    class zzb implements DrivePreferencesApi.FileUploadPreferencesResult {
        private final Status zzUX;
        private final FileUploadPreferences zzarw;

        private zzb(Status status, FileUploadPreferences fileUploadPreferences) {
            this.zzUX = status;
            this.zzarw = fileUploadPreferences;
        }

        @Override // com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult
        public FileUploadPreferences getFileUploadPreferences() {
            return this.zzarw;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    abstract class zzc extends zzt {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzG, reason: merged with bridge method [inline-methods] */
        public DrivePreferencesApi.FileUploadPreferencesResult zzc(Status status) {
            return new zzb(status, null);
        }
    }

    @Override // com.google.android.gms.drive.DrivePreferencesApi
    public PendingResult getFileUploadPreferences(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzc(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzaa.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zzuVar.zzte().zzd(new zza(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DrivePreferencesApi
    public PendingResult setFileUploadPreferences(GoogleApiClient googleApiClient, FileUploadPreferences fileUploadPreferences) {
        if (!(fileUploadPreferences instanceof FileUploadPreferencesImpl)) {
            throw new IllegalArgumentException("Invalid preference value");
        }
        final FileUploadPreferencesImpl fileUploadPreferencesImpl = (FileUploadPreferencesImpl) fileUploadPreferences;
        return googleApiClient.zzb(new zzt.zza(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzaa.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zzuVar.zzte().zza(new SetFileUploadPreferencesRequest(fileUploadPreferencesImpl), new zzbu(this));
            }
        });
    }
}
