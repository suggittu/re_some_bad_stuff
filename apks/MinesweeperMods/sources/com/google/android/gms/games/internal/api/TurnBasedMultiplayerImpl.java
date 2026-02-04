package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import java.util.List;

/* loaded from: classes2.dex */
public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl$11, reason: invalid class name */
    class AnonymousClass11 extends InitiateMatchImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaHI;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzc(this, this.zzaFQ, this.zzaHI);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl$12, reason: invalid class name */
    class AnonymousClass12 extends InitiateMatchImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaHI;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzd(this, this.zzaFQ, this.zzaHI);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl$13, reason: invalid class name */
    class AnonymousClass13 extends LoadMatchesImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaHJ;
        final /* synthetic */ int[] zzaHK;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaHJ, this.zzaHK);
        }
    }

    abstract class CancelMatchImpl extends Games.BaseGamesApiMethodImpl {
        private final String zzyv;

        public CancelMatchImpl(String str, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzyv = str;
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaI, reason: merged with bridge method [inline-methods] */
        public TurnBasedMultiplayer.CancelMatchResult zzc(final Status status) {
            return new TurnBasedMultiplayer.CancelMatchResult() { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.CancelMatchImpl.1
                @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult
                public String getMatchId() {
                    return CancelMatchImpl.this.zzyv;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class InitiateMatchImpl extends Games.BaseGamesApiMethodImpl {
        private InitiateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaJ, reason: merged with bridge method [inline-methods] */
        public TurnBasedMultiplayer.InitiateMatchResult zzc(final Status status) {
            return new TurnBasedMultiplayer.InitiateMatchResult() { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.InitiateMatchImpl.1
                @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult
                public TurnBasedMatch getMatch() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class LeaveMatchImpl extends Games.BaseGamesApiMethodImpl {
        private LeaveMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaK, reason: merged with bridge method [inline-methods] */
        public TurnBasedMultiplayer.LeaveMatchResult zzc(final Status status) {
            return new TurnBasedMultiplayer.LeaveMatchResult() { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LeaveMatchImpl.1
                @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult
                public TurnBasedMatch getMatch() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class LoadMatchImpl extends Games.BaseGamesApiMethodImpl {
        private LoadMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaL, reason: merged with bridge method [inline-methods] */
        public TurnBasedMultiplayer.LoadMatchResult zzc(final Status status) {
            return new TurnBasedMultiplayer.LoadMatchResult() { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchImpl.1
                @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult
                public TurnBasedMatch getMatch() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class LoadMatchesImpl extends Games.BaseGamesApiMethodImpl {
        private LoadMatchesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaM, reason: merged with bridge method [inline-methods] */
        public TurnBasedMultiplayer.LoadMatchesResult zzc(final Status status) {
            return new TurnBasedMultiplayer.LoadMatchesResult() { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchesImpl.1
                @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult
                public LoadMatchesResponse getMatches() {
                    return new LoadMatchesResponse(new Bundle());
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

    abstract class UpdateMatchImpl extends Games.BaseGamesApiMethodImpl {
        private UpdateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaN, reason: merged with bridge method [inline-methods] */
        public TurnBasedMultiplayer.UpdateMatchResult zzc(final Status status) {
            return new TurnBasedMultiplayer.UpdateMatchResult() { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.UpdateMatchImpl.1
                @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult
                public TurnBasedMatch getMatch() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final PendingResult acceptInvitation(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new InitiateMatchImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzd(this, str);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final PendingResult cancelMatch(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new CancelMatchImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzf(this, str);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final PendingResult createMatch(GoogleApiClient googleApiClient, final TurnBasedMatchConfig turnBasedMatchConfig) {
        return googleApiClient.zzb(new InitiateMatchImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, turnBasedMatchConfig);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final void declineInvitation(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(googleApiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzr(str, 1);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final void dismissInvitation(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(googleApiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzq(str, 1);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final void dismissMatch(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(googleApiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzdH(str);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final PendingResult finishMatch(GoogleApiClient googleApiClient, String str) {
        return finishMatch(googleApiClient, str, (byte[]) null, (ParticipantResult[]) null);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final PendingResult finishMatch(GoogleApiClient googleApiClient, String str, byte[] bArr, List list) {
        return finishMatch(googleApiClient, str, bArr, list == null ? null : (ParticipantResult[]) list.toArray(new ParticipantResult[list.size()]));
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final PendingResult finishMatch(GoogleApiClient googleApiClient, final String str, final byte[] bArr, final ParticipantResult... participantResultArr) {
        return googleApiClient.zzb(new UpdateMatchImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, str, bArr, participantResultArr);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final Intent getInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zzh(googleApiClient).zzwB();
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final int getMaxMatchDataSize(GoogleApiClient googleApiClient) {
        return Games.zzh(googleApiClient).zzwL();
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2) {
        return Games.zzh(googleApiClient).zzb(i, i2, true);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2, boolean z) {
        return Games.zzh(googleApiClient).zzb(i, i2, z);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final PendingResult leaveMatch(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new LeaveMatchImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zze(this, str);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final PendingResult leaveMatchDuringTurn(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new LeaveMatchImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, str, str2);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final PendingResult loadMatch(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new LoadMatchImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzg(this, str);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final PendingResult loadMatchesByStatus(GoogleApiClient googleApiClient, final int i, final int[] iArr) {
        return googleApiClient.zza(new LoadMatchesImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, i, iArr);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final PendingResult loadMatchesByStatus(GoogleApiClient googleApiClient, int[] iArr) {
        return loadMatchesByStatus(googleApiClient, 0, iArr);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final void registerMatchUpdateListener(GoogleApiClient googleApiClient, OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(googleApiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzb(googleApiClient.zzr(onTurnBasedMatchUpdateReceivedListener));
        }
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final PendingResult rematch(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new InitiateMatchImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzc(this, str);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final PendingResult takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2) {
        return takeTurn(googleApiClient, str, bArr, str2, (ParticipantResult[]) null);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final PendingResult takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, List list) {
        return takeTurn(googleApiClient, str, bArr, str2, list == null ? null : (ParticipantResult[]) list.toArray(new ParticipantResult[list.size()]));
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final PendingResult takeTurn(GoogleApiClient googleApiClient, final String str, final byte[] bArr, final String str2, final ParticipantResult... participantResultArr) {
        return googleApiClient.zzb(new UpdateMatchImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, str, bArr, str2, participantResultArr);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public final void unregisterMatchUpdateListener(GoogleApiClient googleApiClient) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(googleApiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzwE();
        }
    }
}
