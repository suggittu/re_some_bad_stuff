package com.google.android.gms.drive.internal;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.internal.zzt;
import com.google.android.gms.drive.query.Query;
import java.util.List;

/* loaded from: classes2.dex */
public class zzs implements DriveApi {

    class zza extends com.google.android.gms.drive.internal.zzd {
        private final zza.zzb zzamC;

        public zza(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void onError(Status status) {
            this.zzamC.zzs(new zzb(status, null));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void zza(OnContentsResponse onContentsResponse) {
            this.zzamC.zzs(new zzb(Status.zzagC, new zzv(onContentsResponse.zztn())));
        }
    }

    class zzb implements Releasable, DriveApi.DriveContentsResult {
        private final Status zzUX;
        private final DriveContents zzaoC;

        public zzb(Status status, DriveContents driveContents) {
            this.zzUX = status;
            this.zzaoC = driveContents;
        }

        @Override // com.google.android.gms.drive.DriveApi.DriveContentsResult
        public DriveContents getDriveContents() {
            return this.zzaoC;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzaoC != null) {
                this.zzaoC.zzsy();
            }
        }
    }

    abstract class zzc extends zzt {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzB, reason: merged with bridge method [inline-methods] */
        public DriveApi.DriveContentsResult zzc(Status status) {
            return new zzb(status, null);
        }
    }

    class zzd extends com.google.android.gms.drive.internal.zzd {
        private final zza.zzb zzamC;

        public zzd(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void onError(Status status) {
            this.zzamC.zzs(new zze(status, null));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void zza(OnDriveIdResponse onDriveIdResponse) {
            this.zzamC.zzs(new zze(Status.zzagC, onDriveIdResponse.getDriveId()));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void zza(OnMetadataResponse onMetadataResponse) {
            this.zzamC.zzs(new zze(Status.zzagC, new zzp(onMetadataResponse.zztw()).getDriveId()));
        }
    }

    class zze implements DriveApi.DriveIdResult {
        private final Status zzUX;
        private final DriveId zzaoz;

        public zze(Status status, DriveId driveId) {
            this.zzUX = status;
            this.zzaoz = driveId;
        }

        @Override // com.google.android.gms.drive.DriveApi.DriveIdResult
        public DriveId getDriveId() {
            return this.zzaoz;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    abstract class zzf extends zzt {
        zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzC, reason: merged with bridge method [inline-methods] */
        public DriveApi.DriveIdResult zzc(Status status) {
            return new zze(status, null);
        }
    }

    class zzg implements DriveApi.MetadataBufferResult {
        private final Status zzUX;
        private final MetadataBuffer zzaqI;
        private final boolean zzaqJ;

        public zzg(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.zzUX = status;
            this.zzaqI = metadataBuffer;
            this.zzaqJ = z;
        }

        @Override // com.google.android.gms.drive.DriveApi.MetadataBufferResult
        public MetadataBuffer getMetadataBuffer() {
            return this.zzaqI;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzaqI != null) {
                this.zzaqI.release();
            }
        }
    }

    abstract class zzh extends zzt {
        zzh(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzD, reason: merged with bridge method [inline-methods] */
        public DriveApi.MetadataBufferResult zzc(Status status) {
            return new zzg(status, null, false);
        }
    }

    class zzi extends com.google.android.gms.drive.internal.zzd {
        private final zza.zzb zzamC;

        public zzi(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void onError(Status status) {
            this.zzamC.zzs(new zzg(status, null, false));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void zza(OnListEntriesResponse onListEntriesResponse) {
            this.zzamC.zzs(new zzg(Status.zzagC, new MetadataBuffer(onListEntriesResponse.zztt()), onListEntriesResponse.zztu()));
        }
    }

    @SuppressLint({"MissingRemoteException"})
    class zzj extends zzt.zza {
        zzj(GoogleApiClient googleApiClient, Status status) {
            super(googleApiClient);
            zza(status);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(zzu zzuVar) {
        }
    }

    @Override // com.google.android.gms.drive.DriveApi
    public PendingResult cancelPendingActions(GoogleApiClient googleApiClient, List list) {
        return ((zzu) googleApiClient.zza(Drive.zzUI)).cancelPendingActions(googleApiClient, list);
    }

    @Override // com.google.android.gms.drive.DriveApi
    public PendingResult fetchDriveId(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zzf(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzs.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zzuVar.zzte().zza(new GetMetadataRequest(DriveId.zzcW(str), false), new zzd(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveApi
    public DriveFolder getAppFolder(GoogleApiClient googleApiClient) {
        zzu zzuVar = (zzu) googleApiClient.zza(Drive.zzUI);
        if (!zzuVar.zzth()) {
            throw new IllegalStateException("Client is not yet connected");
        }
        DriveId driveIdZztg = zzuVar.zztg();
        if (driveIdZztg != null) {
            return new zzy(driveIdZztg);
        }
        return null;
    }

    @Override // com.google.android.gms.drive.DriveApi
    public DriveFile getFile(GoogleApiClient googleApiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        }
        if (googleApiClient.isConnected()) {
            return new zzw(driveId);
        }
        throw new IllegalStateException("Client must be connected");
    }

    @Override // com.google.android.gms.drive.DriveApi
    public DriveFolder getFolder(GoogleApiClient googleApiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        }
        if (googleApiClient.isConnected()) {
            return new zzy(driveId);
        }
        throw new IllegalStateException("Client must be connected");
    }

    @Override // com.google.android.gms.drive.DriveApi
    public DriveFolder getRootFolder(GoogleApiClient googleApiClient) {
        zzu zzuVar = (zzu) googleApiClient.zza(Drive.zzUI);
        if (!zzuVar.zzth()) {
            throw new IllegalStateException("Client is not yet connected");
        }
        DriveId driveIdZztf = zzuVar.zztf();
        if (driveIdZztf != null) {
            return new zzy(driveIdZztf);
        }
        return null;
    }

    @Override // com.google.android.gms.drive.DriveApi
    public PendingResult isAutobackupEnabled(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzt(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzs.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzA, reason: merged with bridge method [inline-methods] */
            public BooleanResult zzc(Status status) {
                return new BooleanResult(status, false);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zzuVar.zzte().zze(new com.google.android.gms.drive.internal.zzd() { // from class: com.google.android.gms.drive.internal.zzs.5.1
                    @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
                    public void zzaf(boolean z) {
                        this.zza(new BooleanResult(Status.zzagC, z));
                    }
                });
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveApi
    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    @Override // com.google.android.gms.drive.DriveApi
    public PendingResult newDriveContents(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, DriveFile.MODE_WRITE_ONLY);
    }

    @Override // com.google.android.gms.drive.DriveApi
    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    @Override // com.google.android.gms.drive.DriveApi
    public PendingResult query(GoogleApiClient googleApiClient, final Query query) {
        if (query == null) {
            throw new IllegalArgumentException("Query must be provided.");
        }
        return googleApiClient.zza(new zzh(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzs.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zzuVar.zzte().zza(new QueryRequest(query), new zzi(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveApi
    public PendingResult requestSync(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzt.zza(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzs.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zzuVar.zzte().zza(new zzbu(this));
            }
        });
    }

    public PendingResult zza(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new zzc(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzs.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zzuVar.zzte().zza(new CreateContentsRequest(i), new zza(this));
            }
        });
    }
}
