package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzql implements Connections {
    public static final Api.zzc zzUI = new Api.zzc();
    public static final Api.zza zzUJ = new Api.zza() { // from class: com.google.android.gms.internal.zzql.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzp, reason: merged with bridge method [inline-methods] */
        public final zzqk zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzqk(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };

    abstract class zza extends zza.AbstractC0036zza {
        public zza(GoogleApiClient googleApiClient) {
            super(zzql.zzUI, googleApiClient);
        }
    }

    abstract class zzb extends zza {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzbc, reason: merged with bridge method [inline-methods] */
        public Connections.StartAdvertisingResult zzc(final Status status) {
            return new Connections.StartAdvertisingResult() { // from class: com.google.android.gms.internal.zzql.zzb.1
                @Override // com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult
                public String getLocalEndpointName() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class zzc extends zza {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    public static zzqk zzd(GoogleApiClient googleApiClient, boolean z) {
        com.google.android.gms.common.internal.zzx.zzb(googleApiClient != null, "GoogleApiClient parameter is required.");
        com.google.android.gms.common.internal.zzx.zza(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        return zze(googleApiClient, z);
    }

    public static zzqk zze(GoogleApiClient googleApiClient, boolean z) {
        com.google.android.gms.common.internal.zzx.zza(googleApiClient.zza(Nearby.CONNECTIONS_API), "GoogleApiClient is not configured to use the Nearby Connections Api. Pass Nearby.CONNECTIONS_API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean zHasConnectedApi = googleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API);
        if (z && !zHasConnectedApi) {
            throw new IllegalStateException("GoogleApiClient has an optional Nearby.CONNECTIONS_API and is not connected to Nearby Connections. Use GoogleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API) to guard this call.");
        }
        if (zHasConnectedApi) {
            return (zzqk) googleApiClient.zza(zzUI);
        }
        return null;
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult acceptConnectionRequest(GoogleApiClient googleApiClient, final String str, final byte[] bArr, Connections.MessageListener messageListener) {
        final com.google.android.gms.common.api.internal.zzq zzqVarZzr = googleApiClient.zzr(messageListener);
        return googleApiClient.zzb(new zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzql.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzqk zzqkVar) {
                zzqkVar.zza(this, str, bArr, zzqVarZzr);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void disconnectFromEndpoint(GoogleApiClient googleApiClient, String str) {
        zzd(googleApiClient, false).zzfA(str);
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final String getLocalDeviceId(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient, true).zzEk();
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final String getLocalEndpointId(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient, true).zzEj();
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult rejectConnectionRequest(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzql.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzqk zzqkVar) {
                zzqkVar.zzp(this, str);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult sendConnectionRequest(GoogleApiClient googleApiClient, final String str, final String str2, final byte[] bArr, Connections.ConnectionResponseCallback connectionResponseCallback, Connections.MessageListener messageListener) {
        final com.google.android.gms.common.api.internal.zzq zzqVarZzr = googleApiClient.zzr(connectionResponseCallback);
        final com.google.android.gms.common.api.internal.zzq zzqVarZzr2 = googleApiClient.zzr(messageListener);
        return googleApiClient.zzb(new zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzql.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzqk zzqkVar) {
                zzqkVar.zza(this, str, str2, bArr, zzqVarZzr, zzqVarZzr2);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void sendReliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        zzd(googleApiClient, false).zza(new String[]{str}, bArr);
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void sendReliableMessage(GoogleApiClient googleApiClient, List list, byte[] bArr) {
        zzd(googleApiClient, false).zza((String[]) list.toArray(new String[list.size()]), bArr);
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void sendUnreliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        zzd(googleApiClient, false).zzb(new String[]{str}, bArr);
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void sendUnreliableMessage(GoogleApiClient googleApiClient, List list, byte[] bArr) {
        zzd(googleApiClient, false).zzb((String[]) list.toArray(new String[list.size()]), bArr);
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult startAdvertising(GoogleApiClient googleApiClient, final String str, final AppMetadata appMetadata, final long j, Connections.ConnectionRequestListener connectionRequestListener) {
        final com.google.android.gms.common.api.internal.zzq zzqVarZzr = googleApiClient.zzr(connectionRequestListener);
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzql.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzqk zzqkVar) {
                zzqkVar.zza(this, str, appMetadata, j, zzqVarZzr);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult startDiscovery(GoogleApiClient googleApiClient, final String str, final long j, Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
        final com.google.android.gms.common.api.internal.zzq zzqVarZzr = googleApiClient.zzr(endpointDiscoveryListener);
        return googleApiClient.zzb(new zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzql.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzqk zzqkVar) {
                zzqkVar.zza(this, str, j, zzqVarZzr);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void stopAdvertising(GoogleApiClient googleApiClient) {
        zzd(googleApiClient, false).zzEl();
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void stopAllEndpoints(GoogleApiClient googleApiClient) {
        zzd(googleApiClient, false).zzEm();
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void stopDiscovery(GoogleApiClient googleApiClient, String str) {
        zzd(googleApiClient, false).zzfz(str);
    }
}
