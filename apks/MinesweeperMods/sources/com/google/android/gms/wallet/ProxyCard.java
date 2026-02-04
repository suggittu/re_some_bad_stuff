package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class ProxyCard implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzr();
    private final int mVersionCode;
    String zzbpF;
    String zzbpG;
    int zzbpH;
    int zzbpI;

    ProxyCard(int i, String str, String str2, int i2, int i3) {
        this.mVersionCode = i;
        this.zzbpF = str;
        this.zzbpG = str2;
        this.zzbpH = i2;
        this.zzbpI = i3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getCvn() {
        return this.zzbpG;
    }

    public final int getExpirationMonth() {
        return this.zzbpH;
    }

    public final int getExpirationYear() {
        return this.zzbpI;
    }

    public final String getPan() {
        return this.zzbpF;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }
}
