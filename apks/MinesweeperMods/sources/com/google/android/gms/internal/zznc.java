package com.google.android.gms.internal;

import java.util.HashMap;

/* loaded from: classes2.dex */
public class zznc {
    public static void zza(StringBuilder sb, HashMap map) {
        boolean z;
        sb.append("{");
        boolean z2 = true;
        for (String str : map.keySet()) {
            if (z2) {
                z = false;
            } else {
                sb.append(",");
                z = z2;
            }
            String str2 = (String) map.get(str);
            sb.append("\"").append(str).append("\":");
            if (str2 == null) {
                sb.append("null");
                z2 = z;
            } else {
                sb.append("\"").append(str2).append("\"");
                z2 = z;
            }
        }
        sb.append("}");
    }
}
