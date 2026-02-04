package com.google.android.gms.internal;

import com.google.android.gms.plus.PlusShare;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzhb
/* loaded from: classes2.dex */
class zzhi {
    private final String zzEY;
    private String zzF;
    private int zzGu;
    private final List zzJI;
    private final List zzJJ;
    private final String zzJK;
    private final String zzJL;
    private final String zzJM;
    private final String zzJN;
    private final boolean zzJO;
    private final boolean zzJP;

    public zzhi(int i, Map map) {
        this.zzF = (String) map.get(PlusShare.KEY_CALL_TO_ACTION_URL);
        this.zzJL = (String) map.get("base_uri");
        this.zzJM = (String) map.get("post_parameters");
        this.zzJO = parseBoolean((String) map.get("drt_include"));
        this.zzJP = parseBoolean((String) map.get("pan_include"));
        this.zzJK = (String) map.get("activation_overlay_url");
        this.zzJJ = zzav((String) map.get("check_packages"));
        this.zzEY = (String) map.get("request_id");
        this.zzJN = (String) map.get("type");
        this.zzJI = zzav((String) map.get("errors"));
        this.zzGu = i;
    }

    private static boolean parseBoolean(String str) {
        return str != null && (str.equals("1") || str.equals("true"));
    }

    private List zzav(String str) {
        if (str == null) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    public int getErrorCode() {
        return this.zzGu;
    }

    public String getRequestId() {
        return this.zzEY;
    }

    public String getType() {
        return this.zzJN;
    }

    public String getUrl() {
        return this.zzF;
    }

    public void setUrl(String str) {
        this.zzF = str;
    }

    public List zzgE() {
        return this.zzJI;
    }

    public String zzgF() {
        return this.zzJM;
    }

    public boolean zzgG() {
        return this.zzJO;
    }

    public boolean zzgH() {
        return this.zzJP;
    }
}
