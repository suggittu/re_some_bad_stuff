package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.internal.ChannelImpl;
import com.google.android.gms.wearable.internal.zzaz;
import com.google.android.gms.wearable.internal.zzbb;
import com.google.android.gms.wearable.internal.zzj;
import com.google.android.gms.wearable.internal.zzl;
import com.google.android.gms.wearable.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

/* loaded from: classes2.dex */
final class zzbo {

    final class zza extends zzb {
        public zza(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(AddLocalCapabilityResponse addLocalCapabilityResponse) {
            zzX(new zzj.zza(zzbk.zzgc(addLocalCapabilityResponse.statusCode)));
        }
    }

    abstract class zzb extends com.google.android.gms.wearable.internal.zza {
        private zza.zzb zzUz;

        public zzb(zza.zzb zzbVar) {
            this.zzUz = zzbVar;
        }

        public void zzX(Object obj) {
            zza.zzb zzbVar = this.zzUz;
            if (zzbVar != null) {
                zzbVar.zzs(obj);
                this.zzUz = null;
            }
        }
    }

    final class zzc extends zzb {
        public zzc(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(CloseChannelResponse closeChannelResponse) {
            zzX(new Status(closeChannelResponse.statusCode));
        }
    }

    final class zzd extends zzb {
        public zzd(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zzb(CloseChannelResponse closeChannelResponse) {
            zzX(new Status(closeChannelResponse.statusCode));
        }
    }

    final class zze extends zzb {
        public zze(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(DeleteDataItemsResponse deleteDataItemsResponse) {
            zzX(new zzx.zzb(zzbk.zzgc(deleteDataItemsResponse.statusCode), deleteDataItemsResponse.zzbsz));
        }
    }

    final class zzf extends zzb {
        public zzf(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(GetAllCapabilitiesResponse getAllCapabilitiesResponse) {
            zzX(new zzj.zzd(zzbk.zzgc(getAllCapabilitiesResponse.statusCode), zzbo.zzG(getAllCapabilitiesResponse.zzbsA)));
        }
    }

    final class zzg extends zzb {
        public zzg(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(GetCapabilityResponse getCapabilityResponse) {
            zzX(new zzj.zze(zzbk.zzgc(getCapabilityResponse.statusCode), new zzj.zzc(getCapabilityResponse.zzbsB)));
        }
    }

    final class zzh extends zzb {
        private final com.google.android.gms.wearable.internal.zzt zzbtd;

        public zzh(zza.zzb zzbVar, com.google.android.gms.wearable.internal.zzt zztVar) {
            super(zzbVar);
            this.zzbtd = (com.google.android.gms.wearable.internal.zzt) com.google.android.gms.common.internal.zzx.zzz(zztVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(GetChannelInputStreamResponse getChannelInputStreamResponse) {
            com.google.android.gms.wearable.internal.zzp zzpVar = null;
            if (getChannelInputStreamResponse.zzbsC != null) {
                zzpVar = new com.google.android.gms.wearable.internal.zzp(new ParcelFileDescriptor.AutoCloseInputStream(getChannelInputStreamResponse.zzbsC));
                this.zzbtd.zza(zzpVar.zzIJ());
            }
            zzX(new ChannelImpl.zza(new Status(getChannelInputStreamResponse.statusCode), zzpVar));
        }
    }

    final class zzi extends zzb {
        private final com.google.android.gms.wearable.internal.zzt zzbtd;

        public zzi(zza.zzb zzbVar, com.google.android.gms.wearable.internal.zzt zztVar) {
            super(zzbVar);
            this.zzbtd = (com.google.android.gms.wearable.internal.zzt) com.google.android.gms.common.internal.zzx.zzz(zztVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(GetChannelOutputStreamResponse getChannelOutputStreamResponse) {
            com.google.android.gms.wearable.internal.zzq zzqVar = null;
            if (getChannelOutputStreamResponse.zzbsC != null) {
                zzqVar = new com.google.android.gms.wearable.internal.zzq(new ParcelFileDescriptor.AutoCloseOutputStream(getChannelOutputStreamResponse.zzbsC));
                this.zzbtd.zza(zzqVar.zzIJ());
            }
            zzX(new ChannelImpl.zzb(new Status(getChannelOutputStreamResponse.statusCode), zzqVar));
        }
    }

    final class zzj extends zzb {
        public zzj(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(GetConnectedNodesResponse getConnectedNodesResponse) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(getConnectedNodesResponse.zzbsI);
            zzX(new zzbb.zza(zzbk.zzgc(getConnectedNodesResponse.statusCode), arrayList));
        }
    }

    final class zzk extends zzb {
        public zzk(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(GetDataItemResponse getDataItemResponse) {
            zzX(new zzx.zza(zzbk.zzgc(getDataItemResponse.statusCode), getDataItemResponse.zzbsJ));
        }
    }

    final class zzl extends zzb {
        public zzl(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zzah(DataHolder dataHolder) {
            zzX(new DataItemBuffer(dataHolder));
        }
    }

    final class zzm extends zzb {
        public zzm(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(GetFdForAssetResponse getFdForAssetResponse) {
            zzX(new zzx.zzc(zzbk.zzgc(getFdForAssetResponse.statusCode), getFdForAssetResponse.zzbsK));
        }
    }

    final class zzn extends zzb {
        public zzn(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(GetLocalNodeResponse getLocalNodeResponse) {
            zzX(new zzbb.zzb(zzbk.zzgc(getLocalNodeResponse.statusCode), getLocalNodeResponse.zzbsL));
        }
    }

    final class zzo extends com.google.android.gms.wearable.internal.zza {
        zzo() {
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(Status status) {
        }
    }

    final class zzp extends zzb {
        public zzp(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(OpenChannelResponse openChannelResponse) {
            zzX(new zzl.zza(zzbk.zzgc(openChannelResponse.statusCode), openChannelResponse.zzbsc));
        }
    }

    final class zzq extends zzb {
        private final List zzzM;

        zzq(zza.zzb zzbVar, List list) {
            super(zzbVar);
            this.zzzM = list;
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(PutDataResponse putDataResponse) {
            zzX(new zzx.zza(zzbk.zzgc(putDataResponse.statusCode), putDataResponse.zzbsJ));
            if (putDataResponse.statusCode != 0) {
                Iterator it = this.zzzM.iterator();
                while (it.hasNext()) {
                    ((FutureTask) it.next()).cancel(true);
                }
            }
        }
    }

    final class zzr extends zzb {
        public zzr(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(ChannelSendFileResponse channelSendFileResponse) {
            zzX(new Status(channelSendFileResponse.statusCode));
        }
    }

    final class zzs extends zzb {
        public zzs(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(RemoveLocalCapabilityResponse removeLocalCapabilityResponse) {
            zzX(new zzj.zza(zzbk.zzgc(removeLocalCapabilityResponse.statusCode)));
        }
    }

    final class zzt extends zzb {
        public zzt(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(SendMessageResponse sendMessageResponse) {
            zzX(new zzaz.zzb(zzbk.zzgc(sendMessageResponse.statusCode), sendMessageResponse.zzaNj));
        }
    }

    final class zzu extends zzb {
        public zzu(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public final void zza(ChannelReceiveFileResponse channelReceiveFileResponse) {
            zzX(new Status(channelReceiveFileResponse.statusCode));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map zzG(List list) {
        HashMap map = new HashMap(list.size() * 2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CapabilityInfoParcelable capabilityInfoParcelable = (CapabilityInfoParcelable) it.next();
            map.put(capabilityInfoParcelable.getName(), new zzj.zzc(capabilityInfoParcelable));
        }
        return map;
    }
}
