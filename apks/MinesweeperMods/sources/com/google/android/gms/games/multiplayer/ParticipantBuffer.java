package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes2.dex */
public final class ParticipantBuffer extends AbstractDataBuffer {
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public final Participant get(int i) {
        return new ParticipantRef(this.zzahi, i);
    }
}
