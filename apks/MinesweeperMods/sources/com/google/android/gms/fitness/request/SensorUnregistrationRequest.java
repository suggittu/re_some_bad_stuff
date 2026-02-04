package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.internal.zzow;

/* loaded from: classes2.dex */
public class SensorUnregistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzw();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzow zzaAD;
    private final com.google.android.gms.fitness.data.zzk zzaBh;

    SensorUnregistrationRequest(int i, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2) {
        this.mVersionCode = i;
        this.zzaBh = iBinder == null ? null : zzk.zza.zzbt(iBinder);
        this.mPendingIntent = pendingIntent;
        this.zzaAD = zzow.zza.zzbR(iBinder2);
    }

    public SensorUnregistrationRequest(com.google.android.gms.fitness.data.zzk zzkVar, PendingIntent pendingIntent, zzow zzowVar) {
        this.mVersionCode = 4;
        this.zzaBh = zzkVar;
        this.mPendingIntent = pendingIntent;
        this.zzaAD = zzowVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("SensorUnregistrationRequest{%s}", this.zzaBh);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzw.zza(this, parcel, i);
    }

    IBinder zzvb() {
        if (this.zzaBh == null) {
            return null;
        }
        return this.zzaBh.asBinder();
    }
}
