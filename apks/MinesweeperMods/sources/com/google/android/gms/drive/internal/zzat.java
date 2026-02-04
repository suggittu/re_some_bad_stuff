package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;

/* loaded from: classes2.dex */
public final class zzat extends zzso {
    public int versionCode;
    public long zzarW;
    public String zzarY;
    public long zzarZ;
    public int zzasa;

    public zzat() {
        zztl();
    }

    public static zzat zzm(byte[] bArr) {
        return (zzat) zzsu.mergeFrom(new zzat(), bArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        zzat zzatVar = (zzat) obj;
        if (this.versionCode != zzatVar.versionCode) {
            return false;
        }
        if (this.zzarY == null) {
            if (zzatVar.zzarY != null) {
                return false;
            }
        } else if (!this.zzarY.equals(zzatVar.zzarY)) {
            return false;
        }
        if (this.zzarZ == zzatVar.zzarZ && this.zzarW == zzatVar.zzarW && this.zzasa == zzatVar.zzasa) {
            return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzatVar.zzbuj == null || zzatVar.zzbuj.isEmpty() : this.zzbuj.equals(zzatVar.zzbuj);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((((((((this.zzarY == null ? 0 : this.zzarY.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31)) * 31) + ((int) (this.zzarZ ^ (this.zzarZ >>> 32)))) * 31) + ((int) (this.zzarW ^ (this.zzarW >>> 32)))) * 31) + this.zzasa) * 31;
        if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
            iHashCode = this.zzbuj.hashCode();
        }
        return iHashCode2 + iHashCode;
    }

    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
        zzsnVar.zzA(1, this.versionCode);
        zzsnVar.zzn(2, this.zzarY);
        zzsnVar.zzc(3, this.zzarZ);
        zzsnVar.zzc(4, this.zzarW);
        if (this.zzasa != -1) {
            zzsnVar.zzA(5, this.zzasa);
        }
        super.writeTo(zzsnVar);
    }

    @Override // com.google.android.gms.internal.zzsu
    /* renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final zzat mergeFrom(zzsm zzsmVar) throws zzst {
        while (true) {
            int iZzIX = zzsmVar.zzIX();
            switch (iZzIX) {
                case 0:
                    break;
                case 8:
                    this.versionCode = zzsmVar.zzJb();
                    break;
                case 18:
                    this.zzarY = zzsmVar.readString();
                    break;
                case 24:
                    this.zzarZ = zzsmVar.zzJe();
                    break;
                case 32:
                    this.zzarW = zzsmVar.zzJe();
                    break;
                case 40:
                    this.zzasa = zzsmVar.zzJb();
                    break;
                default:
                    if (!zza(zzsmVar, iZzIX)) {
                        break;
                    } else {
                        break;
                    }
            }
        }
        return this;
    }

    public final zzat zztl() {
        this.versionCode = 1;
        this.zzarY = "";
        this.zzarZ = -1L;
        this.zzarW = -1L;
        this.zzasa = -1;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    public final int zzz() {
        int iZzz = super.zzz() + zzsn.zzC(1, this.versionCode) + zzsn.zzo(2, this.zzarY) + zzsn.zze(3, this.zzarZ) + zzsn.zze(4, this.zzarW);
        return this.zzasa != -1 ? iZzz + zzsn.zzC(5, this.zzasa) : iZzz;
    }
}
