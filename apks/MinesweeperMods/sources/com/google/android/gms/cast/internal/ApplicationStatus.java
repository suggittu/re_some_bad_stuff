package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public class ApplicationStatus implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zza();
    private final int mVersionCode;
    private String zzadp;

    public ApplicationStatus() {
        this(1, null);
    }

    ApplicationStatus(int i, String str) {
        this.mVersionCode = i;
        this.zzadp = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ApplicationStatus) {
            return zzf.zza(this.zzadp, ((ApplicationStatus) obj).zzadp);
        }
        return false;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzadp);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzoe() {
        return this.zzadp;
    }
}
