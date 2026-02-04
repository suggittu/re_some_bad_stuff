package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

@zzhb
/* loaded from: classes2.dex */
public class zzio extends Handler {
    public zzio(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Exception {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzr.zzbF().zzb((Throwable) e, false);
            throw e;
        }
    }
}
