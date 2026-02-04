package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class BatchResult implements Result {
    private final Status zzUX;
    private final PendingResult[] zzagc;

    BatchResult(Status status, PendingResult[] pendingResultArr) {
        this.zzUX = status;
        this.zzagc = pendingResultArr;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzUX;
    }

    public final Result take(BatchResultToken batchResultToken) {
        zzx.zzb(batchResultToken.mId < this.zzagc.length, "The result token does not belong to this batch");
        return this.zzagc[batchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
}
