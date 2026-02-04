package com.google.android.gms.games.request;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes2.dex */
public final class GameRequestSummaryBuffer extends AbstractDataBuffer {
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* renamed from: zzgQ, reason: merged with bridge method [inline-methods] */
    public final GameRequestSummary get(int i) {
        return new GameRequestSummaryRef(this.zzahi, i);
    }
}
