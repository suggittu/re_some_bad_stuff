package com.google.android.gms.internal;

/* loaded from: classes2.dex */
public abstract class zzso extends zzsu {
    protected zzsq zzbuj;

    @Override // com.google.android.gms.internal.zzsu
    public void writeTo(zzsn zzsnVar) {
        if (this.zzbuj == null) {
            return;
        }
        for (int i = 0; i < this.zzbuj.size(); i++) {
            this.zzbuj.zzmG(i).writeTo(zzsnVar);
        }
    }

    @Override // com.google.android.gms.internal.zzsu
    /* renamed from: zzJp, reason: merged with bridge method [inline-methods] */
    public zzso mo4clone() {
        zzso zzsoVar = (zzso) super.mo4clone();
        zzss.zza(this, zzsoVar);
        return zzsoVar;
    }

    public final Object zza(zzsp zzspVar) {
        zzsr zzsrVarZzmF;
        if (this.zzbuj == null || (zzsrVarZzmF = this.zzbuj.zzmF(zzsx.zzmJ(zzspVar.tag))) == null) {
            return null;
        }
        return zzsrVarZzmF.zzb(zzspVar);
    }

    protected final boolean zza(zzsm zzsmVar, int i) {
        int position = zzsmVar.getPosition();
        if (!zzsmVar.zzmo(i)) {
            return false;
        }
        int iZzmJ = zzsx.zzmJ(i);
        zzsw zzswVar = new zzsw(i, zzsmVar.zzz(position, zzsmVar.getPosition() - position));
        zzsr zzsrVarZzmF = null;
        if (this.zzbuj == null) {
            this.zzbuj = new zzsq();
        } else {
            zzsrVarZzmF = this.zzbuj.zzmF(iZzmJ);
        }
        if (zzsrVarZzmF == null) {
            zzsrVarZzmF = new zzsr();
            this.zzbuj.zza(iZzmJ, zzsrVarZzmF);
        }
        zzsrVarZzmF.zza(zzswVar);
        return true;
    }

    @Override // com.google.android.gms.internal.zzsu
    public int zzz() {
        if (this.zzbuj == null) {
            return 0;
        }
        int iZzz = 0;
        for (int i = 0; i < this.zzbuj.size(); i++) {
            iZzz += this.zzbuj.zzmG(i).zzz();
        }
        return iZzz;
    }
}
