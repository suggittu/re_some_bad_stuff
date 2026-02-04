package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes2.dex */
class zzdj {
    private static zzbw zza(zzbw zzbwVar) {
        try {
            return new zzbw(zzdf.zzR(zzgA(zzdf.zzg((zzag.zza) zzbwVar.getObject()))), zzbwVar.zzGP());
        } catch (UnsupportedEncodingException e) {
            zzbg.zzb("Escape URI: unsupported encoding", e);
            return zzbwVar;
        }
    }

    private static zzbw zza(zzbw zzbwVar, int i) {
        if (!zzn((zzag.zza) zzbwVar.getObject())) {
            zzbg.e("Escaping can only be applied to strings.");
            return zzbwVar;
        }
        switch (i) {
            case 12:
                break;
            default:
                zzbg.e("Unsupported Value Escaping: " + i);
                break;
        }
        return zzbwVar;
    }

    static zzbw zza(zzbw zzbwVar, int... iArr) {
        for (int i : iArr) {
            zzbwVar = zza(zzbwVar, i);
        }
        return zzbwVar;
    }

    static String zzgA(String str) {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean zzn(zzag.zza zzaVar) {
        return zzdf.zzl(zzaVar) instanceof String;
    }
}
