package com.google.android.gms.games.stats;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes2.dex */
public final class PlayerStatsBuffer extends AbstractDataBuffer {
    public PlayerStatsBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* renamed from: zzgV, reason: merged with bridge method [inline-methods] */
    public final PlayerStats get(int i) {
        return new PlayerStatsRef(this.zzahi, i);
    }
}
