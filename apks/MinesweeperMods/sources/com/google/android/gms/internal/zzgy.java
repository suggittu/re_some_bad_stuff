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
public class zzgy implements zzgw.zza {
    private final boolean zzHc;
    private final boolean zzHd;

    public zzgy(boolean z, boolean z2) {
        this.zzHc = z;
        this.zzHd = z2;
    }

    @Override // com.google.android.gms.internal.zzgw.zza
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.ads.internal.formats.zze zza(zzgw zzgwVar, JSONObject jSONObject) throws JSONException {
        List listZza = zzgwVar.zza(jSONObject, "images", true, this.zzHc, this.zzHd);
        zzjg zzjgVarZza = zzgwVar.zza(jSONObject, "secondary_image", false, this.zzHc);
        zzjg zzjgVarZzf = zzgwVar.zzf(jSONObject);
        ArrayList arrayList = new ArrayList();
        Iterator it = listZza.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzjg) it.next()).get());
        }
        return new com.google.android.gms.ads.internal.formats.zze(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (zzch) zzjgVarZza.get(), jSONObject.getString("call_to_action"), jSONObject.getString("advertiser"), (com.google.android.gms.ads.internal.formats.zza) zzjgVarZzf.get(), new Bundle());
    }
}
