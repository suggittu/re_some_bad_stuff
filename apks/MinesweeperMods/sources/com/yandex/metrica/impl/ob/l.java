package com.yandex.metrica.impl.ob;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class l<BaseHandler> extends m<BaseHandler> {
    private final List<BaseHandler> a;

    public l(List<BaseHandler> list) {
        this.a = Collections.unmodifiableList(list);
    }

    @Override // com.yandex.metrica.impl.ob.m
    public List<? extends BaseHandler> a() {
        return this.a;
    }
}
