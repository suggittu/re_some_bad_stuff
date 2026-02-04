package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class zzu {
    protected static final Comparator zzaw = new Comparator() { // from class: com.google.android.gms.internal.zzu.1
        @Override // java.util.Comparator
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    private List zzas = new LinkedList();
    private List zzat = new ArrayList(64);
    private int zzau = 0;
    private final int zzav;

    public zzu(int i) {
        this.zzav = i;
    }

    private synchronized void zzy() {
        while (this.zzau > this.zzav) {
            byte[] bArr = (byte[]) this.zzas.remove(0);
            this.zzat.remove(bArr);
            this.zzau -= bArr.length;
        }
    }

    public synchronized void zza(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.zzav) {
                this.zzas.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.zzat, bArr, zzaw);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.zzat.add(iBinarySearch, bArr);
                this.zzau += bArr.length;
                zzy();
            }
        }
    }

    public synchronized byte[] zzb(int i) {
        byte[] bArr;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.zzat.size()) {
                bArr = new byte[i];
                break;
            }
            bArr = (byte[]) this.zzat.get(i3);
            if (bArr.length >= i) {
                this.zzau -= bArr.length;
                this.zzat.remove(i3);
                this.zzas.remove(bArr);
                break;
            }
            i2 = i3 + 1;
        }
        return bArr;
    }
}
