package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.zznz;
import com.google.android.gms.internal.zzpj;

/* loaded from: classes2.dex */
public class zzpa implements BleApi {

    class zza extends zzpj.zza {
        private final zza.zzb zzamC;

        private zza(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzpj
        public void zza(BleDevicesResult bleDevicesResult) {
            this.zzamC.zzs(bleDevicesResult);
        }
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult claimBleDevice(GoogleApiClient googleApiClient, final BleDevice bleDevice) {
        return googleApiClient.zzb(new zznz.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpa.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zznz zznzVar) {
                ((zzok) zznzVar.zzqJ()).zza(new ClaimBleDeviceRequest(bleDevice.getAddress(), bleDevice, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult claimBleDevice(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zznz.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpa.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zznz zznzVar) {
                ((zzok) zznzVar.zzqJ()).zza(new ClaimBleDeviceRequest(str, null, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult listClaimedBleDevices(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zznz.zza(googleApiClient) { // from class: com.google.android.gms.internal.zzpa.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzI, reason: merged with bridge method [inline-methods] */
            public BleDevicesResult zzc(Status status) {
                return BleDevicesResult.zzQ(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zznz zznzVar) {
                ((zzok) zznzVar.zzqJ()).zza(new ListClaimedBleDevicesRequest(new zza(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult startBleScan(GoogleApiClient googleApiClient, final StartBleScanRequest startBleScanRequest) {
        return googleApiClient.zza(new zznz.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpa.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zznz zznzVar) {
                ((zzok) zznzVar.zzqJ()).zza(new StartBleScanRequest(startBleScanRequest, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult stopBleScan(GoogleApiClient googleApiClient, final BleScanCallback bleScanCallback) {
        return googleApiClient.zza(new zznz.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpa.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zznz zznzVar) {
                ((zzok) zznzVar.zzqJ()).zza(new StopBleScanRequest(bleScanCallback, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult unclaimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return unclaimBleDevice(googleApiClient, bleDevice.getAddress());
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult unclaimBleDevice(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zznz.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpa.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zznz zznzVar) {
                ((zzok) zznzVar.zzqJ()).zza(new UnclaimBleDeviceRequest(str, new zzph(this)));
            }
        });
    }
}
