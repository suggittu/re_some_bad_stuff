package com.yandex.metrica.impl;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.yandex.metrica.IMetricaService;
import com.yandex.metrica.impl.ad;
import com.yandex.metrica.impl.at;
import com.yandex.metrica.impl.ob.cb;
import com.yandex.metrica.impl.q;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class ay implements ad.a, t {
    private final Context a;
    private ad b;
    private final NativeCrashesHelper c;
    private final ExecutorService d;
    private aa e;
    private v f;
    private cb g;
    private List<ad.a> h;

    ay(ExecutorService executorService, Context context, Handler handler) {
        this.b = new ad(context, handler);
        this.b.a(this);
        this.d = executorService;
        this.a = context;
        this.c = new NativeCrashesHelper(context);
        this.f = new v(context);
    }

    void a(aa aaVar) {
        this.e = aaVar;
    }

    void a(cb cbVar) {
        this.g = cbVar;
        this.f.b(cbVar);
    }

    void a(i iVar) {
        this.f.a(iVar);
    }

    void a(List<ad.a> list) {
        this.h = list;
    }

    void a(boolean z, aw awVar) {
        awVar.b().b(z);
        this.c.a(z);
    }

    void a(String str, aw awVar) {
        com.yandex.metrica.impl.utils.f.e().a("Error received: native", new Object[0]);
        a(q.a(q.a.EVENT_TYPE_NATIVE_CRASH, str), awVar);
    }

    void a(String str) {
        a(str, this.e.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public as b(g gVar, aw awVar) {
        this.b.d();
        if (gVar.c() == q.a.EVENT_TYPE_EXCEPTION_USER.a()) {
            gVar.e(awVar.i());
        }
        return new ar(this).a(gVar);
    }

    void a(g gVar, aw awVar) {
        a(b(gVar, awVar), awVar);
    }

    public void a(g gVar, aw awVar, final Map<String, Object> map) {
        a(new at(this).a(new at.a() { // from class: com.yandex.metrica.impl.ay.2
            @Override // com.yandex.metrica.impl.at.a
            public g a(g gVar2, aw awVar2) {
                return gVar2.c(bk.b(map));
            }
        }).b(new at.a() { // from class: com.yandex.metrica.impl.ay.1
            @Override // com.yandex.metrica.impl.at.a
            public g a(g gVar2, aw awVar2) {
                ay.this.b(gVar2, awVar2).a(awVar2).run();
                return gVar2;
            }
        }).a(gVar), awVar);
    }

    public void c() {
        a(q.d(q.a.EVENT_TYPE_STARTUP), this.f);
    }

    public void b(String str) {
        a(q.d(str), this.f);
    }

    public void a(aw awVar) {
        a(q.a(awVar.j()), awVar);
    }

    public void c(String str) throws IllegalArgumentException {
        this.f.b().g(str);
    }

    public void a(Map<String, String> map) {
        this.f.b().a(map);
    }

    public void d(String str) {
        this.f.b().i(str);
    }

    void a(Throwable th, aw awVar) {
        if (awVar.b().B()) {
            com.yandex.metrica.impl.utils.f.e().a("Error received: uncaught", new Object[0]);
        }
        this.b.d();
        g gVarA = ap.a(th);
        gVarA.e(awVar.i());
        a(new ap(this).a(gVarA), awVar);
    }

    void d() {
        this.b.d();
    }

    void h() {
        this.b.c();
    }

    @Override // com.yandex.metrica.impl.ad.a
    public void e() {
        i();
        Iterator<ad.a> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        this.b.a(false);
    }

    @Override // com.yandex.metrica.impl.ad.a
    public void g() {
        a(false);
        Iterator<ad.a> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().g();
        }
        this.b.a(true);
    }

    @Override // com.yandex.metrica.impl.ad.a
    public void f() {
        a(false);
        Iterator<ad.a> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        this.b.a(true);
    }

    @Override // com.yandex.metrica.impl.t
    public void a(IMetricaService iMetricaService, g gVar, aw awVar) throws RemoteException {
        a(true);
        c(awVar);
        if (awVar.b().l()) {
            this.c.a(this, this.d);
        }
        iMetricaService.reportData(gVar.a(awVar.d()));
        if (this.e != null && !this.e.a_()) {
            return;
        }
        this.b.c();
    }

    public void a(String str, String str2, aw awVar) {
        a(new ar(this).a(new g().a(q.a.EVENT_TYPE_APP_ENVIRONMENT_UPDATED.a()).a(str, str2)), awVar);
    }

    public void b(aw awVar) {
        a(new ar(this).a(new g().a(q.a.EVENT_TYPE_APP_ENVIRONMENT_CLEARED.a())), awVar);
    }

    void a(boolean z) {
        if (z) {
            z.a(this.a).a(this);
        } else {
            z.a(this.a).b(this);
        }
    }

    void c(aw awVar) {
        if (awVar.b().B()) {
            awVar.b().e(com.yandex.metrica.impl.utils.f.e().b());
        }
    }

    void i() {
        d(this.f);
    }

    void d(aw awVar) {
        if (awVar.e()) {
            a(new aq(this), awVar);
        }
    }

    private void a(as asVar, aw awVar) {
        awVar.a(this.g);
        this.d.execute(asVar.a(awVar));
    }

    @Override // com.yandex.metrica.impl.t
    public ad a() {
        return this.b;
    }

    @Override // com.yandex.metrica.impl.t
    public Context b() {
        return this.a;
    }
}
