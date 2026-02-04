package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zze;

/* loaded from: classes2.dex */
public final class UnpublishRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzt();
    final int mVersionCode;

    @Deprecated
    public final String zzbbF;

    @Deprecated
    public final boolean zzbbH;
    public final MessageWrapper zzbcT;

    @Deprecated
    public final String zzbco;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;

    UnpublishRequest(int i, MessageWrapper messageWrapper, IBinder iBinder, String str, String str2, boolean z, ClientAppContext clientAppContext) {
        this.mVersionCode = i;
        this.zzbcT = messageWrapper;
        this.zzbcr = zze.zza.zzdz(iBinder);
        this.zzbbF = str;
        this.zzbco = str2;
        this.zzbbH = z;
        this.zzbcs = clientAppContext == null ? new ClientAppContext(this.zzbco, this.zzbbF, this.zzbbH) : clientAppContext;
    }

    UnpublishRequest(MessageWrapper messageWrapper, IBinder iBinder, ClientAppContext clientAppContext) {
        this(1, messageWrapper, iBinder, null, null, false, clientAppContext);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzt.zza(this, parcel, i);
    }

    final IBinder zzED() {
        return this.zzbcr.asBinder();
    }
}
