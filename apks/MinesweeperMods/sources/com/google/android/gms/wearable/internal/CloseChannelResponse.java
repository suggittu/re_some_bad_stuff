package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class CloseChannelResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzv();
    public final int statusCode;
    public final int versionCode;

    CloseChannelResponse(int i, int i2) {
        this.versionCode = i;
        this.statusCode = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzv.zza(this, parcel, i);
    }
}
