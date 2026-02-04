package com.yandex.metrica.impl;

import com.google.android.gms.search.SearchAuth;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class e extends g {
    private final Set<a> e;
    private final com.yandex.metrica.impl.utils.c f;

    private enum a {
        NAME,
        VALUE,
        USER_INFO
    }

    public e() {
        this.e = new HashSet();
        this.f = new com.yandex.metrica.impl.utils.c();
    }

    public e(String str, int i) {
        this("", str, i);
    }

    public e(String str, String str2, int i) {
        this.e = new HashSet();
        this.f = new com.yandex.metrica.impl.utils.c();
        this.b = i(str);
        this.a = h(str2);
        this.c = i;
    }

    private void a(String str, String str2, a aVar) {
        if (this.f.a(str, str2)) {
            this.e.add(aVar);
        } else {
            this.e.remove(aVar);
        }
        this.d = !this.e.isEmpty();
    }

    private String h(String str) {
        String strA = this.f.a(str, 1000, "event name");
        a(str, strA, a.NAME);
        return strA;
    }

    private String i(String str) throws UnsupportedEncodingException {
        String strA = this.f.a(str, 245760);
        a(str, strA, a.VALUE);
        return strA;
    }

    @Override // com.yandex.metrica.impl.g
    public g a(String str) {
        String strA = this.f.a(str, SearchAuth.StatusCodes.AUTH_DISABLED, "UserInfo");
        a(str, strA, a.USER_INFO);
        return super.a(strA);
    }

    @Override // com.yandex.metrica.impl.g
    public g b(String str) {
        return super.b(h(str));
    }

    @Override // com.yandex.metrica.impl.g
    public g c(String str) {
        return super.c(i(str));
    }
}
