package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public class AutocompletePredictionBuffer extends AbstractDataBuffer implements Result {
    public AutocompletePredictionBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public AutocompletePrediction get(int i) {
        return new com.google.android.gms.location.places.internal.zzb(this.zzahi, i);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return PlacesStatusCodes.zzhU(this.zzahi.getStatusCode());
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", getStatus()).toString();
    }
}
