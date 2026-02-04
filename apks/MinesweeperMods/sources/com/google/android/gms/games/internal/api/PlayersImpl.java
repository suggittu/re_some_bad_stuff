package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.internal.GamesClientImpl;

/* loaded from: classes2.dex */
public final class PlayersImpl implements Players {

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$10, reason: invalid class name */
    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zza.zzb) this, "nearby", this.zzaFQ, this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$11, reason: invalid class name */
    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zza.zzb) this, "played_with", this.zzaFQ, this.zzaGL, false, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$12, reason: invalid class name */
    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zza.zzb) this, "played_with", this.zzaFQ, this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$13, reason: invalid class name */
    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb((zza.zzb) this, this.zzaGL, false, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$14, reason: invalid class name */
    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb((zza.zzb) this, this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$15, reason: invalid class name */
    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzc((zza.zzb) this, this.zzaGL, false, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$16, reason: invalid class name */
    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzc((zza.zzb) this, this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$17, reason: invalid class name */
    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzd(this, this.zzaGL, false, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$18, reason: invalid class name */
    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzd(this, this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$19, reason: invalid class name */
    class AnonymousClass19 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGh;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb(this, this.zzaGh, this.zzaGL, false, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$20, reason: invalid class name */
    class AnonymousClass20 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGh;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb(this, this.zzaGh, this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$21, reason: invalid class name */
    class AnonymousClass21 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaGC;
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGM;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb((zza.zzb) this, this.zzaGM, this.zzaGC, this.zzaGL, false, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$22, reason: invalid class name */
    class AnonymousClass22 extends LoadPlayersImpl {
        final /* synthetic */ String zzaGC;
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGM;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb((zza.zzb) this, this.zzaGM, this.zzaGC, this.zzaGL, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$23, reason: invalid class name */
    class AnonymousClass23 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String zzaGN;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzl(this, this.zzaGN);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$24, reason: invalid class name */
    class AnonymousClass24 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzaGN;
        final /* synthetic */ int zzaGO;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzc(this, this.zzaGN, this.zzaGO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$25, reason: invalid class name */
    class AnonymousClass25 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzaGN;
        final /* synthetic */ int zzaGO;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzd(this, this.zzaGN, this.zzaGO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$26, reason: invalid class name */
    class AnonymousClass26 extends LoadProfileSettingsResultImpl {
        final /* synthetic */ boolean zzaFO;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzg(this, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$27, reason: invalid class name */
    class AnonymousClass27 extends UpdateProfileSettingsResultImpl {
        final /* synthetic */ boolean zzaGP;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzh(this, this.zzaGP);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$3, reason: invalid class name */
    class AnonymousClass3 extends LoadPlayersImpl {
        final /* synthetic */ String[] zzaGQ;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza(this, this.zzaGQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$9, reason: invalid class name */
    class AnonymousClass9 extends LoadPlayersImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zza.zzb) this, "nearby", this.zzaFQ, this.zzaGL, false, false);
        }
    }

    abstract class LoadPlayersImpl extends Games.BaseGamesApiMethodImpl {
        private LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzas, reason: merged with bridge method [inline-methods] */
        public Players.LoadPlayersResult zzc(final Status status) {
            return new Players.LoadPlayersResult() { // from class: com.google.android.gms.games.internal.api.PlayersImpl.LoadPlayersImpl.1
                @Override // com.google.android.gms.games.Players.LoadPlayersResult
                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.zzbI(14));
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

    abstract class LoadProfileSettingsResultImpl extends Games.BaseGamesApiMethodImpl {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzat, reason: merged with bridge method [inline-methods] */
        public Players.LoadProfileSettingsResult zzc(final Status status) {
            return new Players.LoadProfileSettingsResult() { // from class: com.google.android.gms.games.internal.api.PlayersImpl.LoadProfileSettingsResultImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class LoadXpForGameCategoriesResultImpl extends Games.BaseGamesApiMethodImpl {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzau, reason: merged with bridge method [inline-methods] */
        public Players.LoadXpForGameCategoriesResult zzc(final Status status) {
            return new Players.LoadXpForGameCategoriesResult() { // from class: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpForGameCategoriesResultImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class LoadXpStreamResultImpl extends Games.BaseGamesApiMethodImpl {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzav, reason: merged with bridge method [inline-methods] */
        public Players.LoadXpStreamResult zzc(final Status status) {
            return new Players.LoadXpStreamResult() { // from class: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpStreamResultImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class UpdateProfileSettingsResultImpl extends Games.BaseGamesApiMethodImpl {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.games.Players
    public final Intent getCompareProfileIntent(GoogleApiClient googleApiClient, Player player) {
        return Games.zzh(googleApiClient).zza(new PlayerEntity(player));
    }

    @Override // com.google.android.gms.games.Players
    public final Player getCurrentPlayer(GoogleApiClient googleApiClient) {
        return Games.zzh(googleApiClient).zzwx();
    }

    @Override // com.google.android.gms.games.Players
    public final String getCurrentPlayerId(GoogleApiClient googleApiClient) {
        return Games.zzh(googleApiClient).zzah(true);
    }

    @Override // com.google.android.gms.games.Players
    public final Intent getPlayerSearchIntent(GoogleApiClient googleApiClient) {
        return Games.zzh(googleApiClient).zzwH();
    }

    @Override // com.google.android.gms.games.Players
    public final PendingResult loadConnectedPlayers(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new LoadPlayersImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, z);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public final PendingResult loadInvitablePlayers(GoogleApiClient googleApiClient, final int i, final boolean z) {
        return googleApiClient.zza(new LoadPlayersImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zza.zzb) this, i, false, z);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public final PendingResult loadMoreInvitablePlayers(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new LoadPlayersImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zza.zzb) this, i, true, false);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public final PendingResult loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new LoadPlayersImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zza.zzb) this, "played_with", i, true, false);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public final PendingResult loadPlayer(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new LoadPlayersImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zza.zzb) this, str, false);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public final PendingResult loadPlayer(GoogleApiClient googleApiClient, final String str, final boolean z) {
        return googleApiClient.zza(new LoadPlayersImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, str, z);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public final PendingResult loadRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, final int i, final boolean z) {
        return googleApiClient.zza(new LoadPlayersImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zza.zzb) this, "played_with", i, false, z);
            }
        });
    }
}
