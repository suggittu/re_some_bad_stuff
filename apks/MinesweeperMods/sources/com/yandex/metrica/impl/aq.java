package com.yandex.metrica.impl;

import com.yandex.metrica.IMetricaService;

/* loaded from: classes.dex */
class aq extends as {
    public aq(t tVar) {
        super(tVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        IMetricaService iMetricaServiceF = this.c.a().f();
        try {
            for (g gVar : this.b.f()) {
                if (iMetricaServiceF != null) {
                    this.c.a(iMetricaServiceF, gVar, this.b);
                }
            }
        } catch (Exception e) {
        }
    }
}
