package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes2.dex */
public final class GameSearchSuggestionBuffer extends AbstractDataBuffer {
    public GameSearchSuggestionBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* renamed from: zzgB, reason: merged with bridge method [inline-methods] */
    public final GameSearchSuggestion get(int i) {
        return new GameSearchSuggestionRef(this.zzahi, i);
    }
}
