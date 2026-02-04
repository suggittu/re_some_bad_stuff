package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ChannelApi;

/* loaded from: classes2.dex */
public final class ChannelEventParcelable implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzn();
    final int mVersionCode;
    final int type;
    final int zzbsa;
    final int zzbsb;
    final ChannelImpl zzbsc;

    ChannelEventParcelable(int i, ChannelImpl channelImpl, int i2, int i3, int i4) {
        this.mVersionCode = i;
        this.zzbsc = channelImpl;
        this.type = i2;
        this.zzbsa = i3;
        this.zzbsb = i4;
    }

    private static String zzlG(int i) {
        switch (i) {
            case 1:
                return "CHANNEL_OPENED";
            case 2:
                return "CHANNEL_CLOSED";
            case 3:
                return "INPUT_CLOSED";
            case 4:
                return "OUTPUT_CLOSED";
            default:
                return Integer.toString(i);
        }
    }

    private static String zzlH(int i) {
        switch (i) {
            case 0:
                return "CLOSE_REASON_NORMAL";
            case 1:
                return "CLOSE_REASON_DISCONNECTED";
            case 2:
                return "CLOSE_REASON_REMOTE_CLOSE";
            case 3:
                return "CLOSE_REASON_LOCAL_CLOSE";
            default:
                return Integer.toString(i);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ChannelEventParcelable[versionCode=" + this.mVersionCode + ", channel=" + this.zzbsc + ", type=" + zzlG(this.type) + ", closeReason=" + zzlH(this.zzbsa) + ", appErrorCode=" + this.zzbsb + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }

    public final void zza(ChannelApi.ChannelListener channelListener) {
        switch (this.type) {
            case 1:
                channelListener.onChannelOpened(this.zzbsc);
                break;
            case 2:
                channelListener.onChannelClosed(this.zzbsc, this.zzbsa, this.zzbsb);
                break;
            case 3:
                channelListener.onInputClosed(this.zzbsc, this.zzbsa, this.zzbsb);
                break;
            case 4:
                channelListener.onOutputClosed(this.zzbsc, this.zzbsa, this.zzbsb);
                break;
            default:
                Log.w("ChannelEventParcelable", "Unknown type: " + this.type);
                break;
        }
    }
}
