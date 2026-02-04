package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.utils.j;

/* loaded from: classes.dex */
public class ai extends u {
    public ai(i iVar) {
        super(iVar);
    }

    @Override // com.yandex.metrica.impl.ob.u
    public boolean a(com.yandex.metrica.impl.g gVar) {
        b(gVar);
        return true;
    }

    void b(com.yandex.metrica.impl.g gVar) {
        String strJ = gVar.j();
        com.yandex.metrica.d dVarA = com.yandex.metrica.impl.utils.j.a(strJ);
        String strG = a().g();
        com.yandex.metrica.d dVarA2 = com.yandex.metrica.impl.utils.j.a(strG);
        if (!dVarA.equals(dVarA2)) {
            if (TextUtils.isEmpty(dVarA.a()) && !TextUtils.isEmpty(dVarA2.a())) {
                gVar.a(strG);
                a(gVar, j.a.LOGOUT);
            } else {
                if (!TextUtils.isEmpty(dVarA.a()) && TextUtils.isEmpty(dVarA2.a())) {
                    a(gVar, j.a.LOGIN);
                } else {
                    if ((TextUtils.isEmpty(dVarA.a()) || dVarA.a().equals(dVarA2.a())) ? false : true) {
                        a(gVar, j.a.SWITCH);
                    } else {
                        a(gVar, j.a.UPDATE);
                    }
                }
            }
            a().a(strJ);
        }
        if (!a().j().B()) {
            a().c();
        }
    }

    private void a(com.yandex.metrica.impl.g gVar, j.a aVar) {
        gVar.c(com.yandex.metrica.impl.utils.j.a(aVar));
        a().d(gVar);
    }
}
