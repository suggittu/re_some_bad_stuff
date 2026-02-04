package com.google.android.gms.location.places;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class AutocompleteFilter implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public static final int TYPE_FILTER_ADDRESS = 2;
    public static final int TYPE_FILTER_CITIES = 5;
    public static final int TYPE_FILTER_ESTABLISHMENT = 34;
    public static final int TYPE_FILTER_GEOCODE = 1007;
    public static final int TYPE_FILTER_NONE = 0;
    public static final int TYPE_FILTER_REGIONS = 4;
    final int mVersionCode;
    final boolean zzaPg;
    final List zzaPh;
    final int zzaPi;

    public final class Builder {
        private boolean zzaPg = false;
        private int zzaPi = 0;

        public final AutocompleteFilter build() {
            return new AutocompleteFilter(1, this.zzaPg, AutocompleteFilter.zzhJ(this.zzaPi));
        }

        public final Builder setTypeFilter(int i) {
            this.zzaPi = i;
            return this;
        }
    }

    AutocompleteFilter(int i, boolean z, List list) {
        this.mVersionCode = i;
        this.zzaPh = list;
        this.zzaPi = zzg(list);
        if (this.mVersionCode <= 0) {
            this.zzaPg = !z;
        } else {
            this.zzaPg = z;
        }
    }

    @Deprecated
    public static AutocompleteFilter create(@Nullable Collection collection) {
        return new Builder().setTypeFilter(zzg(collection)).build();
    }

    private static int zzg(@Nullable Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        return ((Integer) collection.iterator().next()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List zzhJ(int i) {
        return Arrays.asList(Integer.valueOf(i));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AutocompleteFilter) {
            return this.zzaPi == this.zzaPi && this.zzaPg == ((AutocompleteFilter) obj).zzaPg;
        }
        return false;
    }

    @Deprecated
    public Set getPlaceTypes() {
        return new HashSet(zzhJ(this.zzaPi));
    }

    public int getTypeFilter() {
        return this.zzaPi;
    }

    public int hashCode() {
        return zzw.hashCode(Boolean.valueOf(this.zzaPg), Integer.valueOf(this.zzaPi));
    }

    public String toString() {
        return zzw.zzy(this).zzg("includeQueryPredictions", Boolean.valueOf(this.zzaPg)).zzg("typeFilter", Integer.valueOf(this.zzaPi)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
