package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public final class VideoConfiguration implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new VideoConfigurationCreator();
    private final int mVersionCode;
    private final int zzaLr;
    private final int zzaLs;
    private final String zzaLt;
    private final String zzaLu;

    public final class Builder {
    }

    public VideoConfiguration(int i, int i2, int i3, String str, String str2) {
        this.mVersionCode = i;
        zzx.zzac(zzgZ(i2));
        zzx.zzac(zzha(i3));
        this.zzaLr = i2;
        this.zzaLs = i3;
        if (i3 == 1) {
            this.zzaLu = str2;
            this.zzaLt = str;
        } else {
            zzx.zzb(str2 == null, "Stream key should be null when not streaming");
            zzx.zzb(str == null, "Stream url should be null when not streaming");
            this.zzaLu = null;
            this.zzaLt = null;
        }
    }

    public static boolean zzgZ(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzha(int i) {
        switch (i) {
            case 0:
            case 1:
                return true;
            default:
                return false;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getStreamUrl() {
        return this.zzaLt;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        VideoConfigurationCreator.zza(this, parcel, i);
    }

    public final int zzyd() {
        return this.zzaLr;
    }

    public final int zzye() {
        return this.zzaLs;
    }

    public final String zzyf() {
        return this.zzaLu;
    }
}
