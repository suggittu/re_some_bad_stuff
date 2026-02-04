package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

/* loaded from: classes2.dex */
public final class InvitationBuffer extends zzf {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public final Invitation zzk(int i, int i2) {
        return new InvitationRef(this.zzahi, i, i2);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected final String zzqg() {
        return "external_invitation_id";
    }
}
