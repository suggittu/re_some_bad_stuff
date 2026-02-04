package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
/* loaded from: classes2.dex */
public final class zzg extends zzgg.zza implements ServiceConnection {
    private Context mContext;
    zzb zzFC;
    private String zzFI;
    private zzf zzFM;
    private boolean zzFS;
    private int zzFT;
    private Intent zzFU;

    public zzg(Context context, String str, boolean z, int i, Intent intent, zzf zzfVar) {
        this.zzFS = false;
        this.zzFI = str;
        this.zzFT = i;
        this.zzFU = intent;
        this.zzFS = z;
        this.mContext = context;
        this.zzFM = zzfVar;
    }

    @Override // com.google.android.gms.internal.zzgg
    public final void finishPurchase() {
        int iZzd = zzr.zzbM().zzd(this.zzFU);
        if (this.zzFT == -1 && iZzd == 0) {
            this.zzFC = new zzb(this.mContext);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            com.google.android.gms.common.stats.zzb.zzrP().zza(this.mContext, intent, this, 1);
        }
    }

    @Override // com.google.android.gms.internal.zzgg
    public final String getProductId() {
        return this.zzFI;
    }

    @Override // com.google.android.gms.internal.zzgg
    public final Intent getPurchaseData() {
        return this.zzFU;
    }

    @Override // com.google.android.gms.internal.zzgg
    public final int getResultCode() {
        return this.zzFT;
    }

    @Override // com.google.android.gms.internal.zzgg
    public final boolean isVerified() {
        return this.zzFS;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzin.zzaJ("In-app billing service connected.");
        this.zzFC.zzN(iBinder);
        String strZzar = zzr.zzbM().zzar(zzr.zzbM().zze(this.zzFU));
        if (strZzar == null) {
            return;
        }
        if (this.zzFC.zzh(this.mContext.getPackageName(), strZzar) == 0) {
            zzh.zzy(this.mContext).zza(this.zzFM);
        }
        com.google.android.gms.common.stats.zzb.zzrP().zza(this.mContext, this);
        this.zzFC.destroy();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzin.zzaJ("In-app billing service disconnected.");
        this.zzFC.destroy();
    }
}
