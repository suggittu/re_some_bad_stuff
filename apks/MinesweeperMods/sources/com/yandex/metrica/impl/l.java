package com.yandex.metrica.impl;

import android.content.ContentValues;
import com.yandex.metrica.impl.bk;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
abstract class l extends ah {
    static final ContentValues a = new ContentValues();
    final Map<String, String> b = new LinkedHashMap();
    final az c = new az();

    l() {
    }

    l a(ContentValues contentValues) {
        this.b.clear();
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            this.b.put(entry.getKey(), entry.getValue().toString());
        }
        b(contentValues);
        return this;
    }

    void b(ContentValues contentValues) {
        String asString = contentValues.getAsString("report_request_parameters");
        if (!bi.a(asString)) {
            try {
                bk.a aVar = new bk.a(asString);
                this.c.b(aVar.a("dId"));
                this.c.a(aVar.a("uId"));
                this.c.e(aVar.a("kitVer"));
                this.c.f(aVar.a("clientKitVer"));
                this.c.i(aVar.a("appVer"));
                this.c.k(aVar.a("appBuild"));
                this.c.g(aVar.a("osVer"));
                this.c.h(aVar.a("lang"));
                this.c.o(aVar.a("root"));
            } catch (Exception e) {
            }
        }
    }

    @Override // com.yandex.metrica.impl.ah
    public String a() {
        return super.a() + " [" + this.b.toString() + "]";
    }
}
