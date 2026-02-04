package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes2.dex */
public class zzj extends com.google.android.gms.drive.metadata.zzb {
    public zzj(String str, Collection collection, Collection collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    public void zza(Bundle bundle, Collection collection) {
        bundle.putParcelableArrayList(getName(), collection instanceof ArrayList ? (ArrayList) collection : new ArrayList<>(collection));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zzs, reason: merged with bridge method [inline-methods] */
    public Collection zzn(Bundle bundle) {
        return bundle.getParcelableArrayList(getName());
    }
}
