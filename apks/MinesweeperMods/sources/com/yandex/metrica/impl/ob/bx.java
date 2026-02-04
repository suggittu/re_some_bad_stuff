package com.yandex.metrica.impl.ob;

/* loaded from: classes.dex */
public class bx extends by {
    private bw b;

    public bx(int i) {
        super(i);
        this.b = new bw(i);
    }

    @Override // com.yandex.metrica.impl.ob.by
    public void a() throws InterruptedException {
        try {
            Thread.sleep(this.b.a());
        } catch (InterruptedException e) {
        }
        super.a();
    }
}
