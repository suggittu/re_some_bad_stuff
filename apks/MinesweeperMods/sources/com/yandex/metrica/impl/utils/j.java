package com.yandex.metrica.impl.utils;

import android.text.TextUtils;
import com.yandex.metrica.impl.bk;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class j {

    public enum a {
        LOGIN("login"),
        LOGOUT("logout"),
        SWITCH("switch"),
        UPDATE("update");

        private String e;

        a(String str) {
            this.e = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.e;
        }
    }

    public static com.yandex.metrica.d a(String str) {
        com.yandex.metrica.d dVar = new com.yandex.metrica.d();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                dVar.a(jSONObject.optString("UserInfo.UserId", null));
                dVar.b(jSONObject.optString("UserInfo.Type", null));
                dVar.a(bk.a(jSONObject.optJSONObject("UserInfo.Options")));
            } catch (JSONException e) {
            }
        }
        return dVar;
    }

    public static String a(a aVar) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("action", aVar.toString());
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
