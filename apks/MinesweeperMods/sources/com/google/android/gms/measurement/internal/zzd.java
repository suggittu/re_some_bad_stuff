package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zznf;
import com.google.android.gms.measurement.internal.zzl;

/* loaded from: classes2.dex */
public class zzd extends zzy {
    static final String zzaVA = String.valueOf(com.google.android.gms.common.zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    private Boolean zzRy;

    zzd(zzw zzwVar) {
        super(zzwVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzp zzAo() {
        return super.zzAo();
    }

    public int zzBA() {
        return 25;
    }

    int zzBB() {
        return 32;
    }

    public int zzBC() {
        return 24;
    }

    int zzBD() {
        return 36;
    }

    int zzBE() {
        return 256;
    }

    public int zzBF() {
        return 36;
    }

    public int zzBG() {
        return 2048;
    }

    int zzBH() {
        return 500;
    }

    public long zzBI() {
        return ((Integer) zzl.zzaWk.get()).intValue();
    }

    public long zzBJ() {
        return ((Integer) zzl.zzaWl.get()).intValue();
    }

    public long zzBK() {
        return ((Integer) zzl.zzaWm.get()).intValue();
    }

    int zzBL() {
        return 25;
    }

    int zzBM() {
        return 50;
    }

    long zzBN() {
        return 3600000L;
    }

    long zzBO() {
        return 60000L;
    }

    long zzBP() {
        return 61000L;
    }

    public long zzBQ() {
        return ((Long) zzl.zzaWw.get()).longValue();
    }

    public long zzBR() {
        return ((Long) zzl.zzaWs.get()).longValue();
    }

    public long zzBS() {
        return 1000L;
    }

    public int zzBT() {
        return Math.max(0, ((Integer) zzl.zzaWi.get()).intValue());
    }

    public int zzBU() {
        return Math.max(1, ((Integer) zzl.zzaWj.get()).intValue());
    }

    public String zzBV() {
        return (String) zzl.zzaWo.get();
    }

    public long zzBW() {
        return ((Long) zzl.zzaWd.get()).longValue();
    }

    public long zzBX() {
        return Math.max(0L, ((Long) zzl.zzaWp.get()).longValue());
    }

    public long zzBY() {
        return Math.max(0L, ((Long) zzl.zzaWr.get()).longValue());
    }

    public long zzBZ() {
        return ((Long) zzl.zzaWq.get()).longValue();
    }

    public long zzBp() {
        return com.google.android.gms.common.zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000;
    }

    String zzBz() {
        return (String) zzl.zzaWa.get();
    }

    public long zzCa() {
        return Math.max(0L, ((Long) zzl.zzaWt.get()).longValue());
    }

    public long zzCb() {
        return Math.max(0L, ((Long) zzl.zzaWu.get()).longValue());
    }

    public int zzCc() {
        return Math.min(20, Math.max(0, ((Integer) zzl.zzaWv.get()).intValue()));
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzCd() {
        super.zzCd();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzc zzCe() {
        return super.zzCe();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzab zzCf() {
        return super.zzCf();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzn zzCg() {
        return super.zzCg();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzg zzCh() {
        return super.zzCh();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzac zzCi() {
        return super.zzCi();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zze zzCj() {
        return super.zzCj();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzaj zzCk() {
        return super.zzCk();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzu zzCl() {
        return super.zzCl();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzad zzCm() {
        return super.zzCm();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzv zzCn() {
        return super.zzCn();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzt zzCo() {
        return super.zzCo();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzd zzCp() {
        return super.zzCp();
    }

    public String zzH(String str, String str2) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme((String) zzl.zzaWe.get()).authority((String) zzl.zzaWf.get()).path("config/app/" + str).appendQueryParameter("app_instance_id", str2).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zzBp()));
        return builder.build().toString();
    }

    public long zza(String str, zzl.zza zzaVar) {
        if (str == null) {
            return ((Long) zzaVar.get()).longValue();
        }
        String strZzO = zzCl().zzO(str, zzaVar.getKey());
        if (TextUtils.isEmpty(strZzO)) {
            return ((Long) zzaVar.get()).longValue();
        }
        try {
            return ((Long) zzaVar.get(Long.valueOf(Long.valueOf(strZzO).longValue()))).longValue();
        } catch (NumberFormatException e) {
            return ((Long) zzaVar.get()).longValue();
        }
    }

    public int zzb(String str, zzl.zza zzaVar) {
        if (str == null) {
            return ((Integer) zzaVar.get()).intValue();
        }
        String strZzO = zzCl().zzO(str, zzaVar.getKey());
        if (TextUtils.isEmpty(strZzO)) {
            return ((Integer) zzaVar.get()).intValue();
        }
        try {
            return ((Integer) zzaVar.get(Integer.valueOf(Integer.valueOf(strZzO).intValue()))).intValue();
        } catch (NumberFormatException e) {
            return ((Integer) zzaVar.get()).intValue();
        }
    }

    long zzeS(String str) {
        return zza(str, zzl.zzaWb);
    }

    int zzeT(String str) {
        return zzb(str, zzl.zzaWx);
    }

    public int zzeU(String str) {
        return zzb(str, zzl.zzaWg);
    }

    public int zzeV(String str) {
        return Math.max(0, zzb(str, zzl.zzaWh));
    }

    public int zzeW(String str) {
        return Math.max(0, Math.min(1000000, zzb(str, zzl.zzaWn)));
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzjj() {
        super.zzjj();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzjk() {
        super.zzjk();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzmq zzjl() {
        return super.zzjl();
    }

    long zzkM() {
        return ((Long) zzl.zzaWy.get()).longValue();
    }

    public String zzkR() {
        return "google_app_measurement.db";
    }

    public String zzkS() {
        return "google_app_measurement2.db";
    }

    public long zzkX() {
        return Math.max(0L, ((Long) zzl.zzaWc.get()).longValue());
    }

    public boolean zzkr() {
        return com.google.android.gms.common.internal.zzd.zzakE;
    }

    public boolean zzks() {
        if (this.zzRy == null) {
            synchronized (this) {
                if (this.zzRy == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String strZzi = zznf.zzi(getContext(), Process.myPid());
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzRy = Boolean.valueOf(str != null && str.equals(strZzi));
                    }
                    if (this.zzRy == null) {
                        this.zzRy = Boolean.TRUE;
                        zzAo().zzCE().zzfg("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzRy.booleanValue();
    }
}
