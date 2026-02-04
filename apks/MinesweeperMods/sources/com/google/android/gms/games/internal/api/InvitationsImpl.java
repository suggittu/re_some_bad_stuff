package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

/* loaded from: classes2.dex */
public final class InvitationsImpl implements Invitations {

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl$2, reason: invalid class name */
    class AnonymousClass2 extends LoadInvitationsImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGl;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zze(this, this.zzaFQ, this.zzaGl);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl$3, reason: invalid class name */
    class AnonymousClass3 extends LoadInvitationsImpl {
        final /* synthetic */ String zzaGn;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzm(this, this.zzaGn);
        }
    }

    abstract class LoadInvitationsImpl extends Games.BaseGamesApiMethodImpl {
        private LoadInvitationsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzaj, reason: merged with bridge method [inline-methods] */
        public Invitations.LoadInvitationsResult zzc(final Status status) {
            return new Invitations.LoadInvitationsResult() { // from class: com.google.android.gms.games.internal.api.InvitationsImpl.LoadInvitationsImpl.1
                @Override // com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult
                public InvitationBuffer getInvitations() {
                    return new InvitationBuffer(DataHolder.zzbI(14));
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

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public final Intent getInvitationInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zzh(googleApiClient).zzwC();
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public final PendingResult loadInvitations(GoogleApiClient googleApiClient) {
        return loadInvitations(googleApiClient, 0);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public final PendingResult loadInvitations(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new LoadInvitationsImpl(googleApiClient) { // from class: com.google.android.gms.games.internal.api.InvitationsImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(this, i);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public final void registerInvitationListener(GoogleApiClient googleApiClient, OnInvitationReceivedListener onInvitationReceivedListener) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(googleApiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zza(googleApiClient.zzr(onInvitationReceivedListener));
        }
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public final void unregisterInvitationListener(GoogleApiClient googleApiClient) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(googleApiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzwD();
        }
    }
}
