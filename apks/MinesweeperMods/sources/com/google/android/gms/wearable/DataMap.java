package com.google.android.gms.wearable;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzsi;
import com.google.android.gms.internal.zzsj;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class DataMap {
    public static final String TAG = "DataMap";
    private final HashMap zzbrc = new HashMap();

    public static ArrayList arrayListFromBundleArrayList(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(fromBundle((Bundle) it.next()));
        }
        return arrayList2;
    }

    public static DataMap fromBundle(Bundle bundle) {
        bundle.setClassLoader(Asset.class.getClassLoader());
        DataMap dataMap = new DataMap();
        for (String str : bundle.keySet()) {
            zza(dataMap, str, bundle.get(str));
        }
        return dataMap;
    }

    public static DataMap fromByteArray(byte[] bArr) {
        try {
            return zzsi.zza(new zzsi.zza(zzsj.zzA(bArr), new ArrayList()));
        } catch (zzst e) {
            throw new IllegalArgumentException("Unable to convert data", e);
        }
    }

    private static void zza(DataMap dataMap, String str, Object obj) {
        if (obj instanceof String) {
            dataMap.putString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            dataMap.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            dataMap.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            dataMap.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Float) {
            dataMap.putFloat(str, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Boolean) {
            dataMap.putBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Byte) {
            dataMap.putByte(str, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof byte[]) {
            dataMap.putByteArray(str, (byte[]) obj);
            return;
        }
        if (obj instanceof String[]) {
            dataMap.putStringArray(str, (String[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            dataMap.putLongArray(str, (long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            dataMap.putFloatArray(str, (float[]) obj);
            return;
        }
        if (obj instanceof Asset) {
            dataMap.putAsset(str, (Asset) obj);
            return;
        }
        if (obj instanceof Bundle) {
            dataMap.putDataMap(str, fromBundle((Bundle) obj));
            return;
        }
        if (obj instanceof ArrayList) {
            switch (zzf((ArrayList) obj)) {
                case 0:
                    dataMap.putStringArrayList(str, (ArrayList) obj);
                    break;
                case 1:
                    dataMap.putStringArrayList(str, (ArrayList) obj);
                    break;
                case 2:
                    dataMap.putIntegerArrayList(str, (ArrayList) obj);
                    break;
                case 3:
                    dataMap.putStringArrayList(str, (ArrayList) obj);
                    break;
                case 5:
                    dataMap.putDataMapArrayList(str, arrayListFromBundleArrayList((ArrayList) obj));
                    break;
            }
        }
    }

    private void zza(String str, Object obj, String str2, ClassCastException classCastException) {
        zza(str, obj, str2, "<null>", classCastException);
    }

    private void zza(String str, Object obj, String str2, Object obj2, ClassCastException classCastException) {
        Log.w(TAG, "Key " + str + " expected " + str2 + " but value was a " + obj.getClass().getName() + ".  The default value " + obj2 + " was returned.");
        Log.w(TAG, "Attempt to cast generated internal exception:", classCastException);
    }

    private static boolean zza(Asset asset, Asset asset2) {
        return (asset == null || asset2 == null) ? asset == asset2 : !TextUtils.isEmpty(asset.getDigest()) ? asset.getDigest().equals(asset2.getDigest()) : Arrays.equals(asset.getData(), asset2.getData());
    }

    private static boolean zza(DataMap dataMap, DataMap dataMap2) {
        if (dataMap.size() != dataMap2.size()) {
            return false;
        }
        for (String str : dataMap.keySet()) {
            Object obj = dataMap.get(str);
            Object obj2 = dataMap2.get(str);
            if (obj instanceof Asset) {
                if ((obj2 instanceof Asset) && zza((Asset) obj, (Asset) obj2)) {
                }
                return false;
            }
            if (obj instanceof String[]) {
                if ((obj2 instanceof String[]) && Arrays.equals((String[]) obj, (String[]) obj2)) {
                }
                return false;
            }
            if (obj instanceof long[]) {
                if ((obj2 instanceof long[]) && Arrays.equals((long[]) obj, (long[]) obj2)) {
                }
                return false;
            }
            if (obj instanceof float[]) {
                if ((obj2 instanceof float[]) && Arrays.equals((float[]) obj, (float[]) obj2)) {
                }
                return false;
            }
            if (obj instanceof byte[]) {
                if ((obj2 instanceof byte[]) && Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                }
                return false;
            }
            if (obj == null || obj2 == null) {
                return obj == obj2;
            }
            if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private static void zzb(Bundle bundle, String str, Object obj) {
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Byte) {
            bundle.putByte(str, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
            return;
        }
        if (obj instanceof String[]) {
            bundle.putStringArray(str, (String[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            bundle.putFloatArray(str, (float[]) obj);
            return;
        }
        if (obj instanceof Asset) {
            bundle.putParcelable(str, (Asset) obj);
            return;
        }
        if (obj instanceof DataMap) {
            bundle.putParcelable(str, ((DataMap) obj).toBundle());
            return;
        }
        if (obj instanceof ArrayList) {
            switch (zzf((ArrayList) obj)) {
                case 0:
                    bundle.putStringArrayList(str, (ArrayList) obj);
                    break;
                case 1:
                    bundle.putStringArrayList(str, (ArrayList) obj);
                    break;
                case 2:
                    bundle.putIntegerArrayList(str, (ArrayList) obj);
                    break;
                case 3:
                    bundle.putStringArrayList(str, (ArrayList) obj);
                    break;
                case 4:
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    Iterator it = ((ArrayList) obj).iterator();
                    while (it.hasNext()) {
                        arrayList.add(((DataMap) it.next()).toBundle());
                    }
                    bundle.putParcelableArrayList(str, arrayList);
                    break;
            }
        }
    }

    private static int zzf(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return 0;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null) {
                if (next instanceof Integer) {
                    return 2;
                }
                if (next instanceof String) {
                    return 3;
                }
                if (next instanceof DataMap) {
                    return 4;
                }
                if (next instanceof Bundle) {
                    return 5;
                }
            }
        }
        return 1;
    }

    public void clear() {
        this.zzbrc.clear();
    }

    public boolean containsKey(String str) {
        return this.zzbrc.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataMap) {
            return zza(this, (DataMap) obj);
        }
        return false;
    }

    public Object get(String str) {
        return this.zzbrc.get(str);
    }

    public Asset getAsset(String str) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (Asset) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "Asset", e);
            return null;
        }
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return z;
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException e) {
            zza(str, obj, "Boolean", Boolean.valueOf(z), e);
            return z;
        }
    }

    public byte getByte(String str) {
        return getByte(str, (byte) 0);
    }

    public byte getByte(String str, byte b) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return b;
        }
        try {
            return ((Byte) obj).byteValue();
        } catch (ClassCastException e) {
            zza(str, obj, "Byte", Byte.valueOf(b), e);
            return b;
        }
    }

    public byte[] getByteArray(String str) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (byte[]) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "byte[]", e);
            return null;
        }
    }

    public DataMap getDataMap(String str) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (DataMap) obj;
        } catch (ClassCastException e) {
            zza(str, obj, TAG, e);
            return null;
        }
    }

    public ArrayList getDataMapArrayList(String str) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "ArrayList<DataMap>", e);
            return null;
        }
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public double getDouble(String str, double d) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return d;
        }
        try {
            return ((Double) obj).doubleValue();
        } catch (ClassCastException e) {
            zza(str, obj, "Double", Double.valueOf(d), e);
            return d;
        }
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public float getFloat(String str, float f) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return f;
        }
        try {
            return ((Float) obj).floatValue();
        } catch (ClassCastException e) {
            zza(str, obj, "Float", Float.valueOf(f), e);
            return f;
        }
    }

    public float[] getFloatArray(String str) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (float[]) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "float[]", e);
            return null;
        }
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return i;
        }
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException e) {
            zza(str, obj, "Integer", e);
            return i;
        }
    }

    public ArrayList getIntegerArrayList(String str) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "ArrayList<Integer>", e);
            return null;
        }
    }

    public long getLong(String str) {
        return getLong(str, 0L);
    }

    public long getLong(String str, long j) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return j;
        }
        try {
            return ((Long) obj).longValue();
        } catch (ClassCastException e) {
            zza(str, obj, "long", e);
            return j;
        }
    }

    public long[] getLongArray(String str) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (long[]) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "long[]", e);
            return null;
        }
    }

    public String getString(String str) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (String) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "String", e);
            return null;
        }
    }

    public String getString(String str, String str2) {
        String string = getString(str);
        return string == null ? str2 : string;
    }

    public String[] getStringArray(String str) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (String[]) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "String[]", e);
            return null;
        }
    }

    public ArrayList getStringArrayList(String str) {
        Object obj = this.zzbrc.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "ArrayList<String>", e);
            return null;
        }
    }

    public int hashCode() {
        return this.zzbrc.hashCode() * 29;
    }

    public boolean isEmpty() {
        return this.zzbrc.isEmpty();
    }

    public Set keySet() {
        return this.zzbrc.keySet();
    }

    public void putAll(DataMap dataMap) {
        for (String str : dataMap.keySet()) {
            this.zzbrc.put(str, dataMap.get(str));
        }
    }

    public void putAsset(String str, Asset asset) {
        this.zzbrc.put(str, asset);
    }

    public void putBoolean(String str, boolean z) {
        this.zzbrc.put(str, Boolean.valueOf(z));
    }

    public void putByte(String str, byte b) {
        this.zzbrc.put(str, Byte.valueOf(b));
    }

    public void putByteArray(String str, byte[] bArr) {
        this.zzbrc.put(str, bArr);
    }

    public void putDataMap(String str, DataMap dataMap) {
        this.zzbrc.put(str, dataMap);
    }

    public void putDataMapArrayList(String str, ArrayList arrayList) {
        this.zzbrc.put(str, arrayList);
    }

    public void putDouble(String str, double d) {
        this.zzbrc.put(str, Double.valueOf(d));
    }

    public void putFloat(String str, float f) {
        this.zzbrc.put(str, Float.valueOf(f));
    }

    public void putFloatArray(String str, float[] fArr) {
        this.zzbrc.put(str, fArr);
    }

    public void putInt(String str, int i) {
        this.zzbrc.put(str, Integer.valueOf(i));
    }

    public void putIntegerArrayList(String str, ArrayList arrayList) {
        this.zzbrc.put(str, arrayList);
    }

    public void putLong(String str, long j) {
        this.zzbrc.put(str, Long.valueOf(j));
    }

    public void putLongArray(String str, long[] jArr) {
        this.zzbrc.put(str, jArr);
    }

    public void putString(String str, String str2) {
        this.zzbrc.put(str, str2);
    }

    public void putStringArray(String str, String[] strArr) {
        this.zzbrc.put(str, strArr);
    }

    public void putStringArrayList(String str, ArrayList arrayList) {
        this.zzbrc.put(str, arrayList);
    }

    public Object remove(String str) {
        return this.zzbrc.remove(str);
    }

    public int size() {
        return this.zzbrc.size();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        for (String str : this.zzbrc.keySet()) {
            zzb(bundle, str, this.zzbrc.get(str));
        }
        return bundle;
    }

    public byte[] toByteArray() {
        return zzsu.toByteArray(zzsi.zza(this).zzbty);
    }

    public String toString() {
        return this.zzbrc.toString();
    }
}
