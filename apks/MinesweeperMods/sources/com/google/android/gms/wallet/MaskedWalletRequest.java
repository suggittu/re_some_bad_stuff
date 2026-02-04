package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class MaskedWalletRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzm();
    private final int mVersionCode;
    String zzboi;
    String zzbop;
    Cart zzboz;
    boolean zzbpl;
    boolean zzbpm;
    boolean zzbpn;
    String zzbpo;
    String zzbpp;
    boolean zzbpq;
    boolean zzbpr;
    CountrySpecification[] zzbps;
    boolean zzbpt;
    boolean zzbpu;
    ArrayList zzbpv;
    PaymentMethodTokenizationParameters zzbpw;
    ArrayList zzbpx;

    public final class Builder {
        private Builder() {
        }

        public final Builder addAllowedCardNetwork(int i) {
            if (MaskedWalletRequest.this.zzbpx == null) {
                MaskedWalletRequest.this.zzbpx = new ArrayList();
            }
            MaskedWalletRequest.this.zzbpx.add(Integer.valueOf(i));
            return this;
        }

        public final Builder addAllowedCardNetworks(Collection collection) {
            if (collection != null) {
                if (MaskedWalletRequest.this.zzbpx == null) {
                    MaskedWalletRequest.this.zzbpx = new ArrayList();
                }
                MaskedWalletRequest.this.zzbpx.addAll(collection);
            }
            return this;
        }

        public final Builder addAllowedCountrySpecificationForShipping(com.google.android.gms.identity.intents.model.CountrySpecification countrySpecification) {
            if (MaskedWalletRequest.this.zzbpv == null) {
                MaskedWalletRequest.this.zzbpv = new ArrayList();
            }
            MaskedWalletRequest.this.zzbpv.add(countrySpecification);
            return this;
        }

        public final Builder addAllowedCountrySpecificationsForShipping(Collection collection) {
            if (collection != null) {
                if (MaskedWalletRequest.this.zzbpv == null) {
                    MaskedWalletRequest.this.zzbpv = new ArrayList();
                }
                MaskedWalletRequest.this.zzbpv.addAll(collection);
            }
            return this;
        }

        public final MaskedWalletRequest build() {
            return MaskedWalletRequest.this;
        }

        public final Builder setAllowDebitCard(boolean z) {
            MaskedWalletRequest.this.zzbpu = z;
            return this;
        }

        public final Builder setAllowPrepaidCard(boolean z) {
            MaskedWalletRequest.this.zzbpt = z;
            return this;
        }

        public final Builder setCart(Cart cart) {
            MaskedWalletRequest.this.zzboz = cart;
            return this;
        }

        public final Builder setCurrencyCode(String str) {
            MaskedWalletRequest.this.zzboi = str;
            return this;
        }

        public final Builder setEstimatedTotalPrice(String str) {
            MaskedWalletRequest.this.zzbpo = str;
            return this;
        }

        @Deprecated
        public final Builder setIsBillingAgreement(boolean z) {
            MaskedWalletRequest.this.zzbpr = z;
            return this;
        }

        public final Builder setMerchantName(String str) {
            MaskedWalletRequest.this.zzbpp = str;
            return this;
        }

        public final Builder setMerchantTransactionId(String str) {
            MaskedWalletRequest.this.zzbop = str;
            return this;
        }

        public final Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paymentMethodTokenizationParameters) {
            MaskedWalletRequest.this.zzbpw = paymentMethodTokenizationParameters;
            return this;
        }

        public final Builder setPhoneNumberRequired(boolean z) {
            MaskedWalletRequest.this.zzbpl = z;
            return this;
        }

        public final Builder setShippingAddressRequired(boolean z) {
            MaskedWalletRequest.this.zzbpm = z;
            return this;
        }

        @Deprecated
        public final Builder setUseMinimalBillingAddress(boolean z) {
            MaskedWalletRequest.this.zzbpn = z;
            return this;
        }
    }

    MaskedWalletRequest() {
        this.mVersionCode = 3;
        this.zzbpt = true;
        this.zzbpu = true;
    }

    MaskedWalletRequest(int i, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4, Cart cart, boolean z4, boolean z5, CountrySpecification[] countrySpecificationArr, boolean z6, boolean z7, ArrayList arrayList, PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, ArrayList arrayList2) {
        this.mVersionCode = i;
        this.zzbop = str;
        this.zzbpl = z;
        this.zzbpm = z2;
        this.zzbpn = z3;
        this.zzbpo = str2;
        this.zzboi = str3;
        this.zzbpp = str4;
        this.zzboz = cart;
        this.zzbpq = z4;
        this.zzbpr = z5;
        this.zzbps = countrySpecificationArr;
        this.zzbpt = z6;
        this.zzbpu = z7;
        this.zzbpv = arrayList;
        this.zzbpw = paymentMethodTokenizationParameters;
        this.zzbpx = arrayList2;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public final boolean allowDebitCard() {
        return this.zzbpu;
    }

    public final boolean allowPrepaidCard() {
        return this.zzbpt;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final ArrayList getAllowedCardNetworks() {
        return this.zzbpx;
    }

    public final ArrayList getAllowedCountrySpecificationsForShipping() {
        return this.zzbpv;
    }

    public final CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.zzbps;
    }

    public final Cart getCart() {
        return this.zzboz;
    }

    public final String getCurrencyCode() {
        return this.zzboi;
    }

    public final String getEstimatedTotalPrice() {
        return this.zzbpo;
    }

    public final String getMerchantName() {
        return this.zzbpp;
    }

    public final String getMerchantTransactionId() {
        return this.zzbop;
    }

    public final PaymentMethodTokenizationParameters getPaymentMethodTokenizationParameters() {
        return this.zzbpw;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Deprecated
    public final boolean isBillingAgreement() {
        return this.zzbpr;
    }

    public final boolean isPhoneNumberRequired() {
        return this.zzbpl;
    }

    public final boolean isShippingAddressRequired() {
        return this.zzbpm;
    }

    @Deprecated
    public final boolean useMinimalBillingAddress() {
        return this.zzbpn;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
