package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.zzlz;

/* loaded from: classes2.dex */
public final class zzl {
    public static zza zzaVY = zza.zzm("measurement.service_enabled", true);
    public static zza zzaVZ = zza.zzm("measurement.service_client_enabled", true);
    public static zza zzaWa = zza.zzl("measurement.log_tag", "GMPM", "GMPM-SVC");
    public static zza zzaWb = zza.zze("measurement.ad_id_cache_time", 10000);
    public static zza zzaWc = zza.zze("measurement.monitoring.sample_period_millis", 86400000);
    public static zza zzaWd = zza.zze("measurement.config.cache_time", 86400000);
    public static zza zzaWe = zza.zzN("measurement.config.url_scheme", "https");
    public static zza zzaWf = zza.zzN("measurement.config.url_authority", "app-measurement.com");
    public static zza zzaWg = zza.zzD("measurement.upload.max_bundles", 100);
    public static zza zzaWh = zza.zzD("measurement.upload.max_batch_size", 65536);
    public static zza zzaWi = zza.zzD("measurement.upload.max_bundle_size", 65536);
    public static zza zzaWj = zza.zzD("measurement.upload.max_events_per_bundle", 1000);
    public static zza zzaWk = zza.zzD("measurement.upload.max_events_per_day", 100000);
    public static zza zzaWl = zza.zzD("measurement.upload.max_public_events_per_day", 50000);
    public static zza zzaWm = zza.zzD("measurement.upload.max_conversions_per_day", 500);
    public static zza zzaWn = zza.zzD("measurement.store.max_stored_events_per_app", 100000);
    public static zza zzaWo = zza.zzN("measurement.upload.url", "https://app-measurement.com/a");
    public static zza zzaWp = zza.zze("measurement.upload.backoff_period", 43200000);
    public static zza zzaWq = zza.zze("measurement.upload.window_interval", 3600000);
    public static zza zzaWr = zza.zze("measurement.upload.interval", 3600000);
    public static zza zzaWs = zza.zze("measurement.upload.stale_data_deletion_interval", 86400000);
    public static zza zzaWt = zza.zze("measurement.upload.initial_upload_delay_time", 15000);
    public static zza zzaWu = zza.zze("measurement.upload.retry_time", 1800000);
    public static zza zzaWv = zza.zzD("measurement.upload.retry_count", 6);
    public static zza zzaWw = zza.zze("measurement.upload.max_queue_time", 2419200000L);
    public static zza zzaWx = zza.zzD("measurement.lifetimevalue.max_currency_tracked", 4);
    public static zza zzaWy = zza.zze("measurement.service_client.idle_disconnect_millis", 5000);

    public final class zza {
        private final Object zzSA;
        private final zzlz zzSB;
        private Object zzSC;
        private final String zzvs;

        private zza(String str, zzlz zzlzVar, Object obj) {
            com.google.android.gms.common.internal.zzx.zzz(zzlzVar);
            this.zzSB = zzlzVar;
            this.zzSA = obj;
            this.zzvs = str;
        }

        static zza zzD(String str, int i) {
            return zzo(str, i, i);
        }

        static zza zzN(String str, String str2) {
            return zzl(str, str2, str2);
        }

        static zza zzb(String str, long j, long j2) {
            return new zza(str, zzlz.zza(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static zza zzb(String str, boolean z, boolean z2) {
            return new zza(str, zzlz.zzk(str, z2), Boolean.valueOf(z));
        }

        static zza zze(String str, long j) {
            return zzb(str, j, j);
        }

        static zza zzl(String str, String str2, String str3) {
            return new zza(str, zzlz.zzv(str, str3), str2);
        }

        static zza zzm(String str, boolean z) {
            return zzb(str, z, z);
        }

        static zza zzo(String str, int i, int i2) {
            return new zza(str, zzlz.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        public final Object get() {
            return this.zzSC != null ? this.zzSC : (com.google.android.gms.common.internal.zzd.zzakE && zzlz.isInitialized()) ? this.zzSB.zzpX() : this.zzSA;
        }

        public final Object get(Object obj) {
            return this.zzSC != null ? this.zzSC : obj == null ? (com.google.android.gms.common.internal.zzd.zzakE && zzlz.isInitialized()) ? this.zzSB.zzpX() : this.zzSA : obj;
        }

        public final String getKey() {
            return this.zzvs;
        }
    }
}
