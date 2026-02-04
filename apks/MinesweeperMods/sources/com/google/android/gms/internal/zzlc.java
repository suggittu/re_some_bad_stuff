package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;

/* loaded from: classes2.dex */
abstract class zzlc extends zza.AbstractC0036zza {
    public zzlc(GoogleApiClient googleApiClient) {
        super(Auth.zzVt, googleApiClient);
    }

    protected abstract void zza(Context context, zzlb zzlbVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
    public final void zza(zzkz zzkzVar) {
        zza(zzkzVar.getContext(), (zzlb) zzkzVar.zzqJ());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzb
    /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public ProxyApi.ProxyResult zzc(Status status) {
        return new zzle(status);
    }
}
