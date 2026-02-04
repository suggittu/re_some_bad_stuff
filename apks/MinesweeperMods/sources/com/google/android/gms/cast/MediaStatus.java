package com.google.android.gms.cast;

import android.util.SparseArray;
import com.google.android.gms.cast.internal.zzf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class MediaStatus {
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_BACKWARD = 32;
    public static final long COMMAND_SKIP_FORWARD = 16;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int REPEAT_MODE_REPEAT_ALL = 1;
    public static final int REPEAT_MODE_REPEAT_ALL_AND_SHUFFLE = 3;
    public static final int REPEAT_MODE_REPEAT_OFF = 0;
    public static final int REPEAT_MODE_REPEAT_SINGLE = 2;
    private JSONObject zzaaU;
    private MediaInfo zzaaV;
    private long[] zzabj;
    private long zzabm;
    private double zzabn;
    private int zzabo;
    private int zzabp;
    private long zzabq;
    private long zzabr;
    private double zzabs;
    private boolean zzabt;
    private int zzabl = 0;
    private int zzabu = 0;
    private int zzabv = 0;
    private final zza zzabw = new zza();

    class zza {
        private int zzabx = 0;
        private List zzaby = new ArrayList();
        private SparseArray zzabz = new SparseArray();

        zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.zzabx = 0;
            this.zzaby.clear();
            this.zzabz.clear();
        }

        private void zza(MediaQueueItem[] mediaQueueItemArr) {
            this.zzaby.clear();
            this.zzabz.clear();
            for (int i = 0; i < mediaQueueItemArr.length; i++) {
                MediaQueueItem mediaQueueItem = mediaQueueItemArr[i];
                this.zzaby.add(mediaQueueItem);
                this.zzabz.put(mediaQueueItem.getItemId(), Integer.valueOf(i));
            }
        }

        private Integer zzbd(int i) {
            return (Integer) this.zzabz.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00f7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean zzh(org.json.JSONObject r11) throws org.json.JSONException {
            /*
                Method dump skipped, instructions count: 280
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaStatus.zza.zzh(org.json.JSONObject):boolean");
        }

        public int getItemCount() {
            return this.zzaby.size();
        }

        public int getRepeatMode() {
            return this.zzabx;
        }

        public MediaQueueItem zzbb(int i) {
            Integer num = (Integer) this.zzabz.get(i);
            if (num == null) {
                return null;
            }
            return (MediaQueueItem) this.zzaby.get(num.intValue());
        }

        public MediaQueueItem zzbc(int i) {
            if (i < 0 || i >= this.zzaby.size()) {
                return null;
            }
            return (MediaQueueItem) this.zzaby.get(i);
        }

        public List zznP() {
            return Collections.unmodifiableList(this.zzaby);
        }
    }

    public MediaStatus(JSONObject jSONObject) throws JSONException {
        zza(jSONObject, 0);
    }

    private boolean zzi(int i, int i2) {
        return i == 1 && i2 == 0;
    }

    public final long[] getActiveTrackIds() {
        return this.zzabj;
    }

    public final int getCurrentItemId() {
        return this.zzabl;
    }

    public final JSONObject getCustomData() {
        return this.zzaaU;
    }

    public final int getIdleReason() {
        return this.zzabp;
    }

    public final int getLoadingItemId() {
        return this.zzabu;
    }

    public final MediaInfo getMediaInfo() {
        return this.zzaaV;
    }

    public final double getPlaybackRate() {
        return this.zzabn;
    }

    public final int getPlayerState() {
        return this.zzabo;
    }

    public final int getPreloadedItemId() {
        return this.zzabv;
    }

    public final MediaQueueItem getQueueItem(int i) {
        return this.zzabw.zzbc(i);
    }

    public final MediaQueueItem getQueueItemById(int i) {
        return this.zzabw.zzbb(i);
    }

    public final int getQueueItemCount() {
        return this.zzabw.getItemCount();
    }

    public final List getQueueItems() {
        return this.zzabw.zznP();
    }

    public final int getQueueRepeatMode() {
        return this.zzabw.getRepeatMode();
    }

    public final long getStreamPosition() {
        return this.zzabq;
    }

    public final double getStreamVolume() {
        return this.zzabs;
    }

    public final boolean isMediaCommandSupported(long j) {
        return (this.zzabr & j) != 0;
    }

    public final boolean isMute() {
        return this.zzabt;
    }

    public final int zza(JSONObject jSONObject, int i) throws JSONException {
        int i2;
        long[] jArr;
        boolean z;
        int i3;
        boolean z2 = true;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.zzabm) {
            this.zzabm = j;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            int i4 = string.equals("IDLE") ? 1 : string.equals("PLAYING") ? 2 : string.equals("PAUSED") ? 3 : string.equals("BUFFERING") ? 4 : 0;
            if (i4 != this.zzabo) {
                this.zzabo = i4;
                i2 |= 2;
            }
            if (i4 == 1 && jSONObject.has("idleReason")) {
                String string2 = jSONObject.getString("idleReason");
                int i5 = string2.equals("CANCELLED") ? 2 : string2.equals("INTERRUPTED") ? 3 : string2.equals("FINISHED") ? 1 : string2.equals("ERROR") ? 4 : 0;
                if (i5 != this.zzabp) {
                    this.zzabp = i5;
                    i2 |= 2;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            double d = jSONObject.getDouble("playbackRate");
            if (this.zzabn != d) {
                this.zzabn = d;
                i2 |= 2;
            }
        }
        if (jSONObject.has("currentTime") && (i & 2) == 0) {
            long jZzg = zzf.zzg(jSONObject.getDouble("currentTime"));
            if (jZzg != this.zzabq) {
                this.zzabq = jZzg;
                i2 |= 2;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            long j2 = jSONObject.getLong("supportedMediaCommands");
            if (j2 != this.zzabr) {
                this.zzabr = j2;
                i2 |= 2;
            }
        }
        if (jSONObject.has("volume") && (i & 1) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("volume");
            double d2 = jSONObject2.getDouble("level");
            if (d2 != this.zzabs) {
                this.zzabs = d2;
                i2 |= 2;
            }
            boolean z3 = jSONObject2.getBoolean("muted");
            if (z3 != this.zzabt) {
                this.zzabt = z3;
                i2 |= 2;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (int i6 = 0; i6 < length; i6++) {
                jArr2[i6] = jSONArray.getLong(i6);
            }
            if (this.zzabj != null && this.zzabj.length == length) {
                int i7 = 0;
                while (true) {
                    if (i7 >= length) {
                        z2 = false;
                        break;
                    }
                    if (this.zzabj[i7] != jArr2[i7]) {
                        break;
                    }
                    i7++;
                }
            }
            if (z2) {
                this.zzabj = jArr2;
            }
            z = z2;
            jArr = jArr2;
        } else if (this.zzabj != null) {
            z = true;
            jArr = null;
        } else {
            jArr = null;
            z = false;
        }
        if (z) {
            this.zzabj = jArr;
            i2 |= 2;
        }
        if (jSONObject.has("customData")) {
            this.zzaaU = jSONObject.getJSONObject("customData");
            i2 |= 2;
        }
        if (jSONObject.has("media")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("media");
            this.zzaaV = new MediaInfo(jSONObject3);
            i2 |= 2;
            if (jSONObject3.has("metadata")) {
                i2 |= 4;
            }
        }
        if (jSONObject.has("currentItemId") && this.zzabl != (i3 = jSONObject.getInt("currentItemId"))) {
            this.zzabl = i3;
            i2 |= 2;
        }
        int iOptInt = jSONObject.optInt("preloadedItemId", 0);
        if (this.zzabv != iOptInt) {
            this.zzabv = iOptInt;
            i2 |= 16;
        }
        int iOptInt2 = jSONObject.optInt("loadingItemId", 0);
        if (this.zzabu != iOptInt2) {
            this.zzabu = iOptInt2;
            i2 |= 2;
        }
        if (!zzi(this.zzabo, this.zzabu)) {
            return this.zzabw.zzh(jSONObject) ? i2 | 8 : i2;
        }
        this.zzabl = 0;
        this.zzabu = 0;
        this.zzabv = 0;
        if (this.zzabw.getItemCount() <= 0) {
            return i2;
        }
        this.zzabw.clear();
        return i2 | 8;
    }

    public final long zznO() {
        return this.zzabm;
    }
}
