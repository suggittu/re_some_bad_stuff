package com.google.android.gms.fitness;

import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;

/* loaded from: classes2.dex */
public interface BleApi {
    PendingResult claimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice);

    PendingResult claimBleDevice(GoogleApiClient googleApiClient, String str);

    PendingResult listClaimedBleDevices(GoogleApiClient googleApiClient);

    @RequiresPermission("android.permission.BLUETOOTH_ADMIN")
    PendingResult startBleScan(GoogleApiClient googleApiClient, StartBleScanRequest startBleScanRequest);

    PendingResult stopBleScan(GoogleApiClient googleApiClient, BleScanCallback bleScanCallback);

    PendingResult unclaimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice);

    PendingResult unclaimBleDevice(GoogleApiClient googleApiClient, String str);
}
