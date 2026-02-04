package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.SparseArray;
import com.yandex.metrica.impl.d;
import com.yandex.metrica.impl.ob.cf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class ch extends ce implements com.yandex.metrica.impl.d {
    private static final SparseArray<String> a = new SparseArray<String>() { // from class: com.yandex.metrica.impl.ob.ch.1
        {
            put(0, null);
            put(7, "1xRTT");
            put(4, "CDMA");
            put(2, "EDGE");
            put(14, "eHRPD");
            put(5, "EVDO rev.0");
            put(6, "EVDO rev.A");
            put(12, "EVDO rev.B");
            put(1, "GPRS");
            put(8, "HSDPA");
            put(10, "HSPA");
            put(15, "HSPA+");
            put(9, "HSUPA");
            put(11, "iDen");
            put(13, "LTE");
            put(3, "UMTS");
        }
    };
    private final TelephonyManager b;
    private PhoneStateListener c;
    private boolean d = false;
    private final d.a<cm> e = new d.a<>();
    private final d.a<cf[]> f = new d.a<>();
    private final Handler g;
    private final Context h;

    protected ch(Context context) {
        this.h = context;
        this.b = (TelephonyManager) context.getSystemService("phone");
        HandlerThread handlerThread = new HandlerThread("TelephonyProviderThread");
        handlerThread.start();
        this.g = new Handler(handlerThread.getLooper());
        this.g.post(new Runnable() { // from class: com.yandex.metrica.impl.ob.ch.2
            @Override // java.lang.Runnable
            public void run() {
                ch.this.c = new a(ch.this, (byte) 0);
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.cj
    public synchronized void a() {
        this.g.post(new Runnable() { // from class: com.yandex.metrica.impl.ob.ch.3
            @Override // java.lang.Runnable
            public void run() {
                if (!ch.this.d) {
                    ch.this.d = true;
                    try {
                        if (ch.this.c != null) {
                            ch.this.b.listen(ch.this.c, 256);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.cj
    public synchronized void b() {
        this.g.post(new Runnable() { // from class: com.yandex.metrica.impl.ob.ch.4
            @Override // java.lang.Runnable
            public void run() {
                if (ch.this.d) {
                    ch.this.d = false;
                    try {
                        if (ch.this.c != null) {
                            ch.this.b.listen(ch.this.c, 0);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.ce
    public synchronized void a(cn cnVar) {
        if (cnVar != null) {
            cnVar.a(c());
        }
    }

    @Override // com.yandex.metrica.impl.ob.ce
    public synchronized void a(cg cgVar) {
        if (cgVar != null) {
            cgVar.a(g());
        }
    }

    private class a extends PhoneStateListener {
        private a() {
        }

        /* synthetic */ a(ch chVar, byte b) {
            this();
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            ch.this.a(signalStrength);
        }
    }

    synchronized cm c() {
        cm cmVarB;
        if (this.e.c() || this.e.d()) {
            cm cmVar = new cm(d(), e(), f());
            if (cmVar.b().a() == null && !this.e.c()) {
                cmVar.b().a(this.e.b().b().a());
            }
            this.e.a(cmVar);
            cmVarB = cmVar;
        } else {
            cmVarB = this.e.b();
        }
        return cmVarB;
    }

    private synchronized cf[] g() {
        cf[] cfVarArrB;
        cf.b eVar;
        if (!this.f.c() && !this.f.d()) {
            cfVarArrB = this.f.b();
        } else {
            ArrayList arrayList = new ArrayList();
            if (com.yandex.metrica.impl.bk.a(17) && this.h.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                List<CellInfo> allCellInfo = this.b.getAllCellInfo();
                if (!com.yandex.metrica.impl.bk.a((Collection) allCellInfo)) {
                    for (int i = 0; i < allCellInfo.size(); i++) {
                        CellInfo cellInfo = allCellInfo.get(i);
                        if (cellInfo instanceof CellInfoGsm) {
                            eVar = new cf.c();
                        } else if (cellInfo instanceof CellInfoCdma) {
                            eVar = new cf.a();
                        } else if (cellInfo instanceof CellInfoLte) {
                            eVar = new cf.d();
                        } else {
                            eVar = (com.yandex.metrica.impl.bk.a(18) && (cellInfo instanceof CellInfoWcdma)) ? new cf.e() : null;
                        }
                        cf cfVarA = eVar == null ? null : eVar.a(cellInfo);
                        if (cfVarA != null) {
                            arrayList.add(cfVarA);
                        }
                    }
                }
            }
            if (arrayList.size() <= 0) {
                cfVarArrB = new cf[]{c().b()};
            } else {
                cfVarArrB = (cf[]) arrayList.toArray(new cf[arrayList.size()]);
            }
            this.f.a(cfVarArrB);
        }
        return cfVarArrB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(SignalStrength signalStrength) {
        int cdmaDbm;
        if (!this.e.c() && !this.e.d()) {
            cf cfVarB = this.e.b().b();
            if (!signalStrength.isGsm()) {
                cdmaDbm = signalStrength.getCdmaDbm();
                int evdoDbm = signalStrength.getEvdoDbm();
                if (-120 != evdoDbm) {
                    cdmaDbm = -120 == cdmaDbm ? evdoDbm : Math.min(cdmaDbm, evdoDbm);
                }
            } else {
                int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                if (99 == gsmSignalStrength) {
                    cdmaDbm = -1;
                } else {
                    cdmaDbm = (gsmSignalStrength * 2) - 113;
                }
            }
            cfVarB.a(Integer.valueOf(cdmaDbm));
        }
    }

    private Integer h() {
        try {
            String strSubstring = this.b.getNetworkOperator().substring(0, 3);
            if (TextUtils.isEmpty(strSubstring)) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(strSubstring));
        } catch (Exception e) {
            return null;
        }
    }

    private Integer i() {
        try {
            String strSubstring = this.b.getNetworkOperator().substring(3);
            if (TextUtils.isEmpty(strSubstring)) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(strSubstring));
        } catch (Exception e) {
            return null;
        }
    }

    private Integer j() {
        try {
            String strSubstring = this.b.getSimOperator().substring(0, 3);
            if (TextUtils.isEmpty(strSubstring)) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(strSubstring));
        } catch (Exception e) {
            return null;
        }
    }

    private Integer k() {
        try {
            String strSubstring = this.b.getSimOperator().substring(3);
            if (TextUtils.isEmpty(strSubstring)) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(strSubstring));
        } catch (Exception e) {
            return null;
        }
    }

    private Integer l() {
        try {
            int cid = ((GsmCellLocation) this.b.getCellLocation()).getCid();
            if (-1 != cid) {
                return Integer.valueOf(cid);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private Integer m() {
        try {
            int lac = ((GsmCellLocation) this.b.getCellLocation()).getLac();
            if (-1 != lac) {
                return Integer.valueOf(lac);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private String n() {
        try {
            return a.get(this.b.getNetworkType(), "unknown");
        } catch (Exception e) {
            return "unknown";
        }
    }

    private String o() {
        try {
            if (this.h.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                return null;
            }
            return this.b.getDeviceId();
        } catch (Exception e) {
            return null;
        }
    }

    private List<String> p() {
        HashSet hashSet = new HashSet();
        try {
            if (this.h.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                for (int i = 0; i < 10; i++) {
                    String deviceId = this.b.getDeviceId(i);
                    if (deviceId != null) {
                        hashSet.add(deviceId);
                    }
                }
            }
        } catch (Exception e) {
        }
        return new ArrayList(hashSet);
    }

    private boolean q() {
        if (this.h.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            try {
                return this.b.isNetworkRoaming();
            } catch (Exception e) {
            }
        }
        return false;
    }

    cf d() {
        return new cf(h(), i(), m(), l(), this.b.getNetworkOperatorName(), n(), null, true, 0, null);
    }

    List<ck> e() {
        ArrayList arrayList = new ArrayList();
        if (com.yandex.metrica.impl.bk.a(23)) {
            arrayList.addAll(s());
            if (arrayList.size() == 0) {
                arrayList.add(r());
            }
        } else {
            arrayList.add(r());
        }
        return arrayList;
    }

    List<String> f() {
        ArrayList arrayList = new ArrayList();
        if (com.yandex.metrica.impl.bk.a(23)) {
            arrayList.addAll(p());
        } else {
            arrayList.add(o());
        }
        return arrayList;
    }

    private ck r() {
        return new ck(j(), k(), q(), this.b.getSimOperatorName(), null);
    }

    private List<ck> s() {
        ArrayList arrayList = new ArrayList();
        if (this.h.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            try {
                List<SubscriptionInfo> activeSubscriptionInfoList = SubscriptionManager.from(this.h).getActiveSubscriptionInfoList();
                if (activeSubscriptionInfoList != null) {
                    Iterator<SubscriptionInfo> it = activeSubscriptionInfoList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new ck(it.next()));
                    }
                }
            } catch (Exception e) {
            }
        }
        return arrayList;
    }
}
