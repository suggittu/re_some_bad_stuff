package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class Thing {
    final Bundle zzUG;

    public class Builder {
        final Bundle zzUH = new Bundle();

        public Thing build() {
            return new Thing(this.zzUH);
        }

        public Builder put(String str, Thing thing) {
            zzx.zzz(str);
            if (thing != null) {
                this.zzUH.putParcelable(str, thing.zzUG);
            }
            return this;
        }

        public Builder put(String str, String str2) {
            zzx.zzz(str);
            if (str2 != null) {
                this.zzUH.putString(str, str2);
            }
            return this;
        }

        public Builder put(String str, boolean z) {
            zzx.zzz(str);
            this.zzUH.putBoolean(str, z);
            return this;
        }

        public Builder put(String str, Thing[] thingArr) {
            zzx.zzz(str);
            if (thingArr != null) {
                ArrayList arrayList = new ArrayList();
                for (Thing thing : thingArr) {
                    if (thing != null) {
                        arrayList.add(thing.zzUG);
                    }
                }
                this.zzUH.putParcelableArray(str, (Parcelable[]) arrayList.toArray(new Bundle[arrayList.size()]));
            }
            return this;
        }

        public Builder put(String str, String[] strArr) {
            zzx.zzz(str);
            if (strArr != null) {
                this.zzUH.putStringArray(str, strArr);
            }
            return this;
        }

        public Builder setDescription(String str) {
            put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, str);
            return this;
        }

        public Builder setId(String str) {
            if (str != null) {
                put("id", str);
            }
            return this;
        }

        public Builder setName(String str) {
            zzx.zzz(str);
            put("name", str);
            return this;
        }

        public Builder setType(String str) {
            put("type", str);
            return this;
        }

        public Builder setUrl(Uri uri) {
            zzx.zzz(uri);
            put(PlusShare.KEY_CALL_TO_ACTION_URL, uri.toString());
            return this;
        }
    }

    Thing(Bundle bundle) {
        this.zzUG = bundle;
    }

    public Bundle zzmk() {
        return this.zzUG;
    }
}
