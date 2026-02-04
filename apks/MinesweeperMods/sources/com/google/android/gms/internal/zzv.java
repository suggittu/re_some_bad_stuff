package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.zzb;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzv implements com.google.android.gms.internal.zzb {
    private final int zzaA;
    private final Map zzax;
    private long zzay;
    private final File zzaz;

    class zza {
        public String key;
        public long zzaB;
        public String zzb;
        public long zzc;
        public long zzd;
        public long zze;
        public long zzf;
        public Map zzg;

        private zza() {
        }

        public zza(String str, zzb.zza zzaVar) {
            this.key = str;
            this.zzaB = zzaVar.data.length;
            this.zzb = zzaVar.zzb;
            this.zzc = zzaVar.zzc;
            this.zzd = zzaVar.zzd;
            this.zze = zzaVar.zze;
            this.zzf = zzaVar.zzf;
            this.zzg = zzaVar.zzg;
        }

        public static zza zzf(InputStream inputStream) throws IOException {
            zza zzaVar = new zza();
            if (zzv.zzb(inputStream) != 538247942) {
                throw new IOException();
            }
            zzaVar.key = zzv.zzd(inputStream);
            zzaVar.zzb = zzv.zzd(inputStream);
            if (zzaVar.zzb.equals("")) {
                zzaVar.zzb = null;
            }
            zzaVar.zzc = zzv.zzc(inputStream);
            zzaVar.zzd = zzv.zzc(inputStream);
            zzaVar.zze = zzv.zzc(inputStream);
            zzaVar.zzf = zzv.zzc(inputStream);
            zzaVar.zzg = zzv.zze(inputStream);
            return zzaVar;
        }

        public boolean zza(OutputStream outputStream) throws IOException {
            try {
                zzv.zza(outputStream, 538247942);
                zzv.zza(outputStream, this.key);
                zzv.zza(outputStream, this.zzb == null ? "" : this.zzb);
                zzv.zza(outputStream, this.zzc);
                zzv.zza(outputStream, this.zzd);
                zzv.zza(outputStream, this.zze);
                zzv.zza(outputStream, this.zzf);
                zzv.zza(this.zzg, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                zzs.zzb("%s", e.toString());
                return false;
            }
        }

        public zzb.zza zzb(byte[] bArr) {
            zzb.zza zzaVar = new zzb.zza();
            zzaVar.data = bArr;
            zzaVar.zzb = this.zzb;
            zzaVar.zzc = this.zzc;
            zzaVar.zzd = this.zzd;
            zzaVar.zze = this.zze;
            zzaVar.zzf = this.zzf;
            zzaVar.zzg = this.zzg;
            return zzaVar;
        }
    }

    class zzb extends FilterInputStream {
        private int zzaC;

        private zzb(InputStream inputStream) {
            super(inputStream);
            this.zzaC = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i = super.read();
            if (i != -1) {
                this.zzaC++;
            }
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = super.read(bArr, i, i2);
            if (i3 != -1) {
                this.zzaC += i3;
            }
            return i3;
        }
    }

    public zzv(File file) {
        this(file, 5242880);
    }

    public zzv(File file, int i) {
        this.zzax = new LinkedHashMap(16, 0.75f, true);
        this.zzay = 0L;
        this.zzaz = file;
        this.zzaA = i;
    }

    private void removeEntry(String str) {
        zza zzaVar = (zza) this.zzax.get(str);
        if (zzaVar != null) {
            this.zzay -= zzaVar.zzaB;
            this.zzax.remove(str);
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i == -1) {
            throw new EOFException();
        }
        return i;
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void zza(String str, zza zzaVar) {
        if (this.zzax.containsKey(str)) {
            this.zzay = (zzaVar.zzaB - ((zza) this.zzax.get(str)).zzaB) + this.zzay;
        } else {
            this.zzay += zzaVar.zzaB;
        }
        this.zzax.put(str, zzaVar);
    }

    static void zza(Map map, OutputStream outputStream) throws IOException {
        if (map == null) {
            zza(outputStream, 0);
            return;
        }
        zza(outputStream, map.size());
        for (Map.Entry entry : map.entrySet()) {
            zza(outputStream, (String) entry.getKey());
            zza(outputStream, (String) entry.getValue());
        }
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                break;
            }
            i2 += i3;
        }
        if (i2 != i) {
            throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
        }
        return bArr;
    }

    static int zzb(InputStream inputStream) {
        return (zza(inputStream) << 0) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16) | (zza(inputStream) << 24);
    }

    static long zzc(InputStream inputStream) {
        return 0 | ((zza(inputStream) & 255) << 0) | ((zza(inputStream) & 255) << 8) | ((zza(inputStream) & 255) << 16) | ((zza(inputStream) & 255) << 24) | ((zza(inputStream) & 255) << 32) | ((zza(inputStream) & 255) << 40) | ((zza(inputStream) & 255) << 48) | ((zza(inputStream) & 255) << 56);
    }

    private void zzc(int i) {
        int i2;
        if (this.zzay + i < this.zzaA) {
            return;
        }
        if (zzs.DEBUG) {
            zzs.zza("Pruning old cache entries.", new Object[0]);
        }
        long j = this.zzay;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator it = this.zzax.entrySet().iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = i3;
                break;
            }
            zza zzaVar = (zza) ((Map.Entry) it.next()).getValue();
            if (zzf(zzaVar.key).delete()) {
                this.zzay -= zzaVar.zzaB;
            } else {
                zzs.zzb("Could not delete cache entry for key=%s, filename=%s", zzaVar.key, zze(zzaVar.key));
            }
            it.remove();
            i2 = i3 + 1;
            if (this.zzay + i < this.zzaA * 0.9f) {
                break;
            } else {
                i3 = i2;
            }
        }
        if (zzs.DEBUG) {
            zzs.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzay - j), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    static String zzd(InputStream inputStream) {
        return new String(zza(inputStream, (int) zzc(inputStream)), "UTF-8");
    }

    private String zze(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    static Map zze(InputStream inputStream) {
        int iZzb = zzb(inputStream);
        Map mapEmptyMap = iZzb == 0 ? Collections.emptyMap() : new HashMap(iZzb);
        for (int i = 0; i < iZzb; i++) {
            mapEmptyMap.put(zzd(inputStream).intern(), zzd(inputStream).intern());
        }
        return mapEmptyMap;
    }

    public synchronized void remove(String str) {
        boolean zDelete = zzf(str).delete();
        removeEntry(str);
        if (!zDelete) {
            zzs.zzb("Could not delete cache entry for key=%s, filename=%s", str, zze(str));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.zzb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.google.android.gms.internal.zzb.zza zza(java.lang.String r9) {
        /*
            r8 = this;
            r1 = 0
            monitor-enter(r8)
            java.util.Map r0 = r8.zzax     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r9)     // Catch: java.lang.Throwable -> L68
            com.google.android.gms.internal.zzv$zza r0 = (com.google.android.gms.internal.zzv.zza) r0     // Catch: java.lang.Throwable -> L68
            if (r0 != 0) goto Lf
            r0 = r1
        Ld:
            monitor-exit(r8)
            return r0
        Lf:
            java.io.File r3 = r8.zzf(r9)     // Catch: java.lang.Throwable -> L68
            com.google.android.gms.internal.zzv$zzb r2 = new com.google.android.gms.internal.zzv$zzb     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L60
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L60
            r4.<init>(r3)     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L60
            r5 = 0
            r2.<init>(r4)     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L60
            com.google.android.gms.internal.zzv.zza.zzf(r2)     // Catch: java.lang.Throwable -> L6e java.io.IOException -> L70
            long r4 = r3.length()     // Catch: java.lang.Throwable -> L6e java.io.IOException -> L70
            int r6 = com.google.android.gms.internal.zzv.zzb.zza(r2)     // Catch: java.lang.Throwable -> L6e java.io.IOException -> L70
            long r6 = (long) r6     // Catch: java.lang.Throwable -> L6e java.io.IOException -> L70
            long r4 = r4 - r6
            int r4 = (int) r4     // Catch: java.lang.Throwable -> L6e java.io.IOException -> L70
            byte[] r4 = zza(r2, r4)     // Catch: java.lang.Throwable -> L6e java.io.IOException -> L70
            com.google.android.gms.internal.zzb$zza r0 = r0.zzb(r4)     // Catch: java.lang.Throwable -> L6e java.io.IOException -> L70
            r2.close()     // Catch: java.io.IOException -> L38 java.lang.Throwable -> L68
            goto Ld
        L38:
            r0 = move-exception
            r0 = r1
            goto Ld
        L3b:
            r0 = move-exception
            r2 = r1
        L3d:
            java.lang.String r4 = "%s: %s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L6e
            r6 = 0
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> L6e
            r5[r6] = r3     // Catch: java.lang.Throwable -> L6e
            r3 = 1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6e
            r5[r3] = r0     // Catch: java.lang.Throwable -> L6e
            com.google.android.gms.internal.zzs.zzb(r4, r5)     // Catch: java.lang.Throwable -> L6e
            r8.remove(r9)     // Catch: java.lang.Throwable -> L6e
            if (r2 == 0) goto L5b
            r2.close()     // Catch: java.io.IOException -> L5d java.lang.Throwable -> L68
        L5b:
            r0 = r1
            goto Ld
        L5d:
            r0 = move-exception
            r0 = r1
            goto Ld
        L60:
            r0 = move-exception
            r2 = r1
        L62:
            if (r2 == 0) goto L67
            r2.close()     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L6b
        L67:
            throw r0     // Catch: java.lang.Throwable -> L68
        L68:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        L6b:
            r0 = move-exception
            r0 = r1
            goto Ld
        L6e:
            r0 = move-exception
            goto L62
        L70:
            r0 = move-exception
            goto L3d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.zza(java.lang.String):com.google.android.gms.internal.zzb$zza");
    }

    @Override // com.google.android.gms.internal.zzb
    public synchronized void zza() {
        BufferedInputStream bufferedInputStream;
        if (this.zzaz.exists()) {
            File[] fileArrListFiles = this.zzaz.listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    BufferedInputStream bufferedInputStream2 = null;
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        try {
                            try {
                                zza zzaVarZzf = zza.zzf(bufferedInputStream);
                                zzaVarZzf.zzaB = file.length();
                                zza(zzaVarZzf.key, zzaVarZzf);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e) {
                                }
                            } catch (Throwable th) {
                                bufferedInputStream2 = bufferedInputStream;
                                th = th;
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (IOException e2) {
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e3) {
                            if (file != null) {
                                file.delete();
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                        }
                    } catch (IOException e5) {
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        } else if (!this.zzaz.mkdirs()) {
            zzs.zzc("Unable to create cache dir %s", this.zzaz.getAbsolutePath());
        }
    }

    @Override // com.google.android.gms.internal.zzb
    public synchronized void zza(String str, zzb.zza zzaVar) {
        FileOutputStream fileOutputStream;
        zza zzaVar2;
        zzc(zzaVar.data.length);
        File fileZzf = zzf(str);
        try {
            fileOutputStream = new FileOutputStream(fileZzf);
            zzaVar2 = new zza(str, zzaVar);
        } catch (IOException e) {
            if (!fileZzf.delete()) {
                zzs.zzb("Could not clean up file %s", fileZzf.getAbsolutePath());
            }
        }
        if (!zzaVar2.zza(fileOutputStream)) {
            fileOutputStream.close();
            zzs.zzb("Failed to write header for %s", fileZzf.getAbsolutePath());
            throw new IOException();
        }
        fileOutputStream.write(zzaVar.data);
        fileOutputStream.close();
        zza(str, zzaVar2);
    }

    public File zzf(String str) {
        return new File(this.zzaz, zze(str));
    }
}
