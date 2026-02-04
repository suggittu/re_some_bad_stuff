package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public abstract class zzg {
    private final String zzavI;
    private Object zzavJ;

    public class zza extends Exception {
        public zza(String str) {
            super(str);
        }

        public zza(String str, Throwable th) {
            super(str, th);
        }
    }

    public zzg(String str) {
        this.zzavI = str;
    }

    protected final Object zzaB(Context context) throws zza {
        if (this.zzavJ == null) {
            zzx.zzz(context);
            Context remoteContext = com.google.android.gms.common.zze.getRemoteContext(context);
            if (remoteContext == null) {
                throw new zza("Could not get remote context.");
            }
            try {
                this.zzavJ = zzd((IBinder) remoteContext.getClassLoader().loadClass(this.zzavI).newInstance());
            } catch (ClassNotFoundException e) {
                throw new zza("Could not load creator class.", e);
            } catch (IllegalAccessException e2) {
                throw new zza("Could not access creator.", e2);
            } catch (InstantiationException e3) {
                throw new zza("Could not instantiate creator.", e3);
            }
        }
        return this.zzavJ;
    }

    protected abstract Object zzd(IBinder iBinder);
}
