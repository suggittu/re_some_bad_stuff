package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

/* loaded from: classes2.dex */
public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zza();
    final int mVersionCode;
    private String zzVa;
    private MaskedWalletRequest zzbqc;
    private MaskedWallet zzbqd;
    private int zzbqq;

    public final class Builder {
        private Builder() {
        }

        public final WalletFragmentInitParams build() {
            zzx.zza((WalletFragmentInitParams.this.zzbqd != null && WalletFragmentInitParams.this.zzbqc == null) || (WalletFragmentInitParams.this.zzbqd == null && WalletFragmentInitParams.this.zzbqc != null), "Exactly one of MaskedWallet or MaskedWalletRequest is required");
            zzx.zza(WalletFragmentInitParams.this.zzbqq >= 0, "masked wallet request code is required and must be non-negative");
            return WalletFragmentInitParams.this;
        }

        public final Builder setAccountName(String str) {
            WalletFragmentInitParams.this.zzVa = str;
            return this;
        }

        public final Builder setMaskedWallet(MaskedWallet maskedWallet) {
            WalletFragmentInitParams.this.zzbqd = maskedWallet;
            return this;
        }

        public final Builder setMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
            WalletFragmentInitParams.this.zzbqc = maskedWalletRequest;
            return this;
        }

        public final Builder setMaskedWalletRequestCode(int i) {
            WalletFragmentInitParams.this.zzbqq = i;
            return this;
        }
    }

    private WalletFragmentInitParams() {
        this.mVersionCode = 1;
        this.zzbqq = -1;
    }

    WalletFragmentInitParams(int i, String str, MaskedWalletRequest maskedWalletRequest, int i2, MaskedWallet maskedWallet) {
        this.mVersionCode = i;
        this.zzVa = str;
        this.zzbqc = maskedWalletRequest;
        this.zzbqq = i2;
        this.zzbqd = maskedWallet;
    }

    public static Builder newBuilder() {
        WalletFragmentInitParams walletFragmentInitParams = new WalletFragmentInitParams();
        walletFragmentInitParams.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAccountName() {
        return this.zzVa;
    }

    public final MaskedWallet getMaskedWallet() {
        return this.zzbqd;
    }

    public final MaskedWalletRequest getMaskedWalletRequest() {
        return this.zzbqc;
    }

    public final int getMaskedWalletRequestCode() {
        return this.zzbqq;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
