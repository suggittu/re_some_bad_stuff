package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class CredentialPickerConfig implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    private final boolean mShowCancelButton;
    final int mVersionCode;
    private final boolean zzWb;
    private final boolean zzWc;

    public class Builder {
        private boolean zzWb = false;
        private boolean mShowCancelButton = true;
        private boolean zzWc = false;

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig(this);
        }

        public Builder setForNewAccount(boolean z) {
            this.zzWc = z;
            return this;
        }

        public Builder setShowAddAccountButton(boolean z) {
            this.zzWb = z;
            return this;
        }

        public Builder setShowCancelButton(boolean z) {
            this.mShowCancelButton = z;
            return this;
        }
    }

    CredentialPickerConfig(int i, boolean z, boolean z2, boolean z3) {
        this.mVersionCode = i;
        this.zzWb = z;
        this.mShowCancelButton = z2;
        this.zzWc = z3;
    }

    private CredentialPickerConfig(Builder builder) {
        this(1, builder.zzWb, builder.mShowCancelButton, builder.zzWc);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean isForNewAccount() {
        return this.zzWc;
    }

    public final boolean shouldShowAddAccountButton() {
        return this.zzWb;
    }

    public final boolean shouldShowCancelButton() {
        return this.mShowCancelButton;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
