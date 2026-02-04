package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.internal.zzhn;
import com.google.android.gms.plus.PlusShare;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
/* loaded from: classes2.dex */
public final class zzhe {
    private static final SimpleDateFormat zzJg = new SimpleDateFormat("yyyyMMdd", Locale.US);

    private static String zzL(int i) {
        return String.format(Locale.US, "#%06x", Integer.valueOf(16777215 & i));
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0235 A[PHI: r18
      0x0235: PHI (r18v3 int) = (r18v2 int), (r18v5 int) binds: [B:45:0x0108, B:50:0x0119] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(android.content.Context r39, com.google.android.gms.ads.internal.request.AdRequestInfoParcel r40, java.lang.String r41) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhe.zza(android.content.Context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel, java.lang.String):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    @Nullable
    private static List zza(@Nullable JSONArray jSONArray, @Nullable List list) {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new LinkedList();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    public static JSONObject zza(Context context, AdRequestInfoParcel adRequestInfoParcel, zzhj zzhjVar, zzhn.zza zzaVar, Location location, zzbm zzbmVar, String str, String str2, List list, Bundle bundle) {
        try {
            HashMap map = new HashMap();
            if (list.size() > 0) {
                map.put("eid", TextUtils.join(",", list));
            }
            if (adRequestInfoParcel.zzHs != null) {
                map.put("ad_pos", adRequestInfoParcel.zzHs);
            }
            zza(map, adRequestInfoParcel.zzHt);
            map.put("format", adRequestInfoParcel.zzrp.zzuh);
            if (adRequestInfoParcel.zzrp.width == -1) {
                map.put("smart_w", "full");
            }
            if (adRequestInfoParcel.zzrp.height == -2) {
                map.put("smart_h", "auto");
            }
            if (adRequestInfoParcel.zzrp.zzul) {
                map.put("fluid", "height");
            }
            if (adRequestInfoParcel.zzrp.zzuj != null) {
                StringBuilder sb = new StringBuilder();
                for (AdSizeParcel adSizeParcel : adRequestInfoParcel.zzrp.zzuj) {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    sb.append(adSizeParcel.width == -1 ? (int) (adSizeParcel.widthPixels / zzhjVar.zzHF) : adSizeParcel.width);
                    sb.append("x");
                    sb.append(adSizeParcel.height == -2 ? (int) (adSizeParcel.heightPixels / zzhjVar.zzHF) : adSizeParcel.height);
                }
                map.put("sz", sb);
            }
            if (adRequestInfoParcel.zzHz != 0) {
                map.put("native_version", Integer.valueOf(adRequestInfoParcel.zzHz));
                if (!adRequestInfoParcel.zzrp.zzum) {
                    map.put("native_templates", adRequestInfoParcel.zzrH);
                    map.put("native_image_orientation", zzc(adRequestInfoParcel.zzrD));
                    if (!adRequestInfoParcel.zzHK.isEmpty()) {
                        map.put("native_custom_templates", adRequestInfoParcel.zzHK);
                    }
                }
            }
            map.put("slotname", adRequestInfoParcel.zzrj);
            map.put("pn", adRequestInfoParcel.applicationInfo.packageName);
            if (adRequestInfoParcel.zzHu != null) {
                map.put("vc", Integer.valueOf(adRequestInfoParcel.zzHu.versionCode));
            }
            map.put("ms", str2);
            map.put("seq_num", adRequestInfoParcel.zzHw);
            map.put("session_id", adRequestInfoParcel.zzHx);
            map.put("js", adRequestInfoParcel.zzrl.afmaVersion);
            zza(map, zzhjVar, zzaVar);
            map.put("platform", Build.MANUFACTURER);
            map.put("submodel", Build.MODEL);
            if (adRequestInfoParcel.zzHt.versionCode >= 2 && adRequestInfoParcel.zzHt.zztK != null) {
                zza(map, adRequestInfoParcel.zzHt.zztK);
            }
            if (adRequestInfoParcel.versionCode >= 2) {
                map.put("quality_signals", adRequestInfoParcel.zzHy);
            }
            if (adRequestInfoParcel.versionCode >= 4 && adRequestInfoParcel.zzHB) {
                map.put("forceHttps", Boolean.valueOf(adRequestInfoParcel.zzHB));
            }
            if (bundle != null) {
                map.put("content_info", bundle);
            }
            if (adRequestInfoParcel.versionCode >= 5) {
                map.put("u_sd", Float.valueOf(adRequestInfoParcel.zzHF));
                map.put("sh", Integer.valueOf(adRequestInfoParcel.zzHE));
                map.put("sw", Integer.valueOf(adRequestInfoParcel.zzHD));
            } else {
                map.put("u_sd", Float.valueOf(zzhjVar.zzHF));
                map.put("sh", Integer.valueOf(zzhjVar.zzHE));
                map.put("sw", Integer.valueOf(zzhjVar.zzHD));
            }
            if (adRequestInfoParcel.versionCode >= 6) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.zzHG)) {
                    try {
                        map.put("view_hierarchy", new JSONObject(adRequestInfoParcel.zzHG));
                    } catch (JSONException e) {
                        zzin.zzd("Problem serializing view hierarchy to JSON", e);
                    }
                }
                map.put("correlation_id", Long.valueOf(adRequestInfoParcel.zzHH));
            }
            if (adRequestInfoParcel.versionCode >= 7) {
                map.put("request_id", adRequestInfoParcel.zzHI);
            }
            if (adRequestInfoParcel.versionCode >= 11 && adRequestInfoParcel.zzHM != null) {
                map.put("capability", adRequestInfoParcel.zzHM.toBundle());
            }
            zza(map, str);
            if (adRequestInfoParcel.versionCode >= 12 && !TextUtils.isEmpty(adRequestInfoParcel.zzHN)) {
                map.put("anchor", adRequestInfoParcel.zzHN);
            }
            if (adRequestInfoParcel.versionCode >= 13) {
                map.put("avol", Float.valueOf(adRequestInfoParcel.zzHO));
            }
            if (adRequestInfoParcel.versionCode >= 14 && adRequestInfoParcel.zzHP > 0) {
                map.put("target_api", Integer.valueOf(adRequestInfoParcel.zzHP));
            }
            if (adRequestInfoParcel.versionCode >= 15) {
                map.put("scroll_index", Integer.valueOf(adRequestInfoParcel.zzHQ == -1 ? -1 : adRequestInfoParcel.zzHQ));
            }
            if (zzin.zzQ(2)) {
                zzin.v("Ad Request JSON: " + com.google.android.gms.ads.internal.zzr.zzbC().zzG(map).toString(2));
            }
            return com.google.android.gms.ads.internal.zzr.zzbC().zzG(map);
        } catch (JSONException e2) {
            zzin.zzaK("Problem serializing ad request to JSON: " + e2.getMessage());
            return null;
        }
    }

