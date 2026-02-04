package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.GamesClientImpl;

/* loaded from: classes2.dex */
public final class AchievementsImpl implements Achievements {

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl$10, reason: invalid class name */
    class AnonymousClass10 extends LoadImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzacQ;

        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb(this, this.zzacQ, this.zzaFQ, this.zzaFO);
        }
    }

    abstract class LoadImpl extends Games.BaseGamesApiMethodImpl {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzZ, reason: merged with bridge method [inline-methods] */
        public Achievements.LoadAchievementsResult zzc(final Status status) {
            return new Achievements.LoadAchievementsResult() { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.LoadImpl.1
                @Override // com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult
                public AchievementBuffer getAchievements() {
                    return new AchievementBuffer(DataHolder.zzbI(14));
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

    abstract class UpdateImpl extends Games.BaseGamesApiMethodImpl {
        private final String zzyv;

        public UpdateImpl(String str, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzyv = str;
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaa, reason: merged with bridge method [inline-methods] */
        public Achievements.UpdateAchievementResult zzc(final Status status) {
            return new Achievements.UpdateAchievementResult() { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.UpdateImpl.1
                @Override // com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
                public String getAchievementId() {
                    return UpdateImpl.this.zzyv;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final Intent getAchievementsIntent(GoogleApiClient googleApiClient) {
        return Games.zzh(googleApiClient).zzwA();
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final void increment(GoogleApiClient googleApiClient, final String str, final int i) {
        googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.6
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zza.zzb) null, str, i);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final PendingResult incrementImmediate(GoogleApiClient googleApiClient, final String str, final int i) {
        return googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.7
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, str, i);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final PendingResult load(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new LoadImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.1
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzc(this, z);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final void reveal(GoogleApiClient googleApiClient, final String str) {
        googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.2
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zza.zzb) null, str);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final PendingResult revealImmediate(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.3
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, str);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final void setSteps(GoogleApiClient googleApiClient, final String str, final int i) {
        googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.8
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzb((zza.zzb) null, str, i);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final PendingResult setStepsImmediate(GoogleApiClient googleApiClient, final String str, final int i) {
        return googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.9
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzb(this, str, i);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final void unlock(GoogleApiClient googleApiClient, final String str) {
        googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.4
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzb((zza.zzb) null, str);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final PendingResult unlockImmediate(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new UpdateImpl(str, googleApiClient) { // from class: com.google.android.gms.games.internal.api.AchievementsImpl.5
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzb(this, str);
            }
        });
    }
}
