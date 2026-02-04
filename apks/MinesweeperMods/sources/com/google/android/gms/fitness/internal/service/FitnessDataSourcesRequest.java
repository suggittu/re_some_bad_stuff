package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class FitnessDataSourcesRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zza();
    private final int mVersionCode;
    private final List zzawe;

    FitnessDataSourcesRequest(int i, List list) {
        this.mVersionCode = i;
        this.zzawe = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List getDataTypes() {
        return Collections.unmodifiableList(this.zzawe);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return zzw.zzy(this).zzg("dataTypes", this.zzawe).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
