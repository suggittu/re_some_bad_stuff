package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
/* loaded from: classes2.dex */
public class CountrySpecification implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzc();
    private final int mVersionCode;
    String zzJU;

    CountrySpecification(int i, String str) {
        this.mVersionCode = i;
        this.zzJU = str;
    }

    public CountrySpecification(String str) {
        this.mVersionCode = 1;
        this.zzJU = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.zzJU;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
