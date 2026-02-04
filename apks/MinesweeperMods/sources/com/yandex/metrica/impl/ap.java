package com.yandex.metrica.impl;

import android.content.Context;
import android.content.Intent;
import com.yandex.metrica.IMetricaService;

/* loaded from: classes.dex */
class ap extends as {
    public ap(t tVar) {
        super(tVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        ad adVarA = this.c.a();
        Context contextB = this.c.b();
        if (adVarA.i()) {
            adVarA.c();
            IMetricaService iMetricaServiceF = adVarA.f();
            if (iMetricaServiceF != null) {
                try {
                    this.c.a(iMetricaServiceF, this.a, this.b);
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            return;
        }
        Intent intentB = be.b(contextB);
        intentB.putExtras(this.a.a(this.b.d()));
        contextB.startService(intentB);
    }

    static g a(Throwable th) {
        return q.c(th == null ? "" : th.getClass().getName(), bk.a((String) null, th));
    }
}
