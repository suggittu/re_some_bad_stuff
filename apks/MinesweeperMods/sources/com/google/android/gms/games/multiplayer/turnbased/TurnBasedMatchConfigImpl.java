package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;

/* loaded from: classes2.dex */
public final class TurnBasedMatchConfigImpl extends TurnBasedMatchConfig {
    private final int zzaJJ;
    private final Bundle zzaJZ;
    private final String[] zzaKa;
    private final int zzaKi;

    TurnBasedMatchConfigImpl(TurnBasedMatchConfig.Builder builder) {
        this.zzaJJ = builder.zzaJJ;
        this.zzaKi = builder.zzaKi;
        this.zzaJZ = builder.zzaJZ;
        this.zzaKa = (String[]) builder.zzaJY.toArray(new String[builder.zzaJY.size()]);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public final Bundle getAutoMatchCriteria() {
        return this.zzaJZ;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public final String[] getInvitedPlayerIds() {
        return this.zzaKa;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public final int getVariant() {
        return this.zzaJJ;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public final int zzxP() {
        return this.zzaKi;
    }
}
