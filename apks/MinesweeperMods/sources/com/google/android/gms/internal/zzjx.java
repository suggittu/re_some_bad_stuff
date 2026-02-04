package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient;

@zzhb
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzjx extends zzjv {
    public zzjx(zzjp zzjpVar) {
        super(zzjpVar);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        zza(view, i, customViewCallback);
    }
}
