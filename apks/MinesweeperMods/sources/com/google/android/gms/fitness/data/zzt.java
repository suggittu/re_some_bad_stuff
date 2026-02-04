package com.google.android.gms.fitness.data;

import java.util.List;

/* loaded from: classes2.dex */
public class zzt {
    public static int zza(Object obj, List list) {
        if (obj == null) {
            return -1;
        }
        int iIndexOf = list.indexOf(obj);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        list.add(obj);
        return list.size() - 1;
    }
}
