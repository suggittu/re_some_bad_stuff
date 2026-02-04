package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.internal.zzb;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class zzj implements CapabilityApi {

    public class zza implements CapabilityApi.AddLocalCapabilityResult, CapabilityApi.RemoveLocalCapabilityResult {
        private final Status zzUX;

        public zza(Status status) {
            this.zzUX = status;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    class zzb implements CapabilityApi.CapabilityListener {
        final CapabilityApi.CapabilityListener zzbrQ;
        final String zzbrR;

        zzb(CapabilityApi.CapabilityListener capabilityListener, String str) {
            this.zzbrQ = capabilityListener;
            this.zzbrR = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (this.zzbrQ.equals(zzbVar.zzbrQ)) {
                return this.zzbrR.equals(zzbVar.zzbrR);
            }
            return false;
        }

        public int hashCode() {
            return (this.zzbrQ.hashCode() * 31) + this.zzbrR.hashCode();
        }

        @Override // com.google.android.gms.wearable.CapabilityApi.CapabilityListener
        public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
            this.zzbrQ.onCapabilityChanged(capabilityInfo);
        }
    }

    public class zzc implements CapabilityInfo {
        private final String mName;
        private final Set zzbrS;

        public zzc(CapabilityInfo capabilityInfo) {
            this(capabilityInfo.getName(), capabilityInfo.getNodes());
        }

        public zzc(String str, Set set) {
            this.mName = str;
            this.zzbrS = set;
        }

        @Override // com.google.android.gms.wearable.CapabilityInfo
        public String getName() {
            return this.mName;
        }

        @Override // com.google.android.gms.wearable.CapabilityInfo
        public Set getNodes() {
            return this.zzbrS;
        }
    }

    public class zzd implements CapabilityApi.GetAllCapabilitiesResult {
        private final Status zzUX;
        private final Map zzbrT;

        public zzd(Status status, Map map) {
            this.zzUX = status;
            this.zzbrT = map;
        }

        @Override // com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult
        public Map getAllCapabilities() {
            return this.zzbrT;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    public class zze implements CapabilityApi.GetCapabilityResult {
        private final Status zzUX;
        private final CapabilityInfo zzbrU;

        public zze(Status status, CapabilityInfo capabilityInfo) {
            this.zzUX = status;
            this.zzbrU = capabilityInfo;
        }

        @Override // com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult
        public CapabilityInfo getCapability() {
            return this.zzbrU;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    final class zzf extends zzi {
        private CapabilityApi.CapabilityListener zzbrQ;

        private zzf(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener) {
            super(googleApiClient);
            this.zzbrQ = capabilityListener;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public final void zza(zzbp zzbpVar) {
            zzbpVar.zza(this, this.zzbrQ);
            this.zzbrQ = null;
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public final Status zzc(Status status) {
            this.zzbrQ = null;
            return status;
        }
    }

    private PendingResult zza(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, IntentFilter[] intentFilterArr) {
        return com.google.android.gms.wearable.internal.zzb.zza(googleApiClient, zza(intentFilterArr), capabilityListener);
    }

    private static zzb.zza zza(final IntentFilter[] intentFilterArr) {
        return new zzb.zza() { // from class: com.google.android.gms.wearable.internal.zzj.5
            @Override // com.google.android.gms.wearable.internal.zzb.zza
            public final void zza(zzbp zzbpVar, zza.zzb zzbVar, CapabilityApi.CapabilityListener capabilityListener, com.google.android.gms.common.api.internal.zzq zzqVar) {
                zzbpVar.zza(zzbVar, capabilityListener, zzqVar, intentFilterArr);
            }
        };
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult addCapabilityListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, String str) {
        com.google.android.gms.common.internal.zzx.zzb(str != null, "capability must not be null");
        zzb zzbVar = new zzb(capabilityListener, str);
        IntentFilter intentFilterZzgM = zzbn.zzgM(CapabilityApi.ACTION_CAPABILITY_CHANGED);
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        intentFilterZzgM.addDataPath(str, 0);
        return zza(googleApiClient, zzbVar, new IntentFilter[]{intentFilterZzgM});
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult addListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, Uri uri, int i) {
        com.google.android.gms.common.internal.zzx.zzb(uri != null, "uri must not be null");
        com.google.android.gms.common.internal.zzx.zzb(i == 0 || i == 1, "invalid filter type");
        return zza(googleApiClient, capabilityListener, new IntentFilter[]{zzbn.zza(CapabilityApi.ACTION_CAPABILITY_CHANGED, uri, i)});
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult addLocalCapability(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzj.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zzr(this, str);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzbq, reason: merged with bridge method [inline-methods] */
            public CapabilityApi.AddLocalCapabilityResult zzc(Status status) {
                return new zza(status);
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult getAllCapabilities(GoogleApiClient googleApiClient, final int i) {
        boolean z = true;
        if (i != 0 && i != 1) {
            z = false;
        }
        com.google.android.gms.common.internal.zzx.zzac(z);
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzj.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zzb(this, i);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzbp, reason: merged with bridge method [inline-methods] */
            public CapabilityApi.GetAllCapabilitiesResult zzc(Status status) {
                return new zzd(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult getCapability(GoogleApiClient googleApiClient, final String str, final int i) {
        boolean z = true;
        if (i != 0 && i != 1) {
            z = false;
        }
        com.google.android.gms.common.internal.zzx.zzac(z);
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzj.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zzg(this, str, i);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzbo, reason: merged with bridge method [inline-methods] */
            public CapabilityApi.GetCapabilityResult zzc(Status status) {
                return new zze(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult removeCapabilityListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, String str) {
        return googleApiClient.zza(new zzf(googleApiClient, new zzb(capabilityListener, str)));
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult removeListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener) {
        return googleApiClient.zza(new zzf(googleApiClient, capabilityListener));
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult removeLocalCapability(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzj.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zzs(this, str);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzbr, reason: merged with bridge method [inline-methods] */
            public CapabilityApi.RemoveLocalCapabilityResult zzc(Status status) {
                return new zza(status);
            }
        });
    }
}
