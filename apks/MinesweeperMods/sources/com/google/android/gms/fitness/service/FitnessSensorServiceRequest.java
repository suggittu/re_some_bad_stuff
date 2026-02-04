package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzk;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class FitnessSensorServiceRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zza();
    public static final int UNSPECIFIED = -1;
    private final int mVersionCode;
    private final long zzaBR;
    private final long zzaBS;
    private final zzk zzaBh;
    private final DataSource zzavU;

    FitnessSensorServiceRequest(int i, DataSource dataSource, IBinder iBinder, long j, long j2) {
        this.mVersionCode = i;
        this.zzavU = dataSource;
        this.zzaBh = zzk.zza.zzbt(iBinder);
        this.zzaBR = j;
        this.zzaBS = j2;
    }

    private boolean zza(FitnessSensorServiceRequest fitnessSensorServiceRequest) {
        return zzw.equal(this.zzavU, fitnessSensorServiceRequest.zzavU) && this.zzaBR == fitnessSensorServiceRequest.zzaBR && this.zzaBS == fitnessSensorServiceRequest.zzaBS;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof FitnessSensorServiceRequest) && zza((FitnessSensorServiceRequest) obj));
    }

    public long getBatchInterval(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaBS, TimeUnit.MICROSECONDS);
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public SensorEventDispatcher getDispatcher() {
        return new zzb(this.zzaBh);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        if (this.zzaBR == -1) {
            return -1L;
        }
        return timeUnit.convert(this.zzaBR, TimeUnit.MICROSECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavU, Long.valueOf(this.zzaBR), Long.valueOf(this.zzaBS));
    }

    public String toString() {
        return String.format("FitnessSensorServiceRequest{%s}", this.zzavU);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public long zzux() {
        return this.zzaBR;
    }

    IBinder zzvb() {
        return this.zzaBh.asBinder();
    }

    public long zzvs() {
        return this.zzaBS;
    }
}
