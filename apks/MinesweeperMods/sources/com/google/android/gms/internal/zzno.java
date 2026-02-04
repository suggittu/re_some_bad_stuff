package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;

/* loaded from: classes2.dex */
public class zzno {
    public static final zza zzatM = new zza("created", 4100000);
    public static final zzb zzatN = new zzb("lastOpenedTime", 4300000);
    public static final zzd zzatO = new zzd("modified", 4100000);
    public static final zzc zzatP = new zzc("modifiedByMe", 4100000);
    public static final zzf zzatQ = new zzf("sharedWithMe", 4100000);
    public static final zze zzatR = new zze("recency", 8000000);

    public class zza extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField {
        public zza(String str, int i) {
            super(str, i);
        }
    }

    public class zzb extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField, SortableMetadataField {
        public zzb(String str, int i) {
            super(str, i);
        }
    }

    public class zzc extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField {
        public zzc(String str, int i) {
            super(str, i);
        }
    }

    public class zzd extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField, SortableMetadataField {
        public zzd(String str, int i) {
            super(str, i);
        }
    }

    public class zze extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField {
        public zze(String str, int i) {
            super(str, i);
        }
    }

    public class zzf extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField, SortableMetadataField {
        public zzf(String str, int i) {
            super(str, i);
        }
    }
}
