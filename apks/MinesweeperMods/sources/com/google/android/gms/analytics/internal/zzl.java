package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzpr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
class zzl extends zzd {
    private boolean mStarted;
    private final zzj zzQY;
    private final zzah zzQZ;
    private final zzag zzRa;
    private final zzi zzRb;
    private long zzRc;
    private final zzt zzRd;
    private final zzt zzRe;
    private final zzaj zzRf;
    private long zzRg;
    private boolean zzRh;

    protected zzl(zzf zzfVar, zzg zzgVar) {
        super(zzfVar);
        com.google.android.gms.common.internal.zzx.zzz(zzgVar);
        this.zzRc = Long.MIN_VALUE;
        this.zzRa = zzgVar.zzk(zzfVar);
        this.zzQY = zzgVar.zzm(zzfVar);
        this.zzQZ = zzgVar.zzn(zzfVar);
        this.zzRb = zzgVar.zzo(zzfVar);
        this.zzRf = new zzaj(zzjl());
        this.zzRd = new zzt(zzfVar) { // from class: com.google.android.gms.analytics.internal.zzl.1
            @Override // com.google.android.gms.analytics.internal.zzt
            public void run() {
                zzl.this.zzjV();
            }
        };
        this.zzRe = new zzt(zzfVar) { // from class: com.google.android.gms.analytics.internal.zzl.2
            @Override // com.google.android.gms.analytics.internal.zzt
            public void run() {
                zzl.this.zzjW();
            }
        };
    }

