package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzrs;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class zzaz {
    private static zzag.zza zzK(Object obj) {
        return zzdf.zzR(zzL(obj));
    }

    static Object zzL(Object obj) {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        }
        if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        }
        if (!(obj instanceof JSONObject)) {
            return obj;
        }
        JSONObject jSONObject = (JSONObject) obj;
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, zzL(jSONObject.get(next)));
        }
        return map;
    }

    public static zzrs.zzc zzgi(String str) {
        zzag.zza zzaVarZzK = zzK(new JSONObject(str));
        zzrs.zzd zzdVarZzHK = zzrs.zzc.zzHK();
        for (int i = 0; i < zzaVarZzK.zzjz.length; i++) {
            zzdVarZzHK.zzc(zzrs.zza.zzHH().zzb(com.google.android.gms.internal.zzae.INSTANCE_NAME.toString(), zzaVarZzK.zzjz[i]).zzb(com.google.android.gms.internal.zzae.FUNCTION.toString(), zzdf.zzgt(zzn.zzFZ())).zzb(zzn.zzGa(), zzaVarZzK.zzjA[i]).zzHJ());
        }
        return zzdVarZzHK.zzHN();
    }
}
