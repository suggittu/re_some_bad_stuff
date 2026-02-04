package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class FieldMappingDictionary implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    private final int mVersionCode;
    private final HashMap zzamV;
    private final ArrayList zzamW;
    private final String zzamX;

    public class Entry implements SafeParcelable {
        public static final zzd CREATOR = new zzd();
        final String className;
        final int versionCode;
        final ArrayList zzamY;

        Entry(int i, String str, ArrayList arrayList) {
            this.versionCode = i;
            this.className = str;
            this.zzamY = arrayList;
        }

        Entry(String str, Map map) {
            this.versionCode = 1;
            this.className = str;
            this.zzamY = zzM(map);
        }

        private static ArrayList zzM(Map map) {
            if (map == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : map.keySet()) {
                arrayList.add(new FieldMapPair(str, (FastJsonResponse.Field) map.get(str)));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzd zzdVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzd zzdVar = CREATOR;
            zzd.zza(this, parcel, i);
        }

        HashMap zzrC() {
            HashMap map = new HashMap();
            int size = this.zzamY.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = (FieldMapPair) this.zzamY.get(i);
                map.put(fieldMapPair.key, fieldMapPair.zzamZ);
            }
            return map;
        }
    }

    public class FieldMapPair implements SafeParcelable {
        public static final zzb CREATOR = new zzb();
        final String key;
        final int versionCode;
        final FastJsonResponse.Field zzamZ;

        FieldMapPair(int i, String str, FastJsonResponse.Field field) {
            this.versionCode = i;
            this.key = str;
            this.zzamZ = field;
        }

        FieldMapPair(String str, FastJsonResponse.Field field) {
            this.versionCode = 1;
            this.key = str;
            this.zzamZ = field;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzb zzbVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzb zzbVar = CREATOR;
            zzb.zza(this, parcel, i);
        }
    }

    FieldMappingDictionary(int i, ArrayList arrayList, String str) {
        this.mVersionCode = i;
        this.zzamW = null;
        this.zzamV = zze(arrayList);
        this.zzamX = (String) zzx.zzz(str);
        zzry();
    }

    public FieldMappingDictionary(Class cls) {
        this.mVersionCode = 1;
        this.zzamW = null;
        this.zzamV = new HashMap();
        this.zzamX = cls.getCanonicalName();
    }

    private static HashMap zze(ArrayList arrayList) {
        HashMap map = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) arrayList.get(i);
            map.put(entry.className, entry.zzrC());
        }
        return map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzc zzcVar = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.zzamV.keySet()) {
            sb.append(str).append(":\n");
            Map map = (Map) this.zzamV.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ").append(str2).append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc zzcVar = CREATOR;
        zzc.zza(this, parcel, i);
    }

    public void zza(Class cls, Map map) {
        this.zzamV.put(cls.getCanonicalName(), map);
    }

    public boolean zzb(Class cls) {
        return this.zzamV.containsKey(cls.getCanonicalName());
    }

    public Map zzcR(String str) {
        return (Map) this.zzamV.get(str);
    }

    ArrayList zzrA() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzamV.keySet()) {
            arrayList.add(new Entry(str, (Map) this.zzamV.get(str)));
        }
        return arrayList;
    }

    public String zzrB() {
        return this.zzamX;
    }

    public void zzry() {
        Iterator it = this.zzamV.keySet().iterator();
        while (it.hasNext()) {
            Map map = (Map) this.zzamV.get((String) it.next());
            Iterator it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                ((FastJsonResponse.Field) map.get((String) it2.next())).zza(this);
            }
        }
    }

    public void zzrz() {
        for (String str : this.zzamV.keySet()) {
            Map map = (Map) this.zzamV.get(str);
            HashMap map2 = new HashMap();
            for (String str2 : map.keySet()) {
                map2.put(str2, ((FastJsonResponse.Field) map.get(str2)).zzro());
            }
            this.zzamV.put(str, map2);
        }
    }
}
