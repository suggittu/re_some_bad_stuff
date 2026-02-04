package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class TextModuleData implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzf();
    String body;
    private final int mVersionCode;
    String zzbqO;

    TextModuleData() {
        this.mVersionCode = 1;
    }

    TextModuleData(int i, String str, String str2) {
        this.mVersionCode = i;
        this.zzbqO = str;
        this.body = str2;
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
        zzf.zza(this, parcel, i);
    }
}
