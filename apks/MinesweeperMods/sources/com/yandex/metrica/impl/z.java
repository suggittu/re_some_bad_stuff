package com.yandex.metrica.impl;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcel;
import com.yandex.metrica.impl.d;
import com.yandex.metrica.impl.ob.bt;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class z implements d {
    private static volatile z i;
    private final Context d;
    private final LocationManager f;
    private boolean l;
    private bt m;
    static final long a = TimeUnit.SECONDS.toMillis(300);
    static final long b = TimeUnit.SECONDS.toMillis(120);
    static final Set<String> c = new HashSet(Arrays.asList("gps"));
    private static final Object j = new Object();
    private d.a<Location> k = new d.a<>();
    private LocationListener n = new LocationListener() { // from class: com.yandex.metrica.impl.z.1
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            z.this.a(location);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String provider) {
        }
    };
    private final WeakHashMap<Object, Object> g = new WeakHashMap<>();
    private boolean h = false;
    private final HandlerThread e = new HandlerThread("LHandlerThread");

    private z(Context context) {
        this.l = false;
        this.d = context;
        this.e.start();
        this.f = (LocationManager) context.getSystemService("location");
        this.m = new bt(context);
        this.l = this.m.a();
    }

    public static z a(Context context) {
        if (i == null) {
            synchronized (j) {
                if (i == null) {
                    i = new z(context.getApplicationContext());
                }
            }
        }
        return i;
    }

    public synchronized void a(Object obj) {
        if (this.l && ai.a(this.d.getPackageManager(), this.d.getPackageName(), "android.permission.ACCESS_COARSE_LOCATION")) {
            this.g.put(obj, null);
            if (!this.h) {
                this.h = true;
                a("network", 0.0f, a, this.n, this.e.getLooper());
                a("passive", 0.0f, a, this.n, this.e.getLooper());
            }
        }
    }

    private void a(String str, float f, long j2, LocationListener locationListener, Looper looper) {
        try {
            this.f.requestLocationUpdates(str, j2, f, locationListener, looper);
        } catch (Exception e) {
        }
    }

    public synchronized void b(Object obj) {
        this.g.remove(obj);
        b();
    }

    synchronized void a() {
        this.g.clear();
        b();
    }

    void b() {
        if (this.h && this.g.isEmpty()) {
            this.h = false;
            try {
                this.f.removeUpdates(this.n);
            } catch (Exception e) {
            }
        }
    }

    public synchronized void a(Location location) {
        if (this.k.a()) {
            this.k.a(e());
        }
        if (a(location, this.k.b())) {
            Location location2 = location == null ? null : new Location(location);
            this.k.a(location2);
            c(location2);
        }
    }

    synchronized Location c() {
        if (this.k.a()) {
            this.k.a(e());
        }
        return this.k.b();
    }

    private synchronized void c(Location location) {
        try {
            j.a(this.d).a(b(location));
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027 A[Catch: all -> 0x002b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {, blocks: (B:9:0x0022, B:12:0x0027, B:22:0x0038, B:23:0x003b, B:19:0x0030), top: B:28:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized android.location.Location e() {
        /*
            r4 = this;
            r0 = 0
            monitor-enter(r4)
            android.content.Context r1 = r4.d     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L34
            com.yandex.metrica.impl.j r1 = com.yandex.metrica.impl.j.a(r1)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L34
            android.database.Cursor r1 = r1.a()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L34
            if (r1 == 0) goto L27
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r2 == 0) goto L27
            java.lang.String r2 = "GeoLocation"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            byte[] r2 = r1.getBlob(r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            android.location.Location r0 = a(r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            com.yandex.metrica.impl.bk.a(r1)     // Catch: java.lang.Throwable -> L2b
        L25:
            monitor-exit(r4)
            return r0
        L27:
            com.yandex.metrica.impl.bk.a(r1)     // Catch: java.lang.Throwable -> L2b
            goto L25
        L2b:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L2e:
            r1 = move-exception
            r1 = r0
        L30:
            com.yandex.metrica.impl.bk.a(r1)     // Catch: java.lang.Throwable -> L2b
            goto L25
        L34:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L38:
            com.yandex.metrica.impl.bk.a(r1)     // Catch: java.lang.Throwable -> L2b
            throw r0     // Catch: java.lang.Throwable -> L2b
        L3c:
            r0 = move-exception
            goto L38
        L3e:
            r2 = move-exception
            goto L30
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.z.e():android.location.Location");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.location.Location d() {
        /*
            r5 = this;
            r2 = 0
            android.location.LocationManager r0 = r5.f
            java.util.List r0 = r0.getAllProviders()
            java.util.Iterator r3 = r0.iterator()
            r1 = r2
        Lc:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L33
            java.lang.Object r0 = r3.next()
            java.lang.String r0 = (java.lang.String) r0
            java.util.Set<java.lang.String> r4 = com.yandex.metrica.impl.z.c
            boolean r4 = r4.contains(r0)
            if (r4 != 0) goto L34
            android.location.LocationManager r4 = r5.f     // Catch: java.lang.Exception -> L30
            android.location.Location r0 = r4.getLastKnownLocation(r0)     // Catch: java.lang.Exception -> L30
        L26:
            if (r0 == 0) goto L34
            boolean r4 = a(r0, r1)
            if (r4 == 0) goto L34
        L2e:
            r1 = r0
            goto Lc
        L30:
            r0 = move-exception
            r0 = r2
            goto L26
        L33:
            return r1
        L34:
            r0 = r1
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.z.d():android.location.Location");
    }

    static boolean a(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        if (location == null) {
            return false;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > b;
        boolean z2 = time < (-b);
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = ((long) accuracy) > 200;
        String provider = location.getProvider();
        String provider2 = location2.getProvider();
        boolean zEquals = provider == null ? provider2 == null : provider.equals(provider2);
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z6 && zEquals;
        }
        return true;
    }

    public static byte[] b(Location location) {
        Parcel parcelObtain = Parcel.obtain();
        byte[] bArrMarshall = new byte[0];
        try {
            parcelObtain.writeValue(location);
            bArrMarshall = parcelObtain.marshall();
        } catch (Exception e) {
        } finally {
            parcelObtain.recycle();
        }
        return bArrMarshall;
    }

    public static Location a(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            Location location = (Location) parcelObtain.readValue(Location.class.getClassLoader());
            parcelObtain.recycle();
            return location;
        } catch (Exception e) {
            parcelObtain.recycle();
            return null;
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    public void a(Object obj, boolean z, boolean z2) {
        if (this.l != z2) {
            if (z) {
                this.l = z2;
                this.m.a(this.l);
                if (this.l) {
                    a(obj);
                    return;
                } else {
                    a();
                    return;
                }
            }
            if (!z2) {
                b(obj);
            }
        }
    }
}
