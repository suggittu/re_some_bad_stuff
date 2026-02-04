package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.impl.ob.cc;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ca implements cb {
    static final Map<bz, IIdentifierCallback.Reason> a = Collections.unmodifiableMap(new HashMap<bz, IIdentifierCallback.Reason>() { // from class: com.yandex.metrica.impl.ob.ca.1
        {
            put(bz.UNKNOWN, IIdentifierCallback.Reason.UNKNOWN);
            put(bz.NETWORK, IIdentifierCallback.Reason.NETWORK);
            put(bz.PARSE, IIdentifierCallback.Reason.INVALID_RESPONSE);
        }
    });
    private final com.yandex.metrica.impl.ay b;
    private final cc c;
    private final bn d;
    private final Object e = new Object();
    private final Map<IIdentifierCallback, Object> f = new WeakHashMap();
    private final Map<IIdentifierCallback, Object> g = new WeakHashMap();

    public ca(com.yandex.metrica.impl.ay ayVar, Context context, String str) {
        this.b = ayVar;
        this.d = new bn(context.getApplicationContext());
        context.getApplicationContext();
        this.c = new cc(this.d, str);
        e();
    }

    @Override // com.yandex.metrica.impl.ob.cb
    public String a() {
        return this.c.c();
    }

    @Override // com.yandex.metrica.impl.ob.cb
    public String b() {
        return this.d.a();
    }

    @Override // com.yandex.metrica.impl.ob.cb
    public String c() {
        return this.c.d();
    }

    public void a(IIdentifierCallback iIdentifierCallback) {
        synchronized (this.e) {
            this.g.put(iIdentifierCallback, null);
            if (!this.c.a(cc.a.ALL)) {
                this.b.c();
            }
        }
        e();
    }

    public void a(Bundle bundle) {
        synchronized (this.e) {
            this.c.a(bundle);
            this.c.a(System.currentTimeMillis() / 1000);
        }
        e();
    }

    public void d() {
        if (this.c.a(cc.a.ALL) && this.c.e() == cd.STORED && !this.c.a()) {
            return;
        }
        this.b.c();
    }

    public void a(String str) throws IllegalArgumentException {
        String strB = this.c.b();
        if (TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(strB)) {
                this.c.a((String) null);
                this.c.a(0L);
                return;
            }
            return;
        }
        if (!str.equals(strB)) {
            this.c.a(str);
            this.c.a(0L);
            this.b.c(str);
            return;
        }
        this.b.c(strB);
    }

    public void b(String str) {
        this.b.d(str);
    }

    void e() {
        WeakHashMap weakHashMap = new WeakHashMap();
        HashMap map = new HashMap();
        WeakHashMap weakHashMap2 = new WeakHashMap();
        HashMap map2 = new HashMap();
        synchronized (this.e) {
            if (this.c.a(cc.a.IDENTIFIERS)) {
                weakHashMap.putAll(this.f);
                this.f.clear();
                this.c.b(map);
            }
            if (this.c.a(cc.a.ALL)) {
                weakHashMap2.putAll(this.g);
                this.g.clear();
                this.c.a(map2);
            }
        }
        Iterator it = weakHashMap.keySet().iterator();
        while (it.hasNext()) {
            ((IIdentifierCallback) it.next()).onReceive(new HashMap(map));
        }
        Iterator it2 = weakHashMap2.keySet().iterator();
        while (it2.hasNext()) {
            ((IIdentifierCallback) it2.next()).onReceive(new HashMap(map2));
        }
        weakHashMap.clear();
        map.clear();
        weakHashMap2.clear();
        map2.clear();
    }

    public void b(Bundle bundle) {
        IIdentifierCallback.Reason reason = a.get(bz.b(bundle));
        WeakHashMap weakHashMap = new WeakHashMap();
        WeakHashMap weakHashMap2 = new WeakHashMap();
        synchronized (this.e) {
            weakHashMap.putAll(this.f);
            weakHashMap2.putAll(this.g);
            this.f.clear();
            this.g.clear();
        }
        Iterator it = weakHashMap.keySet().iterator();
        while (it.hasNext()) {
            ((IIdentifierCallback) it.next()).onRequestError(reason);
        }
        Iterator it2 = weakHashMap2.keySet().iterator();
        while (it2.hasNext()) {
            ((IIdentifierCallback) it2.next()).onRequestError(reason);
        }
        weakHashMap.clear();
        weakHashMap2.clear();
    }

    public void a(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if ((TextUtils.isEmpty(key) || key.contains(":") || key.contains(",") || key.contains("&")) ? false : true) {
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(value) && com.yandex.metrica.impl.utils.e.a(value, -1L) > 0) {
                        map2.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        this.b.a(map2);
    }
}
