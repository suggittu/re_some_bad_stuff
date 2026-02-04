package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;
import com.google.android.gms.drive.zzh;
import com.google.android.gms.internal.zznm;

/* loaded from: classes2.dex */
public class zzy extends zzab implements DriveFolder {

    class zza extends com.google.android.gms.drive.internal.zzd {
        private final zza.zzb zzamC;

        public zza(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void onError(Status status) {
            this.zzamC.zzs(new zzc(status, null));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void zza(OnDriveIdResponse onDriveIdResponse) {
            this.zzamC.zzs(new zzc(Status.zzagC, new zzw(onDriveIdResponse.getDriveId())));
        }
    }

    class zzb extends com.google.android.gms.drive.internal.zzd {
        private final zza.zzb zzamC;

        public zzb(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void onError(Status status) {
            this.zzamC.zzs(new zze(status, null));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void zza(OnDriveIdResponse onDriveIdResponse) {
            this.zzamC.zzs(new zze(Status.zzagC, new zzy(onDriveIdResponse.getDriveId())));
        }
    }

    class zzc implements DriveFolder.DriveFileResult {
        private final Status zzUX;
        private final DriveFile zzarr;

        public zzc(Status status, DriveFile driveFile) {
            this.zzUX = status;
            this.zzarr = driveFile;
        }

        @Override // com.google.android.gms.drive.DriveFolder.DriveFileResult
        public DriveFile getDriveFile() {
            return this.zzarr;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    abstract class zzd extends zzt {
        zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzE, reason: merged with bridge method [inline-methods] */
        public DriveFolder.DriveFileResult zzc(Status status) {
            return new zzc(status, null);
        }
    }

    class zze implements DriveFolder.DriveFolderResult {
        private final Status zzUX;
        private final DriveFolder zzars;

        public zze(Status status, DriveFolder driveFolder) {
            this.zzUX = status;
            this.zzars = driveFolder;
        }

        @Override // com.google.android.gms.drive.DriveFolder.DriveFolderResult
        public DriveFolder getDriveFolder() {
            return this.zzars;
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
        /* renamed from: zzF, reason: merged with bridge method [inline-methods] */
        public DriveFolder.DriveFolderResult zzc(Status status) {
            return new zze(status, null);
        }
    }

    public zzy(DriveId driveId) {
        super(driveId);
    }

    private int zza(DriveContents driveContents, com.google.android.gms.drive.metadata.internal.zzi zziVar) {
        if (driveContents == null) {
            return (zziVar == null || !zziVar.zztI()) ? 1 : 0;
        }
        int requestId = driveContents.zzsx().getRequestId();
        driveContents.zzsy();
        return requestId;
    }

    private PendingResult zza(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet, final int i, final com.google.android.gms.drive.zzh zzhVar) {
        com.google.android.gms.drive.metadata.internal.zzi zziVarZzdd = com.google.android.gms.drive.metadata.internal.zzi.zzdd(metadataChangeSet.getMimeType());
        final int i2 = (zziVarZzdd == null || !zziVarZzdd.zztI()) ? 0 : 1;
        return googleApiClient.zzb(new zzd(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzy.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                metadataChangeSet.zzsL().setContext(zzuVar.getContext());
                zzuVar.zzte().zza(new CreateFileRequest(zzy.this.getDriveId(), metadataChangeSet.zzsL(), i, i2, zzhVar), new zza(this));
            }
        });
    }

    private MetadataChangeSet zza(MetadataChangeSet metadataChangeSet, String str) {
        return metadataChangeSet.zza(zznm.zzatE, str);
    }

    private Query zza(Query query) {
        Query.Builder builderAddFilter = new Query.Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                builderAddFilter.addFilter(query.getFilter());
            }
            builderAddFilter.setPageToken(query.getPageToken());
            builderAddFilter.setSortOrder(query.getSortOrder());
        }
        return builderAddFilter.build();
    }

    private void zzb(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, com.google.android.gms.drive.zzh zzhVar) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        com.google.android.gms.drive.metadata.internal.zzi zziVarZzdd = com.google.android.gms.drive.metadata.internal.zzi.zzdd(metadataChangeSet.getMimeType());
        if (zziVarZzdd != null && zziVarZzdd.isFolder()) {
            throw new IllegalArgumentException("May not create folders using this method. Use DriveFolder.createFolder() instead of mime type application/vnd.google-apps.folder");
        }
        zzhVar.zzg(googleApiClient);
        if (driveContents == null) {
            return;
        }
        if (!(driveContents instanceof zzv)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        }
        if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        }
        if (driveContents.zzsz()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        }
    }

    private void zzb(MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        com.google.android.gms.drive.metadata.internal.zzi zziVarZzdd = com.google.android.gms.drive.metadata.internal.zzi.zzdd(metadataChangeSet.getMimeType());
        if (zziVarZzdd != null && !zziVarZzdd.zztH()) {
            throw new IllegalArgumentException("May not create shortcut files using this method. Use DriveFolder.createShortcutFile() instead.");
        }
    }

    @Override // com.google.android.gms.drive.DriveFolder
    public PendingResult createFile(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents) {
        zzb(metadataChangeSet);
        return zza(googleApiClient, metadataChangeSet, driveContents, (com.google.android.gms.drive.zzh) null);
    }

    @Override // com.google.android.gms.drive.DriveFolder
    public PendingResult createFile(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        zzb(metadataChangeSet);
        return zza(googleApiClient, metadataChangeSet, driveContents, com.google.android.gms.drive.zzh.zza(executionOptions));
    }

    @Override // com.google.android.gms.drive.DriveFolder
    public PendingResult createFolder(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        if (metadataChangeSet.getMimeType() == null || metadataChangeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return googleApiClient.zzb(new zzf(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzy.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
                public void zza(zzu zzuVar) {
                    metadataChangeSet.zzsL().setContext(zzuVar.getContext());
                    zzuVar.zzte().zza(new CreateFolderRequest(zzy.this.getDriveId(), metadataChangeSet.zzsL()), new zzb(this));
                }
            });
        }
        throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
    }

    @Override // com.google.android.gms.drive.DriveFolder
    public PendingResult listChildren(GoogleApiClient googleApiClient) {
        return queryChildren(googleApiClient, null);
    }

    @Override // com.google.android.gms.drive.DriveFolder
    public PendingResult queryChildren(GoogleApiClient googleApiClient, Query query) {
        return new zzs().query(googleApiClient, zza(query));
    }

    public PendingResult zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, com.google.android.gms.drive.zzh zzhVar) {
        if (zzhVar == null) {
            zzhVar = new zzh.zza().build();
        }
        zzb(googleApiClient, metadataChangeSet, driveContents, zzhVar);
        int iZza = zza(driveContents, com.google.android.gms.drive.metadata.internal.zzi.zzdd(metadataChangeSet.getMimeType()));
        String strZzsG = zzhVar.zzsG();
        if (strZzsG != null) {
            metadataChangeSet = zza(metadataChangeSet, strZzsG);
        }
        return zza(googleApiClient, metadataChangeSet, iZza, zzhVar);
    }
}
