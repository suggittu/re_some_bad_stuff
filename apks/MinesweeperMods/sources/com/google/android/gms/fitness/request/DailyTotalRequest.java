package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzog;

/* loaded from: classes2.dex */
public class DailyTotalRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzc();
    private final int mVersionCode;
    private final zzog zzaAE;
    private DataType zzavT;

    DailyTotalRequest(int i, IBinder iBinder, DataType dataType) {
        this.mVersionCode = i;
        this.zzaAE = zzog.zza.zzbB(iBinder);
        this.zzavT = dataType;
    }

    public DailyTotalRequest(zzog zzogVar, DataType dataType) {
        this.mVersionCode = 2;
        this.zzaAE = zzogVar;
        this.zzavT = dataType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaAE.asBinder();
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("DailyTotalRequest{%s}", this.zzavT.zzuo());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
