package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public final class IdpTokenType implements SafeParcelable {
    final int versionCode;
    private final String zzXC;
    public static final IdpTokenType zzXA = new IdpTokenType("accessToken");
    public static final IdpTokenType zzXB = new IdpTokenType("idToken");
    public static final Parcelable.Creator CREATOR = new zzj();

    IdpTokenType(int i, String str) {
        this.versionCode = i;
        this.zzXC = zzx.zzcM(str);
    }

    private IdpTokenType(String str) {
        this(1, str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.zzXC.equals(((IdpTokenType) obj).zzng());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public final int hashCode() {
        return this.zzXC.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public final String zzng() {
        return this.zzXC;
    }
}
