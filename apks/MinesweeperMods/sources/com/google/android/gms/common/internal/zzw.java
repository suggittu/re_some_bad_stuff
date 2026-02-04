package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzw {

    public final class zza {
        private final Object zzML;
        private final List zzamp;

        private zza(Object obj) {
            this.zzML = zzx.zzz(obj);
            this.zzamp = new ArrayList();
        }

        public final String toString() {
            StringBuilder sbAppend = new StringBuilder(100).append(this.zzML.getClass().getSimpleName()).append('{');
            int size = this.zzamp.size();
            for (int i = 0; i < size; i++) {
                sbAppend.append((String) this.zzamp.get(i));
                if (i < size - 1) {
                    sbAppend.append(", ");
                }
            }
            return sbAppend.append('}').toString();
        }

        public final zza zzg(String str, Object obj) {
            this.zzamp.add(((String) zzx.zzz(str)) + "=" + String.valueOf(obj));
            return this;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static zza zzy(Object obj) {
        return new zza(obj);
    }
}
