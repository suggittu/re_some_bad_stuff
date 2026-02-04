package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.util.List;

/* loaded from: classes2.dex */
public interface NodeApi {

    public interface GetConnectedNodesResult extends Result {
        List getNodes();
    }

    public interface GetLocalNodeResult extends Result {
        Node getNode();
    }

    @Deprecated
    public interface NodeListener {
        @Deprecated
        void onPeerConnected(Node node);

        @Deprecated
        void onPeerDisconnected(Node node);
    }

    @Deprecated
    public interface zza {
        @Deprecated
        void onConnectedNodes(List list);
    }

    @Deprecated
    PendingResult addListener(GoogleApiClient googleApiClient, NodeListener nodeListener);

    PendingResult getConnectedNodes(GoogleApiClient googleApiClient);

    PendingResult getLocalNode(GoogleApiClient googleApiClient);

    @Deprecated
    PendingResult removeListener(GoogleApiClient googleApiClient, NodeListener nodeListener);
}
