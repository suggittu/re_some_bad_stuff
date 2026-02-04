package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;

/* loaded from: classes2.dex */
public final class AclsImpl implements Acls {

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl$2, reason: invalid class name */
    class AnonymousClass2 extends LoadNotifyAclImpl {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzj(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl$3, reason: invalid class name */
    class AnonymousClass3 extends UpdateNotifyAclImpl {
        final /* synthetic */ String zzaFV;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzn(this, this.zzaFV);
        }
    }

    abstract class LoadNotifyAclImpl extends Games.BaseGamesApiMethodImpl {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzad, reason: merged with bridge method [inline-methods] */
        public Acls.LoadAclResult zzc(Status status) {
            return AclsImpl.zzab(status);
        }
    }

    abstract class UpdateNotifyAclImpl extends Games.BaseGamesApiMethodImpl {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Acls.LoadAclResult zzab(final Status status) {
        return new Acls.LoadAclResult() { // from class: com.google.android.gms.games.internal.api.AclsImpl.1
            @Override // com.google.android.gms.common.api.Result
            public final Status getStatus() {
                return status;
            }

            @Override // com.google.android.gms.common.api.Releasable
            public final void release() {
            }
        };
    }
}
