package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.zzmy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public final class Value implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzu();
    private final int mVersionCode;
    private final int zzawZ;
    private float zzaxe;
    private boolean zzaxq;
    private String zzaxr;
    private Map zzaxs;
    private int[] zzaxt;
    private float[] zzaxu;
    private byte[] zzaxv;

    public Value(int i) {
        this(3, i, false, 0.0f, null, null, null, null, null);
    }

    Value(int i, int i2, boolean z, float f, String str, Bundle bundle, int[] iArr, float[] fArr, byte[] bArr) {
        this.mVersionCode = i;
        this.zzawZ = i2;
        this.zzaxq = z;
        this.zzaxe = f;
        this.zzaxr = str;
        this.zzaxs = zzv(bundle);
        this.zzaxt = iArr;
        this.zzaxu = fArr;
        this.zzaxv = bArr;
    }

    private boolean zza(Value value) {
        if (this.zzawZ != value.zzawZ || this.zzaxq != value.zzaxq) {
            return false;
        }
        switch (this.zzawZ) {
            case 1:
                if (asInt() != value.asInt()) {
                    break;
                }
                break;
            case 2:
                if (this.zzaxe != value.zzaxe) {
                    break;
                }
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                if (this.zzaxe != value.zzaxe) {
                    break;
                }
                break;
        }
        return true;
    }

    private static Map zzv(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(MapValue.class.getClassLoader());
        ArrayMap arrayMap = new ArrayMap(bundle.size());
        for (String str : bundle.keySet()) {
            arrayMap.put(str, bundle.getParcelable(str));
        }
        return arrayMap;
    }

    public final String asActivity() {
        return FitnessActivities.getName(asInt());
    }

    public final float asFloat() {
        zzx.zza(this.zzawZ == 2, "Value is not in float format");
        return this.zzaxe;
    }

    public final int asInt() {
        zzx.zza(this.zzawZ == 1, "Value is not in int format");
        return Float.floatToRawIntBits(this.zzaxe);
    }

    public final String asString() {
        zzx.zza(this.zzawZ == 3, "Value is not in string format");
        return this.zzaxr;
    }

    public final void clearKey(String str) {
        zzx.zza(this.zzawZ == 4, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        if (this.zzaxs != null) {
            this.zzaxs.remove(str);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof Value) && zza((Value) obj));
    }

    public final int getFormat() {
        return this.zzawZ;
    }

    @Nullable
    public final Float getKeyValue(String str) {
        zzx.zza(this.zzawZ == 4, "Value is not in float map format");
        if (this.zzaxs == null || !this.zzaxs.containsKey(str)) {
            return null;
        }
        return Float.valueOf(((MapValue) this.zzaxs.get(str)).asFloat());
    }

    final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zzw.hashCode(Float.valueOf(this.zzaxe), this.zzaxr, this.zzaxs, this.zzaxt, this.zzaxu, this.zzaxv);
    }

    public final boolean isSet() {
        return this.zzaxq;
    }

    public final void setActivity(String str) {
        setInt(FitnessActivities.zzdm(str));
    }

    public final void setFloat(float f) {
        zzx.zza(this.zzawZ == 2, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.zzaxq = true;
        this.zzaxe = f;
    }

    public final void setInt(int i) {
        zzx.zza(this.zzawZ == 1, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.zzaxq = true;
        this.zzaxe = Float.intBitsToFloat(i);
    }

    public final void setKeyValue(String str, float f) {
        zzx.zza(this.zzawZ == 4, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        this.zzaxq = true;
        if (this.zzaxs == null) {
            this.zzaxs = new HashMap();
        }
        this.zzaxs.put(str, MapValue.zzc(f));
    }

    public final void setString(String str) {
        zzx.zza(this.zzawZ == 3, "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
        this.zzaxq = true;
        this.zzaxr = str;
    }

    public final String toString() {
        if (!this.zzaxq) {
            return "unset";
        }
        switch (this.zzawZ) {
            case 1:
                return Integer.toString(asInt());
            case 2:
                return Float.toString(this.zzaxe);
            case 3:
                return this.zzaxr;
            case 4:
                return new TreeMap(this.zzaxs).toString();
            case 5:
                return Arrays.toString(this.zzaxt);
            case 6:
                return Arrays.toString(this.zzaxu);
            case 7:
                return zzmy.zza(this.zzaxv, 0, this.zzaxv.length, false);
            default:
                return "unknown";
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzu.zza(this, parcel, i);
    }

    final String zzuA() {
        return this.zzaxr;
    }

    final Bundle zzuB() {
        if (this.zzaxs == null) {
            return null;
        }
        Bundle bundle = new Bundle(this.zzaxs.size());
        for (Map.Entry entry : this.zzaxs.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
        }
        return bundle;
    }

    final int[] zzuC() {
        return this.zzaxt;
    }

    final float[] zzuD() {
        return this.zzaxu;
    }

    final byte[] zzuE() {
        return this.zzaxv;
    }

    final float zzuv() {
        return this.zzaxe;
    }
}