    private static void zza(HashMap map, Location location) {
        HashMap map2 = new HashMap();
        Float fValueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long lValueOf = Long.valueOf(location.getTime() * 1000);
        Long lValueOf2 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long lValueOf3 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        map2.put("radius", fValueOf);
        map2.put("lat", lValueOf2);
        map2.put("long", lValueOf3);
        map2.put("time", lValueOf);
        map.put("uule", map2);
    }

    private static void zza(HashMap map, AdRequestParcel adRequestParcel) {
        String strZzhm = zzil.zzhm();
        if (strZzhm != null) {
            map.put("abf", strZzhm);
        }
        if (adRequestParcel.zztC != -1) {
            map.put("cust_age", zzJg.format(new Date(adRequestParcel.zztC)));
        }
        if (adRequestParcel.extras != null) {
            map.put("extras", adRequestParcel.extras);
        }
        if (adRequestParcel.zztD != -1) {
            map.put("cust_gender", Integer.valueOf(adRequestParcel.zztD));
        }
        if (adRequestParcel.zztE != null) {
            map.put("kw", adRequestParcel.zztE);
        }
        if (adRequestParcel.zztG != -1) {
            map.put("tag_for_child_directed_treatment", Integer.valueOf(adRequestParcel.zztG));
        }
        if (adRequestParcel.zztF) {
            map.put("adtest", "on");
        }
        if (adRequestParcel.versionCode >= 2) {
            if (adRequestParcel.zztH) {
                map.put("d_imp_hdr", 1);
            }
            if (!TextUtils.isEmpty(adRequestParcel.zztI)) {
                map.put("ppid", adRequestParcel.zztI);
            }
            if (adRequestParcel.zztJ != null) {
                zza(map, adRequestParcel.zztJ);
            }
        }
        if (adRequestParcel.versionCode >= 3 && adRequestParcel.zztL != null) {
            map.put(PlusShare.KEY_CALL_TO_ACTION_URL, adRequestParcel.zztL);
        }
        if (adRequestParcel.versionCode >= 5) {
            if (adRequestParcel.zztN != null) {
                map.put("custom_targeting", adRequestParcel.zztN);
            }
            if (adRequestParcel.zztO != null) {
                map.put("category_exclusions", adRequestParcel.zztO);
            }
            if (adRequestParcel.zztP != null) {
                map.put("request_agent", adRequestParcel.zztP);
            }
        }
        if (adRequestParcel.versionCode >= 6 && adRequestParcel.zztQ != null) {
            map.put("request_pkg", adRequestParcel.zztQ);
        }
        if (adRequestParcel.versionCode >= 7) {
            map.put("is_designed_for_families", Boolean.valueOf(adRequestParcel.zztR));
        }
    }

