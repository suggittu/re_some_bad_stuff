package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.tagmanager.zzp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* loaded from: classes2.dex */
class zzcn implements zzp.zzf {
    private final Context mContext;
    private final String zzbhM;
    private zzbf zzbkg;
    private final ExecutorService zzbkn = Executors.newSingleThreadExecutor();

    zzcn(Context context, String str) {
        this.mContext = context;
        this.zzbhM = str;
    }

    private zzrs.zzc zza(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            return zzaz.zzgi(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            zzbg.zzaI("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return null;
        } catch (JSONException e2) {
            zzbg.zzaK("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return null;
        }
    }

    private void zzd(zzrq.zza zzaVar) {
        if (zzaVar.zzju == null && zzaVar.zzbme == null) {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        }
    }

    private zzrs.zzc zzx(byte[] bArr) {
        try {
            zzrs.zzc zzcVarZzb = zzrs.zzb(zzaf.zzf.zzc(bArr));
            if (zzcVarZzb == null) {
                return zzcVarZzb;
            }
            zzbg.v("The container was successfully loaded from the resource (using binary file)");
            return zzcVarZzb;
        } catch (zzrs.zzg e) {
            zzbg.zzaK("The resource file is invalid. The container from the binary file is invalid");
            return null;
        } catch (zzst e2) {
            zzbg.e("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public synchronized void release() {
        this.zzbkn.shutdown();
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public void zzGl() {
        this.zzbkn.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzcn.1
            @Override // java.lang.Runnable
            public void run() throws IOException {
                zzcn.this.zzHc();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void zzHc() throws java.io.IOException {
        /*
            r3 = this;
            com.google.android.gms.tagmanager.zzbf r0 = r3.zzbkg
            if (r0 != 0) goto Lc
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Callback must be set before execute"
            r0.<init>(r1)
            throw r0
        Lc:
            com.google.android.gms.tagmanager.zzbf r0 = r3.zzbkg
            r0.zzGk()
            java.lang.String r0 = "Attempting to load resource from disk"
            com.google.android.gms.tagmanager.zzbg.v(r0)
            com.google.android.gms.tagmanager.zzcb r0 = com.google.android.gms.tagmanager.zzcb.zzGU()
            com.google.android.gms.tagmanager.zzcb$zza r0 = r0.zzGV()
            com.google.android.gms.tagmanager.zzcb$zza r1 = com.google.android.gms.tagmanager.zzcb.zza.CONTAINER
            if (r0 == r1) goto L2e
            com.google.android.gms.tagmanager.zzcb r0 = com.google.android.gms.tagmanager.zzcb.zzGU()
            com.google.android.gms.tagmanager.zzcb$zza r0 = r0.zzGV()
            com.google.android.gms.tagmanager.zzcb$zza r1 = com.google.android.gms.tagmanager.zzcb.zza.CONTAINER_DEBUG
            if (r0 != r1) goto L46
        L2e:
            java.lang.String r0 = r3.zzbhM
            com.google.android.gms.tagmanager.zzcb r1 = com.google.android.gms.tagmanager.zzcb.zzGU()
            java.lang.String r1 = r1.getContainerId()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L46
            com.google.android.gms.tagmanager.zzbf r0 = r3.zzbkg
            com.google.android.gms.tagmanager.zzbf$zza r1 = com.google.android.gms.tagmanager.zzbf.zza.NOT_AVAILABLE
            r0.zza(r1)
        L45:
            return
        L46:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L70
            java.io.File r0 = r3.zzHd()     // Catch: java.io.FileNotFoundException -> L70
            r1.<init>(r0)     // Catch: java.io.FileNotFoundException -> L70
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch: java.io.IOException -> L85 java.lang.IllegalArgumentException -> L9d java.lang.Throwable -> Lb5
            r0.<init>()     // Catch: java.io.IOException -> L85 java.lang.IllegalArgumentException -> L9d java.lang.Throwable -> Lb5
            com.google.android.gms.internal.zzrs.zzb(r1, r0)     // Catch: java.io.IOException -> L85 java.lang.IllegalArgumentException -> L9d java.lang.Throwable -> Lb5
            byte[] r0 = r0.toByteArray()     // Catch: java.io.IOException -> L85 java.lang.IllegalArgumentException -> L9d java.lang.Throwable -> Lb5
            com.google.android.gms.internal.zzrq$zza r0 = com.google.android.gms.internal.zzrq.zza.zzy(r0)     // Catch: java.io.IOException -> L85 java.lang.IllegalArgumentException -> L9d java.lang.Throwable -> Lb5
            r3.zzd(r0)     // Catch: java.io.IOException -> L85 java.lang.IllegalArgumentException -> L9d java.lang.Throwable -> Lb5
            com.google.android.gms.tagmanager.zzbf r2 = r3.zzbkg     // Catch: java.io.IOException -> L85 java.lang.IllegalArgumentException -> L9d java.lang.Throwable -> Lb5
            r2.zzI(r0)     // Catch: java.io.IOException -> L85 java.lang.IllegalArgumentException -> L9d java.lang.Throwable -> Lb5
            r1.close()     // Catch: java.io.IOException -> L7e
        L6a:
            java.lang.String r0 = "The Disk resource was successfully read."
            com.google.android.gms.tagmanager.zzbg.v(r0)
            goto L45
        L70:
            r0 = move-exception
            java.lang.String r0 = "Failed to find the resource in the disk"
            com.google.android.gms.tagmanager.zzbg.zzaI(r0)
            com.google.android.gms.tagmanager.zzbf r0 = r3.zzbkg
            com.google.android.gms.tagmanager.zzbf$zza r1 = com.google.android.gms.tagmanager.zzbf.zza.NOT_AVAILABLE
            r0.zza(r1)
            goto L45
        L7e:
            r0 = move-exception
            java.lang.String r0 = "Error closing stream for reading resource from disk"
            com.google.android.gms.tagmanager.zzbg.zzaK(r0)
            goto L6a
        L85:
            r0 = move-exception
            com.google.android.gms.tagmanager.zzbf r0 = r3.zzbkg     // Catch: java.lang.Throwable -> Lb5
            com.google.android.gms.tagmanager.zzbf$zza r2 = com.google.android.gms.tagmanager.zzbf.zza.IO_ERROR     // Catch: java.lang.Throwable -> Lb5
            r0.zza(r2)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r0 = "Failed to read the resource from disk"
            com.google.android.gms.tagmanager.zzbg.zzaK(r0)     // Catch: java.lang.Throwable -> Lb5
            r1.close()     // Catch: java.io.IOException -> L96
            goto L6a
        L96:
            r0 = move-exception
            java.lang.String r0 = "Error closing stream for reading resource from disk"
            com.google.android.gms.tagmanager.zzbg.zzaK(r0)
            goto L6a
        L9d:
            r0 = move-exception
            com.google.android.gms.tagmanager.zzbf r0 = r3.zzbkg     // Catch: java.lang.Throwable -> Lb5
            com.google.android.gms.tagmanager.zzbf$zza r2 = com.google.android.gms.tagmanager.zzbf.zza.IO_ERROR     // Catch: java.lang.Throwable -> Lb5
            r0.zza(r2)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r0 = "Failed to read the resource from disk. The resource is inconsistent"
            com.google.android.gms.tagmanager.zzbg.zzaK(r0)     // Catch: java.lang.Throwable -> Lb5
            r1.close()     // Catch: java.io.IOException -> Lae
            goto L6a
        Lae:
            r0 = move-exception
            java.lang.String r0 = "Error closing stream for reading resource from disk"
            com.google.android.gms.tagmanager.zzbg.zzaK(r0)
            goto L6a
        Lb5:
            r0 = move-exception
            r1.close()     // Catch: java.io.IOException -> Lba
        Lb9:
            throw r0
        Lba:
            r1 = move-exception
            java.lang.String r1 = "Error closing stream for reading resource from disk"
            com.google.android.gms.tagmanager.zzbg.zzaK(r1)
            goto Lb9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzcn.zzHc():void");
    }

    File zzHd() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.zzbhM);
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public void zza(zzbf zzbfVar) {
        this.zzbkg = zzbfVar;
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public void zzb(final zzrq.zza zzaVar) {
        this.zzbkn.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzcn.2
            @Override // java.lang.Runnable
            public void run() throws IOException {
                zzcn.this.zzc(zzaVar);
            }
        });
    }

    boolean zzc(zzrq.zza zzaVar) throws IOException {
        File fileZzHd = zzHd();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileZzHd);
            try {
                try {
                    fileOutputStream.write(zzsu.toByteArray(zzaVar));
                    return true;
                } catch (IOException e) {
                    zzbg.zzaK("Error writing resource to disk. Removing resource from disk.");
                    fileZzHd.delete();
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e2) {
                        zzbg.zzaK("error closing stream for writing resource to disk");
                        return false;
                    }
                }
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    zzbg.zzaK("error closing stream for writing resource to disk");
                }
            }
        } catch (FileNotFoundException e4) {
            zzbg.e("Error opening resource file for writing");
            return false;
        }
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public zzrs.zzc zzke(int i) throws Resources.NotFoundException {
        try {
            InputStream inputStreamOpenRawResource = this.mContext.getResources().openRawResource(i);
            zzbg.v("Attempting to load a container from the resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzrs.zzb(inputStreamOpenRawResource, byteArrayOutputStream);
                zzrs.zzc zzcVarZza = zza(byteArrayOutputStream);
                if (zzcVarZza != null) {
                    zzbg.v("The container was successfully loaded from the resource (using JSON file format)");
                } else {
                    zzcVarZza = zzx(byteArrayOutputStream.toByteArray());
                }
                return zzcVarZza;
            } catch (IOException e) {
                zzbg.zzaK("Error reading the default container with resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
                return null;
            }
        } catch (Resources.NotFoundException e2) {
            zzbg.zzaK("Failed to load the container. No default container resource found with the resource ID " + i);
            return null;
        }
    }
}
