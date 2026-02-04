package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsn;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class zzsw {
    final int tag;
    final byte[] zzbuv;

    zzsw(int i, byte[] bArr) {
        this.tag = i;
        this.zzbuv = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzsw)) {
            return false;
        }
        zzsw zzswVar = (zzsw) obj;
        return this.tag == zzswVar.tag && Arrays.equals(this.zzbuv, zzswVar.zzbuv);
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzbuv);
    }

    final void writeTo(zzsn zzsnVar) throws zzsn.zza {
        zzsnVar.zzmB(this.tag);
        zzsnVar.zzH(this.zzbuv);
    }

    final int zzz() {
        return zzsn.zzmC(this.tag) + 0 + this.zzbuv.length;
    }
}
