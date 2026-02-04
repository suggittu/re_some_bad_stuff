package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class zznp extends com.google.android.gms.drive.metadata.internal.zzk {
    public static final zznp zzatS = new zznp();

    private zznp() {
        super("driveId", Arrays.asList("sqlId", "resourceId", "mimeType"), Arrays.asList("dbInstanceId"), 4100000);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        Iterator it = zzty().iterator();
        while (it.hasNext()) {
            if (!dataHolder.zzcz((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public DriveId zzc(DataHolder dataHolder, int i, int i2) {
        long j = dataHolder.zzpZ().getLong("dbInstanceId");
        int i3 = DriveFolder.MIME_TYPE.equals(dataHolder.zzd(zznm.zzatr.getName(), i, i2)) ? 1 : 0;
        String strZzd = dataHolder.zzd("resourceId", i, i2);
        Long lValueOf = Long.valueOf(dataHolder.zzb("sqlId", i, i2));
        if ("generated-android-null".equals(strZzd)) {
            strZzd = null;
        }
        return new DriveId(strZzd, lValueOf.longValue(), j, i3);
    }
}
