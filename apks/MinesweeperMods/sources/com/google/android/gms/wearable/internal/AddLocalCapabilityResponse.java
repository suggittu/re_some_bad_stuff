package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class AddLocalCapabilityResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzd();
    public final int statusCode;
    public final int versionCode;

    AddLocalCapabilityResponse(int i, int i2) {
        this.versionCode = i;
        this.statusCode = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
