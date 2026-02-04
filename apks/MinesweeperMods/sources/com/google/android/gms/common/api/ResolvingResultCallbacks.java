package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public abstract class ResolvingResultCallbacks extends ResultCallbacks {
    private final Activity mActivity;
    private final int zzagz;

    protected ResolvingResultCallbacks(@NonNull Activity activity, int i) {
        this.mActivity = (Activity) zzx.zzb(activity, "Activity must not be null");
        this.zzagz = i;
    }

    @Override // com.google.android.gms.common.api.ResultCallbacks
    public final void onFailure(@NonNull Status status) {
        if (!status.hasResolution()) {
            onUnresolvableFailure(status);
            return;
        }
        try {
            status.startResolutionForResult(this.mActivity, this.zzagz);
        } catch (IntentSender.SendIntentException e) {
            Log.e("ResolvingResultCallback", "Failed to start resolution", e);
            onUnresolvableFailure(new Status(8));
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallbacks
    public abstract void onSuccess(@NonNull Result result);

    public abstract void onUnresolvableFailure(@NonNull Status status);
}
