package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class ValuesSetDetails implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzk();
    final int mIndex;
    final int mVersionCode;
    final int zzauP;
    final int zzauQ;

    ValuesSetDetails(int i, int i2, int i3, int i4) {
        this.mVersionCode = i;
        this.mIndex = i2;
        this.zzauP = i3;
        this.zzauQ = i4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
