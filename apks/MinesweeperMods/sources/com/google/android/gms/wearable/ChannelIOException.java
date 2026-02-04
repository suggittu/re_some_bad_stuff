package com.google.android.gms.wearable;

import java.io.IOException;

/* loaded from: classes2.dex */
public class ChannelIOException extends IOException {
    private final int zzbqW;
    private final int zzbqX;

    public ChannelIOException(String str, int i, int i2) {
        super(str);
        this.zzbqW = i;
        this.zzbqX = i2;
    }

    public int getAppSpecificErrorCode() {
        return this.zzbqX;
    }

    public int getCloseReason() {
        return this.zzbqW;
    }
}
