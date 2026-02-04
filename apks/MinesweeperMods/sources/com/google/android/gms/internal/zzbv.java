package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@zzhb
/* loaded from: classes2.dex */
public class zzbv {
    final Context mContext;
    final String zzsy;
    String zzxj;
    BlockingQueue zzxl;
    ExecutorService zzxm;
    LinkedHashMap zzxn = new LinkedHashMap();
    Map zzxo = new HashMap();
    private AtomicBoolean zzxp = new AtomicBoolean(false);
    private File zzxq;

    public zzbv(Context context, String str, String str2, Map map) {
        File externalStorageDirectory;
        this.mContext = context;
        this.zzsy = str;
        this.zzxj = str2;
        this.zzxp.set(((Boolean) zzbt.zzwi.get()).booleanValue());
        if (this.zzxp.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzxq = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry entry : map.entrySet()) {
            this.zzxn.put(entry.getKey(), entry.getValue());
        }
        this.zzxl = new ArrayBlockingQueue(30);
        this.zzxm = Executors.newSingleThreadExecutor();
        this.zzxm.execute(new Runnable() { // from class: com.google.android.gms.internal.zzbv.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                zzbv.this.zzdx();
            }
        });
        this.zzxo.put("action", zzby.zzxt);
        this.zzxo.put("ad_format", zzby.zzxt);
        this.zzxo.put("e", zzby.zzxu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void zza(java.io.File r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            r3 = this;
            if (r4 == 0) goto L43
            r2 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L20 java.lang.Throwable -> L34
            r0 = 1
            r1.<init>(r4, r0)     // Catch: java.io.IOException -> L20 java.lang.Throwable -> L34
            byte[] r0 = r5.getBytes()     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b
            r1.write(r0)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b
            r0 = 10
            r1.write(r0)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b
            r1.close()     // Catch: java.io.IOException -> L19
        L18:
            return
        L19:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzin.zzd(r1, r0)
            goto L18
        L20:
            r0 = move-exception
            r1 = r2
        L22:
            java.lang.String r2 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzin.zzd(r2, r0)     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L18
            r1.close()     // Catch: java.io.IOException -> L2d
            goto L18
        L2d:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzin.zzd(r1, r0)
            goto L18
        L34:
            r0 = move-exception
            r1 = r2
        L36:
            if (r1 == 0) goto L3b
            r1.close()     // Catch: java.io.IOException -> L3c
        L3b:
            throw r0
        L3c:
            r1 = move-exception
            java.lang.String r2 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzin.zzd(r2, r1)
            goto L3b
        L43:
            java.lang.String r0 = "CsiReporter: File doesn't exists. Cannot write CSI data to file."
            com.google.android.gms.internal.zzin.zzaK(r0)
            goto L18
        L49:
            r0 = move-exception
            goto L36
        L4b:
            r0 = move-exception
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbv.zza(java.io.File, java.lang.String):void");
    }

    private void zzc(Map map, String str) throws Throwable {
        String strZza = zza(this.zzxj, map, str);
        if (this.zzxp.get()) {
            zza(this.zzxq, strZza);
        } else {
            com.google.android.gms.ads.internal.zzr.zzbC().zzc(this.mContext, this.zzsy, strZza);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzdx() throws Throwable {
        while (true) {
            try {
                zzcb zzcbVar = (zzcb) this.zzxl.take();
                String strZzdD = zzcbVar.zzdD();
                if (!TextUtils.isEmpty(strZzdD)) {
                    zzc(zza(this.zzxn, zzcbVar.zzn()), strZzdD);
                }
            } catch (InterruptedException e) {
                zzin.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    public zzby zzL(String str) {
        zzby zzbyVar = (zzby) this.zzxo.get(str);
        return zzbyVar != null ? zzbyVar : zzby.zzxs;
    }

    String zza(String str, Map map, @NonNull String str2) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        StringBuilder sb = new StringBuilder(builderBuildUpon.build().toString());
        sb.append("&it=").append(str2);
        return sb.toString();
    }

    Map zza(Map map, @Nullable Map map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            linkedHashMap.put(str, zzL(str).zzb((String) linkedHashMap.get(str), str2));
        }
        return linkedHashMap;
    }

    public boolean zza(zzcb zzcbVar) {
        return this.zzxl.offer(zzcbVar);
    }

    public void zzb(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzxn.put("e", TextUtils.join(",", list));
    }
}
