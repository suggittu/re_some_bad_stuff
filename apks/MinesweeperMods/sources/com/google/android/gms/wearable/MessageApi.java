package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public interface MessageApi {
    public static final String ACTION_MESSAGE_RECEIVED = "com.google.android.gms.wearable.MESSAGE_RECEIVED";
    public static final int FILTER_LITERAL = 0;
    public static final int FILTER_PREFIX = 1;
    public static final int UNKNOWN_REQUEST_ID = -1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FilterType {
    }

    public interface MessageListener {
        void onMessageReceived(MessageEvent messageEvent);
    }

    public interface SendMessageResult extends Result {
        int getRequestId();
    }

    PendingResult addListener(GoogleApiClient googleApiClient, MessageListener messageListener);

    PendingResult addListener(GoogleApiClient googleApiClient, MessageListener messageListener, Uri uri, int i);

    PendingResult removeListener(GoogleApiClient googleApiClient, MessageListener messageListener);

    PendingResult sendMessage(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr);
}
