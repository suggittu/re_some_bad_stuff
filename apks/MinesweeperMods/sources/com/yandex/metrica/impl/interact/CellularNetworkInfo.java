package com.yandex.metrica.impl.interact;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.cf;
import com.yandex.metrica.impl.ob.cl;
import com.yandex.metrica.impl.ob.cm;
import com.yandex.metrica.impl.ob.cn;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class CellularNetworkInfo {
    private String a = "";

    public CellularNetworkInfo(Context context) {
        cl.a(context).a(new cn() { // from class: com.yandex.metrica.impl.interact.CellularNetworkInfo.1
            @Override // com.yandex.metrica.impl.ob.cn
            public void a(cm cmVar) {
                String str;
                cf cfVarB = cmVar.b();
                String strG = cfVarB.g();
                String strF = cfVarB.f();
                Integer numC = cfVarB.c();
                Integer numB = cfVarB.b();
                Integer numE = cfVarB.e();
                Integer numD = cfVarB.d();
                Integer numA = cfVarB.a();
                HashMap map = new HashMap();
                map.put("network_type", strG);
                map.put("operator_name", strF);
                map.put("country_code", numB != null ? String.valueOf(numB) : null);
                map.put("operator_id", numC != null ? String.valueOf(numC) : null);
                map.put("cell_id", numE != null ? String.valueOf(numE) : null);
                map.put("lac", numD != null ? String.valueOf(numD) : null);
                map.put("signal_strength", numA != null ? String.valueOf(numA) : null);
                StringBuilder sb = new StringBuilder();
                String str2 = "";
                for (Map.Entry entry : map.entrySet()) {
                    String str3 = (String) entry.getValue();
                    if (TextUtils.isEmpty(str3)) {
                        str = str2;
                    } else {
                        sb.append(str2);
                        sb.append((String) entry.getKey());
                        sb.append("=");
                        sb.append(str3);
                        str = "&";
                    }
                    str2 = str;
                }
                CellularNetworkInfo.this.a = sb.toString();
            }
        });
    }

    public String getCelluralInfo() {
        return this.a;
    }
}
