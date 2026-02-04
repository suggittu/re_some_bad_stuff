package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    private final String zzaaN;
    private int zzaaO;
    private String zzaaP;
    private MediaMetadata zzaaQ;
    private long zzaaR;
    private List zzaaS;
    private TextTrackStyle zzaaT;
    private JSONObject zzaaU;

    public class Builder {
        private final MediaInfo zzaaV;

        public Builder(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.zzaaV = new MediaInfo(str);
        }

        public MediaInfo build() {
            this.zzaaV.zznN();
            return this.zzaaV;
        }

        public Builder setContentType(String str) {
            this.zzaaV.setContentType(str);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzaaV.setCustomData(jSONObject);
            return this;
        }

        public Builder setMediaTracks(List list) {
            this.zzaaV.zzu(list);
            return this;
        }

        public Builder setMetadata(MediaMetadata mediaMetadata) {
            this.zzaaV.zza(mediaMetadata);
            return this;
        }

        public Builder setStreamDuration(long j) {
            this.zzaaV.zzx(j);
            return this;
        }

        public Builder setStreamType(int i) {
            this.zzaaV.setStreamType(i);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.zzaaV.setTextTrackStyle(textTrackStyle);
            return this;
        }
    }

    MediaInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.zzaaN = str;
        this.zzaaO = -1;
        this.zzaaR = -1L;
    }

    MediaInfo(JSONObject jSONObject) throws JSONException {
        this.zzaaN = jSONObject.getString("contentId");
        String string = jSONObject.getString("streamType");
        if ("NONE".equals(string)) {
            this.zzaaO = 0;
        } else if ("BUFFERED".equals(string)) {
            this.zzaaO = 1;
        } else if ("LIVE".equals(string)) {
            this.zzaaO = 2;
        } else {
            this.zzaaO = -1;
        }
        this.zzaaP = jSONObject.getString("contentType");
        if (jSONObject.has("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            this.zzaaQ = new MediaMetadata(jSONObject2.getInt("metadataType"));
            this.zzaaQ.zzg(jSONObject2);
        }
        this.zzaaR = -1L;
        if (jSONObject.has("duration") && !jSONObject.isNull("duration")) {
            double dOptDouble = jSONObject.optDouble("duration", 0.0d);
            if (!Double.isNaN(dOptDouble) && !Double.isInfinite(dOptDouble)) {
                this.zzaaR = zzf.zzg(dOptDouble);
            }
        }
        if (jSONObject.has("tracks")) {
            this.zzaaS = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("tracks");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.zzaaS.add(new MediaTrack(jSONArray.getJSONObject(i)));
            }
        } else {
            this.zzaaS = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.zzg(jSONObject3);
            this.zzaaT = textTrackStyle;
        } else {
            this.zzaaT = null;
        }
        this.zzaaU = jSONObject.optJSONObject("customData");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        if ((this.zzaaU == null) == (mediaInfo.zzaaU == null)) {
            return (this.zzaaU == null || mediaInfo.zzaaU == null || zznb.zze(this.zzaaU, mediaInfo.zzaaU)) && zzf.zza(this.zzaaN, mediaInfo.zzaaN) && this.zzaaO == mediaInfo.zzaaO && zzf.zza(this.zzaaP, mediaInfo.zzaaP) && zzf.zza(this.zzaaQ, mediaInfo.zzaaQ) && this.zzaaR == mediaInfo.zzaaR;
        }
        return false;
    }

    public final String getContentId() {
        return this.zzaaN;
    }

    public final String getContentType() {
        return this.zzaaP;
    }

    public final JSONObject getCustomData() {
        return this.zzaaU;
    }

    public final List getMediaTracks() {
        return this.zzaaS;
    }

    public final MediaMetadata getMetadata() {
        return this.zzaaQ;
    }

    public final long getStreamDuration() {
        return this.zzaaR;
    }

    public final int getStreamType() {
        return this.zzaaO;
    }

    public final TextTrackStyle getTextTrackStyle() {
        return this.zzaaT;
    }

    public final int hashCode() {
        return zzw.hashCode(this.zzaaN, Integer.valueOf(this.zzaaO), this.zzaaP, this.zzaaQ, Long.valueOf(this.zzaaR), String.valueOf(this.zzaaU));
    }

    final void setContentType(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.zzaaP = str;
    }

    final void setCustomData(JSONObject jSONObject) {
        this.zzaaU = jSONObject;
    }

    final void setStreamType(int i) {
        if (i < -1 || i > 2) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.zzaaO = i;
    }

    public final void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.zzaaT = textTrackStyle;
    }

    public final JSONObject toJson() throws JSONException {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.zzaaN);
            switch (this.zzaaO) {
                case 1:
                    str = "BUFFERED";
                    break;
                case 2:
                    str = "LIVE";
                    break;
                default:
                    str = "NONE";
                    break;
            }
            jSONObject.put("streamType", str);
            if (this.zzaaP != null) {
                jSONObject.put("contentType", this.zzaaP);
            }
            if (this.zzaaQ != null) {
                jSONObject.put("metadata", this.zzaaQ.toJson());
            }
            if (this.zzaaR <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", zzf.zzA(this.zzaaR));
            }
            if (this.zzaaS != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.zzaaS.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((MediaTrack) it.next()).toJson());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.zzaaT != null) {
                jSONObject.put("textTrackStyle", this.zzaaT.toJson());
            }
            if (this.zzaaU != null) {
                jSONObject.put("customData", this.zzaaU);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    final void zza(MediaMetadata mediaMetadata) {
        this.zzaaQ = mediaMetadata;
    }

    final void zznN() {
        if (TextUtils.isEmpty(this.zzaaN)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        if (TextUtils.isEmpty(this.zzaaP)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        if (this.zzaaO == -1) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    final void zzu(List list) {
        this.zzaaS = list;
    }

    final void zzx(long j) {
        if (j < 0 && j != -1) {
            throw new IllegalArgumentException("Invalid stream duration");
        }
        this.zzaaR = j;
    }
}
