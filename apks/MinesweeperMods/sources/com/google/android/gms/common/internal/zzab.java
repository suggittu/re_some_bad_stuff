package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zzg;

/* loaded from: classes2.dex */
public final class zzab extends com.google.android.gms.dynamic.zzg {
    private static final zzab zzamw = new zzab();

    private zzab() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zzb(Context context, int i, int i2, Scope[] scopeArr) {
        return zzamw.zzc(context, i, i2, scopeArr);
    }

    private View zzc(Context context, int i, int i2, Scope[] scopeArr) throws zzg.zza {
        try {
            return (View) com.google.android.gms.dynamic.zze.zzp(((zzu) zzaB(context)).zza(com.google.android.gms.dynamic.zze.zzC(context), new SignInButtonConfig(i, i2, scopeArr)));
        } catch (Exception e) {
            throw new zzg.zza("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    @Override // com.google.android.gms.dynamic.zzg
    /* renamed from: zzaV, reason: merged with bridge method [inline-methods] */
    public final zzu zzd(IBinder iBinder) {
        return zzu.zza.zzaU(iBinder);
    }
}
