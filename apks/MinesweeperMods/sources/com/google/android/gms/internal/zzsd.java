package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet;

@SuppressLint({"MissingRemoteException"})
/* loaded from: classes2.dex */
public class zzsd implements Payments {
    @Override // com.google.android.gms.wallet.Payments
    public void changeMaskedWallet(GoogleApiClient googleApiClient, final String str, final String str2, final int i) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzsd.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzse zzseVar) throws PendingIntent.CanceledException {
                zzseVar.zzf(str, str2, i);
                zza(Status.zzagC);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int i) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzsd.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzse zzseVar) throws PendingIntent.CanceledException {
                zzseVar.zzln(i);
                zza(Status.zzagC);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void isNewUser(GoogleApiClient googleApiClient, final int i) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzsd.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzse zzseVar) throws PendingIntent.CanceledException {
                zzseVar.zzlo(i);
                zza(Status.zzagC);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public PendingResult isReadyToPay(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new Wallet.zza(googleApiClient) { // from class: com.google.android.gms.internal.zzsd.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzA, reason: merged with bridge method [inline-methods] */
            public BooleanResult zzc(Status status) {
                return new BooleanResult(status, false);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzse zzseVar) {
                zzseVar.zza(IsReadyToPayRequest.zzIj().zzIk(), this);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest fullWalletRequest, final int i) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzsd.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzse zzseVar) throws PendingIntent.CanceledException {
                zzseVar.zza(fullWalletRequest, i);
                zza(Status.zzagC);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest maskedWalletRequest, final int i) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzsd.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzse zzseVar) throws PendingIntent.CanceledException {
                zzseVar.zza(maskedWalletRequest, i);
                zza(Status.zzagC);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzsd.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzse zzseVar) {
                zzseVar.zza(notifyTransactionStatusRequest);
                zza(Status.zzagC);
            }
        });
    }
}
