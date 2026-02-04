package com.google.android.gms.fitness.service;

import com.google.android.gms.fitness.data.DataPoint;
import java.util.List;

/* loaded from: classes2.dex */
public interface SensorEventDispatcher {
    void publish(DataPoint dataPoint);

    void publish(List list);
}
