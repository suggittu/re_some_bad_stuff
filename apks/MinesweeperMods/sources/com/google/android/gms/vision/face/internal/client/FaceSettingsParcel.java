package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class FaceSettingsParcel implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public int mode;
    public final int versionCode;
    public int zzbnV;
    public int zzbnW;
    public boolean zzbnX;
    public boolean zzbnY;
    public float zzbnZ;

    public FaceSettingsParcel() {
        this.versionCode = 2;
    }

    public FaceSettingsParcel(int i, int i2, int i3, int i4, boolean z, boolean z2, float f) {
        this.versionCode = i;
        this.mode = i2;
        this.zzbnV = i3;
        this.zzbnW = i4;
        this.zzbnX = z;
        this.zzbnY = z2;
        this.zzbnZ = f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
