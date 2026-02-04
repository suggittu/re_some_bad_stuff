package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

/* loaded from: classes2.dex */
public final class TurnBasedMatchBuffer extends zzf {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected final String zzqg() {
        return "external_match_id";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* renamed from: zzs, reason: merged with bridge method [inline-methods] */
    public final TurnBasedMatch zzk(int i, int i2) {
        return new TurnBasedMatchRef(this.zzahi, i, i2);
    }
}
