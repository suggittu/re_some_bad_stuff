package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class Credential implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zza();
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";

    @Nullable
    private final String mName;
    final int mVersionCode;

    @Nullable
    private final Uri zzVV;
    private final List zzVW;

    @Nullable
    private final String zzVX;

    @Nullable
    private final String zzVY;

    @Nullable
    private final String zzVZ;

    @Nullable
    private final String zzWa;
    private final String zzyv;

    public class Builder {
        private String mName;
        private Uri zzVV;
        private List zzVW;
        private String zzVX;
        private String zzVY;
        private String zzVZ;
        private String zzWa;
        private final String zzyv;

        public Builder(Credential credential) {
            this.zzyv = credential.zzyv;
            this.mName = credential.mName;
            this.zzVV = credential.zzVV;
            this.zzVW = credential.zzVW;
            this.zzVX = credential.zzVX;
            this.zzVY = credential.zzVY;
            this.zzVZ = credential.zzVZ;
            this.zzWa = credential.zzWa;
        }

        public Builder(String str) {
            this.zzyv = str;
        }

        public Credential build() {
            return new Credential(3, this.zzyv, this.mName, this.zzVV, this.zzVW, this.zzVX, this.zzVY, this.zzVZ, this.zzWa);
        }

        public Builder setAccountType(String str) {
            this.zzVY = str;
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setPassword(String str) {
            this.zzVX = str;
            return this;
        }

        public Builder setProfilePictureUri(Uri uri) {
            this.zzVV = uri;
            return this;
        }
    }

    Credential(int i, String str, String str2, Uri uri, List list, String str3, String str4, String str5, String str6) {
        this.mVersionCode = i;
        String strTrim = ((String) zzx.zzb(str, "credential identifier cannot be null")).trim();
        zzx.zzh(strTrim, "credential identifier cannot be empty");
        this.zzyv = strTrim;
        if (str2 != null && TextUtils.isEmpty(str2.trim())) {
            str2 = null;
        }
        this.mName = str2;
        this.zzVV = uri;
        this.zzVW = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzVX = str3;
        if (str3 != null && str3.isEmpty()) {
            throw new IllegalArgumentException("password cannot be empty");
        }
        if (!TextUtils.isEmpty(str4)) {
            String scheme = Uri.parse(str4).getScheme();
            zzx.zzac("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme));
        }
        this.zzVY = str4;
        this.zzVZ = str5;
        this.zzWa = str6;
        if (!TextUtils.isEmpty(this.zzVX) && !TextUtils.isEmpty(this.zzVY)) {
            throw new IllegalStateException("password and accountType cannot both be set");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.zzyv, credential.zzyv) && TextUtils.equals(this.mName, credential.mName) && zzw.equal(this.zzVV, credential.zzVV) && TextUtils.equals(this.zzVX, credential.zzVX) && TextUtils.equals(this.zzVY, credential.zzVY) && TextUtils.equals(this.zzVZ, credential.zzVZ);
    }

    @Nullable
    public String getAccountType() {
        return this.zzVY;
    }

    @Nullable
    public String getGeneratedPassword() {
        return this.zzVZ;
    }

    public String getId() {
        return this.zzyv;
    }

    public List getIdTokens() {
        return this.zzVW;
    }

    @Nullable
    public String getName() {
        return this.mName;
    }

    @Nullable
    public String getPassword() {
        return this.zzVX;
    }

    @Nullable
    public Uri getProfilePictureUri() {
        return this.zzVV;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzyv, this.mName, this.zzVV, this.zzVX, this.zzVY, this.zzVZ);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzmx() {
        return this.zzWa;
    }
}
