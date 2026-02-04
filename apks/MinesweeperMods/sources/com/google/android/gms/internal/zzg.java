package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public class zzg extends Thread {
    private final zzb zzj;
    private final zzn zzk;
    private volatile boolean zzl = false;
    private final BlockingQueue zzy;
    private final zzf zzz;

    public zzg(BlockingQueue blockingQueue, zzf zzfVar, zzb zzbVar, zzn zznVar) {
        this.zzy = blockingQueue;
        this.zzz = zzfVar;
        this.zzj = zzbVar;
        this.zzk = zznVar;
    }

    @TargetApi(14)
    private void zzb(zzk zzkVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(zzkVar.zzg());
        }
    }

    private void zzb(zzk zzkVar, zzr zzrVar) {
        this.zzk.zza(zzkVar, zzkVar.zzb(zzrVar));
    }

    public void quit() {
        this.zzl = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        while (true) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                zzk zzkVar = (zzk) this.zzy.take();
                try {
                    zzkVar.zzc("network-queue-take");
                    if (zzkVar.isCanceled()) {
                        zzkVar.zzd("network-discard-cancelled");
                    } else {
                        zzb(zzkVar);
                        zzi zziVarZza = this.zzz.zza(zzkVar);
                        zzkVar.zzc("network-http-complete");
                        if (zziVarZza.zzB && zzkVar.zzw()) {
                            zzkVar.zzd("not-modified");
                        } else {
                            zzm zzmVarZza = zzkVar.zza(zziVarZza);
                            zzkVar.zzc("network-parse-complete");
                            if (zzkVar.zzr() && zzmVarZza.zzag != null) {
                                this.zzj.zza(zzkVar.zzh(), zzmVarZza.zzag);
                                zzkVar.zzc("network-cache-written");
                            }
                            zzkVar.zzv();
                            this.zzk.zza(zzkVar, zzmVarZza);
                        }
                    }
                } catch (zzr e) {
                    e.zza(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    zzb(zzkVar, e);
                } catch (Exception e2) {
                    zzs.zza(e2, "Unhandled exception %s", e2.toString());
                    zzr zzrVar = new zzr(e2);
                    zzrVar.zza(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    this.zzk.zza(zzkVar, zzrVar);
                }
            } catch (InterruptedException e3) {
                if (this.zzl) {
                    return;
                }
            }
        }
    }
}
