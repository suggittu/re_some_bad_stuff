package com.yandex.metrica.impl;

import android.os.Bundle;
import com.yandex.metrica.CounterConfiguration;

/* loaded from: classes.dex */
public class bf extends aw {
    private final String f;

    public bf(String str) {
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
