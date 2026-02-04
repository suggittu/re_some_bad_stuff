package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
final class zzm extends zzl implements Handler.Callback {
    private final Handler mHandler;
    private final HashMap zzalZ = new HashMap();
    private final com.google.android.gms.common.stats.zzb zzama = com.google.android.gms.common.stats.zzb.zzrP();
    private final long zzamb = 5000;
    private final Context zzsa;

    final class zza {
        private final String zzSU;
        private final ComponentName zzamc;

        public zza(ComponentName componentName) {
            this.zzSU = null;
            this.zzamc = (ComponentName) zzx.zzz(componentName);
        }

        public zza(String str) {
            this.zzSU = zzx.zzcM(str);
            this.zzamc = null;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return zzw.equal(this.zzSU, zzaVar.zzSU) && zzw.equal(this.zzamc, zzaVar.zzamc);
        }

        public final int hashCode() {
            return zzw.hashCode(this.zzSU, this.zzamc);
        }

        public final String toString() {
            return this.zzSU == null ? this.zzamc.flattenToString() : this.zzSU;
        }

        public final Intent zzqS() {
            return this.zzSU != null ? new Intent(this.zzSU).setPackage("com.google.android.gms") : new Intent().setComponent(this.zzamc);
        }
    }

    final class zzb {
        private IBinder zzakD;
        private ComponentName zzamc;
        private boolean zzamf;
        private final zza zzamg;
        private final zza zzamd = new zza();
        private final Set zzame = new HashSet();
        private int mState = 2;

        public class zza implements ServiceConnection {
            public zza() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (zzm.this.zzalZ) {
                    zzb.this.zzakD = iBinder;
                    zzb.this.zzamc = componentName;
                    Iterator it = zzb.this.zzame.iterator();
                    while (it.hasNext()) {
                        ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                    }
                    zzb.this.mState = 1;
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (zzm.this.zzalZ) {
                    zzb.this.zzakD = null;
                    zzb.this.zzamc = componentName;
                    Iterator it = zzb.this.zzame.iterator();
                    while (it.hasNext()) {
                        ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                    }
                    zzb.this.mState = 2;
                }
            }
        }

        public zzb(zza zzaVar) {
            this.zzamg = zzaVar;
        }

        public final IBinder getBinder() {
            return this.zzakD;
        }

        public final ComponentName getComponentName() {
            return this.zzamc;
        }

        public final int getState() {
            return this.mState;
        }

        public final boolean isBound() {
            return this.zzamf;
        }

        public final void zza(ServiceConnection serviceConnection, String str) {
            zzm.this.zzama.zza(zzm.this.zzsa, serviceConnection, str, this.zzamg.zzqS());
            this.zzame.add(serviceConnection);
        }

        public final boolean zza(ServiceConnection serviceConnection) {
            return this.zzame.contains(serviceConnection);
        }

        public final void zzb(ServiceConnection serviceConnection, String str) {
            zzm.this.zzama.zzb(zzm.this.zzsa, serviceConnection);
            this.zzame.remove(serviceConnection);
        }

        @TargetApi(14)
        public final void zzcH(String str) {
            this.mState = 3;
            this.zzamf = zzm.this.zzama.zza(zzm.this.zzsa, str, this.zzamg.zzqS(), this.zzamd, 129);
            if (this.zzamf) {
                return;
            }
            this.mState = 2;
            try {
                zzm.this.zzama.zza(zzm.this.zzsa, this.zzamd);
            } catch (IllegalArgumentException e) {
            }
        }

        public final void zzcI(String str) {
            zzm.this.zzama.zza(zzm.this.zzsa, this.zzamd);
            this.zzamf = false;
            this.mState = 2;
        }

        public final boolean zzqT() {
            return this.zzame.isEmpty();
        }
    }

    zzm(Context context) {
        this.zzsa = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
    }

    private boolean zza(zza zzaVar, ServiceConnection serviceConnection, String str) {
        boolean zIsBound;
        zzx.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzalZ) {
            zzb zzbVar = (zzb) this.zzalZ.get(zzaVar);
            if (zzbVar != null) {
                this.mHandler.removeMessages(0, zzbVar);
                if (!zzbVar.zza(serviceConnection)) {
                    zzbVar.zza(serviceConnection, str);
                    switch (zzbVar.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzbVar.getComponentName(), zzbVar.getBinder());
                            break;
                        case 2:
                            zzbVar.zzcH(str);
                            break;
                    }
                } else {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zzaVar);
                }
            } else {
                zzbVar = new zzb(zzaVar);
                zzbVar.zza(serviceConnection, str);
                zzbVar.zzcH(str);
                this.zzalZ.put(zzaVar, zzbVar);
            }
            zIsBound = zzbVar.isBound();
        }
        return zIsBound;
    }

    private void zzb(zza zzaVar, ServiceConnection serviceConnection, String str) {
        zzx.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzalZ) {
            zzb zzbVar = (zzb) this.zzalZ.get(zzaVar);
            if (zzbVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + zzaVar);
            }
            if (!zzbVar.zza(serviceConnection)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zzaVar);
            }
            zzbVar.zzb(serviceConnection, str);
            if (zzbVar.zzqT()) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zzbVar), this.zzamb);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                zzb zzbVar = (zzb) message.obj;
                synchronized (this.zzalZ) {
                    if (zzbVar.zzqT()) {
                        if (zzbVar.isBound()) {
                            zzbVar.zzcI("GmsClientSupervisor");
                        }
                        this.zzalZ.remove(zzbVar.zzamg);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    @Override // com.google.android.gms.common.internal.zzl
    public final boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName), serviceConnection, str);
    }

    @Override // com.google.android.gms.common.internal.zzl
    public final boolean zza(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str), serviceConnection, str2);
    }

    @Override // com.google.android.gms.common.internal.zzl
    public final void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName), serviceConnection, str);
    }

    @Override // com.google.android.gms.common.internal.zzl
    public final void zzb(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str), serviceConnection, str2);
    }
}
