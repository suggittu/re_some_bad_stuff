package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzs;

/* loaded from: classes2.dex */
public class zzw extends zzab implements DriveFile {

    class zza implements DriveFile.DownloadProgressListener {
        private final com.google.android.gms.common.api.internal.zzq zzari;

        public zza(com.google.android.gms.common.api.internal.zzq zzqVar) {
            this.zzari = zzqVar;
        }

        @Override // com.google.android.gms.drive.DriveFile.DownloadProgressListener
        public void onProgress(final long j, final long j2) {
            this.zzari.zza(new zzq.zzb() { // from class: com.google.android.gms.drive.internal.zzw.zza.1
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(DriveFile.DownloadProgressListener downloadProgressListener) {
                    downloadProgressListener.onProgress(j, j2);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }
    }

    public zzw(DriveId driveId) {
        super(driveId);
    }

    private static DriveFile.DownloadProgressListener zza(GoogleApiClient googleApiClient, DriveFile.DownloadProgressListener downloadProgressListener) {
        if (downloadProgressListener == null) {
            return null;
        }
        return new zza(googleApiClient.zzr(downloadProgressListener));
    }

    @Override // com.google.android.gms.drive.DriveFile
    public PendingResult open(GoogleApiClient googleApiClient, final int i, DriveFile.DownloadProgressListener downloadProgressListener) {
        if (i != 268435456 && i != 536870912 && i != 805306368) {
            throw new IllegalArgumentException("Invalid mode provided.");
        }
        final DriveFile.DownloadProgressListener downloadProgressListenerZza = zza(googleApiClient, downloadProgressListener);
        return googleApiClient.zza(new zzs.zzc(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzw.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zza(zzuVar.zzte().zza(new OpenContentsRequest(zzw.this.getDriveId(), i, 0), new zzbl(this, downloadProgressListenerZza)).zztj());
            }
        });
    }
}
