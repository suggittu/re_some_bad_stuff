package com.yandex.metrica.impl;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.impl.ad;
import com.yandex.metrica.impl.ob.cb;
import com.yandex.metrica.impl.q;
import com.yandex.metrica.impl.utils.c;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class c implements com.yandex.metrica.b, ad.a {
    protected final aw a;
    protected final ay b;
    private x c;

    c(Context context, String str, ay ayVar, aw awVar) {
        context.getApplicationContext();
        this.b = ayVar;
        this.a = awVar;
        this.a.b().a(str);
        this.a.b().c(context.getPackageName());
    }

    protected void a() {
        this.a.a(c.a.d());
        this.b.a(this.a);
    }

    void a(cb cbVar) {
        this.a.b(cbVar);
    }

    void a(i iVar) {
        this.a.a(iVar);
    }

    void a(x xVar) {
        this.c = xVar;
    }

    public void a(String str) {
        this.a.b().h(str);
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.a.a(str, str2);
        }
    }

    public void a(Map<String, String> map) {
        if (!bk.a((Map) map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        }
    }

    public void b(Map<String, String> map) {
        if (!bk.a((Map) map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
        }
    }

    public void b(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.b.a(str, str2, this.a);
        }
    }

    public void b() {
        this.b.b(this.a);
    }

    @Override // com.yandex.metrica.IReporter
    public void onResumeSession() {
        b((String) null);
    }

    void b(String str) {
        this.b.d();
        this.c.b();
        this.b.a(q.b(str), this.a);
        if (!this.a.h()) {
            return;
        }
        this.b.a(q.d(q.a.EVENT_TYPE_PURGE_BUFFER), this.a);
    }

    @Override // com.yandex.metrica.IReporter
    public void onPauseSession() {
        c(null);
    }

    void c(String str) {
        if (!this.a.a()) {
            this.b.h();
            this.c.a();
            this.b.a(q.c(str), this.a);
            this.a.g();
        }
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String eventName) throws IllegalArgumentException {
        reportEvent(eventName, "");
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String eventName, String jsonValue) throws IllegalArgumentException {
        bk.a((Object) eventName, "Event Name");
        bk.a((Object) jsonValue, "JSON Value");
        a(q.a(eventName, jsonValue));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String eventName, Map<String, Object> attributes) throws IllegalArgumentException {
        bk.a((Object) eventName, "Event Name");
        bk.a(attributes, "Attributes");
        this.b.a(q.a(eventName), d(), attributes);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String message, Throwable error) throws IllegalArgumentException {
        bk.a((Object) message, "Message");
        a(q.b(message, bk.a((String) null, error)));
    }

    @Override // com.yandex.metrica.IReporter
    public void setSessionTimeout(int sessionTimeOut) {
        this.a.b().c(sessionTimeOut);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUnhandledException(Throwable exception) throws IllegalArgumentException {
        bk.a(exception, "Exception");
        if (!this.a.c()) {
            return;
        }
        this.b.a(exception, this.a);
    }

    void d(String str) throws IllegalArgumentException {
        bk.a((Object) str, "Native Crash");
        if (!this.a.c()) {
            return;
        }
        this.b.a(str, this.a);
    }

    boolean c() {
        boolean z = !a_();
        if (z) {
            this.b.a(q.c(q.a.EVENT_TYPE_ALIVE.b()), this.a);
        }
        return z;
    }

    aw d() {
        return this.a;
    }

    private void a(g gVar) {
        this.b.a(gVar, this.a);
    }

    public void e() {
        this.b.d(this.a);
    }

    @Override // com.yandex.metrica.impl.ad.a
    public void f() {
    }

    @Override // com.yandex.metrica.impl.ad.a
    public void g() {
    }

    public boolean a_() {
        return this.a.a();
    }
}
