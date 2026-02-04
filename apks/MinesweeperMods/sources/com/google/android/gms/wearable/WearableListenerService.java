package com.google.android.gms.wearable;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.internal.zzaw;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class WearableListenerService extends Service implements CapabilityApi.CapabilityListener, ChannelApi.ChannelListener, DataApi.DataListener, MessageApi.MessageListener, NodeApi.NodeListener, NodeApi.zza {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private boolean zzQl;
    private String zzTJ;
    private IBinder zzakD;
    private Handler zzbro;
    private final Object zzbrp = new Object();

    final class zza extends zzaw.zza {
        private volatile int zzakz;

        private zza() {
            this.zzakz = -1;
        }

        private void zzIx() {
            int callingUid = Binder.getCallingUid();
            if (callingUid == this.zzakz) {
                return;
            }
            if (!GooglePlayServicesUtil.zzf(WearableListenerService.this, callingUid)) {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
            this.zzakz = callingUid;
        }

        private boolean zza(Runnable runnable, String str, Object obj) {
            if (WearableListenerService.this instanceof zzj) {
                return zzb(runnable, str, obj);
            }
            return false;
        }

        private boolean zzb(Runnable runnable, String str, Object obj) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", String.format("%s: %s %s", str, WearableListenerService.this.zzTJ, obj));
            }
            zzIx();
            synchronized (WearableListenerService.this.zzbrp) {
                if (WearableListenerService.this.zzQl) {
                    return false;
                }
                WearableListenerService.this.zzbro.post(runnable);
                return true;
            }
        }

        @Override // com.google.android.gms.wearable.internal.zzaw
        public final void onConnectedNodes(final List list) {
            zzb(new Runnable() { // from class: com.google.android.gms.wearable.WearableListenerService.zza.5
                @Override // java.lang.Runnable
                public void run() {
                    WearableListenerService.this.onConnectedNodes(list);
                }
            }, "onConnectedNodes", list);
        }

        @Override // com.google.android.gms.wearable.internal.zzaw
        public final void zza(final AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
            zza(new Runnable() { // from class: com.google.android.gms.wearable.WearableListenerService.zza.8
                @Override // java.lang.Runnable
                public void run() {
                    ((zzj) WearableListenerService.this).zza(amsEntityUpdateParcelable);
                }
            }, "onEntityUpdate", amsEntityUpdateParcelable);
        }

        @Override // com.google.android.gms.wearable.internal.zzaw
        public final void zza(final AncsNotificationParcelable ancsNotificationParcelable) {
            zza(new Runnable() { // from class: com.google.android.gms.wearable.WearableListenerService.zza.7
                @Override // java.lang.Runnable
                public void run() {
                    ((zzj) WearableListenerService.this).zza(ancsNotificationParcelable);
                }
            }, "onNotificationReceived", ancsNotificationParcelable);
        }

        @Override // com.google.android.gms.wearable.internal.zzaw
        public final void zza(final CapabilityInfoParcelable capabilityInfoParcelable) {
            zzb(new Runnable() { // from class: com.google.android.gms.wearable.WearableListenerService.zza.6
                @Override // java.lang.Runnable
                public void run() {
                    WearableListenerService.this.onCapabilityChanged(capabilityInfoParcelable);
                }
            }, "onConnectedCapabilityChanged", capabilityInfoParcelable);
        }

        @Override // com.google.android.gms.wearable.internal.zzaw
        public final void zza(final ChannelEventParcelable channelEventParcelable) {
            zzb(new Runnable() { // from class: com.google.android.gms.wearable.WearableListenerService.zza.9
                @Override // java.lang.Runnable
                public void run() {
                    channelEventParcelable.zza(WearableListenerService.this);
                }
            }, "onChannelEvent", channelEventParcelable);
        }

        @Override // com.google.android.gms.wearable.internal.zzaw
        public final void zza(final MessageEventParcelable messageEventParcelable) {
            zzb(new Runnable() { // from class: com.google.android.gms.wearable.WearableListenerService.zza.2
                @Override // java.lang.Runnable
                public void run() {
                    WearableListenerService.this.onMessageReceived(messageEventParcelable);
                }
            }, "onMessageReceived", messageEventParcelable);
        }

        @Override // com.google.android.gms.wearable.internal.zzaw
        public final void zza(final NodeParcelable nodeParcelable) {
            zzb(new Runnable() { // from class: com.google.android.gms.wearable.WearableListenerService.zza.3
                @Override // java.lang.Runnable
                public void run() {
                    WearableListenerService.this.onPeerConnected(nodeParcelable);
                }
            }, "onPeerConnected", nodeParcelable);
        }

        @Override // com.google.android.gms.wearable.internal.zzaw
        public final void zzag(final DataHolder dataHolder) {
            try {
                if (zzb(new Runnable() { // from class: com.google.android.gms.wearable.WearableListenerService.zza.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataEventBuffer dataEventBuffer = new DataEventBuffer(dataHolder);
                        try {
                            WearableListenerService.this.onDataChanged(dataEventBuffer);
                        } finally {
                            dataEventBuffer.release();
                        }
                    }
                }, "onDataItemChanged", dataHolder)) {
                }
            } finally {
                dataHolder.close();
            }
        }

        @Override // com.google.android.gms.wearable.internal.zzaw
        public final void zzb(final NodeParcelable nodeParcelable) {
            zzb(new Runnable() { // from class: com.google.android.gms.wearable.WearableListenerService.zza.4
                @Override // java.lang.Runnable
                public void run() {
                    WearableListenerService.this.onPeerDisconnected(nodeParcelable);
                }
            }, "onPeerDisconnected", nodeParcelable);
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        if (BIND_LISTENER_INTENT_ACTION.equals(intent.getAction())) {
            return this.zzakD;
        }
        return null;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi.CapabilityListener
    public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelClosed(Channel channel, int i, int i2) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelOpened(Channel channel) {
    }

    @Override // com.google.android.gms.wearable.NodeApi.zza
    public void onConnectedNodes(List list) {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + new ComponentName(getPackageName(), getClass().getName()).flattenToShortString());
        }
        this.zzTJ = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.zzbro = new Handler(handlerThread.getLooper());
        this.zzakD = new zza();
    }

    @Override // com.google.android.gms.wearable.DataApi.DataListener
    public void onDataChanged(DataEventBuffer dataEventBuffer) {
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onDestroy: " + new ComponentName(getPackageName(), getClass().getName()).flattenToShortString());
        }
        synchronized (this.zzbrp) {
            this.zzQl = true;
            if (this.zzbro == null) {
                throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
            }
            this.zzbro.getLooper().quit();
        }
        super.onDestroy();
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onInputClosed(Channel channel, int i, int i2) {
    }

    @Override // com.google.android.gms.wearable.MessageApi.MessageListener
    public void onMessageReceived(MessageEvent messageEvent) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onOutputClosed(Channel channel, int i, int i2) {
    }

    @Override // com.google.android.gms.wearable.NodeApi.NodeListener
    public void onPeerConnected(Node node) {
    }

    @Override // com.google.android.gms.wearable.NodeApi.NodeListener
    public void onPeerDisconnected(Node node) {
    }
}
