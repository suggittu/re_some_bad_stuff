package com.google.android.gms.location.places;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzq;

/* loaded from: classes2.dex */
public class PlacePhotoMetadataBuffer extends AbstractDataBuffer {
    public PlacePhotoMetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public PlacePhotoMetadata get(int i) {
        return new zzq(this.zzahi, i);
    }
}
