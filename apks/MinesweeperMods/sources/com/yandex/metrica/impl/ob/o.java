package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.q;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class o extends p<u> {
    private final aq a;
    private final ap b;
    private final ao c;
    private final ad d;
    private final al e;
    private final am f;
    private final aa g;
    private LinkedList<u> h;

    public o(i iVar) {
        this.a = new aq(iVar);
        this.b = new ap(iVar);
        this.c = new ao(iVar);
        this.d = new ad(iVar);
        this.e = new al(iVar);
        this.f = new am(iVar);
        this.g = new aa(iVar);
    }

    @Override // com.yandex.metrica.impl.ob.p
    m<u> a(int i) {
        this.h = new LinkedList<>();
        switch (q.a.a(i)) {
            case EVENT_TYPE_ACTIVITY_START_DEPRECATED:
                this.h.add(this.f);
                break;
            case EVENT_TYPE_ACTIVITY_START:
                this.h.add(this.f);
                this.h.add(this.d);
                break;
            case EVENT_TYPE_SESSION_START_MANUALLY:
                this.h.add(this.a);
                this.h.add(this.b);
                this.h.add(this.c);
                break;
            case EVENT_TYPE_INIT:
            case EVENT_TYPE_INIT_BACKGROUND:
                this.h.add(this.e);
                this.h.add(this.d);
                break;
            case EVENT_TYPE_ACTIVITY_END:
                this.h.add(this.g);
                break;
            case EVENT_TYPE_EXCEPTION_UNHANDLED_DEPRECATED:
            case EVENT_TYPE_EXCEPTION_UNHANDLED:
            case EVENT_TYPE_REGULAR:
            case EVENT_TYPE_EXCEPTION_USER:
            case EVENT_TYPE_REFERRER_DEPRECATED:
            case EVENT_TYPE_NATIVE_CRASH:
            case EVENT_TYPE_STARTUP:
            case EVENT_TYPE_STATBOX:
                this.h.add(this.e);
                break;
        }
        return new l(this.h);
    }
}
