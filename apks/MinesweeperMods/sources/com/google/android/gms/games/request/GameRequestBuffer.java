package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

/* loaded from: classes2.dex */
public final class GameRequestBuffer extends zzf {
    public GameRequestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected final String zzqg() {
        return "external_request_id";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public final GameRequest zzk(int i, int i2) {
        return new GameRequestRef(this.zzahi, i, i2);
    }
}
