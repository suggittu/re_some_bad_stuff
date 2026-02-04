package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public class DeviceStatus implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzg();
    private final int mVersionCode;
    private double zzabs;
    private boolean zzabt;
    private int zzadG;
    private int zzadH;
    private ApplicationMetadata zzadR;

    public DeviceStatus() {
        this(3, Double.NaN, false, -1, null, -1);
    }

    DeviceStatus(int i, double d, boolean z, int i2, ApplicationMetadata applicationMetadata, int i3) {
        this.mVersionCode = i;
        this.zzabs = d;
        this.zzabt = z;
        this.zzadG = i2;
        this.zzadR = applicationMetadata;
        this.zzadH = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceStatus)) {
            return false;
        }
        DeviceStatus deviceStatus = (DeviceStatus) obj;
        return this.zzabs == deviceStatus.zzabs && this.zzabt == deviceStatus.zzabt && this.zzadG == deviceStatus.zzadG && zzf.zza(this.zzadR, deviceStatus.zzadR) && this.zzadH == deviceStatus.zzadH;
    }

    public ApplicationMetadata getApplicationMetadata() {
        return this.zzadR;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Double.valueOf(this.zzabs), Boolean.valueOf(this.zzabt), Integer.valueOf(this.zzadG), this.zzadR, Integer.valueOf(this.zzadH));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    public double zzok() {
        return this.zzabs;
    }

    public int zzol() {
        return this.zzadG;
    }

    public int zzom() {
        return this.zzadH;
    }

    public boolean zzot() {
        return this.zzabt;
    }
}
