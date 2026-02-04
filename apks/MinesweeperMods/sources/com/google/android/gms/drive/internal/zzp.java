package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public final class zzp extends Metadata {
    private final MetadataBundle zzaqB;

    public zzp(MetadataBundle metadataBundle) {
        this.zzaqB = metadataBundle;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return this.zzaqB != null;
    }

    public final String toString() {
        return "Metadata [mImpl=" + this.zzaqB + "]";
    }

    @Override // com.google.android.gms.drive.Metadata
    public final Object zza(MetadataField metadataField) {
        return this.zzaqB.zza(metadataField);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzsK, reason: merged with bridge method [inline-methods] */
    public final Metadata freeze() {
        return new zzp(this.zzaqB.zztF());
    }
}
