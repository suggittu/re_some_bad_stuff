package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class PlaceAliasResult implements Result, SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzc();
    final int mVersionCode;
    private final Status zzUX;
    final PlaceUserData zzaRf;

    PlaceAliasResult(int i, Status status, PlaceUserData placeUserData) {
        this.mVersionCode = i;
        this.zzUX = status;
        this.zzaRf = placeUserData;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public PlaceUserData zzzC() {
        return this.zzaRf;
    }
}
