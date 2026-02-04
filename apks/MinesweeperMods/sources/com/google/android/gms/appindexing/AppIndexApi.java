package com.google.android.gms.appindexing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import java.util.List;

/* loaded from: classes2.dex */
public interface AppIndexApi {

    @Deprecated
    public interface ActionResult {
        PendingResult end(GoogleApiClient googleApiClient);

        PendingResult getPendingResult();
    }

    @Deprecated
    public final class AppIndexingLink {
        public final Uri appIndexingUrl;
        public final int viewId;
        public final Uri webUrl;

        public AppIndexingLink(Uri uri, Uri uri2, View view) {
            this.appIndexingUrl = uri;
            this.webUrl = uri2;
            this.viewId = view.getId();
        }

        public AppIndexingLink(Uri uri, View view) {
            this(uri, null, view);
        }
    }

    @Deprecated
    ActionResult action(GoogleApiClient googleApiClient, Action action);

    PendingResult end(GoogleApiClient googleApiClient, Action action);

    PendingResult start(GoogleApiClient googleApiClient, Action action);

    @Deprecated
    PendingResult view(GoogleApiClient googleApiClient, Activity activity, Intent intent, String str, Uri uri, List list);

    @Deprecated
    PendingResult view(GoogleApiClient googleApiClient, Activity activity, Uri uri, String str, Uri uri2, List list);

    @Deprecated
    PendingResult viewEnd(GoogleApiClient googleApiClient, Activity activity, Intent intent);

    @Deprecated
    PendingResult viewEnd(GoogleApiClient googleApiClient, Activity activity, Uri uri);
}
