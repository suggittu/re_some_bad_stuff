package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.zzb;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzbb implements NodeApi {

    public class zza implements NodeApi.GetConnectedNodesResult {
        private final Status zzUX;
        private final List zzbsW;

        public zza(Status status, List list) {
            this.zzUX = status;
            this.zzbsW = list;
        }

        @Override // com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult
        public List getNodes() {
            return this.zzbsW;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    public class zzb implements NodeApi.GetLocalNodeResult {
        private final Status zzUX;
        private final Node zzbsX;

        public zzb(Status status, Node node) {
            this.zzUX = status;
            this.zzbsX = node;
        }

        @Override // com.google.android.gms.wearable.NodeApi.GetLocalNodeResult
        public Node getNode() {
            return this.zzbsX;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static zzb.zza zza(final IntentFilter[] intentFilterArr) {
        return new zzb.zza() { // from class: com.google.android.gms.wearable.internal.zzbb.3
            @Override // com.google.android.gms.wearable.internal.zzb.zza
            public final void zza(zzbp zzbpVar, zza.zzb zzbVar, NodeApi.NodeListener nodeListener, com.google.android.gms.common.api.internal.zzq zzqVar) {
                zzbpVar.zza(zzbVar, nodeListener, zzqVar, intentFilterArr);
            }
        };
    }

    @Override // com.google.android.gms.wearable.NodeApi
    public final PendingResult addListener(GoogleApiClient googleApiClient, NodeApi.NodeListener nodeListener) {
        return com.google.android.gms.wearable.internal.zzb.zza(googleApiClient, zza(new IntentFilter[]{zzbn.zzgM("com.google.android.gms.wearable.NODE_CHANGED")}), nodeListener);
    }

    @Override // com.google.android.gms.wearable.NodeApi
    public final PendingResult getConnectedNodes(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzbb.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zzt(this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzbB, reason: merged with bridge method [inline-methods] */
            public NodeApi.GetConnectedNodesResult zzc(Status status) {
                return new zza(status, new ArrayList());
            }
        });
    }

    @Override // com.google.android.gms.wearable.NodeApi
    public final PendingResult getLocalNode(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzbb.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zzs(this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzbA, reason: merged with bridge method [inline-methods] */
            public NodeApi.GetLocalNodeResult zzc(Status status) {
                return new zzb(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.NodeApi
    public final PendingResult removeListener(GoogleApiClient googleApiClient, final NodeApi.NodeListener nodeListener) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzbb.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zza(this, nodeListener);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }
}
