package com.yandex.metrica.impl;

import com.yandex.metrica.IMetricaService;

/* loaded from: classes.dex */
class ar extends as {
    public ar(t tVar) {
        super(tVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.c()) {
            ad adVarA = this.c.a();
            try {
                if (adVarA.i()) {
                    IMetricaService iMetricaServiceF = adVarA.f();
                    if (iMetricaServiceF != null) {
                        this.c.a(iMetricaServiceF, this.a, this.b);
                    }
                } else {
                    this.b.a(this.a);
                    adVarA.a();
                }
            } catch (Exception e) {
                adVarA.a();
            }
        }
    }
}
