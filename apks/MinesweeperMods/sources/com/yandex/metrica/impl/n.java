package com.yandex.metrica.impl;

import android.location.Location;
import com.yandex.metrica.e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class n implements ac {
    private Integer a;
    private Boolean b;
    private Boolean c;
    private Location d;
    private Boolean e;
    private String f;
    private Boolean g;
    private Map<String, String> h = new HashMap();
    private Map<String, String> i = new HashMap();
    private boolean j;
    private boolean k;

    public Integer a() {
        return this.a;
    }

    public Boolean b() {
        return this.b;
    }

    public Boolean c() {
        return this.c;
    }

    public Location d() {
        return this.d;
    }

    public Boolean e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public Boolean g() {
        return this.g;
    }

    @Override // com.yandex.metrica.impl.ac
    public boolean h() {
        if (this.g == null) {
            return false;
        }
        return this.g.booleanValue();
    }

    @Override // com.yandex.metrica.impl.ac
    public void a(boolean z) {
        this.g = Boolean.valueOf(z);
    }

    @Override // com.yandex.metrica.impl.ac
    public void a(String str) {
        this.f = str;
    }

    @Override // com.yandex.metrica.impl.ac
    public void b(boolean z) {
        this.e = Boolean.valueOf(z);
    }

    @Override // com.yandex.metrica.impl.ac
    public void setSessionTimeout(int sessionTimeout) {
        this.a = Integer.valueOf(sessionTimeout);
    }

    public void c(boolean z) {
        this.b = Boolean.valueOf(z);
    }

    @Override // com.yandex.metrica.impl.ac
    public void a(Location location) {
        this.d = location;
    }

    @Override // com.yandex.metrica.impl.ac
    public void d(boolean z) {
        this.c = Boolean.valueOf(z);
    }

    public boolean i() {
        return this.j;
    }

    @Override // com.yandex.metrica.impl.ac
    public void a(String str, String str2) {
        this.i.put(str, str2);
    }

    public com.yandex.metrica.e a(com.yandex.metrica.e eVar) throws IllegalArgumentException {
        if (this.k) {
            return eVar;
        }
        e.a aVarA = com.yandex.metrica.e.a(eVar.getApiKey());
        aVarA.a(eVar.e(), eVar.j());
        aVarA.a(eVar.d());
        aVarA.a(eVar.getPreloadInfo());
        aVarA.c(eVar.a());
        aVarA.a(eVar.getLocation());
        if (eVar.b() != null) {
            aVarA.d(eVar.b());
        }
        if (eVar.getAppVersion() != null) {
            aVarA.a(eVar.getAppVersion());
        }
        if (eVar.h() != null) {
            aVarA.d(eVar.h().intValue());
        }
        if (eVar.c() != null) {
            aVarA.b(eVar.c().intValue());
        }
        if (eVar.g() != null) {
            aVarA.c(eVar.g().intValue());
        }
        if ((eVar.isLogEnabled() != null) && eVar.isLogEnabled().booleanValue()) {
            aVarA.a();
        }
        if (eVar.getSessionTimeout() != null) {
            aVarA.a(eVar.getSessionTimeout().intValue());
        }
        if (eVar.isReportCrashEnabled() != null) {
            aVarA.a(eVar.isReportCrashEnabled().booleanValue());
        }
        if (eVar.isReportNativeCrashEnabled() != null) {
            aVarA.b(eVar.isReportNativeCrashEnabled().booleanValue());
        }
        if (eVar.isTrackLocationEnabled() != null) {
            aVarA.c(eVar.isTrackLocationEnabled().booleanValue());
        }
        if (eVar.isCollectInstalledApps() != null) {
            aVarA.d(eVar.isCollectInstalledApps().booleanValue());
        }
        if (eVar.f() != null) {
            aVarA.b(eVar.f());
        }
        a(eVar.i(), aVarA);
        b(eVar.getErrorEnvironment(), aVarA);
        Integer numA = a();
        if (eVar.getSessionTimeout() == null) {
            if (numA != null) {
                aVarA.a(numA.intValue());
            }
        }
        Boolean boolB = b();
        if (eVar.isReportCrashEnabled() == null) {
            if (boolB != null) {
                aVarA.a(boolB.booleanValue());
            }
        }
        Boolean boolC = c();
        if (eVar.isReportNativeCrashEnabled() == null) {
            if (boolC != null) {
                aVarA.b(boolC.booleanValue());
            }
        }
        Boolean boolE = e();
        if (eVar.isTrackLocationEnabled() == null) {
            if (boolE != null) {
                aVarA.c(boolE.booleanValue());
            }
        }
        Location locationD = d();
        if (eVar.getLocation() == null) {
            if (locationD != null) {
                aVarA.a(locationD);
            }
        }
        Boolean boolG = g();
        if (eVar.isCollectInstalledApps() == null) {
            if (boolG != null) {
                aVarA.d(boolG.booleanValue());
            }
        }
        String strF = f();
        if (eVar.getAppVersion() == null) {
            if (strF != null) {
                aVarA.a(strF);
            }
        }
        a(this.h, aVarA);
        b(this.i, aVarA);
        this.k = true;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h.clear();
        this.i.clear();
        this.j = false;
        return aVarA.b();
    }

    private static void a(Map<String, String> map, e.a aVar) {
        if (!bk.a((Map) map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVar.b(entry.getKey(), entry.getValue());
            }
        }
    }

    private static void b(Map<String, String> map, e.a aVar) {
        if (!bk.a((Map) map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        }
    }
}
