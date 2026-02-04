package com.yandex.metrica.impl.ob;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class bh implements Executor {
    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        if (command != null) {
            command.run();
        }
    }
}
