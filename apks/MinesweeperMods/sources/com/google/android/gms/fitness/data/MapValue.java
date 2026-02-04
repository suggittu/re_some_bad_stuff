package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public class MapValue implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzm();
    private final int mVersionCode;
    private final int zzawZ;
    private final float zzaxe;

    public MapValue(int i, float f) {
        this(1, i, f);
    }

    MapValue(int i, int i2, float f) {
        this.mVersionCode = i;
        this.zzawZ = i2;
        this.zzaxe = f;
    }

    private boolean zza(MapValue mapValue) {
        if (this.zzawZ != mapValue.zzawZ) {
            return false;
        }
        switch (this.zzawZ) {
            case 2:
                if (asFloat() != mapValue.asFloat()) {
                    break;
                }
                break;
            default:
                if (this.zzaxe != mapValue.zzaxe) {
                    break;
                }
                break;
        }
        return true;
    }

    public static MapValue zzc(float f) {
        return new MapValue(2, f);
    }

    public float asFloat() {
        zzx.zza(this.zzawZ == 2, "Value is not in float format");
        return this.zzaxe;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof MapValue) && zza((MapValue) obj));
    }

    int getFormat() {
        return this.zzawZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return (int) this.zzaxe;
    }

    public String toString() {
        switch (this.zzawZ) {
            case 2:
                return Float.toString(asFloat());
            default:
                return "unknown";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    float zzuv() {
        return this.zzaxe;
    }
}
