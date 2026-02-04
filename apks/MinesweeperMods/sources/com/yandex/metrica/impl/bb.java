package com.yandex.metrica.impl;

import android.content.Context;
import android.os.Bundle;
import com.yandex.metrica.CounterConfiguration;

/* loaded from: classes.dex */
public class bb extends v {
    private final String f;

    public bb(Context context, String str, String str2) {
        super(context);
        b().a(str2);
        this.f = str;
    }

    @Override // com.yandex.metrica.impl.aw
    Bundle d() {
        Bundle bundleD = super.d();
        CounterConfiguration counterConfiguration = new CounterConfiguration(b());
        counterConfiguration.b(this.f);
        bundleD.putParcelable("COUNTER_MIGRATION_CFG_OBJ", counterConfiguration);
        return bundleD;
    }
}
