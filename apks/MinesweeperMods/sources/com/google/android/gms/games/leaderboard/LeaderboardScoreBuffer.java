package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes2.dex */
public final class LeaderboardScoreBuffer extends AbstractDataBuffer {
    private final LeaderboardScoreBufferHeader zzaJd;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzaJd = new LeaderboardScoreBufferHeader(dataHolder.zzpZ());
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public final LeaderboardScore get(int i) {
        return new LeaderboardScoreRef(this.zzahi, i);
    }

    public final LeaderboardScoreBufferHeader zzxJ() {
        return this.zzaJd;
    }
}
