package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public class zzb {
    private final zzc zzbbZ;

    public zzb(byte[] bArr) {
        this.zzbbZ = new zzc(zzu(bArr));
    }

    private static byte[] zzu(byte[] bArr) {
        zzx.zzb(bArr.length == 16, "Bytes must be a namespace plus instance (16 bytes).");
        return bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzb) {
            return zzw.equal(this.zzbbZ, ((zzb) obj).zzbbZ);
        }
        return false;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbbZ);
    }

    public String toString() {
        return "EddystoneUid{id=" + zzEt() + '}';
    }

    public String zzEt() {
        return this.zzbbZ.zzEt();
    }
}
