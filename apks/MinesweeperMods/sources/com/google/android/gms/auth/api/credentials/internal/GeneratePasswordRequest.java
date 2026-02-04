package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class GeneratePasswordRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzh();
    final int mVersionCode;
    private final PasswordSpecification zzVM;

    GeneratePasswordRequest(int i, PasswordSpecification passwordSpecification) {
        this.mVersionCode = i;
        this.zzVM = passwordSpecification;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public final PasswordSpecification zzmr() {
        return this.zzVM;
    }
}
