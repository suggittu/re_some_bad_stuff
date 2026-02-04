package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.nearby.bootstrap.Device;

/* loaded from: classes2.dex */
public class ConnectRequest implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final String description;
    private final String name;
    private final long timeoutMillis;
    final int versionCode;
    private final byte zzbaR;
    private final Device zzbaS;
    private final zzqe zzbaT;
    private final zzqf zzbaU;
    private final zzqg zzbaV;
    private final String zzbaW;
    private final byte zzbaX;

    ConnectRequest(int i, Device device, String str, String str2, byte b, long j, String str3, byte b2, IBinder iBinder, IBinder iBinder2, IBinder iBinder3) {
        this.versionCode = i;
        this.zzbaS = (Device) zzx.zzz(device);
        this.name = zzx.zzcM(str);
        this.description = (String) zzx.zzz(str2);
        this.zzbaR = b;
        this.timeoutMillis = j;
        this.zzbaX = b2;
        this.zzbaW = str3;
        zzx.zzz(iBinder);
        this.zzbaT = zzqe.zza.zzdq(iBinder);
        zzx.zzz(iBinder2);
        this.zzbaU = zzqf.zza.zzdr(iBinder2);
        zzx.zzz(iBinder3);
        this.zzbaV = zzqg.zza.zzds(iBinder3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zza zzaVar = CREATOR;
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzbaV == null) {
            return null;
        }
        return this.zzbaV.asBinder();
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String getToken() {
        return this.zzbaW;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza zzaVar = CREATOR;
        zza.zza(this, parcel, i);
    }

    public byte zzEb() {
        return this.zzbaR;
    }

    public Device zzEd() {
        return this.zzbaS;
    }

    public long zzEe() {
        return this.timeoutMillis;
    }

    public byte zzEf() {
        return this.zzbaX;
    }

    public IBinder zzEg() {
        if (this.zzbaT == null) {
            return null;
        }
        return this.zzbaT.asBinder();
    }

    public IBinder zzEh() {
        if (this.zzbaU == null) {
            return null;
        }
        return this.zzbaU.asBinder();
    }
}
