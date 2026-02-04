package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.annotation.Nullable;

/* loaded from: classes2.dex */
abstract class zzn extends BroadcastReceiver {
    protected Context mContext;

    zzn() {
    }

    @Nullable
    public static zzn zza(Context context, zzn zznVar) {
        return zza(context, zznVar, com.google.android.gms.common.zzc.zzoK());
    }

    @Nullable
    public static zzn zza(Context context, zzn zznVar, com.google.android.gms.common.zzc zzcVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(zznVar, intentFilter);
        zznVar.mContext = context;
        if (zzcVar.zzi(context, "com.google.android.gms")) {
            return zznVar;
        }
        zznVar.zzpJ();
        zznVar.unregister();
        return null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            zzpJ();
            unregister();
        }
    }

    public synchronized void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this);
        }
        this.mContext = null;
    }

    protected abstract void zzpJ();
}
