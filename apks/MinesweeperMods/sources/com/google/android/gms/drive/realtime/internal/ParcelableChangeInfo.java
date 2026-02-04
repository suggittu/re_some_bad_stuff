package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public class ParcelableChangeInfo implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzp();
    final int mVersionCode;
    final long zzaez;
    final List zzpH;

    ParcelableChangeInfo(int i, long j, List list) {
        this.mVersionCode = i;
        this.zzaez = j;
        this.zzpH = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
