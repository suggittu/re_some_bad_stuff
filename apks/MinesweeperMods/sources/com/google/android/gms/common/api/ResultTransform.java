package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.internal.zzt;

/* loaded from: classes2.dex */
public abstract class ResultTransform {
    @NonNull
    public final PendingResult createFailedResult(@NonNull Status status) {
        return new zzt(status);
    }

    @NonNull
    public Status onFailure(@NonNull Status status) {
        return status;
    }

    @WorkerThread
    @Nullable
    public abstract PendingResult onSuccess(@NonNull Result result);
}
