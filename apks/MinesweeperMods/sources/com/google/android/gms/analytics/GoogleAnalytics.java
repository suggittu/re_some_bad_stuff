package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzak;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzy;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public final class GoogleAnalytics extends com.google.android.gms.analytics.zza {
    private static List zzPe = new ArrayList();
    private boolean zzPf;
    private Set zzPg;
    private boolean zzPh;
    private boolean zzPi;
    private volatile boolean zzPj;
    private boolean zzPk;
    private boolean zzqA;

    interface zza {
        void zzl(Activity activity);

        void zzm(Activity activity);
    }

    @TargetApi(14)
    class zzb implements Application.ActivityLifecycleCallbacks {
        zzb() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            GoogleAnalytics.this.zzj(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            GoogleAnalytics.this.zzk(activity);
        }
    }

    public GoogleAnalytics(zzf zzfVar) {
        super(zzfVar);
        this.zzPg = new HashSet();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public static GoogleAnalytics getInstance(Context context) {
        return zzf.zzaa(context).zzjz();
    }

    public static void zziF() {
        synchronized (GoogleAnalytics.class) {
            if (zzPe != null) {
                Iterator it = zzPe.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                zzPe = null;
            }
        }
    }

    private com.google.android.gms.analytics.internal.zzb zziH() {
        return zzix().zziH();
    }

    private zzan zziI() {
        return zzix().zziI();
    }

    public final void dispatchLocalHits() {
        zziH().zzjd();
    }

    @TargetApi(14)
    public final void enableAutoActivityReports(Application application) {
        if (Build.VERSION.SDK_INT < 14 || this.zzPh) {
            return;
        }
        application.registerActivityLifecycleCallbacks(new zzb());
        this.zzPh = true;
    }

    public final boolean getAppOptOut() {
        return this.zzPj;
    }

    public final String getClientId() {
        zzx.zzcE("getClientId can not be called from the main thread");
        return zzix().zzjC().zzkk();
    }

    @Deprecated
    public final Logger getLogger() {
        return zzae.getLogger();
    }

    public final boolean isDryRunEnabled() {
        return this.zzPi;
    }

    public final boolean isInitialized() {
        return this.zzqA && !this.zzPf;
    }

    public final Tracker newTracker(int i) {
        Tracker tracker;
        zzal zzalVar;
        synchronized (this) {
            tracker = new Tracker(zzix(), null, null);
            if (i > 0 && (zzalVar = (zzal) new zzak(zzix()).zzah(i)) != null) {
                tracker.zza(zzalVar);
            }
            tracker.zza();
        }
        return tracker;
    }

    public final Tracker newTracker(String str) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(zzix(), str, null);
            tracker.zza();
        }
        return tracker;
    }

    public final void reportActivityStart(Activity activity) {
        if (this.zzPh) {
            return;
        }
        zzj(activity);
    }

    public final void reportActivityStop(Activity activity) {
        if (this.zzPh) {
            return;
        }
        zzk(activity);
    }

    public final void setAppOptOut(boolean z) {
        this.zzPj = z;
        if (this.zzPj) {
            zziH().zzjc();
        }
    }

    public final void setDryRun(boolean z) {
        this.zzPi = z;
    }

    public final void setLocalDispatchPeriod(int i) {
        zziH().setLocalDispatchPeriod(i);
    }

    @Deprecated
    public final void setLogger(Logger logger) {
        zzae.setLogger(logger);
        if (this.zzPk) {
            return;
        }
        Log.i((String) zzy.zzRL.get(), "GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + ((String) zzy.zzRL.get()) + " DEBUG");
        this.zzPk = true;
    }

    public final void zza() {
        zziE();
        this.zzqA = true;
    }

    final void zza(zza zzaVar) {
        this.zzPg.add(zzaVar);
        Context context = zzix().getContext();
        if (context instanceof Application) {
            enableAutoActivityReports((Application) context);
        }
    }

    final void zzb(zza zzaVar) {
        this.zzPg.remove(zzaVar);
    }

    final void zziE() {
        Logger logger;
        zzan zzanVarZziI = zziI();
        if (zzanVarZziI.zzlj()) {
            getLogger().setLogLevel(zzanVarZziI.getLogLevel());
        }
        if (zzanVarZziI.zzln()) {
            this.zzPi = zzanVarZziI.zzlo();
        }
        if (!zzanVarZziI.zzlj() || (logger = zzae.getLogger()) == null) {
            return;
        }
        logger.setLogLevel(zzanVarZziI.getLogLevel());
    }

    final void zziG() throws ExecutionException, InterruptedException, TimeoutException {
        zziH().zzje();
    }

    final void zzj(Activity activity) {
        Iterator it = this.zzPg.iterator();
        while (it.hasNext()) {
            ((zza) it.next()).zzl(activity);
        }
    }

    final void zzk(Activity activity) {
        Iterator it = this.zzPg.iterator();
        while (it.hasNext()) {
            ((zza) it.next()).zzm(activity);
        }
    }
}
