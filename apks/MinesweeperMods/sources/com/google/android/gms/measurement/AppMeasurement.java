package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzw;

/* loaded from: classes2.dex */
public class AppMeasurement {
    private final zzw zzaTV;

    public interface zza {
        @WorkerThread
        void zza(String str, String str2, Bundle bundle, long j);
    }

    public AppMeasurement(zzw zzwVar) {
        zzx.zzz(zzwVar);
        this.zzaTV = zzwVar;
    }

    public static AppMeasurement getInstance(Context context) {
        return zzw.zzaT(context).zzCV();
    }

    public void setMeasurementEnabled(boolean z) {
        this.zzaTV.zzCf().setMeasurementEnabled(z);
    }

    public void zzd(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzaTV.zzCf().zze(str, str2, bundle);
    }
}
