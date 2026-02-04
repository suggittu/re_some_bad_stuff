package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class LocationRequestInternal implements SafeParcelable {

    @Nullable
    String mTag;
    private final int mVersionCode;
    LocationRequest zzaBp;
    boolean zzaOP;
    boolean zzaOQ;
    boolean zzaOR;
    List zzaOS;
    boolean zzaOT;
    static final List zzaOO = Collections.emptyList();
    public static final zzm CREATOR = new zzm();

    LocationRequestInternal(int i, LocationRequest locationRequest, boolean z, boolean z2, boolean z3, List list, @Nullable String str, boolean z4) {
        this.mVersionCode = i;
        this.zzaBp = locationRequest;
        this.zzaOP = z;
        this.zzaOQ = z2;
        this.zzaOR = z3;
        this.zzaOS = list;
        this.mTag = str;
        this.zzaOT = z4;
    }

    public static LocationRequestInternal zza(@Nullable String str, LocationRequest locationRequest) {
        return new LocationRequestInternal(1, locationRequest, false, true, true, zzaOO, str, false);
    }

    @Deprecated
    public static LocationRequestInternal zzb(LocationRequest locationRequest) {
        return zza(null, locationRequest);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationRequestInternal)) {
            return false;
        }
        LocationRequestInternal locationRequestInternal = (LocationRequestInternal) obj;
        return zzw.equal(this.zzaBp, locationRequestInternal.zzaBp) && this.zzaOP == locationRequestInternal.zzaOP && this.zzaOQ == locationRequestInternal.zzaOQ && this.zzaOR == locationRequestInternal.zzaOR && this.zzaOT == locationRequestInternal.zzaOT && zzw.equal(this.zzaOS, locationRequestInternal.zzaOS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return this.zzaBp.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzaBp.toString());
        if (this.mTag != null) {
            sb.append(" tag=").append(this.mTag);
        }
        sb.append(" nlpDebug=").append(this.zzaOP);
        sb.append(" trigger=").append(this.zzaOR);
        sb.append(" restorePIListeners=").append(this.zzaOQ);
        sb.append(" hideAppOps=").append(this.zzaOT);
        sb.append(" clients=").append(this.zzaOS);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
