package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzir;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@zzhb
/* loaded from: classes2.dex */
public class zzi extends zzr.zza {
    private final Context mContext;
    private final com.google.android.gms.ads.internal.client.zzq zzpK;
    private final zzcr zzpL;
    private final zzcs zzpM;
    private final SimpleArrayMap zzpN;
    private final SimpleArrayMap zzpO;
    private final NativeAdOptionsParcel zzpP;
    private final zzx zzpR;
    private final String zzpS;
    private final VersionInfoParcel zzpT;
    private WeakReference zzpU;
    private final zzd zzpm;
    private final zzex zzpn;
    private final Object zzpV = new Object();
    private final List zzpQ = zzbl();

    zzi(Context context, String str, zzex zzexVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.client.zzq zzqVar, zzcr zzcrVar, zzcs zzcsVar, SimpleArrayMap simpleArrayMap, SimpleArrayMap simpleArrayMap2, NativeAdOptionsParcel nativeAdOptionsParcel, zzx zzxVar, zzd zzdVar) {
        this.mContext = context;
        this.zzpS = str;
        this.zzpn = zzexVar;
        this.zzpT = versionInfoParcel;
        this.zzpK = zzqVar;
        this.zzpM = zzcsVar;
        this.zzpL = zzcrVar;
        this.zzpN = simpleArrayMap;
        this.zzpO = simpleArrayMap2;
        this.zzpP = nativeAdOptionsParcel;
        this.zzpR = zzxVar;
        this.zzpm = zzdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List zzbl() {
        ArrayList arrayList = new ArrayList();
        if (this.zzpM != null) {
            arrayList.add("1");
        }
        if (this.zzpL != null) {
            arrayList.add("2");
        }
        if (this.zzpN.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public String getMediationAdapterClassName() {
        synchronized (this.zzpV) {
            if (this.zzpU == null) {
                return null;
            }
            zzp zzpVar = (zzp) this.zzpU.get();
            return zzpVar != null ? zzpVar.getMediationAdapterClassName() : null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public boolean isLoading() {
        synchronized (this.zzpV) {
            if (this.zzpU == null) {
                return false;
            }
            zzp zzpVar = (zzp) this.zzpU.get();
            return zzpVar != null ? zzpVar.isLoading() : false;
        }
    }

    protected void runOnUiThread(Runnable runnable) {
        zzir.zzMc.post(runnable);
    }

    protected zzp zzbm() {
        return new zzp(this.mContext, this.zzpm, AdSizeParcel.zzt(this.mContext), this.zzpS, this.zzpn, this.zzpT);
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void zzf(final AdRequestParcel adRequestParcel) {
        runOnUiThread(new Runnable() { // from class: com.google.android.gms.ads.internal.zzi.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (zzi.this.zzpV) {
                    zzp zzpVarZzbm = zzi.this.zzbm();
                    zzi.this.zzpU = new WeakReference(zzpVarZzbm);
                    zzpVarZzbm.zzb(zzi.this.zzpL);
                    zzpVarZzbm.zzb(zzi.this.zzpM);
                    zzpVarZzbm.zza(zzi.this.zzpN);
                    zzpVarZzbm.zza(zzi.this.zzpK);
                    zzpVarZzbm.zzb(zzi.this.zzpO);
                    zzpVarZzbm.zza(zzi.this.zzbl());
                    zzpVarZzbm.zzb(zzi.this.zzpP);
                    zzpVarZzbm.zza(zzi.this.zzpR);
                    zzpVarZzbm.zzb(adRequestParcel);
                }
            }
        });
    }
}
