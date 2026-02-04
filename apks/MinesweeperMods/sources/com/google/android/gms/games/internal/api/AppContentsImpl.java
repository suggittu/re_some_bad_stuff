package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.internal.GamesClientImpl;

/* loaded from: classes2.dex */
public final class AppContentsImpl implements AppContents {

    /* renamed from: com.google.android.gms.games.internal.api.AppContentsImpl$1, reason: invalid class name */
    class AnonymousClass1 extends LoadsImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaFW;
        final /* synthetic */ String zzaFX;
        final /* synthetic */ String[] zzaFY;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza(this, this.zzaFW, this.zzaFX, this.zzaFY, this.zzaFO);
        }
    }

    abstract class LoadsImpl extends Games.BaseGamesApiMethodImpl {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzae, reason: merged with bridge method [inline-methods] */
        public AppContents.LoadAppContentResult zzc(final Status status) {
            return new AppContents.LoadAppContentResult() { // from class: com.google.android.gms.games.internal.api.AppContentsImpl.LoadsImpl.1
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
}
