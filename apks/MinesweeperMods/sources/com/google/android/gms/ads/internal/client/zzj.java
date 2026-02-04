package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.internal.zzhb;

@zzhb
/* loaded from: classes2.dex */
public final class zzj extends zzw.zza {
    private final AppEventListener zzun;

    public zzj(AppEventListener appEventListener) {
        this.zzun = appEventListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzw
    public final void onAppEvent(String str, String str2) {
        this.zzun.onAppEvent(str, str2);
    }
}
