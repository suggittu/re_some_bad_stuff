package com.yandex.metrica.impl.ob;

import java.util.Random;

/* loaded from: classes.dex */
public class bw {
    private int a;
    private int b;
    private Random c;
    private int d;

    public bw(int i) {
        if (i > 0 && i <= 31) {
            this.a = i;
        } else {
            this.a = 31;
        }
        this.c = new Random();
    }

    public int a() {
        if (this.b < this.a) {
            this.b++;
            this.d = 1 << this.b;
        }
        return this.c.nextInt(this.d);
    }
}
