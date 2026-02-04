package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class DisconnectRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzr();
    final int mVersionCode;

    public DisconnectRequest() {
        this(1);
    }

    DisconnectRequest(int i) {
        this.mVersionCode = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }
}
