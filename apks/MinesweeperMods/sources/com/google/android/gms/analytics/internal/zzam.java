package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.google.android.gms.internal.zzmz;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.search.SearchAuth;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzam {
    private static final char[] zzTu = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String zzK(boolean z) {
        return z ? "1" : "0";
    }

    public static double zza(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return d;
        }
    }

    public static zzpr zza(zzaf zzafVar, String str) {
        com.google.android.gms.common.internal.zzx.zzz(zzafVar);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new HashMap();
        try {
            Map mapZza = zzmz.zza(new URI("?" + str), "UTF-8");
            zzpr zzprVar = new zzpr();
            zzprVar.zzey((String) mapZza.get("utm_content"));
            zzprVar.zzew((String) mapZza.get("utm_medium"));
            zzprVar.setName((String) mapZza.get("utm_campaign"));
            zzprVar.zzev((String) mapZza.get("utm_source"));
            zzprVar.zzex((String) mapZza.get("utm_term"));
            zzprVar.zzez((String) mapZza.get("utm_id"));
            zzprVar.zzeA((String) mapZza.get("anid"));
            zzprVar.zzeB((String) mapZza.get("gclid"));
            zzprVar.zzeC((String) mapZza.get("dclid"));
            zzprVar.zzeD((String) mapZza.get("aclid"));
            return zzprVar;
        } catch (URISyntaxException e) {
            zzafVar.zzd("No valid campaign data found", e);
            return null;
        }
    }

    public static String zza(Locale locale) {
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(language.toLowerCase());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb.append("-").append(locale.getCountry().toLowerCase());
        }
        return sb.toString();
    }

    public static void zza(Map map, String str, Map map2) {
        zzc(map, str, (String) map2.get(str));
    }

    public static boolean zza(double d, String str) {
        return d > 0.0d && d < 100.0d && ((double) (zzbw(str) % SearchAuth.StatusCodes.AUTH_DISABLED)) >= 100.0d * d;
    }

    public static boolean zza(Context context, Class cls) throws PackageManager.NameNotFoundException {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) cls), 4);
            if (serviceInfo != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        return false;
    }

    public static boolean zza(Context context, Class cls, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, (Class<?>) cls), 2);
            if (receiverInfo != null && receiverInfo.enabled) {
                if (z) {
                    if (receiverInfo.exported) {
                    }
                }
                return true;
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        return false;
    }

    public static void zzb(Map map, String str, boolean z) {
        if (map.containsKey(str)) {
            return;
        }
        map.put(str, z ? "1" : "0");
    }

    public static Map zzbs(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("&")) {
            String[] strArrSplit = str2.split("=", 3);
            if (strArrSplit.length > 1) {
                map.put(strArrSplit[0], TextUtils.isEmpty(strArrSplit[1]) ? null : strArrSplit[1]);
                if (strArrSplit.length == 3 && !TextUtils.isEmpty(strArrSplit[1]) && !map.containsKey(strArrSplit[1])) {
                    map.put(strArrSplit[1], TextUtils.isEmpty(strArrSplit[2]) ? null : strArrSplit[2]);
                }
            } else if (strArrSplit.length == 1 && strArrSplit[0].length() != 0) {
                map.put(strArrSplit[0], null);
            }
        }
        return map;
    }

    public static long zzbt(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    public static String zzbu(String str) throws UnsupportedEncodingException {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains("?")) {
            String[] strArrSplit = str.split("[\\?]");
            if (strArrSplit.length > 1) {
                str = strArrSplit[1];
            }
        }
        if (str.contains("%3D")) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else if (!str.contains("=")) {
            return null;
        }
        Map mapZzbs = zzbs(str);
        String[] strArr = {"dclid", "utm_source", "gclid", "aclid", "utm_campaign", "utm_medium", "utm_term", "utm_content", "utm_id", "anid", "gmob_t"};
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return sb.toString();
            }
            if (!TextUtils.isEmpty((CharSequence) mapZzbs.get(strArr[i2]))) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(strArr[i2]).append("=").append((String) mapZzbs.get(strArr[i2]));
            }
            i = i2 + 1;
        }
    }

    public static MessageDigest zzbv(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return null;
            }
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException e) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
            i = i2 + 1;
        }
    }

    public static int zzbw(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char cCharAt = str.charAt(length);
                i = ((i << 6) & 268435455) + cCharAt + (cCharAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    public static boolean zzbx(String str) {
        return TextUtils.isEmpty(str) || !str.startsWith("http:");
    }

    public static void zzc(Map map, String str, String str2) {
        if (str2 == null || map.containsKey(str)) {
            return;
        }
        map.put(str, str2);
    }

    public static void zzd(Map map, String str, String str2) {
        if (str2 == null || !TextUtils.isEmpty((CharSequence) map.get(str))) {
            return;
        }
        map.put(str, str2);
    }

    public static boolean zzh(String str, boolean z) {
        if (str == null) {
            return z;
        }
        if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("1")) {
            return true;
        }
        if (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no") || str.equalsIgnoreCase("0")) {
            return false;
        }
        return z;
    }
}
