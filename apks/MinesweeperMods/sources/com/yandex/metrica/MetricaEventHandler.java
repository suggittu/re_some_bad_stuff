package com.yandex.metrica;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.yandex.metrica.impl.bi;
import com.yandex.metrica.impl.bo;
import com.yandex.metrica.impl.utils.f;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class MetricaEventHandler extends BroadcastReceiver {
    public static Set<BroadcastReceiver> a = new HashSet();

    static void a(BroadcastReceiver... broadcastReceiverArr) {
        for (BroadcastReceiver broadcastReceiver : broadcastReceiverArr) {
            a.add(broadcastReceiver);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("referrer");
            if (!bi.a(stringExtra)) {
                bo.a(context);
                bo.a().d(stringExtra);
            }
        }
        for (BroadcastReceiver broadcastReceiver : a) {
            f.e().a(String.format("Sending referrer to %s", broadcastReceiver.getClass().getName()), new Object[0]);
            broadcastReceiver.onReceive(context, intent);
        }
    }
}
