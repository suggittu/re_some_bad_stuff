package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* loaded from: classes2.dex */
public class zzld implements ProxyApi {
    @Override // com.google.android.gms.auth.api.proxy.ProxyApi
    public PendingResult performProxyRequest(GoogleApiClient googleApiClient, final ProxyRequest proxyRequest) {
        com.google.android.gms.common.internal.zzx.zzz(googleApiClient);
        com.google.android.gms.common.internal.zzx.zzz(proxyRequest);
        return googleApiClient.zzb(new zzlc(googleApiClient) { // from class: com.google.android.gms.internal.zzld.1
            @Override // com.google.android.gms.internal.zzlc
            protected void zza(Context context, zzlb zzlbVar) {
                zzlbVar.zza(new zzky() { // from class: com.google.android.gms.internal.zzld.1.1
                    @Override // com.google.android.gms.internal.zzky, com.google.android.gms.internal.zzla
                    public void zza(ProxyResponse proxyResponse) {
                        zza(new zzle(proxyResponse));
                    }
                }, proxyRequest);
            }
        });
    }
}
