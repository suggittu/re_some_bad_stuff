package com.google.android.gms.nearby.messages;

import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* loaded from: classes2.dex */
public interface Messages {
    PendingResult getPermissionStatus(GoogleApiClient googleApiClient);

    void handleIntent(Intent intent, MessageListener messageListener);

    PendingResult publish(GoogleApiClient googleApiClient, Message message);

    PendingResult publish(GoogleApiClient googleApiClient, Message message, PublishOptions publishOptions);

    @Deprecated
    PendingResult publish(GoogleApiClient googleApiClient, Message message, Strategy strategy);

    PendingResult registerStatusCallback(GoogleApiClient googleApiClient, StatusCallback statusCallback);

    PendingResult subscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult subscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent, SubscribeOptions subscribeOptions);

    PendingResult subscribe(GoogleApiClient googleApiClient, MessageListener messageListener);

    @Deprecated
    PendingResult subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, Strategy strategy);

    @Deprecated
    PendingResult subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, Strategy strategy, MessageFilter messageFilter);

    PendingResult subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, SubscribeOptions subscribeOptions);

    PendingResult unpublish(GoogleApiClient googleApiClient, Message message);

    PendingResult unregisterStatusCallback(GoogleApiClient googleApiClient, StatusCallback statusCallback);

    PendingResult unsubscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult unsubscribe(GoogleApiClient googleApiClient, MessageListener messageListener);
}
