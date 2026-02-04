package ru.anna.chinagame;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.yandex.metrica.YandexMetrica;

/* loaded from: classes.dex */
public class MyApp extends Application {
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        YandexMetrica.activate(getApplicationContext(), "6cfcc474-fbbb-4d06-aace-823fb6d2d096");
        YandexMetrica.enableActivityAutoTracking(this);
    }
}
