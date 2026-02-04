package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzst;

/* loaded from: classes2.dex */
public final class zzau extends zzso {
    public long zzarW;
    public long zzarZ;

    public zzau() {
        zztm();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzau)) {
            return false;
        }
        zzau zzauVar = (zzau) obj;
        if (this.zzarZ == zzauVar.zzarZ && this.zzarW == zzauVar.zzarW) {
            return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzauVar.zzbuj == null || zzauVar.zzbuj.isEmpty() : this.zzbuj.equals(zzauVar.zzbuj);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzarZ ^ (this.zzarZ >>> 32)))) * 31) + ((int) (this.zzarW ^ (this.zzarW >>> 32)))) * 31);
    }

    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
        zzsnVar.zzc(1, this.zzarZ);
        zzsnVar.zzc(2, this.zzarW);
        super.writeTo(zzsnVar);
    }

    @Override // com.google.android.gms.internal.zzsu
    /* renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final zzau mergeFrom(zzsm zzsmVar) throws zzst {
        while (true) {
            int iZzIX = zzsmVar.zzIX();
            switch (iZzIX) {
                case 0:
                    break;
                case 8:
                    this.zzarZ = zzsmVar.zzJe();
                    break;
                case 16:
                    this.zzarW = zzsmVar.zzJe();
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

    public final zzau zztm() {
        this.zzarZ = -1L;
        this.zzarW = -1L;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    public final int zzz() {
        return super.zzz() + zzsn.zze(1, this.zzarZ) + zzsn.zze(2, this.zzarW);
    }
}
