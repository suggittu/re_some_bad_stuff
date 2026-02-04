package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzlz;

/* loaded from: classes2.dex */
public final class zzc {
    public static zzlz zzanx = zzlz.zza("gms:common:stats:max_num_of_events", (Integer) 100);
    public static zzlz zzany = zzlz.zza("gms:common:stats:max_chunk_size", (Integer) 100);

    public final class zza {
        public static zzlz zzanz = zzlz.zza("gms:common:stats:connections:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
        public static zzlz zzanA = zzlz.zzv("gms:common:stats:connections:ignored_calling_processes", "");
        public static zzlz zzanB = zzlz.zzv("gms:common:stats:connections:ignored_calling_services", "");
        public static zzlz zzanC = zzlz.zzv("gms:common:stats:connections:ignored_target_processes", "");
        public static zzlz zzanD = zzlz.zzv("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static zzlz zzanE = zzlz.zza("gms:common:stats:connections:time_out_duration", (Long) 600000L);
    }

    public final class zzb {
        public static zzlz zzanz = zzlz.zza("gms:common:stats:wakeLocks:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
        public static zzlz zzanE = zzlz.zza("gms:common:stats:wakelocks:time_out_duration", (Long) 600000L);
    }
}
