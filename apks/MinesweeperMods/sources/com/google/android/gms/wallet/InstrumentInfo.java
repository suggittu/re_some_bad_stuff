package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class InstrumentInfo implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzh();
    private final int mVersionCode;
    private String zzboI;
    private String zzboJ;

    InstrumentInfo(int i, String str, String str2) {
        this.mVersionCode = i;
        this.zzboI = str;
        this.zzboJ = str2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getInstrumentDetails() {
        return this.zzboJ;
    }

    public final String getInstrumentType() {
        return this.zzboI;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
