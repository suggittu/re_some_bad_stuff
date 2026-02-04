package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* loaded from: classes2.dex */
public interface CapabilityApi {
    public static final String ACTION_CAPABILITY_CHANGED = "com.google.android.gms.wearable.CAPABILITY_CHANGED";
    public static final int FILTER_ALL = 0;
    public static final int FILTER_LITERAL = 0;
    public static final int FILTER_PREFIX = 1;
    public static final int FILTER_REACHABLE = 1;

    public interface AddLocalCapabilityResult extends Result {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CapabilityFilterType {
    }

    public interface CapabilityListener {
        void onCapabilityChanged(CapabilityInfo capabilityInfo);
    }

    public interface GetAllCapabilitiesResult extends Result {
        Map getAllCapabilities();
    }

    public interface GetCapabilityResult extends Result {
        CapabilityInfo getCapability();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NodeFilterType {
    }

    public interface RemoveLocalCapabilityResult extends Result {
    }

    PendingResult addCapabilityListener(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, String str);

    PendingResult addListener(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, Uri uri, int i);

    PendingResult addLocalCapability(GoogleApiClient googleApiClient, String str);

    PendingResult getAllCapabilities(GoogleApiClient googleApiClient, int i);

    PendingResult getCapability(GoogleApiClient googleApiClient, String str, int i);

    PendingResult removeCapabilityListener(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, String str);

    PendingResult removeListener(GoogleApiClient googleApiClient, CapabilityListener capabilityListener);

    PendingResult removeLocalCapability(GoogleApiClient googleApiClient, String str);
}
