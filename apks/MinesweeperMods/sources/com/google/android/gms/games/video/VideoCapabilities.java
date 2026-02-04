package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public final class VideoCapabilities implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new VideoCapabilitiesCreator();
    private final int mVersionCode;
    private final boolean zzaLm;
    private final boolean zzaLn;
    private final boolean zzaLo;
    private final boolean[] zzaLp;
    private final boolean[] zzaLq;

    public VideoCapabilities(int i, boolean z, boolean z2, boolean z3, boolean[] zArr, boolean[] zArr2) {
        this.mVersionCode = i;
        this.zzaLm = z;
        this.zzaLn = z2;
        this.zzaLo = z3;
        this.zzaLp = zArr;
        this.zzaLq = zArr2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof VideoCapabilities)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        VideoCapabilities videoCapabilities = (VideoCapabilities) obj;
        return zzw.equal(videoCapabilities.zzyb(), zzyb()) && zzw.equal(videoCapabilities.zzyc(), zzyc()) && zzw.equal(Boolean.valueOf(videoCapabilities.zzxZ()), Boolean.valueOf(zzxZ())) && zzw.equal(Boolean.valueOf(videoCapabilities.zzxY()), Boolean.valueOf(zzxY())) && zzw.equal(Boolean.valueOf(videoCapabilities.zzya()), Boolean.valueOf(zzya()));
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zzw.hashCode(zzyb(), zzyc(), Boolean.valueOf(zzxZ()), Boolean.valueOf(zzxY()), Boolean.valueOf(zzya()));
    }

    public final String toString() {
        return zzw.zzy(this).zzg("SupportedCaptureModes", zzyb()).zzg("SupportedQualityLevels", zzyc()).zzg("CameraSupported", Boolean.valueOf(zzxZ())).zzg("MicSupported", Boolean.valueOf(zzxY())).zzg("StorageWriteSupported", Boolean.valueOf(zzya())).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        VideoCapabilitiesCreator.zza(this, parcel, i);
    }

    public final boolean zzxY() {
        return this.zzaLn;
    }

    public final boolean zzxZ() {
        return this.zzaLm;
    }

    public final boolean zzya() {
        return this.zzaLo;
    }

    public final boolean[] zzyb() {
        return this.zzaLp;
    }

    public final boolean[] zzyc() {
        return this.zzaLq;
    }
}
