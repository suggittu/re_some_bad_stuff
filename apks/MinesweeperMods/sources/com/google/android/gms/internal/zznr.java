package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class zznr {
    public static boolean zza(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!list2.contains(it.next())) {
                return false;
            }
        }
        return true;
    }
}
