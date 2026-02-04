package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.zzd;
import com.google.android.gms.nearby.messages.internal.zze;
import com.google.android.gms.nearby.messages.internal.zzi;

/* loaded from: classes2.dex */
public final class SubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzs();
    final int mVersionCode;

    @Deprecated
    public final String zzbbF;
    public final boolean zzbbG;

    @Deprecated
    public final boolean zzbbH;
    public final Strategy zzbcU;
    public final zzd zzbcY;
    public final MessageFilter zzbcZ;

    @Deprecated
    public final String zzbco;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;
    public final PendingIntent zzbda;
    public final int zzbdb;
    public final byte[] zzbdc;
    public final zzi zzbdd;

    SubscribeRequest(int i, IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, int i2, String str, String str2, byte[] bArr, boolean z, IBinder iBinder3, boolean z2, ClientAppContext clientAppContext) {
        this.mVersionCode = i;
        this.zzbcY = zzd.zza.zzdy(iBinder);
        this.zzbcU = strategy;
        this.zzbcr = zze.zza.zzdz(iBinder2);
        this.zzbcZ = messageFilter;
        this.zzbda = pendingIntent;
        this.zzbdb = i2;
        this.zzbbF = str;
        this.zzbco = str2;
        this.zzbdc = bArr;
        this.zzbbG = z;
        this.zzbdd = iBinder3 == null ? null : zzi.zza.zzdD(iBinder3);
        this.zzbbH = z2;
        this.zzbcs = clientAppContext == null ? new ClientAppContext(this.zzbco, this.zzbbF, this.zzbbH) : clientAppContext;
    }

    public SubscribeRequest(IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, int i, byte[] bArr, boolean z, IBinder iBinder3, ClientAppContext clientAppContext) {
        this(3, iBinder, strategy, iBinder2, messageFilter, pendingIntent, i, null, null, bArr, z, iBinder3, false, clientAppContext);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzs.zza(this, parcel, i);
    }

    final IBinder zzED() {
        if (this.zzbcr == null) {
            return null;
        }
        return this.zzbcr.asBinder();
    }

    final IBinder zzEH() {
        if (this.zzbcY == null) {
            return null;
        }
        return this.zzbcY.asBinder();
    }

    final IBinder zzEI() {
        if (this.zzbdd == null) {
            return null;
        }
        return this.zzbdd.asBinder();
    }
}
