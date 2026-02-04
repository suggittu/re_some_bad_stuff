package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.auth.api.signin.internal.zzo;
import com.google.android.gms.auth.api.signin.zzg;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzkv;
import com.google.android.gms.internal.zzkw;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zzld;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Auth {
    public static final Api.zzc zzVt = new Api.zzc();
    public static final Api.zzc zzVu = new Api.zzc();
    public static final Api.zzc zzVv = new Api.zzc();
    public static final Api.zzc zzVw = new Api.zzc();
    public static final Api.zzc zzVx = new Api.zzc();
    public static final Api.zzc zzVy = new Api.zzc();
    private static final Api.zza zzVz = new Api.zza() { // from class: com.google.android.gms.auth.api.Auth.1
        @Override // com.google.android.gms.common.api.Api.zza
        public final zzkz zza(Context context, Looper looper, zzf zzfVar, zza zzaVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkz(context, looper, zzfVar, zzaVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final Api.zza zzVA = new Api.zza() { // from class: com.google.android.gms.auth.api.Auth.2
        @Override // com.google.android.gms.common.api.Api.zza
        public final com.google.android.gms.auth.api.credentials.internal.zzf zza(Context context, Looper looper, zzf zzfVar, AuthCredentialsOptions authCredentialsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new com.google.android.gms.auth.api.credentials.internal.zzf(context, looper, zzfVar, authCredentialsOptions, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final Api.zza zzVB = new Api.zza() { // from class: com.google.android.gms.auth.api.Auth.3
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public final zzks zza(Context context, Looper looper, zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzks(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final Api.zza zzVC = new Api.zza() { // from class: com.google.android.gms.auth.api.Auth.4
        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public final zzkw zza(Context context, Looper looper, zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkw(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final Api.zza zzVD = new Api.zza() { // from class: com.google.android.gms.auth.api.Auth.5
        @Override // com.google.android.gms.common.api.Api.zza
        public final zzo zza(Context context, Looper looper, zzf zzfVar, zzg zzgVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzo(context, looper, zzfVar, zzgVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final Api.zza zzVE = new Api.zza() { // from class: com.google.android.gms.auth.api.Auth.6
        @Override // com.google.android.gms.common.api.Api.zza
        public final zzd zza(Context context, Looper looper, zzf zzfVar, @Nullable GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzd(context, looper, zzfVar, googleSignInOptions, connectionCallbacks, onConnectionFailedListener);
        }

        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final List zzo(@Nullable GoogleSignInOptions googleSignInOptions) {
            return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.zzmN();
        }
    };
    public static final Api PROXY_API = new Api("Auth.PROXY_API", zzVz, zzVt);
    public static final Api CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzVA, zzVu);
    public static final Api zzVF = new Api("Auth.SIGN_IN_API", zzVD, zzVw);
    public static final Api GOOGLE_SIGN_IN_API = new Api("Auth.GOOGLE_SIGN_IN_API", zzVE, zzVx);
    public static final Api zzVG = new Api("Auth.ACCOUNT_STATUS_API", zzVB, zzVv);
    public static final Api zzVH = new Api("Auth.CONSENT_API", zzVC, zzVy);
    public static final ProxyApi ProxyApi = new zzld();
    public static final CredentialsApi CredentialsApi = new com.google.android.gms.auth.api.credentials.internal.zzd();
    public static final zzkq zzVI = new zzkr();
    public static final com.google.android.gms.auth.api.signin.zzf zzVJ = new zzn();
    public static final GoogleSignInApi GoogleSignInApi = new zzc();
    public static final com.google.android.gms.auth.api.consent.zza zzVK = new zzkv();

    public final class AuthCredentialsOptions implements Api.ApiOptions.Optional {
        private final String zzVL;
        private final PasswordSpecification zzVM;

        public class Builder {

            @NonNull
            private PasswordSpecification zzVM = PasswordSpecification.zzWl;
        }

        public final Bundle zzml() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", this.zzVL);
            bundle.putParcelable("password_specification", this.zzVM);
            return bundle;
        }

        public final PasswordSpecification zzmr() {
            return this.zzVM;
        }
    }

    public final class zza implements Api.ApiOptions.Optional {
        private final Bundle zzVN;

        public final Bundle zzms() {
            return new Bundle(this.zzVN);
        }
    }

    private Auth() {
    }
}
