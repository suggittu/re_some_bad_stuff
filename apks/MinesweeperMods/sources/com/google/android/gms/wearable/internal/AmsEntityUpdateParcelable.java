package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class AmsEntityUpdateParcelable implements SafeParcelable, com.google.android.gms.wearable.zzb {
    public static final Parcelable.Creator CREATOR = new zzf();
    private final String mValue;
    final int mVersionCode;
    private byte zzbrF;
    private final byte zzbrG;

    AmsEntityUpdateParcelable(int i, byte b, byte b2, String str) {
        this.zzbrF = b;
        this.mVersionCode = i;
        this.zzbrG = b2;
        this.mValue = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AmsEntityUpdateParcelable amsEntityUpdateParcelable = (AmsEntityUpdateParcelable) obj;
        return this.zzbrF == amsEntityUpdateParcelable.zzbrF && this.mVersionCode == amsEntityUpdateParcelable.mVersionCode && this.zzbrG == amsEntityUpdateParcelable.zzbrG && this.mValue.equals(amsEntityUpdateParcelable.mValue);
    }

    public String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return (((((this.mVersionCode * 31) + this.zzbrF) * 31) + this.zzbrG) * 31) + this.mValue.hashCode();
    }

    public String toString() {
        return "AmsEntityUpdateParcelable{mVersionCode=" + this.mVersionCode + ", mEntityId=" + ((int) this.zzbrF) + ", mAttributeId=" + ((int) this.zzbrG) + ", mValue='" + this.mValue + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public byte zzIA() {
        return this.zzbrG;
    }

    public byte zzIz() {
        return this.zzbrF;
    }
}
