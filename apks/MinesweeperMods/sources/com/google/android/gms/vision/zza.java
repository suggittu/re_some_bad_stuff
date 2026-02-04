package com.google.android.gms.vision;

import android.util.SparseArray;

/* loaded from: classes2.dex */
public class zza {
    private SparseArray zzbnm = new SparseArray();
    private SparseArray zzbnn = new SparseArray();
    private static final Object zzqy = new Object();
    private static int zzbnl = 0;

    public int zzkr(int i) {
        int iIntValue;
        synchronized (zzqy) {
            Integer num = (Integer) this.zzbnm.get(i);
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                iIntValue = zzbnl;
                zzbnl++;
                this.zzbnm.append(i, Integer.valueOf(iIntValue));
                this.zzbnn.append(iIntValue, Integer.valueOf(i));
            }
        }
        return iIntValue;
    }

    public int zzks(int i) {
        int iIntValue;
        synchronized (zzqy) {
            iIntValue = ((Integer) this.zzbnn.get(i)).intValue();
        }
        return iIntValue;
    }
}
