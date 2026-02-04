package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class LocationResult implements SafeParcelable {
    private final int mVersionCode;
    private final List zzaOe;
    static final List zzaOd = Collections.emptyList();
    public static final Parcelable.Creator CREATOR = new zze();

    LocationResult(int i, List list) {
        this.mVersionCode = i;
        this.zzaOe = list;
    }

    public static LocationResult create(List list) {
        if (list == null) {
            list = zzaOd;
        }
        return new LocationResult(2, list);
    }

    public static LocationResult extractResult(Intent intent) {
        if (hasResult(intent)) {
            return (LocationResult) intent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
        }
        return null;
    }

    public static boolean hasResult(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.zzaOe.size() != this.zzaOe.size()) {
            return false;
        }
        Iterator it = locationResult.zzaOe.iterator();
        Iterator it2 = this.zzaOe.iterator();
        while (it.hasNext()) {
            if (((Location) it2.next()).getTime() != ((Location) it.next()).getTime()) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    public final Location getLastLocation() {
        int size = this.zzaOe.size();
        if (size == 0) {
            return null;
        }
        return (Location) this.zzaOe.get(size - 1);
    }

    @NonNull
    public final List getLocations() {
        return this.zzaOe;
    }

    final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        int i = 17;
        Iterator it = this.zzaOe.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            long time = ((Location) it.next()).getTime();
            i = ((int) (time ^ (time >>> 32))) + (i2 * 31);
        }
    }

    public final String toString() {
        return "LocationResult[locations: " + this.zzaOe + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
