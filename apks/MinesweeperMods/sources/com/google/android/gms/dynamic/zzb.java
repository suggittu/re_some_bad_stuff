package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.zzc;

@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public final class zzb extends zzc.zza {
    private Fragment zzavH;

    private zzb(Fragment fragment) {
        this.zzavH = fragment;
    }

    public static zzb zza(Fragment fragment) {
        if (fragment != null) {
            return new zzb(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final Bundle getArguments() {
        return this.zzavH.getArguments();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final int getId() {
        return this.zzavH.getId();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean getRetainInstance() {
        return this.zzavH.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final String getTag() {
        return this.zzavH.getTag();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final int getTargetRequestCode() {
        return this.zzavH.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean getUserVisibleHint() {
        return this.zzavH.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final zzd getView() {
        return zze.zzC(this.zzavH.getView());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean isAdded() {
        return this.zzavH.isAdded();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean isDetached() {
        return this.zzavH.isDetached();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean isHidden() {
        return this.zzavH.isHidden();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean isInLayout() {
        return this.zzavH.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean isRemoving() {
        return this.zzavH.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean isResumed() {
        return this.zzavH.isResumed();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final boolean isVisible() {
        return this.zzavH.isVisible();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void setHasOptionsMenu(boolean z) {
        this.zzavH.setHasOptionsMenu(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void setMenuVisibility(boolean z) {
        this.zzavH.setMenuVisibility(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void setRetainInstance(boolean z) {
        this.zzavH.setRetainInstance(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void setUserVisibleHint(boolean z) {
        this.zzavH.setUserVisibleHint(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void startActivity(Intent intent) {
        this.zzavH.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void startActivityForResult(Intent intent, int i) {
        this.zzavH.startActivityForResult(intent, i);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void zzn(zzd zzdVar) {
        this.zzavH.registerForContextMenu((View) zze.zzp(zzdVar));
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final void zzo(zzd zzdVar) {
        this.zzavH.unregisterForContextMenu((View) zze.zzp(zzdVar));
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final zzd zztV() {
        return zze.zzC(this.zzavH.getActivity());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final zzc zztW() {
        return zza(this.zzavH.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final zzd zztX() {
        return zze.zzC(this.zzavH.getResources());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public final zzc zztY() {
        return zza(this.zzavH.getTargetFragment());
    }
}
