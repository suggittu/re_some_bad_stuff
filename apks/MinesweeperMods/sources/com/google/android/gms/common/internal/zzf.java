package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzro;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzf {
    private final Account zzTI;
    private final String zzUW;
    private final Set zzagh;
    private final int zzagj;
    private final View zzagk;
    private final String zzagl;
    private final Set zzalb;
    private final Map zzalc;
    private final zzro zzald;
    private Integer zzale;

    public final class zza {
        public final Set zzXf;
        public final boolean zzalf;

        public zza(Set set, boolean z) {
            zzx.zzz(set);
            this.zzXf = Collections.unmodifiableSet(set);
            this.zzalf = z;
        }
    }

    public zzf(Account account, Set set, Map map, int i, View view, String str, String str2, zzro zzroVar) {
        this.zzTI = account;
        this.zzagh = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.zzalc = map == null ? Collections.EMPTY_MAP : map;
        this.zzagk = view;
        this.zzagj = i;
        this.zzUW = str;
        this.zzagl = str2;
        this.zzald = zzroVar;
        HashSet hashSet = new HashSet(this.zzagh);
        Iterator it = this.zzalc.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(((zza) it.next()).zzXf);
        }
        this.zzalb = Collections.unmodifiableSet(hashSet);
    }

    public static zzf zzat(Context context) {
        return new GoogleApiClient.Builder(context).zzoY();
    }

    public final Account getAccount() {
        return this.zzTI;
    }

    @Deprecated
    public final String getAccountName() {
        if (this.zzTI != null) {
            return this.zzTI.name;
        }
        return null;
    }

    public final void zza(Integer num) {
        this.zzale = num;
    }

    public final Set zzb(Api api) {
        zza zzaVar = (zza) this.zzalc.get(api);
        if (zzaVar == null || zzaVar.zzXf.isEmpty()) {
            return this.zzagh;
        }
        HashSet hashSet = new HashSet(this.zzagh);
        hashSet.addAll(zzaVar.zzXf);
        return hashSet;
    }

    public final Account zzqq() {
        return this.zzTI != null ? this.zzTI : new Account("<<default account>>", "com.google");
    }

    public final int zzqr() {
        return this.zzagj;
    }

    public final Set zzqs() {
        return this.zzagh;
    }

    public final Set zzqt() {
        return this.zzalb;
    }

    public final Map zzqu() {
        return this.zzalc;
    }

    public final String zzqv() {
        return this.zzUW;
    }

    public final String zzqw() {
        return this.zzagl;
    }

    public final View zzqx() {
        return this.zzagk;
    }

    public final zzro zzqy() {
        return this.zzald;
    }

    public final Integer zzqz() {
        return this.zzale;
    }
}
