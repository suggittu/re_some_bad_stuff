package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzst;

/* loaded from: classes2.dex */
public final class zzas extends zzso {
    public int versionCode;
    public long zzarV;
    public long zzarW;
    public long zzarX;

    public zzas() {
        zztk();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzas)) {
            return false;
        }
        zzas zzasVar = (zzas) obj;
        if (this.versionCode == zzasVar.versionCode && this.zzarV == zzasVar.zzarV && this.zzarW == zzasVar.zzarW && this.zzarX == zzasVar.zzarX) {
            return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzasVar.zzbuj == null || zzasVar.zzbuj.isEmpty() : this.zzbuj.equals(zzasVar.zzbuj);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31) + ((int) (this.zzarV ^ (this.zzarV >>> 32)))) * 31) + ((int) (this.zzarW ^ (this.zzarW >>> 32)))) * 31) + ((int) (this.zzarX ^ (this.zzarX >>> 32)))) * 31);
    }

    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
        zzsnVar.zzA(1, this.versionCode);
        zzsnVar.zzc(2, this.zzarV);
        zzsnVar.zzc(3, this.zzarW);
        zzsnVar.zzc(4, this.zzarX);
        super.writeTo(zzsnVar);
    }

    @Override // com.google.android.gms.internal.zzsu
    /* renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public final zzas mergeFrom(zzsm zzsmVar) throws zzst {
        while (true) {
            int iZzIX = zzsmVar.zzIX();
            switch (iZzIX) {
                case 0:
                    break;
                case 8:
                    this.versionCode = zzsmVar.zzJb();
                    break;
                case 16:
                    this.zzarV = zzsmVar.zzJe();
                    break;
                case 24:
                    this.zzarW = zzsmVar.zzJe();
                    break;
                case 32:
                    this.zzarX = zzsmVar.zzJe();
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

    public final zzas zztk() {
        this.versionCode = 1;
        this.zzarV = -1L;
        this.zzarW = -1L;
        this.zzarX = -1L;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    public final int zzz() {
        return super.zzz() + zzsn.zzC(1, this.versionCode) + zzsn.zze(2, this.zzarV) + zzsn.zze(3, this.zzarW) + zzsn.zze(4, this.zzarX);
    }
}
