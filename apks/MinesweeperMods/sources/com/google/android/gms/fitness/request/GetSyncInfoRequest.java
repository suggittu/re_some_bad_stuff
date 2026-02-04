package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzox;

/* loaded from: classes2.dex */
public class GetSyncInfoRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzp();
    private final int mVersionCode;
    private final zzox zzaBb;

    GetSyncInfoRequest(int i, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaBb = zzox.zza.zzbS(iBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaBb.asBinder();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("GetSyncInfoRequest {%d, %s, %s}", Integer.valueOf(this.mVersionCode), this.zzaBb);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
