package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzow;

/* loaded from: classes2.dex */
public class UnclaimBleDeviceRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzag();
    private final int mVersionCode;
    private final String zzaAB;
    private final zzow zzaAD;

    UnclaimBleDeviceRequest(int i, String str, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaAB = str;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    public UnclaimBleDeviceRequest(String str, zzow zzowVar) {
        this.mVersionCode = 5;
        this.zzaAB = str;
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

    public String getDeviceAddress() {
        return this.zzaAB;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("UnclaimBleDeviceRequest{%s}", this.zzaAB);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzag.zza(this, parcel, i);
    }
}
