package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public final class AppIdentifier implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zza();
    private final int mVersionCode;
    private final String zzaxk;

    AppIdentifier(int i, String str) {
        this.mVersionCode = i;
        this.zzaxk = zzx.zzh(str, "Missing application identifier value");
    }

    public AppIdentifier(String str) {
        this(1, str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getIdentifier() {
        return this.zzaxk;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
