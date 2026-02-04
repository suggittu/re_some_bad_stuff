package com.google.android.gms.location.places;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class PlaceFilter extends com.google.android.gms.location.places.zza implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    private static final PlaceFilter zzaPz = new PlaceFilter();
    final int mVersionCode;
    final boolean zzaPA;
    final List zzaPj;
    final List zzaPk;
    final List zzaPl;
    private final Set zzaPo;
    private final Set zzaPp;
    private final Set zzaPq;

    @Deprecated
    public final class zza {
        private boolean zzaPA;
        private Collection zzaPB;
        private Collection zzaPC;
        private String[] zzaPD;

        private zza() {
            this.zzaPB = null;
            this.zzaPA = false;
            this.zzaPC = null;
            this.zzaPD = null;
        }

        public final PlaceFilter zzze() {
            return new PlaceFilter(this.zzaPB != null ? new ArrayList(this.zzaPB) : null, this.zzaPA, this.zzaPD != null ? Arrays.asList(this.zzaPD) : null, this.zzaPC != null ? new ArrayList(this.zzaPC) : null);
        }
    }

    public PlaceFilter() {
        this(false, null);
    }

    PlaceFilter(int i, @Nullable List list, boolean z, @Nullable List list2, @Nullable List list3) {
        this.mVersionCode = i;
        this.zzaPk = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzaPA = z;
        this.zzaPl = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzaPj = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzaPp = zzw(this.zzaPk);
        this.zzaPq = zzw(this.zzaPl);
        this.zzaPo = zzw(this.zzaPj);
    }

    public PlaceFilter(@Nullable Collection collection, boolean z, @Nullable Collection collection2, @Nullable Collection collection3) {
        this(0, zzf(collection), z, zzf(collection2), zzf(collection3));
    }

    public PlaceFilter(boolean z, @Nullable Collection collection) {
        this(null, z, collection, null);
    }

    @Deprecated
    public static PlaceFilter zzzd() {
        return new zza().zzze();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) obj;
        return this.zzaPp.equals(placeFilter.zzaPp) && this.zzaPA == placeFilter.zzaPA && this.zzaPq.equals(placeFilter.zzaPq) && this.zzaPo.equals(placeFilter.zzaPo);
    }

    @Override // com.google.android.gms.location.places.zza
    public final Set getPlaceIds() {
        return this.zzaPo;
    }

    public final Set getPlaceTypes() {
        return this.zzaPp;
    }

    public final int hashCode() {
        return zzw.hashCode(this.zzaPp, Boolean.valueOf(this.zzaPA), this.zzaPq, this.zzaPo);
    }

    @Override // com.google.android.gms.location.places.zza
    public final boolean isRestrictedToPlacesOpenNow() {
        return this.zzaPA;
    }

    public final String toString() {
        zzw.zza zzaVarZzy = zzw.zzy(this);
        if (!this.zzaPp.isEmpty()) {
            zzaVarZzy.zzg("types", this.zzaPp);
        }
        zzaVarZzy.zzg("requireOpenNow", Boolean.valueOf(this.zzaPA));
        if (!this.zzaPo.isEmpty()) {
            zzaVarZzy.zzg("placeIds", this.zzaPo);
        }
        if (!this.zzaPq.isEmpty()) {
            zzaVarZzy.zzg("requestedUserDataTypes", this.zzaPq);
        }
        return zzaVarZzy.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
