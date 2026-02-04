package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.os.Build;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.do, reason: invalid class name */
/* loaded from: classes.dex */
class Cdo extends du {
    private Map<String, String> a;

    public Cdo(String str, Map<String, String> map) {
        super(0, str, null);
        this.a = map;
    }

    @Override // com.yandex.metrica.impl.ob.ea
    public String a() {
        String strA = super.a();
        Map<String, String> map = this.a;
        Uri.Builder builderBuildUpon = Uri.parse(strA).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return builderBuildUpon.build().toString();
    }

    @Override // com.yandex.metrica.impl.ob.ea
    public Map<String, String> b() {
        HashMap map = new HashMap();
        map.put("User-agent", String.format(Locale.US, "com.yandex.mobile.pinning/%s (%s; Android %s)", String.format(Locale.US, "%s.%s.%s", 2, 12, 20), Build.DEVICE, Build.VERSION.RELEASE));
        return map;
    }
}
