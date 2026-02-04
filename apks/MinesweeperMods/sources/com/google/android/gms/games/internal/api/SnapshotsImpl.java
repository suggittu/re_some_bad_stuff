package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;

/* loaded from: classes2.dex */
public final class SnapshotsImpl implements Snapshots {

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl$6, reason: invalid class name */
    class AnonymousClass6 extends LoadImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzacQ;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzc(this, this.zzacQ, this.zzaFQ, this.zzaFO);
        }
    }

    abstract class CommitImpl extends Games.BaseGamesApiMethodImpl {
        private CommitImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaD, reason: merged with bridge method [inline-methods] */
        public Snapshots.CommitSnapshotResult zzc(final Status status) {
            return new Snapshots.CommitSnapshotResult() { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.CommitImpl.1
                @Override // com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult
                public SnapshotMetadata getSnapshotMetadata() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class DeleteImpl extends Games.BaseGamesApiMethodImpl {
        private DeleteImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaE, reason: merged with bridge method [inline-methods] */
        public Snapshots.DeleteSnapshotResult zzc(final Status status) {
            return new Snapshots.DeleteSnapshotResult() { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.DeleteImpl.1
                @Override // com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult
                public String getSnapshotId() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class LoadImpl extends Games.BaseGamesApiMethodImpl {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaF, reason: merged with bridge method [inline-methods] */
        public Snapshots.LoadSnapshotsResult zzc(final Status status) {
            return new Snapshots.LoadSnapshotsResult() { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.LoadImpl.1
                @Override // com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult
                public SnapshotMetadataBuffer getSnapshots() {
                    return new SnapshotMetadataBuffer(DataHolder.zzbI(14));
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    abstract class OpenImpl extends Games.BaseGamesApiMethodImpl {
        private OpenImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaG, reason: merged with bridge method [inline-methods] */
        public Snapshots.OpenSnapshotResult zzc(final Status status) {
            return new Snapshots.OpenSnapshotResult() { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.OpenImpl.1
                @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
                public String getConflictId() {
                    return null;
                }

                @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
                public Snapshot getConflictingSnapshot() {
                    return null;
                }

                @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
                public SnapshotContents getResolutionSnapshotContents() {
                    return null;
                }

                @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
                public Snapshot getSnapshot() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult commitAndClose(GoogleApiClient googleApiClient, final Snapshot snapshot, final SnapshotMetadataChange snapshotMetadataChange) {
        return googleApiClient.zzb(new CommitImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, snapshot, snapshotMetadataChange);
            }
        });
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult delete(GoogleApiClient googleApiClient, final SnapshotMetadata snapshotMetadata) {
        return googleApiClient.zzb(new DeleteImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzi(this, snapshotMetadata.getSnapshotId());
            }
        });
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public final void discardAndClose(GoogleApiClient googleApiClient, Snapshot snapshot) {
        Games.zzh(googleApiClient).zza(snapshot);
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public final int getMaxCoverImageSize(GoogleApiClient googleApiClient) {
        return Games.zzh(googleApiClient).zzwQ();
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public final int getMaxDataSize(GoogleApiClient googleApiClient) {
        return Games.zzh(googleApiClient).zzwP();
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public final Intent getSelectSnapshotIntent(GoogleApiClient googleApiClient, String str, boolean z, boolean z2, int i) {
        return Games.zzh(googleApiClient).zza(str, z, z2, i);
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public final SnapshotMetadata getSnapshotFromBundle(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(Snapshots.EXTRA_SNAPSHOT_METADATA)) {
            return null;
        }
        return (SnapshotMetadata) bundle.getParcelable(Snapshots.EXTRA_SNAPSHOT_METADATA);
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult load(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new LoadImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzf(this, z);
            }
        });
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult open(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
        return open(googleApiClient, snapshotMetadata.getUniqueName(), false);
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult open(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata, int i) {
        return open(googleApiClient, snapshotMetadata.getUniqueName(), false, i);
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult open(GoogleApiClient googleApiClient, String str, boolean z) {
        return open(googleApiClient, str, z, -1);
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult open(GoogleApiClient googleApiClient, final String str, final boolean z, final int i) {
        return googleApiClient.zzb(new OpenImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, str, z, i);
            }
        });
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult resolveConflict(GoogleApiClient googleApiClient, String str, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        return resolveConflict(googleApiClient, str, metadata.getSnapshotId(), new SnapshotMetadataChange.Builder().fromMetadata(metadata).build(), snapshot.getSnapshotContents());
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots
    public final PendingResult resolveConflict(GoogleApiClient googleApiClient, final String str, final String str2, final SnapshotMetadataChange snapshotMetadataChange, final SnapshotContents snapshotContents) {
        return googleApiClient.zzb(new OpenImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.SnapshotsImpl.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, str, str2, snapshotMetadataChange, snapshotContents);
            }
        });
    }
}
