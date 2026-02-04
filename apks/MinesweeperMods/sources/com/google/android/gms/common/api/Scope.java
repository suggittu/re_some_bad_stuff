package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public final class Scope implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    final int mVersionCode;
    private final String zzagB;

    Scope(int i, String str) {
        zzx.zzh(str, "scopeUri must not be null or empty");
        this.mVersionCode = i;
        this.zzagB = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.zzagB.equals(((Scope) obj).zzagB);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzagB.hashCode();
    }

    public final String toString() {
        return this.zzagB;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public final String zzpb() {
        return this.zzagB;
    }
}
