package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.plus.PlusShare;

/* loaded from: classes2.dex */
public final class GameNotificationRef extends zzc implements GameNotification {
    GameNotificationRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final long getId() {
        return getLong("_id");
    }

    public final String getText() {
        return getString("text");
    }

    public final String getTitle() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
    }

    public final int getType() {
        return getInteger("type");
    }

    public final String toString() {
        return zzw.zzy(this).zzg("Id", Long.valueOf(getId())).zzg("NotificationId", zzxt()).zzg("Type", Integer.valueOf(getType())).zzg("Title", getTitle()).zzg("Ticker", zzxu()).zzg("Text", getText()).zzg("CoalescedText", zzxv()).zzg("isAcknowledged", Boolean.valueOf(zzxw())).zzg("isSilent", Boolean.valueOf(zzxx())).toString();
    }

    public final String zzxt() {
        return getString("notification_id");
    }

    public final String zzxu() {
        return getString("ticker");
    }

    public final String zzxv() {
        return getString("coalesced_text");
    }

    public final boolean zzxw() {
        return getInteger("acknowledged") > 0;
    }

    public final boolean zzxx() {
        return getInteger("alert_level") == 0;
    }
}
