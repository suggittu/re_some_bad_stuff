package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;
import java.util.List;

@zzhb
/* loaded from: classes2.dex */
public final class AdRequestParcel implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    public final Bundle extras;
    public final int versionCode;
    public final long zztC;
    public final int zztD;
    public final List zztE;
    public final boolean zztF;
    public final int zztG;
    public final boolean zztH;
    public final String zztI;
    public final SearchAdRequestParcel zztJ;
    public final Location zztK;
    public final String zztL;
    public final Bundle zztM;
    public final Bundle zztN;
    public final List zztO;
    public final String zztP;
    public final String zztQ;
    public final boolean zztR;

    public AdRequestParcel(int i, long j, Bundle bundle, int i2, List list, boolean z, int i3, boolean z2, String str, SearchAdRequestParcel searchAdRequestParcel, Location location, String str2, Bundle bundle2, Bundle bundle3, List list2, String str3, String str4, boolean z3) {
        this.versionCode = i;
        this.zztC = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zztD = i2;
        this.zztE = list;
        this.zztF = z;
        this.zztG = i3;
        this.zztH = z2;
        this.zztI = str;
        this.zztJ = searchAdRequestParcel;
        this.zztK = location;
        this.zztL = str2;
        this.zztM = bundle2;
        this.zztN = bundle3;
        this.zztO = list2;
        this.zztP = str3;
        this.zztQ = str4;
        this.zztR = z3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AdRequestParcel)) {
            return false;
        }
        AdRequestParcel adRequestParcel = (AdRequestParcel) obj;
        return this.versionCode == adRequestParcel.versionCode && this.zztC == adRequestParcel.zztC && com.google.android.gms.common.internal.zzw.equal(this.extras, adRequestParcel.extras) && this.zztD == adRequestParcel.zztD && com.google.android.gms.common.internal.zzw.equal(this.zztE, adRequestParcel.zztE) && this.zztF == adRequestParcel.zztF && this.zztG == adRequestParcel.zztG && this.zztH == adRequestParcel.zztH && com.google.android.gms.common.internal.zzw.equal(this.zztI, adRequestParcel.zztI) && com.google.android.gms.common.internal.zzw.equal(this.zztJ, adRequestParcel.zztJ) && com.google.android.gms.common.internal.zzw.equal(this.zztK, adRequestParcel.zztK) && com.google.android.gms.common.internal.zzw.equal(this.zztL, adRequestParcel.zztL) && com.google.android.gms.common.internal.zzw.equal(this.zztM, adRequestParcel.zztM) && com.google.android.gms.common.internal.zzw.equal(this.zztN, adRequestParcel.zztN) && com.google.android.gms.common.internal.zzw.equal(this.zztO, adRequestParcel.zztO) && com.google.android.gms.common.internal.zzw.equal(this.zztP, adRequestParcel.zztP) && com.google.android.gms.common.internal.zzw.equal(this.zztQ, adRequestParcel.zztQ) && this.zztR == adRequestParcel.zztR;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zztC), this.extras, Integer.valueOf(this.zztD), this.zztE, Boolean.valueOf(this.zztF), Integer.valueOf(this.zztG), Boolean.valueOf(this.zztH), this.zztI, this.zztJ, this.zztK, this.zztL, this.zztM, this.zztN, this.zztO, this.zztP, this.zztQ, Boolean.valueOf(this.zztR));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
