package com.google.android.gms.games.internal.api;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;

/* loaded from: classes2.dex */
public final class EventsImpl implements Events {

    abstract class LoadImpl extends Games.BaseGamesApiMethodImpl {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaf, reason: merged with bridge method [inline-methods] */
        public Events.LoadEventsResult zzc(final Status status) {
            return new Events.LoadEventsResult() { // from class: com.google.android.gms.games.internal.api.EventsImpl.LoadImpl.1
                @Override // com.google.android.gms.games.event.Events.LoadEventsResult
                public EventBuffer getEvents() {
                    return new EventBuffer(DataHolder.zzbI(14));
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
        private UpdateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        public Result zzc(final Status status) {
            return new Result() { // from class: com.google.android.gms.games.internal.api.EventsImpl.UpdateImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Override // com.google.android.gms.games.event.Events
    @SuppressLint({"MissingRemoteException"})
    public final void increment(GoogleApiClient googleApiClient, final String str, final int i) {
        GamesClientImpl gamesClientImplZzc = Games.zzc(googleApiClient, false);
        if (gamesClientImplZzc == null) {
            return;
        }
        if (gamesClientImplZzc.isConnected()) {
            gamesClientImplZzc.zzp(str, i);
        } else {
            googleApiClient.zzb(new UpdateImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.EventsImpl.3
                @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
                public void zza(GamesClientImpl gamesClientImpl) {
                    gamesClientImpl.zzp(str, i);
                }
            });
        }
    }

    @Override // com.google.android.gms.games.event.Events
    public final PendingResult load(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new LoadImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.EventsImpl.2
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzd(this, z);
            }
        });
    }

    @Override // com.google.android.gms.games.event.Events
    public final PendingResult loadByIds(GoogleApiClient googleApiClient, final boolean z, final String... strArr) {
        return googleApiClient.zza(new LoadImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.EventsImpl.1
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, z, strArr);
            }
        });
    }
}
