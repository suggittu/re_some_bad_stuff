package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

/* loaded from: classes2.dex */
class zzs implements Logger {
    private boolean zzPk;
    private int zzRB = 2;

    zzs() {
    }

    @Override // com.google.android.gms.analytics.Logger
    public void error(Exception exc) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public void error(String str) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public int getLogLevel() {
        return this.zzRB;
    }

    @Override // com.google.android.gms.analytics.Logger
    public void info(String str) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public void setLogLevel(int i) {
        this.zzRB = i;
        if (this.zzPk) {
            return;
        }
        Log.i((String) zzy.zzRL.get(), "Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + ((String) zzy.zzRL.get()) + " DEBUG");
        this.zzPk = true;
    }

    @Override // com.google.android.gms.analytics.Logger
    public void verbose(String str) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public void warn(String str) {
    }
}
