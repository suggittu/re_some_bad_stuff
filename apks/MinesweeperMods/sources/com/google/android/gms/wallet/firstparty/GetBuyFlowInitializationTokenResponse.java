package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class GetBuyFlowInitializationTokenResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzc();
    private final int mVersionCode;
    byte[] zzbpR;

    GetBuyFlowInitializationTokenResponse() {
        this(1, new byte[0]);
    }

    GetBuyFlowInitializationTokenResponse(int i, byte[] bArr) {
        this.mVersionCode = i;
        this.zzbpR = bArr;
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
        zzc.zza(this, parcel, i);
    }
}
