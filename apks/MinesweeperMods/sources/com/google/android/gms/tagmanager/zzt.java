package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
class zzt extends zzak {
    private final zza zzbiq;
    private static final String ID = com.google.android.gms.internal.zzad.FUNCTION_CALL.toString();
    private static final String zzbip = com.google.android.gms.internal.zzae.FUNCTION_CALL_NAME.toString();
    private static final String zzbhF = com.google.android.gms.internal.zzae.ADDITIONAL_PARAMS.toString();

    public interface zza {
        Object zzc(String str, Map map);
    }

    public zzt(zza zzaVar) {
        super(ID, zzbip);
        this.zzbiq = zzaVar;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzP(Map map) {
        String strZzg = zzdf.zzg((zzag.zza) map.get(zzbip));
        HashMap map2 = new HashMap();
        zzag.zza zzaVar = (zzag.zza) map.get(zzbhF);
        if (zzaVar != null) {
            Object objZzl = zzdf.zzl(zzaVar);
            if (!(objZzl instanceof Map)) {
                zzbg.zzaK("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return zzdf.zzHF();
            }
            for (Map.Entry entry : ((Map) objZzl).entrySet()) {
                map2.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return zzdf.zzR(this.zzbiq.zzc(strZzg, map2));
        } catch (Exception e) {
            zzbg.zzaK("Custom macro/tag " + strZzg + " threw exception " + e.getMessage());
            return zzdf.zzHF();
        }
    }
}
