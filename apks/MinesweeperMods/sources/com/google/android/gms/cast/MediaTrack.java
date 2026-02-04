package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznb;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class MediaTrack {
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    private String mName;
    private long zzUZ;
    private String zzaaL;
    private String zzaaN;
    private String zzaaP;
    private JSONObject zzaaU;
    private int zzabB;
    private int zzabC;

    public class Builder {
        private final MediaTrack zzabD;

        public Builder(long j, int i) {
            this.zzabD = new MediaTrack(j, i);
        }

        public MediaTrack build() {
            return this.zzabD;
        }

        public Builder setContentId(String str) {
            this.zzabD.setContentId(str);
            return this;
        }

        public Builder setContentType(String str) {
            this.zzabD.setContentType(str);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzabD.setCustomData(jSONObject);
            return this;
        }

        public Builder setLanguage(String str) {
            this.zzabD.setLanguage(str);
            return this;
        }

        public Builder setLanguage(Locale locale) {
            this.zzabD.setLanguage(zzf.zzb(locale));
            return this;
        }

        public Builder setName(String str) {
            this.zzabD.setName(str);
            return this;
        }

        public Builder setSubtype(int i) {
            this.zzabD.zzbe(i);
            return this;
        }
    }

    MediaTrack(long j, int i) {
        clear();
        this.zzUZ = j;
        if (i <= 0 || i > 3) {
            throw new IllegalArgumentException("invalid type " + i);
        }
        this.zzabB = i;
    }

    MediaTrack(JSONObject jSONObject) throws JSONException {
        zzg(jSONObject);
    }

    private void clear() {
        this.zzUZ = 0L;
        this.zzabB = 0;
        this.zzaaN = null;
        this.mName = null;
        this.zzaaL = null;
        this.zzabC = -1;
        this.zzaaU = null;
    }

    private void zzg(JSONObject jSONObject) throws JSONException {
        clear();
        this.zzUZ = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.zzabB = 1;
        } else if ("AUDIO".equals(string)) {
            this.zzabB = 2;
        } else {
            if (!"VIDEO".equals(string)) {
                throw new JSONException("invalid type: " + string);
            }
            this.zzabB = 3;
        }
        this.zzaaN = jSONObject.optString("trackContentId", null);
        this.zzaaP = jSONObject.optString("trackContentType", null);
        this.mName = jSONObject.optString("name", null);
        this.zzaaL = jSONObject.optString("language", null);
        if (jSONObject.has("subtype")) {
            String string2 = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string2)) {
                this.zzabC = 1;
            } else if ("CAPTIONS".equals(string2)) {
                this.zzabC = 2;
            } else if ("DESCRIPTIONS".equals(string2)) {
                this.zzabC = 3;
            } else if ("CHAPTERS".equals(string2)) {
                this.zzabC = 4;
            } else {
                if (!"METADATA".equals(string2)) {
                    throw new JSONException("invalid subtype: " + string2);
                }
                this.zzabC = 5;
            }
        } else {
            this.zzabC = 0;
        }
        this.zzaaU = jSONObject.optJSONObject("customData");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) obj;
        if ((this.zzaaU == null) == (mediaTrack.zzaaU == null)) {
            return (this.zzaaU == null || mediaTrack.zzaaU == null || zznb.zze(this.zzaaU, mediaTrack.zzaaU)) && this.zzUZ == mediaTrack.zzUZ && this.zzabB == mediaTrack.zzabB && zzf.zza(this.zzaaN, mediaTrack.zzaaN) && zzf.zza(this.zzaaP, mediaTrack.zzaaP) && zzf.zza(this.mName, mediaTrack.mName) && zzf.zza(this.zzaaL, mediaTrack.zzaaL) && this.zzabC == mediaTrack.zzabC;
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

    public final long getId() {
        return this.zzUZ;
    }

    public final String getLanguage() {
        return this.zzaaL;
    }

    public final String getName() {
        return this.mName;
    }

    public final int getSubtype() {
        return this.zzabC;
    }

    public final int getType() {
        return this.zzabB;
    }

    public final int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzUZ), Integer.valueOf(this.zzabB), this.zzaaN, this.zzaaP, this.mName, this.zzaaL, Integer.valueOf(this.zzabC), this.zzaaU);
    }

    public final void setContentId(String str) {
        this.zzaaN = str;
    }

    public final void setContentType(String str) {
        this.zzaaP = str;
    }

    final void setCustomData(JSONObject jSONObject) {
        this.zzaaU = jSONObject;
    }

    final void setLanguage(String str) {
        this.zzaaL = str;
    }

    final void setName(String str) {
        this.mName = str;
    }

    public final JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.zzUZ);
            switch (this.zzabB) {
                case 1:
                    jSONObject.put("type", "TEXT");
                    break;
                case 2:
                    jSONObject.put("type", "AUDIO");
                    break;
                case 3:
                    jSONObject.put("type", "VIDEO");
                    break;
            }
            if (this.zzaaN != null) {
                jSONObject.put("trackContentId", this.zzaaN);
            }
            if (this.zzaaP != null) {
                jSONObject.put("trackContentType", this.zzaaP);
            }
            if (this.mName != null) {
                jSONObject.put("name", this.mName);
            }
            if (!TextUtils.isEmpty(this.zzaaL)) {
                jSONObject.put("language", this.zzaaL);
            }
            switch (this.zzabC) {
                case 1:
                    jSONObject.put("subtype", "SUBTITLES");
                    break;
                case 2:
                    jSONObject.put("subtype", "CAPTIONS");
                    break;
                case 3:
                    jSONObject.put("subtype", "DESCRIPTIONS");
                    break;
                case 4:
                    jSONObject.put("subtype", "CHAPTERS");
                    break;
                case 5:
                    jSONObject.put("subtype", "METADATA");
                    break;
            }
            if (this.zzaaU != null) {
                jSONObject.put("customData", this.zzaaU);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    final void zzbe(int i) {
        if (i < 0 || i > 5) {
            throw new IllegalArgumentException("invalid subtype " + i);
        }
        if (i != 0 && this.zzabB != 1) {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        }
        this.zzabC = i;
    }
}
