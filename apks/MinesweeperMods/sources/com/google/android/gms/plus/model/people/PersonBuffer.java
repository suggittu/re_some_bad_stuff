package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.internal.model.people.zzk;

/* loaded from: classes2.dex */
public final class PersonBuffer extends AbstractDataBuffer {
    private final zzd zzbgt;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.zzpZ() == null || !dataHolder.zzpZ().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.zzbgt = null;
        } else {
            this.zzbgt = new zzd(dataHolder, PersonEntity.CREATOR);
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public final Person get(int i) {
        return this.zzbgt != null ? (Person) this.zzbgt.get(i) : new zzk(this.zzahi, i);
    }
}
