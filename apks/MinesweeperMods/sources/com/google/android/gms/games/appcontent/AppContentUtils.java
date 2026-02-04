package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzmn;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class AppContentUtils {

    interface AppContentRunner {
        void zzb(ArrayList arrayList, int i);
    }

    public static ArrayList zza(DataHolder dataHolder, ArrayList arrayList, String str, int i) {
        final ArrayList arrayList2 = new ArrayList();
        zza(dataHolder, 1, str, "action_id", i, new AppContentRunner() { // from class: com.google.android.gms.games.appcontent.AppContentUtils.1
            @Override // com.google.android.gms.games.appcontent.AppContentUtils.AppContentRunner
            public final void zzb(ArrayList arrayList3, int i2) {
                arrayList2.add(new AppContentActionRef(arrayList3, i2));
            }
        }, arrayList);
        return arrayList2;
    }

    private static void zza(DataHolder dataHolder, int i, String str, String str2, int i2, AppContentRunner appContentRunner, ArrayList arrayList) {
        DataHolder dataHolder2 = (DataHolder) arrayList.get(i);
        String strZzd = dataHolder.zzd(str, i2, dataHolder.zzbH(i2));
        if (TextUtils.isEmpty(strZzd)) {
            return;
        }
        int count = dataHolder2.getCount();
        String[] strArrSplit = strZzd.split(",");
        for (int i3 = 0; i3 < count; i3++) {
            String strZzd2 = dataHolder2.zzd(str2, i3, dataHolder2.zzbH(i3));
            if (!TextUtils.isEmpty(strZzd2) && zzmn.zzb(strArrSplit, strZzd2)) {
                appContentRunner.zzb(arrayList, i3);
            }
        }
    }

    public static ArrayList zzb(DataHolder dataHolder, ArrayList arrayList, String str, int i) {
        final ArrayList arrayList2 = new ArrayList();
        zza(dataHolder, 2, str, "annotation_id", i, new AppContentRunner() { // from class: com.google.android.gms.games.appcontent.AppContentUtils.2
            @Override // com.google.android.gms.games.appcontent.AppContentUtils.AppContentRunner
            public final void zzb(ArrayList arrayList3, int i2) {
                arrayList2.add(new AppContentAnnotationRef(arrayList3, i2));
            }
        }, arrayList);
        return arrayList2;
    }

    public static ArrayList zzc(DataHolder dataHolder, ArrayList arrayList, String str, int i) {
        final ArrayList arrayList2 = new ArrayList();
        zza(dataHolder, 4, str, "condition_id", i, new AppContentRunner() { // from class: com.google.android.gms.games.appcontent.AppContentUtils.3
            @Override // com.google.android.gms.games.appcontent.AppContentUtils.AppContentRunner
            public final void zzb(ArrayList arrayList3, int i2) {
                arrayList2.add(new AppContentConditionRef(arrayList3, i2));
            }
        }, arrayList);
        return arrayList2;
    }

    public static Bundle zzd(DataHolder dataHolder, ArrayList arrayList, String str, int i) {
        final Bundle bundle = new Bundle();
        final DataHolder dataHolder2 = (DataHolder) arrayList.get(3);
        zza(dataHolder, 3, str, "tuple_id", i, new AppContentRunner() { // from class: com.google.android.gms.games.appcontent.AppContentUtils.4
            @Override // com.google.android.gms.games.appcontent.AppContentUtils.AppContentRunner
            public final void zzb(ArrayList arrayList2, int i2) {
                AppContentTupleRef appContentTupleRef = new AppContentTupleRef(dataHolder2, i2);
                bundle.putString(appContentTupleRef.getName(), appContentTupleRef.getValue());
            }
        }, arrayList);
        return bundle;
    }
}
