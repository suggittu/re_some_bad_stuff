package com.google.android.gms.internal;

import com.google.android.gms.nearby.messages.Strategy;

/* loaded from: classes2.dex */
public final class zzsm {
    private final byte[] buffer;
    private int zzbtZ;
    private int zzbua;
    private int zzbub;
    private int zzbuc;
    private int zzbud;
    private int zzbuf;
    private int zzbue = Strategy.TTL_SECONDS_INFINITE;
    private int zzbug = 64;
    private int zzbuh = 67108864;

    private zzsm(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzbtZ = i;
        this.zzbua = i + i2;
        this.zzbuc = i;
    }

    public static zzsm zzD(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    private void zzJj() {
        this.zzbua += this.zzbub;
        int i = this.zzbua;
        if (i <= this.zzbue) {
            this.zzbub = 0;
        } else {
            this.zzbub = i - this.zzbue;
            this.zzbua -= this.zzbub;
        }
    }

    public static zzsm zza(byte[] bArr, int i, int i2) {
        return new zzsm(bArr, i, i2);
    }

    public static long zzan(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static int zzmp(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public final int getPosition() {
        return this.zzbuc - this.zzbtZ;
    }

    public final byte[] readBytes() throws zzst {
        int iZzJf = zzJf();
        if (iZzJf > this.zzbua - this.zzbuc || iZzJf <= 0) {
            return iZzJf == 0 ? zzsx.zzbuD : zzmt(iZzJf);
        }
        byte[] bArr = new byte[iZzJf];
        System.arraycopy(this.buffer, this.zzbuc, bArr, 0, iZzJf);
        this.zzbuc = iZzJf + this.zzbuc;
        return bArr;
    }

    public final double readDouble() {
        return Double.longBitsToDouble(zzJi());
    }

    public final float readFloat() {
        return Float.intBitsToFloat(zzJh());
    }

    public final String readString() throws zzst {
        int iZzJf = zzJf();
        if (iZzJf > this.zzbua - this.zzbuc || iZzJf <= 0) {
            return new String(zzmt(iZzJf), "UTF-8");
        }
        String str = new String(this.buffer, this.zzbuc, iZzJf, "UTF-8");
        this.zzbuc = iZzJf + this.zzbuc;
        return str;
    }

    public final int zzIX() throws zzst {
        if (zzJl()) {
            this.zzbud = 0;
            return 0;
        }
        this.zzbud = zzJf();
        if (this.zzbud == 0) {
            throw zzst.zzJv();
        }
        return this.zzbud;
    }

    public final void zzIY() throws zzst {
        int iZzIX;
        do {
            iZzIX = zzIX();
            if (iZzIX == 0) {
                return;
            }
        } while (zzmo(iZzIX));
    }

    public final long zzIZ() {
        return zzJg();
    }

    public final long zzJa() {
        return zzJg();
    }

    public final int zzJb() {
        return zzJf();
    }

    public final boolean zzJc() {
        return zzJf() != 0;
    }

    public final int zzJd() {
        return zzmp(zzJf());
    }

    public final long zzJe() {
        return zzan(zzJg());
    }

    public final int zzJf() throws zzst {
        byte bZzJm = zzJm();
        if (bZzJm >= 0) {
            return bZzJm;
        }
        int i = bZzJm & 127;
        byte bZzJm2 = zzJm();
        if (bZzJm2 >= 0) {
            return i | (bZzJm2 << 7);
        }
        int i2 = i | ((bZzJm2 & 127) << 7);
        byte bZzJm3 = zzJm();
        if (bZzJm3 >= 0) {
            return i2 | (bZzJm3 << 14);
        }
        int i3 = i2 | ((bZzJm3 & 127) << 14);
        byte bZzJm4 = zzJm();
        if (bZzJm4 >= 0) {
            return i3 | (bZzJm4 << 21);
        }
        int i4 = i3 | ((bZzJm4 & 127) << 21);
        byte bZzJm5 = zzJm();
        int i5 = i4 | (bZzJm5 << 28);
        if (bZzJm5 >= 0) {
            return i5;
        }
        for (int i6 = 0; i6 < 5; i6++) {
            if (zzJm() >= 0) {
                return i5;
            }
        }
        throw zzst.zzJu();
    }

    public final long zzJg() throws zzst {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & 127) << i;
            if ((zzJm() & 128) == 0) {
                return j;
            }
        }
        throw zzst.zzJu();
    }

    public final int zzJh() throws zzst {
        return (zzJm() & 255) | ((zzJm() & 255) << 8) | ((zzJm() & 255) << 16) | ((zzJm() & 255) << 24);
    }

    public final long zzJi() throws zzst {
        return ((zzJm() & 255) << 8) | (zzJm() & 255) | ((zzJm() & 255) << 16) | ((zzJm() & 255) << 24) | ((zzJm() & 255) << 32) | ((zzJm() & 255) << 40) | ((zzJm() & 255) << 48) | ((zzJm() & 255) << 56);
    }

    public final int zzJk() {
        if (this.zzbue == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzbue - this.zzbuc;
    }

    public final boolean zzJl() {
        return this.zzbuc == this.zzbua;
    }

    public final byte zzJm() throws zzst {
        if (this.zzbuc == this.zzbua) {
            throw zzst.zzJs();
        }
        byte[] bArr = this.buffer;
        int i = this.zzbuc;
        this.zzbuc = i + 1;
        return bArr[i];
    }

    public final void zza(zzsu zzsuVar) throws zzst {
        int iZzJf = zzJf();
        if (this.zzbuf >= this.zzbug) {
            throw zzst.zzJy();
        }
        int iZzmq = zzmq(iZzJf);
        this.zzbuf++;
        zzsuVar.mergeFrom(this);
        zzmn(0);
        this.zzbuf--;
        zzmr(iZzmq);
    }

    public final void zza(zzsu zzsuVar, int i) throws zzst {
        if (this.zzbuf >= this.zzbug) {
            throw zzst.zzJy();
        }
        this.zzbuf++;
        zzsuVar.mergeFrom(this);
        zzmn(zzsx.zzF(i, 4));
        this.zzbuf--;
    }

    public final void zzmn(int i) {
        if (this.zzbud != i) {
            throw zzst.zzJw();
        }
    }

    public final boolean zzmo(int i) {
        switch (zzsx.zzmI(i)) {
            case 0:
                zzJb();
                return true;
            case 1:
                zzJi();
                return true;
            case 2:
                zzmu(zzJf());
                return true;
            case 3:
                zzIY();
                zzmn(zzsx.zzF(zzsx.zzmJ(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                zzJh();
                return true;
            default:
                throw zzst.zzJx();
        }
    }

    public final int zzmq(int i) throws zzst {
        if (i < 0) {
            throw zzst.zzJt();
        }
        int i2 = this.zzbuc + i;
        int i3 = this.zzbue;
        if (i2 > i3) {
            throw zzst.zzJs();
        }
        this.zzbue = i2;
        zzJj();
        return i3;
    }

    public final void zzmr(int i) {
        this.zzbue = i;
        zzJj();
    }

    public final void zzms(int i) {
        if (i > this.zzbuc - this.zzbtZ) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.zzbuc - this.zzbtZ));
        }
        if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        }
        this.zzbuc = this.zzbtZ + i;
    }

    public final byte[] zzmt(int i) throws zzst {
        if (i < 0) {
            throw zzst.zzJt();
        }
        if (this.zzbuc + i > this.zzbue) {
            zzmu(this.zzbue - this.zzbuc);
            throw zzst.zzJs();
        }
        if (i > this.zzbua - this.zzbuc) {
            throw zzst.zzJs();
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, this.zzbuc, bArr, 0, i);
        this.zzbuc += i;
        return bArr;
    }

    public final void zzmu(int i) throws zzst {
        if (i < 0) {
            throw zzst.zzJt();
        }
        if (this.zzbuc + i > this.zzbue) {
            zzmu(this.zzbue - this.zzbuc);
            throw zzst.zzJs();
        }
        if (i > this.zzbua - this.zzbuc) {
            throw zzst.zzJs();
        }
        this.zzbuc += i;
    }

    public final byte[] zzz(int i, int i2) {
        if (i2 == 0) {
            return zzsx.zzbuD;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzbtZ + i, bArr, 0, i2);
        return bArr;
    }
}
