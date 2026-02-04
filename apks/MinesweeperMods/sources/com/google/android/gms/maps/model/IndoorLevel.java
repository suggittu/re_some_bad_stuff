package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public final class IndoorLevel {
    private final com.google.android.gms.maps.model.internal.zze zzaTt;

    public IndoorLevel(com.google.android.gms.maps.model.internal.zze zzeVar) {
        this.zzaTt = (com.google.android.gms.maps.model.internal.zze) zzx.zzz(zzeVar);
    }

    public final void activate() {
        try {
            this.zzaTt.activate();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.zzaTt.zza(((IndoorLevel) obj).zzaTt);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final String getName() {
        try {
            return this.zzaTt.getName();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final String getShortName() {
        try {
            return this.zzaTt.getShortName();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.zzaTt.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
