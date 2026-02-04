package com.google.android.gms.auth.api.signin;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public class GoogleSignInResult implements Result {
    private Status zzUX;
    private GoogleSignInAccount zzXg;

    public GoogleSignInResult(@Nullable GoogleSignInAccount googleSignInAccount, @NonNull Status status) {
        this.zzXg = googleSignInAccount;
        this.zzUX = status;
    }

    @Nullable
    public GoogleSignInAccount getSignInAccount() {
        return this.zzXg;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.zzUX;
    }

    public boolean isSuccess() {
        return this.zzUX.isSuccess();
    }
}
