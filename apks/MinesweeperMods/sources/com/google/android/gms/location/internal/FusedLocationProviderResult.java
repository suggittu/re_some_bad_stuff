package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class FusedLocationProviderResult implements Result, SafeParcelable {
    private final int mVersionCode;
    private final Status zzUX;
    public static final FusedLocationProviderResult zzaOC = new FusedLocationProviderResult(Status.zzagC);
    public static final Parcelable.Creator CREATOR = new zze();

    FusedLocationProviderResult(int i, Status status) {
        this.mVersionCode = i;
        this.zzUX = status;
    }

    public FusedLocationProviderResult(Status status) {
        this(1, status);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzUX;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
