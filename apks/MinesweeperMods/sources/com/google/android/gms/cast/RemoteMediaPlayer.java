package com.google.android.gms.cast;

import android.annotation.SuppressLint;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"MissingRemoteException"})
/* loaded from: classes2.dex */
public class RemoteMediaPlayer implements Cast.MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private OnPreloadStatusUpdatedListener zzabG;
    private OnQueueStatusUpdatedListener zzabH;
    private OnMetadataUpdatedListener zzabI;
    private OnStatusUpdatedListener zzabJ;
    private final Object zzpV = new Object();
    private final zza zzabF = new zza();
    private final zzm zzabE = new zzm(null) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.1
        @Override // com.google.android.gms.cast.internal.zzm
        protected void onMetadataUpdated() {
            RemoteMediaPlayer.this.onMetadataUpdated();
        }

        @Override // com.google.android.gms.cast.internal.zzm
        protected void onPreloadStatusUpdated() {
            RemoteMediaPlayer.this.onPreloadStatusUpdated();
        }

        @Override // com.google.android.gms.cast.internal.zzm
        protected void onQueueStatusUpdated() {
            RemoteMediaPlayer.this.onQueueStatusUpdated();
        }

        @Override // com.google.android.gms.cast.internal.zzm
        protected void onStatusUpdated() {
            RemoteMediaPlayer.this.onStatusUpdated();
        }
    };

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnPreloadStatusUpdatedListener {
        void onPreloadStatusUpdated();
    }

    public interface OnQueueStatusUpdatedListener {
        void onQueueStatusUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    class zza implements zzn {
        private GoogleApiClient zzaci;
        private long zzacj = 0;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$zza$zza, reason: collision with other inner class name */
        final class C0033zza implements ResultCallback {
            private final long zzack;

            C0033zza(long j) {
                this.zzack = j;
            }

            @Override // com.google.android.gms.common.api.ResultCallback
            /* renamed from: zzp, reason: merged with bridge method [inline-methods] */
            public final void onResult(Status status) {
                if (status.isSuccess()) {
                    return;
                }
                RemoteMediaPlayer.this.zzabE.zzb(this.zzack, status.getStatusCode());
            }
        }

        public zza() {
        }

        @Override // com.google.android.gms.cast.internal.zzn
        public void zza(String str, String str2, long j, String str3) throws IOException {
            if (this.zzaci == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.zzaci, str, str2).setResultCallback(new C0033zza(j));
        }

        public void zzc(GoogleApiClient googleApiClient) {
            this.zzaci = googleApiClient;
        }

        @Override // com.google.android.gms.cast.internal.zzn
        public long zznQ() {
            long j = this.zzacj + 1;
            this.zzacj = j;
            return j;
        }
    }

    abstract class zzb extends com.google.android.gms.cast.internal.zzb {
        zzo zzacm;

        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzacm = new zzo() { // from class: com.google.android.gms.cast.RemoteMediaPlayer.zzb.1
                @Override // com.google.android.gms.cast.internal.zzo
                public void zza(long j, int i, Object obj) {
                    zzb.this.zza(new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
                }

                @Override // com.google.android.gms.cast.internal.zzo
                public void zzy(long j) {
                    zzb.this.zza(zzb.this.zzc(new Status(2103)));
                }
            };
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
        public MediaChannelResult zzc(final Status status) {
            return new MediaChannelResult() { // from class: com.google.android.gms.cast.RemoteMediaPlayer.zzb.2
                @Override // com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult
                public JSONObject getCustomData() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    final class zzc implements MediaChannelResult {
        private final Status zzUX;
        private final JSONObject zzaaU;

        zzc(Status status, JSONObject jSONObject) {
            this.zzUX = status;
            this.zzaaU = jSONObject;
        }

        @Override // com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult
        public final JSONObject getCustomData() {
            return this.zzaaU;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    public RemoteMediaPlayer() {
        this.zzabE.zza(this.zzabF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMetadataUpdated() {
        if (this.zzabI != null) {
            this.zzabI.onMetadataUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPreloadStatusUpdated() {
        if (this.zzabG != null) {
            this.zzabG.onPreloadStatusUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onQueueStatusUpdated() {
        if (this.zzabH != null) {
            this.zzabH.onQueueStatusUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStatusUpdated() {
        if (this.zzabJ != null) {
            this.zzabJ.onStatusUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zzbf(int i) {
        MediaStatus mediaStatus = getMediaStatus();
        for (int i2 = 0; i2 < mediaStatus.getQueueItemCount(); i2++) {
            if (mediaStatus.getQueueItem(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.zzpV) {
            approximateStreamPosition = this.zzabE.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.zzpV) {
            mediaInfo = this.zzabE.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.zzpV) {
            mediaStatus = this.zzabE.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.zzabE.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.zzpV) {
            streamDuration = this.zzabE.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult load(GoogleApiClient googleApiClient, MediaInfo mediaInfo) {
        return load(googleApiClient, mediaInfo, true, 0L, null, null);
    }

    public PendingResult load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z) {
        return load(googleApiClient, mediaInfo, z, 0L, null, null);
    }

    public PendingResult load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j) {
        return load(googleApiClient, mediaInfo, z, j, null, null);
    }

    public PendingResult load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) {
        return load(googleApiClient, mediaInfo, z, j, null, jSONObject);
    }

    public PendingResult load(final GoogleApiClient googleApiClient, final MediaInfo mediaInfo, final boolean z, final long j, final long[] jArr, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.12
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, mediaInfo, z, j, jArr, jSONObject);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    } finally {
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
    public void onMessageReceived(CastDevice castDevice, String str, String str2) throws JSONException {
        this.zzabE.zzcf(str2);
    }

    public PendingResult pause(GoogleApiClient googleApiClient) {
        return pause(googleApiClient, null);
    }

    public PendingResult pause(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.17
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, jSONObject);
                        } finally {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    }
                }
            }
        });
    }

    public PendingResult play(GoogleApiClient googleApiClient) {
        return play(googleApiClient, null);
    }

    public PendingResult play(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.19
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zzc(this.zzacm, jSONObject);
                        } finally {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    }
                }
            }
        });
    }

    public PendingResult queueAppendItem(GoogleApiClient googleApiClient, MediaQueueItem mediaQueueItem, JSONObject jSONObject) {
        return queueInsertItems(googleApiClient, new MediaQueueItem[]{mediaQueueItem}, 0, jSONObject);
    }

    public PendingResult queueInsertAndPlayItem(final GoogleApiClient googleApiClient, final MediaQueueItem mediaQueueItem, final int i, final long j, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, new MediaQueueItem[]{mediaQueueItem}, i, 0, 0, j, jSONObject);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult queueInsertAndPlayItem(GoogleApiClient googleApiClient, MediaQueueItem mediaQueueItem, int i, JSONObject jSONObject) {
        return queueInsertAndPlayItem(googleApiClient, mediaQueueItem, i, -1L, jSONObject);
    }

    public PendingResult queueInsertItems(final GoogleApiClient googleApiClient, final MediaQueueItem[] mediaQueueItemArr, final int i, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, mediaQueueItemArr, i, 0, -1, -1L, jSONObject);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    } finally {
                    }
                }
            }
        });
    }

    public PendingResult queueJumpToItem(final GoogleApiClient googleApiClient, final int i, final long j, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.15
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    if (RemoteMediaPlayer.this.zzbf(i) == -1) {
                        zza(zzc(new Status(0)));
                        return;
                    }
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, i, j, (MediaQueueItem[]) null, 0, (Integer) null, jSONObject);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult queueJumpToItem(GoogleApiClient googleApiClient, int i, JSONObject jSONObject) {
        return queueJumpToItem(googleApiClient, i, -1L, jSONObject);
    }

    public PendingResult queueLoad(final GoogleApiClient googleApiClient, final MediaQueueItem[] mediaQueueItemArr, final int i, final int i2, final long j, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, mediaQueueItemArr, i, i2, j, jSONObject);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    } finally {
                    }
                }
            }
        });
    }

    public PendingResult queueLoad(GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, int i, int i2, JSONObject jSONObject) {
        return queueLoad(googleApiClient, mediaQueueItemArr, i, i2, -1L, jSONObject);
    }

    public PendingResult queueMoveItemToNewIndex(final GoogleApiClient googleApiClient, final int i, final int i2, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.16
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    int iZzbf = RemoteMediaPlayer.this.zzbf(i);
                    if (iZzbf == -1) {
                        zza(zzc(new Status(0)));
                        return;
                    }
                    if (i2 < 0) {
                        zza(zzc(new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", Integer.valueOf(i2)))));
                        return;
                    }
                    if (iZzbf == i2) {
                        zza(zzc(new Status(0)));
                        return;
                    }
                    MediaQueueItem queueItem = RemoteMediaPlayer.this.getMediaStatus().getQueueItem(i2 > iZzbf ? i2 + 1 : i2);
                    int itemId = queueItem != null ? queueItem.getItemId() : 0;
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, new int[]{i}, itemId, jSONObject);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult queueNext(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.11
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, 0, -1L, (MediaQueueItem[]) null, 1, (Integer) null, jSONObject);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult queuePrev(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, 0, -1L, (MediaQueueItem[]) null, -1, (Integer) null, jSONObject);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult queueRemoveItem(final GoogleApiClient googleApiClient, final int i, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.14
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    if (RemoteMediaPlayer.this.zzbf(i) == -1) {
                        zza(zzc(new Status(0)));
                        return;
                    }
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, new int[]{i}, jSONObject);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult queueRemoveItems(final GoogleApiClient googleApiClient, final int[] iArr, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, iArr, jSONObject);
                        } finally {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    }
                }
            }
        });
    }

    public PendingResult queueReorderItems(final GoogleApiClient googleApiClient, final int[] iArr, final int i, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, iArr, i, jSONObject);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult queueSetRepeatMode(final GoogleApiClient googleApiClient, final int i, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.13
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, 0, -1L, (MediaQueueItem[]) null, 0, Integer.valueOf(i), jSONObject);
                        } finally {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    }
                }
            }
        });
    }

    public PendingResult queueUpdateItems(final GoogleApiClient googleApiClient, final MediaQueueItem[] mediaQueueItemArr, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, 0, -1L, mediaQueueItemArr, 0, (Integer) null, jSONObject);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult requestStatus(final GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.23
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult seek(GoogleApiClient googleApiClient, long j) {
        return seek(googleApiClient, j, 0, null);
    }

    public PendingResult seek(GoogleApiClient googleApiClient, long j, int i) {
        return seek(googleApiClient, j, i, null);
    }

    public PendingResult seek(final GoogleApiClient googleApiClient, final long j, final int i, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.20
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, j, i, jSONObject);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult setActiveMediaTracks(final GoogleApiClient googleApiClient, final long[] jArr) {
        if (jArr == null) {
            throw new IllegalArgumentException("trackIds cannot be null");
        }
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, jArr);
                        } finally {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    }
                }
            }
        });
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener onMetadataUpdatedListener) {
        this.zzabI = onMetadataUpdatedListener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener onPreloadStatusUpdatedListener) {
        this.zzabG = onPreloadStatusUpdatedListener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener onQueueStatusUpdatedListener) {
        this.zzabH = onQueueStatusUpdatedListener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener onStatusUpdatedListener) {
        this.zzabJ = onStatusUpdatedListener;
    }

    public PendingResult setStreamMute(GoogleApiClient googleApiClient, boolean z) {
        return setStreamMute(googleApiClient, z, null);
    }

    public PendingResult setStreamMute(final GoogleApiClient googleApiClient, final boolean z, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.22
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, z, jSONObject);
                        } finally {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (IOException | IllegalStateException e) {
                        zza(zzc(new Status(2100)));
                    }
                }
            }
        });
    }

    public PendingResult setStreamVolume(GoogleApiClient googleApiClient, double d) {
        return setStreamVolume(googleApiClient, d, null);
    }

    public PendingResult setStreamVolume(final GoogleApiClient googleApiClient, final double d, final JSONObject jSONObject) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.21
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, d, jSONObject);
                        } finally {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                        zza(zzc(new Status(2100)));
                    }
                }
            }
        });
    }

    public PendingResult setTextTrackStyle(final GoogleApiClient googleApiClient, final TextTrackStyle textTrackStyle) {
        if (textTrackStyle == null) {
            throw new IllegalArgumentException("trackStyle cannot be null");
        }
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, textTrackStyle);
                        } finally {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    }
                }
            }
        });
    }

    public PendingResult stop(GoogleApiClient googleApiClient) {
        return stop(googleApiClient, null);
    }

    public PendingResult stop(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.18
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zzb(this.zzacm, jSONObject);
                        } finally {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    }
                }
            }
        });
    }
}
