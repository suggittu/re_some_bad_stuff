package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.drive.internal.zzt;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes2.dex */
public class zzab implements DriveResource {
    protected final DriveId zzaoz;

    class zza extends com.google.android.gms.drive.internal.zzd {
        private final zza.zzb zzamC;

        public zza(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void onError(Status status) {
            this.zzamC.zzs(new zzs.zzg(status, null, false));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void zza(OnListParentsResponse onListParentsResponse) {
            this.zzamC.zzs(new zzs.zzg(Status.zzagC, new MetadataBuffer(onListParentsResponse.zztv()), false));
        }
    }

    class zzb extends com.google.android.gms.drive.internal.zzd {
        private final zza.zzb zzamC;

        public zzb(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void onError(Status status) {
            this.zzamC.zzs(new zzc(status, null));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void zza(OnMetadataResponse onMetadataResponse) {
            this.zzamC.zzs(new zzc(Status.zzagC, new zzp(onMetadataResponse.zztw())));
        }
    }

    class zzc implements DriveResource.MetadataResult {
        private final Status zzUX;
        private final Metadata zzarA;

        public zzc(Status status, Metadata metadata) {
            this.zzUX = status;
            this.zzarA = metadata;
        }

        @Override // com.google.android.gms.drive.DriveResource.MetadataResult
        public Metadata getMetadata() {
            return this.zzarA;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    abstract class zzd extends zzt {
        private zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzH, reason: merged with bridge method [inline-methods] */
        public DriveResource.MetadataResult zzc(Status status) {
            return new zzc(status, null);
        }
    }

    public zzab(DriveId driveId) {
        this.zzaoz = driveId;
    }

    private PendingResult zza(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new zzd(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzab.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zzuVar.zzte().zza(new GetMetadataRequest(zzab.this.zzaoz, z), new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult addChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener) {
        return ((zzu) googleApiClient.zza(Drive.zzUI)).zza(googleApiClient, this.zzaoz, changeListener);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult addChangeSubscription(GoogleApiClient googleApiClient) {
        return ((zzu) googleApiClient.zza(Drive.zzUI)).zza(googleApiClient, this.zzaoz);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult delete(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzt.zza(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzab.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zzuVar.zzte().zza(new DeleteResourceRequest(zzab.this.zzaoz), new zzbu(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public DriveId getDriveId() {
        return this.zzaoz;
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult getMetadata(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, false);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult listParents(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzs.zzh(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzab.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zzuVar.zzte().zza(new ListParentsRequest(zzab.this.zzaoz), new zza(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult removeChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener) {
        return ((zzu) googleApiClient.zza(Drive.zzUI)).zzb(googleApiClient, this.zzaoz, changeListener);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult removeChangeSubscription(GoogleApiClient googleApiClient) {
        return ((zzu) googleApiClient.zza(Drive.zzUI)).zzb(googleApiClient, this.zzaoz);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult setParents(GoogleApiClient googleApiClient, Set set) {
        if (set == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        }
        final ArrayList arrayList = new ArrayList(set);
        return googleApiClient.zzb(new zzt.zza(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzab.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zzuVar.zzte().zza(new SetResourceParentsRequest(zzab.this.zzaoz, arrayList), new zzbu(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult trash(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzt.zza(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzab.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zzuVar.zzte().zza(new TrashResourceRequest(zzab.this.zzaoz), new zzbu(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult untrash(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzt.zza(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzab.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zzuVar.zzte().zza(new UntrashResourceRequest(zzab.this.zzaoz), new zzbu(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult updateMetadata(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("ChangeSet must be provided.");
        }
        return googleApiClient.zzb(new zzd(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzab.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                metadataChangeSet.zzsL().setContext(zzuVar.getContext());
                zzuVar.zzte().zza(new UpdateMetadataRequest(zzab.this.zzaoz, metadataChangeSet.zzsL()), new zzb(this));
            }
        });
    }
}
