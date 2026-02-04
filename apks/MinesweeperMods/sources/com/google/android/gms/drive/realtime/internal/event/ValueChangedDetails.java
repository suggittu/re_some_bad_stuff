package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class ValueChangedDetails implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzh();
    final int mVersionCode;
    final int zzauO;

    ValueChangedDetails(int i, int i2) {
        this.mVersionCode = i;
        this.zzauO = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
