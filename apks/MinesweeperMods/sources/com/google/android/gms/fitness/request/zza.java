package com.google.android.gms.fitness.request;

import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.zzq;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class zza extends zzq.zza {
    private final BleScanCallback zzaAy;

    /* renamed from: com.google.android.gms.fitness.request.zza$zza, reason: collision with other inner class name */
    public class C0068zza {
        private static final C0068zza zzaAz = new C0068zza();
        private final Map zzaAA = new HashMap();

        private C0068zza() {
        }

        public static C0068zza zzuJ() {
            return zzaAz;
        }

        public zza zza(BleScanCallback bleScanCallback) {
            zza zzaVar;
            synchronized (this.zzaAA) {
                zzaVar = (zza) this.zzaAA.get(bleScanCallback);
                if (zzaVar == null) {
                    zzaVar = new zza(bleScanCallback);
                    this.zzaAA.put(bleScanCallback, zzaVar);
                }
            }
            return zzaVar;
        }

        public zza zzb(BleScanCallback bleScanCallback) {
            zza zzaVar;
            synchronized (this.zzaAA) {
                zzaVar = (zza) this.zzaAA.get(bleScanCallback);
                if (zzaVar == null) {
                    zzaVar = new zza(bleScanCallback);
                }
            }
            return zzaVar;
        }
    }

    private zza(BleScanCallback bleScanCallback) {
        this.zzaAy = (BleScanCallback) com.google.android.gms.common.internal.zzx.zzz(bleScanCallback);
    }

    @Override // com.google.android.gms.fitness.request.zzq
    public void onDeviceFound(BleDevice bleDevice) {
        this.zzaAy.onDeviceFound(bleDevice);
    }

    @Override // com.google.android.gms.fitness.request.zzq
    public void onScanStopped() {
        this.zzaAy.onScanStopped();
    }
}
