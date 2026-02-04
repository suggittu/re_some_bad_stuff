package com.yandex.metrica.impl;

import android.os.Handler;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class y implements Runnable {
    private final WeakReference<Handler> a;
    private final WeakReference<c> b;

    y(Handler handler, c cVar) {
        this.a = new WeakReference<>(handler);
        this.b = new WeakReference<>(cVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler = this.a.get();
        c cVar = this.b.get();
        if (handler != null && cVar != null && cVar.c()) {
            x.a(handler, cVar, this);
        }
    }
}
