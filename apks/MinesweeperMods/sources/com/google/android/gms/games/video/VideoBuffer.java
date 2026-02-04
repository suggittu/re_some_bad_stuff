package com.google.android.gms.games.video;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes2.dex */
public final class VideoBuffer extends AbstractDataBuffer {
    public VideoBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* renamed from: zzgX, reason: merged with bridge method [inline-methods] */
    public final VideoRef get(int i) {
        return new VideoRef(this.zzahi, i);
    }
}
