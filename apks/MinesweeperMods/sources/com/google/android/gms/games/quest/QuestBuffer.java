package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

/* loaded from: classes2.dex */
public final class QuestBuffer extends zzf {
    public QuestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected final String zzqg() {
        return "external_quest_id";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* renamed from: zzt, reason: merged with bridge method [inline-methods] */
    public final Quest zzk(int i, int i2) {
        return new QuestRef(this.zzahi, i, i2);
    }
}
