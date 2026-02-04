package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.internal.zzag;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
class zzj extends zzdd {
    private static final String ID = com.google.android.gms.internal.zzad.ARBITRARY_PIXEL.toString();
    private static final String URL = com.google.android.gms.internal.zzae.URL.toString();
    private static final String zzbhF = com.google.android.gms.internal.zzae.ADDITIONAL_PARAMS.toString();
    private static final String zzbhG = com.google.android.gms.internal.zzae.UNREPEATABLE.toString();
    static final String zzbhH = "gtm_" + ID + "_unrepeatable";
    private static final Set zzbhI = new HashSet();
    private final Context mContext;
    private final zza zzbhJ;

    public interface zza {
        zzar zzFX();
    }

    public zzj(final Context context) {
        this(context, new zza() { // from class: com.google.android.gms.tagmanager.zzj.1
            @Override // com.google.android.gms.tagmanager.zzj.zza
            public zzar zzFX() {
                return zzz.zzaX(context);
            }
        });
    }

    zzj(Context context, zza zzaVar) {
        super(ID, URL);
        this.zzbhJ = zzaVar;
        this.mContext = context;
    }

    private synchronized boolean zzfL(String str) {
        boolean z = true;
        synchronized (this) {
            if (!zzfN(str)) {
                if (zzfM(str)) {
                    zzbhI.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    @Override // com.google.android.gms.tagmanager.zzdd
    public void zzR(Map map) {
        String strZzg = map.get(zzbhG) != null ? zzdf.zzg((zzag.zza) map.get(zzbhG)) : null;
        if (strZzg == null || !zzfL(strZzg)) {
            Uri.Builder builderBuildUpon = Uri.parse(zzdf.zzg((zzag.zza) map.get(URL))).buildUpon();
            zzag.zza zzaVar = (zzag.zza) map.get(zzbhF);
            if (zzaVar != null) {
                Object objZzl = zzdf.zzl(zzaVar);
                if (!(objZzl instanceof List)) {
                    zzbg.e("ArbitraryPixel: additional params not a list: not sending partial hit: " + builderBuildUpon.build().toString());
                    return;
                }
                for (Object obj : (List) objZzl) {
                    if (!(obj instanceof Map)) {
                        zzbg.e("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + builderBuildUpon.build().toString());
                        return;
                    }
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        builderBuildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
            }
            String string = builderBuildUpon.build().toString();
            this.zzbhJ.zzFX().zzgc(string);
            zzbg.v("ArbitraryPixel: url = " + string);
            if (strZzg != null) {
                synchronized (zzj.class) {
                    zzbhI.add(strZzg);
                    zzcv.zzb(this.mContext, zzbhH, strZzg, "true");
                }
            }
        }
    }

    boolean zzfM(String str) {
        return this.mContext.getSharedPreferences(zzbhH, 0).contains(str);
    }

    boolean zzfN(String str) {
        return zzbhI.contains(str);
    }
}
