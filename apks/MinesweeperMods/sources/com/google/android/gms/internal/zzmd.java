package com.google.android.gms.internal;

import android.support.v4.util.LruCache;

/* loaded from: classes2.dex */
public final class zzmd extends LruCache {

    public final class zza {
        public final int zzakx;
        public final int zzaky;

        public zza(int i, int i2) {
            this.zzakx = i;
            this.zzaky = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zza zzaVar = (zza) obj;
            return zzaVar.zzakx == this.zzakx && zzaVar.zzaky == this.zzaky;
        }

        public final int hashCode() {
            return com.google.android.gms.common.internal.zzw.hashCode(Integer.valueOf(this.zzakx), Integer.valueOf(this.zzaky));
        }
    }

    public zzmd() {
        super(10);
    }
}
