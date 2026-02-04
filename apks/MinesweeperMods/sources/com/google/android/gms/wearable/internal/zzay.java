package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.wearable.internal.zzax;
import com.google.android.gms.wearable.internal.zzbo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class zzay {
    private final Map zzaxd = new HashMap();

    class zza extends zzbo.zzb {
        private WeakReference zzbsM;
        private WeakReference zzbsN;

        zza(Map map, Object obj, zza.zzb zzbVar) {
            super(zzbVar);
            this.zzbsM = new WeakReference(map);
            this.zzbsN = new WeakReference(obj);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(Status status) {
            Map map = (Map) this.zzbsM.get();
            Object obj = this.zzbsN.get();
            if (!status.getStatus().isSuccess() && map != null && obj != null) {
                synchronized (map) {
                    zzbq zzbqVar = (zzbq) map.remove(obj);
                    if (zzbqVar != null) {
                        zzbqVar.clear();
                    }
                }
            }
            zzX(status);
        }
    }

    class zzb extends zzbo.zzb {
        private WeakReference zzbsM;
        private WeakReference zzbsN;

        zzb(Map map, Object obj, zza.zzb zzbVar) {
            super(zzbVar);
            this.zzbsM = new WeakReference(map);
            this.zzbsN = new WeakReference(obj);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(Status status) {
            Map map = (Map) this.zzbsM.get();
            Object obj = this.zzbsN.get();
            if (status.getStatus().getStatusCode() == 4002 && map != null && obj != null) {
                synchronized (map) {
                    zzbq zzbqVar = (zzbq) map.remove(obj);
                    if (zzbqVar != null) {
                        zzbqVar.clear();
                    }
                }
            }
            zzX(status);
        }
    }

    zzay() {
    }

    public final void zza(zzbp zzbpVar, zza.zzb zzbVar, Object obj) {
        synchronized (this.zzaxd) {
            zzbq zzbqVar = (zzbq) this.zzaxd.remove(obj);
            if (zzbqVar == null) {
                zzbVar.zzs(new Status(4002));
            } else {
                zzbqVar.clear();
                ((zzax) zzbpVar.zzqJ()).zza(new zzb(this.zzaxd, obj, zzbVar), new RemoveListenerRequest(zzbqVar));
            }
        }
    }

    public final void zza(zzbp zzbpVar, zza.zzb zzbVar, Object obj, zzbq zzbqVar) {
        synchronized (this.zzaxd) {
            if (this.zzaxd.get(obj) != null) {
                zzbVar.zzs(new Status(4001));
                return;
            }
            this.zzaxd.put(obj, zzbqVar);
            try {
                ((zzax) zzbpVar.zzqJ()).zza(new zza(this.zzaxd, obj, zzbVar), new AddListenerRequest(zzbqVar));
            } catch (RemoteException e) {
                this.zzaxd.remove(obj);
                throw e;
            }
        }
    }

    public final void zzev(IBinder iBinder) {
        synchronized (this.zzaxd) {
            zzax zzaxVarZzeu = zzax.zza.zzeu(iBinder);
            zzbo.zzo zzoVar = new zzbo.zzo();
            for (Map.Entry entry : this.zzaxd.entrySet()) {
                zzbq zzbqVar = (zzbq) entry.getValue();
                try {
                    zzaxVarZzeu.zza(zzoVar, new AddListenerRequest(zzbqVar));
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: added: " + entry.getKey() + "/" + zzbqVar);
                    }
                } catch (RemoteException e) {
                    Log.d("WearableClient", "onPostInitHandler: Didn't add: " + entry.getKey() + "/" + zzbqVar);
                }
            }
        }
    }
}
