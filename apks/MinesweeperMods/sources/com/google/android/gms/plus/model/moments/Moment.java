package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public interface Moment extends Freezable {

    public class Builder {
        private String zzJN;
        private final Set zzbeN = new HashSet();
        private String zzbfA;
        private ItemScopeEntity zzbfI;
        private ItemScopeEntity zzbfJ;
        private String zzyv;

        public Moment build() {
            return new MomentEntity(this.zzbeN, this.zzyv, this.zzbfI, this.zzbfA, this.zzbfJ, this.zzJN);
        }

        public Builder setId(String str) {
            this.zzyv = str;
            this.zzbeN.add(2);
            return this;
        }

        public Builder setResult(ItemScope itemScope) {
            this.zzbfI = (ItemScopeEntity) itemScope;
            this.zzbeN.add(4);
            return this;
        }

        public Builder setStartDate(String str) {
            this.zzbfA = str;
            this.zzbeN.add(5);
            return this;
        }

        public Builder setTarget(ItemScope itemScope) {
            this.zzbfJ = (ItemScopeEntity) itemScope;
            this.zzbeN.add(6);
            return this;
        }

        public Builder setType(String str) {
            this.zzJN = str;
            this.zzbeN.add(7);
            return this;
        }
    }

    String getId();

    ItemScope getResult();

    String getStartDate();

    ItemScope getTarget();

    String getType();

    boolean hasId();

    boolean hasResult();

    boolean hasStartDate();

    boolean hasTarget();

    boolean hasType();
}
