package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzow;

/* loaded from: classes2.dex */
public class DeleteAllUserDataRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzn();
    private final int mVersionCode;
    private final zzow zzaAD;

    DeleteAllUserDataRequest(int i, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaAD.asBinder();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("DisableFitRequest", new Object[0]);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }
}
