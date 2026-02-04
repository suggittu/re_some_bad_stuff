package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class WalletObjectMessage implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzi();
    String body;
    private final int mVersionCode;
    String zzbqO;
    TimeInterval zzbqR;
    UriData zzbqS;
    UriData zzbqT;

    WalletObjectMessage() {
        this.mVersionCode = 1;
    }

    WalletObjectMessage(int i, String str, String str2, TimeInterval timeInterval, UriData uriData, UriData uriData2) {
        this.mVersionCode = i;
        this.zzbqO = str;
        this.body = str2;
        this.zzbqR = timeInterval;
        this.zzbqS = uriData;
        this.zzbqT = uriData2;
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
        zzi.zza(this, parcel, i);
    }
}
