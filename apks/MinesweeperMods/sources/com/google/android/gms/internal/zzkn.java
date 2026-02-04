package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public class zzkn implements AppInviteInvitationResult {
    private final Status zzUX;
    private final Intent zzUY;

    public zzkn(Status status, Intent intent) {
        this.zzUX = status;
        this.zzUY = intent;
    }

    @Override // com.google.android.gms.appinvite.AppInviteInvitationResult
    public Intent getInvitationIntent() {
        return this.zzUY;
    }

    @Override // com.google.android.gms.appinvite.AppInviteInvitationResult, com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }
}
