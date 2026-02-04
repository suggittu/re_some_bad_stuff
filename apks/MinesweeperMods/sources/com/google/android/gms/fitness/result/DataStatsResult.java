package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public class DataStatsResult implements Result, SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzf();
    private final int mVersionCode;
    private final Status zzUX;
    private final List zzaBL;

    DataStatsResult(int i, Status status, List list) {
        this.mVersionCode = i;
        this.zzUX = status;
        this.zzaBL = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    List zzvn() {
        return this.zzaBL;
    }
}
