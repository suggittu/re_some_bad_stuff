package com.google.android.gms.analytics.internal;

import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.zznf;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class zzr {
    private final zzf zzOK;
    private Set zzRA;
    private volatile Boolean zzRy;
    private String zzRz;

    protected zzr(zzf zzfVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzfVar);
        this.zzOK = zzfVar;
    }

    public long zzkA() {
        return ((Long) zzy.zzRV.get()).longValue();
    }

    public long zzkB() {
        return ((Long) zzy.zzRW.get()).longValue();
    }

    public int zzkC() {
        return ((Integer) zzy.zzRX.get()).intValue();
    }

    public int zzkD() {
        return ((Integer) zzy.zzRY.get()).intValue();
    }

    public long zzkE() {
        return ((Integer) zzy.zzSl.get()).intValue();
    }

    public String zzkF() {
        return (String) zzy.zzSa.get();
    }

    public String zzkG() {
        return (String) zzy.zzRZ.get();
    }

    public String zzkH() {
        return (String) zzy.zzSb.get();
    }

    public String zzkI() {
        return (String) zzy.zzSc.get();
    }

    public zzm zzkJ() {
        return zzm.zzbm((String) zzy.zzSe.get());
    }

    public zzo zzkK() {
        return zzo.zzbn((String) zzy.zzSf.get());
    }

    public Set zzkL() {
        String str = (String) zzy.zzSk.get();
        if (this.zzRA == null || this.zzRz == null || !this.zzRz.equals(str)) {
            String[] strArrSplit = TextUtils.split(str, ",");
            HashSet hashSet = new HashSet();
            for (String str2 : strArrSplit) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str2)));
                } catch (NumberFormatException e) {
                }
            }
            this.zzRz = str;
            this.zzRA = hashSet;
        }
        return this.zzRA;
    }

    public long zzkM() {
        return ((Long) zzy.zzSt.get()).longValue();
    }

    public long zzkN() {
        return ((Long) zzy.zzSu.get()).longValue();
    }

    public long zzkO() {
        return ((Long) zzy.zzSx.get()).longValue();
    }

    public int zzkP() {
        return ((Integer) zzy.zzRO.get()).intValue();
    }

    public int zzkQ() {
        return ((Integer) zzy.zzRQ.get()).intValue();
    }

    public String zzkR() {
        return "google_analytics_v4.db";
    }

    public String zzkS() {
        return "google_analytics2_v4.db";
    }

    public long zzkT() {
        return 86400000L;
    }

    public int zzkU() {
        return ((Integer) zzy.zzSn.get()).intValue();
    }

    public int zzkV() {
        return ((Integer) zzy.zzSo.get()).intValue();
    }

    public long zzkW() {
        return ((Long) zzy.zzSp.get()).longValue();
    }

    public long zzkX() {
        return ((Long) zzy.zzSy.get()).longValue();
    }

    public boolean zzkr() {
        return com.google.android.gms.common.internal.zzd.zzakE;
    }

    public boolean zzks() {
        if (this.zzRy == null) {
            synchronized (this) {
                if (this.zzRy == null) {
                    ApplicationInfo applicationInfo = this.zzOK.getContext().getApplicationInfo();
                    String strZzi = zznf.zzi(this.zzOK.getContext(), Process.myPid());
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzRy = Boolean.valueOf(str != null && str.equals(strZzi));
                    }
                    if ((this.zzRy == null || !this.zzRy.booleanValue()) && "com.google.android.gms.analytics".equals(strZzi)) {
                        this.zzRy = Boolean.TRUE;
                    }
                    if (this.zzRy == null) {
                        this.zzRy = Boolean.TRUE;
                        this.zzOK.zzjm().zzbh("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzRy.booleanValue();
    }

    public boolean zzkt() {
        return ((Boolean) zzy.zzRK.get()).booleanValue();
    }

    public int zzku() {
        return ((Integer) zzy.zzSd.get()).intValue();
    }

    public int zzkv() {
        return ((Integer) zzy.zzSh.get()).intValue();
    }

    public int zzkw() {
        return ((Integer) zzy.zzSi.get()).intValue();
    }

    public int zzkx() {
        return ((Integer) zzy.zzSj.get()).intValue();
    }

    public long zzky() {
        return ((Long) zzy.zzRS.get()).longValue();
    }

    public long zzkz() {
        return ((Long) zzy.zzRR.get()).longValue();
    }
}
