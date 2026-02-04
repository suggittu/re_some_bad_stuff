package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.nearby.bootstrap.Device;

/* loaded from: classes2.dex */
public class SendDataRequest implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private final byte[] data;
    final int versionCode;
    private final Device zzbaS;
    private final zzqg zzbaV;

    SendDataRequest(int i, Device device, byte[] bArr, IBinder iBinder) {
        this.versionCode = i;
        this.zzbaS = (Device) zzx.zzz(device);
        this.data = (byte[]) zzx.zzz(bArr);
        zzx.zzz(iBinder);
        this.zzbaV = zzqg.zza.zzds(iBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzf zzfVar = CREATOR;
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzbaV == null) {
            return null;
        }
        return this.zzbaV.asBinder();
    }

    public byte[] getData() {
        return this.data;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf zzfVar = CREATOR;
        zzf.zza(this, parcel, i);
    }

    public Device zzEd() {
        return this.zzbaS;
    }
}
