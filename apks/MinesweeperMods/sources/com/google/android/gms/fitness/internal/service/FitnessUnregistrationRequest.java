package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

/* loaded from: classes2.dex */
public class FitnessUnregistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    private final DataSource zzavU;

    FitnessUnregistrationRequest(int i, DataSource dataSource) {
        this.mVersionCode = i;
        this.zzavU = dataSource;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("ApplicationUnregistrationRequest{%s}", this.zzavU);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
