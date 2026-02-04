package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class Bucket implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzc();
    public static final int TYPE_ACTIVITY_SEGMENT = 4;
    public static final int TYPE_ACTIVITY_TYPE = 3;
    public static final int TYPE_SESSION = 2;
    public static final int TYPE_TIME = 1;
    private final int mVersionCode;
    private final long zzRD;
    private final long zzavV;
    private final Session zzavX;
    private final int zzawf;
    private final List zzawg;
    private final int zzawh;
    private boolean zzawi;

    Bucket(int i, long j, long j2, Session session, int i2, List list, int i3, boolean z) {
        this.zzawi = false;
        this.mVersionCode = i;
        this.zzRD = j;
        this.zzavV = j2;
        this.zzavX = session;
        this.zzawf = i2;
        this.zzawg = list;
        this.zzawh = i3;
        this.zzawi = z;
    }

    public Bucket(RawBucket rawBucket, List list) {
        this(2, rawBucket.zzRD, rawBucket.zzavV, rawBucket.zzavX, rawBucket.zzaxf, zza(rawBucket.zzawg, list), rawBucket.zzawh, rawBucket.zzawi);
    }

    private static List zza(Collection collection, List list) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new DataSet((RawDataSet) it.next(), list));
        }
        return arrayList;
    }

    private boolean zza(Bucket bucket) {
        return this.zzRD == bucket.zzRD && this.zzavV == bucket.zzavV && this.zzawf == bucket.zzawf && zzw.equal(this.zzawg, bucket.zzawg) && this.zzawh == bucket.zzawh && this.zzawi == bucket.zzawi;
    }

    public static String zzeM(int i) {
        switch (i) {
            case 0:
                return "unknown";
            case 1:
                return "time";
            case 2:
                return "session";
            case 3:
                return "type";
            case 4:
                return "segment";
            default:
                return "bug";
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Bucket) && zza((Bucket) obj));
    }

    public String getActivity() {
        return FitnessActivities.getName(this.zzawf);
    }

    public int getBucketType() {
        return this.zzawh;
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzawg) {
            if (dataSet.getDataType().equals(dataType)) {
                return dataSet;
            }
        }
        return null;
    }

    public List getDataSets() {
        return this.zzawg;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzavV, TimeUnit.MILLISECONDS);
    }

    public Session getSession() {
        return this.zzavX;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzRD, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), Integer.valueOf(this.zzawf), Integer.valueOf(this.zzawh));
    }

    public String toString() {
        return zzw.zzy(this).zzg("startTime", Long.valueOf(this.zzRD)).zzg("endTime", Long.valueOf(this.zzavV)).zzg("activity", Integer.valueOf(this.zzawf)).zzg("dataSets", this.zzawg).zzg("bucketType", zzeM(this.zzawh)).zzg("serverHasMoreData", Boolean.valueOf(this.zzawi)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public boolean zzb(Bucket bucket) {
        return this.zzRD == bucket.zzRD && this.zzavV == bucket.zzavV && this.zzawf == bucket.zzawf && this.zzawh == bucket.zzawh;
    }

    public long zzlO() {
        return this.zzRD;
    }

    public int zzub() {
        return this.zzawf;
    }

    public boolean zzuc() {
        if (this.zzawi) {
            return true;
        }
        Iterator it = this.zzawg.iterator();
        while (it.hasNext()) {
            if (((DataSet) it.next()).zzuc()) {
                return true;
            }
        }
        return false;
    }

    public long zzud() {
        return this.zzavV;
    }
}
