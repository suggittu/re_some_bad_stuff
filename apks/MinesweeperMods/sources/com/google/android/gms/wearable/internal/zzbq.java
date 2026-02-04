package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.zzaw;
import com.google.android.gms.wearable.zza;
import com.google.android.gms.wearable.zzc;
import java.util.List;

/* loaded from: classes2.dex */
final class zzbq extends zzaw.zza {
    private com.google.android.gms.common.api.internal.zzq zzbbb;
    private final IntentFilter[] zzbsT;
    private com.google.android.gms.common.api.internal.zzq zzbtp;
    private com.google.android.gms.common.api.internal.zzq zzbtq;
    private com.google.android.gms.common.api.internal.zzq zzbtr;
    private com.google.android.gms.common.api.internal.zzq zzbts;
    private com.google.android.gms.common.api.internal.zzq zzbtt;
    private com.google.android.gms.common.api.internal.zzq zzbtu;
    private com.google.android.gms.common.api.internal.zzq zzbtv;
    private final String zzbtw;

    private zzbq(IntentFilter[] intentFilterArr, String str) {
        this.zzbsT = (IntentFilter[]) com.google.android.gms.common.internal.zzx.zzz(intentFilterArr);
        this.zzbtw = str;
    }

    private static zzq.zzb zzI(final List list) {
        return new zzq.zzb() { // from class: com.google.android.gms.wearable.internal.zzbq.7
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* renamed from: zza, reason: merged with bridge method [inline-methods] */
            public final void zzt(NodeApi.zza zzaVar) {
                zzaVar.onConnectedNodes(list);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public final void zzpr() {
            }
        };
    }

    public static zzbq zza(com.google.android.gms.common.api.internal.zzq zzqVar, String str, IntentFilter[] intentFilterArr) {
        zzbq zzbqVar = new zzbq(intentFilterArr, (String) com.google.android.gms.common.internal.zzx.zzz(str));
        zzbqVar.zzbtu = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        return zzbqVar;
    }

    public static zzbq zza(com.google.android.gms.common.api.internal.zzq zzqVar, IntentFilter[] intentFilterArr) {
        zzbq zzbqVar = new zzbq(intentFilterArr, null);
        zzbqVar.zzbtr = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        return zzbqVar;
    }

    private static zzq.zzb zzai(final DataHolder dataHolder) {
        return new zzq.zzb() { // from class: com.google.android.gms.wearable.internal.zzbq.3
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* renamed from: zza, reason: merged with bridge method [inline-methods] */
            public final void zzt(DataApi.DataListener dataListener) {
                try {
                    dataListener.onDataChanged(new DataEventBuffer(dataHolder));
                } finally {
                    dataHolder.close();
                }
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public final void zzpr() {
                dataHolder.close();
            }
        };
    }

    private static zzq.zzb zzb(final AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        return new zzq.zzb() { // from class: com.google.android.gms.wearable.internal.zzbq.2
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* renamed from: zza, reason: merged with bridge method [inline-methods] */
            public final void zzt(zza.InterfaceC0269zza interfaceC0269zza) {
                interfaceC0269zza.zza(amsEntityUpdateParcelable);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public final void zzpr() {
            }
        };
    }

    private static zzq.zzb zzb(final AncsNotificationParcelable ancsNotificationParcelable) {
        return new zzq.zzb() { // from class: com.google.android.gms.wearable.internal.zzbq.1
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* renamed from: zza, reason: merged with bridge method [inline-methods] */
            public final void zzt(zzc.zza zzaVar) {
                zzaVar.zza(ancsNotificationParcelable);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public final void zzpr() {
            }
        };
    }

    private static zzq.zzb zzb(final CapabilityInfoParcelable capabilityInfoParcelable) {
        return new zzq.zzb() { // from class: com.google.android.gms.wearable.internal.zzbq.9
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* renamed from: zza, reason: merged with bridge method [inline-methods] */
            public final void zzt(CapabilityApi.CapabilityListener capabilityListener) {
                capabilityListener.onCapabilityChanged(capabilityInfoParcelable);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public final void zzpr() {
            }
        };
    }

    private static zzq.zzb zzb(final ChannelEventParcelable channelEventParcelable) {
        return new zzq.zzb() { // from class: com.google.android.gms.wearable.internal.zzbq.8
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public final void zzt(ChannelApi.ChannelListener channelListener) {
                channelEventParcelable.zza(channelListener);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public final void zzpr() {
            }
        };
    }

    private static zzq.zzb zzb(final MessageEventParcelable messageEventParcelable) {
        return new zzq.zzb() { // from class: com.google.android.gms.wearable.internal.zzbq.4
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* renamed from: zza, reason: merged with bridge method [inline-methods] */
            public final void zzt(MessageApi.MessageListener messageListener) {
                messageListener.onMessageReceived(messageEventParcelable);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public final void zzpr() {
            }
        };
    }

    public static zzbq zzb(com.google.android.gms.common.api.internal.zzq zzqVar, IntentFilter[] intentFilterArr) {
        zzbq zzbqVar = new zzbq(intentFilterArr, null);
        zzbqVar.zzbbb = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        return zzbqVar;
    }

    private static zzq.zzb zzc(final NodeParcelable nodeParcelable) {
        return new zzq.zzb() { // from class: com.google.android.gms.wearable.internal.zzbq.5
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* renamed from: zza, reason: merged with bridge method [inline-methods] */
            public final void zzt(NodeApi.NodeListener nodeListener) {
                nodeListener.onPeerConnected(nodeParcelable);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public final void zzpr() {
            }
        };
    }

    public static zzbq zzc(com.google.android.gms.common.api.internal.zzq zzqVar, IntentFilter[] intentFilterArr) {
        zzbq zzbqVar = new zzbq(intentFilterArr, null);
        zzbqVar.zzbts = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        return zzbqVar;
    }

    private static zzq.zzb zzd(final NodeParcelable nodeParcelable) {
        return new zzq.zzb() { // from class: com.google.android.gms.wearable.internal.zzbq.6
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* renamed from: zza, reason: merged with bridge method [inline-methods] */
            public final void zzt(NodeApi.NodeListener nodeListener) {
                nodeListener.onPeerDisconnected(nodeParcelable);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public final void zzpr() {
            }
        };
    }

    public static zzbq zzd(com.google.android.gms.common.api.internal.zzq zzqVar, IntentFilter[] intentFilterArr) {
        zzbq zzbqVar = new zzbq(intentFilterArr, null);
        zzbqVar.zzbtu = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        return zzbqVar;
    }

    public static zzbq zze(com.google.android.gms.common.api.internal.zzq zzqVar, IntentFilter[] intentFilterArr) {
        zzbq zzbqVar = new zzbq(intentFilterArr, null);
        zzbqVar.zzbtv = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        return zzbqVar;
    }

    private static void zzh(com.google.android.gms.common.api.internal.zzq zzqVar) {
        if (zzqVar != null) {
            zzqVar.clear();
        }
    }

    public final void clear() {
        zzh(this.zzbtp);
        this.zzbtp = null;
        zzh(this.zzbtq);
        this.zzbtq = null;
        zzh(this.zzbtr);
        this.zzbtr = null;
        zzh(this.zzbbb);
        this.zzbbb = null;
        zzh(this.zzbts);
        this.zzbts = null;
        zzh(this.zzbtt);
        this.zzbtt = null;
        zzh(this.zzbtu);
        this.zzbtu = null;
        zzh(this.zzbtv);
        this.zzbtv = null;
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public final void onConnectedNodes(List list) {
        if (this.zzbtt != null) {
            this.zzbtt.zza(zzI(list));
        }
    }

    public final IntentFilter[] zzIO() {
        return this.zzbsT;
    }

    public final String zzIP() {
        return this.zzbtw;
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public final void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        if (this.zzbtp != null) {
            this.zzbtp.zza(zzb(amsEntityUpdateParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public final void zza(AncsNotificationParcelable ancsNotificationParcelable) {
        if (this.zzbtq != null) {
            this.zzbtq.zza(zzb(ancsNotificationParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public final void zza(CapabilityInfoParcelable capabilityInfoParcelable) {
        if (this.zzbtv != null) {
            this.zzbtv.zza(zzb(capabilityInfoParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public final void zza(ChannelEventParcelable channelEventParcelable) {
        if (this.zzbtu != null) {
            this.zzbtu.zza(zzb(channelEventParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public final void zza(MessageEventParcelable messageEventParcelable) {
        if (this.zzbbb != null) {
            this.zzbbb.zza(zzb(messageEventParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public final void zza(NodeParcelable nodeParcelable) {
        if (this.zzbts != null) {
            this.zzbts.zza(zzc(nodeParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public final void zzag(DataHolder dataHolder) {
        if (this.zzbtr != null) {
            this.zzbtr.zza(zzai(dataHolder));
        } else {
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public final void zzb(NodeParcelable nodeParcelable) {
        if (this.zzbts != null) {
            this.zzbts.zza(zzd(nodeParcelable));
        }
    }
}
