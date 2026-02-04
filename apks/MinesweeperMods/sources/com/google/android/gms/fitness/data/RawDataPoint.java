package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@KeepName
/* loaded from: classes2.dex */
public final class RawDataPoint implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzo();
    final int mVersionCode;
    public final long zzawj;
    public final long zzawk;
    public final Value[] zzawl;
    public final long zzawn;
    public final long zzawo;
    public final int zzaxg;
    public final int zzaxh;

    public RawDataPoint(int i, long j, long j2, Value[] valueArr, int i2, int i3, long j3, long j4) {
        this.mVersionCode = i;
        this.zzawj = j;
        this.zzawk = j2;
        this.zzaxg = i2;
        this.zzaxh = i3;
        this.zzawn = j3;
        this.zzawo = j4;
        this.zzawl = valueArr;
    }

    RawDataPoint(DataPoint dataPoint, List list) {
        this.mVersionCode = 4;
        this.zzawj = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
        this.zzawk = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
        this.zzawl = dataPoint.zzuf();
        this.zzaxg = zzt.zza(dataPoint.getDataSource(), list);
        this.zzaxh = zzt.zza(dataPoint.getOriginalDataSource(), list);
        this.zzawn = dataPoint.zzug();
        this.zzawo = dataPoint.zzuh();
    }

    private boolean zza(RawDataPoint rawDataPoint) {
        return this.zzawj == rawDataPoint.zzawj && this.zzawk == rawDataPoint.zzawk && Arrays.equals(this.zzawl, rawDataPoint.zzawl) && this.zzaxg == rawDataPoint.zzaxg && this.zzaxh == rawDataPoint.zzaxh && this.zzawn == rawDataPoint.zzawn;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawDataPoint) && zza((RawDataPoint) obj));
    }

    public final int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzawj), Long.valueOf(this.zzawk));
    }

    public final String toString() {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", Arrays.toString(this.zzawl), Long.valueOf(this.zzawk), Long.valueOf(this.zzawj), Integer.valueOf(this.zzaxg), Integer.valueOf(this.zzaxh));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
