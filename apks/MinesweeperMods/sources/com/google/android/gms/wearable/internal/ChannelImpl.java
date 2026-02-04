package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.internal.zzb;
import com.google.android.gms.wearable.internal.zzl;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class ChannelImpl implements SafeParcelable, Channel {
    public static final Parcelable.Creator CREATOR = new zzo();
    private final String mPath;
    final int mVersionCode;
    private final String zzVo;
    private final String zzbrb;

    final class zza implements Channel.GetInputStreamResult {
        private final Status zzUX;
        private final InputStream zzbsh;

        zza(Status status, InputStream inputStream) {
            this.zzUX = (Status) com.google.android.gms.common.internal.zzx.zzz(status);
            this.zzbsh = inputStream;
        }

        @Override // com.google.android.gms.wearable.Channel.GetInputStreamResult
        public final InputStream getInputStream() {
            return this.zzbsh;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public final void release() throws IOException {
            if (this.zzbsh != null) {
                try {
                    this.zzbsh.close();
                } catch (IOException e) {
                }
            }
        }
    }

    final class zzb implements Channel.GetOutputStreamResult {
        private final Status zzUX;
        private final OutputStream zzbsi;

        zzb(Status status, OutputStream outputStream) {
            this.zzUX = (Status) com.google.android.gms.common.internal.zzx.zzz(status);
            this.zzbsi = outputStream;
        }

        @Override // com.google.android.gms.wearable.Channel.GetOutputStreamResult
        public final OutputStream getOutputStream() {
            return this.zzbsi;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public final void release() throws IOException {
            if (this.zzbsi != null) {
                try {
                    this.zzbsi.close();
                } catch (IOException e) {
                }
            }
        }
    }

    ChannelImpl(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.zzVo = (String) com.google.android.gms.common.internal.zzx.zzz(str);
        this.zzbrb = (String) com.google.android.gms.common.internal.zzx.zzz(str2);
        this.mPath = (String) com.google.android.gms.common.internal.zzx.zzz(str3);
    }

    private static zzb.zza zza(final String str, final IntentFilter[] intentFilterArr) {
        return new zzb.zza() { // from class: com.google.android.gms.wearable.internal.ChannelImpl.7
            @Override // com.google.android.gms.wearable.internal.zzb.zza
            public final void zza(zzbp zzbpVar, zza.zzb zzbVar, ChannelApi.ChannelListener channelListener, com.google.android.gms.common.api.internal.zzq zzqVar) {
                zzbpVar.zza(zzbVar, channelListener, zzqVar, str, intentFilterArr);
            }
        };
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult addListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        return com.google.android.gms.wearable.internal.zzb.zza(googleApiClient, zza(this.zzVo, new IntentFilter[]{zzbn.zzgM(ChannelApi.ACTION_CHANNEL_EVENT)}), channelListener);
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult close(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zzt(this, ChannelImpl.this.zzVo);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult close(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zzh(this, ChannelImpl.this.zzVo, i);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) obj;
        return this.zzVo.equals(channelImpl.zzVo) && com.google.android.gms.common.internal.zzw.equal(channelImpl.zzbrb, this.zzbrb) && com.google.android.gms.common.internal.zzw.equal(channelImpl.mPath, this.mPath) && channelImpl.mVersionCode == this.mVersionCode;
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult getInputStream(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zzu(this, ChannelImpl.this.zzVo);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzbt, reason: merged with bridge method [inline-methods] */
            public Channel.GetInputStreamResult zzc(Status status) {
                return new zza(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public String getNodeId() {
        return this.zzbrb;
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult getOutputStream(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zzv(this, ChannelImpl.this.zzVo);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzbu, reason: merged with bridge method [inline-methods] */
            public Channel.GetOutputStreamResult zzc(Status status) {
                return new zzb(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public String getPath() {
        return this.mPath;
    }

    public String getToken() {
        return this.zzVo;
    }

    public int hashCode() {
        return this.zzVo.hashCode();
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult receiveFile(GoogleApiClient googleApiClient, final Uri uri, final boolean z) {
        com.google.android.gms.common.internal.zzx.zzb(googleApiClient, "client is null");
        com.google.android.gms.common.internal.zzx.zzb(uri, "uri is null");
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zza(this, ChannelImpl.this.zzVo, uri, z);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult removeListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        com.google.android.gms.common.internal.zzx.zzb(googleApiClient, "client is null");
        com.google.android.gms.common.internal.zzx.zzb(channelListener, "listener is null");
        return googleApiClient.zza(new zzl.zzb(googleApiClient, channelListener, this.zzVo));
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult sendFile(GoogleApiClient googleApiClient, Uri uri) {
        return sendFile(googleApiClient, uri, 0L, -1L);
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult sendFile(GoogleApiClient googleApiClient, final Uri uri, final long j, final long j2) {
        com.google.android.gms.common.internal.zzx.zzb(googleApiClient, "client is null");
        com.google.android.gms.common.internal.zzx.zzb(this.zzVo, "token is null");
        com.google.android.gms.common.internal.zzx.zzb(uri, "uri is null");
        com.google.android.gms.common.internal.zzx.zzb(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
        com.google.android.gms.common.internal.zzx.zzb(j2 >= 0 || j2 == -1, "invalid length: %s", Long.valueOf(j2));
        return googleApiClient.zza(new zzi(googleApiClient) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzbp zzbpVar) {
                zzbpVar.zza(this, ChannelImpl.this.zzVo, uri, j, j2);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.zzVo + "', nodeId='" + this.zzbrb + "', path='" + this.mPath + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
