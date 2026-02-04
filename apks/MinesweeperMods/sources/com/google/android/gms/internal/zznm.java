package com.google.android.gms.internal;

import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes2.dex */
public class zznm {
    public static final MetadataField zzasU = zznp.zzatS;
    public static final MetadataField zzasV = new com.google.android.gms.drive.metadata.internal.zzp("alternateLink", 4300000);
    public static final zza zzasW = new zza(5000000);
    public static final MetadataField zzasX = new com.google.android.gms.drive.metadata.internal.zzp(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 4300000);
    public static final MetadataField zzasY = new com.google.android.gms.drive.metadata.internal.zzp("embedLink", 4300000);
    public static final MetadataField zzasZ = new com.google.android.gms.drive.metadata.internal.zzp("fileExtension", 4300000);
    public static final MetadataField zzata = new com.google.android.gms.drive.metadata.internal.zzg("fileSize", 4300000);
    public static final MetadataField zzatb = new com.google.android.gms.drive.metadata.internal.zzp("folderColorRgb", 7500000);
    public static final MetadataField zzatc = new com.google.android.gms.drive.metadata.internal.zzb("hasThumbnail", 4300000);
    public static final MetadataField zzatd = new com.google.android.gms.drive.metadata.internal.zzp("indexableText", 4300000);
    public static final MetadataField zzate = new com.google.android.gms.drive.metadata.internal.zzb("isAppData", 4300000);
    public static final MetadataField zzatf = new com.google.android.gms.drive.metadata.internal.zzb("isCopyable", 4300000);
    public static final MetadataField zzatg = new com.google.android.gms.drive.metadata.internal.zzb("isEditable", 4100000);
    public static final MetadataField zzath = new com.google.android.gms.drive.metadata.internal.zzb("isExplicitlyTrashed", Collections.singleton("trashed"), Collections.emptySet(), 7000000) { // from class: com.google.android.gms.internal.zznm.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.drive.metadata.internal.zzb, com.google.android.gms.drive.metadata.zza
        /* renamed from: zze */
        public final Boolean zzc(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.zzc("trashed", i, i2) == 2);
        }
    };
    public static final MetadataField zzati = new com.google.android.gms.drive.metadata.internal.zzb("isLocalContentUpToDate", 7800000);
    public static final zzb zzatj = new zzb("isPinned", 4100000);
    public static final MetadataField zzatk = new com.google.android.gms.drive.metadata.internal.zzb("isOpenable", 7200000);
    public static final MetadataField zzatl = new com.google.android.gms.drive.metadata.internal.zzb("isRestricted", 4300000);
    public static final MetadataField zzatm = new com.google.android.gms.drive.metadata.internal.zzb("isShared", 4300000);
    public static final MetadataField zzatn = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosFolder", 7000000);
    public static final MetadataField zzato = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosRootFolder", 7000000);
    public static final MetadataField zzatp = new com.google.android.gms.drive.metadata.internal.zzb("isTrashable", 4400000);
    public static final MetadataField zzatq = new com.google.android.gms.drive.metadata.internal.zzb("isViewed", 4300000);
    public static final zzc zzatr = new zzc(4100000);
    public static final MetadataField zzats = new com.google.android.gms.drive.metadata.internal.zzp("originalFilename", 4300000);
    public static final com.google.android.gms.drive.metadata.zzb zzatt = new com.google.android.gms.drive.metadata.internal.zzo("ownerNames", 4300000);
    public static final com.google.android.gms.drive.metadata.internal.zzq zzatu = new com.google.android.gms.drive.metadata.internal.zzq("lastModifyingUser", 6000000);
    public static final com.google.android.gms.drive.metadata.internal.zzq zzatv = new com.google.android.gms.drive.metadata.internal.zzq("sharingUser", 6000000);
    public static final com.google.android.gms.drive.metadata.internal.zzm zzatw = new com.google.android.gms.drive.metadata.internal.zzm(4100000);
    public static final zzd zzatx = new zzd("quotaBytesUsed", 4300000);
    public static final zzf zzaty = new zzf("starred", 4100000);
    public static final MetadataField zzatz = new com.google.android.gms.drive.metadata.internal.zzk("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000) { // from class: com.google.android.gms.internal.zznm.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.drive.metadata.zza
        /* renamed from: zzk, reason: merged with bridge method [inline-methods] */
        public final BitmapTeleporter zzc(DataHolder dataHolder, int i, int i2) {
            throw new IllegalStateException("Thumbnail field is write only");
        }
    };
    public static final zzg zzatA = new zzg(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 4100000);
    public static final zzh zzatB = new zzh("trashed", 4100000);
    public static final MetadataField zzatC = new com.google.android.gms.drive.metadata.internal.zzp("webContentLink", 4300000);
    public static final MetadataField zzatD = new com.google.android.gms.drive.metadata.internal.zzp("webViewLink", 4300000);
    public static final MetadataField zzatE = new com.google.android.gms.drive.metadata.internal.zzp("uniqueIdentifier", 5000000);
    public static final com.google.android.gms.drive.metadata.internal.zzb zzatF = new com.google.android.gms.drive.metadata.internal.zzb("writersCanShare", 6000000);
    public static final MetadataField zzatG = new com.google.android.gms.drive.metadata.internal.zzp("role", 6000000);
    public static final MetadataField zzatH = new com.google.android.gms.drive.metadata.internal.zzp("md5Checksum", 7000000);
    public static final zze zzatI = new zze(7000000);
    public static final MetadataField zzatJ = new com.google.android.gms.drive.metadata.internal.zzp("recencyReason", 8000000);
    public static final MetadataField zzatK = new com.google.android.gms.drive.metadata.internal.zzb("subscribed", 8000000);

    public class zza extends zznn implements SearchableMetadataField {
        public zza(int i) {
            super(i);
        }
    }

    public class zzb extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField {
        public zzb(String str, int i) {
            super(str, i);
        }
    }

    public class zzc extends com.google.android.gms.drive.metadata.internal.zzp implements SearchableMetadataField {
        public zzc(int i) {
            super("mimeType", i);
        }
    }

    public class zzd extends com.google.android.gms.drive.metadata.internal.zzg implements SortableMetadataField {
        public zzd(String str, int i) {
            super(str, i);
        }
    }

    public class zze extends com.google.android.gms.drive.metadata.internal.zzj {
        public zze(int i) {
            super("spaces", Arrays.asList("inDriveSpace", "isAppData", "inGooglePhotosSpace"), Collections.emptySet(), i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.drive.metadata.zzb, com.google.android.gms.drive.metadata.zza
        /* renamed from: zzd */
        public Collection zzc(DataHolder dataHolder, int i, int i2) {
            ArrayList arrayList = new ArrayList();
            if (dataHolder.zze("inDriveSpace", i, i2)) {
                arrayList.add(DriveSpace.zzaoP);
            }
            if (dataHolder.zze("isAppData", i, i2)) {
                arrayList.add(DriveSpace.zzaoQ);
            }
            if (dataHolder.zze("inGooglePhotosSpace", i, i2)) {
                arrayList.add(DriveSpace.zzaoR);
            }
            return arrayList;
        }
    }

    public class zzf extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField {
        public zzf(String str, int i) {
            super(str, i);
        }
    }

    public class zzg extends com.google.android.gms.drive.metadata.internal.zzp implements SearchableMetadataField, SortableMetadataField {
        public zzg(String str, int i) {
            super(str, i);
        }
    }

    public class zzh extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField {
        public zzh(String str, int i) {
            super(str, i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.drive.metadata.internal.zzb, com.google.android.gms.drive.metadata.zza
        /* renamed from: zze */
        public Boolean zzc(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.zzc(getName(), i, i2) != 0);
        }
    }
}
