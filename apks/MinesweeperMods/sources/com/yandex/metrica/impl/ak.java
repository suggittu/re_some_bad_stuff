package com.yandex.metrica.impl;

import android.text.TextUtils;
import com.yandex.metrica.PreloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ak {
    private PreloadInfo a;

    public ak(PreloadInfo preloadInfo) {
        if (preloadInfo != null) {
            if (TextUtils.isEmpty(preloadInfo.getTrackingId())) {
                com.yandex.metrica.impl.utils.f.e().c("Required field \"PreloadInfo.trackingId\" is empty!\nThis preload info will be skipped.", new Object[0]);
            } else {
                this.a = preloadInfo;
            }
        }
    }

    String a() throws JSONException {
        if (this.a == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preloadInfo", b());
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public JSONObject b() throws JSONException {
        if (this.a == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackingId", this.a.getTrackingId());
            if (!this.a.getAdditionalParams().isEmpty()) {
                jSONObject.put("additionalParams", new JSONObject(this.a.getAdditionalParams()));
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e) {
            return jSONObject;
        }
    }
}
