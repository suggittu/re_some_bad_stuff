package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class zzb implements Iterator {
    protected final DataBuffer zzajb;
    protected int zzajc = -1;

    public zzb(DataBuffer dataBuffer) {
        this.zzajb = (DataBuffer) zzx.zzz(dataBuffer);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.zzajc < this.zzajb.getCount() + (-1);
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzajc);
        }
        DataBuffer dataBuffer = this.zzajb;
        int i = this.zzajc + 1;
        this.zzajc = i;
        return dataBuffer.get(i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
