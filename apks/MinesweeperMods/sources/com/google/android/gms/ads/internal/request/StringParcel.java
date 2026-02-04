package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
/* loaded from: classes2.dex */
public class StringParcel implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzn();
    final int mVersionCode;
    String zzxG;

    StringParcel(int i, String str) {
        this.mVersionCode = i;
        this.zzxG = str;
    }

    public StringParcel(String str) {
        this.mVersionCode = 1;
        this.zzxG = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }

    public String zzgz() {
        return this.zzxG;
    }
}
