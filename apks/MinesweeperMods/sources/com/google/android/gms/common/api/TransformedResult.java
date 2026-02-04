package com.google.android.gms.common.api;

import android.support.annotation.NonNull;

/* loaded from: classes2.dex */
public abstract class TransformedResult {
    public abstract void andFinally(@NonNull ResultCallbacks resultCallbacks);

    @NonNull
    public abstract TransformedResult then(@NonNull ResultTransform resultTransform);
}
