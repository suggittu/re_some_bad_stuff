package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public final class PaymentMethodTokenizationParameters implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzq();
    private final int mVersionCode;
    int zzbpC;
    Bundle zzbpD;

    public final class Builder {
        private Builder() {
        }

        public final Builder addParameter(String str, String str2) {
            zzx.zzh(str, "Tokenization parameter name must not be empty");
            zzx.zzh(str2, "Tokenization parameter value must not be empty");
            PaymentMethodTokenizationParameters.this.zzbpD.putString(str, str2);
            return this;
        }

        public final PaymentMethodTokenizationParameters build() {
            return PaymentMethodTokenizationParameters.this;
        }

        public final Builder setPaymentMethodTokenizationType(int i) {
            PaymentMethodTokenizationParameters.this.zzbpC = i;
            return this;
        }
    }

    private PaymentMethodTokenizationParameters() {
        this.zzbpD = new Bundle();
        this.mVersionCode = 1;
    }

    PaymentMethodTokenizationParameters(int i, int i2, Bundle bundle) {
        this.zzbpD = new Bundle();
        this.mVersionCode = i;
        this.zzbpC = i2;
        this.zzbpD = bundle;
    }

    public static Builder newBuilder() {
        PaymentMethodTokenizationParameters paymentMethodTokenizationParameters = new PaymentMethodTokenizationParameters();
        paymentMethodTokenizationParameters.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final Bundle getParameters() {
        return new Bundle(this.zzbpD);
    }

    public final int getPaymentMethodTokenizationType() {
        return this.zzbpC;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzq.zza(this, parcel, i);
    }
}
