package com.google.android.gms.location.places;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class NearbyAlertFilter extends zza implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    final int mVersionCode;
    final List zzaPj;
    final List zzaPk;
    final List zzaPl;
    final String zzaPm;
    final boolean zzaPn;
    private final Set zzaPo;
    private final Set zzaPp;
    private final Set zzaPq;

    NearbyAlertFilter(int i, @Nullable List list, @Nullable List list2, @Nullable List list3, @Nullable String str, boolean z) {
        this.mVersionCode = i;
        this.zzaPk = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzaPl = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzaPj = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzaPp = zzw(this.zzaPk);
        this.zzaPq = zzw(this.zzaPl);
        this.zzaPo = zzw(this.zzaPj);
        this.zzaPm = str;
        this.zzaPn = z;
    }

    public static NearbyAlertFilter zzh(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace ID to match results with.");
        }
        return new NearbyAlertFilter(0, zzf(collection), null, null, null, false);
    }

    public static NearbyAlertFilter zzi(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace type to match results with.");
        }
        return new NearbyAlertFilter(0, null, zzf(collection), null, null, false);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyAlertFilter)) {
            return false;
        }
        NearbyAlertFilter nearbyAlertFilter = (NearbyAlertFilter) obj;
        if (this.zzaPm != null || nearbyAlertFilter.zzaPm == null) {
            return this.zzaPp.equals(nearbyAlertFilter.zzaPp) && this.zzaPq.equals(nearbyAlertFilter.zzaPq) && this.zzaPo.equals(nearbyAlertFilter.zzaPo) && (this.zzaPm == null || this.zzaPm.equals(nearbyAlertFilter.zzaPm)) && this.zzaPn == nearbyAlertFilter.zzyX();
        }
        return false;
    }

    @Override // com.google.android.gms.location.places.zza
    public final Set getPlaceIds() {
        return this.zzaPo;
    }

    public final int hashCode() {
        return zzw.hashCode(this.zzaPp, this.zzaPq, this.zzaPo, this.zzaPm, Boolean.valueOf(this.zzaPn));
    }

    public final String toString() {
        zzw.zza zzaVarZzy = zzw.zzy(this);
        if (!this.zzaPp.isEmpty()) {
            zzaVarZzy.zzg("types", this.zzaPp);
        }
        if (!this.zzaPo.isEmpty()) {
            zzaVarZzy.zzg("placeIds", this.zzaPo);
        }
        if (!this.zzaPq.isEmpty()) {
            zzaVarZzy.zzg("requestedUserDataTypes", this.zzaPq);
        }
        if (this.zzaPm != null) {
            zzaVarZzy.zzg("chainName", this.zzaPm);
        }
        zzaVarZzy.zzg("Beacon required: ", Boolean.valueOf(this.zzaPn));
        return zzaVarZzy.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public final boolean zzyX() {
        return this.zzaPn;
    }
}
