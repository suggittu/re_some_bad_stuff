package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.zzb;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class zzx implements DataApi {

    public class zza implements DataApi.DataItemResult {
        private final Status zzUX;
        private final DataItem zzbsv;

        public zza(Status status, DataItem dataItem) {
            this.zzUX = status;
            this.zzbsv = dataItem;
        }

        @Override // com.google.android.gms.wearable.DataApi.DataItemResult
        public DataItem getDataItem() {
            return this.zzbsv;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    public class zzb implements DataApi.DeleteDataItemsResult {
        private final Status zzUX;
        private final int zzbsw;

        public zzb(Status status, int i) {
            this.zzUX = status;
            this.zzbsw = i;
        }

        @Override // com.google.android.gms.wearable.DataApi.DeleteDataItemsResult
        public int getNumDeleted() {
            return this.zzbsw;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    public class zzc implements DataApi.GetFdForAssetResult {
        private volatile boolean mClosed = false;
        private final Status zzUX;
        private volatile InputStream zzbsh;
        private volatile ParcelFileDescriptor zzbsx;

        public zzc(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzUX = status;
            this.zzbsx = parcelFileDescriptor;
        }

        @Override // com.google.android.gms.wearable.DataApi.GetFdForAssetResult
        public ParcelFileDescriptor getFd() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the file descriptor after release().");
            }
            return this.zzbsx;
        }

        @Override // com.google.android.gms.wearable.DataApi.GetFdForAssetResult
        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            }
            if (this.zzbsx == null) {
                return null;
            }
            if (this.zzbsh == null) {
                this.zzbsh = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbsx);
            }
            return this.zzbsh;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() throws IOException {
            if (this.zzbsx == null) {
                return;
            }
            if (this.mClosed) {
                throw new IllegalStateException("releasing an already released result.");
            }
            try {
                if (this.zzbsh != null) {
                    this.zzbsh.close();
                } else {
                    this.zzbsx.close();
                }
                this.mClosed = true;
                this.zzbsx = null;
                this.zzbsh = null;
            } catch (IOException e) {
            }
        }
    }

    private PendingResult zza(GoogleApiClient googleApiClient, DataApi.DataListener dataListener, IntentFilter[] intentFilterArr) {
        return com.google.android.gms.wearable.internal.zzb.zza(googleApiClient, zza(intentFilterArr), dataListener);
    }

    private static zzb.zza zza(final IntentFilter[] intentFilterArr) {
        return new zzb.zza() { // from class: com.google.android.gms.wearable.internal.zzx.8
            @Override // com.google.android.gms.wearable.internal.zzb.zza
            public final void zza(zzbp zzbpVar, zza.zzb zzbVar, DataApi.DataListener dataListener, com.google.android.gms.common.api.internal.zzq zzqVar) {
                zzbpVar.zza(zzbVar, dataListener, zzqVar, intentFilterArr);
            }
        };
    }

    private void zza(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        }
        if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        }
        if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult addListener(GoogleApiClient googleApiClient, DataApi.DataListener dataListener) {
        return zza(googleApiClient, dataListener, new IntentFilter[]{zzbn.zzgM(DataApi.ACTION_DATA_CHANGED)});
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult addListener(GoogleApiClient googleApiClient, DataApi.DataListener dataListener, Uri uri, int i) {
        com.google.android.gms.common.internal.zzx.zzb(uri != null, "uri must not be null");
        com.google.android.gms.common.internal.zzx.zzb(i == 0 || i == 1, "invalid filter type");
        return zza(googleApiClient, dataListener, new IntentFilter[]{zzbn.zza(DataApi.ACTION_DATA_CHANGED, uri, i)});
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult deleteDataItems(GoogleApiClient googleApiClient, Uri uri) {
        return deleteDataItems(googleApiClient, uri, 0);
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult deleteDataItems(GoogleApiClient googleApiClient, final Uri uri, final int i) {
        com.google.android.gms.common.internal.zzx.zzb(uri != null, "uri must not be null");
        com.google.android.gms.common.internal.zzx.zzb(i == 0 || i == 1, "invalid filter type");
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzx.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zzb(this, uri, i);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzbx, reason: merged with bridge method [inline-methods] */
            public DataApi.DeleteDataItemsResult zzc(Status status) {
                return new zzb(status, 0);
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult getDataItem(GoogleApiClient googleApiClient, final Uri uri) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzx.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zza(this, uri);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzbv, reason: merged with bridge method [inline-methods] */
            public DataApi.DataItemResult zzc(Status status) {
                return new zza(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult getDataItems(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzx.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zzr(this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzbw, reason: merged with bridge method [inline-methods] */
            public DataItemBuffer zzc(Status status) {
                return new DataItemBuffer(DataHolder.zzbI(status.getStatusCode()));
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult getDataItems(GoogleApiClient googleApiClient, Uri uri) {
        return getDataItems(googleApiClient, uri, 0);
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult getDataItems(GoogleApiClient googleApiClient, final Uri uri, final int i) {
        com.google.android.gms.common.internal.zzx.zzb(uri != null, "uri must not be null");
        com.google.android.gms.common.internal.zzx.zzb(i == 0 || i == 1, "invalid filter type");
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzx.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zza(this, uri, i);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzbw, reason: merged with bridge method [inline-methods] */
            public DataItemBuffer zzc(Status status) {
                return new DataItemBuffer(DataHolder.zzbI(status.getStatusCode()));
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult getFdForAsset(GoogleApiClient googleApiClient, final Asset asset) {
        zza(asset);
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzx.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zza(this, asset);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzby, reason: merged with bridge method [inline-methods] */
            public DataApi.GetFdForAssetResult zzc(Status status) {
                return new zzc(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult getFdForAsset(GoogleApiClient googleApiClient, final DataItemAsset dataItemAsset) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzx.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zza(this, dataItemAsset);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzby, reason: merged with bridge method [inline-methods] */
            public DataApi.GetFdForAssetResult zzc(Status status) {
                return new zzc(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult putDataItem(GoogleApiClient googleApiClient, final PutDataRequest putDataRequest) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzx.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) throws IOException {
                zzbpVar.zza(this, putDataRequest);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzbv, reason: merged with bridge method [inline-methods] */
            public DataApi.DataItemResult zzc(Status status) {
                return new zza(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult removeListener(GoogleApiClient googleApiClient, final DataApi.DataListener dataListener) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzx.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zza(this, dataListener);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }
}
