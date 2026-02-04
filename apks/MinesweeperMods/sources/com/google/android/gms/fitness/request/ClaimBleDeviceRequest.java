package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.zzow;

/* loaded from: classes2.dex */
public class ClaimBleDeviceRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    private final String zzaAB;
    private final BleDevice zzaAC;
    private final zzow zzaAD;

    ClaimBleDeviceRequest(int i, String str, BleDevice bleDevice, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaAB = str;
        this.zzaAC = bleDevice;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    public ClaimBleDeviceRequest(String str, BleDevice bleDevice, zzow zzowVar) {
        this.mVersionCode = 4;
        this.zzaAB = str;
        this.zzaAC = bleDevice;
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
        return String.format("ClaimBleDeviceRequest{%s %s}", this.zzaAB, this.zzaAC);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public BleDevice zzuK() {
        return this.zzaAC;
    }
}
