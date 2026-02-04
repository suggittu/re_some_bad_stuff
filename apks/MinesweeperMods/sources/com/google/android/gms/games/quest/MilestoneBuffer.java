package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes2.dex */
public final class MilestoneBuffer extends AbstractDataBuffer {
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public final Milestone get(int i) {
        return new MilestoneRef(this.zzahi, i);
    }
}
