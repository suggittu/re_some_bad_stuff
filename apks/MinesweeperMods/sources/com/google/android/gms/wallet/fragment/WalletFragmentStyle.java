package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public final class WalletFragmentStyle implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzc();
    final int mVersionCode;
    Bundle zzbqu;
    int zzbqv;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BuyButtonAppearance {
        public static final int ANDROID_PAY_DARK = 4;
        public static final int ANDROID_PAY_LIGHT = 5;
        public static final int ANDROID_PAY_LIGHT_WITH_BORDER = 6;

        @Deprecated
        public static final int GOOGLE_WALLET_CLASSIC = 1;

        @Deprecated
        public static final int GOOGLE_WALLET_GRAYSCALE = 2;

        @Deprecated
        public static final int GOOGLE_WALLET_MONOCHROME = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BuyButtonText {
        public static final int BUY_WITH = 5;
        public static final int DONATE_WITH = 7;
        public static final int LOGO_ONLY = 6;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Dimension {
        public static final int MATCH_PARENT = -1;
        public static final int UNIT_DIP = 1;
        public static final int UNIT_IN = 4;
        public static final int UNIT_MM = 5;
        public static final int UNIT_PT = 3;
        public static final int UNIT_PX = 0;
        public static final int UNIT_SP = 2;
        public static final int WRAP_CONTENT = -2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogoImageType {
        public static final int ANDROID_PAY = 3;

        @Deprecated
        public static final int GOOGLE_WALLET_CLASSIC = 1;

        @Deprecated
        public static final int GOOGLE_WALLET_MONOCHROME = 2;
    }

    public WalletFragmentStyle() {
        this.mVersionCode = 1;
        this.zzbqu = new Bundle();
        this.zzbqu.putInt("buyButtonAppearanceDefault", 4);
        this.zzbqu.putInt("maskedWalletDetailsLogoImageTypeDefault", 3);
    }

    WalletFragmentStyle(int i, Bundle bundle, int i2) {
        this.mVersionCode = i;
        this.zzbqu = bundle;
        this.zzbqv = i2;
    }

    private static int zza(long j, DisplayMetrics displayMetrics) {
        int i;
        int i2 = (int) (j >>> 32);
        int i3 = (int) j;
        switch (i2) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 5;
                break;
            case 128:
                return TypedValue.complexToDimensionPixelSize(i3, displayMetrics);
            case 129:
                return i3;
            default:
                throw new IllegalStateException("Unexpected unit or type: " + i2);
        }
        return Math.round(TypedValue.applyDimension(i, Float.intBitsToFloat(i3), displayMetrics));
    }

    private static long zza(int i, float f) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return zzv(i, Float.floatToIntBits(f));
            default:
                throw new IllegalArgumentException("Unrecognized unit: " + i);
        }
    }

    private static long zza(TypedValue typedValue) {
        switch (typedValue.type) {
            case 5:
                return zzv(128, typedValue.data);
            case 16:
                return zzll(typedValue.data);
            default:
                throw new IllegalArgumentException("Unexpected dimension type: " + typedValue.type);
        }
    }

    private void zza(TypedArray typedArray, int i, String str) {
        TypedValue typedValuePeekValue;
        if (this.zzbqu.containsKey(str) || (typedValuePeekValue = typedArray.peekValue(i)) == null) {
            return;
        }
        this.zzbqu.putLong(str, zza(typedValuePeekValue));
    }

    private void zza(TypedArray typedArray, int i, String str, String str2) {
        TypedValue typedValuePeekValue;
        if (this.zzbqu.containsKey(str) || this.zzbqu.containsKey(str2) || (typedValuePeekValue = typedArray.peekValue(i)) == null) {
            return;
        }
        if (typedValuePeekValue.type < 28 || typedValuePeekValue.type > 31) {
            this.zzbqu.putInt(str2, typedValuePeekValue.resourceId);
        } else {
            this.zzbqu.putInt(str, typedValuePeekValue.data);
        }
    }

    private void zzb(TypedArray typedArray, int i, String str) {
        TypedValue typedValuePeekValue;
        if (this.zzbqu.containsKey(str) || (typedValuePeekValue = typedArray.peekValue(i)) == null) {
            return;
        }
        this.zzbqu.putInt(str, typedValuePeekValue.data);
    }

    private static long zzll(int i) {
        if (i >= 0) {
            return zza(0, i);
        }
        if (i == -1 || i == -2) {
            return zzv(129, i);
        }
        throw new IllegalArgumentException("Unexpected dimension value: " + i);
    }

    private static long zzv(int i, int i2) {
        return (i << 32) | (i2 & 4294967295L);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final WalletFragmentStyle setBuyButtonAppearance(int i) {
        this.zzbqu.putInt("buyButtonAppearance", i);
        return this;
    }

    public final WalletFragmentStyle setBuyButtonHeight(int i) {
        this.zzbqu.putLong("buyButtonHeight", zzll(i));
        return this;
    }

    public final WalletFragmentStyle setBuyButtonHeight(int i, float f) {
        this.zzbqu.putLong("buyButtonHeight", zza(i, f));
        return this;
    }

    public final WalletFragmentStyle setBuyButtonText(int i) {
        this.zzbqu.putInt("buyButtonText", i);
        return this;
    }

    public final WalletFragmentStyle setBuyButtonWidth(int i) {
        this.zzbqu.putLong("buyButtonWidth", zzll(i));
        return this;
    }

    public final WalletFragmentStyle setBuyButtonWidth(int i, float f) {
        this.zzbqu.putLong("buyButtonWidth", zza(i, f));
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int i) {
        this.zzbqu.remove("maskedWalletDetailsBackgroundResource");
        this.zzbqu.putInt("maskedWalletDetailsBackgroundColor", i);
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int i) {
        this.zzbqu.remove("maskedWalletDetailsBackgroundColor");
        this.zzbqu.putInt("maskedWalletDetailsBackgroundResource", i);
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int i) {
        this.zzbqu.remove("maskedWalletDetailsButtonBackgroundResource");
        this.zzbqu.putInt("maskedWalletDetailsButtonBackgroundColor", i);
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int i) {
        this.zzbqu.remove("maskedWalletDetailsButtonBackgroundColor");
        this.zzbqu.putInt("maskedWalletDetailsButtonBackgroundResource", i);
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int i) {
        this.zzbqu.putInt("maskedWalletDetailsButtonTextAppearance", i);
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int i) {
        this.zzbqu.putInt("maskedWalletDetailsHeaderTextAppearance", i);
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int i) {
        this.zzbqu.putInt("maskedWalletDetailsLogoImageType", i);
        return this;
    }

    @Deprecated
    public final WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int i) {
        this.zzbqu.putInt("maskedWalletDetailsLogoTextColor", i);
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int i) {
        this.zzbqu.putInt("maskedWalletDetailsTextAppearance", i);
        return this;
    }

    public final WalletFragmentStyle setStyleResourceId(int i) {
        this.zzbqv = i;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public final int zza(String str, DisplayMetrics displayMetrics, int i) {
        return this.zzbqu.containsKey(str) ? zza(this.zzbqu.getLong(str), displayMetrics) : i;
    }

    public final void zzbc(Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(this.zzbqv <= 0 ? R.style.WalletFragmentDefaultStyle : this.zzbqv, R.styleable.WalletFragmentStyle);
        zza(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
        zza(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
        zzb(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
        zzb(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
        zzb(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
        zzb(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
        zza(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
        zzb(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
        zza(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
        zzb(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
        zzb(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
        typedArrayObtainStyledAttributes.recycle();
    }
}
