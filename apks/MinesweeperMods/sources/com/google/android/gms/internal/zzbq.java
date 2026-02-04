package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@zzhb
/* loaded from: classes2.dex */
public class zzbq {
    private final Collection zzvu = new ArrayList();
    private final Collection zzvv = new ArrayList();
    private final Collection zzvw = new ArrayList();

    public void zza(zzbp zzbpVar) {
        this.zzvu.add(zzbpVar);
    }

    public void zzb(zzbp zzbpVar) {
        this.zzvv.add(zzbpVar);
    }

    public void zzc(zzbp zzbpVar) {
        this.zzvw.add(zzbpVar);
    }

    public List zzdr() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.zzvv.iterator();
        while (it.hasNext()) {
            String str = (String) ((zzbp) it.next()).get();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public List zzds() {
        List listZzdr = zzdr();
        Iterator it = this.zzvw.iterator();
        while (it.hasNext()) {
            String str = (String) ((zzbp) it.next()).get();
            if (str != null) {
                listZzdr.add(str);
            }
        }
        return listZzdr;
    }
}
