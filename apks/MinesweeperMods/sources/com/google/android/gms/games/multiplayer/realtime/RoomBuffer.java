package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

/* loaded from: classes2.dex */
public final class RoomBuffer extends zzf {
    public RoomBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected final String zzqg() {
        return "external_match_id";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* renamed from: zzr, reason: merged with bridge method [inline-methods] */
    public final Room zzk(int i, int i2) {
        return new RoomRef(this.zzahi, i, i2);
    }
}
