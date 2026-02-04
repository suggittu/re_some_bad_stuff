package com.yandex.metrica.impl;

import com.yandex.metrica.impl.utils.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class p {
    private Map<String, String> a = new HashMap();
    private com.yandex.metrica.impl.utils.c b = new com.yandex.metrica.impl.utils.c();
    private c.a c;

    p(c.a aVar) {
        this.c = aVar;
    }

    void a(String str, String str2) {
        if (str2 == null) {
            this.a.remove(str);
        } else {
            this.b.a(this.a, str, str2, this.c, "Crash Environment");
        }
    }

    String a() {
        if (this.a.isEmpty()) {
            return null;
        }
        return new JSONObject(this.a).toString();
    }
}
