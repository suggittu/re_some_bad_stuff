package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzmr {
    public static Set zzA(Object obj) {
        return Collections.singleton(obj);
    }

    public static Map zza(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        ArrayMap arrayMap = new ArrayMap(6);
        arrayMap.put(obj, obj2);
        arrayMap.put(obj3, obj4);
        arrayMap.put(obj5, obj6);
        arrayMap.put(obj7, obj8);
        arrayMap.put(obj9, obj10);
        arrayMap.put(obj11, obj12);
        return Collections.unmodifiableMap(arrayMap);
    }

    public static Set zza(Object obj, Object obj2, Object obj3) {
        zzmm zzmmVar = new zzmm(3);
        zzmmVar.add(obj);
        zzmmVar.add(obj2);
        zzmmVar.add(obj3);
        return Collections.unmodifiableSet(zzmmVar);
    }

    public static Set zza(Object obj, Object obj2, Object obj3, Object obj4) {
        zzmm zzmmVar = new zzmm(4);
        zzmmVar.add(obj);
        zzmmVar.add(obj2);
        zzmmVar.add(obj3);
        zzmmVar.add(obj4);
        return Collections.unmodifiableSet(zzmmVar);
    }

    public static List zzc(Object obj, Object obj2) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(obj);
        arrayList.add(obj2);
        return Collections.unmodifiableList(arrayList);
    }

    public static Set zzc(Object... objArr) {
        switch (objArr.length) {
            case 0:
                return zzsb();
            case 1:
                return zzA(objArr[0]);
            case 2:
                return zzd(objArr[0], objArr[1]);
            case 3:
                return zza(objArr[0], objArr[1], objArr[2]);
            case 4:
                return zza(objArr[0], objArr[1], objArr[2], objArr[3]);
            default:
                return Collections.unmodifiableSet(objArr.length <= 32 ? new zzmm(Arrays.asList(objArr)) : new HashSet(Arrays.asList(objArr)));
        }
    }

    public static Set zzd(Object obj, Object obj2) {
        zzmm zzmmVar = new zzmm(2);
        zzmmVar.add(obj);
        zzmmVar.add(obj2);
        return Collections.unmodifiableSet(zzmmVar);
    }

    public static Set zzsb() {
        return Collections.emptySet();
    }
}
