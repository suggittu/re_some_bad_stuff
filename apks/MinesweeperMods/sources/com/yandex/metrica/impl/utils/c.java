package com.yandex.metrica.impl.utils;

import android.text.TextUtils;
import com.yandex.metrica.impl.bi;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    public static class a {
        private final int a;
        private final int b;
        private final int c;

        public a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public static a d() {
            return new a(30, 50, 100);
        }
    }

    public boolean a(String str, String str2) {
        return !bi.a(str, str2);
    }

    public Map<String, String> a(Map<String, String> map, String str, String str2, a aVar, String str3) {
        if (map != null) {
            String strA = a(str, aVar.b(), str3);
            String strA2 = a(str2, aVar.c(), str3);
            if (map.size() >= aVar.a() && !map.containsKey(strA)) {
                b(strA, aVar.a(), str3);
            } else {
                map.put(strA, strA2);
            }
        }
        return map;
    }

    public String a(String str, int i, String str2) {
        if (str != null && str.length() > i) {
            String strSubstring = str.substring(0, i);
            f.e().b("\"%s\"'s parameter %s size exceeded limit of %d characters", str2, str, Integer.valueOf(i));
            return strSubstring;
        }
        return str;
    }

    public String a(String str, int i) throws UnsupportedEncodingException {
        if (!TextUtils.isEmpty(str)) {
            try {
                byte[] bytes = str.getBytes("UTF-8");
                if (bytes.length > i) {
                    return new String(bytes, 0, i);
                }
                return str;
            } catch (UnsupportedEncodingException e) {
                return str;
            }
        }
        return str;
    }

    public byte[] a(byte[] bArr, int i) {
        if (bArr.length > i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }
        return bArr;
    }

    public void b(String str, int i, String str2) {
        f.e().b("The %s has reached the limit of %d items. Item with key %s will be ignored", str2, Integer.valueOf(i), str);
    }
}
