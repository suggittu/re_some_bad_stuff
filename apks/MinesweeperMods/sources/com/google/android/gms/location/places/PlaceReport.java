package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public class PlaceReport implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzj();
    private final String mTag;
    final int mVersionCode;
    private final String zzaPH;
    private final String zzaPI;

    PlaceReport(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.zzaPH = str;
        this.mTag = str2;
        this.zzaPI = str3;
    }

    public static PlaceReport create(String str, String str2) {
        return zzk(str, str2, "unknown");
    }

    private static boolean zzel(String str) {
        switch (str) {
            case "unknown":
            case "userReported":
            case "inferredGeofencing":
            case "inferredRadioSignals":
            case "inferredReverseGeocoding":
            case "inferredSnappedToRoad":
                return true;
            default:
                return false;
        }
    }

    public static PlaceReport zzk(String str, String str2, String str3) {
        zzx.zzz(str);
        zzx.zzcM(str2);
        zzx.zzcM(str3);
        zzx.zzb(zzel(str3), "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzw.equal(this.zzaPH, placeReport.zzaPH) && zzw.equal(this.mTag, placeReport.mTag) && zzw.equal(this.zzaPI, placeReport.zzaPI);
    }

    public String getPlaceId() {
        return this.zzaPH;
    }

    public String getSource() {
        return this.zzaPI;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaPH, this.mTag, this.zzaPI);
    }

    public String toString() {
        zzw.zza zzaVarZzy = zzw.zzy(this);
        zzaVarZzy.zzg("placeId", this.zzaPH);
        zzaVarZzy.zzg("tag", this.mTag);
        if (!"unknown".equals(this.zzaPI)) {
            zzaVarZzy.zzg("source", this.zzaPI);
        }
        return zzaVarZzy.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
