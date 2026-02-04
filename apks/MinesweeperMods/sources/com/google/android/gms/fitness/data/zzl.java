package com.google.android.gms.fitness.data;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.request.OnDataPointListener;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzl extends zzk.zza {
    private final OnDataPointListener zzaxb;

    public class zza {
        private static final zza zzaxc = new zza();
        private final Map zzaxd = new HashMap();

        private zza() {
        }

        public static zza zzuu() {
            return zzaxc;
        }

        public zzl zza(OnDataPointListener onDataPointListener) {
            zzl zzlVar;
            synchronized (this.zzaxd) {
                zzlVar = (zzl) this.zzaxd.get(onDataPointListener);
                if (zzlVar == null) {
                    zzlVar = new zzl(onDataPointListener);
                    this.zzaxd.put(onDataPointListener, zzlVar);
                }
            }
            return zzlVar;
        }

        public zzl zzb(OnDataPointListener onDataPointListener) {
            zzl zzlVar;
            synchronized (this.zzaxd) {
                zzlVar = (zzl) this.zzaxd.get(onDataPointListener);
            }
            return zzlVar;
        }

        public zzl zzc(OnDataPointListener onDataPointListener) {
            zzl zzlVar;
            synchronized (this.zzaxd) {
                zzlVar = (zzl) this.zzaxd.remove(onDataPointListener);
                if (zzlVar == null) {
                    zzlVar = new zzl(onDataPointListener);
                }
            }
            return zzlVar;
        }
    }

    private zzl(OnDataPointListener onDataPointListener) {
        this.zzaxb = (OnDataPointListener) zzx.zzz(onDataPointListener);
    }

    @Override // com.google.android.gms.fitness.data.zzk
    public void zzc(DataPoint dataPoint) {
        this.zzaxb.onDataPoint(dataPoint);
    }
}
