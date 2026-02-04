package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class Feature implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final int id;
    final int mVersionCode;
    final Bundle zzTS;

    Feature(int i, int i2, Bundle bundle) {
        this.mVersionCode = i;
        this.id = i2;
        this.zzTS = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zze zzeVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze zzeVar = CREATOR;
        zze.zza(this, parcel, i);
    }
}
