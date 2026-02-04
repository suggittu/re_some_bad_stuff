package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zze;

/* loaded from: classes2.dex */
public class GetPermissionStatusRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    final int mVersionCode;

    @Deprecated
    public final String zzbbF;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;

    GetPermissionStatusRequest(int i, IBinder iBinder, String str, ClientAppContext clientAppContext) {
        this.mVersionCode = i;
        this.zzbcr = zze.zza.zzdz(iBinder);
        this.zzbbF = str;
        this.zzbcs = clientAppContext == null ? new ClientAppContext(null, this.zzbbF) : clientAppContext;
    }

    GetPermissionStatusRequest(IBinder iBinder, ClientAppContext clientAppContext) {
        this(1, iBinder, null, clientAppContext);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    IBinder zzED() {
        return this.zzbcr.asBinder();
    }
}
