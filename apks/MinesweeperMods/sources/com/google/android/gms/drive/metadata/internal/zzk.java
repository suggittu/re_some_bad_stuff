package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.Collection;

/* loaded from: classes2.dex */
public abstract class zzk extends com.google.android.gms.drive.metadata.zza {
    public zzk(String str, Collection collection, Collection collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    public void zza(Bundle bundle, Parcelable parcelable) {
        bundle.putParcelable(getName(), parcelable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zzt, reason: merged with bridge method [inline-methods] */
    public Parcelable zzn(Bundle bundle) {
        return bundle.getParcelable(getName());
    }
}
