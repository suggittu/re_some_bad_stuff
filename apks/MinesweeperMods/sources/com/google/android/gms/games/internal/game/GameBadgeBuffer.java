package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes2.dex */
public final class GameBadgeBuffer extends AbstractDataBuffer {
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* renamed from: zzgy, reason: merged with bridge method [inline-methods] */
    public final GameBadge get(int i) {
        return new GameBadgeRef(this.zzahi, i);
    }
}
