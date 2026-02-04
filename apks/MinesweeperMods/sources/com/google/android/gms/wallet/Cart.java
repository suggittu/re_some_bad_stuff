package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class Cart implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    String zzboh;
    String zzboi;
    ArrayList zzboj;

    public final class Builder {
        private Builder() {
        }

        public final Builder addLineItem(LineItem lineItem) {
            Cart.this.zzboj.add(lineItem);
            return this;
        }

        public final Cart build() {
            return Cart.this;
        }

        public final Builder setCurrencyCode(String str) {
            Cart.this.zzboi = str;
            return this;
        }

        public final Builder setLineItems(List list) {
            Cart.this.zzboj.clear();
            Cart.this.zzboj.addAll(list);
            return this;
        }

        public final Builder setTotalPrice(String str) {
            Cart.this.zzboh = str;
            return this;
        }
    }

    Cart() {
        this.mVersionCode = 1;
        this.zzboj = new ArrayList();
    }

    Cart(int i, String str, String str2, ArrayList arrayList) {
        this.mVersionCode = i;
        this.zzboh = str;
        this.zzboi = str2;
        this.zzboj = arrayList;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getCurrencyCode() {
        return this.zzboi;
    }

    public final ArrayList getLineItems() {
        return this.zzboj;
    }

    public final String getTotalPrice() {
        return this.zzboh;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
