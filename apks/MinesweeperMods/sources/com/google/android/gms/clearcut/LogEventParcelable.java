package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzsz;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class LogEventParcelable implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    public final int versionCode;
    public PlayLoggerContext zzafh;
    public byte[] zzafi;
    public int[] zzafj;
    public final zzsz.zzd zzafk;
    public final zzb.InterfaceC0035zzb zzafl;
    public final zzb.InterfaceC0035zzb zzafm;

    LogEventParcelable(int i, PlayLoggerContext playLoggerContext, byte[] bArr, int[] iArr) {
        this.versionCode = i;
        this.zzafh = playLoggerContext;
        this.zzafi = bArr;
        this.zzafj = iArr;
        this.zzafk = null;
        this.zzafl = null;
        this.zzafm = null;
    }

    public LogEventParcelable(PlayLoggerContext playLoggerContext, zzsz.zzd zzdVar, zzb.InterfaceC0035zzb interfaceC0035zzb, zzb.InterfaceC0035zzb interfaceC0035zzb2, int[] iArr) {
        this.versionCode = 1;
        this.zzafh = playLoggerContext;
        this.zzafk = zzdVar;
        this.zzafl = interfaceC0035zzb;
        this.zzafm = interfaceC0035zzb2;
        this.zzafj = iArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEventParcelable)) {
            return false;
        }
        LogEventParcelable logEventParcelable = (LogEventParcelable) obj;
        return this.versionCode == logEventParcelable.versionCode && zzw.equal(this.zzafh, logEventParcelable.zzafh) && Arrays.equals(this.zzafi, logEventParcelable.zzafi) && Arrays.equals(this.zzafj, logEventParcelable.zzafj) && zzw.equal(this.zzafk, logEventParcelable.zzafk) && zzw.equal(this.zzafl, logEventParcelable.zzafl) && zzw.equal(this.zzafm, logEventParcelable.zzafm);
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.versionCode), this.zzafh, this.zzafi, this.zzafj, this.zzafk, this.zzafl, this.zzafm);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LogEventParcelable[");
        sb.append(this.versionCode);
        sb.append(", ");
        sb.append(this.zzafh);
        sb.append(", ");
        sb.append(this.zzafi == null ? null : new String(this.zzafi));
        sb.append(", ");
        sb.append(this.zzafj != null ? zzv.zzcL(", ").zza(Arrays.asList(this.zzafj)) : null);
        sb.append(", ");
        sb.append(this.zzafk);
        sb.append(", ");
        sb.append(this.zzafl);
        sb.append(", ");
        sb.append(this.zzafm);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
