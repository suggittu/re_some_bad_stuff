package com.yandex.metrica.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.yandex.metrica.c;
import com.yandex.metrica.impl.al;
import com.yandex.metrica.impl.b;
import com.yandex.metrica.impl.ob.ck;
import com.yandex.metrica.impl.ob.cl;
import com.yandex.metrica.impl.ob.cm;
import com.yandex.metrica.impl.ob.cn;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class au extends l {
    c.a l;
    az m;
    com.yandex.metrica.impl.ob.bc n;
    com.yandex.metrica.impl.ob.i o;
    List<Long> p;
    int q;
    private c s;
    private boolean u;
    int r = -1;
    private final com.yandex.metrica.impl.utils.c t = new com.yandex.metrica.impl.utils.c();

    public au(com.yandex.metrica.impl.ob.i iVar) {
        this.q = 0;
        this.o = iVar;
        this.n = iVar.i();
        this.m = iVar.h();
        this.q = com.yandex.metrica.impl.ob.b.b(1, al.a(Long.valueOf(System.currentTimeMillis() / 1000), Long.valueOf(com.yandex.metrica.impl.utils.i.a())));
    }

    c.a a(c cVar, c.a.f[] fVarArr) {
        c.a aVar = new c.a();
        a(aVar);
        aVar.b = al.a(Long.valueOf(System.currentTimeMillis() / 1000), Long.valueOf(com.yandex.metrica.impl.utils.i.a()));
        aVar.c = (c.a.g[]) cVar.a.toArray(new c.a.g[cVar.a.size()]);
        aVar.d = a(cVar.c);
        aVar.e = fVarArr;
        this.q += com.yandex.metrica.impl.ob.b.g(8);
        return aVar;
    }

    void a(final c.a aVar) {
        cl.a(this.o.m()).a(new cn() { // from class: com.yandex.metrica.impl.au.1
            @Override // com.yandex.metrica.impl.ob.cn
            public void a(cm cmVar) {
                c.a aVar2 = aVar;
                List<String> listC = cmVar.c();
                if (!bk.a((Collection) listC)) {
                    aVar2.f = new String[listC.size()];
                    for (int i = 0; i < listC.size(); i++) {
                        String str = listC.get(i);
                        if (!TextUtils.isEmpty(str)) {
                            aVar2.f[i] = str;
                            au.this.q += com.yandex.metrica.impl.ob.b.b(aVar2.f[i]);
                            au.this.q += com.yandex.metrica.impl.ob.b.g(9);
                        }
                    }
                }
                c.a aVar3 = aVar;
                List<ck> listA = cmVar.a();
                if (bk.a((Collection) listA)) {
                    return;
                }
                aVar3.g = new c.a.h[listA.size()];
                for (int i2 = 0; i2 < listA.size(); i2++) {
                    aVar3.g[i2] = al.a(listA.get(i2));
                    au.this.q += com.yandex.metrica.impl.ob.b.b(aVar3.g[i2]);
                    au.this.q += com.yandex.metrica.impl.ob.b.g(10);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v59, types: [com.yandex.metrica.c$a, com.yandex.metrica.impl.ob.d] */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r0v67 */
    @Override // com.yandex.metrica.impl.ah
    public boolean b() throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        Closeable closeable = null;
        if (!this.m.F()) {
            return false;
        }
        this.p = null;
        this.u = this.o.y();
        c.a.f[] fVarArrQ = q();
        this.s = r();
        if (this.s.a.isEmpty()) {
            return false;
        }
        this.l = a(this.s, fVarArrQ);
        Uri.Builder builderBuildUpon = Uri.parse(this.m.z()).buildUpon();
        builderBuildUpon.path("report");
        builderBuildUpon.appendQueryParameter("deviceid", bi.c(this.c.c(), this.m.c()));
        builderBuildUpon.appendQueryParameter("uuid", bi.c(this.c.b(), this.m.b()));
        builderBuildUpon.appendQueryParameter("analytics_sdk_version", bi.c(this.c.h(), this.m.h()));
        builderBuildUpon.appendQueryParameter("client_analytics_sdk_version", bi.c(this.c.i(), this.m.i()));
        builderBuildUpon.appendQueryParameter("app_version_name", bi.c(this.c.u(), this.m.u()));
        builderBuildUpon.appendQueryParameter("app_build_number", bi.c(this.c.w(), this.m.w()));
        builderBuildUpon.appendQueryParameter("os_version", bi.c(this.c.o(), this.m.o()));
        builderBuildUpon.appendQueryParameter("locale", bi.c(this.c.t(), this.m.t()));
        builderBuildUpon.appendQueryParameter("is_rooted", bi.c(this.c.B(), this.m.B()));
        builderBuildUpon.appendQueryParameter("app_framework", bi.c(this.c.d(), this.m.d()));
        builderBuildUpon.appendQueryParameter(this.m.j() >= 200 ? "api_key_128" : "api_key", s());
        builderBuildUpon.appendQueryParameter("app_id", this.o.l().a());
        builderBuildUpon.appendQueryParameter("app_platform", this.m.k());
        builderBuildUpon.appendQueryParameter("protocol_version", this.m.f());
        builderBuildUpon.appendQueryParameter("model", this.m.n());
        builderBuildUpon.appendQueryParameter("manufacturer", this.m.m());
        builderBuildUpon.appendQueryParameter("screen_width", String.valueOf(this.m.p()));
        builderBuildUpon.appendQueryParameter("screen_height", String.valueOf(this.m.q()));
        builderBuildUpon.appendQueryParameter("screen_dpi", String.valueOf(this.m.r()));
        builderBuildUpon.appendQueryParameter("scalefactor", String.valueOf(this.m.s()));
        builderBuildUpon.appendQueryParameter("device_type", this.m.C());
        builderBuildUpon.appendQueryParameter("android_id", this.m.l());
        builderBuildUpon.appendQueryParameter("adv_id", this.m.a(this.o.m()));
        String strV = this.m.v();
        if (!TextUtils.isEmpty(strV)) {
            builderBuildUpon.appendQueryParameter("clids_set", strV);
        }
        a(builderBuildUpon.build().toString());
        this.p = this.s.b;
        ?? r0 = this.l;
        byte[] bArrA = com.yandex.metrica.impl.ob.d.a((com.yandex.metrica.impl.ob.d) r0);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(bArrA, 0, bArrA.length);
                    gZIPOutputStream.finish();
                    a(byteArrayOutputStream.toByteArray());
                    b("gzip");
                    bk.a((Closeable) byteArrayOutputStream);
                    bk.a((Closeable) gZIPOutputStream);
                } catch (Exception e) {
                    a(bArrA);
                    b("identity");
                    bk.a((Closeable) byteArrayOutputStream);
                    bk.a((Closeable) gZIPOutputStream);
                    r0 = 1;
                    return true;
                }
            } catch (Throwable th) {
                closeable = r0;
                th = th;
                bk.a((Closeable) byteArrayOutputStream);
                bk.a(closeable);
                throw th;
            }
        } catch (Exception e2) {
            gZIPOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bk.a((Closeable) byteArrayOutputStream);
            bk.a(closeable);
            throw th;
        }
        r0 = 1;
        return true;
    }

    c.a.f[] q() {
        c.a.f[] fVarArrA = al.a(this.o.m());
        if (fVarArrA != null) {
            for (c.a.f fVar : fVarArrA) {
                this.q = com.yandex.metrica.impl.ob.b.b(fVar) + this.q;
            }
        }
        return fVarArrA;
    }

    private static c.a.C0271c[] a(JSONObject jSONObject) {
        int length = jSONObject.length();
        if (length <= 0) {
            return null;
        }
        c.a.C0271c[] c0271cArr = new c.a.C0271c[length];
        Iterator<String> itKeys = jSONObject.keys();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!itKeys.hasNext()) {
                return c0271cArr;
            }
            String next = itKeys.next();
            try {
                c.a.C0271c c0271c = new c.a.C0271c();
                c0271c.b = next;
                c0271c.c = jSONObject.getString(next);
                c0271cArr[i2] = c0271c;
            } catch (JSONException e) {
            }
            i = i2 + 1;
        }
    }

    @Override // com.yandex.metrica.impl.ah
    public boolean c() throws Throwable {
        boolean z = true;
        this.k = j() == 200;
        boolean z2 = j() == 400;
        if (!this.k && !z2) {
            z = false;
        }
        if (z) {
            c.a.g[] gVarArr = this.l.c;
            for (int i = 0; i < gVarArr.length; i++) {
                c.a.g gVar = gVarArr[i];
                this.n.a(this.p.get(i).longValue(), al.a(gVar.c.d).a(), gVar.d.length);
                al.a();
            }
            this.n.a(this.o.a().c());
        }
        return this.k;
    }

    @Override // com.yandex.metrica.impl.ah
    public boolean d() {
        return true;
    }

    @Override // com.yandex.metrica.impl.ah
    public void e() {
        if (this.k) {
            com.yandex.metrica.impl.utils.f fVarP = this.o.p();
            if (fVarP.b()) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.s.a.size()) {
                        break;
                    }
                    fVarP.a(this.s.a.get(i2), "Event sent");
                    i = i2 + 1;
                }
            }
        }
        this.s = null;
    }

    protected c r() throws Throwable {
        Cursor cursorT;
        Throwable th;
        JSONObject jSONObject;
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject2 = new JSONObject();
        try {
            cursorT = t();
            b.a aVar = null;
            jSONObject = jSONObject2;
            while (cursorT.moveToNext()) {
                try {
                    ContentValues contentValues = new ContentValues();
                    com.yandex.metrica.impl.utils.b.a(cursorT, contentValues);
                    long jLongValue = contentValues.getAsLong("id").longValue();
                    com.yandex.metrica.impl.ob.az azVarA = com.yandex.metrica.impl.ob.az.a(contentValues.getAsInteger("type"));
                    if (!a(jLongValue)) {
                        c.a.g.b bVarA = al.a(this.m.t(), al.a(azVarA), al.a(contentValues));
                        this.q += com.yandex.metrica.impl.ob.b.c(1, Long.MAX_VALUE);
                        this.q += com.yandex.metrica.impl.ob.b.b(2, bVarA);
                        if (this.q >= 250880) {
                            break;
                        }
                        b bVarA2 = a(jLongValue, bVarA);
                        if (bVarA2 == null) {
                            continue;
                        } else {
                            if (aVar == null) {
                                aVar = bVarA2.b;
                            } else if (!aVar.equals(bVarA2.b)) {
                                break;
                            }
                            arrayList2.add(Long.valueOf(jLongValue));
                            arrayList.add(bVarA2.a);
                            try {
                                jSONObject = new JSONObject(bVarA2.b.a);
                            } catch (JSONException e) {
                            }
                            if (bVarA2.c) {
                                break;
                            }
                        }
                    }
                } catch (Exception e2) {
                    cursor = cursorT;
                    bk.a(cursor);
                    return new c(arrayList, arrayList2, jSONObject);
                } catch (Throwable th2) {
                    th = th2;
                    bk.a(cursorT);
                    throw th;
                }
            }
            bk.a(cursorT);
        } catch (Exception e3) {
            jSONObject = jSONObject2;
            cursor = null;
        } catch (Throwable th3) {
            cursorT = null;
            th = th3;
        }
        return new c(arrayList, arrayList2, jSONObject);
    }

    private static int a(b.a aVar) {
        try {
            c.a.C0271c[] c0271cArrA = a(new JSONObject(aVar.a));
            if (c0271cArrA == null) {
                return 0;
            }
            int length = c0271cArrA.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int iB = com.yandex.metrica.impl.ob.b.b(7, c0271cArrA[i]) + i2;
                i++;
                i2 = iB;
            }
            return i2;
        } catch (JSONException e) {
            return 0;
        }
    }

    protected b a(long j, c.a.g.b bVar) throws Throwable {
        Cursor cursorA;
        b.a aVar;
        boolean z;
        ArrayList arrayList;
        b.a aVar2;
        c.a.g.C0272a c0272aE;
        c.a.g gVar = new c.a.g();
        gVar.b = j;
        gVar.c = bVar;
        Cursor cursor = null;
        b.a aVar3 = null;
        boolean z2 = false;
        try {
            cursorA = a(j, al.a(bVar.d));
            try {
                try {
                    arrayList = new ArrayList();
                    while (cursorA.moveToNext()) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            com.yandex.metrica.impl.utils.b.a(cursorA, contentValues);
                            al.a aVarH = al.a.a(contentValues.getAsInteger("type").intValue(), this.u).a(contentValues.getAsString("name")).b(contentValues.getAsString("value")).a(contentValues.getAsLong("time").longValue()).a(contentValues.getAsInteger("number").intValue()).e(contentValues.getAsString("cell_info")).c(contentValues.getAsString("location_info")).d(contentValues.getAsString("wifi_network_info")).f(contentValues.getAsString("error_environment")).g(contentValues.getAsString("user_info")).a(contentValues.getAsInteger("truncated").intValue() == 1).b(contentValues.getAsInteger("connection_type").intValue()).h(contentValues.getAsString("cellular_connection_type"));
                            if (aVarH.c() == null) {
                                c0272aE = null;
                            } else {
                                c0272aE = aVarH.e();
                            }
                            if (c0272aE != null) {
                                aVar2 = new b.a(contentValues.getAsString("app_environment"), contentValues.getAsLong("app_environment_revision").longValue());
                                if (aVar3 == null) {
                                    try {
                                        if (this.r < 0) {
                                            this.r = a(aVar2);
                                            this.q += this.r;
                                            aVar3 = aVar2;
                                        } else {
                                            aVar3 = aVar2;
                                        }
                                    } catch (Exception e) {
                                        z = z2;
                                        aVar = aVar2;
                                        cursor = cursorA;
                                        bk.a(cursor);
                                        return new b(gVar, aVar, z);
                                    }
                                } else if (!aVar3.equals(aVar2)) {
                                    z2 = true;
                                    aVar2 = aVar3;
                                    break;
                                }
                                byte[] bArrA = this.t.a(c0272aE.f, 245760);
                                if (!c0272aE.f.equals(bArrA)) {
                                    c0272aE.f = bArrA;
                                    c0272aE.k = true;
                                }
                                this.q += com.yandex.metrica.impl.ob.b.b(3, c0272aE);
                                if (this.q >= 250880) {
                                    break;
                                }
                                arrayList.add(c0272aE);
                            }
                        } catch (Exception e2) {
                            cursor = cursorA;
                            b.a aVar4 = aVar3;
                            z = false;
                            aVar = aVar4;
                        }
                    }
                    aVar2 = aVar3;
                } catch (Throwable th) {
                    th = th;
                    bk.a(cursorA);
                    throw th;
                }
            } catch (Exception e3) {
                cursor = cursorA;
                z = false;
                aVar = null;
            }
        } catch (Exception e4) {
            aVar = null;
            z = false;
        } catch (Throwable th2) {
            th = th2;
            cursorA = null;
        }
        if (arrayList.size() > 0) {
            gVar.d = (c.a.g.C0272a[]) arrayList.toArray(new c.a.g.C0272a[arrayList.size()]);
            bk.a(cursorA);
            z = z2;
            aVar = aVar2;
            return new b(gVar, aVar, z);
        }
        bk.a(cursorA);
        return null;
    }

    protected String s() {
        return this.m.a();
    }

    protected Cursor t() {
        return this.n.a(this.b);
    }

    protected Cursor a(long j, com.yandex.metrica.impl.ob.az azVar) {
        return this.n.b(j, azVar);
    }

    protected boolean a(long j) {
        return -2 == j;
    }

    static final class c {
        final List<c.a.g> a;
        final List<Long> b;
        final JSONObject c;

        c(List<c.a.g> list, List<Long> list2, JSONObject jSONObject) {
            this.a = list;
            this.b = list2;
            this.c = jSONObject;
        }
    }

    static final class b {
        final c.a.g a;
        final b.a b;
        final boolean c;

        b(c.a.g gVar, b.a aVar, boolean z) {
            this.a = gVar;
            this.b = aVar;
            this.c = z;
        }
    }

    public static a u() {
        return new a();
    }

    static class a {
        a() {
        }

        au a(com.yandex.metrica.impl.ob.i iVar) {
            return new au(iVar);
        }
    }
}
