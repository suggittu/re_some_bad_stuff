package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@KeepName
/* loaded from: classes2.dex */
public final class RawBucket implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzn();
    final int mVersionCode;
    public final long zzRD;
    public final long zzavV;
    public final Session zzavX;
    public final List zzawg;
    public final int zzawh;
    public final boolean zzawi;
    public final int zzaxf;

    public RawBucket(int i, long j, long j2, Session session, int i2, List list, int i3, boolean z) {
        this.mVersionCode = i;
        this.zzRD = j;
        this.zzavV = j2;
        this.zzavX = session;
        this.zzaxf = i2;
        this.zzawg = list;
        this.zzawh = i3;
        this.zzawi = z;
    }

    public RawBucket(Bucket bucket, List list, List list2) {
        this.mVersionCode = 2;
        this.zzRD = bucket.getStartTime(TimeUnit.MILLISECONDS);
        this.zzavV = bucket.getEndTime(TimeUnit.MILLISECONDS);
        this.zzavX = bucket.getSession();
        this.zzaxf = bucket.zzub();
        this.zzawh = bucket.getBucketType();
        this.zzawi = bucket.zzuc();
        List dataSets = bucket.getDataSets();
        this.zzawg = new ArrayList(dataSets.size());
        Iterator it = dataSets.iterator();
        while (it.hasNext()) {
            this.zzawg.add(new RawDataSet((DataSet) it.next(), list, list2));
        }
    }

    private boolean zza(RawBucket rawBucket) {
        return this.zzRD == rawBucket.zzRD && this.zzavV == rawBucket.zzavV && this.zzaxf == rawBucket.zzaxf && zzw.equal(this.zzawg, rawBucket.zzawg) && this.zzawh == rawBucket.zzawh && this.zzawi == rawBucket.zzawi;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawBucket) && zza((RawBucket) obj));
    }

    public final int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), Integer.valueOf(this.zzawh));
    }

    public final String toString() {
        return zzw.zzy(this).zzg("startTime", Long.valueOf(this.zzRD)).zzg("endTime", Long.valueOf(this.zzavV)).zzg("activity", Integer.valueOf(this.zzaxf)).zzg("dataSets", this.zzawg).zzg("bucketType", Integer.valueOf(this.zzawh)).zzg("serverHasMoreData", Boolean.valueOf(this.zzawi)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }
}
