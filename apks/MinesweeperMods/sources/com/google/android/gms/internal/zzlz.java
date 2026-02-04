package com.google.android.gms.internal;

import android.os.Binder;

/* loaded from: classes2.dex */
public abstract class zzlz {
    private Object zzSC = null;
    protected final String zzvs;
    protected final Object zzvt;
    private static final Object zzqy = new Object();
    private static zza zzaiV = null;
    private static int zzaiW = 0;
    private static String zzaiX = "com.google.android.providers.gsf.permission.READ_GSERVICES";

    interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Float zzb(String str, Float f);

        Integer zzb(String str, Integer num);
    }

    protected zzlz(String str, Object obj) {
        this.zzvs = str;
        this.zzvt = obj;
    }

    public static boolean isInitialized() {
        return zzaiV != null;
    }

    public static zzlz zza(String str, Float f) {
        return new zzlz(str, f) { // from class: com.google.android.gms.internal.zzlz.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlz
            /* renamed from: zzcx, reason: merged with bridge method [inline-methods] */
            public final Float zzct(String str2) {
                return zzlz.zzaiV.zzb(this.zzvs, (Float) this.zzvt);
            }
        };
    }

    public static zzlz zza(String str, Integer num) {
        return new zzlz(str, num) { // from class: com.google.android.gms.internal.zzlz.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlz
            /* renamed from: zzcw, reason: merged with bridge method [inline-methods] */
            public final Integer zzct(String str2) {
                return zzlz.zzaiV.zzb(this.zzvs, (Integer) this.zzvt);
            }
        };
    }

    public static zzlz zza(String str, Long l) {
        return new zzlz(str, l) { // from class: com.google.android.gms.internal.zzlz.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlz
            /* renamed from: zzcv, reason: merged with bridge method [inline-methods] */
            public final Long zzct(String str2) {
                return zzlz.zzaiV.getLong(this.zzvs, (Long) this.zzvt);
            }
        };
    }

    public static zzlz zzk(String str, boolean z) {
        return new zzlz(str, Boolean.valueOf(z)) { // from class: com.google.android.gms.internal.zzlz.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlz
            /* renamed from: zzcu, reason: merged with bridge method [inline-methods] */
            public final Boolean zzct(String str2) {
                return zzlz.zzaiV.zza(this.zzvs, (Boolean) this.zzvt);
            }
        };
    }

    public static int zzpW() {
        return zzaiW;
    }

    public static zzlz zzv(String str, String str2) {
        return new zzlz(str, str2) { // from class: com.google.android.gms.internal.zzlz.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlz
            /* renamed from: zzcy, reason: merged with bridge method [inline-methods] */
            public final String zzct(String str3) {
                return zzlz.zzaiV.getString(this.zzvs, (String) this.zzvt);
            }
        };
    }

    public final Object get() {
        return this.zzSC != null ? this.zzSC : zzct(this.zzvs);
    }

    protected abstract Object zzct(String str);

    public final Object zzpX() {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            return get();
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }
}
