package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.dx;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class du extends dv<JSONObject> {
    public du(int i, String str, JSONObject jSONObject) {
        super(i, str, jSONObject == null ? null : jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yandex.metrica.impl.ob.dv, com.yandex.metrica.impl.ob.ea
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONObject b(dz dzVar) throws dx {
        try {
            return new JSONObject(new String(dzVar.a, dw.a(dzVar.b, "utf-8")));
        } catch (UnsupportedEncodingException e) {
            dx.a aVar = dx.a.PARSE;
            throw new dx(e);
        } catch (JSONException e2) {
            dx.a aVar2 = dx.a.PARSE;
            throw new dx(e2);
        }
    }
}
