package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@zzhb
/* loaded from: classes2.dex */
public class zzet {
    public List zza(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            arrayList.add(jSONArrayOptJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void zza(Context context, String str, zzif zzifVar, String str2, boolean z, List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String str3 = z ? "1" : "0";
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String strReplaceAll = ((String) it.next()).replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", zzifVar.zzKV.zzBT).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", com.google.android.gms.ads.internal.zzr.zzbF().getSessionId()).replaceAll("@gw_seqnum@", zzifVar.zzHw);
            if (zzifVar.zzCp != null) {
                strReplaceAll = strReplaceAll.replaceAll("@gw_adnetid@", zzifVar.zzCp.zzBA).replaceAll("@gw_allocid@", zzifVar.zzCp.zzBC);
            }
            new zziy(context, str, strReplaceAll).zzgd();
        }
    }
}
