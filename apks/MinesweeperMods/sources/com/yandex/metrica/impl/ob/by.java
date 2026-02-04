package com.yandex.metrica.impl.ob;

/* loaded from: classes.dex */
public class by {
    protected int a = 0;
    private final int b;
    private boolean c;

    public by(int i) {
        this.b = i;
    }

    public boolean b() {
        return this.c && this.a < this.b;
    }

    public void a() {
        this.a++;
        this.c = false;
    }

    public void c() {
        this.c = true;
    }
}
