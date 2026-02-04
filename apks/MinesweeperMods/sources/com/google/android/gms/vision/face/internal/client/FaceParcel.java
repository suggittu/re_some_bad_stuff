package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class FaceParcel implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public final float centerX;
    public final float centerY;
    public final float height;
    public final int id;
    public final int versionCode;
    public final float width;
    public final float zzbnP;
    public final float zzbnQ;
    public final LandmarkParcel[] zzbnR;
    public final float zzbnS;
    public final float zzbnT;
    public final float zzbnU;

    public FaceParcel(int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, LandmarkParcel[] landmarkParcelArr, float f7, float f8, float f9) {
        this.versionCode = i;
        this.id = i2;
        this.centerX = f;
        this.centerY = f2;
        this.width = f3;
        this.height = f4;
        this.zzbnP = f5;
        this.zzbnQ = f6;
        this.zzbnR = landmarkParcelArr;
        this.zzbnS = f7;
        this.zzbnT = f8;
        this.zzbnU = f9;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
