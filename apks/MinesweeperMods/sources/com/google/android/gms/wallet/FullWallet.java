package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

/* loaded from: classes2.dex */
public final class FullWallet implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zze();
    private final int mVersionCode;
    String zzboo;
    String zzbop;
    ProxyCard zzboq;
    String zzbor;
    Address zzbos;
    Address zzbot;
    String[] zzbou;
    UserAddress zzbov;
    UserAddress zzbow;
    InstrumentInfo[] zzbox;
    PaymentMethodToken zzboy;

    private FullWallet() {
        this.mVersionCode = 1;
    }

    FullWallet(int i, String str, String str2, ProxyCard proxyCard, String str3, Address address, Address address2, String[] strArr, UserAddress userAddress, UserAddress userAddress2, InstrumentInfo[] instrumentInfoArr, PaymentMethodToken paymentMethodToken) {
        this.mVersionCode = i;
        this.zzboo = str;
        this.zzbop = str2;
        this.zzboq = proxyCard;
        this.zzbor = str3;
        this.zzbos = address;
        this.zzbot = address2;
        this.zzbou = strArr;
        this.zzbov = userAddress;
        this.zzbow = userAddress2;
        this.zzbox = instrumentInfoArr;
        this.zzboy = paymentMethodToken;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Deprecated
    public final Address getBillingAddress() {
        return this.zzbos;
    }

    public final UserAddress getBuyerBillingAddress() {
        return this.zzbov;
    }

    public final UserAddress getBuyerShippingAddress() {
        return this.zzbow;
    }

    public final String getEmail() {
        return this.zzbor;
    }

    public final String getGoogleTransactionId() {
        return this.zzboo;
    }

    public final InstrumentInfo[] getInstrumentInfos() {
        return this.zzbox;
    }

    public final String getMerchantTransactionId() {
        return this.zzbop;
    }

    public final String[] getPaymentDescriptions() {
        return this.zzbou;
    }

    public final PaymentMethodToken getPaymentMethodToken() {
        return this.zzboy;
    }

    public final ProxyCard getProxyCard() {
        return this.zzboq;
    }

    @Deprecated
    public final Address getShippingAddress() {
        return this.zzbot;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
