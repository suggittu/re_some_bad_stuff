package com.google.android.gms.measurement;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class zzf {
    private final zzg zzaUs;
    protected final zzc zzaUt;
    private final List zzaUu;

    public zzf(zzg zzgVar, zzmq zzmqVar) {
        zzx.zzz(zzgVar);
        this.zzaUs = zzgVar;
        this.zzaUu = new ArrayList();
        zzc zzcVar = new zzc(this, zzmqVar);
        zzcVar.zzAE();
        this.zzaUt = zzcVar;
    }

    protected zzg zzAC() {
        return this.zzaUs;
    }

    public zzc zzAF() {
        return this.zzaUt;
    }

    public List zzAG() {
        return this.zzaUt.zzAw();
    }

    protected void zza(zzc zzcVar) {
    }

    protected void zzd(zzc zzcVar) {
        Iterator it = this.zzaUu.iterator();
        while (it.hasNext()) {
            ((zzd) it.next()).zza(this, zzcVar);
        }
    }

    public zzc zziy() {
        zzc zzcVarZzAu = this.zzaUt.zzAu();
        zzd(zzcVarZzAu);
        return zzcVarZzAu;
    }
}
