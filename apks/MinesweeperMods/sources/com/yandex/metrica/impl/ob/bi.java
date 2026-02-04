package com.yandex.metrica.impl.ob;

import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class bi {
    String a;
    private String b;
    private SSLSocketFactory c;
    private dp d = new dp() { // from class: com.yandex.metrica.impl.ob.bi.1
        @Override // com.yandex.metrica.impl.ob.dp
        public String a() {
            return bi.this.b;
        }
    };

    private static class a {
        static final bi a = new bi();
    }

    public static bi a() {
        return a.a;
    }

    bi() {
    }

    public synchronized SSLSocketFactory b() {
        return this.c;
    }

    public synchronized boolean c() {
        return this.c != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0025 A[Catch: all -> 0x0074, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x000c, B:9:0x0012, B:11:0x0018, B:16:0x0025, B:18:0x0038, B:19:0x004a, B:22:0x005b), top: B:31:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(android.content.Context r5, java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            r1 = 0
            r0 = 1
            monitor-enter(r4)
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L5b
            java.lang.String r2 = "https://certificate.mobile.yandex.net/api/v1/pins"
            r3 = r2
        Lc:
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L74
            if (r2 != 0) goto L72
            boolean r2 = r4.c()     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L70
            java.lang.String r2 = r4.a     // Catch: java.lang.Throwable -> L74
            boolean r2 = r3.equals(r2)     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L70
            r2 = r0
        L21:
            if (r2 != 0) goto L72
        L23:
            if (r0 == 0) goto L59
            r4.b = r6     // Catch: java.lang.Throwable -> L74
            r4.a = r3     // Catch: java.lang.Throwable -> L74
            com.yandex.metrica.impl.ob.dj r0 = new com.yandex.metrica.impl.ob.dj     // Catch: java.lang.Throwable -> L74
            com.yandex.metrica.impl.ob.dp r1 = r4.d     // Catch: java.lang.Throwable -> L74
            r2 = 1
            r3 = 1
            r0.<init>(r1, r2, r3)     // Catch: java.lang.Throwable -> L74
            java.security.cert.X509Certificate r1 = d()     // Catch: java.lang.Throwable -> L74
            if (r1 == 0) goto L59
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L74
            r2.<init>()     // Catch: java.lang.Throwable -> L74
            r2.add(r1)     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = r4.a     // Catch: java.lang.Throwable -> L74
            r0.a(r1, r2)     // Catch: java.lang.Throwable -> L74
            com.yandex.metrica.impl.ob.dc r1 = new com.yandex.metrica.impl.ob.dc     // Catch: java.lang.Throwable -> L74
            r1.<init>(r5, r0)     // Catch: java.lang.Throwable -> L74
            com.yandex.metrica.impl.ob.df r0 = new com.yandex.metrica.impl.ob.df     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            javax.net.ssl.SSLContext r0 = r0.a()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            javax.net.ssl.SSLSocketFactory r0 = r0.getSocketFactory()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            r4.c = r0     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
        L59:
            monitor-exit(r4)
            return
        L5b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r2.<init>()     // Catch: java.lang.Throwable -> L74
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch: java.lang.Throwable -> L74
            java.lang.String r3 = "/api/v1/pins"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L74
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L74
            r3 = r2
            goto Lc
        L70:
            r2 = r1
            goto L21
        L72:
            r0 = r1
            goto L23
        L74:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L77:
            r0 = move-exception
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.bi.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    private static X509Certificate d() {
        try {
            String[] strArrA = com.yandex.metrica.impl.ob.a.a();
            if (strArrA != null && strArrA.length > 0) {
                return dd.a(strArrA[0]);
            }
        } catch (Exception e) {
        }
        return null;
    }
}