    private static void zza(HashMap map, SearchAdRequestParcel searchAdRequestParcel) {
        String str;
        String str2 = null;
        if (Color.alpha(searchAdRequestParcel.zzvd) != 0) {
            map.put("acolor", zzL(searchAdRequestParcel.zzvd));
        }
        if (Color.alpha(searchAdRequestParcel.backgroundColor) != 0) {
            map.put("bgcolor", zzL(searchAdRequestParcel.backgroundColor));
        }
        if (Color.alpha(searchAdRequestParcel.zzve) != 0 && Color.alpha(searchAdRequestParcel.zzvf) != 0) {
            map.put("gradientto", zzL(searchAdRequestParcel.zzve));
            map.put("gradientfrom", zzL(searchAdRequestParcel.zzvf));
        }
        if (Color.alpha(searchAdRequestParcel.zzvg) != 0) {
            map.put("bcolor", zzL(searchAdRequestParcel.zzvg));
        }
        map.put("bthick", Integer.toString(searchAdRequestParcel.zzvh));
        switch (searchAdRequestParcel.zzvi) {
            case 0:
                str = "none";
                break;
            case 1:
                str = "dashed";
                break;
            case 2:
                str = "dotted";
                break;
            case 3:
                str = "solid";
                break;
            default:
                str = null;
                break;
        }
        if (str != null) {
            map.put("btype", str);
        }
        switch (searchAdRequestParcel.zzvj) {
            case 0:
                str2 = "light";
                break;
            case 1:
                str2 = "medium";
                break;
            case 2:
                str2 = "dark";
                break;
        }
        if (str2 != null) {
            map.put("callbuttoncolor", str2);
        }
        if (searchAdRequestParcel.zzvk != null) {
            map.put("channel", searchAdRequestParcel.zzvk);
        }
        if (Color.alpha(searchAdRequestParcel.zzvl) != 0) {
            map.put("dcolor", zzL(searchAdRequestParcel.zzvl));
        }
        if (searchAdRequestParcel.zzvm != null) {
            map.put("font", searchAdRequestParcel.zzvm);
        }
        if (Color.alpha(searchAdRequestParcel.zzvn) != 0) {
            map.put("hcolor", zzL(searchAdRequestParcel.zzvn));
        }
        map.put("headersize", Integer.toString(searchAdRequestParcel.zzvo));
        if (searchAdRequestParcel.zzvp != null) {
            map.put("q", searchAdRequestParcel.zzvp);
        }
    }

