package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.zzc;

/* loaded from: classes2.dex */
public final class zzh extends zzc.zza {
    private Fragment zzalg;

    private zzh(Fragment fragment) {
        this.zzalg = fragment;
    }

    public static zzh zza(Fragment fragment) {
        if (fragment != null) {
            return new zzh(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final Bundle getArguments() {
        return this.zzalg.getArguments();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final int getId() {
        return this.zzalg.getId();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean getRetainInstance() {
        return this.zzalg.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final String getTag() {
        return this.zzalg.getTag();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final int getTargetRequestCode() {
        return this.zzalg.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean getUserVisibleHint() {
        return this.zzalg.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final zzd getView() {
        return zze.zzC(this.zzalg.getView());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean isAdded() {
        return this.zzalg.isAdded();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean isDetached() {
        return this.zzalg.isDetached();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean isHidden() {
        return this.zzalg.isHidden();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean isInLayout() {
        return this.zzalg.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean isRemoving() {
        return this.zzalg.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean isResumed() {
        return this.zzalg.isResumed();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean isVisible() {
        return this.zzalg.isVisible();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void setHasOptionsMenu(boolean z) {
        this.zzalg.setHasOptionsMenu(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void setMenuVisibility(boolean z) {
        this.zzalg.setMenuVisibility(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void setRetainInstance(boolean z) {
        this.zzalg.setRetainInstance(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void setUserVisibleHint(boolean z) {
        this.zzalg.setUserVisibleHint(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void startActivity(Intent intent) {
        this.zzalg.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void startActivityForResult(Intent intent, int i) {
        this.zzalg.startActivityForResult(intent, i);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void zzn(zzd zzdVar) {
        this.zzalg.registerForContextMenu((View) zze.zzp(zzdVar));
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void zzo(zzd zzdVar) {
        this.zzalg.unregisterForContextMenu((View) zze.zzp(zzdVar));
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final zzd zztV() {
        return zze.zzC(this.zzalg.getActivity());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final zzc zztW() {
        return zza(this.zzalg.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final zzd zztX() {
        return zze.zzC(this.zzalg.getResources());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final zzc zztY() {
        return zza(this.zzalg.getTargetFragment());
    }
}
