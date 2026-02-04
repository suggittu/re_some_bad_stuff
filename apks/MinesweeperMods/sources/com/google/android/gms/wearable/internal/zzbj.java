package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;

/* loaded from: classes2.dex */
final class zzbj implements ChannelApi.ChannelListener {
    private final String zzVo;
    private final ChannelApi.ChannelListener zzbtb;

    zzbj(String str, ChannelApi.ChannelListener channelListener) {
        this.zzVo = (String) com.google.android.gms.common.internal.zzx.zzz(str);
        this.zzbtb = (ChannelApi.ChannelListener) com.google.android.gms.common.internal.zzx.zzz(channelListener);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbj)) {
            return false;
        }
        zzbj zzbjVar = (zzbj) obj;
        return this.zzbtb.equals(zzbjVar.zzbtb) && this.zzVo.equals(zzbjVar.zzVo);
    }

    public final int hashCode() {
        return (this.zzVo.hashCode() * 31) + this.zzbtb.hashCode();
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onChannelClosed(Channel channel, int i, int i2) {
        this.zzbtb.onChannelClosed(channel, i, i2);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onChannelOpened(Channel channel) {
        this.zzbtb.onChannelOpened(channel);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onInputClosed(Channel channel, int i, int i2) {
        this.zzbtb.onInputClosed(channel, i, i2);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onOutputClosed(Channel channel, int i, int i2) {
        this.zzbtb.onOutputClosed(channel, i, i2);
    }
}
