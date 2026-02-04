package com.yandex.metrica.impl.ob;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.yandex.metrica.impl.ob.ea;
import java.lang.Thread;

/* loaded from: classes.dex */
public class dy {
    private dw a;
    private HandlerThread b;
    private b c;
    private volatile Handler d;

    public dy(dw dwVar) {
        this(dwVar, null);
    }

    public dy(dw dwVar, Handler handler) {
        this.a = dwVar;
        this.b = new HandlerThread(dy.class.getSimpleName() + '@' + Integer.toHexString(hashCode()));
        this.d = handler;
    }

    public <T> void a(ea<T> eaVar, ea.b<T> bVar, ea.a aVar) {
        a();
        eaVar.a(bVar);
        eaVar.a(aVar);
        this.c.a(eaVar);
    }

    private synchronized void a() {
        if (this.b.getState() == Thread.State.NEW) {
            this.b.start();
            Looper looper = this.b.getLooper();
            this.c = new b(this, looper, (byte) 0);
            if (this.d == null) {
                this.d = new Handler(looper);
            }
        }
    }

    private class b extends Handler {
        /* synthetic */ b(dy dyVar, Looper looper, byte b) {
            this(looper);
        }

        private b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            byte b = 0;
            ea<?> eaVar = (ea) msg.obj;
            ea.b<?> bVarE = eaVar.e();
            try {
                dy.this.d.post(new c(bVarE, eaVar.b(dy.this.a.a(eaVar)), (byte) 0));
            } catch (dx e) {
                dy.this.d.post(new a(eaVar.f(), e, b));
            }
        }

        public <T> void a(ea<T> eaVar) {
            Message message = new Message();
            message.obj = eaVar;
            sendMessage(message);
        }
    }

    private static class c<T> implements Runnable {
        private ea.b<T> a;
        private T b;

        /* synthetic */ c(ea.b bVar, Object obj, byte b) {
            this(bVar, obj);
        }

        private c(ea.b bVar, T t) {
            this.a = bVar;
            this.b = t;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a != null) {
                this.a.a(this.b);
            }
        }
    }

    private static class a implements Runnable {
        private ea.a a;
        private dx b;

        /* synthetic */ a(ea.a aVar, dx dxVar, byte b) {
            this(aVar, dxVar);
        }

        private a(ea.a aVar, dx dxVar) {
            this.a = aVar;
            this.b = dxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a != null) {
                this.a.a(this.b);
            }
        }
    }
}
