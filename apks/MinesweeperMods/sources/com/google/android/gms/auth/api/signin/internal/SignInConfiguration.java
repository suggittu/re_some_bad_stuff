package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class SignInConfiguration implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzp();
    final int versionCode;
    private final String zzXL;
    private EmailSignInOptions zzXM;
    private GoogleSignInOptions zzXN;
    private String zzXO;
    private String zzXd;

    SignInConfiguration(int i, String str, String str2, EmailSignInOptions emailSignInOptions, GoogleSignInOptions googleSignInOptions, String str3) {
        this.versionCode = i;
        this.zzXL = zzx.zzcM(str);
        this.zzXd = str2;
        this.zzXM = emailSignInOptions;
        this.zzXN = googleSignInOptions;
        this.zzXO = str3;
    }

    public SignInConfiguration(String str) {
        this(2, str, null, null, null, null);
    }

    private JSONObject zzmJ() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consumerPackageName", this.zzXL);
            if (!TextUtils.isEmpty(this.zzXd)) {
                jSONObject.put("serverClientId", this.zzXd);
            }
            if (this.zzXM != null) {
                jSONObject.put("emailSignInOptions", this.zzXM.zzmI());
            }
            if (this.zzXN != null) {
                jSONObject.put("googleSignInOptions", this.zzXN.zzmI());
            }
            if (!TextUtils.isEmpty(this.zzXO)) {
                jSONObject.put("apiKey", this.zzXO);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[Catch: ClassCastException -> 0x0080, TryCatch #0 {ClassCastException -> 0x0080, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:33:0x0073, B:30:0x0066, B:27:0x0059, B:24:0x004c), top: B:39:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003a A[Catch: ClassCastException -> 0x0080, TryCatch #0 {ClassCastException -> 0x0080, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:33:0x0073, B:30:0x0066, B:27:0x0059, B:24:0x004c), top: B:39:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0059 A[Catch: ClassCastException -> 0x0080, TryCatch #0 {ClassCastException -> 0x0080, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:33:0x0073, B:30:0x0066, B:27:0x0059, B:24:0x004c), top: B:39:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0066 A[Catch: ClassCastException -> 0x0080, TryCatch #0 {ClassCastException -> 0x0080, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:33:0x0073, B:30:0x0066, B:27:0x0059, B:24:0x004c), top: B:39:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
        L3:
            return r0
        L4:
            com.google.android.gms.auth.api.signin.internal.SignInConfiguration r4 = (com.google.android.gms.auth.api.signin.internal.SignInConfiguration) r4     // Catch: java.lang.ClassCastException -> L80
            java.lang.String r1 = r3.zzXL     // Catch: java.lang.ClassCastException -> L80
            java.lang.String r2 = r4.zznk()     // Catch: java.lang.ClassCastException -> L80
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L80
            if (r1 == 0) goto L3
            java.lang.String r1 = r3.zzXd     // Catch: java.lang.ClassCastException -> L80
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L80
            if (r1 == 0) goto L4c
            java.lang.String r1 = r4.zzmR()     // Catch: java.lang.ClassCastException -> L80
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L80
            if (r1 == 0) goto L3
        L24:
            java.lang.String r1 = r3.zzXO     // Catch: java.lang.ClassCastException -> L80
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L80
            if (r1 == 0) goto L59
            java.lang.String r1 = r4.zznn()     // Catch: java.lang.ClassCastException -> L80
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L80
            if (r1 == 0) goto L3
        L36:
            com.google.android.gms.auth.api.signin.EmailSignInOptions r1 = r3.zzXM     // Catch: java.lang.ClassCastException -> L80
            if (r1 != 0) goto L66
            com.google.android.gms.auth.api.signin.EmailSignInOptions r1 = r4.zznl()     // Catch: java.lang.ClassCastException -> L80
            if (r1 != 0) goto L3
        L40:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r1 = r3.zzXN     // Catch: java.lang.ClassCastException -> L80
            if (r1 != 0) goto L73
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r1 = r4.zznm()     // Catch: java.lang.ClassCastException -> L80
            if (r1 != 0) goto L3
        L4a:
            r0 = 1
            goto L3
        L4c:
            java.lang.String r1 = r3.zzXd     // Catch: java.lang.ClassCastException -> L80
            java.lang.String r2 = r4.zzmR()     // Catch: java.lang.ClassCastException -> L80
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L80
            if (r1 == 0) goto L3
            goto L24
        L59:
            java.lang.String r1 = r3.zzXO     // Catch: java.lang.ClassCastException -> L80
            java.lang.String r2 = r4.zznn()     // Catch: java.lang.ClassCastException -> L80
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L80
            if (r1 == 0) goto L3
            goto L36
        L66:
            com.google.android.gms.auth.api.signin.EmailSignInOptions r1 = r3.zzXM     // Catch: java.lang.ClassCastException -> L80
            com.google.android.gms.auth.api.signin.EmailSignInOptions r2 = r4.zznl()     // Catch: java.lang.ClassCastException -> L80
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L80
            if (r1 == 0) goto L3
            goto L40
        L73:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r1 = r3.zzXN     // Catch: java.lang.ClassCastException -> L80
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r2 = r4.zznm()     // Catch: java.lang.ClassCastException -> L80
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L80
            if (r1 == 0) goto L3
            goto L4a
        L80:
            r1 = move-exception
            goto L3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.SignInConfiguration.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return new zze().zzp(this.zzXL).zzp(this.zzXd).zzp(this.zzXO).zzp(this.zzXM).zzp(this.zzXN).zzne();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }

    public final SignInConfiguration zzj(GoogleSignInOptions googleSignInOptions) {
        this.zzXN = (GoogleSignInOptions) zzx.zzb(googleSignInOptions, "GoogleSignInOptions cannot be null.");
        return this;
    }

    public final String zzmI() {
        return zzmJ().toString();
    }

    public final String zzmR() {
        return this.zzXd;
    }

    public final String zznk() {
        return this.zzXL;
    }

    public final EmailSignInOptions zznl() {
        return this.zzXM;
    }

    public final GoogleSignInOptions zznm() {
        return this.zzXN;
    }

    public final String zznn() {
        return this.zzXO;
    }
}
