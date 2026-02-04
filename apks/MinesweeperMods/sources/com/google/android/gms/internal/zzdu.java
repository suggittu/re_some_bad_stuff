package com.google.android.gms.internal;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzhb
/* loaded from: classes2.dex */
public class zzdu extends zzdr {
    private static final Set zzzX = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzzY = new DecimalFormat("#,###");
    private boolean zzAa;
    private File zzzZ;

    public zzdu(zzjp zzjpVar) {
        super(zzjpVar);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzin.zzaK("Context.getCacheDir() returned null");
            return;
        }
        this.zzzZ = new File(cacheDir, "admobVideoStreams");
        if (!this.zzzZ.isDirectory() && !this.zzzZ.mkdirs()) {
            zzin.zzaK("Could not create preload cache directory at " + this.zzzZ.getAbsolutePath());
            this.zzzZ = null;
        } else {
            if (this.zzzZ.setReadable(true, false) && this.zzzZ.setExecutable(true, false)) {
                return;
            }
            zzin.zzaK("Could not set cache file permissions at " + this.zzzZ.getAbsolutePath());
            this.zzzZ = null;
        }
    }

    private File zza(File file) {
        return new File(this.zzzZ, file.getName() + ".done");
    }

    private static void zzb(File file) throws IOException {
        if (file.isFile()) {
            file.setLastModified(System.currentTimeMillis());
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
    }

    @Override // com.google.android.gms.internal.zzdr
    public void abort() {
        this.zzAa = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x0323, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x032b, code lost:
    
        if (com.google.android.gms.internal.zzin.zzQ(3) == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x032d, code lost:
    
        com.google.android.gms.internal.zzin.zzaI("Preloaded " + com.google.android.gms.internal.zzdu.zzzY.format(r5) + " bytes from " + r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0352, code lost:
    
        r11.setReadable(true, false);
        zzb(r12);
        zza(r27, r11.getAbsolutePath(), r5);
        com.google.android.gms.internal.zzdu.zzzX.remove(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x036a, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.String] */
    @Override // com.google.android.gms.internal.zzdr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean zzU(java.lang.String r27) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 943
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdu.zzU(java.lang.String):boolean");
    }

    public int zzea() {
        int i = 0;
        if (this.zzzZ != null) {
            for (File file : this.zzzZ.listFiles()) {
                if (!file.getName().endsWith(".done")) {
                    i++;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean zzeb() {
        /*
            r11 = this;
            r6 = 0
            java.io.File r0 = r11.zzzZ
            if (r0 != 0) goto L6
        L5:
            return r6
        L6:
            r5 = 0
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.io.File r0 = r11.zzzZ
            java.io.File[] r8 = r0.listFiles()
            int r9 = r8.length
            r7 = r6
        L14:
            if (r7 >= r9) goto L33
            r4 = r8[r7]
            java.lang.String r0 = r4.getName()
            java.lang.String r1 = ".done"
            boolean r0 = r0.endsWith(r1)
            if (r0 != 0) goto L4c
            long r0 = r4.lastModified()
            int r10 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r10 >= 0) goto L4c
            r2 = r4
        L2d:
            int r3 = r7 + 1
            r7 = r3
            r5 = r2
            r2 = r0
            goto L14
        L33:
            if (r5 == 0) goto L4a
            boolean r0 = r5.delete()
            java.io.File r1 = r11.zza(r5)
            boolean r2 = r1.isFile()
            if (r2 == 0) goto L48
            boolean r1 = r1.delete()
            r0 = r0 & r1
        L48:
            r6 = r0
            goto L5
        L4a:
            r0 = r6
            goto L48
        L4c:
            r0 = r2
            r2 = r5
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdu.zzeb():boolean");
    }
}
