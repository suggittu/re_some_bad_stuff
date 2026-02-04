package com.google.android.gms.fitness.service;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.zzk;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class zzb implements SensorEventDispatcher {
    private final zzk zzaBh;

    zzb(zzk zzkVar) {
        this.zzaBh = (zzk) zzx.zzz(zzkVar);
    }

    @Override // com.google.android.gms.fitness.service.SensorEventDispatcher
    public void publish(DataPoint dataPoint) {
        dataPoint.zzui();
        this.zzaBh.zzc(dataPoint);
    }

    @Override // com.google.android.gms.fitness.service.SensorEventDispatcher
    public void publish(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            publish((DataPoint) it.next());
        }
    }
}