    private static void zza(HashMap map, zzhj zzhjVar, zzhn.zza zzaVar) {
        map.put("am", Integer.valueOf(zzhjVar.zzJQ));
        map.put("cog", zzy(zzhjVar.zzJR));
        map.put("coh", zzy(zzhjVar.zzJS));
        if (!TextUtils.isEmpty(zzhjVar.zzJT)) {
            map.put("carrier", zzhjVar.zzJT);
        }
        map.put("gl", zzhjVar.zzJU);
        if (zzhjVar.zzJV) {
            map.put("simulator", 1);
        }
        if (zzhjVar.zzJW) {
            map.put("is_sidewinder", 1);
        }
        map.put("ma", zzy(zzhjVar.zzJX));
        map.put("sp", zzy(zzhjVar.zzJY));
        map.put("hl", zzhjVar.zzJZ);
        if (!TextUtils.isEmpty(zzhjVar.zzKa)) {
            map.put("mv", zzhjVar.zzKa);
        }
        map.put("muv", Integer.valueOf(zzhjVar.zzKb));
        if (zzhjVar.zzKc != -2) {
            map.put("cnt", Integer.valueOf(zzhjVar.zzKc));
        }
        map.put("gnt", Integer.valueOf(zzhjVar.zzKd));
        map.put("pt", Integer.valueOf(zzhjVar.zzKe));
        map.put("rm", Integer.valueOf(zzhjVar.zzKf));
        map.put("riv", Integer.valueOf(zzhjVar.zzKg));
        Bundle bundle = new Bundle();
        bundle.putString("build", zzhjVar.zzKl);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("is_charging", zzhjVar.zzKi);
        bundle2.putDouble("battery_level", zzhjVar.zzKh);
        bundle.putBundle("battery", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putInt("active_network_state", zzhjVar.zzKk);
        bundle3.putBoolean("active_network_metered", zzhjVar.zzKj);
        if (zzaVar != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("predicted_latency_micros", zzaVar.zzKq);
            bundle4.putLong("predicted_down_throughput_bps", zzaVar.zzKr);
            bundle4.putLong("predicted_up_throughput_bps", zzaVar.zzKs);
            bundle3.putBundle("predictions", bundle4);
        }
        bundle.putBundle("network", bundle3);
        map.put("device", bundle);
    }

    private static void zza(HashMap map, String str) {
        if (str != null) {
            HashMap map2 = new HashMap();
            map2.put("token", str);
            map.put("pan", map2);
        }
    }

    private static String zzc(NativeAdOptionsParcel nativeAdOptionsParcel) {
        switch (nativeAdOptionsParcel != null ? nativeAdOptionsParcel.zzyB : 0) {
            case 1:
                return "portrait";
            case 2:
                return "landscape";
            default:
                return "any";
        }
    }

    public static JSONObject zzc(AdResponseParcel adResponseParcel) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (adResponseParcel.zzEF != null) {
            jSONObject.put("ad_base_url", adResponseParcel.zzEF);
        }
        if (adResponseParcel.zzHW != null) {
            jSONObject.put("ad_size", adResponseParcel.zzHW);
        }
        jSONObject.put("native", adResponseParcel.zzuk);
        if (adResponseParcel.zzuk) {
            jSONObject.put("ad_json", adResponseParcel.body);
        } else {
            jSONObject.put("ad_html", adResponseParcel.body);
        }
        if (adResponseParcel.zzHY != null) {
            jSONObject.put("debug_dialog", adResponseParcel.zzHY);
        }
        if (adResponseParcel.zzHS != -1) {
            jSONObject.put("interstitial_timeout", adResponseParcel.zzHS / 1000.0d);
        }
        if (adResponseParcel.orientation == com.google.android.gms.ads.internal.zzr.zzbE().zzhw()) {
            jSONObject.put("orientation", "portrait");
        } else if (adResponseParcel.orientation == com.google.android.gms.ads.internal.zzr.zzbE().zzhv()) {
            jSONObject.put("orientation", "landscape");
        }
        if (adResponseParcel.zzBQ != null) {
            jSONObject.put("click_urls", zzi(adResponseParcel.zzBQ));
        }
        if (adResponseParcel.zzBR != null) {
            jSONObject.put("impression_urls", zzi(adResponseParcel.zzBR));
        }
        if (adResponseParcel.zzHV != null) {
            jSONObject.put("manual_impression_urls", zzi(adResponseParcel.zzHV));
        }
        if (adResponseParcel.zzIb != null) {
            jSONObject.put("active_view", adResponseParcel.zzIb);
        }
        jSONObject.put("ad_is_javascript", adResponseParcel.zzHZ);
        if (adResponseParcel.zzIa != null) {
            jSONObject.put("ad_passback_url", adResponseParcel.zzIa);
        }
        jSONObject.put("mediation", adResponseParcel.zzHT);
        jSONObject.put("custom_render_allowed", adResponseParcel.zzIc);
        jSONObject.put("content_url_opted_out", adResponseParcel.zzId);
        jSONObject.put("prefetch", adResponseParcel.zzIe);
        jSONObject.put("oauth2_token_status", adResponseParcel.zzIf);
        if (adResponseParcel.zzBU != -1) {
            jSONObject.put("refresh_interval_milliseconds", adResponseParcel.zzBU);
        }
        if (adResponseParcel.zzHU != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", adResponseParcel.zzHU);
        }
        if (!TextUtils.isEmpty(adResponseParcel.zzIi)) {
            jSONObject.put("gws_query_id", adResponseParcel.zzIi);
        }
        jSONObject.put("fluid", adResponseParcel.zzul ? "height" : "");
        jSONObject.put("native_express", adResponseParcel.zzum);
        if (adResponseParcel.zzIk != null) {
            jSONObject.put("video_start_urls", zzi(adResponseParcel.zzIk));
        }
        if (adResponseParcel.zzIl != null) {
            jSONObject.put("video_complete_urls", zzi(adResponseParcel.zzIl));
        }
        if (adResponseParcel.zzIj != null) {
            jSONObject.put("rewards", adResponseParcel.zzIj.zzgR());
        }
        jSONObject.put("use_displayed_impression", adResponseParcel.zzIm);
        return jSONObject;
    }

    @Nullable
    static JSONArray zzi(List list) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        return jSONArray;
    }

    private static Integer zzy(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }
}
