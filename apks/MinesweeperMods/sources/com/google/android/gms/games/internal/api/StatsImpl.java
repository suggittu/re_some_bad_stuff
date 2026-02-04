package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats;

/* loaded from: classes2.dex */
public final class StatsImpl implements Stats {

    abstract class LoadsImpl extends Games.BaseGamesApiMethodImpl {
        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaH, reason: merged with bridge method [inline-methods] */
        public Stats.LoadPlayerStatsResult zzc(final Status status) {
            return new Stats.LoadPlayerStatsResult() { // from class: com.google.android.gms.games.internal.api.StatsImpl.LoadsImpl.1
                @Override // com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult
                public PlayerStats getPlayerStats() {
                    return null;
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

    @Override // com.google.android.gms.games.stats.Stats
    public final PendingResult loadPlayerStats(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new LoadsImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.StatsImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zze(this, z);
            }
        });
    }
}
