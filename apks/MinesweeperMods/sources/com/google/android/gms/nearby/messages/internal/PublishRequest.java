package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.zze;
import com.google.android.gms.nearby.messages.internal.zzg;

/* loaded from: classes2.dex */
public final class PublishRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzq();
    final int mVersionCode;

    @Deprecated
    public final String zzbbF;
    public final boolean zzbbG;

    @Deprecated
    public final boolean zzbbH;
    public final MessageWrapper zzbcT;
    public final Strategy zzbcU;
    public final zzg zzbcV;

    @Deprecated
    public final String zzbco;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;

    PublishRequest(int i, MessageWrapper messageWrapper, Strategy strategy, IBinder iBinder, String str, String str2, boolean z, IBinder iBinder2, boolean z2, ClientAppContext clientAppContext) {
        this.mVersionCode = i;
        this.zzbcT = messageWrapper;
        this.zzbcU = strategy;
        this.zzbcr = zze.zza.zzdz(iBinder);
        this.zzbbF = str;
        this.zzbco = str2;
        this.zzbbG = z;
        this.zzbcV = iBinder2 == null ? null : zzg.zza.zzdB(iBinder2);
        this.zzbbH = z2;
        this.zzbcs = clientAppContext == null ? new ClientAppContext(this.zzbco, this.zzbbF, this.zzbbH) : clientAppContext;
    }

    PublishRequest(MessageWrapper messageWrapper, Strategy strategy, IBinder iBinder, boolean z, IBinder iBinder2, ClientAppContext clientAppContext) {
        this(2, messageWrapper, strategy, iBinder, null, null, z, iBinder2, false, clientAppContext);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzq.zza(this, parcel, i);
    }

    final IBinder zzED() {
        return this.zzbcr.asBinder();
    }

    final IBinder zzEF() {
        if (this.zzbcV == null) {
            return null;
        }
        return this.zzbcV.asBinder();
    }
}
