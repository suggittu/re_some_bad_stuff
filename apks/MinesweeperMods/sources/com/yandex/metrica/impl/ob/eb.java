package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.ea;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class eb<T> implements ea.a, ea.b<T>, Future<T> {
    private boolean a = false;
    private T b;
    private dx c;

    public static <E> eb<E> a() {
        return new eb<>();
    }

    private eb() {
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        try {
            return a((Long) null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(timeout, unit)));
    }

    private synchronized T a(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        T t;
        if (this.c != null) {
            throw new ExecutionException(this.c);
        }
        if (this.a) {
            t = this.b;
        } else {
            if (l == null) {
                wait(0L);
            } else if (l.longValue() > 0) {
                wait(l.longValue());
            }
            if (this.c != null) {
                throw new ExecutionException(this.c);
            }
            if (!this.a) {
                throw new TimeoutException();
            }
            t = this.b;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000f  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean isDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.a     // Catch: java.lang.Throwable -> L14
            if (r0 != 0) goto Lf
            com.yandex.metrica.impl.ob.dx r0 = r1.c     // Catch: java.lang.Throwable -> L14
            if (r0 != 0) goto Lf
            boolean r0 = r1.isCancelled()     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto L12
        Lf:
            r0 = 1
        L10:
            monitor-exit(r1)
            return r0
        L12:
            r0 = 0
            goto L10
        L14:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.eb.isDone():boolean");
    }

    @Override // com.yandex.metrica.impl.ob.ea.b
    public synchronized void a(T t) {
        this.a = true;
        this.b = t;
        notifyAll();
    }

    @Override // com.yandex.metrica.impl.ob.ea.a
    public synchronized void a(dx dxVar) {
        this.c = dxVar;
        notifyAll();
    }
}
