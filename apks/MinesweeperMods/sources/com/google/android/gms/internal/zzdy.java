package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.internal.zzea;
import com.google.android.gms.internal.zzhj;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@zzhb
/* loaded from: classes2.dex */
public class zzdy {
    private final Map zzAx = new HashMap();
    private final LinkedList zzAy = new LinkedList();
    private zzdv zzAz;

    private String[] zzY(String str) {
        try {
            String[] strArrSplit = str.split("\u0000");
            for (int i = 0; i < strArrSplit.length; i++) {
                strArrSplit[i] = new String(Base64.decode(strArrSplit[i], 0), "UTF-8");
            }
            return strArrSplit;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    private static void zza(String str, zzdz zzdzVar) {
        if (zzin.zzQ(2)) {
            zzin.v(String.format(str, zzdzVar));
        }
    }

    private String zzef() {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator it = this.zzAy.iterator();
            while (it.hasNext()) {
                sb.append(Base64.encodeToString(((zzdz) it.next()).toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    sb.append("\u0000");
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    void flush() {
        while (this.zzAy.size() > 0) {
            zzdz zzdzVar = (zzdz) this.zzAy.remove();
            zzea zzeaVar = (zzea) this.zzAx.get(zzdzVar);
            zza("Flushing interstitial queue for %s.", zzdzVar);
            while (zzeaVar.size() > 0) {
                zzeaVar.zzej().zzAD.zzbp();
            }
            this.zzAx.remove(zzdzVar);
        }
    }

    void restore() {
        if (this.zzAz == null) {
            return;
        }
        SharedPreferences sharedPreferences = this.zzAz.zzed().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
        flush();
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            try {
                if (!entry.getKey().equals("PoolKeys")) {
                    zzec zzecVar = new zzec((String) entry.getValue());
                    zzdz zzdzVar = new zzdz(zzecVar.zzqH, zzecVar.zzpS, zzecVar.zzAC);
                    if (!this.zzAx.containsKey(zzdzVar)) {
                        this.zzAx.put(zzdzVar, new zzea(zzecVar.zzqH, zzecVar.zzpS, zzecVar.zzAC));
                        map.put(zzdzVar.toString(), zzdzVar);
                        zza("Restored interstitial queue for %s.", zzdzVar);
                    }
                }
            } catch (IOException | ClassCastException e) {
                zzin.zzd("Malformed preferences value for InterstitialAdPool.", e);
            }
        }
        for (String str : zzY(sharedPreferences.getString("PoolKeys", ""))) {
            zzdz zzdzVar2 = (zzdz) map.get(str);
            if (this.zzAx.containsKey(zzdzVar2)) {
                this.zzAy.add(zzdzVar2);
            }
        }
    }

    void save() {
        if (this.zzAz == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.zzAz.zzed().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
        editorEdit.clear();
        for (Map.Entry entry : this.zzAx.entrySet()) {
            zzdz zzdzVar = (zzdz) entry.getKey();
            if (zzdzVar.zzeh()) {
                editorEdit.putString(zzdzVar.toString(), new zzec((zzea) entry.getValue()).zzem());
                zza("Saved interstitial queue for %s.", zzdzVar);
            }
        }
        editorEdit.putString("PoolKeys", zzef());
        editorEdit.commit();
    }

    zzea.zza zza(AdRequestParcel adRequestParcel, String str) {
        zzea zzeaVar;
        int i = new zzhj.zza(this.zzAz.zzed()).zzgI().zzKc;
        zzdz zzdzVar = new zzdz(adRequestParcel, str, i);
        zzea zzeaVar2 = (zzea) this.zzAx.get(zzdzVar);
        if (zzeaVar2 == null) {
            zza("Interstitial pool created at %s.", zzdzVar);
            zzea zzeaVar3 = new zzea(adRequestParcel, str, i);
            this.zzAx.put(zzdzVar, zzeaVar3);
            zzeaVar = zzeaVar3;
        } else {
            zzeaVar = zzeaVar2;
        }
        this.zzAy.remove(zzdzVar);
        this.zzAy.add(zzdzVar);
        zzdzVar.zzeg();
        while (this.zzAy.size() > ((Integer) zzbt.zzwG.get()).intValue()) {
            zzdz zzdzVar2 = (zzdz) this.zzAy.remove();
            zzea zzeaVar4 = (zzea) this.zzAx.get(zzdzVar2);
            zza("Evicting interstitial queue for %s.", zzdzVar2);
            while (zzeaVar4.size() > 0) {
                zzeaVar4.zzej().zzAD.zzbp();
            }
            this.zzAx.remove(zzdzVar2);
        }
        while (zzeaVar.size() > 0) {
            zzea.zza zzaVarZzej = zzeaVar.zzej();
            if (!zzaVarZzej.zzAG || com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis() - zzaVarZzej.zzAF <= 1000 * ((Integer) zzbt.zzwI.get()).intValue()) {
                zza("Pooled interstitial returned at %s.", zzdzVar);
                return zzaVarZzej;
            }
            zza("Expired interstitial at %s.", zzdzVar);
        }
        return null;
    }

    void zza(zzdv zzdvVar) {
        if (this.zzAz == null) {
            this.zzAz = zzdvVar;
            restore();
        }
    }

    void zzee() {
        if (this.zzAz == null) {
            return;
        }
        for (Map.Entry entry : this.zzAx.entrySet()) {
            zzdz zzdzVar = (zzdz) entry.getKey();
            zzea zzeaVar = (zzea) entry.getValue();
            while (zzeaVar.size() < ((Integer) zzbt.zzwH.get()).intValue()) {
                zza("Pooling one interstitial for %s.", zzdzVar);
                zzeaVar.zzb(this.zzAz);
            }
        }
        save();
    }
}
