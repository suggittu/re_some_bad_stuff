package com.google.android.gms.measurement.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
class zzae {
    final boolean zzaXg;
    final int zzaZh;
    final boolean zzaZi;
    final String zzaZj;
    final List zzaZk;
    final String zzaZl;

    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzae(com.google.android.gms.internal.zzpz.zzf r7) {
        /*
            r6 = this;
            r5 = 6
            r1 = 1
            r2 = 0
            r0 = 0
            r6.<init>()
            com.google.android.gms.common.internal.zzx.zzz(r7)
            java.lang.Integer r3 = r7.zzaZN
            if (r3 == 0) goto L16
            java.lang.Integer r3 = r7.zzaZN
            int r3 = r3.intValue()
            if (r3 != 0) goto L52
        L16:
            r3 = r0
        L17:
            if (r3 == 0) goto L82
            java.lang.Integer r4 = r7.zzaZN
            int r4 = r4.intValue()
            r6.zzaZh = r4
            java.lang.Boolean r4 = r7.zzaZP
            if (r4 == 0) goto L2e
            java.lang.Boolean r4 = r7.zzaZP
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L2e
            r0 = r1
        L2e:
            r6.zzaZi = r0
            boolean r0 = r6.zzaZi
            if (r0 != 0) goto L3c
            int r0 = r6.zzaZh
            if (r0 == r1) goto L3c
            int r0 = r6.zzaZh
            if (r0 != r5) goto L6b
        L3c:
            java.lang.String r0 = r7.zzaZO
            r6.zzaZj = r0
        L40:
            java.lang.String[] r0 = r7.zzaZQ
            if (r0 != 0) goto L76
            r0 = r2
        L45:
            r6.zzaZk = r0
            int r0 = r6.zzaZh
            if (r0 != r1) goto L7f
            java.lang.String r0 = r6.zzaZj
            r6.zzaZl = r0
        L4f:
            r6.zzaXg = r3
            return
        L52:
            java.lang.Integer r3 = r7.zzaZN
            int r3 = r3.intValue()
            if (r3 != r5) goto L65
            java.lang.String[] r3 = r7.zzaZQ
            if (r3 == 0) goto L63
            java.lang.String[] r3 = r7.zzaZQ
            int r3 = r3.length
            if (r3 != 0) goto L8d
        L63:
            r3 = r0
            goto L17
        L65:
            java.lang.String r3 = r7.zzaZO
            if (r3 != 0) goto L8d
            r3 = r0
            goto L17
        L6b:
            java.lang.String r0 = r7.zzaZO
            java.util.Locale r4 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toUpperCase(r4)
            r6.zzaZj = r0
            goto L40
        L76:
            java.lang.String[] r0 = r7.zzaZQ
            boolean r4 = r6.zzaZi
            java.util.List r0 = r6.zza(r0, r4)
            goto L45
        L7f:
            r6.zzaZl = r2
            goto L4f
        L82:
            r6.zzaZh = r0
            r6.zzaZi = r0
            r6.zzaZj = r2
            r6.zzaZk = r2
            r6.zzaZl = r2
            goto L4f
        L8d:
            r3 = r1
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzae.<init>(com.google.android.gms.internal.zzpz$zzf):void");
    }

    private List zza(String[] strArr, boolean z) {
        if (z) {
            return Arrays.asList(strArr);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(str.toUpperCase(Locale.ENGLISH));
        }
        return arrayList;
    }

    public Boolean zzfp(String str) {
        if (!this.zzaXg) {
            return null;
        }
        if (!this.zzaZi && this.zzaZh != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (this.zzaZh) {
            case 1:
                return Boolean.valueOf(Pattern.compile(this.zzaZl, this.zzaZi ? 0 : 66).matcher(str).matches());
            case 2:
                return Boolean.valueOf(str.startsWith(this.zzaZj));
            case 3:
                return Boolean.valueOf(str.endsWith(this.zzaZj));
            case 4:
                return Boolean.valueOf(str.contains(this.zzaZj));
            case 5:
                return Boolean.valueOf(str.equals(this.zzaZj));
            case 6:
                return Boolean.valueOf(this.zzaZk.contains(str));
            default:
                return null;
        }
    }
}
