package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class EmailSignInOptions implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zza();
    final int versionCode;
    private final Uri zzWL;
    private String zzWM;
    private Uri zzWN;

    EmailSignInOptions(int i, Uri uri, String str, Uri uri2) {
        zzx.zzb(uri, "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzh(uri.toString(), "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzb(Patterns.WEB_URL.matcher(uri.toString()).matches(), "Invalid server widget url");
        this.versionCode = i;
        this.zzWL = uri;
        this.zzWM = str;
        this.zzWN = uri2;
    }

    private JSONObject zzmJ() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("serverWidgetUrl", this.zzWL.toString());
            if (!TextUtils.isEmpty(this.zzWM)) {
                jSONObject.put("modeQueryName", this.zzWM);
            }
            if (this.zzWN != null) {
                jSONObject.put("tosUrl", this.zzWN.toString());
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                EmailSignInOptions emailSignInOptions = (EmailSignInOptions) obj;
                if (this.zzWL.equals(emailSignInOptions.zzmF())) {
                    if (this.zzWN == null) {
                        if (emailSignInOptions.zzmG() == null) {
                            if (TextUtils.isEmpty(this.zzWM) ? this.zzWM.equals(emailSignInOptions.zzmH()) : TextUtils.isEmpty(emailSignInOptions.zzmH())) {
                            }
                        }
                    } else if (this.zzWN.equals(emailSignInOptions.zzmG())) {
                        z = TextUtils.isEmpty(this.zzWM) ? true : true;
                    }
                }
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public int hashCode() {
        return new com.google.android.gms.auth.api.signin.internal.zze().zzp(this.zzWL).zzp(this.zzWN).zzp(this.zzWM).zzne();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public Uri zzmF() {
        return this.zzWL;
    }

    public Uri zzmG() {
        return this.zzWN;
    }

    public String zzmH() {
        return this.zzWM;
    }

    public String zzmI() {
        return zzmJ().toString();
    }
}
