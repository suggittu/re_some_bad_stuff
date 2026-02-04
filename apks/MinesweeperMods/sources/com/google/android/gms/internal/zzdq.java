package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzhb
/* loaded from: classes2.dex */
public class zzdq implements Iterable {
    private final List zzzM = new LinkedList();

    private zzdp zzf(zzjp zzjpVar) {
        Iterator it = com.google.android.gms.ads.internal.zzr.zzbR().iterator();
        while (it.hasNext()) {
            zzdp zzdpVar = (zzdp) it.next();
            if (zzdpVar.zzpD == zzjpVar) {
                return zzdpVar;
            }
        }
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.zzzM.iterator();
    }

    public void zza(zzdp zzdpVar) {
        this.zzzM.add(zzdpVar);
    }

    public void zzb(zzdp zzdpVar) {
        this.zzzM.remove(zzdpVar);
    }

    public boolean zzd(zzjp zzjpVar) {
        zzdp zzdpVarZzf = zzf(zzjpVar);
        if (zzdpVarZzf == null) {
            return false;
        }
        zzdpVarZzf.zzzJ.abort();
        return true;
    }

    public boolean zze(zzjp zzjpVar) {
        return zzf(zzjpVar) != null;
    }
}
