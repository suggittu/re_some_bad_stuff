package com.google.android.gms.tagmanager;

import com.google.android.gms.analytics.CampaignTrackingReceiver;

/* loaded from: classes2.dex */
public final class InstallReferrerReceiver extends CampaignTrackingReceiver {
    @Override // com.google.android.gms.analytics.CampaignTrackingReceiver
    protected final void zzaV(String str) {
        zzax.zzgh(str);
    }

    @Override // com.google.android.gms.analytics.CampaignTrackingReceiver
    protected final Class zziB() {
        return InstallReferrerService.class;
    }
}
