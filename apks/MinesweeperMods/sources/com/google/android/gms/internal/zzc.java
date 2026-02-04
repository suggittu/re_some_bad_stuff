package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.internal.zzb;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public class zzc extends Thread {
    private static final boolean DEBUG = zzs.DEBUG;
    private final BlockingQueue zzh;
    private final BlockingQueue zzi;
    private final zzb zzj;
    private final zzn zzk;
    private volatile boolean zzl = false;

    public zzc(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzb zzbVar, zzn zznVar) {
        this.zzh = blockingQueue;
        this.zzi = blockingQueue2;
        this.zzj = zzbVar;
        this.zzk = zznVar;
    }

    public void quit() {
        this.zzl = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException, SecurityException, IllegalArgumentException {
        if (DEBUG) {
            zzs.zza("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzj.zza();
        while (true) {
            try {
                final zzk zzkVar = (zzk) this.zzh.take();
                zzkVar.zzc("cache-queue-take");
                if (zzkVar.isCanceled()) {
                    zzkVar.zzd("cache-discard-canceled");
                } else {
                    zzb.zza zzaVarZza = this.zzj.zza(zzkVar.zzh());
                    if (zzaVarZza == null) {
                        zzkVar.zzc("cache-miss");
                        this.zzi.put(zzkVar);
                    } else if (zzaVarZza.zzb()) {
                        zzkVar.zzc("cache-hit-expired");
                        zzkVar.zza(zzaVarZza);
                        this.zzi.put(zzkVar);
                    } else {
                        zzkVar.zzc("cache-hit");
                        zzm zzmVarZza = zzkVar.zza(new zzi(zzaVarZza.data, zzaVarZza.zzg));
                        zzkVar.zzc("cache-hit-parsed");
                        if (zzaVarZza.zzc()) {
                            zzkVar.zzc("cache-hit-refresh-needed");
                            zzkVar.zza(zzaVarZza);
                            zzmVarZza.zzai = true;
                            this.zzk.zza(zzkVar, zzmVarZza, new Runnable() { // from class: com.google.android.gms.internal.zzc.1
                                @Override // java.lang.Runnable
                                public void run() throws InterruptedException {
                                    try {
                                        zzc.this.zzi.put(zzkVar);
                                    } catch (InterruptedException e) {
                                    }
                                }
                            });
                        } else {
                            this.zzk.zza(zzkVar, zzmVarZza);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.zzl) {
                    return;
                }
            }
        }
    }
}
