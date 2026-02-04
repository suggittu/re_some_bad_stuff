package com.yandex.metrica.impl;

import android.content.ContentValues;
import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class k {
    private Context a;
    private ContentValues b;
    private com.yandex.metrica.impl.ob.j c;

    public k(Context context) {
        this.a = context;
    }

    public k a(ContentValues contentValues) {
        this.b = contentValues;
        return this;
    }

    public k a(com.yandex.metrica.impl.ob.j jVar) {
        this.c = jVar;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0182  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.yandex.metrica.impl.g r9, com.yandex.metrica.impl.b.a r10) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.k.a(com.yandex.metrica.impl.g, com.yandex.metrica.impl.b$a):void");
    }

    public void a() throws JSONException {
        az azVarH = this.c.h();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("dId", azVarH.c());
            jSONObject.putOpt("uId", azVarH.b());
            jSONObject.putOpt("appVer", azVarH.u());
            jSONObject.putOpt("appBuild", azVarH.w());
            jSONObject.putOpt("kitVer", azVarH.h());
            jSONObject.putOpt("clientKitVer", azVarH.i());
            jSONObject.putOpt("osVer", azVarH.o());
            jSONObject.putOpt("lang", azVarH.t());
            jSONObject.putOpt("root", azVarH.B());
        } catch (Exception e) {
            jSONObject = new JSONObject();
        }
        this.b.put("report_request_parameters", jSONObject.toString());
    }
}
