package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.internal.GamesClientImpl;

/* loaded from: classes2.dex */
public final class NotificationsImpl implements Notifications {

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$1, reason: invalid class name */
    class AnonymousClass1 extends Games.BaseGamesApiMethodImpl {
        final /* synthetic */ String zzaGC;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzd((zza.zzb) this, this.zzaGC, true);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzao, reason: merged with bridge method [inline-methods] */
        public Notifications.GameMuteStatusChangeResult zzc(final Status status) {
            return new Notifications.GameMuteStatusChangeResult() { // from class: com.google.android.gms.games.internal.api.NotificationsImpl.1.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$2, reason: invalid class name */
    class AnonymousClass2 extends Games.BaseGamesApiMethodImpl {
        final /* synthetic */ String zzaGC;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzd((zza.zzb) this, this.zzaGC, false);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzao, reason: merged with bridge method [inline-methods] */
        public Notifications.GameMuteStatusChangeResult zzc(final Status status) {
            return new Notifications.GameMuteStatusChangeResult() { // from class: com.google.android.gms.games.internal.api.NotificationsImpl.2.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$3, reason: invalid class name */
    class AnonymousClass3 extends Games.BaseGamesApiMethodImpl {
        final /* synthetic */ String zzaGC;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzo(this, this.zzaGC);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzap, reason: merged with bridge method [inline-methods] */
        public Notifications.GameMuteStatusLoadResult zzc(final Status status) {
            return new Notifications.GameMuteStatusLoadResult() { // from class: com.google.android.gms.games.internal.api.NotificationsImpl.3.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$4, reason: invalid class name */
    class AnonymousClass4 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean zzaFO;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzi(this, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$5, reason: invalid class name */
    class AnonymousClass5 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean zzaGG;
        final /* synthetic */ Bundle zzaGH;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza(this, this.zzaGG, this.zzaGH);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$6, reason: invalid class name */
    class AnonymousClass6 extends InboxCountImpl {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzk(this);
        }
    }

    abstract class ContactSettingLoadImpl extends Games.BaseGamesApiMethodImpl {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaq, reason: merged with bridge method [inline-methods] */
        public Notifications.ContactSettingLoadResult zzc(final Status status) {
            return new Notifications.ContactSettingLoadResult() { // from class: com.google.android.gms.games.internal.api.NotificationsImpl.ContactSettingLoadImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class ContactSettingUpdateImpl extends Games.BaseGamesApiMethodImpl {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    abstract class InboxCountImpl extends Games.BaseGamesApiMethodImpl {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzar, reason: merged with bridge method [inline-methods] */
        public Notifications.InboxCountResult zzc(final Status status) {
            return new Notifications.InboxCountResult() { // from class: com.google.android.gms.games.internal.api.NotificationsImpl.InboxCountImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Override // com.google.android.gms.games.Notifications
    public final void clear(GoogleApiClient googleApiClient, int i) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(googleApiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzgt(i);
        }
    }

    @Override // com.google.android.gms.games.Notifications
    public final void clearAll(GoogleApiClient googleApiClient) {
        clear(googleApiClient, 31);
    }
}
