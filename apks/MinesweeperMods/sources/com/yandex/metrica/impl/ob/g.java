package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.b;
import java.util.HashMap;

/* loaded from: classes.dex */
public class g {
    private final HashMap<String, com.yandex.metrica.impl.b> a = new HashMap<>();

    public synchronized com.yandex.metrica.impl.b a(i iVar, bo boVar) {
        com.yandex.metrica.impl.b bVar;
        bVar = this.a.get(iVar.l().toString());
        if (bVar == null) {
            b.a aVarA = boVar.a();
            bVar = new com.yandex.metrica.impl.b(aVarA.a, aVarA.b);
            this.a.put(iVar.l().toString(), bVar);
        }
        return bVar;
    }

    public synchronized void a(b.a aVar, bo boVar) {
        if (aVar.b > boVar.a().b) {
            boVar.a(aVar).k();
        }
    }

    public synchronized void b(b.a aVar, bo boVar) {
        boVar.a(aVar).k();
    }
}
