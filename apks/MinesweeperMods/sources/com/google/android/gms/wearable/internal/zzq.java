package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class zzq extends OutputStream {
    private volatile zzm zzbsk;
    private final OutputStream zzbsm;

    public zzq(OutputStream outputStream) {
        this.zzbsm = (OutputStream) com.google.android.gms.common.internal.zzx.zzz(outputStream);
    }

    private IOException zza(IOException iOException) {
        zzm zzmVar = this.zzbsk;
        if (zzmVar == null) {
            return iOException;
        }
        if (Log.isLoggable("ChannelOutputStream", 2)) {
            Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", iOException);
        }
        return new ChannelIOException("Channel closed unexpectedly before stream was finished", zzmVar.zzbsa, zzmVar.zzbsb);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        try {
            this.zzbsm.close();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        try {
            this.zzbsm.flush();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        try {
            this.zzbsm.write(i);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        try {
            this.zzbsm.write(bArr);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.zzbsm.write(bArr, i, i2);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    final zzu zzIJ() {
        return new zzu() { // from class: com.google.android.gms.wearable.internal.zzq.1
            @Override // com.google.android.gms.wearable.internal.zzu
            public void zzb(zzm zzmVar) {
                zzq.this.zzc(zzmVar);
            }
        };
    }

    final void zzc(zzm zzmVar) {
        this.zzbsk = zzmVar;
    }
}
