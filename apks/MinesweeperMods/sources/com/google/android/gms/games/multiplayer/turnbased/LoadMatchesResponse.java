package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

/* loaded from: classes2.dex */
public final class LoadMatchesResponse {
    private final InvitationBuffer zzaKe;
    private final TurnBasedMatchBuffer zzaKf;
    private final TurnBasedMatchBuffer zzaKg;
    private final TurnBasedMatchBuffer zzaKh;

    public LoadMatchesResponse(Bundle bundle) {
        DataHolder dataHolderZza = zza(bundle, 0);
        if (dataHolderZza != null) {
            this.zzaKe = new InvitationBuffer(dataHolderZza);
        } else {
            this.zzaKe = null;
        }
        DataHolder dataHolderZza2 = zza(bundle, 1);
        if (dataHolderZza2 != null) {
            this.zzaKf = new TurnBasedMatchBuffer(dataHolderZza2);
        } else {
            this.zzaKf = null;
        }
        DataHolder dataHolderZza3 = zza(bundle, 2);
        if (dataHolderZza3 != null) {
            this.zzaKg = new TurnBasedMatchBuffer(dataHolderZza3);
        } else {
            this.zzaKg = null;
        }
        DataHolder dataHolderZza4 = zza(bundle, 3);
        if (dataHolderZza4 != null) {
            this.zzaKh = new TurnBasedMatchBuffer(dataHolderZza4);
        } else {
            this.zzaKh = null;
        }
    }

    private static DataHolder zza(Bundle bundle, int i) {
        String strZzgw = TurnBasedMatchTurnStatus.zzgw(i);
        if (bundle.containsKey(strZzgw)) {
            return (DataHolder) bundle.getParcelable(strZzgw);
        }
        return null;
    }

    @Deprecated
    public final void close() {
        release();
    }

    public final TurnBasedMatchBuffer getCompletedMatches() {
        return this.zzaKh;
    }

    public final InvitationBuffer getInvitations() {
        return this.zzaKe;
    }

    public final TurnBasedMatchBuffer getMyTurnMatches() {
        return this.zzaKf;
    }

    public final TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.zzaKg;
    }

    public final boolean hasData() {
        if (this.zzaKe != null && this.zzaKe.getCount() > 0) {
            return true;
        }
        if (this.zzaKf != null && this.zzaKf.getCount() > 0) {
            return true;
        }
        if (this.zzaKg == null || this.zzaKg.getCount() <= 0) {
            return this.zzaKh != null && this.zzaKh.getCount() > 0;
        }
        return true;
    }

    public final void release() {
        if (this.zzaKe != null) {
            this.zzaKe.release();
        }
        if (this.zzaKf != null) {
            this.zzaKf.release();
        }
        if (this.zzaKg != null) {
            this.zzaKg.release();
        }
        if (this.zzaKh != null) {
            this.zzaKh.release();
        }
    }
}
