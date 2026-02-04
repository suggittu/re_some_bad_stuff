package ru.anna.chinagame;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/* loaded from: classes.dex */
public final class ruannachinagame extends Application {
    @Override // android.content.ContextWrapper
    protected final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}
