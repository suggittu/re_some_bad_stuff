package com.yandex.metrica.impl;

import android.util.SparseArray;
import com.yandex.metrica.impl.af;
import com.yandex.metrica.impl.ob.bp;

/* loaded from: classes.dex */
public class f extends af {
    @Override // com.yandex.metrica.impl.af
    SparseArray<af.a> a() {
        return new SparseArray<af.a>() { // from class: com.yandex.metrica.impl.f.1
        };
    }

    @Override // com.yandex.metrica.impl.af
    protected int a(bp bpVar) {
        return bpVar.a();
    }

    @Override // com.yandex.metrica.impl.af
    protected void a(bp bpVar, int i) {
        bpVar.a(i);
    }
}
