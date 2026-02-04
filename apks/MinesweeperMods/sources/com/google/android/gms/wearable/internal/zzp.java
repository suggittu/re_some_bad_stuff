package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class zzp extends InputStream {
    private final InputStream zzbsj;
    private volatile zzm zzbsk;

    public zzp(InputStream inputStream) {
        this.zzbsj = (InputStream) com.google.android.gms.common.internal.zzx.zzz(inputStream);
    }

    private int zzlK(int i) throws ChannelIOException {
        zzm zzmVar;
        if (i != -1 || (zzmVar = this.zzbsk) == null) {
            return i;
        }
        throw new ChannelIOException("Channel closed unexpectedly before stream was finished", zzmVar.zzbsa, zzmVar.zzbsb);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.zzbsj.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zzbsj.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.zzbsj.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.zzbsj.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() {
        return zzlK(this.zzbsj.read());
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        return zzlK(this.zzbsj.read(bArr));
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        return zzlK(this.zzbsj.read(bArr, i, i2));
    }

    @Override // java.io.InputStream
    public final void reset() throws IOException {
        this.zzbsj.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        return this.zzbsj.skip(j);
    }

    final zzu zzIJ() {
        return new zzu() { // from class: com.google.android.gms.wearable.internal.zzp.1
            @Override // com.google.android.gms.wearable.internal.zzu
            public void zzb(zzm zzmVar) {
                zzp.this.zza(zzmVar);
            }
        };
    }

    final void zza(zzm zzmVar) {
        this.zzbsk = (zzm) com.google.android.gms.common.internal.zzx.zzz(zzmVar);
    }
}
