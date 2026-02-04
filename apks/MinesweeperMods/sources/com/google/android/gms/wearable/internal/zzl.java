package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.internal.zzb;

/* loaded from: classes2.dex */
public final class zzl implements ChannelApi {

    final class zza implements ChannelApi.OpenChannelResult {
        private final Status zzUX;
        private final Channel zzbrY;

        zza(Status status, Channel channel) {
            this.zzUX = (Status) com.google.android.gms.common.internal.zzx.zzz(status);
            this.zzbrY = channel;
        }

        @Override // com.google.android.gms.wearable.ChannelApi.OpenChannelResult
        public final Channel getChannel() {
            return this.zzbrY;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    final class zzb extends zzi {
        private final String zzVo;
        private ChannelApi.ChannelListener zzbrZ;

        zzb(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener, String str) {
            super(googleApiClient);
            this.zzbrZ = (ChannelApi.ChannelListener) com.google.android.gms.common.internal.zzx.zzz(channelListener);
            this.zzVo = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public final void zza(zzbp zzbpVar) {
            zzbpVar.zza(this, this.zzbrZ, this.zzVo);
            this.zzbrZ = null;
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public final Status zzc(Status status) {
            this.zzbrZ = null;
            return status;
        }
    }

    private static zzb.zza zza(final IntentFilter[] intentFilterArr) {
        return new zzb.zza() { // from class: com.google.android.gms.wearable.internal.zzl.2
            @Override // com.google.android.gms.wearable.internal.zzb.zza
            public final void zza(zzbp zzbpVar, zza.zzb zzbVar, ChannelApi.ChannelListener channelListener, com.google.android.gms.common.api.internal.zzq zzqVar) {
                zzbpVar.zza(zzbVar, channelListener, zzqVar, (String) null, intentFilterArr);
            }
        };
    }

    @Override // com.google.android.gms.wearable.ChannelApi
    public final PendingResult addListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        com.google.android.gms.common.internal.zzx.zzb(googleApiClient, "client is null");
        com.google.android.gms.common.internal.zzx.zzb(channelListener, "listener is null");
        return com.google.android.gms.wearable.internal.zzb.zza(googleApiClient, zza(new IntentFilter[]{zzbn.zzgM(ChannelApi.ACTION_CHANNEL_EVENT)}), channelListener);
    }

    @Override // com.google.android.gms.wearable.ChannelApi
    public final PendingResult openChannel(GoogleApiClient googleApiClient, final String str, final String str2) {
        com.google.android.gms.common.internal.zzx.zzb(googleApiClient, "client is null");
        com.google.android.gms.common.internal.zzx.zzb(str, "nodeId is null");
        com.google.android.gms.common.internal.zzx.zzb(str2, "path is null");
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zze(this, str, str2);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzbs, reason: merged with bridge method [inline-methods] */
            public ChannelApi.OpenChannelResult zzc(Status status) {
                return new zza(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.ChannelApi
    public final PendingResult removeListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        com.google.android.gms.common.internal.zzx.zzb(googleApiClient, "client is null");
        com.google.android.gms.common.internal.zzx.zzb(channelListener, "listener is null");
        return googleApiClient.zza(new zzb(googleApiClient, channelListener, null));
    }
}
