package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzad;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.nearby.messages.Strategy;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/* loaded from: classes2.dex */
public class Tracker extends zzd {
    private boolean zzPs;
    private final Map zzPt;
    private final zzad zzPu;
    private final zza zzPv;
    private ExceptionReporter zzPw;
    private zzal zzPx;
    private final Map zzxA;

    class zza extends zzd implements GoogleAnalytics.zza {
        private boolean zzPG;
        private int zzPH;
        private long zzPI;
        private boolean zzPJ;
        private long zzPK;

        protected zza(zzf zzfVar) {
            super(zzfVar);
            this.zzPI = -1L;
        }

        private void zziN() {
            if (this.zzPI >= 0 || this.zzPG) {
                zziC().zza(Tracker.this.zzPv);
            } else {
                zziC().zzb(Tracker.this.zzPv);
            }
        }

        public void enableAutoActivityTracking(boolean z) {
            this.zzPG = z;
            zziN();
        }

        public void setSessionTimeout(long j) {
            this.zzPI = j;
            zziN();
        }

        @Override // com.google.android.gms.analytics.internal.zzd
        protected void zziJ() {
        }

        public synchronized boolean zziM() {
            boolean z;
            z = this.zzPJ;
            this.zzPJ = false;
            return z;
        }

        boolean zziO() {
            return zzjl().elapsedRealtime() >= this.zzPK + Math.max(1000L, this.zzPI);
        }

