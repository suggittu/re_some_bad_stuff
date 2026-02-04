package com.yandex.metrica;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.yandex.metrica.IMetricaService;
import com.yandex.metrica.impl.GoogleAdvertisingIdGetter;
import com.yandex.metrica.impl.bd;
import com.yandex.metrica.impl.bk;
import com.yandex.metrica.impl.ob.bi;
import com.yandex.metrica.impl.ob.bj;
import com.yandex.metrica.impl.ob.br;
import com.yandex.metrica.impl.ob.cl;
import com.yandex.metrica.impl.ob.g;
import com.yandex.metrica.impl.ob.h;
import com.yandex.metrica.impl.ob.i;
import com.yandex.metrica.impl.q;
import com.yandex.metrica.impl.utils.f;
import com.yandex.metrica.impl.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class MetricaService extends Service {
    private static final Executor a = new bj();
    private static final ExecutorService b = Executors.newSingleThreadExecutor();
    private static final Map<String, i> c = new HashMap();
    private static final g d = new g();
    private final IMetricaService.Stub e = new IMetricaService.Stub() { // from class: com.yandex.metrica.MetricaService.1
        @Override // com.yandex.metrica.IMetricaService
        public void reportEvent(String event, int type, String value, Bundle data) throws RemoteException {
            data.setClassLoader(CounterConfiguration.class.getClassLoader());
            a(new com.yandex.metrica.impl.g(value, event, type), data);
        }

        @Override // com.yandex.metrica.IMetricaService
        public void reportData(Bundle data) throws RemoteException {
            data.setClassLoader(CounterConfiguration.class.getClassLoader());
            a(com.yandex.metrica.impl.g.b(data), data);
        }

        private void a(com.yandex.metrica.impl.g gVar, Bundle bundle) {
            if (!gVar.m()) {
                MetricaService.b.execute(MetricaService.this.new a(MetricaService.this, gVar, bundle, getCallingUid()));
            }
        }
    };

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f.a(getApplicationContext());
        new bd().a(this);
        com.yandex.metrica.impl.utils.g.a().a(getApplicationContext());
        GoogleAdvertisingIdGetter.a().a(this);
        br brVar = new br(this, getPackageName());
        bi.a().a(this, brVar.b((String) null), brVar.h(null));
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int startId) {
        a(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        a(intent);
        return 2;
    }

    private void a(Intent intent) {
        if (intent != null) {
            intent.getExtras().setClassLoader(CounterConfiguration.class.getClassLoader());
            if (!b(intent)) {
                com.yandex.metrica.impl.g gVarB = com.yandex.metrica.impl.g.b(intent.getExtras());
                if (gVarB.m()) {
                    gVarB.a(intent.getIntExtra("EXTRA_KEY_KEY_START_TYPE", q.a.EVENT_TYPE_UNDEFINED.a())).b(intent.getStringExtra("EXTRA_KEY_KEY_START_EVENT")).c("");
                }
                if (!(gVarB.l() | gVarB.m())) {
                    Bundle bundleExtra = intent.getBundleExtra("EXTRA_KEY_LIB_CFG");
                    if (bundleExtra == null) {
                        bundleExtra = intent.getExtras();
                    }
                    CounterConfiguration counterConfigurationA = bk.a(bundleExtra);
                    if (!(counterConfigurationA == null)) {
                        b(counterConfigurationA);
                        z.a((Context) this).a(gVarB.d());
                        try {
                            i iVar = new i(this, a, h.a(this, counterConfigurationA, null, intent.getData().getEncodedAuthority()), counterConfigurationA, d);
                            iVar.a(gVarB);
                            iVar.d();
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
        stopSelf();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        z.a((Context) this).b(this);
        cl.a(this).b();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (b(intent)) {
            return false;
        }
        String encodedAuthority = intent.getData().getEncodedAuthority();
        synchronized (c) {
            for (Map.Entry entry : new HashMap(c).entrySet()) {
                String str = (String) entry.getKey();
                i iVar = (i) entry.getValue();
                if (str == null || iVar == null || str.startsWith(encodedAuthority)) {
                    c.remove(str);
                    if (iVar != null) {
                        iVar.c();
                    }
                }
            }
        }
        return true;
    }

    private final class a implements Runnable {
        private final int b;
        private final com.yandex.metrica.impl.g c;
        private final Bundle d;
        private final Context e;

        a(Context context, com.yandex.metrica.impl.g gVar, Bundle bundle, int i) {
            this.e = context.getApplicationContext();
            this.b = i;
            this.c = gVar;
            this.d = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            CounterConfiguration counterConfigurationB;
            CounterConfiguration counterConfigurationA = bk.a(this.d);
            if (!MetricaService.a(counterConfigurationA)) {
                MetricaService.this.b(counterConfigurationA);
                MetricaService.a(MetricaService.this, MetricaService.this.getPackageName().equals(counterConfigurationA.f()), counterConfigurationA.n());
                synchronized (MetricaService.c) {
                    h hVarA = MetricaService.a(MetricaService.this, this.c, counterConfigurationA, this.b);
                    String strJ = counterConfigurationA.j();
                    if (this.d.containsKey("COUNTER_MIGRATION_CFG_OBJ") && (counterConfigurationB = bk.b(this.d)) != null) {
                        h hVarA2 = h.a(MetricaService.this.getApplicationContext(), counterConfigurationB, Integer.valueOf(this.b), null);
                        if (!MetricaService.c.containsKey(hVarA2.toString())) {
                            CounterConfiguration counterConfiguration = new CounterConfiguration(counterConfigurationB);
                            counterConfiguration.a(strJ);
                            MetricaService.a(MetricaService.this, hVarA2, counterConfiguration, (com.yandex.metrica.impl.g) null).f();
                        }
                    }
                    i iVarA = MetricaService.a(MetricaService.this, hVarA, counterConfigurationA, this.c);
                    if (!MetricaService.a(iVarA)) {
                        z.a(this.e).a(this.c.d());
                        if (!q.a(this.c.c())) {
                            iVarA.a(counterConfigurationA);
                        }
                        if (!MetricaService.a(iVarA, this.c)) {
                            iVarA.a(this.c);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CounterConfiguration counterConfiguration) {
        if (com.yandex.metrica.impl.bi.a(counterConfiguration.h())) {
            String strC = bk.c(this, counterConfiguration.f());
            if (!com.yandex.metrica.impl.bi.a(strC)) {
                counterConfiguration.e(strC);
            }
        }
    }

    private static boolean b(Intent intent) {
        return intent == null || intent.getData() == null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        z.a((Context) this).a((Object) this);
        cl.a(this).a();
        return this.e;
    }

    static /* synthetic */ i a(MetricaService metricaService, h hVar, CounterConfiguration counterConfiguration, com.yandex.metrica.impl.g gVar) {
        if (hVar != null) {
            i iVar = c.get(hVar.toString());
            if (iVar == null) {
                i iVar2 = new i(metricaService.getApplicationContext(), a, hVar, counterConfiguration, d);
                if (gVar == null || !q.a(gVar)) {
                    c.put(hVar.toString(), iVar2);
                    return iVar2;
                }
                return iVar2;
            }
            iVar.b(counterConfiguration);
            return iVar;
        }
        return null;
    }

    static /* synthetic */ boolean a(CounterConfiguration counterConfiguration) {
        return counterConfiguration == null;
    }

    static /* synthetic */ void a(MetricaService metricaService, boolean z, boolean z2) {
        z.a((Context) metricaService).a(metricaService, z, z2);
    }

    static /* synthetic */ h a(MetricaService metricaService, com.yandex.metrica.impl.g gVar, CounterConfiguration counterConfiguration, int i) {
        boolean z;
        if (q.a(gVar)) {
            String strK = gVar.k();
            Iterator<ApplicationInfo> it = metricaService.getApplicationContext().getPackageManager().getInstalledApplications(0).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (it.next().packageName.equals(strK)) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return h.a(strK);
            }
            return null;
        }
        return h.a(metricaService.getApplicationContext(), counterConfiguration, Integer.valueOf(i), null);
    }

    static /* synthetic */ boolean a(i iVar) {
        return iVar == null || iVar.o();
    }

    static /* synthetic */ boolean a(i iVar, com.yandex.metrica.impl.g gVar) {
        if (q.a.EVENT_TYPE_STARTUP.a() == gVar.c()) {
            iVar.e();
            return true;
        }
        if (q.a.EVENT_TYPE_REFERRER_RECEIVED.a() == gVar.c()) {
            iVar.b(gVar);
            return true;
        }
        return false;
    }
}
