package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

/* loaded from: classes2.dex */
public class PlaceUserData implements SafeParcelable {
    public static final zze CREATOR = new zze();
    final int mVersionCode;
    private final String zzVa;
    private final String zzaPH;
    private final List zzaRg;

    PlaceUserData(int i, String str, String str2, List list) {
        this.mVersionCode = i;
        this.zzVa = str;
        this.zzaPH = str2;
        this.zzaRg = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zze zzeVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceUserData)) {
            return false;
        }
        PlaceUserData placeUserData = (PlaceUserData) obj;
        return this.zzVa.equals(placeUserData.zzVa) && this.zzaPH.equals(placeUserData.zzaPH) && this.zzaRg.equals(placeUserData.zzaRg);
    }

    public String getPlaceId() {
        return this.zzaPH;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzVa, this.zzaPH, this.zzaRg);
    }

    public String toString() {
        return zzw.zzy(this).zzg("accountName", this.zzVa).zzg("placeId", this.zzaPH).zzg("placeAliases", this.zzaRg).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze zzeVar = CREATOR;
        zze.zza(this, parcel, i);
    }

    public String zzzD() {
        return this.zzVa;
    }

    public List zzzE() {
        return this.zzaRg;
    }
}
