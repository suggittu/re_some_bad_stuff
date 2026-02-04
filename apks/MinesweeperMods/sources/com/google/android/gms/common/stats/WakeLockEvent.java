package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public final class WakeLockEvent extends zzf implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzh();
    private final long mTimeout;
    final int mVersionCode;
    private final String zzanQ;
    private final int zzanR;
    private final List zzanS;
    private final String zzanT;
    private int zzanU;
    private final String zzanV;
    private final String zzanW;
    private final float zzanX;
    private final long zzane;
    private int zzanf;
    private final long zzanm;
    private long zzano;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List list, String str2, long j2, int i4, String str3, String str4, float f, long j3) {
        this.mVersionCode = i;
        this.zzane = j;
        this.zzanf = i2;
        this.zzanQ = str;
        this.zzanV = str3;
        this.zzanR = i3;
        this.zzano = -1L;
        this.zzanS = list;
        this.zzanT = str2;
        this.zzanm = j2;
        this.zzanU = i4;
        this.zzanW = str4;
        this.zzanX = f;
        this.mTimeout = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List list, String str2, long j2, int i3, String str3, String str4, float f, long j3) {
        this(1, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.stats.zzf
    public final int getEventType() {
        return this.zzanf;
    }

    @Override // com.google.android.gms.common.stats.zzf
    public final long getTimeMillis() {
        return this.zzane;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public final String zzrK() {
        return this.zzanT;
    }

    @Override // com.google.android.gms.common.stats.zzf
    public final long zzrL() {
        return this.zzano;
    }

    public final long zzrN() {
        return this.zzanm;
    }

    @Override // com.google.android.gms.common.stats.zzf
    public final String zzrO() {
        return "\t" + zzrR() + "\t" + zzrT() + "\t" + (zzrU() == null ? "" : TextUtils.join(",", zzrU())) + "\t" + zzrV() + "\t" + (zzrS() == null ? "" : zzrS()) + "\t" + (zzrW() == null ? "" : zzrW()) + "\t" + zzrX();
    }

    public final String zzrR() {
        return this.zzanQ;
    }

    public final String zzrS() {
        return this.zzanV;
    }

    public final int zzrT() {
        return this.zzanR;
    }

    public final List zzrU() {
        return this.zzanS;
    }

    public final int zzrV() {
        return this.zzanU;
    }

    public final String zzrW() {
        return this.zzanW;
    }

    public final float zzrX() {
        return this.zzanX;
    }

    public final long zzrY() {
        return this.mTimeout;
    }
}
