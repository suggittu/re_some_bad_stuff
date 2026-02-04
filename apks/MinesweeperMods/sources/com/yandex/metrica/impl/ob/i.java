package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.q;
import java.io.Closeable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class i implements j {
    private final HandlerThread c;
    private final Handler d;
    private final Context e;
    private final h f;
    private bo g;
    private bo h;
    private bl i;
    private br j;
    private CounterConfiguration k;
    private com.yandex.metrica.impl.bj m;
    private bc n;
    private k o;
    private com.yandex.metrica.impl.b p;
    private final g q;
    private long r;
    private volatile aw s;
    private boolean a = false;
    private boolean b = false;
    private final com.yandex.metrica.impl.az l = new com.yandex.metrica.impl.az();
    private final com.yandex.metrica.impl.utils.f t = new com.yandex.metrica.impl.utils.f();
    private Runnable u = new Runnable() { // from class: com.yandex.metrica.impl.ob.i.1
        @Override // java.lang.Runnable
        public void run() {
            i.this.c();
        }
    };

    public aw a() {
        return this.s;
    }

    public i(Context context, Executor executor, h hVar, CounterConfiguration counterConfiguration, g gVar) {
        this.e = context.getApplicationContext();
        this.f = hVar;
        this.k = counterConfiguration;
        this.g = new bo(this.e, hVar.toString());
        this.r = this.g.d(0L);
        this.h = new bo(this.e, h.a(this.e.getPackageName()).toString());
        this.i = new bl(this.e, this.k.j());
        this.j = new br(this.e, l().a());
        this.s = new aw(this, this.g);
        this.c = new HandlerThread("TaskHandler [" + hVar.a() + "]");
        this.c.start();
        this.d = new Handler(this.c.getLooper());
        this.l.a(this);
        this.n = bd.a(this);
        this.m = new com.yandex.metrica.impl.bj(this, executor);
        if (this.n != null) {
            this.n.b(this);
        }
        this.o = new q(new n(this));
        this.q = gVar;
        this.p = this.q.a(this, this.g);
    }

    public void a(com.yandex.metrica.impl.g gVar) {
        if (p().b()) {
            p().a(gVar, "Event received");
        }
        if (com.yandex.metrica.impl.bk.c(this.l.a())) {
            this.l.b(this);
            this.o.a(gVar);
        }
    }

    public void b(com.yandex.metrica.impl.g gVar) {
        this.o.a(gVar);
    }

    public void c(com.yandex.metrica.impl.g gVar) {
        a(gVar, this.s.e());
    }

    public void d(com.yandex.metrica.impl.g gVar) {
        this.s.b(gVar);
        a(gVar, this.s.d());
    }

    private void a(com.yandex.metrica.impl.g gVar, ax axVar) {
        if (TextUtils.isEmpty(gVar.j())) {
            gVar.a(g());
        }
        this.n.a(gVar, axVar, this.p.b());
        this.m.b();
    }

    public synchronized void a(CounterConfiguration counterConfiguration) {
        this.k = counterConfiguration;
        this.l.d(this);
    }

    @Override // com.yandex.metrica.impl.ob.j
    public void b() {
        if ((this.n.a() >= ((long) this.k.c())) | this.a) {
            f();
            this.a = false;
        }
    }

    public synchronized void c() {
        this.b = true;
        com.yandex.metrica.impl.bk.a((Closeable) this.m);
        bd.a(this.n);
        this.d.removeCallbacksAndMessages(null);
        this.c.quit();
    }

    public void d() {
        this.d.postDelayed(this.u, com.yandex.metrica.impl.ad.a);
    }

    public synchronized void e() {
        this.m.c();
    }

    public synchronized void f() {
        this.m.a();
    }

    public String g() {
        return this.g.a((String) null);
    }

    @Override // com.yandex.metrica.impl.ob.j
    public com.yandex.metrica.impl.az h() {
        return this.l;
    }

    public bc i() {
        return this.n;
    }

    @Override // com.yandex.metrica.impl.ob.j
    public CounterConfiguration j() {
        return this.k;
    }

    public ResultReceiver k() {
        if (this.k != null) {
            return this.k.a();
        }
        return null;
    }

    @Override // com.yandex.metrica.impl.ob.j
    public h l() {
        return this.f;
    }

    @Override // com.yandex.metrica.impl.ob.j
    public Context m() {
        return this.e;
    }

    public Handler n() {
        return this.d;
    }

    @Override // com.yandex.metrica.impl.ob.j
    public synchronized boolean o() {
        return this.b;
    }

    public void a(CounterConfiguration.a aVar) {
        this.g.a(aVar).k();
        if (this.e.getPackageName().equals(this.f.a())) {
            this.h.a(aVar).k();
        }
    }

    @Override // com.yandex.metrica.impl.ob.j
    public com.yandex.metrica.impl.utils.f p() {
        if (!this.t.b() && this.k != null && this.k.t()) {
            this.t.a();
        }
        return this.t;
    }

    public void f(com.yandex.metrica.impl.g gVar) {
        b(true);
        d(gVar);
        t();
    }

    public void g(com.yandex.metrica.impl.g gVar) {
        this.p.a(gVar.i());
        this.q.a(this.p.b(), this.g);
    }

    public void q() {
        this.p.a();
        this.q.b(this.p.b(), this.g);
    }

    public void a(String str) {
        this.g.c(str).k();
    }

    public void b(String str) {
        this.h.d(str).k();
        this.j.r(str).k();
    }

    public String r() {
        return this.h.b((String) null);
    }

    public void s() {
        this.h.c().k();
    }

    public bl v() {
        return this.i;
    }

    public br w() {
        return this.j;
    }

    public boolean x() {
        CounterConfiguration.a aVarB = this.h.b();
        CounterConfiguration.a aVarB2 = this.g.b();
        if (aVarB != CounterConfiguration.a.TRUE || aVarB2 != CounterConfiguration.a.TRUE) {
            return false;
        }
        return true;
    }

    public void a(boolean z) {
        this.j.a(z).k();
    }

    public boolean y() {
        return (this.k.x() && this.j.b()) ? false : true;
    }

    public void b(boolean z) {
        this.a = z;
    }

    public void b(CounterConfiguration counterConfiguration) {
        this.k.a(counterConfiguration);
    }

    public void e(com.yandex.metrica.impl.g gVar) {
        a(com.yandex.metrica.impl.g.a(gVar, q.a.EVENT_TYPE_ALIVE), this.s.f());
    }

    public void t() {
        this.r = System.currentTimeMillis() / 1000;
        this.g.n(this.r).k();
    }

    public boolean u() {
        return ((((System.currentTimeMillis() / 1000) - this.r) > 86400L ? 1 : (((System.currentTimeMillis() / 1000) - this.r) == 86400L ? 0 : -1)) > 0) && h().F();
    }
}
