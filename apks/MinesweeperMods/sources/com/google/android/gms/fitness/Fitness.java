package com.google.android.gms.fitness;

import android.content.Intent;
import android.os.Build;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zznz;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzob;
import com.google.android.gms.internal.zzoc;
import com.google.android.gms.internal.zzod;
import com.google.android.gms.internal.zzoe;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpa;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpc;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpf;
import com.google.android.gms.internal.zzpg;
import com.google.android.gms.internal.zzpi;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class Fitness {
    public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
    public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
    public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
    public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
    public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
    public static final Api.zzc zzavK = new Api.zzc();
    public static final Api.zzc zzavL = new Api.zzc();
    public static final Api.zzc zzavM = new Api.zzc();
    public static final Api.zzc zzavN = new Api.zzc();
    public static final Api.zzc zzavO = new Api.zzc();
    public static final Api.zzc zzavP = new Api.zzc();
    public static final Api.zzc zzavQ = new Api.zzc();

    @Deprecated
    public static final Void API = null;
    public static final Api SENSORS_API = new Api("Fitness.SENSORS_API", new zzoe.zzb(), zzavP);
    public static final SensorsApi SensorsApi = new zzpf();
    public static final Api RECORDING_API = new Api("Fitness.RECORDING_API", new zzod.zzb(), zzavO);
    public static final RecordingApi RecordingApi = new zzpe();
    public static final Api SESSIONS_API = new Api("Fitness.SESSIONS_API", new zzof.zzb(), zzavQ);
    public static final SessionsApi SessionsApi = new zzpg();
    public static final Api HISTORY_API = new Api("Fitness.HISTORY_API", new zzob.zzb(), zzavM);
    public static final HistoryApi HistoryApi = new zzpc();
    public static final Api CONFIG_API = new Api("Fitness.CONFIG_API", new zzoa.zzb(), zzavL);
    public static final ConfigApi ConfigApi = new zzpb();
    public static final Api BLE_API = new Api("Fitness.BLE_API", new zznz.zzb(), zzavK);
    public static final BleApi BleApi = zztZ();
    public static final Api zzaoG = new Api("Fitness.INTERNAL_API", new zzoc.zza(), zzavN);
    public static final zzoy zzavR = new zzpd();
    public static final Scope SCOPE_ACTIVITY_READ = new Scope(Scopes.FITNESS_ACTIVITY_READ);
    public static final Scope SCOPE_ACTIVITY_READ_WRITE = new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE);
    public static final Scope SCOPE_LOCATION_READ = new Scope(Scopes.FITNESS_LOCATION_READ);
    public static final Scope SCOPE_LOCATION_READ_WRITE = new Scope(Scopes.FITNESS_LOCATION_READ_WRITE);
    public static final Scope SCOPE_BODY_READ = new Scope(Scopes.FITNESS_BODY_READ);
    public static final Scope SCOPE_BODY_READ_WRITE = new Scope(Scopes.FITNESS_BODY_READ_WRITE);
    public static final Scope SCOPE_NUTRITION_READ = new Scope(Scopes.FITNESS_NUTRITION_READ);
    public static final Scope SCOPE_NUTRITION_READ_WRITE = new Scope(Scopes.FITNESS_NUTRITION_READ_WRITE);

    private Fitness() {
    }

    public static long getEndTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_END_TIME, -1L);
        if (longExtra == -1) {
            return -1L;
        }
        return timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    public static long getStartTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_START_TIME, -1L);
        if (longExtra == -1) {
            return -1L;
        }
        return timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    private static BleApi zztZ() {
        return Build.VERSION.SDK_INT >= 18 ? new zzpa() : new zzpi();
    }
}
