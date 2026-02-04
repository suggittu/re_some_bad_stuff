package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public interface DataApi {
    public static final String ACTION_DATA_CHANGED = "com.google.android.gms.wearable.DATA_CHANGED";
    public static final int FILTER_LITERAL = 0;
    public static final int FILTER_PREFIX = 1;

    public interface DataItemResult extends Result {
        DataItem getDataItem();
    }

    public interface DataListener {
        void onDataChanged(DataEventBuffer dataEventBuffer);
    }

    public interface DeleteDataItemsResult extends Result {
        int getNumDeleted();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FilterType {
    }

    public interface GetFdForAssetResult extends Releasable, Result {
        ParcelFileDescriptor getFd();

        InputStream getInputStream();
    }

    PendingResult addListener(GoogleApiClient googleApiClient, DataListener dataListener);

    PendingResult addListener(GoogleApiClient googleApiClient, DataListener dataListener, Uri uri, int i);

    PendingResult deleteDataItems(GoogleApiClient googleApiClient, Uri uri);

    PendingResult deleteDataItems(GoogleApiClient googleApiClient, Uri uri, int i);

    PendingResult getDataItem(GoogleApiClient googleApiClient, Uri uri);

    PendingResult getDataItems(GoogleApiClient googleApiClient);

    PendingResult getDataItems(GoogleApiClient googleApiClient, Uri uri);

    PendingResult getDataItems(GoogleApiClient googleApiClient, Uri uri, int i);

    PendingResult getFdForAsset(GoogleApiClient googleApiClient, Asset asset);

    PendingResult getFdForAsset(GoogleApiClient googleApiClient, DataItemAsset dataItemAsset);

    PendingResult putDataItem(GoogleApiClient googleApiClient, PutDataRequest putDataRequest);

    PendingResult removeListener(GoogleApiClient googleApiClient, DataListener dataListener);
}
