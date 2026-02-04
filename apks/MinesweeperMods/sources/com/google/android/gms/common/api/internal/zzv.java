package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public class zzv extends zzb {
    @Deprecated
    public zzv(Looper looper) {
        super(looper);
    }

    public zzv(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzb
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public Status zzc(Status status) {
        return status;
    }
}
