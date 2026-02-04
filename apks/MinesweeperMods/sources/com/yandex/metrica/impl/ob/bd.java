package com.yandex.metrica.impl.ob;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class bd {
    private static final Map<String, bc> a = new HashMap();
    private static final Map<String, bc> b = new HashMap();

    public static synchronized bc a(j jVar) {
        bc bcVar;
        if (!com.yandex.metrica.impl.bk.c(jVar.h().a())) {
            bcVar = null;
        } else {
            h hVarL = jVar.l();
            bcVar = b.get(hVarL.toString());
            if (bcVar == null) {
                bcVar = a.get(hVarL.toString());
                if (bcVar == null) {
                    bcVar = new bc(jVar);
                    a(hVarL, bcVar);
                } else {
                    bcVar.a(jVar);
                    a(hVarL, bcVar);
                }
            }
        }
        return bcVar;
    }

    public static synchronized void a(bc bcVar) {
        if (bcVar != null) {
            j jVarB = bcVar.b();
            if (jVarB != null) {
                h hVarL = jVarB.l();
                b.remove(hVarL.toString());
                a.put(hVarL.toString(), bcVar);
            }
            com.yandex.metrica.impl.bk.a((Closeable) bcVar);
        }
    }

    private static void a(h hVar, bc bcVar) {
        a.remove(hVar.toString());
        b.put(hVar.toString(), bcVar);
    }
}
