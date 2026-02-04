package com.google.android.gms.nearby.messages.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishCallback;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.nearby.messages.internal.zzd;
import com.google.android.gms.nearby.messages.internal.zzf;
import com.google.android.gms.nearby.messages.internal.zzg;
import com.google.android.gms.nearby.messages.internal.zzh;
import com.google.android.gms.nearby.messages.internal.zzi;

/* loaded from: classes2.dex */
class zzm extends com.google.android.gms.common.internal.zzj {
    private final boolean zzbcv;
    private final ClientAppContext zzbcw;
    private final zzg zzbcx;
    private final zzg zzbcy;

    interface zza {
        com.google.android.gms.common.api.internal.zzq zzEE();
    }

    @TargetApi(14)
    class zzb implements Application.ActivityLifecycleCallbacks {
        private final Activity zzbcA;
        private final zzm zzbcB;

        private zzb(Activity activity, zzm zzmVar) {
            this.zzbcA = activity;
            this.zzbcB = zzmVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity == this.zzbcA) {
                Log.v("NearbyMessagesClient", String.format("Unregistering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName()));
                activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (activity == this.zzbcA) {
                try {
                    this.zzbcB.zzjq(1);
                } catch (RemoteException e) {
                    Log.v("NearbyMessagesClient", String.format("Failed to emit ACTIVITY_STOPPED from ClientLifecycleSafetyNet for Activity %s: %s", activity.getPackageName(), e));
                }
            }
        }
    }

    class zzc extends zzd.zza implements zza {
        private final com.google.android.gms.common.api.internal.zzq zzbbi;

        private zzc(com.google.android.gms.common.api.internal.zzq zzqVar) {
            this.zzbbi = zzqVar;
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzm.zza
        public com.google.android.gms.common.api.internal.zzq zzEE() {
            return this.zzbbi;
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzd
        public void zza(final MessageWrapper messageWrapper) {
            this.zzbbi.zza(new zzq.zzb() { // from class: com.google.android.gms.nearby.messages.internal.zzm.zzc.1
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(MessageListener messageListener) {
                    messageListener.onFound(messageWrapper.zzbcu);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzd
        public void zza(final MessageWrapper[] messageWrapperArr) {
            this.zzbbi.zza(new zzq.zzb() { // from class: com.google.android.gms.nearby.messages.internal.zzm.zzc.2
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(MessageListener messageListener) {
                    for (MessageWrapper messageWrapper : messageWrapperArr) {
                        messageListener.zza(messageWrapper.zzbcu);
                    }
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzd
        public void zzb(final MessageWrapper messageWrapper) {
            this.zzbbi.zza(new zzq.zzb() { // from class: com.google.android.gms.nearby.messages.internal.zzm.zzc.3
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(MessageListener messageListener) {
                    messageListener.onLost(messageWrapper.zzbcu);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }
    }

    class zzd extends zzg.zza {
        private final PublishCallback zzbcG;

        private zzd(PublishCallback publishCallback) {
            this.zzbcG = publishCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static zzd zza(@Nullable PublishCallback publishCallback) {
            if (publishCallback == null) {
                return null;
            }
            return new zzd(publishCallback);
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzg
        public void onExpired() {
            this.zzbcG.onExpired();
        }
    }

    class zze extends zzh.zza implements zza {
        private final com.google.android.gms.common.api.internal.zzq zzbcH;

        private zze(com.google.android.gms.common.api.internal.zzq zzqVar) {
            this.zzbcH = zzqVar;
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzh
        public void onPermissionChanged(final boolean z) {
            this.zzbcH.zza(new zzq.zzb() { // from class: com.google.android.gms.nearby.messages.internal.zzm.zze.1
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(StatusCallback statusCallback) {
                    statusCallback.onPermissionChanged(z);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzm.zza
        public com.google.android.gms.common.api.internal.zzq zzEE() {
            return this.zzbcH;
        }
    }

    class zzf extends zzi.zza {
        private final SubscribeCallback zzbcK;

        private zzf(SubscribeCallback subscribeCallback) {
            this.zzbcK = subscribeCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static zzf zza(@Nullable SubscribeCallback subscribeCallback) {
            if (subscribeCallback == null) {
                return null;
            }
            return new zzf(subscribeCallback);
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzi
        public void onExpired() {
            this.zzbcK.onExpired();
        }
    }

    abstract class zzg {
        private final SimpleArrayMap zzanP;

        private zzg() {
            this.zzanP = new SimpleArrayMap(1);
        }

        @Nullable
        zza zzG(Object obj) {
            return (zza) this.zzanP.get(obj);
        }

        @Nullable
        zza zzH(Object obj) {
            zza zzaVar = (zza) this.zzanP.remove(obj);
            if (zzaVar != null) {
                zzaVar.zzEE().clear();
            }
            return zzaVar;
        }

        zza zza(com.google.android.gms.common.api.internal.zzq zzqVar, Object obj) {
            zza zzaVar = (zza) this.zzanP.get(obj);
            if (zzaVar != null) {
                zzqVar.clear();
                return zzaVar;
            }
            zza zzaVarZzf = zzf(zzqVar);
            this.zzanP.put(obj, zzaVarZzf);
            return zzaVarZzf;
        }

        protected abstract zza zzf(com.google.android.gms.common.api.internal.zzq zzqVar);
    }

    @TargetApi(14)
    zzm(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zzf zzfVar, MessagesOptions messagesOptions) {
        super(context, looper, 62, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzbcx = new zzg() { // from class: com.google.android.gms.nearby.messages.internal.zzm.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.nearby.messages.internal.zzm.zzg
            /* renamed from: zze, reason: merged with bridge method [inline-methods] */
            public zze zzf(com.google.android.gms.common.api.internal.zzq zzqVar) {
                return new zze(zzqVar);
            }
        };
        this.zzbcy = new zzg() { // from class: com.google.android.gms.nearby.messages.internal.zzm.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.nearby.messages.internal.zzm.zzg
            /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
            public zzc zzf(com.google.android.gms.common.api.internal.zzq zzqVar) {
                return new zzc(zzqVar);
            }
        };
        String strZzqv = zzfVar.zzqv();
        int iZzaU = zzaU(context);
        if (messagesOptions != null) {
            this.zzbcw = new ClientAppContext(strZzqv, messagesOptions.zzbbF, messagesOptions.zzbbH, iZzaU);
            this.zzbcv = messagesOptions.zzbbG;
        } else {
            this.zzbcw = new ClientAppContext(strZzqv, null, false, iZzaU);
            this.zzbcv = false;
        }
        if (iZzaU == 1 && zzne.zzsg()) {
            Activity activity = (Activity) context;
            Log.v("NearbyMessagesClient", String.format("Registering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName()));
            activity.getApplication().registerActivityLifecycleCallbacks(new zzb(activity, this));
        }
    }

    private static com.google.android.gms.common.api.internal.zzq zza(GoogleApiClient googleApiClient, Object obj, zzg zzgVar) {
        zza zzaVarZzG = zzgVar.zzG(obj);
        return zzaVarZzG != null ? zzaVarZzG.zzEE() : googleApiClient.zzr(obj);
    }

    private static int zzaU(Context context) {
        if (context instanceof Activity) {
            return 1;
        }
        if (context instanceof Application) {
            return 2;
        }
        return context instanceof Service ? 3 : 0;
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        try {
            zzjq(2);
        } catch (RemoteException e) {
            Log.v("NearbyMessagesClient", String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", e));
        }
        super.disconnect();
    }

    com.google.android.gms.common.api.internal.zzq zza(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return zza(googleApiClient, messageListener, this.zzbcy);
    }

    com.google.android.gms.common.api.internal.zzq zza(GoogleApiClient googleApiClient, StatusCallback statusCallback) {
        return zza(googleApiClient, statusCallback, this.zzbcx);
    }

    void zza(zza.zzb zzbVar, PendingIntent pendingIntent) {
        ((com.google.android.gms.nearby.messages.internal.zzf) zzqJ()).zza(new UnsubscribeRequest(null, zzp.zzn(zzbVar), pendingIntent, 0, this.zzbcw));
    }

    void zza(zza.zzb zzbVar, PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
        ((com.google.android.gms.nearby.messages.internal.zzf) zzqJ()).zza(new SubscribeRequest(null, subscribeOptions.getStrategy(), zzp.zzn(zzbVar), subscribeOptions.getFilter(), pendingIntent, 0, null, this.zzbcv, zzf.zza(subscribeOptions.getCallback()), this.zzbcw));
    }

    void zza(zza.zzb zzbVar, com.google.android.gms.common.api.internal.zzq zzqVar, MessageListener messageListener) {
        if (this.zzbcy.zzG(messageListener) == null) {
            return;
        }
        ((com.google.android.gms.nearby.messages.internal.zzf) zzqJ()).zza(new UnsubscribeRequest((IBinder) this.zzbcy.zza(zzqVar, messageListener), zzp.zzn(zzbVar), null, 0, this.zzbcw));
        this.zzbcy.zzH(messageListener);
    }

    void zza(zza.zzb zzbVar, com.google.android.gms.common.api.internal.zzq zzqVar, MessageListener messageListener, SubscribeOptions subscribeOptions, @Nullable byte[] bArr) {
        ((com.google.android.gms.nearby.messages.internal.zzf) zzqJ()).zza(new SubscribeRequest((IBinder) this.zzbcy.zza(zzqVar, messageListener), subscribeOptions.getStrategy(), zzp.zzn(zzbVar), subscribeOptions.getFilter(), null, 0, bArr, this.zzbcv, zzf.zza(subscribeOptions.getCallback()), this.zzbcw));
    }

    void zza(zza.zzb zzbVar, com.google.android.gms.common.api.internal.zzq zzqVar, StatusCallback statusCallback) {
        RegisterStatusCallbackRequest registerStatusCallbackRequest = new RegisterStatusCallbackRequest(zzp.zzn(zzbVar), (IBinder) this.zzbcx.zza(zzqVar, statusCallback), this.zzbcw);
        registerStatusCallbackRequest.zzbcX = true;
        ((com.google.android.gms.nearby.messages.internal.zzf) zzqJ()).zza(registerStatusCallbackRequest);
    }

    void zza(zza.zzb zzbVar, MessageWrapper messageWrapper) {
        ((com.google.android.gms.nearby.messages.internal.zzf) zzqJ()).zza(new UnpublishRequest(messageWrapper, zzp.zzn(zzbVar), this.zzbcw));
    }

    void zza(zza.zzb zzbVar, MessageWrapper messageWrapper, PublishOptions publishOptions) {
        ((com.google.android.gms.nearby.messages.internal.zzf) zzqJ()).zza(new PublishRequest(messageWrapper, publishOptions.getStrategy(), zzp.zzn(zzbVar), this.zzbcv, zzd.zza(publishOptions.getCallback()), this.zzbcw));
    }

    void zzb(zza.zzb zzbVar, com.google.android.gms.common.api.internal.zzq zzqVar, StatusCallback statusCallback) {
        if (this.zzbcx.zzG(statusCallback) == null) {
            return;
        }
        RegisterStatusCallbackRequest registerStatusCallbackRequest = new RegisterStatusCallbackRequest(zzp.zzn(zzbVar), (IBinder) this.zzbcx.zza(zzqVar, statusCallback), this.zzbcw);
        registerStatusCallbackRequest.zzbcX = false;
        ((com.google.android.gms.nearby.messages.internal.zzf) zzqJ()).zza(registerStatusCallbackRequest);
        this.zzbcx.zzH(statusCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzdE, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.nearby.messages.internal.zzf zzW(IBinder iBinder) {
        return zzf.zza.zzdA(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    @NonNull
    protected String zzgu() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    @NonNull
    protected String zzgv() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    void zzjq(int i) {
        String str;
        switch (i) {
            case 1:
                str = "ACTIVITY_STOPPED";
                break;
            case 2:
                str = "CLIENT_DISCONNECTED";
                break;
            default:
                Log.w("NearbyMessagesClient", String.format("Received unknown/unforeseen client lifecycle event %d, can't do anything with it.", Integer.valueOf(i)));
                return;
        }
        if (!isConnected()) {
            Log.d("NearbyMessagesClient", String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", str));
            return;
        }
        HandleClientLifecycleEventRequest handleClientLifecycleEventRequest = new HandleClientLifecycleEventRequest(this.zzbcw, i);
        Log.d("NearbyMessagesClient", String.format("Emitting client lifecycle event %s", str));
        ((com.google.android.gms.nearby.messages.internal.zzf) zzqJ()).zza(handleClientLifecycleEventRequest);
    }

    void zzm(zza.zzb zzbVar) {
        ((com.google.android.gms.nearby.messages.internal.zzf) zzqJ()).zza(new GetPermissionStatusRequest(zzp.zzn(zzbVar), this.zzbcw));
    }
}
