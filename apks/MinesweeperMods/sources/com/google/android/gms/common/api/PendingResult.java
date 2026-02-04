package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class PendingResult {

    public interface zza {
        void zzu(Status status);
    }

    @NonNull
    public abstract Result await();

    @NonNull
    public abstract Result await(long j, @NonNull TimeUnit timeUnit);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(@NonNull ResultCallback resultCallback);

    public abstract void setResultCallback(@NonNull ResultCallback resultCallback, long j, @NonNull TimeUnit timeUnit);

    @NonNull
    public TransformedResult then(@NonNull ResultTransform resultTransform) {
        throw new UnsupportedOperationException();
    }

    public void zza(@NonNull zza zzaVar) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    public Integer zzpa() {
        throw new UnsupportedOperationException();
    }
}
