package com.yandex.metrica.impl.ob;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
class cy implements db {
    private Map<String, Set<String>> a = new ConcurrentHashMap();
    private volatile AtomicLong b = new AtomicLong();

    @Override // com.yandex.metrica.impl.ob.db
    public void a(String str, String[] strArr) {
        if (!this.a.keySet().contains(str)) {
            this.a.put(str, new HashSet(Arrays.asList(strArr)));
            d();
        }
    }

    public Map<String, Set<String>> c() {
        HashMap map = new HashMap();
        for (String str : this.a.keySet()) {
            map.put(str, a(str));
        }
        return map;
    }

    public void a(Map<String, Set<String>> map) {
        this.a = new ConcurrentHashMap(map);
        d();
    }

    @Override // com.yandex.metrica.impl.ob.db
    public Set<String> a(String str) {
        Set<String> set = this.a.get(str);
        if (set == null) {
            return null;
        }
        return new HashSet(set);
    }

    @Override // com.yandex.metrica.impl.ob.db
    public boolean a(String str, String str2) {
        Set<String> hashSet = this.a.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.a.put(str, hashSet);
        }
        d();
        return hashSet.add(str2);
    }

    @Override // com.yandex.metrica.impl.ob.db
    public void a(String str, Set<String> set) {
        this.a.put(str, new HashSet(set));
        d();
    }

    @Override // com.yandex.metrica.impl.ob.db
    public long a() {
        return this.b.get();
    }

    @Override // com.yandex.metrica.impl.ob.db
    public void b() {
        d();
    }

    private void d() {
        this.b.set(System.currentTimeMillis());
    }
}
