package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzhb
/* loaded from: classes2.dex */
public class zzfs {
    private final String zzDJ;
    private final zzjp zzpD;

    public zzfs(zzjp zzjpVar) {
        this(zzjpVar, "");
    }

    public zzfs(zzjp zzjpVar, String str) {
        this.zzpD = zzjpVar;
        this.zzDJ = str;
    }

    public void zza(int i, int i2, int i3, int i4, float f, int i5) throws JSONException {
        try {
            this.zzpD.zzb("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f).put("rotation", i5));
        } catch (JSONException e) {
            zzin.zzb("Error occured while obtaining screen information.", e);
        }
    }

    public void zzam(String str) throws JSONException {
        try {
            this.zzpD.zzb("onError", new JSONObject().put("message", str).put("action", this.zzDJ));
        } catch (JSONException e) {
            zzin.zzb("Error occurred while dispatching error event.", e);
        }
    }

    public void zzan(String str) throws JSONException {
        try {
            this.zzpD.zzb("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzin.zzb("Error occured while dispatching ready Event.", e);
        }
    }

    public void zzao(String str) throws JSONException {
        try {
            this.zzpD.zzb("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzin.zzb("Error occured while dispatching state change.", e);
        }
    }

    public void zzb(int i, int i2, int i3, int i4) throws JSONException {
        try {
            this.zzpD.zzb("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzin.zzb("Error occured while dispatching size change.", e);
        }
    }

    public void zzc(int i, int i2, int i3, int i4) throws JSONException {
        try {
            this.zzpD.zzb("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzin.zzb("Error occured while dispatching default position.", e);
        }
    }
}
