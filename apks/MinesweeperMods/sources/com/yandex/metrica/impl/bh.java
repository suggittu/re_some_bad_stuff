package com.yandex.metrica.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.yandex.metrica.impl.bg;
import com.yandex.metrica.impl.o;
import com.yandex.metrica.impl.ob.br;
import com.yandex.metrica.impl.ob.bz;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes.dex */
class bh extends ah {
    private az a;
    private Context b;
    private com.yandex.metrica.impl.ob.i c;
    private br l;
    private boolean m = false;
    private bz n;

    public bh(com.yandex.metrica.impl.ob.i iVar) {
        this.c = iVar;
        this.b = iVar.m();
        this.a = iVar.h();
        this.l = iVar.w();
    }

    @Override // com.yandex.metrica.impl.ah
    public boolean b() {
        a(false);
        this.a.c(this.c);
        if (!n()) {
            return false;
        }
        Uri.Builder builderBuildUpon = Uri.parse(this.a.A()).buildUpon();
        a(builderBuildUpon);
        a(builderBuildUpon.build().toString());
        return true;
    }

    boolean n() {
        return !this.a.a(this.l.a(0L));
    }

    void a(Uri.Builder builder) {
        builder.path("analytics/startup");
        String strC = this.a.c();
        String strE = this.a.e();
        if (!TextUtils.isEmpty(strC)) {
            strE = strC;
        } else if (TextUtils.isEmpty(strE)) {
            strE = "";
        }
        builder.appendQueryParameter("deviceid", strE);
        builder.appendQueryParameter("app_platform", this.a.k());
        builder.appendQueryParameter("protocol_version", this.a.f());
        builder.appendQueryParameter("analytics_sdk_version", this.a.h());
        builder.appendQueryParameter("analytics_sdk_version_name", this.a.g());
        builder.appendQueryParameter("model", this.a.n());
        builder.appendQueryParameter("manufacturer", this.a.m());
        builder.appendQueryParameter("os_version", this.a.o());
        builder.appendQueryParameter("screen_width", String.valueOf(this.a.p()));
        builder.appendQueryParameter("screen_height", String.valueOf(this.a.q()));
        builder.appendQueryParameter("screen_dpi", String.valueOf(this.a.r()));
        builder.appendQueryParameter("scalefactor", String.valueOf(this.a.s()));
        builder.appendQueryParameter("locale", this.a.t());
        builder.appendQueryParameter("device_type", this.a.C());
        builder.appendQueryParameter("query_hosts", "1");
        builder.appendQueryParameter("features", "easy_collecting");
        Map<String, String> mapV = this.c.j().v();
        String strW = this.c.j().w();
        if (TextUtils.isEmpty(strW)) {
            strW = this.l.a();
        }
        if (!bk.a((Map) mapV)) {
            builder.appendQueryParameter("distribution_customization", "1");
            a(builder, "clids_set", com.yandex.metrica.impl.utils.h.a(mapV));
            builder.appendQueryParameter("app_id", this.c.l().a());
            if (!TextUtils.isEmpty(strW)) {
                builder.appendQueryParameter("install_referrer", strW);
            }
        }
        a(builder, "uuid", this.a.b());
    }

    private static void a(Uri.Builder builder, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            builder.appendQueryParameter(str, str2);
        }
    }

    @Override // com.yandex.metrica.impl.ah
    public boolean c() throws JSONException {
        this.k = false;
        if (o()) {
            this.k = true;
        } else if (200 == this.h) {
            Map<String, String> mapV = this.c.j().v();
            bg.a aVarA = bg.a(this.i);
            if (bg.a.EnumC0273a.OK == aVarA.i()) {
                this.a.a(aVarA);
                Long lA = bg.a(k());
                if (lA != null) {
                    com.yandex.metrica.impl.utils.g.a().a(lA.longValue());
                }
                this.a.b(o.b.a.b(this.b, this.a.c()));
                a(this.a);
                this.c.a(com.yandex.metrica.impl.utils.h.a(this.a.v()).equals(mapV));
                i.a(this.c.k(), this.a);
                this.k = true;
            } else {
                this.n = bz.PARSE;
            }
        }
        return this.k;
    }

    @Override // com.yandex.metrica.impl.ah
    public boolean d() {
        return !TextUtils.isEmpty(this.l.h(null)) && com.yandex.metrica.impl.ob.bi.a().c();
    }

    @Override // com.yandex.metrica.impl.ah
    public void f() {
        this.n = bz.NETWORK;
    }

    @Override // com.yandex.metrica.impl.ah
    public void e() {
        if (!this.k) {
            if (this.n == null) {
                this.n = bz.UNKNOWN;
            }
            i.a(this.c.k(), this.n);
        }
    }

    synchronized void a(az azVar) {
        if (!o()) {
            String strC = azVar.c();
            if (TextUtils.isEmpty(strC)) {
                strC = azVar.e();
            }
            a(System.currentTimeMillis() / 1000);
            this.l.k(azVar.b()).l(strC).m(azVar.z()).n(azVar.y()).o(azVar.x()).p(azVar.A()).q(azVar.v()).j(azVar.E()).b(azVar.D()).k();
            com.yandex.metrica.impl.ob.bi.a().a(this.b, this.a.b(), azVar.E());
            if (!bi.a(azVar.c())) {
                Intent intent = new Intent("com.yandex.metrica.intent.action.SYNC");
                intent.putExtra("CAUSE", "CAUSE_DEVICE_ID");
                intent.putExtra("SYNC_TO_PKG", this.c.l().a());
                intent.putExtra("SYNC_DATA", azVar.c());
                intent.putExtra("SYNC_DATA_2", azVar.b());
                this.b.sendBroadcast(intent);
            }
        }
    }

    synchronized void a(long j) {
        this.l.b(j).k();
    }

    synchronized void a(boolean z) {
        this.m = z;
    }

    synchronized boolean o() {
        return this.m;
    }

    @Override // com.yandex.metrica.impl.ah
    public boolean m() {
        return true;
    }
}
