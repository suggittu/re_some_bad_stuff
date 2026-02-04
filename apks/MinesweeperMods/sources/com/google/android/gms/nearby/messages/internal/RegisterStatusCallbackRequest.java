package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zze;
import com.google.android.gms.nearby.messages.internal.zzh;

/* loaded from: classes2.dex */
public final class RegisterStatusCallbackRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzr();
    final int versionCode;

    @Deprecated
    public String zzbbF;
    public final zzh zzbcW;
    public boolean zzbcX;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;

    RegisterStatusCallbackRequest(int i, IBinder iBinder, IBinder iBinder2, boolean z, String str, ClientAppContext clientAppContext) {
        this.versionCode = i;
        this.zzbcr = zze.zza.zzdz(iBinder);
        this.zzbcW = zzh.zza.zzdC(iBinder2);
        this.zzbcX = z;
        this.zzbbF = str;
        this.zzbcs = clientAppContext == null ? new ClientAppContext(null, this.zzbbF) : clientAppContext;
    }

    RegisterStatusCallbackRequest(IBinder iBinder, IBinder iBinder2, ClientAppContext clientAppContext) {
        this(1, iBinder, iBinder2, false, null, clientAppContext);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }

    final IBinder zzED() {
        return this.zzbcr.asBinder();
    }

    final IBinder zzEG() {
        return this.zzbcW.asBinder();
    }
}
