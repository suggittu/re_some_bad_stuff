package com.yandex.metrica.impl;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
class NativeCrashesHelper {
    private String a;
    private final Context b;
    private boolean c;
    private boolean d;

    private static native void cancelSetUpNativeUncaughtExceptionHandler();

    private static native void logsEnabled(boolean z);

    private static native void setUpNativeUncaughtExceptionHandler(String str);

    NativeCrashesHelper(Context context) {
        this.b = context;
    }

    synchronized void a(boolean z) {
        if (z) {
            try {
                if (!this.d && a()) {
                    b(false);
                    this.a = this.b.getFilesDir().getAbsolutePath() + "/YandexMetricaNativeCrashes";
                }
                this.d = true;
                if (b()) {
                    setUpNativeUncaughtExceptionHandler(this.a);
                    this.c = true;
                }
            } catch (Throwable th) {
                this.c = false;
            }
        } else {
            try {
                if (c()) {
                    cancelSetUpNativeUncaughtExceptionHandler();
                }
            } catch (Throwable th2) {
            }
            this.c = false;
        }
    }

    synchronized void a(ay ayVar, ExecutorService executorService) {
        if (c()) {
            executorService.execute(new a(ayVar, this));
            this.c = false;
        }
    }

    private boolean b() {
        return this.a != null;
    }

    private boolean c() {
        return b() && this.c;
    }

    private static boolean b(boolean z) {
        try {
            logsEnabled(z);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static class a implements Runnable {
        private final ay a;
        private final NativeCrashesHelper b;

        a(ay ayVar, NativeCrashesHelper nativeCrashesHelper) {
            this.b = nativeCrashesHelper;
            this.a = ayVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.b.a;
            for (String str2 : NativeCrashesHelper.a(str)) {
                String str3 = str + "/" + str2;
                try {
                    String strB = s.b(s.a(str3));
                    if (strB != null) {
                        this.a.a(strB);
                    }
                } catch (Exception e) {
                } finally {
                    new File(str3).delete();
                }
            }
        }
    }

    boolean a() {
        try {
            System.loadLibrary("YandexMetricaNativeModule");
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    static /* synthetic */ String[] a(String str) {
        File file = new File(str + "/");
        if (!file.mkdir() && !file.exists()) {
            return new String[0];
        }
        String[] list = file.list(new FilenameFilter() { // from class: com.yandex.metrica.impl.NativeCrashesHelper.1
            @Override // java.io.FilenameFilter
            public boolean accept(File dir, String filename) {
                return filename.endsWith(".dmp");
            }
        });
        return list == null ? new String[0] : list;
    }
}
