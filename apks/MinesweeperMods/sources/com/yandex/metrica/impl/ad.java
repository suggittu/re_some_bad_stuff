package com.yandex.metrica.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.yandex.metrica.IMetricaService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ad {
    public static final long a = TimeUnit.SECONDS.toMillis(10);
    private final Context b;
    private final Handler c;
    private IMetricaService d = null;
    private a e = null;
    private boolean f = false;
    private boolean g = true;
    private final Runnable h = new Runnable() { // from class: com.yandex.metrica.impl.ad.1
        @Override // java.lang.Runnable
        public void run() {
            ad.this.g();
        }
    };
    private final ServiceConnection i = new ServiceConnection() { // from class: com.yandex.metrica.impl.ad.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            ad.this.f = true;
            ad.this.d = IMetricaService.Stub.asInterface(service);
            ad.a(ad.this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            ad.this.f = false;
            ad.this.d = null;
            ad.b(ad.this);
        }
    };

    interface a {
        void e();

        void f();

        void g();
    }

    public ad(Context context, Handler handler) {
        this.b = context.getApplicationContext();
        this.c = handler;
    }

    public synchronized void a() {
        if (!this.f) {
            try {
                this.b.bindService(be.b(this.b), this.i, 1);
            } catch (Exception e) {
            }
        }
    }

    public void b() {
        if (this.f) {
            this.b.unbindService(this.i);
            this.f = false;
        }
    }

    public void c() {
        this.c.removeCallbacks(this.h);
        this.c.postDelayed(this.h, a);
    }

    void d() {
        this.c.removeCallbacks(this.h);
    }

    public boolean e() {
        return this.d != null;
    }

    public IMetricaService f() {
        return this.d;
    }

    synchronized void g() {
        if (this.b != null && this.i != null && e()) {
            try {
                b();
            } catch (Exception e) {
            }
        }
        this.d = null;
        if (this.e != null) {
            this.e.f();
        }
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean h() {
        return this.g;
    }

    public boolean i() {
        return !h() && e();
    }

    static /* synthetic */ void a(ad adVar) {
        if (adVar.e == null) {
            return;
        }
        adVar.e.e();
    }

    static /* synthetic */ void b(ad adVar) {
        if (adVar.e == null) {
            return;
        }
        adVar.e.g();
    }
}
