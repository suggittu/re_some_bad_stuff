package com.google.android.gms.ads.internal.formats;

import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzcp;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.util.Arrays;
import java.util.List;

@zzhb
/* loaded from: classes2.dex */
public class zzf extends zzcp.zza implements zzh.zza {
    private final Object zzpV = new Object();
    private final zza zzye;
    private zzh zzyf;
    private final String zzyi;
    private final SimpleArrayMap zzyj;
    private final SimpleArrayMap zzyk;

    public zzf(String str, SimpleArrayMap simpleArrayMap, SimpleArrayMap simpleArrayMap2, zza zzaVar) {
        this.zzyi = str;
        this.zzyj = simpleArrayMap;
        this.zzyk = simpleArrayMap2;
        this.zzye = zzaVar;
    }

    @Override // com.google.android.gms.internal.zzcp
    public List getAvailableAssetNames() {
        int i = 0;
        String[] strArr = new String[this.zzyj.size() + this.zzyk.size()];
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzyj.size(); i3++) {
            strArr[i2] = (String) this.zzyj.keyAt(i3);
            i2++;
        }
        while (i < this.zzyk.size()) {
            strArr[i2] = (String) this.zzyk.keyAt(i);
            i++;
            i2++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.zzcp, com.google.android.gms.ads.internal.formats.zzh.zza
    public String getCustomTemplateId() {
        return this.zzyi;
    }

    @Override // com.google.android.gms.internal.zzcp
    public void performClick(String str) {
        synchronized (this.zzpV) {
            if (this.zzyf == null) {
                zzin.e("Attempt to call performClick before ad initialized.");
            } else {
                this.zzyf.zza(str, null, null, null);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzcp
    public void recordImpression() {
        synchronized (this.zzpV) {
            if (this.zzyf == null) {
                zzin.e("Attempt to perform recordImpression before ad initialized.");
            } else {
                this.zzyf.recordImpression();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzcp
    public String zzO(String str) {
        return (String) this.zzyk.get(str);
    }

    @Override // com.google.android.gms.internal.zzcp
    public zzch zzP(String str) {
        return (zzch) this.zzyj.get(str);
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public void zzb(zzh zzhVar) {
        synchronized (this.zzpV) {
            this.zzyf = zzhVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public String zzdM() {
        return "3";
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public zza zzdN() {
        return this.zzye;
    }
}
