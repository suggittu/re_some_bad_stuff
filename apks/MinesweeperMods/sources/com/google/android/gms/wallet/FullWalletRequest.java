package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class FullWalletRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzf();
    private final int mVersionCode;
    String zzboo;
    String zzbop;
    Cart zzboz;

    public final class Builder {
        private Builder() {
        }

        public final FullWalletRequest build() {
            return FullWalletRequest.this;
        }

        public final Builder setCart(Cart cart) {
            FullWalletRequest.this.zzboz = cart;
            return this;
        }

        public final Builder setGoogleTransactionId(String str) {
            FullWalletRequest.this.zzboo = str;
            return this;
        }

        public final Builder setMerchantTransactionId(String str) {
            FullWalletRequest.this.zzbop = str;
            return this;
        }
    }

    FullWalletRequest() {
        this.mVersionCode = 1;
    }

    FullWalletRequest(int i, String str, String str2, Cart cart) {
        this.mVersionCode = i;
        this.zzboo = str;
        this.zzbop = str2;
        this.zzboz = cart;
    }

    public static Builder newBuilder() {
        FullWalletRequest fullWalletRequest = new FullWalletRequest();
        fullWalletRequest.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final Cart getCart() {
        return this.zzboz;
    }

    public final String getGoogleTransactionId() {
        return this.zzboo;
    }

    public final String getMerchantTransactionId() {
        return this.zzbop;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
