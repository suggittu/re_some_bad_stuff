package com.yandex.metrica.impl;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public interface d {

    public static class a<T> {
        public static final long a = TimeUnit.SECONDS.toMillis(10);
        private long b;
        private long c;
        private T d;
        private boolean e;

        public a() {
            this(a);
        }

        public a(long j) {
            this.c = 0L;
            this.d = null;
            this.e = true;
            this.b = j;
        }

        public final boolean a() {
            return this.e;
        }

        public T b() {
            return this.d;
        }

        public void a(T t) {
            this.d = t;
            this.c = System.currentTimeMillis();
            this.e = false;
        }

        public final boolean c() {
            return this.d == null;
        }

        public final boolean d() {
            long j = this.b;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.c;
            return jCurrentTimeMillis > j || jCurrentTimeMillis < 0;
        }
    }
}
