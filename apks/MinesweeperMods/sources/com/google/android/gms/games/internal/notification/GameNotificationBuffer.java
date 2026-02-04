package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* loaded from: classes2.dex */
public final class GameNotificationBuffer extends AbstractDataBuffer {
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* renamed from: zzgD, reason: merged with bridge method [inline-methods] */
    public final GameNotification get(int i) {
        return new GameNotificationRef(this.zzahi, i);
    }
}
