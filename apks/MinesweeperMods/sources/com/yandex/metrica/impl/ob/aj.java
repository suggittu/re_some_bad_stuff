package com.yandex.metrica.impl.ob;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class aj extends u {
    public aj(i iVar) {
        super(iVar);
    }

    @Override // com.yandex.metrica.impl.ob.u
    public boolean a(com.yandex.metrica.impl.g gVar) {
        if (!TextUtils.isEmpty(gVar.j()) && TextUtils.isEmpty(a().g())) {
            a().a(gVar.j());
        }
        return false;
    }
}
