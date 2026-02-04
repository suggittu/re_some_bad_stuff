package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.internal.zzae;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class ExceptionReporter implements Thread.UncaughtExceptionHandler {
    private final Context mContext;
    private final Thread.UncaughtExceptionHandler zzPa;
    private final Tracker zzPb;
    private ExceptionParser zzPc;
    private GoogleAnalytics zzPd;

    public ExceptionReporter(Tracker tracker, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        if (tracker == null) {
            throw new NullPointerException("tracker cannot be null");
        }
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.zzPa = uncaughtExceptionHandler;
        this.zzPb = tracker;
        this.zzPc = new StandardExceptionParser(context, new ArrayList());
        this.mContext = context.getApplicationContext();
        zzae.v("ExceptionReporter created, original handler is " + (uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName()));
    }

    public ExceptionParser getExceptionParser() {
        return this.zzPc;
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        this.zzPc = exceptionParser;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) throws ExecutionException, InterruptedException, TimeoutException {
        String description = "UncaughtException";
        if (this.zzPc != null) {
            description = this.zzPc.getDescription(thread != null ? thread.getName() : null, th);
        }
        zzae.v("Reporting uncaught exception: " + description);
        this.zzPb.send(new HitBuilders.ExceptionBuilder().setDescription(description).setFatal(true).build());
        GoogleAnalytics googleAnalyticsZziC = zziC();
        googleAnalyticsZziC.dispatchLocalHits();
        googleAnalyticsZziC.zziG();
        if (this.zzPa != null) {
            zzae.v("Passing exception to the original handler");
            this.zzPa.uncaughtException(thread, th);
        }
    }

    GoogleAnalytics zziC() {
        if (this.zzPd == null) {
            this.zzPd = GoogleAnalytics.getInstance(this.mContext);
        }
        return this.zzPd;
    }

    Thread.UncaughtExceptionHandler zziD() {
        return this.zzPa;
    }
}
