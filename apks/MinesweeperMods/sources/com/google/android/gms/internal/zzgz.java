package com.google.android.gms.internal;

import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.internal.zzgw;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
/* loaded from: classes2.dex */
public class zzgz implements zzgw.zza {
    private final boolean zzHc;

    public zzgz(boolean z) {
        this.zzHc = z;
    }

    private void zza(zzgw zzgwVar, JSONObject jSONObject, SimpleArrayMap simpleArrayMap) {
        simpleArrayMap.put(jSONObject.getString("name"), zzgwVar.zza(jSONObject, "image_value", this.zzHc));
    }

    private void zza(JSONObject jSONObject, SimpleArrayMap simpleArrayMap) {
        simpleArrayMap.put(jSONObject.getString("name"), jSONObject.getString("string_value"));
    }

    private SimpleArrayMap zzc(SimpleArrayMap simpleArrayMap) {
        SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= simpleArrayMap.size()) {
                return simpleArrayMap2;
            }
            simpleArrayMap2.put(simpleArrayMap.keyAt(i2), ((Future) simpleArrayMap.valueAt(i2)).get());
            i = i2 + 1;
        }
    }

    @Override // com.google.android.gms.internal.zzgw.zza
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.ads.internal.formats.zzf zza(zzgw zzgwVar, JSONObject jSONObject) throws JSONException {
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
        zzjg zzjgVarZzf = zzgwVar.zzf(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                zza(jSONObject2, simpleArrayMap2);
            } else if ("image".equals(string)) {
                zza(zzgwVar, jSONObject2, simpleArrayMap);
            } else {
                zzin.zzaK("Unknown custom asset type: " + string);
            }
        }
        return new com.google.android.gms.ads.internal.formats.zzf(jSONObject.getString("custom_template_id"), zzc(simpleArrayMap), simpleArrayMap2, (com.google.android.gms.ads.internal.formats.zza) zzjgVarZzf.get());
    }
}
