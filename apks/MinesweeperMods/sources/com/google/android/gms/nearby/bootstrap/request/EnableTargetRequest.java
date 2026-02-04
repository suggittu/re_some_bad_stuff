package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqg;

/* loaded from: classes2.dex */
public class EnableTargetRequest implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private final String description;
    private final String name;
    final int versionCode;
    private final byte zzbaR;
    private final zzqe zzbaT;
    private final zzqf zzbaU;
    private final zzqg zzbaV;

    EnableTargetRequest(int i, String str, String str2, byte b, IBinder iBinder, IBinder iBinder2, IBinder iBinder3) {
        this.versionCode = i;
        this.name = zzx.zzcM(str);
        this.description = (String) zzx.zzz(str2);
        this.zzbaR = b;
        zzx.zzz(iBinder);
        this.zzbaT = zzqe.zza.zzdq(iBinder);
        zzx.zzz(iBinder2);
        this.zzbaU = zzqf.zza.zzdr(iBinder2);
        zzx.zzz(iBinder3);
        this.zzbaV = zzqg.zza.zzds(iBinder3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zze zzeVar = CREATOR;
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze zzeVar = CREATOR;
        zze.zza(this, parcel, i);
    }

    public byte zzEb() {
        return this.zzbaR;
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
