package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes2.dex */
public class DataTypeReadRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzj();
    private final String mName;
    private final int mVersionCode;
    private final zzoj zzaBa;

    DataTypeReadRequest(int i, String str, IBinder iBinder) {
        this.mVersionCode = i;
        this.mName = str;
        this.zzaBa = zzoj.zza.zzbE(iBinder);
    }

    public DataTypeReadRequest(String str, zzoj zzojVar) {
        this.mVersionCode = 3;
        this.mName = str;
        this.zzaBa = zzojVar;
    }

    private boolean zzb(DataTypeReadRequest dataTypeReadRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.mName, dataTypeReadRequest.mName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataTypeReadRequest) && zzb((DataTypeReadRequest) obj));
    }

    public IBinder getCallbackBinder() {
        return this.zzaBa.asBinder();
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.mName);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg("name", this.mName).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
