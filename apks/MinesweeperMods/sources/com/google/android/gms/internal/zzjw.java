package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzhb
@TargetApi(11)
/* loaded from: classes2.dex */
public class zzjw extends zzjq {
    public zzjw(zzjp zzjpVar, boolean z) {
        super(zzjpVar, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (!(webView instanceof zzjp)) {
                zzin.zzaK("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView, str);
            }
            zzjp zzjpVar = (zzjp) webView;
            zzjpVar.zzhU().zzfo();
            String str2 = zzjpVar.zzaN().zzui ? (String) zzbt.zzwf.get() : zzjpVar.zzhY() ? (String) zzbt.zzwe.get() : (String) zzbt.zzwd.get();
            zzin.v("shouldInterceptRequest(" + str2 + ")");
            return zzd(zzjpVar.getContext(), this.zzpD.zzhX().afmaVersion, str2);
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            zzin.zzaK("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, str);
        }
    }

    protected WebResourceResponse zzd(Context context, String str, String str2) {
        HashMap map = new HashMap();
        map.put("User-Agent", com.google.android.gms.ads.internal.zzr.zzbC().zze(context, str));
        map.put("Cache-Control", "max-stale=3600");
        String str3 = (String) new zziw(context).zzb(str2, map).get(60L, TimeUnit.SECONDS);
        if (str3 == null) {
            return null;
        }
        return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
    }
}
