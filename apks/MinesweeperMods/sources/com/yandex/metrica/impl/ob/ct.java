package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
class ct implements db {
    private static final String a = ct.class.getSimpleName();
    private final cy b = new cy();
    private File c;

    public ct(String str, String str2) throws IOException {
        b(str, str2);
    }

    @Override // com.yandex.metrica.impl.ob.db
    public synchronized Set<String> a(String str) {
        return this.b.a(str);
    }

    @Override // com.yandex.metrica.impl.ob.db
    public synchronized void a(String str, String[] strArr) {
        if (this.b.a(str) == null) {
            long jLastModified = this.c.lastModified();
            a(str, new HashSet(Arrays.asList(strArr)));
            this.c.setLastModified(jLastModified);
        }
    }

    @Override // com.yandex.metrica.impl.ob.db
    public synchronized boolean a(String str, String str2) {
        boolean zA;
        zA = this.b.a(str, str2);
        d();
        return zA;
    }

    @Override // com.yandex.metrica.impl.ob.db
    public synchronized void a(String str, Set<String> set) {
        this.b.a(str, set);
        d();
    }

    @Override // com.yandex.metrica.impl.ob.db
    public synchronized long a() {
        return this.c.lastModified();
    }

    @Override // com.yandex.metrica.impl.ob.db
    public void b() {
        this.c.setLastModified(System.currentTimeMillis());
    }

    private synchronized void b(String str, String str2) throws IOException {
        Map<String, Set<String>> mapC;
        this.c = new File(str, "sslpinningv1-" + str2);
        if (this.c.createNewFile()) {
            mapC = new HashMap<>();
            a(mapC);
            this.c.setLastModified(0L);
        } else {
            mapC = c();
        }
        this.b.a(mapC);
    }

    private synchronized Map<String, Set<String>> c() throws IOException {
        HashMap map;
        BufferedReader bufferedReader;
        HashSet hashSet = null;
        synchronized (this) {
            map = new HashMap();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.c)));
                try {
                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                        if (line.contains("type-")) {
                            String strSubstring = line.substring(5);
                            hashSet = new HashSet();
                            map.put(strSubstring, hashSet);
                        } else if (!TextUtils.isEmpty(line)) {
                            hashSet.add(line);
                        }
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        Log.e(a, e.getMessage());
                    }
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            Log.e(a, e2.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void a(java.util.Map<java.lang.String, java.util.Set<java.lang.String>> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r2 = 0
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L9c
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L9c
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L9c
            java.io.File r4 = r5.c     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L9c
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L9c
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L9c
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L9c
            java.util.Set r0 = r6.keySet()     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            java.util.Iterator r2 = r0.iterator()     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
        L1b:
            boolean r0 = r2.hasNext()     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            if (r0 == 0) goto L6a
            java.lang.Object r0 = r2.next()     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            java.lang.String r4 = "type-"
            r3.<init>(r4)     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            java.lang.StringBuilder r3 = r3.append(r0)     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            java.lang.String r3 = r3.toString()     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            r1.write(r3)     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            r1.newLine()     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            java.lang.Object r0 = r6.get(r0)     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            java.util.Set r0 = (java.util.Set) r0     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            java.util.Iterator r3 = r0.iterator()     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
        L46:
            boolean r0 = r3.hasNext()     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            if (r0 == 0) goto L1b
            java.lang.Object r0 = r3.next()     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            r1.write(r0)     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            r1.newLine()     // Catch: java.io.IOException -> L59 java.lang.Throwable -> L9a
            goto L46
        L59:
            r0 = move-exception
        L5a:
            java.lang.String r2 = com.yandex.metrica.impl.ob.ct.a     // Catch: java.lang.Throwable -> L9a
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L9a
            android.util.Log.e(r2, r0)     // Catch: java.lang.Throwable -> L9a
            if (r1 == 0) goto L68
            r1.close()     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
        L68:
            monitor-exit(r5)
            return
        L6a:
            r1.close()     // Catch: java.io.IOException -> L6e java.lang.Throwable -> L79
            goto L68
        L6e:
            r0 = move-exception
            java.lang.String r1 = com.yandex.metrica.impl.ob.ct.a     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L79
            android.util.Log.e(r1, r0)     // Catch: java.lang.Throwable -> L79
            goto L68
        L79:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L7c:
            r0 = move-exception
            java.lang.String r1 = com.yandex.metrica.impl.ob.ct.a     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L79
            android.util.Log.e(r1, r0)     // Catch: java.lang.Throwable -> L79
            goto L68
        L87:
            r0 = move-exception
            r1 = r2
        L89:
            if (r1 == 0) goto L8e
            r1.close()     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L8f
        L8e:
            throw r0     // Catch: java.lang.Throwable -> L79
        L8f:
            r1 = move-exception
            java.lang.String r2 = com.yandex.metrica.impl.ob.ct.a     // Catch: java.lang.Throwable -> L79
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L79
            android.util.Log.e(r2, r1)     // Catch: java.lang.Throwable -> L79
            goto L8e
        L9a:
            r0 = move-exception
            goto L89
        L9c:
            r0 = move-exception
            r1 = r2
            goto L5a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.ct.a(java.util.Map):void");
    }

    private synchronized void d() {
        a(this.b.c());
    }
}
