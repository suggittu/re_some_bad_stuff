package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

@Deprecated
/* loaded from: classes2.dex */
public class zzae {
    private static volatile Logger zzSV = new zzs();

    public static Logger getLogger() {
        return zzSV;
    }

    public static void setLogger(Logger logger) {
        zzSV = logger;
    }

    public static void v(String str) {
        zzaf zzafVarZzlx = zzaf.zzlx();
        if (zzafVarZzlx != null) {
            zzafVarZzlx.zzbd(str);
        } else if (zzQ(0)) {
            Log.v((String) zzy.zzRL.get(), str);
        }
        Logger logger = zzSV;
        if (logger != null) {
            logger.verbose(str);
        }
    }

    public static boolean zzQ(int i) {
        return getLogger() != null && getLogger().getLogLevel() <= i;
    }

    public static void zzaJ(String str) {
        zzaf zzafVarZzlx = zzaf.zzlx();
        if (zzafVarZzlx != null) {
            zzafVarZzlx.zzbf(str);
        } else if (zzQ(1)) {
            Log.i((String) zzy.zzRL.get(), str);
        }
        Logger logger = zzSV;
        if (logger != null) {
            logger.info(str);
        }
    }

    public static void zzaK(String str) {
        zzaf zzafVarZzlx = zzaf.zzlx();
        if (zzafVarZzlx != null) {
            zzafVarZzlx.zzbg(str);
        } else if (zzQ(2)) {
            Log.w((String) zzy.zzRL.get(), str);
        }
        Logger logger = zzSV;
        if (logger != null) {
            logger.warn(str);
        }
    }

    public static void zzf(String str, Object obj) {
        zzaf zzafVarZzlx = zzaf.zzlx();
        if (zzafVarZzlx != null) {
            zzafVarZzlx.zze(str, obj);
        } else if (zzQ(3)) {
            Log.e((String) zzy.zzRL.get(), obj != null ? str + ":" + obj : str);
        }
        Logger logger = zzSV;
        if (logger != null) {
            logger.error(str);
        }
    }
}
