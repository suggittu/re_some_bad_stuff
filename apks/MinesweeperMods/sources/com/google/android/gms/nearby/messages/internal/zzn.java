package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class zzn implements Messages {
    public static final Api.zzc zzUI = new Api.zzc();
    public static final Api.zza zzUJ = new Api.zza() { // from class: com.google.android.gms.nearby.messages.internal.zzn.1
        @Override // com.google.android.gms.common.api.Api.zza
        public final int getPriority() {
            return Strategy.TTL_SECONDS_INFINITE;
        }

        @Override // com.google.android.gms.common.api.Api.zza
        public final zzm zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, MessagesOptions messagesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzm(context, looper, connectionCallbacks, onConnectionFailedListener, zzfVar, messagesOptions);
        }
    };

    abstract class zza extends zza.AbstractC0036zza {
        public zza(GoogleApiClient googleApiClient) {
            super(zzn.zzUI, googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    @Nullable
    private static Message zzA(Intent intent) {
        return (Message) zzj.zzc(intent, "com.google.android.gms.nearby.messages.MESSAGES");
    }

    @Nullable
    private static Message zzB(Intent intent) {
        return (Message) zzj.zzc(intent, "com.google.android.gms.nearby.messages.LOST_MESSAGE");
    }

    private static List zzC(Intent intent) {
        return zzj.zzd(intent, "com.google.android.gms.nearby.messages.UPDATED_MESSAGES");
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult getPermissionStatus(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.nearby.messages.internal.zzn.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzm zzmVar) {
                zzmVar.zzm(this);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public void handleIntent(Intent intent, MessageListener messageListener) {
        Message messageZzA = zzA(intent);
        if (messageZzA != null) {
            messageListener.onFound(messageZzA);
        }
        Message messageZzB = zzB(intent);
        if (messageZzB != null) {
            messageListener.onLost(messageZzB);
        }
        Iterator it = zzC(intent).iterator();
        while (it.hasNext()) {
            messageListener.zza((Message) it.next());
        }
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult publish(GoogleApiClient googleApiClient, Message message) {
        return publish(googleApiClient, message, PublishOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult publish(GoogleApiClient googleApiClient, final Message message, final PublishOptions publishOptions) {
        zzx.zzz(message);
        zzx.zzz(publishOptions);
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.nearby.messages.internal.zzn.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzm zzmVar) {
                zzmVar.zza(this, MessageWrapper.zzb(message), publishOptions);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    @Deprecated
    public PendingResult publish(GoogleApiClient googleApiClient, Message message, Strategy strategy) {
        return publish(googleApiClient, message, new PublishOptions.Builder().setStrategy(strategy).build());
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult registerStatusCallback(GoogleApiClient googleApiClient, final StatusCallback statusCallback) {
        zzx.zzz(statusCallback);
        final com.google.android.gms.common.api.internal.zzq zzqVarZza = ((zzm) googleApiClient.zza(zzUI)).zza(googleApiClient, statusCallback);
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.nearby.messages.internal.zzn.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzm zzmVar) {
                zzmVar.zza(this, zzqVarZza, statusCallback);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult subscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return subscribe(googleApiClient, pendingIntent, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult subscribe(GoogleApiClient googleApiClient, final PendingIntent pendingIntent, final SubscribeOptions subscribeOptions) {
        zzx.zzz(pendingIntent);
        zzx.zzz(subscribeOptions);
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.nearby.messages.internal.zzn.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzm zzmVar) {
                zzmVar.zza(this, pendingIntent, subscribeOptions);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    @Deprecated
    public PendingResult subscribe(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return subscribe(googleApiClient, messageListener, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    @Deprecated
    public PendingResult subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, Strategy strategy) {
        return subscribe(googleApiClient, messageListener, new SubscribeOptions.Builder().setStrategy(strategy).build());
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    @Deprecated
    public PendingResult subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, Strategy strategy, MessageFilter messageFilter) {
        return subscribe(googleApiClient, messageListener, new SubscribeOptions.Builder().setStrategy(strategy).setFilter(messageFilter).build());
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult subscribe(GoogleApiClient googleApiClient, final MessageListener messageListener, final SubscribeOptions subscribeOptions) {
        zzx.zzz(messageListener);
        zzx.zzz(subscribeOptions);
        final com.google.android.gms.common.api.internal.zzq zzqVarZza = ((zzm) googleApiClient.zza(zzUI)).zza(googleApiClient, messageListener);
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.nearby.messages.internal.zzn.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzm zzmVar) {
                zzmVar.zza(this, zzqVarZza, messageListener, subscribeOptions, null);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult unpublish(GoogleApiClient googleApiClient, final Message message) {
        zzx.zzz(message);
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.nearby.messages.internal.zzn.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzm zzmVar) {
                zzmVar.zza(this, MessageWrapper.zzb(message));
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult unregisterStatusCallback(GoogleApiClient googleApiClient, final StatusCallback statusCallback) {
        final com.google.android.gms.common.api.internal.zzq zzqVarZza = ((zzm) googleApiClient.zza(zzUI)).zza(googleApiClient, statusCallback);
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.nearby.messages.internal.zzn.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzm zzmVar) {
                zzmVar.zzb(this, zzqVarZza, statusCallback);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult unsubscribe(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        zzx.zzz(pendingIntent);
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.nearby.messages.internal.zzn.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzm zzmVar) {
                zzmVar.zza(this, pendingIntent);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult unsubscribe(GoogleApiClient googleApiClient, final MessageListener messageListener) {
        zzx.zzz(messageListener);
        final com.google.android.gms.common.api.internal.zzq zzqVarZza = ((zzm) googleApiClient.zza(zzUI)).zza(googleApiClient, messageListener);
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.nearby.messages.internal.zzn.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzm zzmVar) {
                zzmVar.zza(this, zzqVarZza, messageListener);
            }
        });
    }
}
