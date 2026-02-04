package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;

/* loaded from: classes2.dex */
public final class QuestsImpl implements Quests {

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl$5, reason: invalid class name */
    class AnonymousClass5 extends LoadsImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int[] zzaGY;
        final /* synthetic */ int zzaGl;
        final /* synthetic */ String zzaHa;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaHa, this.zzaGY, this.zzaGl, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl$6, reason: invalid class name */
    class AnonymousClass6 extends LoadsImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String[] zzaGZ;
        final /* synthetic */ String zzaHa;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaHa, this.zzaFO, this.zzaGZ);
        }
    }

    abstract class AcceptImpl extends Games.BaseGamesApiMethodImpl {
        private AcceptImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaw, reason: merged with bridge method [inline-methods] */
        public Quests.AcceptQuestResult zzc(final Status status) {
            return new Quests.AcceptQuestResult() { // from class: com.google.android.gms.games.internal.api.QuestsImpl.AcceptImpl.1
                @Override // com.google.android.gms.games.quest.Quests.AcceptQuestResult
                public Quest getQuest() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class ClaimImpl extends Games.BaseGamesApiMethodImpl {
        private ClaimImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzax, reason: merged with bridge method [inline-methods] */
        public Quests.ClaimMilestoneResult zzc(final Status status) {
            return new Quests.ClaimMilestoneResult() { // from class: com.google.android.gms.games.internal.api.QuestsImpl.ClaimImpl.1
                @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
                public Milestone getMilestone() {
                    return null;
                }

                @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
                public Quest getQuest() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class LoadsImpl extends Games.BaseGamesApiMethodImpl {
        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzay, reason: merged with bridge method [inline-methods] */
        public Quests.LoadQuestsResult zzc(final Status status) {
            return new Quests.LoadQuestsResult() { // from class: com.google.android.gms.games.internal.api.QuestsImpl.LoadsImpl.1
                @Override // com.google.android.gms.games.quest.Quests.LoadQuestsResult
                public QuestBuffer getQuests() {
                    return new QuestBuffer(DataHolder.zzbI(status.getStatusCode()));
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

    @Override // com.google.android.gms.games.quest.Quests
    public final PendingResult accept(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new AcceptImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.QuestsImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzh(this, str);
            }
        });
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final PendingResult claim(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new ClaimImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.QuestsImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzb(this, str, str2);
            }
        });
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final Intent getQuestIntent(GoogleApiClient googleApiClient, String str) {
        return Games.zzh(googleApiClient).zzdI(str);
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final Intent getQuestsIntent(GoogleApiClient googleApiClient, int[] iArr) {
        return Games.zzh(googleApiClient).zzb(iArr);
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final PendingResult load(GoogleApiClient googleApiClient, final int[] iArr, final int i, final boolean z) {
        return googleApiClient.zza(new LoadsImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.QuestsImpl.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, iArr, i, z);
            }
        });
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final PendingResult loadByIds(GoogleApiClient googleApiClient, final boolean z, final String... strArr) {
        return googleApiClient.zza(new LoadsImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.QuestsImpl.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzb(this, z, strArr);
            }
        });
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final void registerQuestUpdateListener(GoogleApiClient googleApiClient, QuestUpdateListener questUpdateListener) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(googleApiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzc(googleApiClient.zzr(questUpdateListener));
        }
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final void showStateChangedPopup(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(googleApiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzdJ(str);
        }
    }

    @Override // com.google.android.gms.games.quest.Quests
    public final void unregisterQuestUpdateListener(GoogleApiClient googleApiClient) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(googleApiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzwF();
        }
    }
}
