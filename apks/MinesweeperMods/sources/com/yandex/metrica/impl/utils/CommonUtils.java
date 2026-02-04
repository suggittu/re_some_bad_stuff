package com.yandex.metrica.impl.utils;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class CommonUtils {
    public static <T> Collection<T> emptyIfNull(Collection<T> iterable) {
        return iterable == null ? Collections.emptyList() : iterable;
    }

    public static <T> T[] emptyIfNull(T[] tArr) {
        return tArr == null ? (T[]) new Object[0] : tArr;
    }

    public static String convertListToSpaceDelimitedString(List<String> listOfStrings) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (listOfStrings != null) {
            String str2 = "";
            for (String str3 : listOfStrings) {
                if (TextUtils.isEmpty(str3)) {
                    str = str2;
                } else {
                    sb.append(str2);
                    sb.append(str3);
                    str = " ";
                }
                str2 = str;
            }
        }
        return sb.toString();
    }
}
