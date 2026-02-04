package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
/* loaded from: classes2.dex */
public class zze extends zzge.zza implements ServiceConnection {
    private final Activity mActivity;
    private zzb zzFC;
    zzh zzFD;
    private zzk zzFF;
    private Context zzFK;
    private zzgc zzFL;
    private zzf zzFM;
    private zzj zzFN;
    private String zzFO = null;

    public zze(Activity activity) {
        this.mActivity = activity;
        this.zzFD = zzh.zzy(this.mActivity.getApplicationContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037 A[Catch: RemoteException -> 0x003f, all -> 0x004d, Merged into TryCatch #1 {all -> 0x004d, RemoteException -> 0x003f, blocks: (B:5:0x0006, B:7:0x0011, B:9:0x0016, B:12:0x0021, B:15:0x0037, B:18:0x0040), top: B:23:0x0006 }, TRY_ENTER, TRY_LEAVE] */
    @Override // com.google.android.gms.internal.zzge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r6, int r7, android.content.Intent r8) {
        /*
            r5 = this;
            r4 = 0
            r0 = 1001(0x3e9, float:1.403E-42)
            if (r6 != r0) goto L36
            r0 = 0
            com.google.android.gms.ads.internal.purchase.zzi r1 = com.google.android.gms.ads.internal.zzr.zzbM()     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            int r1 = r1.zzd(r8)     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            r2 = -1
            if (r7 != r2) goto L37
            com.google.android.gms.ads.internal.zzr.zzbM()     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            if (r1 != 0) goto L37
            com.google.android.gms.ads.internal.purchase.zzk r2 = r5.zzFF     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            java.lang.String r3 = r5.zzFO     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            boolean r2 = r2.zza(r3, r7, r8)     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            if (r2 == 0) goto L21
            r0 = 1
        L21:
            com.google.android.gms.internal.zzgc r2 = r5.zzFL     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            r2.recordPlayBillingResolution(r1)     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            android.app.Activity r1 = r5.mActivity     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            r1.finish()     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            com.google.android.gms.internal.zzgc r1 = r5.zzFL     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            java.lang.String r1 = r1.getProductId()     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            r5.zza(r1, r0, r7, r8)     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            r5.zzFO = r4
        L36:
            return
        L37:
            com.google.android.gms.ads.internal.purchase.zzh r2 = r5.zzFD     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            com.google.android.gms.ads.internal.purchase.zzf r3 = r5.zzFM     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            r2.zza(r3)     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L4d
            goto L21
        L3f:
            r0 = move-exception
            java.lang.String r0 = "Fail to process purchase result."
            com.google.android.gms.internal.zzin.zzaK(r0)     // Catch: java.lang.Throwable -> L4d
            android.app.Activity r0 = r5.mActivity     // Catch: java.lang.Throwable -> L4d
            r0.finish()     // Catch: java.lang.Throwable -> L4d
            r5.zzFO = r4
            goto L36
        L4d:
            r0 = move-exception
            r5.zzFO = r4
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zze.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // com.google.android.gms.internal.zzge
    public void onCreate() {
        GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcelZzc = GInAppPurchaseManagerInfoParcel.zzc(this.mActivity.getIntent());
        this.zzFN = gInAppPurchaseManagerInfoParcelZzc.zzFy;
        this.zzFF = gInAppPurchaseManagerInfoParcelZzc.zzrI;
        this.zzFL = gInAppPurchaseManagerInfoParcelZzc.zzFw;
        this.zzFC = new zzb(this.mActivity.getApplicationContext());
        this.zzFK = gInAppPurchaseManagerInfoParcelZzc.zzFx;
        if (this.mActivity.getResources().getConfiguration().orientation == 2) {
            this.mActivity.setRequestedOrientation(zzr.zzbE().zzhv());
        } else {
            this.mActivity.setRequestedOrientation(zzr.zzbE().zzhw());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        this.mActivity.bindService(intent, this, 1);
    }

    @Override // com.google.android.gms.internal.zzge
    public void onDestroy() {
        this.mActivity.unbindService(this);
        this.zzFC.destroy();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws IntentSender.SendIntentException {
        this.zzFC.zzN(iBinder);
        try {
            this.zzFO = this.zzFF.zzfZ();
            Bundle bundleZzb = this.zzFC.zzb(this.mActivity.getPackageName(), this.zzFL.getProductId(), this.zzFO);
            PendingIntent pendingIntent = (PendingIntent) bundleZzb.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int iZzd = zzr.zzbM().zzd(bundleZzb);
                this.zzFL.recordPlayBillingResolution(iZzd);
                zza(this.zzFL.getProductId(), false, iZzd, null);
                this.mActivity.finish();
            } else {
                this.zzFM = new zzf(this.zzFL.getProductId(), this.zzFO);
                this.zzFD.zzb(this.zzFM);
                Integer num = 0;
                Integer num2 = 0;
                Integer num3 = 0;
                this.mActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), num.intValue(), num2.intValue(), num3.intValue());
            }
        } catch (IntentSender.SendIntentException | RemoteException e) {
            zzin.zzd("Error when connecting in-app billing service", e);
            this.mActivity.finish();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        zzin.zzaJ("In-app billing service disconnected.");
        this.zzFC.destroy();
    }

    protected void zza(String str, boolean z, int i, Intent intent) {
        if (this.zzFN != null) {
            this.zzFN.zza(str, z, i, intent, this.zzFM);
        }
    }
}
