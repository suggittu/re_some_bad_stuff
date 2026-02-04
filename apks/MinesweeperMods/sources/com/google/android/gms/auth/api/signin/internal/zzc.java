package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class zzc implements GoogleSignInApi {

    abstract class zza extends zza.AbstractC0036zza {
        public zza(GoogleApiClient googleApiClient) {
            super(Auth.zzVx, googleApiClient);
        }
    }

    private OptionalPendingResult zza(GoogleApiClient googleApiClient, final GoogleSignInOptions googleSignInOptions) {
        Log.d("GoogleSignInApiImpl", "trySilentSignIn");
        return new zzr(googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.auth.api.signin.internal.zzc.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzd zzdVar) {
                final zzq zzqVarZzaf = zzq.zzaf(zzdVar.getContext());
                ((zzh) zzdVar.zzqJ()).zza(new com.google.android.gms.auth.api.signin.internal.zza() { // from class: com.google.android.gms.auth.api.signin.internal.zzc.1.1
                    @Override // com.google.android.gms.auth.api.signin.internal.zza, com.google.android.gms.auth.api.signin.internal.zzg
                    public void zza(GoogleSignInAccount googleSignInAccount, Status status) {
                        if (googleSignInAccount != null) {
                            zzqVarZzaf.zzb(googleSignInAccount, googleSignInOptions);
                        }
                        zza(new GoogleSignInResult(googleSignInAccount, status));
                    }
                }, googleSignInOptions);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzn, reason: merged with bridge method [inline-methods] */
            public GoogleSignInResult zzc(Status status) {
                return new GoogleSignInResult(null, status);
            }
        }));
    }

    private boolean zza(Account account, Account account2) {
        return account == null ? account2 == null : account.equals(account2);
    }

    private GoogleSignInOptions zzb(GoogleApiClient googleApiClient) {
        return ((zzd) googleApiClient.zza(Auth.zzVx)).zznd();
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public Intent getSignInIntent(GoogleApiClient googleApiClient) {
        zzx.zzz(googleApiClient);
        return ((zzd) googleApiClient.zza(Auth.zzVx)).zznc();
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public GoogleSignInResult getSignInResultFromIntent(Intent intent) {
        if (intent == null || !(intent.hasExtra("googleSignInStatus") || intent.hasExtra("googleSignInAccount"))) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.zzagC;
        }
        return new GoogleSignInResult(googleSignInAccount, status);
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public PendingResult revokeAccess(GoogleApiClient googleApiClient) {
        zzq.zzaf(googleApiClient.getContext()).zznr();
        Iterator it = GoogleApiClient.zzoV().iterator();
        while (it.hasNext()) {
            ((GoogleApiClient) it.next()).zzoW();
        }
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.auth.api.signin.internal.zzc.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzd zzdVar) {
                ((zzh) zzdVar.zzqJ()).zzc(new com.google.android.gms.auth.api.signin.internal.zza() { // from class: com.google.android.gms.auth.api.signin.internal.zzc.3.1
                    @Override // com.google.android.gms.auth.api.signin.internal.zza, com.google.android.gms.auth.api.signin.internal.zzg
                    public void zzm(Status status) {
                        zza(status);
                    }
                }, zzdVar.zznd());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public PendingResult signOut(GoogleApiClient googleApiClient) {
        zzq.zzaf(googleApiClient.getContext()).zznr();
        Iterator it = GoogleApiClient.zzoV().iterator();
        while (it.hasNext()) {
            ((GoogleApiClient) it.next()).zzoW();
        }
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.auth.api.signin.internal.zzc.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzd zzdVar) {
                ((zzh) zzdVar.zzqJ()).zzb(new com.google.android.gms.auth.api.signin.internal.zza() { // from class: com.google.android.gms.auth.api.signin.internal.zzc.2.1
                    @Override // com.google.android.gms.auth.api.signin.internal.zza, com.google.android.gms.auth.api.signin.internal.zzg
                    public void zzl(Status status) {
                        zza(status);
                    }
                }, zzdVar.zznd());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public OptionalPendingResult silentSignIn(GoogleApiClient googleApiClient) {
        GoogleSignInOptions googleSignInOptionsZzb = zzb(googleApiClient);
        GoogleSignInResult googleSignInResultZza = zza(googleApiClient.getContext(), googleSignInOptionsZzb);
        return googleSignInResultZza != null ? PendingResults.zzb(googleSignInResultZza, googleApiClient) : zza(googleApiClient, googleSignInOptionsZzb);
    }

    public GoogleSignInResult zza(Context context, GoogleSignInOptions googleSignInOptions) {
        GoogleSignInAccount googleSignInAccountZzno;
        Log.d("GoogleSignInApiImpl", "getSavedSignInResultIfEligible");
        zzx.zzz(googleSignInOptions);
        zzq zzqVarZzaf = zzq.zzaf(context);
        GoogleSignInOptions googleSignInOptionsZznp = zzqVarZzaf.zznp();
        if (googleSignInOptionsZznp == null || !zza(googleSignInOptionsZznp.getAccount(), googleSignInOptions.getAccount()) || googleSignInOptions.zzmP()) {
            return null;
        }
        if ((!googleSignInOptions.zzmO() || (googleSignInOptionsZznp.zzmO() && googleSignInOptions.zzmR().equals(googleSignInOptionsZznp.zzmR()))) && new HashSet(googleSignInOptionsZznp.zzmN()).containsAll(new HashSet(googleSignInOptions.zzmN())) && (googleSignInAccountZzno = zzqVarZzaf.zzno()) != null && !googleSignInAccountZzno.zzb()) {
            return new GoogleSignInResult(googleSignInAccountZzno, Status.zzagC);
        }
        return null;
    }
}
