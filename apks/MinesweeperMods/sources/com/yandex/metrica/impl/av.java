package com.yandex.metrica.impl;

import android.database.Cursor;
import com.yandex.metrica.c;
import com.yandex.metrica.impl.au;

/* loaded from: classes.dex */
class av extends au {
    public av(com.yandex.metrica.impl.ob.i iVar) {
        super(iVar);
    }

    protected long n() {
        return Long.MIN_VALUE;
    }

    protected long o() {
        return Long.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013 A[Catch: all -> 0x0058, Exception -> 0x0062, TRY_LEAVE, TryCatch #6 {Exception -> 0x0062, all -> 0x0058, blocks: (B:5:0x0007, B:7:0x000d, B:9:0x0013), top: B:34:0x0007 }] */
    @Override // com.yandex.metrica.impl.au
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected com.yandex.metrica.impl.au.c r() throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            android.database.Cursor r1 = r7.t()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4c
            if (r1 == 0) goto L13
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L62
            if (r2 == 0) goto L13
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L62
            if (r2 != 0) goto L38
        L13:
            com.yandex.metrica.impl.ob.bc r2 = r7.n     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L62
            long r4 = r7.n()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L62
            com.yandex.metrica.impl.ob.az r3 = com.yandex.metrica.impl.ob.az.BACKGROUND     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L62
            android.database.Cursor r0 = r2.b(r4, r3)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L62
            if (r0 == 0) goto L38
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L67
            if (r2 == 0) goto L38
            int r2 = r0.getCount()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L67
            if (r2 <= 0) goto L38
            com.yandex.metrica.impl.ob.bc r2 = r7.n     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L67
            long r4 = r7.n()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L67
            com.yandex.metrica.impl.ob.az r3 = com.yandex.metrica.impl.ob.az.BACKGROUND     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L67
            r2.a(r4, r3)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L67
        L38:
            com.yandex.metrica.impl.bk.a(r1)
            com.yandex.metrica.impl.bk.a(r0)
        L3e:
            com.yandex.metrica.impl.au$c r0 = super.r()
            return r0
        L43:
            r1 = move-exception
            r1 = r0
        L45:
            com.yandex.metrica.impl.bk.a(r0)
            com.yandex.metrica.impl.bk.a(r1)
            goto L3e
        L4c:
            r1 = move-exception
            r2 = r0
            r6 = r0
            r0 = r1
            r1 = r6
        L51:
            com.yandex.metrica.impl.bk.a(r1)
            com.yandex.metrica.impl.bk.a(r2)
            throw r0
        L58:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L51
        L5d:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L51
        L62:
            r2 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L45
        L67:
            r2 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.av.r():com.yandex.metrica.impl.au$c");
    }

    @Override // com.yandex.metrica.impl.au
    protected Cursor t() {
        return this.n.a(n(), this.b);
    }

    @Override // com.yandex.metrica.impl.au
    protected Cursor a(long j, com.yandex.metrica.impl.ob.az azVar) {
        return this.n.b(n(), azVar);
    }

    @Override // com.yandex.metrica.impl.au
    protected boolean a(long j) {
        return false;
    }

    @Override // com.yandex.metrica.impl.au
    protected au.b a(long j, c.a.g.b bVar) {
        return super.a(o(), bVar);
    }

    @Override // com.yandex.metrica.impl.l, com.yandex.metrica.impl.ah
    public String a() {
        return super.a() + " [" + n() + "]";
    }
}
