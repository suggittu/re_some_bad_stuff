package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.q;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class n extends p<u> {
    private final w a;
    private final t b;
    private final ab c;
    private final af d;
    private final ah e;
    private final ak f;
    private final aq g;
    private final ai h;
    private final ag i;
    private final aj j;
    private final ac k;
    private final ae l;
    private final x m;
    private final y n;
    private final s o;
    private final r p;
    private final v q;
    private final z r;

    public n(i iVar) {
        this.a = new w(iVar);
        this.b = new t(iVar);
        this.c = new ab(iVar);
        this.d = new af(iVar);
        this.e = new ah(iVar);
        this.f = new ak(iVar);
        this.g = new aq(iVar);
        this.h = new ai(iVar);
        this.i = new ag(iVar);
        this.j = new aj(iVar);
        this.k = new ac(iVar);
        this.l = new ae(iVar);
        this.m = new x(iVar);
        this.n = new y(iVar);
        this.o = new s(iVar);
        this.p = new r(iVar);
        this.q = new v(iVar);
        this.r = new z(iVar);
    }

    @Override // com.yandex.metrica.impl.ob.p
    m<u> a(int i) {
        LinkedList linkedList = new LinkedList();
        q.a aVarA = q.a.a(i);
        if (com.yandex.metrica.impl.q.b(aVarA)) {
            linkedList.add(this.j);
        }
        if (com.yandex.metrica.impl.q.a(aVarA)) {
            linkedList.add(this.e);
        }
        switch (aVarA) {
            case EVENT_TYPE_ACTIVATION:
                linkedList.add(this.m);
                linkedList.add(this.n);
                linkedList.add(this.q);
                linkedList.add(this.a);
                break;
            case EVENT_TYPE_ACTIVITY_START:
                linkedList.add(this.a);
                break;
            case EVENT_TYPE_REGULAR:
                linkedList.add(this.a);
                linkedList.add(this.d);
                break;
            case EVENT_TYPE_EXCEPTION_USER:
            case EVENT_TYPE_REFERRER_DEPRECATED:
            case EVENT_TYPE_STATBOX:
                linkedList.add(this.d);
                break;
            case EVENT_TYPE_UPDATE_COLLECT_INSTALLED_APPS:
                linkedList.add(this.f);
                linkedList.add(this.a);
                break;
            case EVENT_TYPE_PURGE_BUFFER:
                linkedList.add(this.c);
                break;
            case EVENT_TYPE_NATIVE_CRASH:
                linkedList.add(this.r);
                break;
            case EVENT_TYPE_EXCEPTION_UNHANDLED_DEPRECATED:
            case EVENT_TYPE_EXCEPTION_UNHANDLED:
                linkedList.add(this.c);
                linkedList.add(this.d);
                linkedList.add(this.b);
                linkedList.add(this.g);
                break;
            case EVENT_TYPE_IDENTITY:
                linkedList.add(this.f);
                linkedList.add(this.a);
                break;
            case EVENT_TYPE_SET_USER_INFO:
                linkedList.add(this.h);
                break;
            case EVENT_TYPE_REPORT_USER_INFO:
                linkedList.add(this.i);
                break;
            case EVENT_TYPE_REFERRER_RECEIVED:
                linkedList.add(this.l);
                break;
            case EVENT_TYPE_MIGRATE_EVENT_FORMAT_DEPRECATED:
                linkedList.add(this.m);
                break;
            case EVENT_TYPE_MIGRATE_TO_UUID_API_KEY_DEPRECATED:
                linkedList.add(this.n);
                break;
            case EVENT_TYPE_APP_ENVIRONMENT_UPDATED:
                linkedList.add(this.o);
                break;
            case EVENT_TYPE_APP_ENVIRONMENT_CLEARED:
                linkedList.add(this.p);
                break;
        }
        if (com.yandex.metrica.impl.q.c(aVarA)) {
            linkedList.add(this.k);
        }
        return new l(linkedList);
    }
}
