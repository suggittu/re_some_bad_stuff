package com.google.android.gms.measurement;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzc {
    private final zzf zzaUi;
    private boolean zzaUj;
    private long zzaUk;
    private long zzaUl;
    private long zzaUm;
    private long zzaUn;
    private long zzaUo;
    private boolean zzaUp;
    private final Map zzaUq;
    private final List zzaUr;
    private final zzmq zzqW;

    zzc(zzc zzcVar) {
        this.zzaUi = zzcVar.zzaUi;
        this.zzqW = zzcVar.zzqW;
        this.zzaUk = zzcVar.zzaUk;
        this.zzaUl = zzcVar.zzaUl;
        this.zzaUm = zzcVar.zzaUm;
        this.zzaUn = zzcVar.zzaUn;
        this.zzaUo = zzcVar.zzaUo;
        this.zzaUr = new ArrayList(zzcVar.zzaUr);
        this.zzaUq = new HashMap(zzcVar.zzaUq.size());
        for (Map.Entry entry : zzcVar.zzaUq.entrySet()) {
            zze zzeVarZzg = zzg((Class) entry.getKey());
            ((zze) entry.getValue()).zza(zzeVarZzg);
            this.zzaUq.put(entry.getKey(), zzeVarZzg);
        }
    }

    zzc(zzf zzfVar, zzmq zzmqVar) {
        zzx.zzz(zzfVar);
        zzx.zzz(zzmqVar);
        this.zzaUi = zzfVar;
        this.zzqW = zzmqVar;
        this.zzaUn = 1800000L;
        this.zzaUo = 3024000000L;
        this.zzaUq = new HashMap();
        this.zzaUr = new ArrayList();
    }

    private static zze zzg(Class cls) {
        try {
            return (zze) cls.newInstance();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e);
        } catch (InstantiationException e2) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e2);
        }
    }

    final void zzAA() {
        this.zzaUm = this.zzqW.elapsedRealtime();
        if (this.zzaUl != 0) {
            this.zzaUk = this.zzaUl;
        } else {
            this.zzaUk = this.zzqW.currentTimeMillis();
        }
        this.zzaUj = true;
    }

    final zzf zzAB() {
        return this.zzaUi;
    }

    final zzg zzAC() {
        return this.zzaUi.zzAC();
    }

    final boolean zzAD() {
        return this.zzaUp;
    }

    final void zzAE() {
        this.zzaUp = true;
    }

    public final zzc zzAu() {
        return new zzc(this);
    }

    public final Collection zzAv() {
        return this.zzaUq.values();
    }

    public final List zzAw() {
        return this.zzaUr;
    }

    public final long zzAx() {
        return this.zzaUk;
    }

    public final void zzAy() {
        zzAC().zze(this);
    }

    public final boolean zzAz() {
        return this.zzaUj;
    }

    public final void zzM(long j) {
        this.zzaUl = j;
    }

    public final void zzb(zze zzeVar) {
        zzx.zzz(zzeVar);
        Class<?> cls = zzeVar.getClass();
        if (cls.getSuperclass() != zze.class) {
            throw new IllegalArgumentException();
        }
        zzeVar.zza(zzf(cls));
    }

    public final zze zze(Class cls) {
        return (zze) this.zzaUq.get(cls);
    }

    public final zze zzf(Class cls) {
        zze zzeVar = (zze) this.zzaUq.get(cls);
        if (zzeVar != null) {
            return zzeVar;
        }
        zze zzeVarZzg = zzg(cls);
        this.zzaUq.put(cls, zzeVarZzg);
        return zzeVarZzg;
    }
}
