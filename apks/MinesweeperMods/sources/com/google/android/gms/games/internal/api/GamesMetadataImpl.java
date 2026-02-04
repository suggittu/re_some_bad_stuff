package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.internal.GamesClientImpl;

/* loaded from: classes2.dex */
public final class GamesMetadataImpl implements GamesMetadata {

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$2, reason: invalid class name */
    class AnonymousClass2 extends LoadGameInstancesImpl {
        final /* synthetic */ String zzaFQ;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzj(this, this.zzaFQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$3, reason: invalid class name */
    class AnonymousClass3 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String zzaGh;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzk(this, this.zzaGh);
        }
    }

    abstract class LoadGameInstancesImpl extends Games.BaseGamesApiMethodImpl {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzag, reason: merged with bridge method [inline-methods] */
        public GamesMetadata.LoadGameInstancesResult zzc(final Status status) {
            return new GamesMetadata.LoadGameInstancesResult() { // from class: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameInstancesImpl.1
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

    abstract class LoadGameSearchSuggestionsImpl extends Games.BaseGamesApiMethodImpl {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzah, reason: merged with bridge method [inline-methods] */
        public GamesMetadata.LoadGameSearchSuggestionsResult zzc(final Status status) {
            return new GamesMetadata.LoadGameSearchSuggestionsResult() { // from class: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameSearchSuggestionsImpl.1
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

    abstract class LoadGamesImpl extends Games.BaseGamesApiMethodImpl {
        private LoadGamesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzai, reason: merged with bridge method [inline-methods] */
        public GamesMetadata.LoadGamesResult zzc(final Status status) {
            return new GamesMetadata.LoadGamesResult() { // from class: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGamesImpl.1
                @Override // com.google.android.gms.games.GamesMetadata.LoadGamesResult
                public GameBuffer getGames() {
                    return new GameBuffer(DataHolder.zzbI(14));
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

    @Override // com.google.android.gms.games.GamesMetadata
    public final Game getCurrentGame(GoogleApiClient googleApiClient) {
        return Games.zzh(googleApiClient).zzwy();
    }

    @Override // com.google.android.gms.games.GamesMetadata
    public final PendingResult loadGame(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new LoadGamesImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.GamesMetadataImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zze(this);
            }
        });
    }
}
