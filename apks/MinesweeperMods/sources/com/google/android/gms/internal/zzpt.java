package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzpt extends com.google.android.gms.measurement.zze {
    private ProductAction zzPn;
    private final List zzPq = new ArrayList();
    private final List zzPp = new ArrayList();
    private final Map zzPo = new HashMap();

    public final String toString() {
        HashMap map = new HashMap();
        if (!this.zzPq.isEmpty()) {
            map.put("products", this.zzPq);
        }
        if (!this.zzPp.isEmpty()) {
            map.put("promotions", this.zzPp);
        }
        if (!this.zzPo.isEmpty()) {
            map.put("impressions", this.zzPo);
        }
        map.put("productAction", this.zzPn);
        return zzF(map);
    }

    public final ProductAction zzAV() {
        return this.zzPn;
    }

    public final List zzAW() {
        return Collections.unmodifiableList(this.zzPq);
    }

    public final Map zzAX() {
        return this.zzPo;
    }

    public final List zzAY() {
        return Collections.unmodifiableList(this.zzPp);
    }

    public final void zza(Product product, String str) {
        if (product == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        if (!this.zzPo.containsKey(str)) {
            this.zzPo.put(str, new ArrayList());
        }
        ((List) this.zzPo.get(str)).add(product);
    }

    @Override // com.google.android.gms.measurement.zze
    public final void zza(zzpt zzptVar) {
        zzptVar.zzPq.addAll(this.zzPq);
        zzptVar.zzPp.addAll(this.zzPp);
        for (Map.Entry entry : this.zzPo.entrySet()) {
            String str = (String) entry.getKey();
            Iterator it = ((List) entry.getValue()).iterator();
            while (it.hasNext()) {
                zzptVar.zza((Product) it.next(), str);
            }
        }
        if (this.zzPn != null) {
            zzptVar.zzPn = this.zzPn;
        }
    }
}
