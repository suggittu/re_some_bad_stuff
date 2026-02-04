package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes2.dex */
public final class ExperienceEventBuffer extends AbstractDataBuffer {
    public ExperienceEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* renamed from: zzgx, reason: merged with bridge method [inline-methods] */
    public final ExperienceEvent get(int i) {
        return new ExperienceEventRef(this.zzahi, i);
    }
}
