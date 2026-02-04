package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.List;

/* loaded from: classes2.dex */
public class ParcelableEventList implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzd();
    final int mVersionCode;
    final DataHolder zzavf;
    final boolean zzavg;
    final List zzavh;
    final ParcelableChangeInfo zzavi;
    final List zzpH;

    ParcelableEventList(int i, List list, DataHolder dataHolder, boolean z, List list2, ParcelableChangeInfo parcelableChangeInfo) {
        this.mVersionCode = i;
        this.zzpH = list;
        this.zzavf = dataHolder;
        this.zzavg = z;
        this.zzavh = list2;
        this.zzavi = parcelableChangeInfo;
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
