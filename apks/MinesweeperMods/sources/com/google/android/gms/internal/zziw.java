package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzm;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@zzhb
/* loaded from: classes2.dex */
public class zziw {
    private static zzl zzMy;
    private static final Object zzqy = new Object();
    public static final zza zzMz = new zza() { // from class: com.google.android.gms.internal.zziw.1
        @Override // com.google.android.gms.internal.zziw.zza
        /* renamed from: zzhB, reason: merged with bridge method [inline-methods] */
        public final Void zzgp() {
            return null;
        }

        @Override // com.google.android.gms.internal.zziw.zza
        /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
        public final Void zzh(InputStream inputStream) {
            return null;
        }
    };

    public interface zza {
        Object zzgp();

        Object zzh(InputStream inputStream);
    }

    class zzb extends zzk {
        private final zza zzMD;
        private final zzm.zzb zzaG;

        public zzb(String str, final zza zzaVar, final zzm.zzb zzbVar) {
            super(0, str, new zzm.zza() { // from class: com.google.android.gms.internal.zziw.zzb.1
                @Override // com.google.android.gms.internal.zzm.zza
                public void zze(zzr zzrVar) {
                    zzbVar.zzb(zzaVar.zzgp());
                }
            });
            this.zzMD = zzaVar;
            this.zzaG = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzk
        protected zzm zza(zzi zziVar) {
            return zzm.zza(new ByteArrayInputStream(zziVar.data), zzx.zzb(zziVar));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzk
        /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
        public void zza(InputStream inputStream) {
            this.zzaG.zzb(this.zzMD.zzh(inputStream));
        }
    }

    class zzc extends zzjd implements zzm.zzb {
        private zzc() {
        }

        @Override // com.google.android.gms.internal.zzm.zzb
        public void zzb(Object obj) {
            super.zzg(obj);
        }
    }

    public zziw(Context context) {
        zzMy = zzS(context);
    }

    private static zzl zzS(Context context) {
        zzl zzlVar;
        synchronized (zzqy) {
            if (zzMy == null) {
                zzMy = zzac.zza(context.getApplicationContext());
            }
            zzlVar = zzMy;
        }
        return zzlVar;
    }

    public zzjg zza(String str, zza zzaVar) {
        zzc zzcVar = new zzc();
        zzMy.zze(new zzb(str, zzaVar, zzcVar));
        return zzcVar;
    }

    public zzjg zzb(final String str, final Map map) {
        final zzc zzcVar = new zzc();
        zzMy.zze(new zzab(str, zzcVar, new zzm.zza() { // from class: com.google.android.gms.internal.zziw.2
            @Override // com.google.android.gms.internal.zzm.zza
            public void zze(zzr zzrVar) {
                zzin.zzaK("Failed to load URL: " + str + "\n" + zzrVar.toString());
                zzcVar.zzb((Object) null);
            }
        }) { // from class: com.google.android.gms.internal.zziw.3
            @Override // com.google.android.gms.internal.zzk
            public Map getHeaders() {
                return map == null ? super.getHeaders() : map;
            }
        });
        return zzcVar;
    }
}
