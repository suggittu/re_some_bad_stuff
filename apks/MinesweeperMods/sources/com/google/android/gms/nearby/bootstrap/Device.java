package com.google.android.gms.nearby.bootstrap;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public class Device implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    private final String description;
    private final String name;
    final int versionCode;
    private final String zzbaQ;
    private final byte zzbaR;

    Device(int i, String str, String str2, String str3, byte b) {
        this.versionCode = i;
        this.name = zzx.zzcM(str);
        this.description = (String) zzx.zzz(str2);
        this.zzbaQ = (String) zzx.zzz(str3);
        zzx.zzb(b <= 4, "Unknown device type");
        this.zzbaR = b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeviceId() {
        return this.zzbaQ;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + ": " + this.description + "[" + ((int) this.zzbaR) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public byte zzEb() {
        return this.zzbaR;
    }
}
