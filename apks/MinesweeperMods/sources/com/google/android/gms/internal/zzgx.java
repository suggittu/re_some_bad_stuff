package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.internal.zzgw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
/* loaded from: classes2.dex */
public class zzgx implements zzgw.zza {
    private final boolean zzHc;
    private final boolean zzHd;

    public zzgx(boolean z, boolean z2) {
        this.zzHc = z;
        this.zzHd = z2;
    }

    @Override // com.google.android.gms.internal.zzgw.zza
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.ads.internal.formats.zzd zza(zzgw zzgwVar, JSONObject jSONObject) throws JSONException {
        List listZza = zzgwVar.zza(jSONObject, "images", true, this.zzHc, this.zzHd);
        zzjg zzjgVarZza = zzgwVar.zza(jSONObject, "app_icon", true, this.zzHc);
        zzjg zzjgVarZzf = zzgwVar.zzf(jSONObject);
        ArrayList arrayList = new ArrayList();
        Iterator it = listZza.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzjg) it.next()).get());
        }
        return new com.google.android.gms.ads.internal.formats.zzd(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (zzch) zzjgVarZza.get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"), (com.google.android.gms.ads.internal.formats.zza) zzjgVarZzf.get(), new Bundle());
    }
}
