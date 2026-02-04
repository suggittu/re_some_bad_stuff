package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class ReadRawResult implements Result, SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzi();
    private final int mVersionCode;
    private final List zzaBN;
    private final DataHolder zzahi;

    ReadRawResult(int i, DataHolder dataHolder, List list) {
        this.mVersionCode = i;
        this.zzahi = dataHolder;
        this.zzaBN = list == null ? Collections.singletonList(dataHolder) : list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return new Status(this.zzahi.getStatusCode());
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    DataHolder zzsX() {
        return this.zzahi;
    }

    public List zzvo() {
        return this.zzaBN;
    }
}
