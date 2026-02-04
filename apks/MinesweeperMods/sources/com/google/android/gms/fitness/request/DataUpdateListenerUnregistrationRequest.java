package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzow;

/* loaded from: classes2.dex */
public class DataUpdateListenerUnregistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzl();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzow zzaAD;

    DataUpdateListenerUnregistrationRequest(int i, PendingIntent pendingIntent, IBinder iBinder) {
        this.mVersionCode = i;
        this.mPendingIntent = pendingIntent;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    private boolean zzb(DataUpdateListenerUnregistrationRequest dataUpdateListenerUnregistrationRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.mPendingIntent, dataUpdateListenerUnregistrationRequest.mPendingIntent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataUpdateListenerUnregistrationRequest) && zzb((DataUpdateListenerUnregistrationRequest) obj));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.mPendingIntent);
    }

    public String toString() {
        return String.format("DataUpdateListenerUnregistrationRequest", new Object[0]);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }
}
