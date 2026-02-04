package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class IndoorBuilding {
    private final com.google.android.gms.maps.model.internal.zzd zzaTs;

    public IndoorBuilding(com.google.android.gms.maps.model.internal.zzd zzdVar) {
        this.zzaTs = (com.google.android.gms.maps.model.internal.zzd) zzx.zzz(zzdVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.zzaTs.zzb(((IndoorBuilding) obj).zzaTs);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getActiveLevelIndex() {
        try {
            return this.zzaTs.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getDefaultLevelIndex() {
        try {
            return this.zzaTs.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final List getLevels() {
        try {
            List levels = this.zzaTs.getLevels();
            ArrayList arrayList = new ArrayList(levels.size());
            Iterator it = levels.iterator();
            while (it.hasNext()) {
                arrayList.add(new IndoorLevel(zze.zza.zzdh((IBinder) it.next())));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.zzaTs.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isUnderground() {
        try {
            return this.zzaTs.isUnderground();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
