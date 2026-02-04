package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.internal.zzs;

/* loaded from: classes2.dex */
class zzbl extends zzd {
    private final zza.zzb zzamC;
    private final DriveFile.DownloadProgressListener zzasy;

    zzbl(zza.zzb zzbVar, DriveFile.DownloadProgressListener downloadProgressListener) {
        this.zzamC = zzbVar;
        this.zzasy = downloadProgressListener;
    }

    @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
    public void onError(Status status) {
        this.zzamC.zzs(new zzs.zzb(status, null));
    }

    @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
    public void zza(OnContentsResponse onContentsResponse) {
        this.zzamC.zzs(new zzs.zzb(onContentsResponse.zzto() ? new Status(-1) : Status.zzagC, new zzv(onContentsResponse.zztn())));
    }

    @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
    public void zza(OnDownloadProgressResponse onDownloadProgressResponse) {
        if (this.zzasy != null) {
            this.zzasy.onProgress(onDownloadProgressResponse.zztq(), onDownloadProgressResponse.zztr());
        }
    }
}
