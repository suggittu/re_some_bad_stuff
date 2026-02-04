package com.yandex.metrica;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.location.Location;
import com.yandex.metrica.impl.bk;
import com.yandex.metrica.impl.bo;
import com.yandex.metrica.impl.utils.f;
import java.util.Map;

/* loaded from: classes.dex */
public final class YandexMetrica {
    private YandexMetrica() {
    }

    public static void activate(Context context, String apiKey) {
        bo.a(context, e.a(apiKey).b());
    }

    public static void activate(Context context, YandexMetricaConfig config) {
        bo.a(context, e.a(config));
    }

    public static void onResumeActivity(Activity activity) {
        bo.a().a(activity);
    }

    public static void onPauseActivity(Activity activity) {
        bo.a().b(activity);
    }

    public static void enableActivityAutoTracking(Application application) {
        bo.a().a(application);
    }

    public static void reportEvent(String eventName) {
        bo.a().b(eventName);
    }

    public static void reportError(String message, Throwable error) {
        bo.a().a(message, error);
    }

    public static void reportUnhandledException(Throwable exception) {
        bo.a().a(exception);
    }

    public static void reportNativeCrash(String nativeCrash) {
        bo.a().c(nativeCrash);
    }

    public static void reportEvent(String eventName, String jsonValue) {
        bo.a().a(eventName, jsonValue);
    }

    public static void reportEvent(String eventName, Map<String, Object> attributes) {
        bo.a().a(eventName, attributes);
    }

    public static void setSessionTimeout(int sessionTimeout) {
        bo.a(sessionTimeout);
    }

    public static void setReportCrashesEnabled(boolean enabled) {
        bo.a(enabled);
    }

    public static void setReportNativeCrashesEnabled(boolean enabled) {
        bo.b(enabled);
    }

    public static void setLocation(Location location) {
        bo.a(location);
    }

    public static void setTrackLocationEnabled(boolean enabled) {
        bo.c(enabled);
    }

    public static void setCustomAppVersion(String appVersion) {
        bo.e(appVersion);
    }

    public static void setLogEnabled() {
        f.e().a();
    }

    public static void setCollectInstalledApps(boolean collect) {
        bo.d(collect);
    }

    public static IReporter getReporter(Context context, String apiKey) {
        bk.b(apiKey);
        bo.a(context);
        return bo.a().a(apiKey);
    }

    public static void setEnvironmentValue(String key, String value) {
        bo.b(key, value);
    }

    public static String getLibraryVersion() {
        return "2.42";
    }

    public static int getLibraryApiLevel() {
        return 45;
    }

    public static boolean isCollectInstalledApps() {
        return bo.c();
    }

    public static void registerReferrerBroadcastReceivers(BroadcastReceiver... anotherReferrerReceivers) {
        MetricaEventHandler.a(anotherReferrerReceivers);
    }
}
