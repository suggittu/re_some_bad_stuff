package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzpl;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public abstract class zza {

    /* renamed from: com.google.android.gms.flags.impl.zza$zza, reason: collision with other inner class name */
    public class C0070zza extends zza {
        public static Boolean zza(final SharedPreferences sharedPreferences, final String str, final Boolean bool) {
            return (Boolean) zzpl.zzb(new Callable() { // from class: com.google.android.gms.flags.impl.zza.zza.1
                @Override // java.util.concurrent.Callable
                /* renamed from: zzvt, reason: merged with bridge method [inline-methods] */
                public final Boolean call() {
                    return Boolean.valueOf(sharedPreferences.getBoolean(str, bool.booleanValue()));
                }
            });
        }
    }

    public class zzb extends zza {
        public static Integer zza(final SharedPreferences sharedPreferences, final String str, final Integer num) {
            return (Integer) zzpl.zzb(new Callable() { // from class: com.google.android.gms.flags.impl.zza.zzb.1
                @Override // java.util.concurrent.Callable
                /* renamed from: zzvu, reason: merged with bridge method [inline-methods] */
                public final Integer call() {
                    return Integer.valueOf(sharedPreferences.getInt(str, num.intValue()));
                }
            });
        }
    }

    public class zzc extends zza {
        public static Long zza(final SharedPreferences sharedPreferences, final String str, final Long l) {
            return (Long) zzpl.zzb(new Callable() { // from class: com.google.android.gms.flags.impl.zza.zzc.1
                @Override // java.util.concurrent.Callable
                /* renamed from: zzvv, reason: merged with bridge method [inline-methods] */
                public final Long call() {
                    return Long.valueOf(sharedPreferences.getLong(str, l.longValue()));
                }
            });
        }
    }

    public class zzd extends zza {
        public static String zza(final SharedPreferences sharedPreferences, final String str, final String str2) {
            return (String) zzpl.zzb(new Callable() { // from class: com.google.android.gms.flags.impl.zza.zzd.1
                @Override // java.util.concurrent.Callable
                /* renamed from: zzkp, reason: merged with bridge method [inline-methods] */
                public final String call() {
                    return sharedPreferences.getString(str, str2);
                }
            });
        }
    }
}
