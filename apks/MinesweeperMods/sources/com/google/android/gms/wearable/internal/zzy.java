package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

/* loaded from: classes2.dex */
public class zzy implements DataEvent {
    private int zzabB;
    private DataItem zzbsv;

    public zzy(DataEvent dataEvent) {
        this.zzabB = dataEvent.getType();
        this.zzbsv = (DataItem) dataEvent.getDataItem().freeze();
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public DataItem getDataItem() {
        return this.zzbsv;
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public int getType() {
        return this.zzabB;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return "DataEventEntity{ type=" + (getType() == 1 ? "changed" : getType() == 2 ? "deleted" : "unknown") + ", dataitem=" + getDataItem() + " }";
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzIK, reason: merged with bridge method [inline-methods] */
    public DataEvent freeze() {
        return this;
    }
}
