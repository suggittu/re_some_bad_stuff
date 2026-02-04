package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzna;
import java.io.DataInputStream;
import java.io.IOException;

@zzhb
/* loaded from: classes2.dex */
public final class LargeParcelTeleporter implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzl();
    final int mVersionCode;
    ParcelFileDescriptor zzIq;
    private Parcelable zzIr;
    private boolean zzIs;

    LargeParcelTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.mVersionCode = i;
        this.zzIq = parcelFileDescriptor;
        this.zzIr = null;
        this.zzIs = true;
    }

    public LargeParcelTeleporter(SafeParcelable safeParcelable) {
        this.mVersionCode = 1;
        this.zzIq = null;
        this.zzIr = safeParcelable;
        this.zzIs = false;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (this.zzIq == null) {
            Parcel parcelObtain = Parcel.obtain();
            try {
                this.zzIr.writeToParcel(parcelObtain, 0);
                byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                this.zzIq = zzf(bArrMarshall);
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        }
        zzl.zza(this, parcel, i);
    }

    public final SafeParcelable zza(Parcelable.Creator creator) throws IOException {
        if (this.zzIs) {
            if (this.zzIq == null) {
                zzin.e("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zzIq));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    dataInputStream.readFully(bArr, 0, bArr.length);
                    zzna.zzb(dataInputStream);
                    Parcel parcelObtain = Parcel.obtain();
                    try {
                        parcelObtain.unmarshall(bArr, 0, bArr.length);
                        parcelObtain.setDataPosition(0);
                        this.zzIr = (SafeParcelable) creator.createFromParcel(parcelObtain);
                        parcelObtain.recycle();
                        this.zzIs = false;
                    } catch (Throwable th) {
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (IOException e) {
                    throw new IllegalStateException("Could not read from parcel file descriptor", e);
                }
            } catch (Throwable th2) {
                zzna.zzb(dataInputStream);
                throw th2;
            }
        }
        return (SafeParcelable) this.zzIr;
    }

    protected final ParcelFileDescriptor zzf(final byte[] bArr) throws IOException {
        final ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]);
            try {
                new Thread(new Runnable() { // from class: com.google.android.gms.ads.internal.request.LargeParcelTeleporter.1
                    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
                    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public void run() throws java.lang.Throwable {
                        /*
                            r4 = this;
                            r2 = 0
                            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L32
                            java.io.OutputStream r0 = r2     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L32
                            r1.<init>(r0)     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L32
                            byte[] r0 = r3     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
                            int r0 = r0.length     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
                            r1.writeInt(r0)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
                            byte[] r0 = r3     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
                            r1.write(r0)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
                            com.google.android.gms.internal.zzna.zzb(r1)
                        L16:
                            return
                        L17:
                            r0 = move-exception
                            r1 = r2
                        L19:
                            java.lang.String r2 = "Error transporting the ad response"
                            com.google.android.gms.internal.zzin.zzb(r2, r0)     // Catch: java.lang.Throwable -> L40
                            com.google.android.gms.internal.zzih r2 = com.google.android.gms.ads.internal.zzr.zzbF()     // Catch: java.lang.Throwable -> L40
                            r3 = 1
                            r2.zzb(r0, r3)     // Catch: java.lang.Throwable -> L40
                            if (r1 != 0) goto L2e
                            java.io.OutputStream r0 = r2
                            com.google.android.gms.internal.zzna.zzb(r0)
                            goto L16
                        L2e:
                            com.google.android.gms.internal.zzna.zzb(r1)
                            goto L16
                        L32:
                            r0 = move-exception
                            r1 = r2
                        L34:
                            if (r1 != 0) goto L3c
                            java.io.OutputStream r1 = r2
                            com.google.android.gms.internal.zzna.zzb(r1)
                        L3b:
                            throw r0
                        L3c:
                            com.google.android.gms.internal.zzna.zzb(r1)
                            goto L3b
                        L40:
                            r0 = move-exception
                            goto L34
                        L42:
                            r0 = move-exception
                            goto L19
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.request.LargeParcelTeleporter.AnonymousClass1.run():void");
                    }
                }).start();
                return parcelFileDescriptorArrCreatePipe[0];
            } catch (IOException e) {
                e = e;
                zzin.zzb("Error transporting the ad response", e);
                zzr.zzbF().zzb((Throwable) e, true);
                zzna.zzb(autoCloseOutputStream);
                return null;
            }
        } catch (IOException e2) {
            e = e2;
            autoCloseOutputStream = null;
        }
    }
}
