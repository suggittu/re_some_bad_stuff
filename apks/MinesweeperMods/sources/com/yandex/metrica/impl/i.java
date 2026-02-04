package com.yandex.metrica.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.yandex.metrica.impl.ob.bz;

/* loaded from: classes.dex */
public class i extends ResultReceiver {
    private a a;

    interface a {
        void a(int i, Bundle bundle);
    }

    public i(Handler handler) {
        super(handler);
    }

    void a(a aVar) {
        this.a = aVar;
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (this.a != null) {
            this.a.a(resultCode, resultData);
        }
    }

    public static void a(ResultReceiver resultReceiver, az azVar) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putString("UuId", azVar.b());
            bundle.putString("DeviceId", azVar.c());
            bundle.putString("AdUrlGet", azVar.x());
            bundle.putString("AdUrlReport", azVar.y());
            bundle.putLong("ServerTimeOffset", com.yandex.metrica.impl.utils.i.a());
            bundle.putString("Clids", bk.b(com.yandex.metrica.impl.utils.h.a(azVar.v())));
            resultReceiver.send(1, bundle);
        }
    }

    public static void a(ResultReceiver resultReceiver, bz bzVar) {
        if (resultReceiver != null) {
            resultReceiver.send(2, bzVar.a(new Bundle()));
        }
    }
}
