package com.yandex.metrica.impl;

import com.google.android.gms.plus.PlusShare;
import com.yandex.metrica.impl.bk;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class bg {

    static class a {
        private EnumC0273a a;
        private boolean b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;

        /* renamed from: com.yandex.metrica.impl.bg$a$a, reason: collision with other inner class name */
        public enum EnumC0273a {
            BAD,
            OK
        }

        a() {
        }

        void a(boolean z) {
            this.b = z;
        }

        public boolean a() {
            return this.b;
        }

        void a(String str) {
            this.c = str;
        }

        public String b() {
            return this.c;
        }

        void b(String str) {
            this.d = str;
        }

        public String c() {
            return this.d;
        }

        void c(String str) {
            this.e = str;
        }

        public String d() {
            return this.e;
        }

        void d(String str) {
            this.f = str;
        }

        public String e() {
            return this.f;
        }

        void e(String str) {
            this.g = str;
        }

        public String f() {
            return this.g;
        }

        void f(String str) {
            this.h = str;
        }

        public String g() {
            return this.h;
        }

        void g(String str) {
            this.i = str;
        }

        public String h() {
            return this.i;
        }

        void a(EnumC0273a enumC0273a) {
            this.a = enumC0273a;
        }

        public EnumC0273a i() {
            return this.a;
        }
    }

    private static String a(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONObject(str).getString("value");
        } catch (Exception e) {
            return "";
        }
    }

    private static String b(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONObject(str).getString(PlusShare.KEY_CALL_TO_ACTION_URL);
        } catch (Exception e) {
            return "";
        }
    }

    public static a a(byte[] bArr) throws JSONException {
        a aVar = new a();
        try {
            bk.a aVar2 = new bk.a(new String(bArr, "UTF-8"));
            aVar.e(a(aVar2, "device_id"));
            aVar.f(a(aVar2, "uuid"));
            JSONObject jSONObject = (JSONObject) aVar2.a("query_hosts", new JSONObject());
            if (jSONObject.has("list")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("list");
                String strB = b(jSONObject2, "get_ad");
                if (a(strB)) {
                    aVar.a(strB);
                }
                String strB2 = b(jSONObject2, "report");
                if (a(strB2)) {
                    aVar.b(strB2);
                }
                String strB3 = b(jSONObject2, "report_ad");
                if (a(strB3)) {
                    aVar.c(strB3);
                }
                String strB4 = b(jSONObject2, "ssl_pinning");
                if (a(strB4)) {
                    aVar.d(strB4);
                }
            }
            JSONObject jSONObjectOptJSONObject = ((JSONObject) aVar2.a("distribution_customization", new JSONObject())).optJSONObject("clids");
            if (jSONObjectOptJSONObject != null) {
                a(aVar, jSONObjectOptJSONObject);
            }
            JSONObject jSONObject3 = (JSONObject) aVar2.a("features", new JSONObject());
            aVar.a(false);
            if (jSONObject3.has("list")) {
                JSONObject jSONObject4 = jSONObject3.getJSONObject("list");
                if (jSONObject4.has("easy_collecting")) {
                    aVar.a(jSONObject4.getJSONObject("easy_collecting").optBoolean("enabled", false));
                }
            }
            aVar.a(a.EnumC0273a.OK);
            return aVar;
        } catch (Exception e) {
            a aVar3 = new a();
            aVar3.a(a.EnumC0273a.BAD);
            return aVar3;
        }
    }

    private static boolean a(String str) {
        return !bi.a(str);
    }

    private static void a(a aVar, JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("value")) {
                map.put(next, jSONObjectOptJSONObject.getString("value"));
            }
        }
        aVar.g(com.yandex.metrica.impl.utils.h.a(map));
    }

    public static Long a(Map<String, List<String>> map) {
        if (!bk.a((Map) map)) {
            List<String> list = map.get("Date");
            if (!bk.a((Collection) list)) {
                try {
                    return Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse(list.get(0)).getTime());
                } catch (Exception e) {
                }
            }
        }
        return null;
    }
}
