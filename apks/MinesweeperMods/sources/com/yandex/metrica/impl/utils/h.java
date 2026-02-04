package com.yandex.metrica.impl.utils;

import android.text.TextUtils;
import com.yandex.metrica.impl.bk;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class h {
    public static String a(Map<String, String> map) {
        if (bk.a((Map) map)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                sb.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static Map<String, String> a(String str) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(",")) {
                int iIndexOf = str2.indexOf(":");
                if (iIndexOf != -1) {
                    String strSubstring = str2.substring(0, iIndexOf);
                    if (!TextUtils.isEmpty(strSubstring)) {
                        map.put(strSubstring, str2.substring(iIndexOf + 1));
                    }
                }
            }
        }
        return map;
    }
}
