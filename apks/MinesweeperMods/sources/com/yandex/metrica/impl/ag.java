package com.yandex.metrica.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
class ag extends Thread {
    private final Executor a;
    private volatile b e;
    private final BlockingQueue<b> c = new LinkedBlockingQueue();
    private final Object d = new Object();
    private Executor b = new com.yandex.metrica.impl.ob.bh();

    public ag(Executor executor) {
        this.a = executor;
    }

    public void a(ah ahVar) {
        synchronized (this.d) {
            b bVar = new b(ahVar, (byte) 0);
            if (!a(bVar)) {
                this.c.offer(bVar);
            }
        }
    }

    public void a() {
        this.e = null;
        this.c.clear();
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Executor executor;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                this.e = this.c.take();
                ah ahVar = this.e.a;
                if (ahVar.m()) {
                    executor = this.a;
                } else {
                    executor = this.b;
                }
                executor.execute(new a(this, ahVar, (byte) 0));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                this.e = null;
            }
        }
    }

    public boolean b(ah ahVar) {
        return a(new b(ahVar, (byte) 0));
    }

    private boolean a(b bVar) {
        return this.c.contains(bVar) || bVar.equals(this.e);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x001d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void c(com.yandex.metrica.impl.ah r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ag.c(com.yandex.metrica.impl.ah):void");
    }

    private static class b {
        private final ah a;
        private final String b;

        /* synthetic */ b(ah ahVar, byte b) {
            this(ahVar);
        }

        private b(ah ahVar) {
            this.a = ahVar;
            this.b = ahVar.a();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return this.b.equals(((b) o).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }
    }

    private class a implements Runnable {
        private final ah b;

        /* synthetic */ a(ag agVar, ah ahVar, byte b) {
            this(ahVar);
        }

        private a(ah ahVar) {
            this.b = ahVar;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                ag.this.c(this.b);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
