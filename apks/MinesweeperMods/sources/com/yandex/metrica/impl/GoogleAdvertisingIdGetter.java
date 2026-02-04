package com.yandex.metrica.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Pair;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public class GoogleAdvertisingIdGetter {
    private volatile String a = null;
    private volatile Boolean b = null;
    private final Object c = new Object();
    private volatile FutureTask<Pair<String, Boolean>> d;

    /* JADX INFO: Access modifiers changed from: private */
    static class b {
        static final GoogleAdvertisingIdGetter a = new GoogleAdvertisingIdGetter();
    }

    private interface c<T> {
        T b(Future<Pair<String, Boolean>> future) throws ExecutionException, InterruptedException;
    }

    public static GoogleAdvertisingIdGetter a() {
        return b.a;
    }

    public void a(final Context context) {
        if (this.d == null) {
            synchronized (this.c) {
                if (this.d == null) {
                    this.d = new FutureTask<>(new Callable<Pair<String, Boolean>>() { // from class: com.yandex.metrica.impl.GoogleAdvertisingIdGetter.1
                        @Override // java.util.concurrent.Callable
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public Pair<String, Boolean> call() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                            Context applicationContext = context.getApplicationContext();
                            if (GoogleAdvertisingIdGetter.d(applicationContext)) {
                                GoogleAdvertisingIdGetter.a(b.a, applicationContext);
                            }
                            if (!GoogleAdvertisingIdGetter.this.d()) {
                                GoogleAdvertisingIdGetter.b(b.a, applicationContext);
                            }
                            return new Pair<>(GoogleAdvertisingIdGetter.this.a, GoogleAdvertisingIdGetter.this.b);
                        }
                    });
                    new Thread(this.d).start();
                }
            }
        }
    }

    private <T> T a(Context context, c<T> cVar) {
        a(context);
        try {
            return cVar.b(this.d);
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    public String b(Context context) {
        return (String) a(context, new c<String>() { // from class: com.yandex.metrica.impl.GoogleAdvertisingIdGetter.2
            @Override // com.yandex.metrica.impl.GoogleAdvertisingIdGetter.c
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b(Future<Pair<String, Boolean>> future) throws ExecutionException, InterruptedException {
                return (String) future.get().first;
            }
        });
    }

    public String b() {
        return this.a;
    }

    public Boolean c() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean d() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = r1.a     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto Lc
            java.lang.Boolean r0 = r1.b     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto Lc
            r0 = 1
        La:
            monitor-exit(r1)
            return r0
        Lc:
            r0 = 0
            goto La
        Le:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.GoogleAdvertisingIdGetter.d():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        try {
            return Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", Context.class).invoke(null, context).equals(0);
        } catch (Exception e) {
            return false;
        }
    }

    private interface GoogleAdvertisingInfo extends IInterface {
        boolean getEnabled(boolean z) throws RemoteException;

        String getId() throws RemoteException;

        public static abstract class GoogleAdvertisingInfoBinder extends Binder implements GoogleAdvertisingInfo {
            public static GoogleAdvertisingInfo Create(IBinder binder) {
                if (binder == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof GoogleAdvertisingInfo)) {
                    return (GoogleAdvertisingInfo) iInterfaceQueryLocalInterface;
                }
                return new GoogleAdvertisingInfoImplementation(binder);
            }

            @Override // android.os.Binder
            public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
                switch (code) {
                    case 1:
                        data.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        String id = getId();
                        reply.writeNoException();
                        reply.writeString(id);
                        return true;
                    case 2:
                        data.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        boolean enabled = getEnabled(data.readInt() != 0);
                        reply.writeNoException();
                        reply.writeInt(enabled ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(code, data, reply, flags);
                }
            }

            private static class GoogleAdvertisingInfoImplementation implements GoogleAdvertisingInfo {
                private IBinder a;

                GoogleAdvertisingInfoImplementation(IBinder binder) {
                    this.a = binder;
                }

                @Override // android.os.IInterface
                public IBinder asBinder() {
                    return this.a;
                }

                @Override // com.yandex.metrica.impl.GoogleAdvertisingIdGetter.GoogleAdvertisingInfo
                public String getId() throws RemoteException {
                    Parcel parcelObtain = Parcel.obtain();
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        this.a.transact(1, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        return parcelObtain2.readString();
                    } finally {
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                }

                @Override // com.yandex.metrica.impl.GoogleAdvertisingIdGetter.GoogleAdvertisingInfo
                public boolean getEnabled(boolean paramBoolean) throws RemoteException {
                    Parcel parcelObtain = Parcel.obtain();
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        parcelObtain.writeInt(paramBoolean ? 1 : 0);
                        this.a.transact(2, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        return parcelObtain2.readInt() != 0;
                    } finally {
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                }
            }
        }
    }

    private class a implements ServiceConnection {
        private boolean a;
        private final BlockingQueue<IBinder> b;

        private a() {
            this.a = false;
            this.b = new LinkedBlockingQueue();
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) throws InterruptedException {
            try {
                this.b.put(service);
            } catch (InterruptedException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
        }

        public IBinder a() throws InterruptedException {
            if (this.a) {
                throw new IllegalStateException();
            }
            this.a = true;
            return this.b.take();
        }
    }

    static /* synthetic */ void a(GoogleAdvertisingIdGetter googleAdvertisingIdGetter, Context context) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context);
            Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            String str = (String) cls.getMethod("getId", new Class[0]).invoke(objInvoke, new Object[0]);
            Boolean bool = (Boolean) cls.getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(objInvoke, new Object[0]);
            synchronized (googleAdvertisingIdGetter) {
                googleAdvertisingIdGetter.a = str;
                googleAdvertisingIdGetter.b = bool;
            }
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void b(GoogleAdvertisingIdGetter googleAdvertisingIdGetter, Context context) {
        a aVar = new a((byte) 0);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, aVar, 1)) {
            try {
                GoogleAdvertisingInfo googleAdvertisingInfoCreate = GoogleAdvertisingInfo.GoogleAdvertisingInfoBinder.Create(aVar.a());
                String id = googleAdvertisingInfoCreate.getId();
                Boolean boolValueOf = Boolean.valueOf(googleAdvertisingInfoCreate.getEnabled(true));
                synchronized (googleAdvertisingIdGetter) {
                    googleAdvertisingIdGetter.a = id;
                    googleAdvertisingIdGetter.b = boolValueOf;
                }
            } catch (Exception e) {
            } finally {
                context.unbindService(aVar);
            }
        }
    }
}
