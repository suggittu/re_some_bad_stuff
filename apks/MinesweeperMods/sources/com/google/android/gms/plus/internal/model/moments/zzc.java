package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

/* loaded from: classes2.dex */
public final class zzc extends com.google.android.gms.common.data.zzc implements Moment {
    private MomentEntity zzbfK;

    public zzc(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private MomentEntity zzFo() {
        synchronized (this) {
            if (this.zzbfK == null) {
                byte[] byteArray = getByteArray("momentImpl");
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.unmarshall(byteArray, 0, byteArray.length);
                parcelObtain.setDataPosition(0);
                this.zzbfK = MomentEntity.CREATOR.createFromParcel(parcelObtain);
                parcelObtain.recycle();
            }
        }
        return this.zzbfK;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final String getId() {
        return zzFo().getId();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final ItemScope getResult() {
        return zzFo().getResult();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final String getStartDate() {
        return zzFo().getStartDate();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final ItemScope getTarget() {
        return zzFo().getTarget();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final String getType() {
        return zzFo().getType();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final boolean hasId() {
        return zzFo().hasId();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final boolean hasResult() {
        return zzFo().hasResult();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final boolean hasStartDate() {
        return zzFo().hasStartDate();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final boolean hasTarget() {
        return zzFo().hasTarget();
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final boolean hasType() {
        return zzFo().hasType();
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzFn, reason: merged with bridge method [inline-methods] */
    public final MomentEntity freeze() {
        return zzFo();
    }
}
