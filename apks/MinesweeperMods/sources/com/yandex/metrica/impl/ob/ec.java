package com.yandex.metrica.impl.ob;

/* loaded from: classes.dex */
public class ec {
    private int a;
    private int b;
    private final int c;
    private final float d;

    public ec() {
        this(2500, 1, 1.0f);
    }

    public ec(int i, int i2, float f) {
        this.a = i;
        this.c = i2;
        this.d = f;
    }

    public int a() {
        return this.a;
    }

    public void a(dx dxVar) throws dx {
        this.b++;
        this.a = (int) (this.a + (this.a * this.d));
        if (!b()) {
            throw dxVar;
        }
    }

    protected boolean b() {
        return this.b <= this.c;
    }
}
