package com.yandex.metrica.impl;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.yandex.metrica.c;
import com.yandex.metrica.impl.bk;
import com.yandex.metrica.impl.bm;
import com.yandex.metrica.impl.ob.ck;
import com.yandex.metrica.impl.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class al {
    private static Map<com.yandex.metrica.impl.ob.az, Integer> a;
    private static SparseArray<com.yandex.metrica.impl.ob.az> b;

    static {
        HashMap map = new HashMap();
        map.put(com.yandex.metrica.impl.ob.az.FOREGROUND, 0);
        map.put(com.yandex.metrica.impl.ob.az.BACKGROUND, 1);
        a = Collections.unmodifiableMap(map);
        SparseArray<com.yandex.metrica.impl.ob.az> sparseArray = new SparseArray<>();
        sparseArray.put(0, com.yandex.metrica.impl.ob.az.FOREGROUND);
        sparseArray.put(1, com.yandex.metrica.impl.ob.az.BACKGROUND);
        b = sparseArray;
    }

    public static c.b a(ContentValues contentValues) {
        return a(contentValues.getAsLong("start_time"), contentValues.getAsLong("server_time_offset"));
    }

    public static c.a.h a(ck ckVar) {
        c.a.h hVar = new c.a.h();
        if (ckVar.a() != null) {
            hVar.b = ckVar.a().intValue();
        }
        if (ckVar.b() != null) {
            hVar.c = ckVar.b().intValue();
        }
        if (!TextUtils.isEmpty(ckVar.d())) {
            hVar.d = ckVar.d();
        }
        hVar.e = ckVar.c();
        if (!TextUtils.isEmpty(ckVar.e())) {
            hVar.f = ckVar.e();
        }
        return hVar;
    }

    public static com.yandex.metrica.impl.ob.az a(int i) {
        return b.get(i);
    }

    public static List<c.a.i> a(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    arrayList.add(a(jSONArray.getJSONObject(i)));
                } catch (Exception e2) {
                }
            }
            return arrayList;
        } catch (Exception e3) {
            return new ArrayList();
        }
    }

    public static c.a.i a(JSONObject jSONObject) throws JSONException {
        try {
            c.a.i iVar = new c.a.i();
            iVar.b = jSONObject.getString("mac");
            iVar.c = jSONObject.getInt("signal_strength");
            iVar.d = jSONObject.getString("ssid");
            iVar.e = jSONObject.optBoolean("is_connected");
            return iVar;
        } catch (Exception e2) {
            c.a.i iVar2 = new c.a.i();
            iVar2.b = jSONObject.getString("mac");
            return iVar2;
        }
    }

    public static c.b a(Long l, Long l2) {
        long jLongValue = l.longValue();
        c.b bVar = new c.b();
        bVar.b = jLongValue;
        bVar.c = ((GregorianCalendar) GregorianCalendar.getInstance()).getTimeZone().getOffset(jLongValue * 1000) / 1000;
        if (l2 != null) {
            bVar.d = l2.longValue();
        }
        return bVar;
    }

    public static c.a.g.b a(String str, int i, c.b bVar) {
        c.a.g.b bVar2 = new c.a.g.b();
        bVar2.b = bVar;
        bVar2.c = str;
        bVar2.d = i;
        return bVar2;
    }

    static int a(com.yandex.metrica.impl.ob.az azVar) {
        return a.get(azVar).intValue();
    }

    public static c.a.b[] b(String str) throws JSONException {
        try {
            try {
                if (!TextUtils.isEmpty(str)) {
                    JSONArray jSONArray = new JSONArray(str);
                    c.a.b[] bVarArr = new c.a.b[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject != null) {
                            bVarArr[i] = b(jSONObject);
                        }
                    }
                    return bVarArr;
                }
            } catch (JSONException e2) {
                return new c.a.b[]{b(new JSONObject(str))};
            }
        } catch (Exception e3) {
        }
        return null;
    }

    static c.a.b b(JSONObject jSONObject) {
        int iOptInt;
        c.a.b bVar = new c.a.b();
        if (jSONObject.has("signal_strength") && (iOptInt = jSONObject.optInt("signal_strength")) != -1) {
            bVar.c = iOptInt;
        }
        if (jSONObject.has("cell_id")) {
            bVar.b = jSONObject.optInt("cell_id");
        }
        if (jSONObject.has("lac")) {
            bVar.d = jSONObject.optInt("lac");
        }
        if (jSONObject.has("country_code")) {
            bVar.e = jSONObject.optInt("country_code");
        }
        if (jSONObject.has("operator_id")) {
            bVar.f = jSONObject.optInt("operator_id");
        }
        if (jSONObject.has("operator_name")) {
            bVar.g = jSONObject.optString("operator_name");
        }
        if (jSONObject.has("is_connected")) {
            bVar.h = jSONObject.optBoolean("is_connected");
        }
        bVar.i = jSONObject.optInt("cell_type", 0);
        if (jSONObject.has("pci")) {
            bVar.j = jSONObject.optInt("pci");
        }
        return bVar;
    }

    public static c.a.d c(String str) {
        try {
            bk.a aVar = new bk.a(str);
            c.a.d dVar = new c.a.d();
            dVar.c = aVar.getDouble("lon");
            dVar.b = aVar.getDouble("lat");
            if (aVar.b("altitude")) {
                dVar.h = aVar.getInt("altitude");
            }
            if (aVar.b("direction")) {
                dVar.f = aVar.getInt("direction");
            }
            if (aVar.b("precision")) {
                dVar.e = aVar.getInt("precision");
            }
            if (aVar.b("speed")) {
                dVar.g = aVar.getInt("speed");
            }
            if (aVar.b("timestamp")) {
                dVar.d = aVar.getLong("timestamp") / 1000;
                return dVar;
            }
            return dVar;
        } catch (Exception e2) {
            return null;
        }
    }

    public static c.a.e a(int i, String str, String str2, String str3) throws JSONException {
        c.a.e eVar = new c.a.e();
        eVar.d = i;
        if (str != null) {
            eVar.e = str;
        }
        c.a.b[] bVarArrB = b(str3);
        List<c.a.i> listA = a(str2);
        if (bVarArrB != null) {
            eVar.b = bVarArrB;
        }
        if (listA != null) {
            eVar.c = (c.a.i[]) listA.toArray(new c.a.i[listA.size()]);
        }
        return eVar;
    }

    public static c.a.C0270a d(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                com.yandex.metrica.d dVarA = com.yandex.metrica.impl.utils.j.a(str);
                c.a.C0270a c0270a = new c.a.C0270a();
                c0270a.b = dVarA.a();
                if (!TextUtils.isEmpty(dVarA.b())) {
                    c0270a.c = dVarA.b();
                }
                if (!bk.a((Map) dVarA.c())) {
                    c0270a.d = bk.b(dVarA.c());
                    return c0270a;
                }
                return c0270a;
            }
        } catch (Exception e2) {
        }
        return null;
    }

    public static void a() {
    }

    public static c.a.f[] a(Context context) {
        List<bm.a> listB = bm.a(context).b();
        if (bk.a((Collection) listB)) {
            return null;
        }
        c.a.f[] fVarArr = new c.a.f[listB.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= listB.size()) {
                return fVarArr;
            }
            c.a.f fVar = new c.a.f();
            bm.a aVar = listB.get(i2);
            fVar.b = aVar.a;
            fVar.c = aVar.b;
            fVarArr[i2] = fVar;
            i = i2 + 1;
        }
    }

    static class a {
        private static final Map<q.a, Class<?>> n;
        private static final Map<q.a, Integer> o;
        protected String a;
        protected String b;
        protected int c;
        protected long d;
        protected String e;
        protected String f;
        protected String g;
        protected Integer h;
        protected String i;
        protected String j;
        protected boolean k;
        protected int l;
        protected String m;

        static {
            HashMap map = new HashMap();
            map.put(q.a.EVENT_TYPE_REGULAR, c.class);
            map.put(q.a.EVENT_TYPE_REFERRER_DEPRECATED, d.class);
            map.put(q.a.EVENT_TYPE_ACTIVITY_START_DEPRECATED, a.class);
            map.put(q.a.EVENT_TYPE_ALIVE, a.class);
            map.put(q.a.EVENT_TYPE_EXCEPTION_UNHANDLED_DEPRECATED, d.class);
            map.put(q.a.EVENT_TYPE_NATIVE_CRASH, f.class);
            map.put(q.a.EVENT_TYPE_EXCEPTION_USER, c.class);
            map.put(q.a.EVENT_TYPE_IDENTITY, e.class);
            map.put(q.a.EVENT_TYPE_STATBOX, c.class);
            map.put(q.a.EVENT_TYPE_SET_USER_INFO, c.class);
            map.put(q.a.EVENT_TYPE_REPORT_USER_INFO, c.class);
            map.put(q.a.EVENT_TYPE_EXCEPTION_UNHANDLED, c.class);
            map.put(q.a.EVENT_TYPE_ACTIVITY_START, a.class);
            n = Collections.unmodifiableMap(map);
            HashMap map2 = new HashMap();
            map2.put(q.a.EVENT_TYPE_INIT, 1);
            map2.put(q.a.EVENT_TYPE_REGULAR, 4);
            map2.put(q.a.EVENT_TYPE_REFERRER_DEPRECATED, 5);
            map2.put(q.a.EVENT_TYPE_ACTIVITY_START_DEPRECATED, 2);
            map2.put(q.a.EVENT_TYPE_ALIVE, 7);
            map2.put(q.a.EVENT_TYPE_EXCEPTION_UNHANDLED_DEPRECATED, 3);
            map2.put(q.a.EVENT_TYPE_EXCEPTION_UNHANDLED, 3);
            map2.put(q.a.EVENT_TYPE_NATIVE_CRASH, 3);
            map2.put(q.a.EVENT_TYPE_EXCEPTION_USER, 6);
            map2.put(q.a.EVENT_TYPE_IDENTITY, 8);
            map2.put(q.a.EVENT_TYPE_STATBOX, 11);
            map2.put(q.a.EVENT_TYPE_SET_USER_INFO, 12);
            map2.put(q.a.EVENT_TYPE_REPORT_USER_INFO, 12);
            map2.put(q.a.EVENT_TYPE_FIRST_ACTIVATION, 13);
            map2.put(q.a.EVENT_TYPE_ACTIVITY_START, 2);
            o = Collections.unmodifiableMap(map2);
        }

        static a a(int i, boolean z) {
            Class<?> cls;
            a aVar;
            q.a aVarA = q.a.a(i);
            switch (aVarA) {
                case EVENT_TYPE_INIT:
                case EVENT_TYPE_FIRST_ACTIVATION:
                    if (z) {
                        cls = c.class;
                        break;
                    } else {
                        cls = b.class;
                        break;
                    }
                default:
                    cls = n.get(aVarA);
                    break;
            }
            Integer num = o.get(aVarA);
            try {
                aVar = (a) cls.newInstance();
            } catch (Exception e) {
                aVar = new a();
            }
            return aVar.a(num);
        }

        a a(String str) {
            this.a = str;
            return this;
        }

        a b(String str) {
            this.b = str;
            return this;
        }

        a a(int i) {
            this.c = i;
            return this;
        }

        a a(long j) {
            this.d = j;
            return this;
        }

        a c(String str) {
            this.e = str;
            return this;
        }

        a d(String str) {
            this.g = str;
            return this;
        }

        a e(String str) {
            this.f = str;
            return this;
        }

        a a(Integer num) {
            this.h = num;
            return this;
        }

        a f(String str) {
            this.i = str;
            return this;
        }

        a g(String str) {
            this.j = str;
            return this;
        }

        a a(boolean z) {
            this.k = z;
            return this;
        }

        a b(int i) {
            this.l = i;
            return this;
        }

        a h(String str) {
            this.m = str;
            return this;
        }

        protected String a() {
            return "";
        }

        protected byte[] b() {
            return new byte[0];
        }

        protected Integer c() {
            return this.h;
        }

        protected String d() {
            return this.i;
        }

        c.a.g.C0272a e() throws JSONException {
            c.a.g.C0272a c0272a = new c.a.g.C0272a();
            c.a.e eVarA = al.a(this.l, this.m, this.g, this.f);
            c.a.d dVarC = al.c(this.e);
            c.a.C0270a c0270aD = al.d(this.j);
            if (eVarA != null) {
                c0272a.h = eVarA;
            }
            if (dVarC != null) {
                c0272a.g = dVarC;
            }
            if (a() != null) {
                c0272a.e = a();
            }
            if (b() != null) {
                c0272a.f = b();
            }
            if (d() != null) {
                c0272a.i = d();
            }
            if (c0270aD != null) {
                c0272a.j = c0270aD;
            }
            c0272a.b = this.c;
            c0272a.c = this.d;
            c0272a.d = this.h.intValue();
            c0272a.k = this.k;
            c0272a.l = f();
            return c0272a;
        }

        protected int f() {
            return 0;
        }
    }

    static class d extends a {
        d() {
        }

        @Override // com.yandex.metrica.impl.al.a
        protected byte[] b() {
            return bi.c(this.a);
        }
    }

    static class c extends a {
        c() {
        }

        @Override // com.yandex.metrica.impl.al.a
        protected String a() {
            return this.a;
        }

        @Override // com.yandex.metrica.impl.al.a
        protected byte[] b() {
            return this.b != null ? bi.c(this.b) : super.b();
        }
    }

    static class b extends a {
        b() {
        }

        @Override // com.yandex.metrica.impl.al.a
        protected String a() {
            return this.a;
        }
    }

    static class f extends a {
        f() {
        }

        @Override // com.yandex.metrica.impl.al.a
        protected byte[] b() {
            return bi.c(s.c(this.b));
        }
    }

    static class e extends a {
        e() {
        }

        @Override // com.yandex.metrica.impl.al.a
        protected byte[] b() {
            return Base64.decode(this.b, 0);
        }

        @Override // com.yandex.metrica.impl.al.a
        public int f() {
            return 1;
        }
    }
}
