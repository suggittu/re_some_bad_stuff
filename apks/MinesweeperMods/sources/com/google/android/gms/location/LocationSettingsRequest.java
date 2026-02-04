package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class LocationSettingsRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzf();
    private final int mVersionCode;
    private final List zzaBm;
    private final boolean zzaOf;
    private final boolean zzaOg;

    public final class Builder {
        private final ArrayList zzaOh = new ArrayList();
        private boolean zzaOf = false;
        private boolean zzaOg = false;

        public final Builder addAllLocationRequests(Collection collection) {
            this.zzaOh.addAll(collection);
            return this;
        }

        public final Builder addLocationRequest(LocationRequest locationRequest) {
            this.zzaOh.add(locationRequest);
            return this;
        }

        public final LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.zzaOh, this.zzaOf, this.zzaOg);
        }

        public final Builder setAlwaysShow(boolean z) {
            this.zzaOf = z;
            return this;
        }

        public final Builder setNeedBle(boolean z) {
            this.zzaOg = z;
            return this;
        }
    }

    LocationSettingsRequest(int i, List list, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.zzaBm = list;
        this.zzaOf = z;
        this.zzaOg = z2;
    }

    private LocationSettingsRequest(List list, boolean z, boolean z2) {
        this(3, list, z, z2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public final List zzuZ() {
        return Collections.unmodifiableList(this.zzaBm);
    }

    public final boolean zzyK() {
        return this.zzaOf;
    }

    public final boolean zzyL() {
        return this.zzaOg;
    }
}
