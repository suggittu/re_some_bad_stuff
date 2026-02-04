package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public final class LocationAvailability implements SafeParcelable {
    public static final LocationAvailabilityCreator CREATOR = new LocationAvailabilityCreator();
    private final int mVersionCode;
    int zzaNU;
    int zzaNV;
    long zzaNW;
    int zzaNX;

    LocationAvailability(int i, int i2, int i3, int i4, long j) {
        this.mVersionCode = i;
        this.zzaNX = i2;
        this.zzaNU = i3;
        this.zzaNV = i4;
        this.zzaNW = j;
    }

    public static LocationAvailability extractLocationAvailability(Intent intent) {
        if (hasLocationAvailability(intent)) {
            return (LocationAvailability) intent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
        }
        return null;
    }

    public static boolean hasLocationAvailability(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationAvailability)) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability) obj;
        return this.zzaNX == locationAvailability.zzaNX && this.zzaNU == locationAvailability.zzaNU && this.zzaNV == locationAvailability.zzaNV && this.zzaNW == locationAvailability.zzaNW;
    }

    final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaNX), Integer.valueOf(this.zzaNU), Integer.valueOf(this.zzaNV), Long.valueOf(this.zzaNW));
    }

    public final boolean isLocationAvailable() {
        return this.zzaNX < 1000;
    }

    public final String toString() {
        return "LocationAvailability[isLocationAvailable: " + isLocationAvailable() + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        LocationAvailabilityCreator.zza(this, parcel, i);
    }
}
