package com.yandex.metrica.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.cb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class aa extends c implements ac {
    private final v c;
    private List<h> d;

    aa(Context context, com.yandex.metrica.e eVar, ay ayVar) {
        super(context, eVar.getApiKey(), ayVar, new aw());
        this.c = new bb(context, "13", "20799a27-fa80-4b36-b2db-0f8141f24180");
        this.a.a(new ak(eVar.getPreloadInfo()));
        a(eVar);
        this.d = new ArrayList();
        this.d.add(new a(this.a));
        this.d.add(new ae(this.c));
    }

    @Override // com.yandex.metrica.impl.c
    void a(cb cbVar) {
        super.a(cbVar);
        this.c.b(cbVar);
    }

    @Override // com.yandex.metrica.impl.c
    void a(i iVar) {
        super.a(iVar);
        this.c.a(iVar);
    }

    @Override // com.yandex.metrica.impl.c, com.yandex.metrica.IReporter
    public void reportEvent(String eventName) throws IllegalArgumentException {
        super.reportEvent(eventName);
    }

    @Override // com.yandex.metrica.impl.c, com.yandex.metrica.IReporter
    public void reportEvent(String eventName, String jsonValue) throws IllegalArgumentException {
        super.reportEvent(eventName, jsonValue);
        com.yandex.metrica.impl.utils.f.e().a("Event received: %s", eventName);
    }

    @Override // com.yandex.metrica.impl.c, com.yandex.metrica.IReporter
    public void reportEvent(String eventName, Map<String, Object> attributes) throws IllegalArgumentException {
        super.reportEvent(eventName, attributes);
        com.yandex.metrica.impl.utils.f.e().a("Event received: %s", eventName);
    }

    @Override // com.yandex.metrica.impl.c, com.yandex.metrica.IReporter
    public void reportError(String message, Throwable error) throws IllegalArgumentException {
        super.reportError(message, error);
        com.yandex.metrica.impl.utils.f.e().a("Error received: %s", message);
    }

    public void a(Application application) throws IllegalArgumentException {
        bk.a((Object) application, "Application");
        if (Build.VERSION.SDK_INT >= 14) {
            com.yandex.metrica.impl.utils.f.e().a("Enable activity auto tracking", new Object[0]);
            application.registerActivityLifecycleCallbacks(new m(this));
        } else {
            com.yandex.metrica.impl.utils.f.e().b("Could not enable activity auto tracking. API level should be more than 14 (ICE_CREAM_SANDWICH)", new Object[0]);
        }
    }

    public void a(Activity activity) {
        b(c(activity));
    }

    public void b(Activity activity) {
        c(c(activity));
    }

    String c(Activity activity) {
        if (activity == null) {
            return null;
        }
        return activity.getClass().getSimpleName();
    }

    void a(com.yandex.metrica.e eVar) {
        this.a.b().a(eVar);
        d(this.a.b().l());
    }

    public void c(boolean z) {
        this.a.b().a(z);
    }

    @Override // com.yandex.metrica.impl.ac
    public void d(boolean z) {
        this.b.a(z, this.a);
    }

    @Override // com.yandex.metrica.impl.ac
    public void a(Location location) {
        this.a.b().a(location);
    }

    @Override // com.yandex.metrica.impl.ac
    public void b(boolean z) {
        this.a.b().c(z);
    }

    @Override // com.yandex.metrica.impl.c
    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.yandex.metrica.impl.utils.f.e().b("Invalid App Environment (key,value) pair: (%s,%s).", str, str2);
        } else {
            super.b(str, str2);
        }
    }

    @Override // com.yandex.metrica.impl.c, com.yandex.metrica.impl.ac
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.yandex.metrica.impl.utils.f.e().b("Invalid Error Environment (key,value) pair: (%s,%s).", str, str2);
        } else {
            super.a(str, str2);
        }
    }

    @Override // com.yandex.metrica.impl.ac
    public void a(boolean z) {
        this.a.b().d(z);
        this.b.a(q.a(), this.a);
    }

    @Override // com.yandex.metrica.impl.ac
    public boolean h() {
        return this.a.b().r();
    }

    void a(Throwable th) {
        Iterator<h> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a(th, this.b);
        }
    }

    @Override // com.yandex.metrica.impl.c, com.yandex.metrica.impl.ad.a
    public void e() {
        super.e();
        this.b.d(this.c);
    }
}
