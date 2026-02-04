package com.yandex.metrica.impl;

import android.content.Context;
import android.util.SparseArray;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.impl.ob.bp;

/* loaded from: classes.dex */
public abstract class af {
    private final SparseArray<a> a = a();

    interface a {
        void a(Context context);
    }

    protected abstract int a(bp bpVar);

    abstract SparseArray<a> a();

    protected abstract void a(bp bpVar, int i);

    af() {
    }

    public void a(Context context) {
        bp bpVar = new bp(context);
        int iA = a(bpVar);
        int libraryApiLevel = YandexMetrica.getLibraryApiLevel();
        if (iA >= libraryApiLevel) {
            return;
        }
        for (int i = iA; i <= libraryApiLevel; i++) {
            a aVar = this.a.get(i);
            if (aVar != null) {
                aVar.a(context);
            }
        }
        a(bpVar, libraryApiLevel);
        bpVar.k();
    }
}
