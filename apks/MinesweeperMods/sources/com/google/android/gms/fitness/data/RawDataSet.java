package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

@KeepName
/* loaded from: classes2.dex */
public final class RawDataSet implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzp();
    final int mVersionCode;
    public final boolean zzawi;
    public final int zzaxg;
    public final int zzaxi;
    public final List zzaxj;

    public RawDataSet(int i, int i2, int i3, List list, boolean z) {
        this.mVersionCode = i;
        this.zzaxg = i2;
        this.zzaxi = i3;
        this.zzaxj = list;
        this.zzawi = z;
    }

    public RawDataSet(DataSet dataSet, List list, List list2) {
        this.mVersionCode = 3;
        this.zzaxj = dataSet.zzv(list);
        this.zzawi = dataSet.zzuc();
        this.zzaxg = zzt.zza(dataSet.getDataSource(), list);
        this.zzaxi = zzt.zza(dataSet.getDataType(), list2);
    }

    private boolean zza(RawDataSet rawDataSet) {
        return this.zzaxg == rawDataSet.zzaxg && this.zzawi == rawDataSet.zzawi && zzw.equal(this.zzaxj, rawDataSet.zzaxj);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawDataSet) && zza((RawDataSet) obj));
    }

    public final int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaxg));
    }

    public final String toString() {
        return String.format("RawDataSet{%s@[%s]}", Integer.valueOf(this.zzaxg), this.zzaxj);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
