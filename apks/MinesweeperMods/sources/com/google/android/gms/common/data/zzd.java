package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class zzd extends AbstractDataBuffer {
    private static final String[] zzajg = {"data"};
    private final Parcelable.Creator zzajh;

    public zzd(DataHolder dataHolder, Parcelable.Creator creator) {
        super(dataHolder);
        this.zzajh = creator;
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* renamed from: zzbG, reason: merged with bridge method [inline-methods] */
    public SafeParcelable get(int i) {
        byte[] bArrZzg = this.zzahi.zzg("data", i, this.zzahi.zzbH(i));
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArrZzg, 0, bArrZzg.length);
        parcelObtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.zzajh.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return safeParcelable;
    }
}
