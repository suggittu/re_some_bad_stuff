package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

/* loaded from: classes2.dex */
class zze {
    static MetadataField zza(MetadataBundle metadataBundle) {
        Set setZztG = metadataBundle.zztG();
        if (setZztG.size() != 1) {
            throw new IllegalArgumentException("bundle should have exactly 1 populated field");
        }
        return (MetadataField) setZztG.iterator().next();
    }
}
