package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;

/* loaded from: classes2.dex */
public final class zzaz implements MessageApi {

    final class zza extends zzi {
        private com.google.android.gms.common.api.internal.zzq zzbbi;
        private MessageApi.MessageListener zzbsS;
        private IntentFilter[] zzbsT;

        private zza(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, com.google.android.gms.common.api.internal.zzq zzqVar, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzbsS = (MessageApi.MessageListener) com.google.android.gms.common.internal.zzx.zzz(messageListener);
            this.zzbbi = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
            this.zzbsT = (IntentFilter[]) com.google.android.gms.common.internal.zzx.zzz(intentFilterArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public final void zza(zzbp zzbpVar) {
            zzbpVar.zza(this, this.zzbsS, this.zzbbi, this.zzbsT);
            this.zzbsS = null;
            this.zzbbi = null;
            this.zzbsT = null;
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public final Status zzc(Status status) {
            this.zzbsS = null;
            this.zzbbi = null;
            this.zzbsT = null;
            return status;
        }
    }

    public class zzb implements MessageApi.SendMessageResult {
        private final Status zzUX;
        private final int zzaox;

        public zzb(Status status, int i) {
            this.zzUX = status;
            this.zzaox = i;
        }

        @Override // com.google.android.gms.wearable.MessageApi.SendMessageResult
        public int getRequestId() {
            return this.zzaox;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private PendingResult zza(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(googleApiClient, messageListener, googleApiClient.zzr(messageListener), intentFilterArr));
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public final PendingResult addListener(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener) {
        return zza(googleApiClient, messageListener, new IntentFilter[]{zzbn.zzgM(MessageApi.ACTION_MESSAGE_RECEIVED)});
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public final PendingResult addListener(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, Uri uri, int i) {
        com.google.android.gms.common.internal.zzx.zzb(uri != null, "uri must not be null");
        com.google.android.gms.common.internal.zzx.zzb(i == 0 || i == 1, "invalid filter type");
        return zza(googleApiClient, messageListener, new IntentFilter[]{zzbn.zza(MessageApi.ACTION_MESSAGE_RECEIVED, uri, i)});
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public final PendingResult removeListener(GoogleApiClient googleApiClient, final MessageApi.MessageListener messageListener) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzaz.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zza(this, messageListener);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public final PendingResult sendMessage(GoogleApiClient googleApiClient, final String str, final String str2, final byte[] bArr) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzaz.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zza(this, str, str2, bArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzbz, reason: merged with bridge method [inline-methods] */
            public MessageApi.SendMessageResult zzc(Status status) {
                return new zzb(status, -1);
            }
        });
    }
}
