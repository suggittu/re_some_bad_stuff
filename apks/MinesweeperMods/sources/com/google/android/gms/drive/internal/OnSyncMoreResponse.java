package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class OnSyncMoreResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzbj();
    final int mVersionCode;
    final boolean zzaqJ;

    OnSyncMoreResponse(int i, boolean z) {
        this.mVersionCode = i;
        this.zzaqJ = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbj.zza(this, parcel, i);
    }
}
