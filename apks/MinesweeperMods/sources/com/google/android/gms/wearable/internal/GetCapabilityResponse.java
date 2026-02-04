package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class GetCapabilityResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzai();
    public final int statusCode;
    public final int versionCode;
    public final CapabilityInfoParcelable zzbsB;

    GetCapabilityResponse(int i, int i2, CapabilityInfoParcelable capabilityInfoParcelable) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzbsB = capabilityInfoParcelable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzai.zza(this, parcel, i);
    }
}
