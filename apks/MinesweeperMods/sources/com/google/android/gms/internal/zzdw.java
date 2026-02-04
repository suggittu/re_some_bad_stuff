package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzgd;
import java.util.LinkedList;
import java.util.List;

@zzhb
/* loaded from: classes2.dex */
class zzdw {
    private final List zzpH = new LinkedList();

    interface zza {
        void zzb(zzdx zzdxVar);
    }

    zzdw() {
    }

    void zza(final zzdx zzdxVar) {
        Handler handler = zzir.zzMc;
        for (final zza zzaVar : this.zzpH) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.zzdw.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzaVar.zzb(zzdxVar);
                    } catch (RemoteException e) {
                        zzin.zzd("Could not propagate interstitial ad event.", e);
                    }
                }
            });
        }
    }

    void zzc(com.google.android.gms.ads.internal.zzk zzkVar) {
        zzkVar.zza(new zzq.zza() { // from class: com.google.android.gms.internal.zzdw.1
            @Override // com.google.android.gms.ads.internal.client.zzq
            public void onAdClosed() {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.1.1
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzpK != null) {
                            zzdxVar.zzpK.onAdClosed();
                        }
                        com.google.android.gms.ads.internal.zzr.zzbN().zzee();
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.client.zzq
            public void onAdFailedToLoad(final int i) {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.1.2
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzpK != null) {
                            zzdxVar.zzpK.onAdFailedToLoad(i);
                        }
                    }
                });
                zzin.v("Pooled interstitial failed to load.");
            }

            @Override // com.google.android.gms.ads.internal.client.zzq
            public void onAdLeftApplication() {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.1.3
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzpK != null) {
                            zzdxVar.zzpK.onAdLeftApplication();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.client.zzq
            public void onAdLoaded() {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.1.4
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzpK != null) {
                            zzdxVar.zzpK.onAdLoaded();
                        }
                    }
                });
                zzin.v("Pooled interstitial loaded.");
            }

            @Override // com.google.android.gms.ads.internal.client.zzq
            public void onAdOpened() {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.1.5
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzpK != null) {
                            zzdxVar.zzpK.onAdOpened();
                        }
                    }
                });
            }
        });
        zzkVar.zza(new zzw.zza() { // from class: com.google.android.gms.internal.zzdw.2
            @Override // com.google.android.gms.ads.internal.client.zzw
            public void onAppEvent(final String str, final String str2) {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.2.1
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzAq != null) {
                            zzdxVar.zzAq.onAppEvent(str, str2);
                        }
                    }
                });
            }
        });
        zzkVar.zza(new zzgd.zza() { // from class: com.google.android.gms.internal.zzdw.3
            @Override // com.google.android.gms.internal.zzgd
            public void zza(final zzgc zzgcVar) {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.3.1
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzAr != null) {
                            zzdxVar.zzAr.zza(zzgcVar);
                        }
                    }
                });
            }
        });
        zzkVar.zza(new zzcf.zza() { // from class: com.google.android.gms.internal.zzdw.4
            @Override // com.google.android.gms.internal.zzcf
            public void zza(final zzce zzceVar) {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.4.1
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzAs != null) {
                            zzdxVar.zzAs.zza(zzceVar);
                        }
                    }
                });
            }
        });
        zzkVar.zza(new zzp.zza() { // from class: com.google.android.gms.internal.zzdw.5
            @Override // com.google.android.gms.ads.internal.client.zzp
            public void onAdClicked() {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.5.1
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzAt != null) {
                            zzdxVar.zzAt.onAdClicked();
                        }
                    }
                });
            }
        });
        zzkVar.zza(new zzd.zza() { // from class: com.google.android.gms.internal.zzdw.6
            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoAdClosed() {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.6.4
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzAu != null) {
                            zzdxVar.zzAu.onRewardedVideoAdClosed();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoAdFailedToLoad(final int i) {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.6.7
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzAu != null) {
                            zzdxVar.zzAu.onRewardedVideoAdFailedToLoad(i);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoAdLeftApplication() {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.6.6
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzAu != null) {
                            zzdxVar.zzAu.onRewardedVideoAdLeftApplication();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoAdLoaded() {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.6.1
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzAu != null) {
                            zzdxVar.zzAu.onRewardedVideoAdLoaded();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoAdOpened() {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.6.2
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzAu != null) {
                            zzdxVar.zzAu.onRewardedVideoAdOpened();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoStarted() {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.6.3
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzAu != null) {
                            zzdxVar.zzAu.onRewardedVideoStarted();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void zza(final com.google.android.gms.ads.internal.reward.client.zza zzaVar) {
                zzdw.this.zzpH.add(new zza() { // from class: com.google.android.gms.internal.zzdw.6.5
                    @Override // com.google.android.gms.internal.zzdw.zza
                    public void zzb(zzdx zzdxVar) {
                        if (zzdxVar.zzAu != null) {
                            zzdxVar.zzAu.zza(zzaVar);
                        }
                    }
                });
            }
        });
    }
}
