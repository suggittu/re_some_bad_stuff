package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class EventIncrementManager {
    private final AtomicReference zzaIj = new AtomicReference();

    public void flush() {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.zzaIj.get();
        if (eventIncrementCache != null) {
            eventIncrementCache.flush();
        }
    }

    public void zzp(String str, int i) {
        EventIncrementCache eventIncrementCacheZzwS = (EventIncrementCache) this.zzaIj.get();
        if (eventIncrementCacheZzwS == null) {
            eventIncrementCacheZzwS = zzwS();
            if (!this.zzaIj.compareAndSet(null, eventIncrementCacheZzwS)) {
                eventIncrementCacheZzwS = (EventIncrementCache) this.zzaIj.get();
            }
        }
        eventIncrementCacheZzwS.zzw(str, i);
    }

    protected abstract EventIncrementCache zzwS();
}
