package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

/* loaded from: classes2.dex */
public final class zzz extends com.google.android.gms.common.data.zzc implements DataEvent {
    private final int zzaDQ;

    public zzz(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaDQ = i2;
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public final DataItem getDataItem() {
        return new zzaf(this.zzahi, this.zzaje, this.zzaDQ);
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public final int getType() {
        return getInteger("event_type");
    }

    public final String toString() {
        return "DataEventRef{ type=" + (getType() == 1 ? "changed" : getType() == 2 ? "deleted" : "unknown") + ", dataitem=" + getDataItem() + " }";
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzIK, reason: merged with bridge method [inline-methods] */
    public final DataEvent freeze() {
        return new zzy(this);
    }
}
