package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public class PlaceAlias implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public static final PlaceAlias zzaRc = new PlaceAlias(0, "Home");
    public static final PlaceAlias zzaRd = new PlaceAlias(0, "Work");
    final int mVersionCode;
    private final String zzaRe;

    PlaceAlias(int i, String str) {
        this.mVersionCode = i;
        this.zzaRe = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlaceAlias) {
            return zzw.equal(this.zzaRe, ((PlaceAlias) obj).zzaRe);
        }
        return false;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaRe);
    }

    public String toString() {
        return zzw.zzy(this).zzg("alias", this.zzaRe).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public String zzzB() {
        return this.zzaRe;
    }
}
