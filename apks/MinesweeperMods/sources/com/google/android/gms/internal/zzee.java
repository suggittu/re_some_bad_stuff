package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzed;
import java.util.concurrent.Future;

@zzhb
/* loaded from: classes2.dex */
public class zzee {

    class zza extends zzjd {
        Object zzAR;

        private zza() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zzed zza(Context context, VersionInfoParcel versionInfoParcel, final zza zzaVar, zzan zzanVar) {
        zzef zzefVar = new zzef(context, versionInfoParcel, zzanVar);
        zzaVar.zzAR = zzefVar;
        zzefVar.zza(new zzed.zza() { // from class: com.google.android.gms.internal.zzee.2
            @Override // com.google.android.gms.internal.zzed.zza
            public void zzeo() {
                zzaVar.zzg(zzaVar.zzAR);
            }
        });
        return zzefVar;
    }

    public Future zza(final Context context, final VersionInfoParcel versionInfoParcel, final String str, final zzan zzanVar) {
        final zza zzaVar = new zza();
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzee.1
            @Override // java.lang.Runnable
            public void run() {
                zzee.this.zza(context, versionInfoParcel, zzaVar, zzanVar).zzaa(str);
            }
        });
        return zzaVar;
    }
}
