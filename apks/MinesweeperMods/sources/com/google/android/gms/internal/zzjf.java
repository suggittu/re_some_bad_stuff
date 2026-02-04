package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@zzhb
/* loaded from: classes2.dex */
public class zzjf {

    public interface zza {
        Object zzf(Object obj);
    }

    public static zzjg zza(final zzjg zzjgVar, final zza zzaVar) {
        final zzjd zzjdVar = new zzjd();
        zzjgVar.zzb(new Runnable() { // from class: com.google.android.gms.internal.zzjf.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    zzjdVar.zzg(zzaVar.zzf(zzjgVar.get()));
                } catch (InterruptedException | CancellationException | ExecutionException e) {
                    zzjdVar.cancel(true);
                }
            }
        });
        return zzjdVar;
    }

    public static zzjg zzl(final List list) {
        final zzjd zzjdVar = new zzjd();
        final int size = list.size();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzjg) it.next()).zzb(new Runnable() { // from class: com.google.android.gms.internal.zzjf.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (atomicInteger.incrementAndGet() >= size) {
                        try {
                            zzjdVar.zzg(zzjf.zzm(list));
                        } catch (InterruptedException | ExecutionException e) {
                            zzin.zzd("Unable to convert list of futures to a future of list", e);
                        }
                    }
                }
            });
        }
        return zzjdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List zzm(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = ((zzjg) it.next()).get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
