package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

/* loaded from: classes2.dex */
public final class OfferWalletObject implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzo();
    private final int mVersionCode;
    CommonWalletObject zzboB;
    String zzbpB;
    String zzio;

    OfferWalletObject() {
        this.mVersionCode = 3;
    }

    OfferWalletObject(int i, String str, String str2, CommonWalletObject commonWalletObject) {
        this.mVersionCode = i;
        this.zzbpB = str2;
        if (i < 3) {
            this.zzboB = CommonWalletObject.zzIr().zzgK(str).zzIs();
        } else {
            this.zzboB = commonWalletObject;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getId() {
        return this.zzboB.getId();
    }

    public final String getRedemptionCode() {
        return this.zzbpB;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
