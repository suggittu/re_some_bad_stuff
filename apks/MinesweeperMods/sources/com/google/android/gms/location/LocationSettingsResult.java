package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class LocationSettingsResult implements Result, SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzg();
    private final int mVersionCode;
    private final Status zzUX;
    private final LocationSettingsStates zzaOi;

    LocationSettingsResult(int i, Status status, LocationSettingsStates locationSettingsStates) {
        this.mVersionCode = i;
        this.zzUX = status;
        this.zzaOi = locationSettingsStates;
    }

    public LocationSettingsResult(Status status) {
        this(1, status, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final LocationSettingsStates getLocationSettingsStates() {
        return this.zzaOi;
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
        zzg.zza(this, parcel, i);
    }
}
