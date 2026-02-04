package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.zzax;
import com.google.android.gms.wearable.internal.zzbo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes2.dex */
public class zzbp extends com.google.android.gms.common.internal.zzj {
    private final ExecutorService zzbkn;
    private final zzay zzbte;
    private final zzay zzbtf;
    private final zzay zzbtg;
    private final zzay zzbth;
    private final zzay zzbti;
    private final zzay zzbtj;
    private final zzay zzbtk;
    private final zzay zzbtl;

    public zzbp(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, 14, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzbkn = Executors.newCachedThreadPool();
        this.zzbte = new zzay();
        this.zzbtf = new zzay();
        this.zzbtg = new zzay();
        this.zzbth = new zzay();
        this.zzbti = new zzay();
        this.zzbtj = new zzay();
        this.zzbtk = new zzay();
        this.zzbtl = new zzay();
    }

    private FutureTask zza(final ParcelFileDescriptor parcelFileDescriptor, final byte[] bArr) {
        return new FutureTask(new Callable() { // from class: com.google.android.gms.wearable.internal.zzbp.1
            @Override // java.util.concurrent.Callable
            /* renamed from: zzvt, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws IOException {
                if (Log.isLoggable("WearableClient", 3)) {
                    Log.d("WearableClient", "processAssets: writing data to FD : " + parcelFileDescriptor);
                }
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor);
                try {
                    try {
                        autoCloseOutputStream.write(bArr);
                        autoCloseOutputStream.flush();
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: wrote data: " + parcelFileDescriptor);
                        }
                        try {
                            if (Log.isLoggable("WearableClient", 3)) {
                                Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                            }
                            autoCloseOutputStream.close();
                            return true;
                        } catch (IOException e) {
                            return true;
                        }
                    } catch (IOException e2) {
                        Log.w("WearableClient", "processAssets: writing data failed: " + parcelFileDescriptor);
                        return false;
                    }
                } finally {
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
            }
        });
    }

    private Runnable zzb(final zza.zzb zzbVar, final String str, final Uri uri, final long j, final long j2) {
        com.google.android.gms.common.internal.zzx.zzz(zzbVar);
        com.google.android.gms.common.internal.zzx.zzz(str);
        com.google.android.gms.common.internal.zzx.zzz(uri);
        com.google.android.gms.common.internal.zzx.zzb(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
        com.google.android.gms.common.internal.zzx.zzb(j2 >= -1, "invalid length: %s", Long.valueOf(j2));
        return new Runnable() { // from class: com.google.android.gms.wearable.internal.zzbp.3
            @Override // java.lang.Runnable
            public void run() throws IOException {
                if (Log.isLoggable("WearableClient", 2)) {
                    Log.v("WearableClient", "Executing sendFileToChannelTask");
                }
                if (!"file".equals(uri.getScheme())) {
                    Log.w("WearableClient", "Channel.sendFile used with non-file URI");
                    zzbVar.zzw(new Status(10, "Channel.sendFile used with non-file URI"));
                    return;
                }
                File file = new File(uri.getPath());
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, DriveFile.MODE_READ_ONLY);
                    try {
                        try {
                            ((zzax) zzbp.this.zzqJ()).zza(new zzbo.zzr(zzbVar), str, parcelFileDescriptorOpen, j, j2);
                            try {
                                parcelFileDescriptorOpen.close();
                            } catch (IOException e) {
                                Log.w("WearableClient", "Failed to close sourceFd", e);
                            }
                        } catch (RemoteException e2) {
                            Log.w("WearableClient", "Channel.sendFile failed.", e2);
                            zzbVar.zzw(new Status(8));
                            try {
                                parcelFileDescriptorOpen.close();
                            } catch (IOException e3) {
                                Log.w("WearableClient", "Failed to close sourceFd", e3);
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            parcelFileDescriptorOpen.close();
                        } catch (IOException e4) {
                            Log.w("WearableClient", "Failed to close sourceFd", e4);
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    Log.w("WearableClient", "File couldn't be opened for Channel.sendFile: " + file);
                    zzbVar.zzw(new Status(13));
                }
            }
        };
    }

    private Runnable zzb(final zza.zzb zzbVar, final String str, final Uri uri, final boolean z) {
        com.google.android.gms.common.internal.zzx.zzz(zzbVar);
        com.google.android.gms.common.internal.zzx.zzz(str);
        com.google.android.gms.common.internal.zzx.zzz(uri);
        return new Runnable() { // from class: com.google.android.gms.wearable.internal.zzbp.2
            @Override // java.lang.Runnable
            public void run() throws IOException {
                if (Log.isLoggable("WearableClient", 2)) {
                    Log.v("WearableClient", "Executing receiveFileFromChannelTask");
                }
                if (!"file".equals(uri.getScheme())) {
                    Log.w("WearableClient", "Channel.receiveFile used with non-file URI");
                    zzbVar.zzw(new Status(10, "Channel.receiveFile used with non-file URI"));
                    return;
                }
                File file = new File(uri.getPath());
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, (z ? 33554432 : 0) | DriveFile.MODE_WRITE_ONLY);
                    try {
                        try {
                            ((zzax) zzbp.this.zzqJ()).zza(new zzbo.zzu(zzbVar), str, parcelFileDescriptorOpen);
                            try {
                                parcelFileDescriptorOpen.close();
                            } catch (IOException e) {
                                Log.w("WearableClient", "Failed to close targetFd", e);
                            }
                        } catch (RemoteException e2) {
                            Log.w("WearableClient", "Channel.receiveFile failed.", e2);
                            zzbVar.zzw(new Status(8));
                            try {
                                parcelFileDescriptorOpen.close();
                            } catch (IOException e3) {
                                Log.w("WearableClient", "Failed to close targetFd", e3);
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            parcelFileDescriptorOpen.close();
                        } catch (IOException e4) {
                            Log.w("WearableClient", "Failed to close targetFd", e4);
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    Log.w("WearableClient", "File couldn't be opened for Channel.receiveFile: " + file);
                    zzbVar.zzw(new Status(13));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            this.zzbte.zzev(iBinder);
            this.zzbtf.zzev(iBinder);
            this.zzbtg.zzev(iBinder);
            this.zzbth.zzev(iBinder);
            this.zzbti.zzev(iBinder);
            this.zzbtj.zzev(iBinder);
            this.zzbtk.zzev(iBinder);
            this.zzbtl.zzev(iBinder);
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(zza.zzb zzbVar, Uri uri) {
        ((zzax) zzqJ()).zza(new zzbo.zzk(zzbVar), uri);
    }

    public void zza(zza.zzb zzbVar, Uri uri, int i) {
        ((zzax) zzqJ()).zza(new zzbo.zzl(zzbVar), uri, i);
    }

    public void zza(zza.zzb zzbVar, Asset asset) {
        ((zzax) zzqJ()).zza(new zzbo.zzm(zzbVar), asset);
    }

    public void zza(zza.zzb zzbVar, CapabilityApi.CapabilityListener capabilityListener) {
        this.zzbtl.zza(this, zzbVar, capabilityListener);
    }

    public void zza(zza.zzb zzbVar, CapabilityApi.CapabilityListener capabilityListener, com.google.android.gms.common.api.internal.zzq zzqVar, IntentFilter[] intentFilterArr) {
        this.zzbtl.zza(this, zzbVar, capabilityListener, zzbq.zze(zzqVar, intentFilterArr));
    }

    public void zza(zza.zzb zzbVar, ChannelApi.ChannelListener channelListener, com.google.android.gms.common.api.internal.zzq zzqVar, String str, IntentFilter[] intentFilterArr) {
        if (str == null) {
            this.zzbtg.zza(this, zzbVar, channelListener, zzbq.zzd(zzqVar, intentFilterArr));
        } else {
            this.zzbtg.zza(this, zzbVar, new zzbj(str, channelListener), zzbq.zza(zzqVar, str, intentFilterArr));
        }
    }

    public void zza(zza.zzb zzbVar, ChannelApi.ChannelListener channelListener, String str) {
        if (str == null) {
            this.zzbtg.zza(this, zzbVar, channelListener);
        } else {
            this.zzbtg.zza(this, zzbVar, new zzbj(str, channelListener));
        }
    }

    public void zza(zza.zzb zzbVar, DataApi.DataListener dataListener) {
        this.zzbth.zza(this, zzbVar, dataListener);
    }

    public void zza(zza.zzb zzbVar, DataApi.DataListener dataListener, com.google.android.gms.common.api.internal.zzq zzqVar, IntentFilter[] intentFilterArr) {
        this.zzbth.zza(this, zzbVar, dataListener, zzbq.zza(zzqVar, intentFilterArr));
    }

    public void zza(zza.zzb zzbVar, DataItemAsset dataItemAsset) {
        zza(zzbVar, Asset.createFromRef(dataItemAsset.getId()));
    }

    public void zza(zza.zzb zzbVar, MessageApi.MessageListener messageListener) {
        this.zzbti.zza(this, zzbVar, messageListener);
    }

    public void zza(zza.zzb zzbVar, MessageApi.MessageListener messageListener, com.google.android.gms.common.api.internal.zzq zzqVar, IntentFilter[] intentFilterArr) {
        this.zzbti.zza(this, zzbVar, messageListener, zzbq.zzb(zzqVar, intentFilterArr));
    }

    public void zza(zza.zzb zzbVar, NodeApi.NodeListener nodeListener) {
        this.zzbtj.zza(this, zzbVar, nodeListener);
    }

    public void zza(zza.zzb zzbVar, NodeApi.NodeListener nodeListener, com.google.android.gms.common.api.internal.zzq zzqVar, IntentFilter[] intentFilterArr) {
        this.zzbtj.zza(this, zzbVar, nodeListener, zzbq.zzc(zzqVar, intentFilterArr));
    }

    public void zza(zza.zzb zzbVar, PutDataRequest putDataRequest) throws IOException {
        Iterator it = putDataRequest.getAssets().entrySet().iterator();
        while (it.hasNext()) {
            Asset asset = (Asset) ((Map.Entry) it.next()).getValue();
            if (asset.getData() == null && asset.getDigest() == null && asset.getFd() == null && asset.getUri() == null) {
                throw new IllegalArgumentException("Put for " + putDataRequest.getUri() + " contains invalid asset: " + asset);
            }
        }
        PutDataRequest putDataRequestZzr = PutDataRequest.zzr(putDataRequest.getUri());
        putDataRequestZzr.setData(putDataRequest.getData());
        if (putDataRequest.isUrgent()) {
            putDataRequestZzr.setUrgent();
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : putDataRequest.getAssets().entrySet()) {
            Asset asset2 = (Asset) entry.getValue();
            if (asset2.getData() != null) {
                try {
                    ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + asset2 + " read:" + parcelFileDescriptorArrCreatePipe[0] + " write:" + parcelFileDescriptorArrCreatePipe[1]);
                    }
                    putDataRequestZzr.putAsset((String) entry.getKey(), Asset.createFromFd(parcelFileDescriptorArrCreatePipe[0]));
                    FutureTask futureTaskZza = zza(parcelFileDescriptorArrCreatePipe[1], asset2.getData());
                    arrayList.add(futureTaskZza);
                    this.zzbkn.submit(futureTaskZza);
                } catch (IOException e) {
                    throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e);
                }
            } else if (asset2.getUri() != null) {
                try {
                    putDataRequestZzr.putAsset((String) entry.getKey(), Asset.createFromFd(getContext().getContentResolver().openFileDescriptor(asset2.getUri(), "r")));
                } catch (FileNotFoundException e2) {
                    new zzbo.zzq(zzbVar, arrayList).zza(new PutDataResponse(4005, null));
                    Log.w("WearableClient", "Couldn't resolve asset URI: " + asset2.getUri());
                    return;
                }
            } else {
                putDataRequestZzr.putAsset((String) entry.getKey(), asset2);
            }
        }
        ((zzax) zzqJ()).zza(new zzbo.zzq(zzbVar, arrayList), putDataRequestZzr);
    }

    public void zza(zza.zzb zzbVar, String str, Uri uri, long j, long j2) {
        try {
            this.zzbkn.execute(zzb(zzbVar, str, uri, j, j2));
        } catch (RuntimeException e) {
            zzbVar.zzw(new Status(8));
            throw e;
        }
    }

    public void zza(zza.zzb zzbVar, String str, Uri uri, boolean z) {
        try {
            this.zzbkn.execute(zzb(zzbVar, str, uri, z));
        } catch (RuntimeException e) {
            zzbVar.zzw(new Status(8));
            throw e;
        }
    }

    public void zza(zza.zzb zzbVar, String str, String str2, byte[] bArr) {
        ((zzax) zzqJ()).zza(new zzbo.zzt(zzbVar), str, str2, bArr);
    }

    public void zzb(zza.zzb zzbVar, int i) {
        ((zzax) zzqJ()).zza(new zzbo.zzf(zzbVar), i);
    }

    public void zzb(zza.zzb zzbVar, Uri uri, int i) {
        ((zzax) zzqJ()).zzb(new zzbo.zze(zzbVar), uri, i);
    }

    public void zze(zza.zzb zzbVar, String str, String str2) {
        ((zzax) zzqJ()).zza(new zzbo.zzp(zzbVar), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzew, reason: merged with bridge method [inline-methods] */
    public zzax zzW(IBinder iBinder) {
        return zzax.zza.zzeu(iBinder);
    }

    public void zzg(zza.zzb zzbVar, String str, int i) {
        ((zzax) zzqJ()).zza(new zzbo.zzg(zzbVar), str, i);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.wearable.BIND";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    public void zzh(zza.zzb zzbVar, String str, int i) {
        ((zzax) zzqJ()).zzb(new zzbo.zzd(zzbVar), str, i);
    }

    public void zzr(zza.zzb zzbVar) {
        ((zzax) zzqJ()).zzb(new zzbo.zzl(zzbVar));
    }

    public void zzr(zza.zzb zzbVar, String str) {
        ((zzax) zzqJ()).zzd(new zzbo.zza(zzbVar), str);
    }

    public void zzs(zza.zzb zzbVar) {
        ((zzax) zzqJ()).zzc(new zzbo.zzn(zzbVar));
    }

    public void zzs(zza.zzb zzbVar, String str) {
        ((zzax) zzqJ()).zze(new zzbo.zzs(zzbVar), str);
    }

    public void zzt(zza.zzb zzbVar) {
        ((zzax) zzqJ()).zzd(new zzbo.zzj(zzbVar));
    }

    public void zzt(zza.zzb zzbVar, String str) {
        ((zzax) zzqJ()).zzf(new zzbo.zzc(zzbVar), str);
    }

    public void zzu(zza.zzb zzbVar, String str) {
        zzt zztVar = new zzt();
        ((zzax) zzqJ()).zza(new zzbo.zzh(zzbVar, zztVar), zztVar, str);
    }

    public void zzv(zza.zzb zzbVar, String str) {
        zzt zztVar = new zzt();
        ((zzax) zzqJ()).zzb(new zzbo.zzi(zzbVar, zztVar), zztVar, str);
    }
}
