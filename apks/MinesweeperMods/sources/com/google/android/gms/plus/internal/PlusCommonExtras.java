package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

@KeepName
/* loaded from: classes2.dex */
public class PlusCommonExtras implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private final int mVersionCode;
    private String zzbeo;
    private String zzbep;

    public PlusCommonExtras() {
        this.mVersionCode = 1;
        this.zzbeo = "";
        this.zzbep = "";
    }

    PlusCommonExtras(int i, String str, String str2) {
        this.mVersionCode = i;
        this.zzbeo = str;
        this.zzbep = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.mVersionCode == plusCommonExtras.mVersionCode && zzw.equal(this.zzbeo, plusCommonExtras.zzbeo) && zzw.equal(this.zzbep, plusCommonExtras.zzbep);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.zzbeo, this.zzbep);
    }

    public String toString() {
        return zzw.zzy(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("Gpsrc", this.zzbeo).zzg("ClientCallingPackage", this.zzbep).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public String zzFb() {
        return this.zzbeo;
    }

    public String zzFc() {
        return this.zzbep;
    }

    public void zzJ(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", com.google.android.gms.common.internal.safeparcel.zzc.zza(this));
    }
}
