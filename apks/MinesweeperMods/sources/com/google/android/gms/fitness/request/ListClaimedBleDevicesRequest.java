package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpj;

/* loaded from: classes2.dex */
public class ListClaimedBleDevicesRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzr();
    private final int mVersionCode;
    private final zzpj zzaBc;

    ListClaimedBleDevicesRequest(int i, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaBc = zzpj.zza.zzbT(iBinder);
    }

    public ListClaimedBleDevicesRequest(zzpj zzpjVar) {
        this.mVersionCode = 2;
        this.zzaBc = zzpjVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaBc.asBinder();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }
}
