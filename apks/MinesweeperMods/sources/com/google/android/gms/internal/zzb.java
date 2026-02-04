package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public interface zzb {

    public class zza {
        public byte[] data;
        public String zzb;
        public long zzc;
        public long zzd;
        public long zze;
        public long zzf;
        public Map zzg = Collections.emptyMap();

        public boolean zzb() {
            return this.zze < System.currentTimeMillis();
        }

        public boolean zzc() {
            return this.zzf < System.currentTimeMillis();
        }
    }

    zza zza(String str);

    void zza();

    void zza(String str, zza zzaVar);
}
