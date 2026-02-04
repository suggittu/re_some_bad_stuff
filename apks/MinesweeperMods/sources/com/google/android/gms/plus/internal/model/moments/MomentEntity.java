package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class MomentEntity extends FastSafeParcelableJsonResponse implements Moment {
    public static final zzb CREATOR = new zzb();
    private static final HashMap zzbeM;
    final int mVersionCode;
    String zzJN;
    final Set zzbeN;
    String zzbfA;
    ItemScopeEntity zzbfI;
    ItemScopeEntity zzbfJ;
    String zzyv;

    static {
        HashMap map = new HashMap();
        zzbeM = map;
        map.put("id", FastJsonResponse.Field.zzl("id", 2));
        zzbeM.put("result", FastJsonResponse.Field.zza("result", 4, ItemScopeEntity.class));
        zzbeM.put("startDate", FastJsonResponse.Field.zzl("startDate", 5));
        zzbeM.put("target", FastJsonResponse.Field.zza("target", 6, ItemScopeEntity.class));
        zzbeM.put("type", FastJsonResponse.Field.zzl("type", 7));
    }

    public MomentEntity() {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
    }

    MomentEntity(Set set, int i, String str, ItemScopeEntity itemScopeEntity, String str2, ItemScopeEntity itemScopeEntity2, String str3) {
        this.zzbeN = set;
        this.mVersionCode = i;
        this.zzyv = str;
        this.zzbfI = itemScopeEntity;
        this.zzbfA = str2;
        this.zzbfJ = itemScopeEntity2;
        this.zzJN = str3;
    }

    public MomentEntity(Set set, String str, ItemScopeEntity itemScopeEntity, String str2, ItemScopeEntity itemScopeEntity2, String str3) {
        this.zzbeN = set;
        this.mVersionCode = 1;
        this.zzyv = str;
        this.zzbfI = itemScopeEntity;
        this.zzbfA = str2;
        this.zzbfJ = itemScopeEntity2;
        this.zzJN = str3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof MomentEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MomentEntity momentEntity = (MomentEntity) obj;
        for (FastJsonResponse.Field field : zzbeM.values()) {
            if (zza(field)) {
                if (momentEntity.zza(field) && zzb(field).equals(momentEntity.zzb(field))) {
                }
                return false;
            }
            if (momentEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final String getId() {
        return this.zzyv;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final ItemScope getResult() {
        return this.zzbfI;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final String getStartDate() {
        return this.zzbfA;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final ItemScope getTarget() {
        return this.zzbfJ;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final String getType() {
        return this.zzJN;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final boolean hasId() {
        return this.zzbeN.contains(2);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final boolean hasResult() {
        return this.zzbeN.contains(4);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final boolean hasStartDate() {
        return this.zzbeN.contains(5);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final boolean hasTarget() {
        return this.zzbeN.contains(6);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public final boolean hasType() {
        return this.zzbeN.contains(7);
    }

    public final int hashCode() {
        int iHashCode = 0;
        Iterator it = zzbeM.values().iterator();
        while (true) {
            int i = iHashCode;
            if (!it.hasNext()) {
                return i;
            }
            FastJsonResponse.Field field = (FastJsonResponse.Field) it.next();
            if (zza(field)) {
                iHashCode = zzb(field).hashCode() + i + field.zzrs();
            } else {
                iHashCode = i;
            }
        }
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb zzbVar = CREATOR;
        zzb.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: zzFl, reason: merged with bridge method [inline-methods] */
    public final HashMap zzrl() {
        return zzbeM;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzFn, reason: merged with bridge method [inline-methods] */
    public final MomentEntity freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final boolean zza(FastJsonResponse.Field field) {
        return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final Object zzb(FastJsonResponse.Field field) {
        switch (field.zzrs()) {
            case 2:
                return this.zzyv;
            case 3:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            case 4:
                return this.zzbfI;
            case 5:
                return this.zzbfA;
            case 6:
                return this.zzbfJ;
            case 7:
                return this.zzJN;
        }
    }
}
