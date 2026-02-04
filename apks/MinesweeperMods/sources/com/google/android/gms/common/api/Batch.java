package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class Batch extends com.google.android.gms.common.api.internal.zzb {
    private int zzafZ;
    private boolean zzaga;
    private boolean zzagb;
    private final PendingResult[] zzagc;
    private final Object zzpV;

    public final class Builder {
        private GoogleApiClient zzaaj;
        private List zzage = new ArrayList();

        public Builder(GoogleApiClient googleApiClient) {
            this.zzaaj = googleApiClient;
        }

        public final BatchResultToken add(PendingResult pendingResult) {
            BatchResultToken batchResultToken = new BatchResultToken(this.zzage.size());
            this.zzage.add(pendingResult);
            return batchResultToken;
        }

        public final Batch build() {
            return new Batch(this.zzage, this.zzaaj);
        }
    }

    private Batch(List list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzpV = new Object();
        this.zzafZ = list.size();
        this.zzagc = new PendingResult[this.zzafZ];
        if (list.isEmpty()) {
            zza(new BatchResult(Status.zzagC, this.zzagc));
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            PendingResult pendingResult = (PendingResult) list.get(i2);
            this.zzagc[i2] = pendingResult;
            pendingResult.zza(new PendingResult.zza() { // from class: com.google.android.gms.common.api.Batch.1
                @Override // com.google.android.gms.common.api.PendingResult.zza
                public void zzu(Status status) {
                    synchronized (Batch.this.zzpV) {
                        if (Batch.this.isCanceled()) {
                            return;
                        }
                        if (status.isCanceled()) {
                            Batch.this.zzagb = true;
                        } else if (!status.isSuccess()) {
                            Batch.this.zzaga = true;
                        }
                        Batch.zzb(Batch.this);
                        if (Batch.this.zzafZ == 0) {
                            if (Batch.this.zzagb) {
                                Batch.super.cancel();
                            } else {
                                Batch.this.zza(new BatchResult(Batch.this.zzaga ? new Status(13) : Status.zzagC, Batch.this.zzagc));
                            }
                        }
                    }
                }
            });
            i = i2 + 1;
        }
    }

    static /* synthetic */ int zzb(Batch batch) {
        int i = batch.zzafZ;
        batch.zzafZ = i - 1;
        return i;
    }

    @Override // com.google.android.gms.common.api.internal.zzb, com.google.android.gms.common.api.PendingResult
    public final void cancel() {
        super.cancel();
        for (PendingResult pendingResult : this.zzagc) {
            pendingResult.cancel();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzb
    /* renamed from: createFailedResult, reason: merged with bridge method [inline-methods] */
    public final BatchResult zzc(Status status) {
        return new BatchResult(status, this.zzagc);
    }
}
