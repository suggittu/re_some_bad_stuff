package com.yandex.metrica.impl;

import android.content.Context;
import android.os.Handler;
import com.yandex.metrica.impl.ad;
import com.yandex.metrica.impl.ob.cb;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class ax {
    private Context a;
    private ay b;
    private i c;
    private Handler d;
    private cb e;
    private List<ad.a> f;
    private Map<String, com.yandex.metrica.b> g;

    /* synthetic */ ax(byte b) {
        this();
    }

    private ax() {
        this.g = new HashMap();
    }

    aa a(com.yandex.metrica.e eVar) {
        if (this.g.containsKey(eVar.getApiKey())) {
            throw new IllegalArgumentException(String.format("Failed to activate AppMetrica with provided API Key. API Key %s has already been used by another reporter.", eVar.getApiKey()));
        }
        aa aaVar = new aa(this.a, eVar, this.b);
        a(aaVar);
        this.b.a(aaVar);
        this.g.put(eVar.getApiKey(), aaVar);
        return aaVar;
    }

    synchronized com.yandex.metrica.b a(String str) {
        com.yandex.metrica.b bVar;
        bVar = this.g.get(str);
        if (bVar == null) {
            ab abVar = new ab(this.a, aw.a.get(str), str, this.b);
            a(abVar);
            this.g.put(str, abVar);
            bVar = abVar;
        }
        return bVar;
    }

    private void a(c cVar) {
        cVar.a(new x(this.d, cVar));
        cVar.a(this.c);
        cVar.a(this.e);
        cVar.a();
        this.f.add(cVar);
    }

    static class a {
        ax a = new ax(0);

        a() {
        }

        a a(Context context) {
            this.a.a = context;
            return this;
        }

        a a(ay ayVar) {
            this.a.b = ayVar;
            return this;
        }

        a a(i iVar) {
            this.a.c = iVar;
            return this;
        }

        a a(Handler handler) {
            this.a.d = handler;
            return this;
        }

        a a(cb cbVar) {
            this.a.e = cbVar;
            return this;
        }

        a a(List<ad.a> list) {
            this.a.f = list;
            return this;
        }

        ax a() {
            return this.a;
        }
    }
}
