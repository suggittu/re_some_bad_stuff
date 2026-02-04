package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzj;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzhn;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjq;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
/* loaded from: classes2.dex */
public final class zzhd extends zzj.zza {
    private static zzhd zzIQ;
    private static final Object zzqy = new Object();
    private final Context mContext;
    private final zzhc zzIR;
    private final zzbm zzIS;
    private final zzeg zzIT;

    zzhd(Context context, zzbm zzbmVar, zzhc zzhcVar) {
        this.mContext = context;
        this.zzIR = zzhcVar;
        this.zzIS = zzbmVar;
        this.zzIT = new zzeg(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(8487000, 8487000, true), zzbmVar.zzdp(), new zzeg.zzb() { // from class: com.google.android.gms.internal.zzhd.6
            @Override // com.google.android.gms.internal.zzeg.zzb
            /* renamed from: zza, reason: merged with bridge method [inline-methods] */
            public void zze(zzed zzedVar) {
                zzedVar.zza("/log", zzde.zzzf);
            }
        }, new zzeg.zzc());
    }

    private static AdResponseParcel zza(final Context context, final zzeg zzegVar, final zzbm zzbmVar, final zzhc zzhcVar, final AdRequestInfoParcel adRequestInfoParcel) throws ExecutionException, JSONException, InterruptedException, TimeoutException {
        Bundle bundle;
        zzjg zzjgVarZza;
        String string;
        zzin.zzaI("Starting ad request from service.");
        zzbt.initialize(context);
        final zzcb zzcbVar = new zzcb(((Boolean) zzbt.zzwg.get()).booleanValue(), "load_ad", adRequestInfoParcel.zzrp.zzuh);
        if (adRequestInfoParcel.versionCode > 10 && adRequestInfoParcel.zzHL != -1) {
            zzcbVar.zza(zzcbVar.zzb(adRequestInfoParcel.zzHL), "cts");
        }
        zzbz zzbzVarZzdB = zzcbVar.zzdB();
        final Bundle bundle2 = (adRequestInfoParcel.versionCode < 4 || adRequestInfoParcel.zzHA == null) ? null : adRequestInfoParcel.zzHA;
        if (!((Boolean) zzbt.zzwp.get()).booleanValue() || zzhcVar.zzIP == null) {
            bundle = bundle2;
            zzjgVarZza = null;
        } else {
            if (bundle2 == null && ((Boolean) zzbt.zzwq.get()).booleanValue()) {
                zzin.v("contentInfo is not present, but we'll still launch the app index task");
                bundle2 = new Bundle();
            }
            if (bundle2 != null) {
                bundle = bundle2;
                zzjgVarZza = zziq.zza(new Callable() { // from class: com.google.android.gms.internal.zzhd.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: zzdt, reason: merged with bridge method [inline-methods] */
                    public final Void call() {
                        zzhcVar.zzIP.zza(context, adRequestInfoParcel.zzHu.packageName, bundle2);
                        return null;
                    }
                });
            } else {
                bundle = bundle2;
                zzjgVarZza = null;
            }
        }
        zzhcVar.zzIK.zzex();
        zzhj zzhjVarZzE = com.google.android.gms.ads.internal.zzr.zzbI().zzE(context);
        if (zzhjVarZzE.zzKc == -1) {
            zzin.zzaI("Device is offline.");
            return new AdResponseParcel(2);
        }
        String string2 = adRequestInfoParcel.versionCode >= 7 ? adRequestInfoParcel.zzHI : UUID.randomUUID().toString();
        final zzhf zzhfVar = new zzhf(string2, adRequestInfoParcel.applicationInfo.packageName);
        if (adRequestInfoParcel.zzHt.extras != null && (string = adRequestInfoParcel.zzHt.extras.getString("_ad")) != null) {
            return zzhe.zza(context, adRequestInfoParcel, string);
        }
        Location locationZzd = zzhcVar.zzIK.zzd(250L);
        String token = zzhcVar.zzIL.getToken(context, adRequestInfoParcel.zzrj, adRequestInfoParcel.zzHu.packageName);
        List listZza = zzhcVar.zzII.zza(adRequestInfoParcel);
        String strZzf = zzhcVar.zzIM.zzf(adRequestInfoParcel);
        zzhn.zza zzaVarZzF = zzhcVar.zzIN.zzF(context);
        if (zzjgVarZza != null) {
            try {
                zzin.v("Waiting for app index fetching task.");
                zzjgVarZza.get(((Long) zzbt.zzwr.get()).longValue(), TimeUnit.MILLISECONDS);
                zzin.v("App index fetching task completed.");
            } catch (InterruptedException e) {
                e = e;
                zzin.zzd("Failed to fetch app index signal", e);
            } catch (ExecutionException e2) {
                e = e2;
                zzin.zzd("Failed to fetch app index signal", e);
            } catch (TimeoutException e3) {
                zzin.zzaI("Timed out waiting for app index fetching task");
            }
        }
        JSONObject jSONObjectZza = zzhe.zza(context, adRequestInfoParcel, zzhjVarZzE, zzaVarZzF, locationZzd, zzbmVar, token, strZzf, listZza, bundle);
        if (adRequestInfoParcel.versionCode < 7) {
            try {
                jSONObjectZza.put("request_id", string2);
            } catch (JSONException e4) {
            }
        }
        if (jSONObjectZza == null) {
            return new AdResponseParcel(0);
        }
        final String string3 = jSONObjectZza.toString();
        zzcbVar.zza(zzbzVarZzdB, "arc");
        final zzbz zzbzVarZzdB2 = zzcbVar.zzdB();
        if (((Boolean) zzbt.zzvC.get()).booleanValue()) {
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzhd.2
                @Override // java.lang.Runnable
                public final void run() {
                    zzeg.zzd zzdVarZzer = zzegVar.zzer();
                    zzhfVar.zzb(zzdVarZzer);
                    zzcbVar.zza(zzbzVarZzdB2, "rwc");
                    final zzbz zzbzVarZzdB3 = zzcbVar.zzdB();
                    zzdVarZzer.zza(new zzji.zzc() { // from class: com.google.android.gms.internal.zzhd.2.1
                        @Override // com.google.android.gms.internal.zzji.zzc
                        /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
                        public void zze(zzeh zzehVar) {
                            zzcbVar.zza(zzbzVarZzdB3, "jsf");
                            zzcbVar.zzdC();
                            zzehVar.zza("/invalidRequest", zzhfVar.zzJk);
                            zzehVar.zza("/loadAdURL", zzhfVar.zzJl);
                            try {
                                zzehVar.zze("AFMA_buildAdURL", string3);
                            } catch (Exception e5) {
                                zzin.zzb("Error requesting an ad url", e5);
                            }
                        }
                    }, new zzji.zza() { // from class: com.google.android.gms.internal.zzhd.2.2
                        @Override // com.google.android.gms.internal.zzji.zza
                        public void run() {
                        }
                    });
                }
            });
        } else {
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzhd.3
                @Override // java.lang.Runnable
                public final void run() {
                    zzjp zzjpVarZza = com.google.android.gms.ads.internal.zzr.zzbD().zza(context, new AdSizeParcel(), false, false, null, adRequestInfoParcel.zzrl);
                    if (com.google.android.gms.ads.internal.zzr.zzbF().zzhi()) {
                        zzjpVarZza.clearCache(true);
                    }
                    zzjpVarZza.getWebView().setWillNotDraw(true);
                    zzhfVar.zzh(zzjpVarZza);
                    zzcbVar.zza(zzbzVarZzdB2, "rwc");
                    zzjq.zza zzaVarZza = zzhd.zza(string3, zzcbVar, zzcbVar.zzdB());
                    zzjq zzjqVarZzhU = zzjpVarZza.zzhU();
                    zzjqVarZzhU.zza("/invalidRequest", zzhfVar.zzJk);
                    zzjqVarZzhU.zza("/loadAdURL", zzhfVar.zzJl);
                    zzjqVarZzhU.zza("/log", zzde.zzzf);
                    zzjqVarZzhU.zza(zzaVarZza);
                    zzin.zzaI("Loading the JS library.");
                    zzjpVarZza.loadUrl(zzbmVar.zzdp());
                }
            });
        }
        try {
            zzhi zzhiVar = (zzhi) zzhfVar.zzgC().get(10L, TimeUnit.SECONDS);
            if (zzhiVar == null) {
                return new AdResponseParcel(0);
            }
            if (zzhiVar.getErrorCode() != -2) {
                return new AdResponseParcel(zzhiVar.getErrorCode());
            }
            if (zzcbVar.zzdE() != null) {
                zzcbVar.zza(zzcbVar.zzdE(), "rur");
            }
            AdResponseParcel adResponseParcelZza = zza(adRequestInfoParcel, context, adRequestInfoParcel.zzrl.afmaVersion, zzhiVar.getUrl(), zzhiVar.zzgG() ? zzhcVar.zzIH.zzaz(adRequestInfoParcel.zzHu.packageName) : null, zzhiVar.zzgH() ? token : null, zzhiVar, zzcbVar, zzhcVar);
            if (adResponseParcelZza.zzIf == 1) {
                zzhcVar.zzIL.clearToken(context, adRequestInfoParcel.zzHu.packageName);
            }
            zzcbVar.zza(zzbzVarZzdB, "tts");
            adResponseParcelZza.zzIh = zzcbVar.zzdD();
            return adResponseParcelZza;
        } catch (Exception e5) {
            return new AdResponseParcel(0);
        } finally {
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzhd.4
                @Override // java.lang.Runnable
                public final void run() {
                    zzhcVar.zzIJ.zza(context, zzhfVar, adRequestInfoParcel.zzrl);
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0183, code lost:
    
        com.google.android.gms.internal.zzin.zzaK("Received error HTTP response code: " + r9);
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019b, code lost:
    
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x019e, code lost:
    
        if (r21 == null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a0, code lost:
    
        r21.zzIO.zzgK();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, com.google.android.gms.internal.zzhi r19, com.google.android.gms.internal.zzcb r20, com.google.android.gms.internal.zzhc r21) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhd.zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.zzhi, com.google.android.gms.internal.zzcb, com.google.android.gms.internal.zzhc):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static zzhd zza(Context context, zzbm zzbmVar, zzhc zzhcVar) {
        zzhd zzhdVar;
        synchronized (zzqy) {
            if (zzIQ == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzIQ = new zzhd(context, zzbmVar, zzhcVar);
            }
            zzhdVar = zzIQ;
        }
        return zzhdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzjq.zza zza(final String str, final zzcb zzcbVar, final zzbz zzbzVar) {
        return new zzjq.zza() { // from class: com.google.android.gms.internal.zzhd.5
            @Override // com.google.android.gms.internal.zzjq.zza
            public final void zza(zzjp zzjpVar, boolean z) {
                zzcbVar.zza(zzbzVar, "jsf");
                zzcbVar.zzdC();
                zzjpVar.zze("AFMA_buildAdURL", str);
            }
        };
    }

    private static void zza(String str, Map map, String str2, int i) {
        if (zzin.zzQ(2)) {
            zzin.v("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    zzin.v("    " + str3 + ":");
                    Iterator it = ((List) map.get(str3)).iterator();
                    while (it.hasNext()) {
                        zzin.v("      " + ((String) it.next()));
                    }
                }
            }
            zzin.v("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    zzin.v(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                zzin.v("    null");
            }
            zzin.v("  Response Code:\n    " + i + "\n}");
        }
    }

    @Override // com.google.android.gms.ads.internal.request.zzj
    public final void zza(final AdRequestInfoParcel adRequestInfoParcel, final com.google.android.gms.ads.internal.request.zzk zzkVar) {
        com.google.android.gms.ads.internal.zzr.zzbF().zzb(this.mContext, adRequestInfoParcel.zzrl);
        zziq.zza(new Runnable() { // from class: com.google.android.gms.internal.zzhd.7
            @Override // java.lang.Runnable
            public void run() {
                AdResponseParcel adResponseParcel;
                try {
                    adResponseParcel = zzhd.this.zzd(adRequestInfoParcel);
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.zzr.zzbF().zzb((Throwable) e, true);
                    zzin.zzd("Could not fetch ad response due to an Exception.", e);
                    adResponseParcel = null;
                }
                if (adResponseParcel == null) {
                    adResponseParcel = new AdResponseParcel(0);
                }
                try {
                    zzkVar.zzb(adResponseParcel);
                } catch (RemoteException e2) {
                    zzin.zzd("Fail to forward ad response.", e2);
                }
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.request.zzj
    public final AdResponseParcel zzd(AdRequestInfoParcel adRequestInfoParcel) {
        return zza(this.mContext, this.zzIT, this.zzIS, this.zzIR, adRequestInfoParcel);
    }
}
