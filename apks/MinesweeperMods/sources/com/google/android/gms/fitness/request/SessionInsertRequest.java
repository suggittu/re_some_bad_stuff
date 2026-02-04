package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zznw;
import com.google.android.gms.internal.zzow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class SessionInsertRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzx();
    private final int mVersionCode;
    private final zzow zzaAD;
    private final List zzaBs;
    private final Session zzavX;
    private final List zzawg;

    public class Builder {
        private Session zzavX;
        private List zzawg = new ArrayList();
        private List zzaBs = new ArrayList();
        private List zzaBt = new ArrayList();

        private void zzf(DataPoint dataPoint) {
            zzh(dataPoint);
            zzg(dataPoint);
        }

        private void zzg(DataPoint dataPoint) {
            long startTime = this.zzavX.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.zzavX.getEndTime(TimeUnit.NANOSECONDS);
            long startTime2 = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
            long endTime2 = dataPoint.getEndTime(TimeUnit.NANOSECONDS);
            if (startTime2 == 0 || endTime2 == 0) {
                return;
            }
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (endTime2 > endTime) {
                endTime2 = zzns.zza(endTime2, TimeUnit.NANOSECONDS, timeUnit);
            }
            com.google.android.gms.common.internal.zzx.zza(startTime2 >= startTime && endTime2 <= endTime, "Data point %s has start and end times outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
            if (endTime2 != dataPoint.getEndTime(TimeUnit.NANOSECONDS)) {
                Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", Long.valueOf(dataPoint.getEndTime(TimeUnit.NANOSECONDS)), Long.valueOf(endTime2), timeUnit));
                dataPoint.setTimeInterval(startTime2, endTime2, TimeUnit.NANOSECONDS);
            }
        }

        private void zzh(DataPoint dataPoint) {
            long startTime = this.zzavX.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.zzavX.getEndTime(TimeUnit.NANOSECONDS);
            long timestamp = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
            if (timestamp != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (timestamp < startTime || timestamp > endTime) {
                    timestamp = zzns.zza(timestamp, TimeUnit.NANOSECONDS, timeUnit);
                }
                com.google.android.gms.common.internal.zzx.zza(timestamp >= startTime && timestamp <= endTime, "Data point %s has time stamp outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
                if (dataPoint.getTimestamp(TimeUnit.NANOSECONDS) != timestamp) {
                    Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", Long.valueOf(dataPoint.getTimestamp(TimeUnit.NANOSECONDS)), Long.valueOf(timestamp), timeUnit));
                    dataPoint.setTimestamp(timestamp, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void zzvd() {
            Iterator it = this.zzawg.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((DataSet) it.next()).getDataPoints().iterator();
                while (it2.hasNext()) {
                    zzf((DataPoint) it2.next());
                }
            }
            Iterator it3 = this.zzaBs.iterator();
            while (it3.hasNext()) {
                zzf((DataPoint) it3.next());
            }
        }

        public Builder addAggregateDataPoint(DataPoint dataPoint) {
            com.google.android.gms.common.internal.zzx.zzb(dataPoint != null, "Must specify a valid aggregate data point.");
            DataSource dataSource = dataPoint.getDataSource();
            com.google.android.gms.common.internal.zzx.zza(!this.zzaBt.contains(dataSource), "Data set/Aggregate data point for this data source %s is already added.", dataSource);
            zznw.zze(dataPoint);
            this.zzaBt.add(dataSource);
            this.zzaBs.add(dataPoint);
            return this;
        }

        public Builder addDataSet(DataSet dataSet) {
            com.google.android.gms.common.internal.zzx.zzb(dataSet != null, "Must specify a valid data set.");
            DataSource dataSource = dataSet.getDataSource();
            com.google.android.gms.common.internal.zzx.zza(!this.zzaBt.contains(dataSource), "Data set for this data source %s is already added.", dataSource);
            com.google.android.gms.common.internal.zzx.zzb(dataSet.getDataPoints().isEmpty() ? false : true, "No data points specified in the input data set.");
            this.zzaBt.add(dataSource);
            this.zzawg.add(dataSet);
            return this;
        }

        public SessionInsertRequest build() {
            com.google.android.gms.common.internal.zzx.zza(this.zzavX != null, "Must specify a valid session.");
            com.google.android.gms.common.internal.zzx.zza(this.zzavX.getEndTime(TimeUnit.MILLISECONDS) != 0, "Must specify a valid end time, cannot insert a continuing session.");
            zzvd();
            return new SessionInsertRequest(this);
        }

        public Builder setSession(Session session) {
            this.zzavX = session;
            return this;
        }
    }

    SessionInsertRequest(int i, Session session, List list, List list2, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzavX = session;
        this.zzawg = Collections.unmodifiableList(list);
        this.zzaBs = Collections.unmodifiableList(list2);
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    public SessionInsertRequest(Session session, List list, List list2, zzow zzowVar) {
        this.mVersionCode = 3;
        this.zzavX = session;
        this.zzawg = Collections.unmodifiableList(list);
        this.zzaBs = Collections.unmodifiableList(list2);
        this.zzaAD = zzowVar;
    }

    private SessionInsertRequest(Builder builder) {
        this(builder.zzavX, builder.zzawg, builder.zzaBs, null);
    }

    public SessionInsertRequest(SessionInsertRequest sessionInsertRequest, zzow zzowVar) {
        this(sessionInsertRequest.zzavX, sessionInsertRequest.zzawg, sessionInsertRequest.zzaBs, zzowVar);
    }

    private boolean zzb(SessionInsertRequest sessionInsertRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.zzavX, sessionInsertRequest.zzavX) && com.google.android.gms.common.internal.zzw.equal(this.zzawg, sessionInsertRequest.zzawg) && com.google.android.gms.common.internal.zzw.equal(this.zzaBs, sessionInsertRequest.zzaBs);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionInsertRequest) && zzb((SessionInsertRequest) obj));
    }

    public List getAggregateDataPoints() {
        return this.zzaBs;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public List getDataSets() {
        return this.zzawg;
    }

    public Session getSession() {
        return this.zzavX;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.zzavX, this.zzawg, this.zzaBs);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg("session", this.zzavX).zzg("dataSets", this.zzawg).zzg("aggregateDataPoints", this.zzaBs).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzx.zza(this, parcel, i);
    }
}
