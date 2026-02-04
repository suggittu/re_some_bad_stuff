package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zzow;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class DataUpdateRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzm();
    private final int mVersionCode;
    private final long zzRD;
    private final zzow zzaAD;
    private final long zzavV;
    private final DataSet zzaxn;

    public class Builder {
        private long zzRD;
        private long zzavV;
        private DataSet zzaxn;

        private void zzuV() {
            com.google.android.gms.common.internal.zzx.zza(this.zzRD, "Must set a non-zero value for startTimeMillis/startTime");
            com.google.android.gms.common.internal.zzx.zza(this.zzavV, "Must set a non-zero value for endTimeMillis/endTime");
            com.google.android.gms.common.internal.zzx.zzb(this.zzaxn, "Must set the data set");
            for (DataPoint dataPoint : this.zzaxn.getDataPoints()) {
                long startTime = dataPoint.getStartTime(TimeUnit.MILLISECONDS);
                long endTime = dataPoint.getEndTime(TimeUnit.MILLISECONDS);
                com.google.android.gms.common.internal.zzx.zza(!((startTime > endTime ? 1 : (startTime == endTime ? 0 : -1)) > 0 || (((startTime > 0L ? 1 : (startTime == 0L ? 0 : -1)) != 0 && (startTime > this.zzRD ? 1 : (startTime == this.zzRD ? 0 : -1)) < 0) || (((startTime > 0L ? 1 : (startTime == 0L ? 0 : -1)) != 0 && (startTime > this.zzavV ? 1 : (startTime == this.zzavV ? 0 : -1)) > 0) || (endTime > this.zzavV ? 1 : (endTime == this.zzavV ? 0 : -1)) > 0 || (endTime > this.zzRD ? 1 : (endTime == this.zzRD ? 0 : -1)) < 0))), "Data Point's startTimeMillis %d, endTimeMillis %d should lie between timeRange provided in the request. StartTimeMillis %d, EndTimeMillis: %d", Long.valueOf(startTime), Long.valueOf(endTime), Long.valueOf(this.zzRD), Long.valueOf(this.zzavV));
            }
        }

        public DataUpdateRequest build() {
            zzuV();
            return new DataUpdateRequest(this);
        }

        public Builder setDataSet(DataSet dataSet) {
            com.google.android.gms.common.internal.zzx.zzb(dataSet, "Must set the data set");
            this.zzaxn = dataSet;
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            com.google.android.gms.common.internal.zzx.zzb(j > 0, "Invalid start time :%d", Long.valueOf(j));
            com.google.android.gms.common.internal.zzx.zzb(j2 >= j, "Invalid end time :%d", Long.valueOf(j2));
            this.zzRD = timeUnit.toMillis(j);
            this.zzavV = timeUnit.toMillis(j2);
            return this;
        }
    }

    DataUpdateRequest(int i, long j, long j2, DataSet dataSet, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzRD = j;
        this.zzavV = j2;
        this.zzaxn = dataSet;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    public DataUpdateRequest(long j, long j2, DataSet dataSet, IBinder iBinder) {
        this.mVersionCode = 1;
        this.zzRD = j;
        this.zzavV = j2;
        this.zzaxn = dataSet;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    private DataUpdateRequest(Builder builder) {
        this(builder.zzRD, builder.zzavV, builder.zzaxn, null);
    }

    public DataUpdateRequest(DataUpdateRequest dataUpdateRequest, IBinder iBinder) {
        this(dataUpdateRequest.zzlO(), dataUpdateRequest.zzud(), dataUpdateRequest.getDataSet(), iBinder);
    }

    private boolean zzb(DataUpdateRequest dataUpdateRequest) {
        return this.zzRD == dataUpdateRequest.zzRD && this.zzavV == dataUpdateRequest.zzavV && com.google.android.gms.common.internal.zzw.equal(this.zzaxn, dataUpdateRequest.zzaxn);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataUpdateRequest) && zzb((DataUpdateRequest) obj));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public DataSet getDataSet() {
        return this.zzaxn;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzavV, TimeUnit.MILLISECONDS);
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzRD, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), this.zzaxn);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg("startTimeMillis", Long.valueOf(this.zzRD)).zzg("endTimeMillis", Long.valueOf(this.zzavV)).zzg("dataSet", this.zzaxn).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    public long zzlO() {
        return this.zzRD;
    }

    public long zzud() {
        return this.zzavV;
    }
}
