package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SignInAccount implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zze();
    final int versionCode;
    private String zzWP;
    private String zzWQ;
    private Uri zzWR;
    private String zzWk;
    private String zzXj;
    private GoogleSignInAccount zzXm;
    private String zzXn;
    private String zzrG;

    SignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, GoogleSignInAccount googleSignInAccount, String str5, String str6) {
        this.versionCode = i;
        this.zzWP = zzx.zzh(str3, "Email cannot be empty.");
        this.zzWQ = str4;
        this.zzWR = uri;
        this.zzXj = str;
        this.zzWk = str2;
        this.zzXm = googleSignInAccount;
        this.zzrG = zzx.zzcM(str5);
        this.zzXn = str6;
    }

    public static SignInAccount zza(zzd zzdVar, String str, String str2, String str3, Uri uri, String str4, String str5) {
        return new SignInAccount(2, zzdVar != null ? zzdVar.zzmT() : null, str, str2, str3, uri, null, str4, str5);
    }

    public static SignInAccount zzbM(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl", null);
        return zza(zzd.zzbL(jSONObject.optString("providerId", null)), jSONObject.optString("tokenId", null), jSONObject.getString("email"), jSONObject.optString("displayName", null), !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null, jSONObject.getString("localId"), jSONObject.optString("refreshToken")).zza(GoogleSignInAccount.zzbH(jSONObject.optString("googleSignInAccount")));
    }

    private JSONObject zzmJ() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("email", getEmail());
            if (!TextUtils.isEmpty(this.zzWQ)) {
                jSONObject.put("displayName", this.zzWQ);
            }
            if (this.zzWR != null) {
                jSONObject.put("photoUrl", this.zzWR.toString());
            }
            if (!TextUtils.isEmpty(this.zzXj)) {
                jSONObject.put("providerId", this.zzXj);
            }
            if (!TextUtils.isEmpty(this.zzWk)) {
                jSONObject.put("tokenId", this.zzWk);
            }
            if (this.zzXm != null) {
                jSONObject.put("googleSignInAccount", this.zzXm.zzmI());
            }
            if (!TextUtils.isEmpty(this.zzXn)) {
                jSONObject.put("refreshToken", this.zzXn);
            }
            jSONObject.put("localId", getUserId());
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDisplayName() {
        return this.zzWQ;
    }

    public String getEmail() {
        return this.zzWP;
    }

    public String getIdToken() {
        return this.zzWk;
    }

    public Uri getPhotoUrl() {
        return this.zzWR;
    }

    public String getUserId() {
        return this.zzrG;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public SignInAccount zza(GoogleSignInAccount googleSignInAccount) {
        this.zzXm = googleSignInAccount;
        return this;
    }

    public String zzmI() {
        return zzmJ().toString();
    }

    String zzmT() {
        return this.zzXj;
    }

    public zzd zzmU() {
        return zzd.zzbL(this.zzXj);
    }

    public GoogleSignInAccount zzmV() {
        return this.zzXm;
    }

    public String zzmW() {
        return this.zzXn;
    }
}