    private void zza(zzh zzhVar, zzpr zzprVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzhVar);
        com.google.android.gms.common.internal.zzx.zzz(zzprVar);
        com.google.android.gms.analytics.zza zzaVar = new com.google.android.gms.analytics.zza(zzji());
        zzaVar.zzaS(zzhVar.zzjE());
        zzaVar.enableAdvertisingIdCollection(zzhVar.zzjF());
        com.google.android.gms.measurement.zzc zzcVarZziy = zzaVar.zziy();
        zzke zzkeVar = (zzke) zzcVarZziy.zzf(zzke.class);
        zzkeVar.zzaX("data");
        zzkeVar.zzI(true);
        zzcVarZziy.zzb(zzprVar);
        zzkd zzkdVar = (zzkd) zzcVarZziy.zzf(zzkd.class);
        zzpq zzpqVar = (zzpq) zzcVarZziy.zzf(zzpq.class);
        for (Map.Entry entry : zzhVar.zzn().entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if ("an".equals(str)) {
                zzpqVar.setAppName(str2);
            } else if ("av".equals(str)) {
                zzpqVar.setAppVersion(str2);
            } else if ("aid".equals(str)) {
                zzpqVar.setAppId(str2);
            } else if ("aiid".equals(str)) {
                zzpqVar.setAppInstallerId(str2);
            } else if ("uid".equals(str)) {
                zzkeVar.setUserId(str2);
            } else {
                zzkdVar.set(str, str2);
            }
        }
        zzb("Sending installation campaign to", zzhVar.zzjE(), zzprVar);
        zzcVarZziy.zzM(zzjq().zzlF());
        zzcVarZziy.zzAy();
    }

    private boolean zzbk(String str) {
        return getContext().checkCallingOrSelfPermission(str) == 0;
    }

    private void zzjT() {
        Context context = zzji().getContext();
        if (!AnalyticsReceiver.zzY(context)) {
            zzbg("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!AnalyticsService.zzZ(context)) {
            zzbh("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzY(context)) {
            zzbg("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        } else {
            if (CampaignTrackingService.zzZ(context)) {
                return;
            }
            zzbg("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzjV() {
        zzb(new zzw() { // from class: com.google.android.gms.analytics.internal.zzl.4
            @Override // com.google.android.gms.analytics.internal.zzw
            public void zzc(Throwable th) {
                zzl.this.zzkb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzjW() {
        try {
            this.zzQY.zzjN();
            zzkb();
        } catch (SQLiteException e) {
            zzd("Failed to delete stale hits", e);
        }
        this.zzRe.zzt(zzjn().zzkT());
    }

    private boolean zzkc() {
        if (this.zzRh) {
            return false;
        }
        return (!zzjn().zzkr() || zzjn().zzks()) && zzki() > 0;
    }

    private void zzkd() {
        zzv zzvVarZzjp = zzjp();
        if (zzvVarZzjp.zzlb() && !zzvVarZzjp.zzbw()) {
            long jZzjO = zzjO();
            if (jZzjO == 0 || Math.abs(zzjl().currentTimeMillis() - jZzjO) > zzjn().zzkB()) {
                return;
            }
            zza("Dispatch alarm scheduled (ms)", Long.valueOf(zzjn().zzkA()));
            zzvVarZzjp.zzlc();
        }
    }

    private void zzke() {
        long jMin;
        zzkd();
        long jZzki = zzki();
        long jZzlH = zzjq().zzlH();
        if (jZzlH != 0) {
            jMin = jZzki - Math.abs(zzjl().currentTimeMillis() - jZzlH);
            if (jMin <= 0) {
                jMin = Math.min(zzjn().zzky(), jZzki);
            }
        } else {
            jMin = Math.min(zzjn().zzky(), jZzki);
        }
        zza("Dispatch scheduled (ms)", Long.valueOf(jMin));
        if (!this.zzRd.zzbw()) {
            this.zzRd.zzt(jMin);
        } else {
            this.zzRd.zzu(Math.max(1L, jMin + this.zzRd.zzkY()));
        }
    }

    private void zzkf() {
        zzkg();
        zzkh();
    }

    private void zzkg() {
        if (this.zzRd.zzbw()) {
            zzbd("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzRd.cancel();
    }

    private void zzkh() {
        zzv zzvVarZzjp = zzjp();
        if (zzvVarZzjp.zzbw()) {
            zzvVarZzjp.cancel();
        }
    }

    protected void onServiceConnected() {
        zzjk();
        if (zzjn().zzkr()) {
            return;
        }
        zzjY();
    }

    void start() {
        zzjv();
        com.google.android.gms.common.internal.zzx.zza(!this.mStarted, "Analytics backend already started");
        this.mStarted = true;
        if (!zzjn().zzkr()) {
            zzjT();
        }
        zzjo().zzf(new Runnable() { // from class: com.google.android.gms.analytics.internal.zzl.3
            @Override // java.lang.Runnable
            public void run() {
                zzl.this.zzjU();
            }
        });
    }

    public void zzJ(boolean z) {
        zzkb();
    }

    public long zza(zzh zzhVar, boolean z) {
        com.google.android.gms.common.internal.zzx.zzz(zzhVar);
        zzjv();
        zzjk();
        try {
            try {
                this.zzQY.beginTransaction();
                this.zzQY.zza(zzhVar.zzjD(), zzhVar.getClientId());
                long jZza = this.zzQY.zza(zzhVar.zzjD(), zzhVar.getClientId(), zzhVar.zzjE());
                if (z) {
                    zzhVar.zzn(1 + jZza);
                } else {
                    zzhVar.zzn(jZza);
                }
                this.zzQY.zzb(zzhVar);
                this.zzQY.setTransactionSuccessful();
                try {
                    return jZza;
                } catch (SQLiteException e) {
                    return jZza;
                }
            } catch (SQLiteException e2) {
                zze("Failed to update Analytics property", e2);
                try {
                    this.zzQY.endTransaction();
                } catch (SQLiteException e3) {
                    zze("Failed to end transaction", e3);
                }
                return -1L;
            }
        } finally {
            try {
                this.zzQY.endTransaction();
            } catch (SQLiteException e4) {
                zze("Failed to end transaction", e4);
            }
        }
    }

    public void zza(zzab zzabVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzabVar);
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        if (this.zzRh) {
            zzbe("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", zzabVar);
        }
        zzab zzabVarZzf = zzf(zzabVar);
        zzjX();
        if (this.zzRb.zzb(zzabVarZzf)) {
            zzbe("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        if (zzjn().zzkr()) {
            zzjm().zza(zzabVarZzf, "Service unavailable on package side");
            return;
        }
        try {
            this.zzQY.zzc(zzabVarZzf);
            zzkb();
        } catch (SQLiteException e) {
            zze("Delivery failed to save hit to a database", e);
            zzjm().zza(zzabVarZzf, "deliver: failed to insert hit to database");
        }
    }

    public void zza(final zzw zzwVar, final long j) {
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        long jZzlH = zzjq().zzlH();
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(jZzlH != 0 ? Math.abs(zzjl().currentTimeMillis() - jZzlH) : -1L));
        if (!zzjn().zzkr()) {
            zzjX();
        }
        try {
            if (zzjZ()) {
                zzjo().zzf(new Runnable() { // from class: com.google.android.gms.analytics.internal.zzl.5
                    @Override // java.lang.Runnable
                    public void run() {
                        zzl.this.zza(zzwVar, j);
                    }
                });
                return;
            }
            zzjq().zzlI();
            zzkb();
            if (zzwVar != null) {
                zzwVar.zzc(null);
            }
            if (this.zzRg != j) {
                this.zzRa.zzlA();
            }
        } catch (Throwable th) {
            zze("Local dispatch failed", th);
            zzjq().zzlI();
            zzkb();
            if (zzwVar != null) {
                zzwVar.zzc(th);
            }
        }
    }

    public void zzb(zzw zzwVar) {
        zza(zzwVar, this.zzRg);
    }

    public void zzbl(String str) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        zzjk();
        zzjj();
        zzpr zzprVarZza = zzam.zza(zzjm(), str);
        if (zzprVarZza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String strZzlJ = zzjq().zzlJ();
        if (str.equals(strZzlJ)) {
            zzbg("Ignoring duplicate install campaign");
            return;
        }
        if (!TextUtils.isEmpty(strZzlJ)) {
            zzd("Ignoring multiple install campaigns. original, new", strZzlJ, str);
            return;
        }
        zzjq().zzbp(str);
        if (zzjq().zzlG().zzv(zzjn().zzkW())) {
            zzd("Campaign received too late, ignoring", zzprVarZza);
            return;
        }
        zzb("Received installation campaign", zzprVarZza);
        Iterator it = this.zzQY.zzr(0L).iterator();
        while (it.hasNext()) {
            zza((zzh) it.next(), zzprVarZza);
        }
    }

    protected void zzc(zzh zzhVar) {
        zzjk();
        zzb("Sending first hit to property", zzhVar.zzjE());
        if (zzjq().zzlG().zzv(zzjn().zzkW())) {
            return;
        }
        String strZzlJ = zzjq().zzlJ();
        if (TextUtils.isEmpty(strZzlJ)) {
            return;
        }
        zzpr zzprVarZza = zzam.zza(zzjm(), strZzlJ);
        zzb("Found relevant installation campaign", zzprVarZza);
        zza(zzhVar, zzprVarZza);
    }

    zzab zzf(zzab zzabVar) {
        Pair pairZzlN;
        if (!TextUtils.isEmpty(zzabVar.zzlv()) || (pairZzlN = zzjq().zzlK().zzlN()) == null) {
            return zzabVar;
        }
        String str = ((Long) pairZzlN.second) + ":" + ((String) pairZzlN.first);
        HashMap map = new HashMap(zzabVar.zzn());
        map.put("_m", str);
        return zzab.zza(this, zzabVar, map);
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
        this.zzQY.zza();
        this.zzQZ.zza();
        this.zzRb.zza();
    }

    public long zzjO() {
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        try {
            return this.zzQY.zzjO();
        } catch (SQLiteException e) {
            zze("Failed to get min/max hit times from local store", e);
            return 0L;
        }
    }

    protected void zzjU() {
        zzjv();
        zzjq().zzlF();
        if (!zzbk("android.permission.ACCESS_NETWORK_STATE")) {
            zzbh("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzkj();
        }
        if (!zzbk("android.permission.INTERNET")) {
            zzbh("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzkj();
        }
        if (AnalyticsService.zzZ(getContext())) {
            zzbd("AnalyticsService registered in the app manifest and enabled");
        } else if (zzjn().zzkr()) {
            zzbh("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            zzbg("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.zzRh && !zzjn().zzkr() && !this.zzQY.isEmpty()) {
            zzjX();
        }
        zzkb();
    }

    protected void zzjX() {
        if (this.zzRh || !zzjn().zzkt() || this.zzRb.isConnected()) {
            return;
        }
        if (this.zzRf.zzv(zzjn().zzkO())) {
            this.zzRf.start();
            zzbd("Connecting to service");
            if (this.zzRb.connect()) {
                zzbd("Connected to service");
                this.zzRf.clear();
                onServiceConnected();
            }
        }
    }

    public void zzjY() {
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        zzjj();
        if (!zzjn().zzkt()) {
            zzbg("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.zzRb.isConnected()) {
            zzbd("Service not connected");
            return;
        }
        if (this.zzQY.isEmpty()) {
            return;
        }
        zzbd("Dispatching local hits to device AnalyticsService");
        while (true) {
            try {
                List listZzp = this.zzQY.zzp(zzjn().zzkC());
                if (listZzp.isEmpty()) {
                    zzkb();
                    return;
                }
                while (!listZzp.isEmpty()) {
                    zzab zzabVar = (zzab) listZzp.get(0);
                    if (!this.zzRb.zzb(zzabVar)) {
                        zzkb();
                        return;
                    }
                    listZzp.remove(zzabVar);
                    try {
                        this.zzQY.zzq(zzabVar.zzlq());
                    } catch (SQLiteException e) {
                        zze("Failed to remove hit that was send for delivery", e);
                        zzkf();
                        return;
                    }
                }
            } catch (SQLiteException e2) {
                zze("Failed to read hits from store", e2);
                zzkf();
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
    
        zzbd("Store is empty, nothing to dispatch");
        zzkf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
    
        r12.zzQY.setTransactionSuccessful();
        r12.zzQY.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007b, code lost:
    
        zze("Failed to commit local dispatch transaction", r0);
        zzkf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fa, code lost:
    
        if (r12.zzRb.isConnected() == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0104, code lost:
    
        if (zzjn().zzkr() != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0106, code lost:
    
        zzbd("Service connected, sending hits to the service");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010f, code lost:
    
        if (r8.isEmpty() != false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0111, code lost:
    
        r0 = (com.google.android.gms.analytics.internal.zzab) r8.get(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x011e, code lost:
    
        if (r12.zzRb.zzb(r0) == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0120, code lost:
    
        r4 = java.lang.Math.max(r4, r0.zzlq());
        r8.remove(r0);
        zzb("Hit sent do device AnalyticsService for delivery", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0130, code lost:
    
        r12.zzQY.zzq(r0.zzlq());
        r3.add(java.lang.Long.valueOf(r0.zzlq()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0145, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0146, code lost:
    
        zze("Failed to remove hit that was send for delivery", r0);
        zzkf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x014e, code lost:
    
        r12.zzQY.setTransactionSuccessful();
        r12.zzQY.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x015a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x015b, code lost:
    
        zze("Failed to commit local dispatch transaction", r0);
        zzkf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0165, code lost:
    
        r0 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x016c, code lost:
    
        if (r12.zzQZ.zzlB() == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x016e, code lost:
    
        r9 = r12.zzQZ.zzq(r8);
        r10 = r9.iterator();
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x017d, code lost:
    
        if (r10.hasNext() == false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x017f, code lost:
    
        r4 = java.lang.Math.max(r4, ((java.lang.Long) r10.next()).longValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x018e, code lost:
    
        r8.removeAll(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0191, code lost:
    
        r12.zzQY.zzo(r9);
        r3.addAll(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0199, code lost:
    
        r0 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x019e, code lost:
    
        if (r3.isEmpty() == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01a0, code lost:
    
        r12.zzQY.setTransactionSuccessful();
        r12.zzQY.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01ac, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01ad, code lost:
    
        zze("Failed to commit local dispatch transaction", r0);
        zzkf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01b7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01b8, code lost:
    
        zze("Failed to remove successfully uploaded hits", r0);
        zzkf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c0, code lost:
    
        r12.zzQY.setTransactionSuccessful();
        r12.zzQY.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01cc, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01cd, code lost:
    
        zze("Failed to commit local dispatch transaction", r0);
        zzkf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01d7, code lost:
    
        r12.zzQY.setTransactionSuccessful();
        r12.zzQY.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01e4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01e5, code lost:
    
        zze("Failed to commit local dispatch transaction", r0);
        zzkf();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean zzjZ() {
        /*
            Method dump skipped, instructions count: 518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzl.zzjZ():boolean");
    }

    public void zzjc() {
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        if (!zzjn().zzkr()) {
            zzbd("Delete all hits from local store");
            try {
                this.zzQY.zzjL();
                this.zzQY.zzjM();
                zzkb();
            } catch (SQLiteException e) {
                zzd("Failed to delete hits from store", e);
            }
        }
        zzjX();
        if (this.zzRb.zzjH()) {
            zzbd("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    public void zzjf() {
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        zzbd("Service disconnected");
    }

    void zzjh() {
        zzjk();
        this.zzRg = zzjl().currentTimeMillis();
    }

    public void zzka() {
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        zzbe("Sync dispatching local hits");
        long j = this.zzRg;
        if (!zzjn().zzkr()) {
            zzjX();
        }
        do {
            try {
            } catch (Throwable th) {
                zze("Sync local dispatch failed", th);
                zzkb();
                return;
            }
        } while (zzjZ());
        zzjq().zzlI();
        zzkb();
        if (this.zzRg != j) {
            this.zzRa.zzlA();
        }
    }

    public void zzkb() {
        boolean zIsConnected;
        zzji().zzjk();
        zzjv();
        if (!zzkc()) {
            this.zzRa.unregister();
            zzkf();
            return;
        }
        if (this.zzQY.isEmpty()) {
            this.zzRa.unregister();
            zzkf();
            return;
        }
        if (((Boolean) zzy.zzSs.get()).booleanValue()) {
            zIsConnected = true;
        } else {
            this.zzRa.zzly();
            zIsConnected = this.zzRa.isConnected();
        }
        if (zIsConnected) {
            zzke();
        } else {
            zzkf();
            zzkd();
        }
    }

    public long zzki() {
        if (this.zzRc != Long.MIN_VALUE) {
            return this.zzRc;
        }
        return zziI().zzll() ? zziI().zzmc() * 1000 : zzjn().zzkz();
    }

    public void zzkj() {
        zzjv();
        zzjk();
        this.zzRh = true;
        this.zzRb.disconnect();
        zzkb();
    }

    public void zzs(long j) {
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        if (j < 0) {
            j = 0;
        }
        this.zzRc = j;
        zzkb();
    }
}
