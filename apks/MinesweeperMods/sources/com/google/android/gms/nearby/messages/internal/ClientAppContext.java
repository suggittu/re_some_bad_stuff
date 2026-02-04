package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public final class ClientAppContext implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zza();
    final int versionCode;
    public final boolean zzbbH;
    public final String zzbco;
    public final String zzbcp;
    public final int zzbcq;

    ClientAppContext(int i, String str, String str2, boolean z, int i2) {
        this.versionCode = i;
        this.zzbco = str;
        this.zzbcp = str2;
        this.zzbbH = z;
        this.zzbcq = i2;
    }

    public ClientAppContext(String str, String str2) {
        this(str, str2, false);
    }

    public ClientAppContext(String str, String str2, boolean z) {
        this(str, str2, z, 0);
    }

    public ClientAppContext(String str, String str2, boolean z, int i) {
        this(1, str, str2, z, i);
    }

    private static boolean zzT(String str, String str2) {
        return TextUtils.isEmpty(str) ? TextUtils.isEmpty(str2) : str.equals(str2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientAppContext)) {
            return false;
        }
        ClientAppContext clientAppContext = (ClientAppContext) obj;
        return zzT(this.zzbco, clientAppContext.zzbco) && zzT(this.zzbcp, clientAppContext.zzbcp) && this.zzbbH == clientAppContext.zzbbH && this.zzbcq == clientAppContext.zzbcq;
    }

    public final int hashCode() {
        return zzw.hashCode(this.zzbco, this.zzbcp, Boolean.valueOf(this.zzbbH), Integer.valueOf(this.zzbcq));
    }

    public final String toString() {
        return String.format("{realClientPackageName: %s, zeroPartyIdentifier: %s, useRealClientApiKey: %b, callingContext: %d}", this.zzbco, this.zzbcp, Boolean.valueOf(this.zzbbH), Integer.valueOf(this.zzbcq));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
