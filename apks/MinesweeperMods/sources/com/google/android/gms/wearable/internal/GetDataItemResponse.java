package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class GetDataItemResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzar();
    public final int statusCode;
    public final int versionCode;
    public final DataItemParcelable zzbsJ;

    GetDataItemResponse(int i, int i2, DataItemParcelable dataItemParcelable) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzbsJ = dataItemParcelable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzar.zza(this, parcel, i);
    }
}
