package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.internal.zzqn;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes2.dex */
public final class zzqk extends com.google.android.gms.common.internal.zzj {
    private final long zzaEg;

    final class zza extends zzb {
        private final zza.zzb zzamC;

        public zza(zza.zzb zzbVar, com.google.android.gms.common.api.internal.zzq zzqVar) {
            super(zzqVar);
            this.zzamC = (zza.zzb) com.google.android.gms.common.internal.zzx.zzz(zzbVar);
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public final void zziZ(int i) {
            this.zzamC.zzs(new Status(i));
        }
    }

    class zzb extends zzqj {
        private final com.google.android.gms.common.api.internal.zzq zzbbb;

        zzb(com.google.android.gms.common.api.internal.zzq zzqVar) {
            this.zzbbb = zzqVar;
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public void onDisconnected(final String str) {
            this.zzbbb.zza(new zzq.zzb() { // from class: com.google.android.gms.internal.zzqk.zzb.2
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(Connections.MessageListener messageListener) {
                    messageListener.onDisconnected(str);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public void onMessageReceived(final String str, final byte[] bArr, final boolean z) {
            this.zzbbb.zza(new zzq.zzb() { // from class: com.google.android.gms.internal.zzqk.zzb.1
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(Connections.MessageListener messageListener) {
                    messageListener.onMessageReceived(str, bArr, z);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }
    }

    class zzc extends zzqj {
        private final zza.zzb zzbbf;

        zzc(zza.zzb zzbVar) {
            this.zzbbf = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public void zzja(int i) {
            this.zzbbf.zzs(new Status(i));
        }
    }

    final class zzd extends zzb {
        private final zza.zzb zzamC;
        private final com.google.android.gms.common.api.internal.zzq zzbbg;

        public zzd(zza.zzb zzbVar, com.google.android.gms.common.api.internal.zzq zzqVar, com.google.android.gms.common.api.internal.zzq zzqVar2) {
            super(zzqVar2);
            this.zzamC = (zza.zzb) com.google.android.gms.common.internal.zzx.zzz(zzbVar);
            this.zzbbg = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public final void zza(final String str, final int i, final byte[] bArr) {
            this.zzbbg.zza(new zzq.zzb() { // from class: com.google.android.gms.internal.zzqk.zzd.1
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(Connections.ConnectionResponseCallback connectionResponseCallback) {
                    connectionResponseCallback.onConnectionResponse(str, new Status(i), bArr);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public final void zziY(int i) {
            this.zzamC.zzs(new Status(i));
        }
    }

    final class zze extends zzqj {
        private final zza.zzb zzamC;
        private final com.google.android.gms.common.api.internal.zzq zzbbi;

        zze(zza.zzb zzbVar, com.google.android.gms.common.api.internal.zzq zzqVar) {
            this.zzamC = (zza.zzb) com.google.android.gms.common.internal.zzx.zzz(zzbVar);
            this.zzbbi = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public final void onConnectionRequest(final String str, final String str2, final String str3, final byte[] bArr) {
            this.zzbbi.zza(new zzq.zzb() { // from class: com.google.android.gms.internal.zzqk.zze.1
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(Connections.ConnectionRequestListener connectionRequestListener) {
                    connectionRequestListener.onConnectionRequest(str, str2, str3, bArr);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public final void zzm(int i, String str) {
            this.zzamC.zzs(new zzf(new Status(i), str));
        }
    }

    final class zzf implements Connections.StartAdvertisingResult {
        private final Status zzUX;
        private final String zzbbm;

        zzf(Status status, String str) {
            this.zzUX = status;
            this.zzbbm = str;
        }

        @Override // com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult
        public final String getLocalEndpointName() {
            return this.zzbbm;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    final class zzg extends zzqj {
        private final zza.zzb zzamC;
        private final com.google.android.gms.common.api.internal.zzq zzbbi;

        zzg(zza.zzb zzbVar, com.google.android.gms.common.api.internal.zzq zzqVar) {
            this.zzamC = (zza.zzb) com.google.android.gms.common.internal.zzx.zzz(zzbVar);
            this.zzbbi = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public final void onEndpointFound(final String str, final String str2, final String str3, final String str4) {
            this.zzbbi.zza(new zzq.zzb() { // from class: com.google.android.gms.internal.zzqk.zzg.1
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointFound(str, str2, str3, str4);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public final void onEndpointLost(final String str) {
            this.zzbbi.zza(new zzq.zzb() { // from class: com.google.android.gms.internal.zzqk.zzg.2
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointLost(str);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public final void zziW(int i) {
            this.zzamC.zzs(new Status(i));
        }
    }

    public zzqk(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzaEg = hashCode();
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public final void disconnect() {
        if (isConnected()) {
            try {
                ((zzqn) zzqJ()).zzF(this.zzaEg);
            } catch (RemoteException e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        super.disconnect();
    }

    public final String zzEj() {
        try {
            return ((zzqn) zzqJ()).zzaj(this.zzaEg);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public final String zzEk() {
        try {
            return ((zzqn) zzqJ()).zzEk();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public final void zzEl() {
        try {
            ((zzqn) zzqJ()).zzag(this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", e);
        }
    }

    public final void zzEm() {
        try {
            ((zzqn) zzqJ()).zzai(this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", e);
        }
    }

    public final void zza(zza.zzb zzbVar, String str, long j, com.google.android.gms.common.api.internal.zzq zzqVar) {
        ((zzqn) zzqJ()).zza(new zzg(zzbVar, zzqVar), str, j, this.zzaEg);
    }

    public final void zza(zza.zzb zzbVar, String str, AppMetadata appMetadata, long j, com.google.android.gms.common.api.internal.zzq zzqVar) {
        ((zzqn) zzqJ()).zza(new zze(zzbVar, zzqVar), str, appMetadata, j, this.zzaEg);
    }

    public final void zza(zza.zzb zzbVar, String str, String str2, byte[] bArr, com.google.android.gms.common.api.internal.zzq zzqVar, com.google.android.gms.common.api.internal.zzq zzqVar2) {
        ((zzqn) zzqJ()).zza(new zzd(zzbVar, zzqVar, zzqVar2), str, str2, bArr, this.zzaEg);
    }

    public final void zza(zza.zzb zzbVar, String str, byte[] bArr, com.google.android.gms.common.api.internal.zzq zzqVar) {
        ((zzqn) zzqJ()).zza(new zza(zzbVar, zzqVar), str, bArr, this.zzaEg);
    }

    public final void zza(String[] strArr, byte[] bArr) {
        try {
            ((zzqn) zzqJ()).zza(strArr, bArr, this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", e);
        }
    }

    public final void zzb(String[] strArr, byte[] bArr) {
        try {
            ((zzqn) zzqJ()).zzb(strArr, bArr, this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzdv, reason: merged with bridge method [inline-methods] */
    public final zzqn zzW(IBinder iBinder) {
        return zzqn.zza.zzdx(iBinder);
    }

    public final void zzfA(String str) {
        try {
            ((zzqn) zzqJ()).zzi(str, this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", e);
        }
    }

    public final void zzfz(String str) {
        try {
            ((zzqn) zzqJ()).zzh(str, this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", e);
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected final String zzgu() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected final String zzgv() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    public final void zzp(zza.zzb zzbVar, String str) {
        ((zzqn) zzqJ()).zza(new zzc(zzbVar), str, this.zzaEg);
    }
}
