package com.google.android.gms.analytics.internal;

import com.google.android.gms.internal.zzlz;

/* loaded from: classes2.dex */
public final class zzy {
    public static zza zzRJ = zza.zzg("analytics.service_enabled", false);
    public static zza zzRK = zza.zzg("analytics.service_client_enabled", true);
    public static zza zzRL = zza.zze("analytics.log_tag", "GAv4", "GAv4-SVC");
    public static zza zzRM = zza.zzb("analytics.max_tokens", 60);
    public static zza zzRN = zza.zza("analytics.tokens_per_sec", 0.5f);
    public static zza zzRO = zza.zza("analytics.max_stored_hits", 2000, 20000);
    public static zza zzRP = zza.zzd("analytics.max_stored_hits_per_app", 2000);
    public static zza zzRQ = zza.zzd("analytics.max_stored_properties_per_app", 100);
    public static zza zzRR = zza.zza("analytics.local_dispatch_millis", 1800000L, 120000L);
    public static zza zzRS = zza.zza("analytics.initial_local_dispatch_millis", 5000L, 5000L);
    public static zza zzRT = zza.zzb("analytics.min_local_dispatch_millis", 120000);
    public static zza zzRU = zza.zzb("analytics.max_local_dispatch_millis", 7200000);
    public static zza zzRV = zza.zzb("analytics.dispatch_alarm_millis", 7200000);
    public static zza zzRW = zza.zzb("analytics.max_dispatch_alarm_millis", 32400000);
    public static zza zzRX = zza.zzd("analytics.max_hits_per_dispatch", 20);
    public static zza zzRY = zza.zzd("analytics.max_hits_per_batch", 20);
    public static zza zzRZ = zza.zzl("analytics.insecure_host", "http://www.google-analytics.com");
    public static zza zzSa = zza.zzl("analytics.secure_host", "https://ssl.google-analytics.com");
    public static zza zzSb = zza.zzl("analytics.simple_endpoint", "/collect");
    public static zza zzSc = zza.zzl("analytics.batching_endpoint", "/batch");
    public static zza zzSd = zza.zzd("analytics.max_get_length", 2036);
    public static zza zzSe = zza.zze("analytics.batching_strategy.k", zzm.BATCH_BY_COUNT.name(), zzm.BATCH_BY_COUNT.name());
    public static zza zzSf = zza.zzl("analytics.compression_strategy.k", zzo.GZIP.name());
    public static zza zzSg = zza.zzd("analytics.max_hits_per_request.k", 20);
    public static zza zzSh = zza.zzd("analytics.max_hit_length.k", 8192);
    public static zza zzSi = zza.zzd("analytics.max_post_length.k", 8192);
    public static zza zzSj = zza.zzd("analytics.max_batch_post_length", 8192);
    public static zza zzSk = zza.zzl("analytics.fallback_responses.k", "404,502");
    public static zza zzSl = zza.zzd("analytics.batch_retry_interval.seconds.k", 3600);
    public static zza zzSm = zza.zzb("analytics.service_monitor_interval", 86400000);
    public static zza zzSn = zza.zzd("analytics.http_connection.connect_timeout_millis", 60000);
    public static zza zzSo = zza.zzd("analytics.http_connection.read_timeout_millis", 61000);
    public static zza zzSp = zza.zzb("analytics.campaigns.time_limit", 86400000);
    public static zza zzSq = zza.zzl("analytics.first_party_experiment_id", "");
    public static zza zzSr = zza.zzd("analytics.first_party_experiment_variant", 0);
    public static zza zzSs = zza.zzg("analytics.test.disable_receiver", false);
    public static zza zzSt = zza.zza("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
    public static zza zzSu = zza.zzb("analytics.service_client.connect_timeout_millis", 5000);
    public static zza zzSv = zza.zzb("analytics.service_client.second_connect_delay_millis", 5000);
    public static zza zzSw = zza.zzb("analytics.service_client.unexpected_reconnect_millis", 60000);
    public static zza zzSx = zza.zzb("analytics.service_client.reconnect_throttle_millis", 1800000);
    public static zza zzSy = zza.zzb("analytics.monitoring.sample_period_millis", 86400000);
    public static zza zzSz = zza.zzb("analytics.initialization_warning_threshold", 5000);

    public final class zza {
        private final Object zzSA;
        private final zzlz zzSB;
        private Object zzSC;

        private zza(zzlz zzlzVar, Object obj) {
            com.google.android.gms.common.internal.zzx.zzz(zzlzVar);
            this.zzSB = zzlzVar;
            this.zzSA = obj;
        }

        static zza zza(String str, float f) {
            return zza(str, f, f);
        }

        static zza zza(String str, float f, float f2) {
            return new zza(zzlz.zza(str, Float.valueOf(f2)), Float.valueOf(f));
        }

        static zza zza(String str, int i, int i2) {
            return new zza(zzlz.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static zza zza(String str, long j, long j2) {
            return new zza(zzlz.zza(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static zza zza(String str, boolean z, boolean z2) {
            return new zza(zzlz.zzk(str, z2), Boolean.valueOf(z));
        }

        static zza zzb(String str, long j) {
            return zza(str, j, j);
        }

        static zza zzd(String str, int i) {
            return zza(str, i, i);
        }

        static zza zze(String str, String str2, String str3) {
            return new zza(zzlz.zzv(str, str3), str2);
        }

        static zza zzg(String str, boolean z) {
            return zza(str, z, z);
        }

        static zza zzl(String str, String str2) {
            return zze(str, str2, str2);
        }

        public final Object get() {
            return this.zzSC != null ? this.zzSC : (com.google.android.gms.common.internal.zzd.zzakE && zzlz.isInitialized()) ? this.zzSB.zzpX() : this.zzSA;
        }
    }
}
