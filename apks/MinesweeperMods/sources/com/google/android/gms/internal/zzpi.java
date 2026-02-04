package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

/* loaded from: classes2.dex */
public class zzpi implements BleApi {
    private static final Status zzaAx = new Status(FitnessStatusCodes.UNSUPPORTED_PLATFORM);

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult claimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return PendingResults.zza(zzaAx, googleApiClient);
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult claimBleDevice(GoogleApiClient googleApiClient, String str) {
        return PendingResults.zza(zzaAx, googleApiClient);
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult listClaimedBleDevices(GoogleApiClient googleApiClient) {
        return PendingResults.zza(BleDevicesResult.zzQ(zzaAx), googleApiClient);
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult startBleScan(GoogleApiClient googleApiClient, StartBleScanRequest startBleScanRequest) {
        return PendingResults.zza(zzaAx, googleApiClient);
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult stopBleScan(GoogleApiClient googleApiClient, BleScanCallback bleScanCallback) {
        return PendingResults.zza(zzaAx, googleApiClient);
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult unclaimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return PendingResults.zza(zzaAx, googleApiClient);
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult unclaimBleDevice(GoogleApiClient googleApiClient, String str) {
        return PendingResults.zza(zzaAx, googleApiClient);
    }
}
