package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class zzsu {
    protected volatile int zzbuu = -1;

    public static final zzsu mergeFrom(zzsu zzsuVar, byte[] bArr) {
        return mergeFrom(zzsuVar, bArr, 0, bArr.length);
    }

    public static final zzsu mergeFrom(zzsu zzsuVar, byte[] bArr, int i, int i2) throws zzst {
        try {
            zzsm zzsmVarZza = zzsm.zza(bArr, i, i2);
            zzsuVar.mergeFrom(zzsmVarZza);
            zzsmVarZza.zzmn(0);
            return zzsuVar;
        } catch (zzst e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final boolean messageNanoEquals(zzsu zzsuVar, zzsu zzsuVar2) {
        int serializedSize;
        if (zzsuVar == zzsuVar2) {
            return true;
        }
        if (zzsuVar == null || zzsuVar2 == null || zzsuVar.getClass() != zzsuVar2.getClass() || zzsuVar2.getSerializedSize() != (serializedSize = zzsuVar.getSerializedSize())) {
            return false;
        }
        byte[] bArr = new byte[serializedSize];
        byte[] bArr2 = new byte[serializedSize];
        toByteArray(zzsuVar, bArr, 0, serializedSize);
        toByteArray(zzsuVar2, bArr2, 0, serializedSize);
        return Arrays.equals(bArr, bArr2);
    }

    public static final void toByteArray(zzsu zzsuVar, byte[] bArr, int i, int i2) {
        try {
            zzsn zzsnVarZzb = zzsn.zzb(bArr, i, i2);
            zzsuVar.writeTo(zzsnVarZzb);
            zzsnVarZzb.zzJo();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final byte[] toByteArray(zzsu zzsuVar) {
        byte[] bArr = new byte[zzsuVar.getSerializedSize()];
        toByteArray(zzsuVar, bArr, 0, bArr.length);
        return bArr;
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public zzsu mo4clone() {
        return (zzsu) super.clone();
    }

    public int getCachedSize() {
        if (this.zzbuu < 0) {
            getSerializedSize();
        }
        return this.zzbuu;
    }

    public int getSerializedSize() {
        int iZzz = zzz();
        this.zzbuu = iZzz;
        return iZzz;
    }

    public abstract zzsu mergeFrom(zzsm zzsmVar);

    public String toString() {
        return zzsv.zzf(this);
    }

    public void writeTo(zzsn zzsnVar) {
    }

    public int zzz() {
        return 0;
    }
}