        @Override // com.google.android.gms.analytics.GoogleAnalytics.zza
        public void zzl(Activity activity) {
            if (this.zzPH == 0 && zziO()) {
                this.zzPJ = true;
            }
            this.zzPH++;
            if (this.zzPG) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Tracker.this.setCampaignParamsOnNextHit(intent.getData());
                }
                HashMap map = new HashMap();
                map.put("&t", "screenview");
                Tracker.this.set("&cd", Tracker.this.zzPx != null ? Tracker.this.zzPx.zzo(activity) : activity.getClass().getCanonicalName());
                if (TextUtils.isEmpty((CharSequence) map.get("&dr"))) {
                    String strZzn = Tracker.zzn(activity);
                    if (!TextUtils.isEmpty(strZzn)) {
                        map.put("&dr", strZzn);
                    }
                }
                Tracker.this.send(map);
            }
        }

        @Override // com.google.android.gms.analytics.GoogleAnalytics.zza
        public void zzm(Activity activity) {
            this.zzPH--;
            this.zzPH = Math.max(0, this.zzPH);
            if (this.zzPH == 0) {
                this.zzPK = zzjl().elapsedRealtime();
            }
        }
    }

    Tracker(zzf zzfVar, String str, zzad zzadVar) {
        super(zzfVar);
        this.zzxA = new HashMap();
        this.zzPt = new HashMap();
        if (str != null) {
            this.zzxA.put("&tid", str);
        }
        this.zzxA.put("useSecure", "1");
        this.zzxA.put("&a", Integer.toString(new Random().nextInt(Strategy.TTL_SECONDS_INFINITE) + 1));
        if (zzadVar == null) {
            this.zzPu = new zzad("tracking", zzjl());
        } else {
            this.zzPu = zzadVar;
        }
        this.zzPv = new zza(zzfVar);
    }

    private static boolean zza(Map.Entry entry) {
        String str = (String) entry.getKey();
        entry.getValue();
        return str.startsWith("&") && str.length() >= 2;
    }

    private static String zzb(Map.Entry entry) {
        if (zza(entry)) {
            return ((String) entry.getKey()).substring(1);
        }
        return null;
    }

    private static void zzb(Map map, Map map2) {
        zzx.zzz(map2);
        if (map == null) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            String strZzb = zzb(entry);
            if (strZzb != null) {
                map2.put(strZzb, entry.getValue());
            }
        }
    }

    private static void zzc(Map map, Map map2) {
        zzx.zzz(map2);
        if (map == null) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            String strZzb = zzb(entry);
            if (strZzb != null && !map2.containsKey(strZzb)) {
                map2.put(strZzb, entry.getValue());
            }
        }
    }

    private boolean zziK() {
        return this.zzPw != null;
    }

    static String zzn(Activity activity) {
        zzx.zzz(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        return stringExtra;
    }

    public void enableAdvertisingIdCollection(boolean z) {
        this.zzPs = z;
    }

    public void enableAutoActivityTracking(boolean z) {
        this.zzPv.enableAutoActivityTracking(z);
    }

    public void enableExceptionReporting(boolean z) {
        synchronized (this) {
            if (zziK() == z) {
                return;
            }
            if (z) {
                this.zzPw = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), getContext());
                Thread.setDefaultUncaughtExceptionHandler(this.zzPw);
                zzbd("Uncaught exceptions will be reported to Google Analytics");
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this.zzPw.zziD());
                zzbd("Uncaught exceptions will not be reported to Google Analytics");
            }
        }
    }

    public String get(String str) {
        zzjv();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.zzxA.containsKey(str)) {
            return (String) this.zzxA.get(str);
        }
        if (str.equals("&ul")) {
            return zzam.zza(Locale.getDefault());
        }
        if (str.equals("&cid")) {
            return zzjr().zzkk();
        }
        if (str.equals("&sr")) {
            return zzju().zzla();
        }
        if (str.equals("&aid")) {
            return zzjt().zzjS().zzwK();
        }
        if (str.equals("&an")) {
            return zzjt().zzjS().zzlg();
        }
        if (str.equals("&av")) {
            return zzjt().zzjS().zzli();
        }
        if (str.equals("&aiid")) {
            return zzjt().zzjS().zzAJ();
        }
        return null;
    }

    public void send(Map map) {
        final long jCurrentTimeMillis = zzjl().currentTimeMillis();
        if (zziC().getAppOptOut()) {
            zzbe("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        final boolean zIsDryRunEnabled = zziC().isDryRunEnabled();
        final HashMap map2 = new HashMap();
        zzb(this.zzxA, map2);
        zzb(map, map2);
        final boolean zZzh = zzam.zzh((String) this.zzxA.get("useSecure"), true);
        zzc(this.zzPt, map2);
        this.zzPt.clear();
        final String str = (String) map2.get("t");
        if (TextUtils.isEmpty(str)) {
            zzjm().zzh(map2, "Missing hit type parameter");
            return;
        }
        final String str2 = (String) map2.get("tid");
        if (TextUtils.isEmpty(str2)) {
            zzjm().zzh(map2, "Missing tracking id parameter");
            return;
        }
        final boolean zZziL = zziL();
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int i = Integer.parseInt((String) this.zzxA.get("&a")) + 1;
                if (i >= Integer.MAX_VALUE) {
                    i = 1;
                }
                this.zzxA.put("&a", Integer.toString(i));
            }
        }
        zzjo().zzf(new Runnable() { // from class: com.google.android.gms.analytics.Tracker.1
            @Override // java.lang.Runnable
            public void run() {
                if (Tracker.this.zzPv.zziM()) {
                    map2.put("sc", "start");
                }
                zzam.zzd(map2, "cid", Tracker.this.zziC().getClientId());
                String str3 = (String) map2.get("sf");
                if (str3 != null) {
                    double dZza = zzam.zza(str3, 100.0d);
                    if (zzam.zza(dZza, (String) map2.get("cid"))) {
                        Tracker.this.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(dZza));
                        return;
                    }
                }
                com.google.android.gms.analytics.internal.zza zzaVarZzjs = Tracker.this.zzjs();
                if (zZziL) {
                    zzam.zzb(map2, "ate", zzaVarZzjs.zziU());
                    zzam.zzc(map2, "adid", zzaVarZzjs.zziY());
                } else {
                    map2.remove("ate");
                    map2.remove("adid");
                }
                zzpq zzpqVarZzjS = Tracker.this.zzjt().zzjS();
                zzam.zzc(map2, "an", zzpqVarZzjS.zzlg());
                zzam.zzc(map2, "av", zzpqVarZzjS.zzli());
                zzam.zzc(map2, "aid", zzpqVarZzjS.zzwK());
                zzam.zzc(map2, "aiid", zzpqVarZzjS.zzAJ());
                map2.put("v", "1");
                map2.put("_v", zze.zzQm);
                zzam.zzc(map2, "ul", Tracker.this.zzju().zzkZ().getLanguage());
                zzam.zzc(map2, "sr", Tracker.this.zzju().zzla());
                if (!(str.equals("transaction") || str.equals("item")) && !Tracker.this.zzPu.zzlw()) {
                    Tracker.this.zzjm().zzh(map2, "Too many hits sent too quickly, rate limiting invoked");
                    return;
                }
                long jZzbt = zzam.zzbt((String) map2.get("ht"));
                if (jZzbt == 0) {
                    jZzbt = jCurrentTimeMillis;
                }
                if (zIsDryRunEnabled) {
                    Tracker.this.zzjm().zzc("Dry run enabled. Would have sent hit", new zzab(Tracker.this, map2, jZzbt, zZzh));
                    return;
                }
                String str4 = (String) map2.get("cid");
                HashMap map3 = new HashMap();
                zzam.zza(map3, "uid", map2);
                zzam.zza(map3, "an", map2);
                zzam.zza(map3, "aid", map2);
                zzam.zza(map3, "av", map2);
                zzam.zza(map3, "aiid", map2);
                map2.put("_s", String.valueOf(Tracker.this.zziH().zza(new zzh(0L, str4, str2, TextUtils.isEmpty((CharSequence) map2.get("adid")) ? false : true, 0L, map3))));
                Tracker.this.zziH().zza(new zzab(Tracker.this, map2, jZzbt, zZzh));
            }
        });
    }

    public void set(String str, String str2) {
        zzx.zzb(str, "Key should be non-null");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zzxA.put(str, str2);
    }

    public void setAnonymizeIp(boolean z) {
        set("&aip", zzam.zzK(z));
    }

    public void setAppId(String str) {
        set("&aid", str);
    }

    public void setAppInstallerId(String str) {
        set("&aiid", str);
    }

    public void setAppName(String str) {
        set("&an", str);
    }

    public void setAppVersion(String str) {
        set("&av", str);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri == null || uri.isOpaque()) {
            return;
        }
        String queryParameter = uri.getQueryParameter("referrer");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        Uri uri2 = Uri.parse("http://hostname/?" + queryParameter);
        String queryParameter2 = uri2.getQueryParameter("utm_id");
        if (queryParameter2 != null) {
            this.zzPt.put("&ci", queryParameter2);
        }
        String queryParameter3 = uri2.getQueryParameter("anid");
        if (queryParameter3 != null) {
            this.zzPt.put("&anid", queryParameter3);
        }
        String queryParameter4 = uri2.getQueryParameter("utm_campaign");
        if (queryParameter4 != null) {
            this.zzPt.put("&cn", queryParameter4);
        }
        String queryParameter5 = uri2.getQueryParameter("utm_content");
        if (queryParameter5 != null) {
            this.zzPt.put("&cc", queryParameter5);
        }
        String queryParameter6 = uri2.getQueryParameter("utm_medium");
        if (queryParameter6 != null) {
            this.zzPt.put("&cm", queryParameter6);
        }
        String queryParameter7 = uri2.getQueryParameter("utm_source");
        if (queryParameter7 != null) {
            this.zzPt.put("&cs", queryParameter7);
        }
        String queryParameter8 = uri2.getQueryParameter("utm_term");
        if (queryParameter8 != null) {
            this.zzPt.put("&ck", queryParameter8);
        }
        String queryParameter9 = uri2.getQueryParameter("dclid");
        if (queryParameter9 != null) {
            this.zzPt.put("&dclid", queryParameter9);
        }
        String queryParameter10 = uri2.getQueryParameter("gclid");
        if (queryParameter10 != null) {
            this.zzPt.put("&gclid", queryParameter10);
        }
        String queryParameter11 = uri2.getQueryParameter("aclid");
        if (queryParameter11 != null) {
            this.zzPt.put("&aclid", queryParameter11);
        }
    }

    public void setClientId(String str) {
        set("&cid", str);
    }

    public void setEncoding(String str) {
        set("&de", str);
    }

    public void setHostname(String str) {
        set("&dh", str);
    }

    public void setLanguage(String str) {
        set("&ul", str);
    }

    public void setLocation(String str) {
        set("&dl", str);
    }

    public void setPage(String str) {
        set("&dp", str);
    }

    public void setReferrer(String str) {
        set("&dr", str);
    }

    public void setSampleRate(double d) {
        set("&sf", Double.toString(d));
    }

    public void setScreenColors(String str) {
        set("&sd", str);
    }

    public void setScreenName(String str) {
        set("&cd", str);
    }

    public void setScreenResolution(int i, int i2) {
        if (i >= 0 || i2 >= 0) {
            set("&sr", i + "x" + i2);
        } else {
            zzbg("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long j) {
        this.zzPv.setSessionTimeout(1000 * j);
    }

    public void setTitle(String str) {
        set("&dt", str);
    }

    public void setUseSecure(boolean z) {
        set("useSecure", zzam.zzK(z));
    }

    public void setViewportSize(String str) {
        set("&vp", str);
    }

    void zza(zzal zzalVar) {
        zzbd("Loading Tracker config values");
        this.zzPx = zzalVar;
        if (this.zzPx.zzlT()) {
            String trackingId = this.zzPx.getTrackingId();
            set("&tid", trackingId);
            zza("trackingId loaded", trackingId);
        }
        if (this.zzPx.zzlU()) {
            String string = Double.toString(this.zzPx.zzlV());
            set("&sf", string);
            zza("Sample frequency loaded", string);
        }
        if (this.zzPx.zzlW()) {
            int sessionTimeout = this.zzPx.getSessionTimeout();
            setSessionTimeout(sessionTimeout);
            zza("Session timeout loaded", Integer.valueOf(sessionTimeout));
        }
        if (this.zzPx.zzlX()) {
            boolean zZzlY = this.zzPx.zzlY();
            enableAutoActivityTracking(zZzlY);
            zza("Auto activity tracking loaded", Boolean.valueOf(zZzlY));
        }
        if (this.zzPx.zzlZ()) {
            boolean zZzma = this.zzPx.zzma();
            if (zZzma) {
                set("&aip", "1");
            }
            zza("Anonymize ip loaded", Boolean.valueOf(zZzma));
        }
        enableExceptionReporting(this.zzPx.zzmb());
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
        this.zzPv.zza();
        String strZzlg = zziI().zzlg();
        if (strZzlg != null) {
            set("&an", strZzlg);
        }
        String strZzli = zziI().zzli();
        if (strZzli != null) {
            set("&av", strZzli);
        }
    }

    boolean zziL() {
        return this.zzPs;
    }
}
