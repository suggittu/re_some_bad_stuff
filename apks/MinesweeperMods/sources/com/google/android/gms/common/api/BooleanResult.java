package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public class BooleanResult implements Result {
    private final Status zzUX;
    private final boolean zzagf;

    public BooleanResult(Status status, boolean z) {
        this.zzUX = (Status) zzx.zzb(status, "Status must not be null");
        this.zzagf = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.zzUX.equals(booleanResult.zzUX) && this.zzagf == booleanResult.zzagf;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    public boolean getValue() {
        return this.zzagf;
    }

    public final int hashCode() {
        return (this.zzagf ? 1 : 0) + ((this.zzUX.hashCode() + 527) * 31);
    }
}
