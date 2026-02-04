package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class RequestsImpl implements Requests {

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$4, reason: invalid class name */
    class AnonymousClass4 extends SendRequestImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String[] zzaHi;
        final /* synthetic */ int zzaHj;
        final /* synthetic */ byte[] zzaHk;
        final /* synthetic */ int zzaHl;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaHi, this.zzaHj, this.zzaHk, this.zzaHl);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$5, reason: invalid class name */
    class AnonymousClass5 extends SendRequestImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String[] zzaHi;
        final /* synthetic */ int zzaHj;
        final /* synthetic */ byte[] zzaHk;
        final /* synthetic */ int zzaHl;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaHi, this.zzaHj, this.zzaHk, this.zzaHl);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$6, reason: invalid class name */
    class AnonymousClass6 extends UpdateRequestsImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaHa;
        final /* synthetic */ String[] zzaHe;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaHa, this.zzaHe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$7, reason: invalid class name */
    class AnonymousClass7 extends LoadRequestsImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGl;
        final /* synthetic */ String zzaHa;
        final /* synthetic */ int zzaHg;
        final /* synthetic */ int zzaHh;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaHa, this.zzaHg, this.zzaHh, this.zzaGl);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$8, reason: invalid class name */
    class AnonymousClass8 extends LoadRequestSummariesImpl {
        final /* synthetic */ String zzaHa;
        final /* synthetic */ int zzaHh;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzf(this, this.zzaHa, this.zzaHh);
        }
    }

    abstract class LoadRequestSummariesImpl extends Games.BaseGamesApiMethodImpl {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaz, reason: merged with bridge method [inline-methods] */
        public Requests.LoadRequestSummariesResult zzc(final Status status) {
            return new Requests.LoadRequestSummariesResult() { // from class: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestSummariesImpl.1
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

    abstract class LoadRequestsImpl extends Games.BaseGamesApiMethodImpl {
        private LoadRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaA, reason: merged with bridge method [inline-methods] */
        public Requests.LoadRequestsResult zzc(final Status status) {
            return new Requests.LoadRequestsResult() { // from class: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestsImpl.1
                @Override // com.google.android.gms.games.request.Requests.LoadRequestsResult
                public GameRequestBuffer getRequests(int i) {
                    return new GameRequestBuffer(DataHolder.zzbI(status.getStatusCode()));
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

    abstract class SendRequestImpl extends Games.BaseGamesApiMethodImpl {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaB, reason: merged with bridge method [inline-methods] */
        public Requests.SendRequestResult zzc(final Status status) {
            return new Requests.SendRequestResult() { // from class: com.google.android.gms.games.internal.api.RequestsImpl.SendRequestImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class UpdateRequestsImpl extends Games.BaseGamesApiMethodImpl {
        private UpdateRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaC, reason: merged with bridge method [inline-methods] */
        public Requests.UpdateRequestsResult zzc(final Status status) {
            return new Requests.UpdateRequestsResult() { // from class: com.google.android.gms.games.internal.api.RequestsImpl.UpdateRequestsImpl.1
                @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
                public Set getRequestIds() {
                    return null;
                }

                @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
                public int getRequestOutcome(String str) {
                    throw new IllegalArgumentException("Unknown request ID " + str);
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

    @Override // com.google.android.gms.games.request.Requests
    public final PendingResult acceptRequest(GoogleApiClient googleApiClient, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return acceptRequests(googleApiClient, arrayList);
    }

    @Override // com.google.android.gms.games.request.Requests
    public final PendingResult acceptRequests(GoogleApiClient googleApiClient, List list) {
        final String[] strArr = list == null ? null : (String[]) list.toArray(new String[list.size()]);
        return googleApiClient.zzb(new UpdateRequestsImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.RequestsImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzb(this, strArr);
            }
        });
    }

    @Override // com.google.android.gms.games.request.Requests
    public final PendingResult dismissRequest(GoogleApiClient googleApiClient, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return dismissRequests(googleApiClient, arrayList);
    }

    @Override // com.google.android.gms.games.request.Requests
    public final PendingResult dismissRequests(GoogleApiClient googleApiClient, List list) {
        final String[] strArr = list == null ? null : (String[]) list.toArray(new String[list.size()]);
        return googleApiClient.zzb(new UpdateRequestsImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.RequestsImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzc(this, strArr);
            }
        });
    }

    @Override // com.google.android.gms.games.request.Requests
    public final ArrayList getGameRequestsFromBundle(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) bundle.get(Requests.EXTRA_REQUESTS);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    @Override // com.google.android.gms.games.request.Requests
    public final ArrayList getGameRequestsFromInboxResponse(Intent intent) {
        return intent == null ? new ArrayList() : getGameRequestsFromBundle(intent.getExtras());
    }

    @Override // com.google.android.gms.games.request.Requests
    public final Intent getInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zzh(googleApiClient).zzwM();
    }

    @Override // com.google.android.gms.games.request.Requests
    public final int getMaxLifetimeDays(GoogleApiClient googleApiClient) {
        return Games.zzh(googleApiClient).zzwO();
    }

    @Override // com.google.android.gms.games.request.Requests
    public final int getMaxPayloadSize(GoogleApiClient googleApiClient) {
        return Games.zzh(googleApiClient).zzwN();
    }

    @Override // com.google.android.gms.games.request.Requests
    public final Intent getSendIntent(GoogleApiClient googleApiClient, int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        return Games.zzh(googleApiClient).zza(i, bArr, i2, bitmap, str);
    }

    @Override // com.google.android.gms.games.request.Requests
    public final PendingResult loadRequests(GoogleApiClient googleApiClient, final int i, final int i2, final int i3) {
        return googleApiClient.zza(new LoadRequestsImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.RequestsImpl.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, i, i2, i3);
            }
        });
    }

    @Override // com.google.android.gms.games.request.Requests
    public final void registerRequestListener(GoogleApiClient googleApiClient, OnRequestReceivedListener onRequestReceivedListener) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(googleApiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzd(googleApiClient.zzr(onRequestReceivedListener));
        }
    }

    @Override // com.google.android.gms.games.request.Requests
    public final void unregisterRequestListener(GoogleApiClient googleApiClient) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(googleApiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzwG();
        }
    }
}
