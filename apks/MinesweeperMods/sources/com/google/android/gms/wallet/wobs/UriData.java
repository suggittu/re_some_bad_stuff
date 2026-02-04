package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class UriData implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzh();
    String description;
    private final int mVersionCode;
    String zzbdg;

    UriData() {
        this.mVersionCode = 1;
    }

    UriData(int i, String str, String str2) {
        this.mVersionCode = i;
        this.zzbdg = str;
        this.description = str2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
