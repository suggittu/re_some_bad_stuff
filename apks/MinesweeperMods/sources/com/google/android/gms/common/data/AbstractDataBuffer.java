package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class AbstractDataBuffer implements DataBuffer {
    protected final DataHolder zzahi;

    public AbstractDataBuffer(DataHolder dataHolder) {
        this.zzahi = dataHolder;
        if (this.zzahi != null) {
            this.zzahi.zzu(this);
        }
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    @Deprecated
    public final void close() {
        release();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public abstract Object get(int i);

    @Override // com.google.android.gms.common.data.DataBuffer
    public int getCount() {
        if (this.zzahi == null) {
            return 0;
        }
        return this.zzahi.getCount();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    @Deprecated
    public boolean isClosed() {
        return this.zzahi == null || this.zzahi.isClosed();
    }

    @Override // com.google.android.gms.common.data.DataBuffer, java.lang.Iterable
    public Iterator iterator() {
        return new zzb(this);
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.api.Releasable
    public void release() {
        if (this.zzahi != null) {
            this.zzahi.close();
        }
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public Iterator singleRefIterator() {
        return new zzg(this);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public Bundle zzpZ() {
        return this.zzahi.zzpZ();
    }
}
