package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class zzk implements Handler.Callback {
    private final Handler mHandler;
    private final zza zzalQ;
    private final ArrayList zzalR = new ArrayList();
    final ArrayList zzalS = new ArrayList();
    private final ArrayList zzalT = new ArrayList();
    private volatile boolean zzalU = false;
    private final AtomicInteger zzalV = new AtomicInteger(0);
    private boolean zzalW = false;
    private final Object zzpV = new Object();

    public interface zza {
        boolean isConnected();

        Bundle zzoi();
    }

    public zzk(Looper looper, zza zzaVar) {
        this.zzalQ = zzaVar;
        this.mHandler = new Handler(looper, this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
            return false;
        }
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
        synchronized (this.zzpV) {
            if (this.zzalU && this.zzalQ.isConnected() && this.zzalR.contains(connectionCallbacks)) {
                connectionCallbacks.onConnected(this.zzalQ.zzoi());
            }
        }
        return true;
    }

    public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean zContains;
        zzx.zzz(connectionCallbacks);
        synchronized (this.zzpV) {
            zContains = this.zzalR.contains(connectionCallbacks);
        }
        return zContains;
    }

    public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean zContains;
        zzx.zzz(onConnectionFailedListener);
        synchronized (this.zzpV) {
            zContains = this.zzalT.contains(onConnectionFailedListener);
        }
        return zContains;
    }

    public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzx.zzz(connectionCallbacks);
        synchronized (this.zzpV) {
            if (this.zzalR.contains(connectionCallbacks)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + connectionCallbacks + " is already registered");
            } else {
                this.zzalR.add(connectionCallbacks);
            }
        }
        if (this.zzalQ.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzx.zzz(onConnectionFailedListener);
        synchronized (this.zzpV) {
            if (this.zzalT.contains(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + onConnectionFailedListener + " is already registered");
            } else {
                this.zzalT.add(onConnectionFailedListener);
            }
        }
    }

    public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzx.zzz(connectionCallbacks);
        synchronized (this.zzpV) {
            if (!this.zzalR.remove(connectionCallbacks)) {
                Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + connectionCallbacks + " not found");
            } else if (this.zzalW) {
                this.zzalS.add(connectionCallbacks);
            }
        }
    }

    public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzx.zzz(onConnectionFailedListener);
        synchronized (this.zzpV) {
            if (!this.zzalT.remove(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + onConnectionFailedListener + " not found");
            }
        }
    }

    public final void zzbT(int i) {
        zzx.zza(Looper.myLooper() == this.mHandler.getLooper(), "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.zzpV) {
            this.zzalW = true;
            ArrayList arrayList = new ArrayList(this.zzalR);
            int i2 = this.zzalV.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.zzalU || this.zzalV.get() != i2) {
                    break;
                } else if (this.zzalR.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.zzalS.clear();
            this.zzalW = false;
        }
    }

    public final void zzk(Bundle bundle) {
        zzx.zza(Looper.myLooper() == this.mHandler.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.zzpV) {
            zzx.zzab(!this.zzalW);
            this.mHandler.removeMessages(1);
            this.zzalW = true;
            zzx.zzab(this.zzalS.size() == 0);
            ArrayList arrayList = new ArrayList(this.zzalR);
            int i = this.zzalV.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.zzalU || !this.zzalQ.isConnected() || this.zzalV.get() != i) {
                    break;
                } else if (!this.zzalS.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.zzalS.clear();
            this.zzalW = false;
        }
    }

    public final void zzk(ConnectionResult connectionResult) {
        zzx.zza(Looper.myLooper() == this.mHandler.getLooper(), "onConnectionFailure must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.zzpV) {
            ArrayList arrayList = new ArrayList(this.zzalT);
            int i = this.zzalV.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener) it.next();
                if (!this.zzalU || this.zzalV.get() != i) {
                    return;
                }
                if (this.zzalT.contains(onConnectionFailedListener)) {
                    onConnectionFailedListener.onConnectionFailed(connectionResult);
                }
            }
        }
    }

    public final void zzqQ() {
        this.zzalU = false;
        this.zzalV.incrementAndGet();
    }

    public final void zzqR() {
        this.zzalU = true;
    }
}
