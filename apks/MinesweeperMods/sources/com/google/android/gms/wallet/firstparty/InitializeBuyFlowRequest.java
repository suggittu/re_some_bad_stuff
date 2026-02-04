package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class InitializeBuyFlowRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzf();
    private final int mVersionCode;
    byte[][] zzbpV;

    InitializeBuyFlowRequest(int i, byte[][] bArr) {
        this.mVersionCode = i;
        this.zzbpV = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
