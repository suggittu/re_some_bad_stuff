package com.yandex.metrica;

import android.content.ContentValues;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.google.android.gms.nearby.messages.Strategy;
import com.yandex.metrica.impl.bc;
import com.yandex.metrica.impl.bi;
import com.yandex.metrica.impl.bk;
import com.yandex.metrica.impl.z;
import java.util.Map;

/* loaded from: classes.dex */
public class CounterConfiguration implements Parcelable {
    public static final Parcelable.Creator<CounterConfiguration> CREATOR = new Parcelable.Creator<CounterConfiguration>() { // from class: com.yandex.metrica.CounterConfiguration.1
        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CounterConfiguration[] newArray(int i) {
            return new CounterConfiguration[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ CounterConfiguration createFromParcel(Parcel parcel) {
            return new CounterConfiguration(parcel);
        }
    };
    private ContentValues a;
    private ResultReceiver b;

    public enum a {
        UNDEFINED(-1),
        FALSE(0),
        TRUE(1);

        public final int d;

        a(int i) {
            this.d = i;
        }

        public static a a(int i) {
            switch (i) {
            }
            return UNDEFINED;
        }
    }

    public CounterConfiguration(CounterConfiguration other) {
        this.b = null;
        this.a = new ContentValues();
        this.a.putAll(other.a);
        this.b = other.b;
    }

    public CounterConfiguration() {
        this.b = null;
        this.a = new ContentValues();
        this.a.put("CFG_DISPATCH_PERIOD", (Integer) 90);
        this.a.put("CFG_MAX_REPORTS_COUNT", (Integer) 7);
        this.a.put("CFG_SESSION_TIMEOUT", (Integer) 10);
        this.a.put("CFG_REPORTS", (Boolean) true);
        this.a.put("CFG_REPORTS_CRASHES", (Boolean) true);
        this.a.put("CFG_REPORTS_NATIVE_CRASHES", (Boolean) true);
        this.a.put("CFG_REPORT_LOCATION", (Boolean) true);
        this.a.put("CFG_COLLECT_INSTALLED_APPS", Integer.valueOf(a.FALSE.d));
        this.a.putNull("CFG_HOST_URL");
        this.a.putNull("CFG_MANUAL_LOCATION");
        this.a.putNull("CFG_APP_VERSION");
        this.a.putNull("CFG_APP_VERSION_CODE");
        this.a.putNull("CFG_API_KEY");
        this.a.putNull("CFG_PACKAGE_NAME");
        this.a.putNull("CFG_UUID");
        this.a.putNull("CFG_DEVICE_ID");
        this.a.putNull("CFG_DEVICE_SIZE_TYPE");
        this.a.putNull("CFG_CLIDS");
        this.a.put("CFG_MAIN_REPORTER", (Boolean) true);
        this.a.put("CFG_IS_LOG_ENABLED", (Boolean) false);
        this.a.put("CFG_APP_FRAMEWORK", bc.b());
    }

    public void a(e eVar) throws IllegalArgumentException {
        if (eVar.getSessionTimeout() != null) {
            c(eVar.getSessionTimeout().intValue());
        }
        if (eVar.getLocation() != null) {
            a(eVar.getLocation());
        }
        if (eVar.isTrackLocationEnabled() != null) {
            c(eVar.isTrackLocationEnabled().booleanValue());
        }
        if (eVar.isCollectInstalledApps() != null) {
            d(eVar.isCollectInstalledApps().booleanValue());
        }
        if (eVar.isReportCrashEnabled() != null) {
            a(eVar.isReportCrashEnabled().booleanValue());
        }
        if (eVar.isReportNativeCrashEnabled() != null) {
            b(eVar.isReportNativeCrashEnabled().booleanValue());
        }
        if (eVar.d() != null) {
            a(eVar.d());
        }
        if (eVar.h() != null) {
            a(eVar.h().intValue());
        }
        if (eVar.g() != null) {
            b(eVar.g().intValue());
        }
        if (!bi.a(eVar.getAppVersion())) {
            h(eVar.getAppVersion());
        }
        if (eVar.c() != null) {
            d(eVar.c().intValue());
        }
        if (eVar.b() != null) {
            g(eVar.b());
        }
        if (eVar.j() != null) {
            f(eVar.j().booleanValue());
        }
        if (eVar.e() != null) {
            a(eVar.e());
        }
        if (eVar.f() != null) {
            i(eVar.f());
        }
    }

    public void a(ResultReceiver resultReceiver) {
        this.b = resultReceiver;
    }

    public ResultReceiver a() {
        return this.b;
    }

    public void a(int i) {
        this.a.put("CFG_DISPATCH_PERIOD", Integer.valueOf(i));
    }

    public int b() {
        return this.a.getAsInteger("CFG_DISPATCH_PERIOD").intValue();
    }

    public void b(int i) {
        ContentValues contentValues = this.a;
        if (i <= 0) {
            i = Strategy.TTL_SECONDS_INFINITE;
        }
        contentValues.put("CFG_MAX_REPORTS_COUNT", Integer.valueOf(i));
    }

    public int c() {
        return this.a.getAsInteger("CFG_MAX_REPORTS_COUNT").intValue();
    }

    public void c(int i) {
        this.a.put("CFG_SESSION_TIMEOUT", Integer.valueOf(Math.max(10, i)));
    }

    public int d() {
        return this.a.getAsInteger("CFG_SESSION_TIMEOUT").intValue();
    }

    public void a(com.yandex.metrica.a aVar) {
        this.a.put("CFG_DEVICE_SIZE_TYPE", aVar == null ? null : aVar.a());
    }

    public com.yandex.metrica.a e() {
        return com.yandex.metrica.a.a(this.a.getAsString("CFG_DEVICE_SIZE_TYPE"));
    }

    public void a(String str) {
        bk.b(str);
        this.a.put("CFG_API_KEY", str);
    }

    public void b(String str) {
        this.a.put("CFG_API_KEY", str);
    }

    public void c(String str) {
        this.a.put("CFG_PACKAGE_NAME", str);
    }

    public String f() {
        return this.a.getAsString("CFG_PACKAGE_NAME");
    }

    public void d(String str) {
        this.a.put("CFG_UUID", str);
    }

    public String g() {
        return this.a.getAsString("CFG_UUID");
    }

    public void e(String str) {
        this.a.put("CFG_DEVICE_ID", str);
    }

    public String h() {
        return this.a.getAsString("CFG_DEVICE_ID");
    }

    public void f(String str) {
        this.a.put("CFG_POSSIBLE_DEVICE_ID", str);
    }

    public String i() {
        return this.a.getAsString("CFG_POSSIBLE_DEVICE_ID");
    }

    public String j() {
        return this.a.getAsString("CFG_API_KEY");
    }

    public void a(boolean z) {
        this.a.put("CFG_REPORTS_CRASHES", Boolean.valueOf(z));
    }

    public boolean k() {
        return this.a.getAsBoolean("CFG_REPORTS_CRASHES").booleanValue();
    }

    public void b(boolean z) {
        this.a.put("CFG_REPORTS_NATIVE_CRASHES", Boolean.valueOf(z));
    }

    public boolean l() {
        return this.a.getAsBoolean("CFG_REPORTS_NATIVE_CRASHES").booleanValue();
    }

    public boolean m() {
        return this.a.getAsBoolean("CFG_REPORTS").booleanValue();
    }

    public void c(boolean z) {
        this.a.put("CFG_REPORT_LOCATION", Boolean.valueOf(z));
    }

    public boolean n() {
        return this.a.getAsBoolean("CFG_REPORT_LOCATION").booleanValue();
    }

    public void g(String str) throws IllegalArgumentException {
        bk.a(str, "Custom Host URL");
        this.a.put("CFG_HOST_URL", str);
    }

    public String o() {
        return this.a.getAsString("CFG_HOST_URL");
    }

    public void h(String str) {
        this.a.put("CFG_APP_VERSION", str);
    }

    public String p() {
        return this.a.getAsString("CFG_APP_VERSION");
    }

    public void d(int i) {
        this.a.put("CFG_APP_VERSION_CODE", String.valueOf(i));
    }

    public String q() {
        return this.a.getAsString("CFG_APP_VERSION_CODE");
    }

    public void d(boolean z) {
        this.a.put("CFG_COLLECT_INSTALLED_APPS", Integer.valueOf(z ? a.TRUE.d : a.FALSE.d));
    }

    public boolean r() {
        switch (s()) {
            case TRUE:
                return true;
            case UNDEFINED:
            default:
                return false;
        }
    }

    public a s() {
        return a(this.a.get("CFG_COLLECT_INSTALLED_APPS"));
    }

    public void a(Location location) {
        this.a.put("CFG_MANUAL_LOCATION", z.b(location));
    }

    public void e(boolean z) {
        this.a.put("CFG_IS_LOG_ENABLED", Boolean.valueOf(z));
    }

    public boolean t() {
        if (!this.a.containsKey("CFG_IS_LOG_ENABLED")) {
            return false;
        }
        return this.a.getAsBoolean("CFG_IS_LOG_ENABLED").booleanValue();
    }

    public Location u() {
        Location locationA = z.a(this.a.getAsByteArray("CFG_MANUAL_LOCATION"));
        if (locationA == null && A()) {
            Double dY = y();
            Double dZ = z();
            Location location = new Location("NONE");
            location.setLatitude(dY.doubleValue());
            location.setLongitude(dZ.doubleValue());
            location.setTime(System.currentTimeMillis());
            return location;
        }
        return locationA;
    }

    public void a(Map<String, String> map) {
        this.a.put("CFG_CLIDS", bk.b(map));
    }

    public Map<String, String> v() {
        return bk.d(this.a.getAsString("CFG_CLIDS"));
    }

    public String w() {
        return this.a.getAsString("CFG_DISTRIBUTION_REFERRER");
    }

    public void i(String str) {
        this.a.put("CFG_DISTRIBUTION_REFERRER", str);
    }

    public boolean x() {
        Boolean asBoolean = this.a.getAsBoolean("CFG_AUTO_PRELOAD_INFO_DETECTION");
        if (asBoolean != null) {
            return asBoolean.booleanValue();
        }
        return false;
    }

    public void f(boolean z) {
        this.a.put("CFG_AUTO_PRELOAD_INFO_DETECTION", Boolean.valueOf(z));
    }

    Double y() {
        return this.a.getAsDouble("CFG_LOCATION_LATITUDE");
    }

    Double z() {
        return this.a.getAsDouble("CFG_LOCATION_LONGITUDE");
    }

    boolean A() {
        return (this.a.getAsDouble("CFG_LOCATION_LONGITUDE") != null) & (this.a.getAsDouble("CFG_LOCATION_LATITUDE") != null);
    }

    public CounterConfiguration(Parcel srcObj) {
        this.b = null;
        a(srcObj);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void a(Parcel parcel) {
        this.a = (ContentValues) parcel.readParcelable(ContentValues.class.getClass().getClassLoader());
        this.b = (ResultReceiver) parcel.readParcelable(ResultReceiver.class.getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel destObj, int flags) {
        destObj.writeParcelable(this.a, 0);
        ResultReceiver resultReceiver = this.b;
        Parcel parcelObtain = Parcel.obtain();
        resultReceiver.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        destObj.writeParcelable(resultReceiver2, 0);
    }

    public void g(boolean z) {
        this.a.put("CFG_MAIN_REPORTER", Boolean.valueOf(z));
    }

    public boolean B() {
        Boolean asBoolean = this.a.getAsBoolean("CFG_MAIN_REPORTER");
        if (asBoolean != null) {
            return asBoolean.booleanValue();
        }
        return true;
    }

    public boolean C() {
        return bk.c(j());
    }

    public String D() {
        return this.a.getAsString("CFG_APP_FRAMEWORK");
    }

    public Bundle E() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("COUNTER_CFG_OBJ", this);
        return bundle;
    }

    public void a(CounterConfiguration counterConfiguration) {
        if (this.a.containsKey("CFG_DISPATCH_PERIOD")) {
            this.a.put("CFG_DISPATCH_PERIOD", counterConfiguration.a.getAsInteger("CFG_DISPATCH_PERIOD"));
        }
        if (this.a.containsKey("CFG_SESSION_TIMEOUT")) {
            this.a.put("CFG_SESSION_TIMEOUT", counterConfiguration.a.getAsInteger("CFG_SESSION_TIMEOUT"));
        }
        if (this.a.containsKey("CFG_MAX_REPORTS_COUNT")) {
            this.a.put("CFG_MAX_REPORTS_COUNT", counterConfiguration.a.getAsInteger("CFG_MAX_REPORTS_COUNT"));
        }
        if (this.a.containsKey("CFG_REPORTS_CRASHES")) {
            this.a.put("CFG_REPORTS_CRASHES", counterConfiguration.a.getAsBoolean("CFG_REPORTS_CRASHES"));
        }
        if (this.a.containsKey("CFG_REPORTS_NATIVE_CRASHES")) {
            this.a.put("CFG_REPORTS_NATIVE_CRASHES", counterConfiguration.a.getAsBoolean("CFG_REPORTS_NATIVE_CRASHES"));
        }
        if (this.a.containsKey("CFG_REPORTS")) {
            this.a.put("CFG_REPORTS", counterConfiguration.a.getAsBoolean("CFG_REPORTS"));
        }
        if (this.a.containsKey("CFG_REPORT_LOCATION")) {
            this.a.put("CFG_REPORT_LOCATION", counterConfiguration.a.getAsBoolean("CFG_REPORT_LOCATION"));
        }
        if (this.a.containsKey("CFG_MANUAL_LOCATION")) {
            this.a.put("CFG_MANUAL_LOCATION", counterConfiguration.a.getAsByteArray("CFG_MANUAL_LOCATION"));
        }
        if (this.a.containsKey("CFG_COLLECT_INSTALLED_APPS")) {
            this.a.put("CFG_COLLECT_INSTALLED_APPS", Integer.valueOf(a(counterConfiguration.a.get("CFG_COLLECT_INSTALLED_APPS")).d));
        }
        if (this.a.containsKey("CFG_DEVICE_SIZE_TYPE")) {
            this.a.put("CFG_DEVICE_SIZE_TYPE", counterConfiguration.a.getAsString("CFG_DEVICE_SIZE_TYPE"));
        }
        if (this.a.containsKey("CFG_IS_LOG_ENABLED")) {
            this.a.put("CFG_IS_LOG_ENABLED", counterConfiguration.a.getAsBoolean("CFG_IS_LOG_ENABLED"));
        }
        if (this.a.containsKey("CFG_CLIDS")) {
            this.a.put("CFG_CLIDS", counterConfiguration.a.getAsString("CFG_CLIDS"));
        }
        if (this.a.containsKey("CFG_AUTO_PRELOAD_INFO_DETECTION")) {
            this.a.put("CFG_AUTO_PRELOAD_INFO_DETECTION", counterConfiguration.a.getAsBoolean("CFG_AUTO_PRELOAD_INFO_DETECTION"));
        }
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getInt("CFG_DISPATCH_PERIOD") != 0) {
                a(bundle.getInt("CFG_DISPATCH_PERIOD"));
            }
            if (bundle.getInt("CFG_SESSION_TIMEOUT") != 0) {
                c(bundle.getInt("CFG_SESSION_TIMEOUT"));
            }
            if (bundle.getInt("CFG_MAX_REPORTS_COUNT") != 0) {
                b(bundle.getInt("CFG_MAX_REPORTS_COUNT"));
            }
            if (bundle.getString("CFG_API_KEY") != null && !"-1".equals(bundle.getString("CFG_API_KEY"))) {
                a(bundle.getString("CFG_API_KEY"));
            }
        }
    }

    private static a a(Object obj) {
        if (obj != null) {
            if (obj instanceof Integer) {
                return a.a(((Integer) obj).intValue());
            }
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue() ? a.TRUE : a.FALSE;
            }
        }
        return a.UNDEFINED;
    }
}
