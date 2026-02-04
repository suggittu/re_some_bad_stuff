package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class WalletFragmentOptions implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    private int mTheme;
    final int mVersionCode;
    private int zzaoy;
    private int zzbpM;
    private WalletFragmentStyle zzbqs;

    public final class Builder {
        private Builder() {
        }

        public final WalletFragmentOptions build() {
            return WalletFragmentOptions.this;
        }

        public final Builder setEnvironment(int i) {
            WalletFragmentOptions.this.zzbpM = i;
            return this;
        }

        public final Builder setFragmentStyle(int i) {
            WalletFragmentOptions.this.zzbqs = new WalletFragmentStyle().setStyleResourceId(i);
            return this;
        }

        public final Builder setFragmentStyle(WalletFragmentStyle walletFragmentStyle) {
            WalletFragmentOptions.this.zzbqs = walletFragmentStyle;
            return this;
        }

        public final Builder setMode(int i) {
            WalletFragmentOptions.this.zzaoy = i;
            return this;
        }

        public final Builder setTheme(int i) {
            WalletFragmentOptions.this.mTheme = i;
            return this;
        }
    }

    private WalletFragmentOptions() {
        this.mVersionCode = 1;
        this.zzbpM = 3;
        this.zzbqs = new WalletFragmentStyle();
    }

    WalletFragmentOptions(int i, int i2, int i3, WalletFragmentStyle walletFragmentStyle, int i4) {
        this.mVersionCode = i;
        this.zzbpM = i2;
        this.mTheme = i3;
        this.zzbqs = walletFragmentStyle;
        this.zzaoy = i4;
    }

    public static Builder newBuilder() {
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.getClass();
        return new Builder();
    }

    public static WalletFragmentOptions zzb(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WalletFragmentOptions);
        int i = typedArrayObtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_appTheme, 0);
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_environment, 1);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_fragmentMode, 1);
        typedArrayObtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.mTheme = i;
        walletFragmentOptions.zzbpM = i2;
        walletFragmentOptions.zzbqs = new WalletFragmentStyle().setStyleResourceId(resourceId);
        walletFragmentOptions.zzbqs.zzbc(context);
        walletFragmentOptions.zzaoy = i3;
        return walletFragmentOptions;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getEnvironment() {
        return this.zzbpM;
    }

    public final WalletFragmentStyle getFragmentStyle() {
        return this.zzbqs;
    }

    public final int getMode() {
        return this.zzaoy;
    }

    public final int getTheme() {
        return this.mTheme;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public final void zzbc(Context context) throws Resources.NotFoundException {
        if (this.zzbqs != null) {
            this.zzbqs.zzbc(context);
        }
    }
}
