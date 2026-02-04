package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.internal.zzow;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class SensorRegistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzv();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzow zzaAD;
    private com.google.android.gms.fitness.data.zzk zzaBh;
    int zzaBi;
    int zzaBj;
    private final long zzaBk;
    private final long zzaBl;
    private final List zzaBm;
    private final long zzaBn;
    private final List zzaBo;
    private DataType zzavT;
    private DataSource zzavU;
    private final long zzaxo;
    private final int zzaxp;

    SensorRegistrationRequest(int i, DataSource dataSource, DataType dataType, IBinder iBinder, int i2, int i3, long j, long j2, PendingIntent pendingIntent, long j3, int i4, List list, long j4, IBinder iBinder2) {
        this.mVersionCode = i;
        this.zzavU = dataSource;
        this.zzavT = dataType;
        this.zzaBh = iBinder == null ? null : zzk.zza.zzbt(iBinder);
        this.zzaxo = j == 0 ? i2 : j;
        this.zzaBl = j3;
        this.zzaBk = j2 == 0 ? i3 : j2;
        this.zzaBm = list;
        this.mPendingIntent = pendingIntent;
        this.zzaxp = i4;
        this.zzaBo = Collections.emptyList();
        this.zzaBn = j4;
        this.zzaAD = zzow.zza.zzbR(iBinder2);
    }

    public SensorRegistrationRequest(DataSource dataSource, DataType dataType, com.google.android.gms.fitness.data.zzk zzkVar, PendingIntent pendingIntent, long j, long j2, long j3, int i, List list, List list2, long j4, zzow zzowVar) {
        this.mVersionCode = 6;
        this.zzavU = dataSource;
        this.zzavT = dataType;
        this.zzaBh = zzkVar;
        this.mPendingIntent = pendingIntent;
        this.zzaxo = j;
        this.zzaBl = j2;
        this.zzaBk = j3;
        this.zzaxp = i;
        this.zzaBm = list;
        this.zzaBo = list2;
        this.zzaBn = j4;
        this.zzaAD = zzowVar;
    }

    public SensorRegistrationRequest(SensorRequest sensorRequest, com.google.android.gms.fitness.data.zzk zzkVar, PendingIntent pendingIntent, zzow zzowVar) {
        this(sensorRequest.getDataSource(), sensorRequest.getDataType(), zzkVar, pendingIntent, sensorRequest.getSamplingRate(TimeUnit.MICROSECONDS), sensorRequest.getFastestRate(TimeUnit.MICROSECONDS), sensorRequest.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), sensorRequest.getAccuracyMode(), null, Collections.emptyList(), sensorRequest.zzvc(), zzowVar);
    }

    private boolean zzb(SensorRegistrationRequest sensorRegistrationRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.zzavU, sensorRegistrationRequest.zzavU) && com.google.android.gms.common.internal.zzw.equal(this.zzavT, sensorRegistrationRequest.zzavT) && this.zzaxo == sensorRegistrationRequest.zzaxo && this.zzaBl == sensorRegistrationRequest.zzaBl && this.zzaBk == sensorRegistrationRequest.zzaBk && this.zzaxp == sensorRegistrationRequest.zzaxp && com.google.android.gms.common.internal.zzw.equal(this.zzaBm, sensorRegistrationRequest.zzaBm);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SensorRegistrationRequest) && zzb((SensorRegistrationRequest) obj));
    }

    public int getAccuracyMode() {
        return this.zzaxp;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.zzavU, this.zzavT, this.zzaBh, Long.valueOf(this.zzaxo), Long.valueOf(this.zzaBl), Long.valueOf(this.zzaBk), Integer.valueOf(this.zzaxp), this.zzaBm);
    }

    public String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", this.zzavT, this.zzavU, Long.valueOf(this.zzaxo), Long.valueOf(this.zzaBl), Long.valueOf(this.zzaBk));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzv.zza(this, parcel, i);
    }

    public long zzuX() {
        return this.zzaBl;
    }

    public long zzuY() {
        return this.zzaBk;
    }

    public List zzuZ() {
        return this.zzaBm;
    }

    public long zzux() {
        return this.zzaxo;
    }

    public long zzva() {
        return this.zzaBn;
    }

    IBinder zzvb() {
        if (this.zzaBh == null) {
            return null;
        }
        return this.zzaBh.asBinder();
    }
}
