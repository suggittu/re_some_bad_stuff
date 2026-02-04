package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public interface MetadataField {
    String getName();

    Object zza(DataHolder dataHolder, int i, int i2);

    void zza(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2);

    void zza(Object obj, Bundle bundle);

    Object zzm(Bundle bundle);
}
