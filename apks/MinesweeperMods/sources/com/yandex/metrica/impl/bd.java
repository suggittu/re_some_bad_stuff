package com.yandex.metrica.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.yandex.metrica.impl.af;
import com.yandex.metrica.impl.b;
import com.yandex.metrica.impl.o;
import com.yandex.metrica.impl.ob.bp;
import com.yandex.metrica.impl.ob.br;
import com.yandex.metrica.impl.ob.bv;

/* loaded from: classes.dex */
public class bd extends af {
    @Override // com.yandex.metrica.impl.af
    SparseArray<af.a> a() {
        return new SparseArray<af.a>() { // from class: com.yandex.metrica.impl.bd.1
            {
                byte b2 = 0;
                put(29, new a(b2));
                put(39, new b(b2));
            }
        };
    }

    @Override // com.yandex.metrica.impl.af
    protected int a(bp bpVar) {
        return bpVar.b();
    }

    @Override // com.yandex.metrica.impl.af
    protected void a(bp bpVar, int i) {
        bpVar.b(i);
    }

    private static class a implements af.a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.af.a
        public void a(Context context) {
            String strA = new br(context).a((String) null);
            if (!TextUtils.isEmpty(strA) && TextUtils.isEmpty(o.b.a.b(context, strA))) {
                br.b(context);
            }
        }
    }

    private static class b implements af.a {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.af.a
        public void a(Context context) {
            com.yandex.metrica.impl.ob.bo boVar = new com.yandex.metrica.impl.ob.bo(context, context.getPackageName());
            SharedPreferences sharedPreferencesA = bv.a(context, "_boundentrypreferences");
            String string = sharedPreferencesA.getString(com.yandex.metrica.impl.ob.bo.c.a(), null);
            long j = sharedPreferencesA.getLong(com.yandex.metrica.impl.ob.bo.d.a(), -1L);
            if (string != null && j != -1) {
                boVar.a(new b.a(string, j)).k();
                sharedPreferencesA.edit().remove(com.yandex.metrica.impl.ob.bo.c.a()).remove(com.yandex.metrica.impl.ob.bo.d.a()).commit();
            }
        }
    }
}
