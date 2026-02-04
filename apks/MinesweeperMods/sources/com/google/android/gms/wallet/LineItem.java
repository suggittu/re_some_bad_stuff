package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class LineItem implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzj();
    String description;
    private final int mVersionCode;
    String zzboL;
    String zzboM;
    int zzboN;
    String zzboh;
    String zzboi;

    public final class Builder {
        private Builder() {
        }

        public final LineItem build() {
            return LineItem.this;
        }

        public final Builder setCurrencyCode(String str) {
            LineItem.this.zzboi = str;
            return this;
        }

        public final Builder setDescription(String str) {
            LineItem.this.description = str;
            return this;
        }

        public final Builder setQuantity(String str) {
            LineItem.this.zzboL = str;
            return this;
        }

        public final Builder setRole(int i) {
            LineItem.this.zzboN = i;
            return this;
        }

        public final Builder setTotalPrice(String str) {
            LineItem.this.zzboh = str;
            return this;
        }

        public final Builder setUnitPrice(String str) {
            LineItem.this.zzboM = str;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    LineItem() {
        this.mVersionCode = 1;
        this.zzboN = 0;
    }

    LineItem(int i, String str, String str2, String str3, String str4, int i2, String str5) {
        this.mVersionCode = i;
        this.description = str;
        this.zzboL = str2;
        this.zzboM = str3;
        this.zzboh = str4;
        this.zzboN = i2;
        this.zzboi = str5;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getCurrencyCode() {
        return this.zzboi;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getQuantity() {
        return this.zzboL;
    }

    public final int getRole() {
        return this.zzboN;
    }

    public final String getTotalPrice() {
        return this.zzboh;
    }

    public final String getUnitPrice() {
        return this.zzboM;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
