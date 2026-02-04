package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class PaymentMethodToken implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzp();
    private final int mVersionCode;
    String zzbaW;
    int zzbpC;

    private PaymentMethodToken() {
        this.mVersionCode = 1;
    }

    PaymentMethodToken(int i, int i2, String str) {
        this.mVersionCode = i;
        this.zzbpC = i2;
        this.zzbaW = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getPaymentMethodTokenizationType() {
        return this.zzbpC;
    }

    public final String getToken() {
        return this.zzbaW;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
