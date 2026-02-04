package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class zzg extends zzb {
    private Object zzajy;

    public zzg(DataBuffer dataBuffer) {
        super(dataBuffer);
    }

    @Override // com.google.android.gms.common.data.zzb, java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzajc);
        }
        this.zzajc++;
        if (this.zzajc == 0) {
            this.zzajy = this.zzajb.get(0);
            if (!(this.zzajy instanceof zzc)) {
                throw new IllegalStateException("DataBuffer reference of type " + this.zzajy.getClass() + " is not movable");
            }
        } else {
            ((zzc) this.zzajy).zzbF(this.zzajc);
        }
        return this.zzajy;
    }
}
