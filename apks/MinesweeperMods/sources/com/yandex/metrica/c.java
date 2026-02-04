package com.yandex.metrica;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public interface c {

    public static final class b extends com.yandex.metrica.impl.ob.d {
        public long b;
        public int c;
        public long d;

        public b() {
            d();
        }

        public b d() {
            this.b = 0L;
            this.c = 0;
            this.d = 0L;
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.d
        public void a(com.yandex.metrica.impl.ob.b bVar) throws IOException {
            bVar.a(1, this.b);
            bVar.c(2, this.c);
            if (this.d != 0) {
                bVar.b(3, this.d);
            }
            super.a(bVar);
        }

        @Override // com.yandex.metrica.impl.ob.d
        protected int c() {
            int iC = super.c() + com.yandex.metrica.impl.ob.b.c(1, this.b) + com.yandex.metrica.impl.ob.b.f(2, this.c);
            if (this.d != 0) {
                return iC + com.yandex.metrica.impl.ob.b.d(3, this.d);
            }
            return iC;
        }
    }

    public static final class a extends com.yandex.metrica.impl.ob.d {
        public b b;
        public g[] c;
        public C0271c[] d;
        public f[] e;
        public String[] f;
        public h[] g;

        public static final class d extends com.yandex.metrica.impl.ob.d {
            public double b;
            public double c;
            public long d;
            public int e;
            public int f;
            public int g;
            public int h;

            public d() {
                d();
            }

            public d d() {
                this.b = 0.0d;
                this.c = 0.0d;
                this.d = 0L;
                this.e = 0;
                this.f = 0;
                this.g = 0;
                this.h = 0;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.d
            public void a(com.yandex.metrica.impl.ob.b bVar) throws IOException {
                bVar.a(1, this.b);
                bVar.a(2, this.c);
                if (this.d != 0) {
                    bVar.a(3, this.d);
                }
                if (this.e != 0) {
                    bVar.b(4, this.e);
                }
                if (this.f != 0) {
                    bVar.b(5, this.f);
                }
                if (this.g != 0) {
                    bVar.b(6, this.g);
                }
                if (this.h != 0) {
                    bVar.a(7, this.h);
                }
                super.a(bVar);
            }

            @Override // com.yandex.metrica.impl.ob.d
            protected int c() {
                int iC = super.c() + com.yandex.metrica.impl.ob.b.d(1) + com.yandex.metrica.impl.ob.b.d(2);
                if (this.d != 0) {
                    iC += com.yandex.metrica.impl.ob.b.c(3, this.d);
                }
                if (this.e != 0) {
                    iC += com.yandex.metrica.impl.ob.b.e(4, this.e);
                }
                if (this.f != 0) {
                    iC += com.yandex.metrica.impl.ob.b.e(5, this.f);
                }
                if (this.g != 0) {
                    iC += com.yandex.metrica.impl.ob.b.e(6, this.g);
                }
                if (this.h != 0) {
                    return iC + com.yandex.metrica.impl.ob.b.d(7, this.h);
                }
                return iC;
            }
        }

        public static final class i extends com.yandex.metrica.impl.ob.d {
            private static volatile i[] f;
            public String b;
            public int c;
            public String d;
            public boolean e;

            public static i[] d() {
                if (f == null) {
                    synchronized (com.yandex.metrica.impl.ob.c.a) {
                        if (f == null) {
                            f = new i[0];
                        }
                    }
                }
                return f;
            }

            public i() {
                e();
            }

            public i e() {
                this.b = "";
                this.c = 0;
                this.d = "";
                this.e = false;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.d
            public void a(com.yandex.metrica.impl.ob.b bVar) throws IOException {
                bVar.a(1, this.b);
                if (this.c != 0) {
                    bVar.c(2, this.c);
                }
                if (!this.d.equals("")) {
                    bVar.a(3, this.d);
                }
                if (this.e) {
                    bVar.a(4, this.e);
                }
                super.a(bVar);
            }

            @Override // com.yandex.metrica.impl.ob.d
            protected int c() {
                int iC = super.c() + com.yandex.metrica.impl.ob.b.b(1, this.b);
                if (this.c != 0) {
                    iC += com.yandex.metrica.impl.ob.b.f(2, this.c);
                }
                if (!this.d.equals("")) {
                    iC += com.yandex.metrica.impl.ob.b.b(3, this.d);
                }
                if (this.e) {
                    return iC + com.yandex.metrica.impl.ob.b.e(4);
                }
                return iC;
            }
        }

        public static final class b extends com.yandex.metrica.impl.ob.d {
            private static volatile b[] k;
            public int b;
            public int c;
            public int d;
            public int e;
            public int f;
            public String g;
            public boolean h;
            public int i;
            public int j;

            public static b[] d() {
                if (k == null) {
                    synchronized (com.yandex.metrica.impl.ob.c.a) {
                        if (k == null) {
                            k = new b[0];
                        }
                    }
                }
                return k;
            }

            public b() {
                e();
            }

            public b e() {
                this.b = -1;
                this.c = 0;
                this.d = -1;
                this.e = -1;
                this.f = -1;
                this.g = "";
                this.h = false;
                this.i = 0;
                this.j = -1;
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.d
            public void a(com.yandex.metrica.impl.ob.b bVar) throws IOException {
                if (this.b != -1) {
                    bVar.b(1, this.b);
                }
                if (this.c != 0) {
                    bVar.c(2, this.c);
                }
                if (this.d != -1) {
                    bVar.b(3, this.d);
                }
                if (this.e != -1) {
                    bVar.b(4, this.e);
                }
                if (this.f != -1) {
                    bVar.b(5, this.f);
                }
                if (!this.g.equals("")) {
                    bVar.a(6, this.g);
                }
                if (this.h) {
                    bVar.a(7, this.h);
                }
                if (this.i != 0) {
                    bVar.a(8, this.i);
                }
                if (this.j != -1) {
                    bVar.b(9, this.j);
                }
                super.a(bVar);
            }

            @Override // com.yandex.metrica.impl.ob.d
            protected int c() {
                int iC = super.c();
                if (this.b != -1) {
                    iC += com.yandex.metrica.impl.ob.b.e(1, this.b);
                }
                if (this.c != 0) {
                    iC += com.yandex.metrica.impl.ob.b.f(2, this.c);
                }
                if (this.d != -1) {
                    iC += com.yandex.metrica.impl.ob.b.e(3, this.d);
                }
                if (this.e != -1) {
                    iC += com.yandex.metrica.impl.ob.b.e(4, this.e);
                }
                if (this.f != -1) {
                    iC += com.yandex.metrica.impl.ob.b.e(5, this.f);
                }
                if (!this.g.equals("")) {
                    iC += com.yandex.metrica.impl.ob.b.b(6, this.g);
                }
                if (this.h) {
                    iC += com.yandex.metrica.impl.ob.b.e(7);
                }
                if (this.i != 0) {
                    iC += com.yandex.metrica.impl.ob.b.d(8, this.i);
                }
                if (this.j != -1) {
                    return iC + com.yandex.metrica.impl.ob.b.e(9, this.j);
                }
                return iC;
            }
        }

        public static final class e extends com.yandex.metrica.impl.ob.d {
            public b[] b;
            public i[] c;
            public int d;
            public String e;

            public e() {
                d();
            }

            public e d() {
                this.b = b.d();
                this.c = i.d();
                this.d = 2;
                this.e = "";
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.d
            public void a(com.yandex.metrica.impl.ob.b bVar) throws IOException {
                if (this.b != null && this.b.length > 0) {
                    for (int i = 0; i < this.b.length; i++) {
                        b bVar2 = this.b[i];
                        if (bVar2 != null) {
                            bVar.a(1, bVar2);
                        }
                    }
                }
                if (this.c != null && this.c.length > 0) {
                    for (int i2 = 0; i2 < this.c.length; i2++) {
                        i iVar = this.c[i2];
                        if (iVar != null) {
                            bVar.a(2, iVar);
                        }
                    }
                }
                if (this.d != 2) {
                    bVar.a(3, this.d);
                }
                if (!this.e.equals("")) {
                    bVar.a(4, this.e);
                }
                super.a(bVar);
            }

            @Override // com.yandex.metrica.impl.ob.d
            protected int c() {
                int iC = super.c();
                if (this.b != null && this.b.length > 0) {
                    int iB = iC;
                    for (int i = 0; i < this.b.length; i++) {
                        b bVar = this.b[i];
                        if (bVar != null) {
                            iB += com.yandex.metrica.impl.ob.b.b(1, bVar);
                        }
                    }
                    iC = iB;
                }
                if (this.c != null && this.c.length > 0) {
                    for (int i2 = 0; i2 < this.c.length; i2++) {
                        i iVar = this.c[i2];
                        if (iVar != null) {
                            iC += com.yandex.metrica.impl.ob.b.b(2, iVar);
                        }
                    }
                }
                if (this.d != 2) {
                    iC += com.yandex.metrica.impl.ob.b.d(3, this.d);
                }
                if (!this.e.equals("")) {
                    return iC + com.yandex.metrica.impl.ob.b.b(4, this.e);
                }
                return iC;
            }
        }

        /* renamed from: com.yandex.metrica.c$a$a, reason: collision with other inner class name */
        public static final class C0270a extends com.yandex.metrica.impl.ob.d {
            public String b;
            public String c;
            public String d;

            public C0270a() {
                d();
            }

            public C0270a d() {
                this.b = "";
                this.c = "";
                this.d = "";
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.d
            public void a(com.yandex.metrica.impl.ob.b bVar) throws IOException {
                bVar.a(1, this.b);
                if (!this.c.equals("")) {
                    bVar.a(2, this.c);
                }
                if (!this.d.equals("")) {
                    bVar.a(3, this.d);
                }
                super.a(bVar);
            }

            @Override // com.yandex.metrica.impl.ob.d
            protected int c() {
                int iC = super.c() + com.yandex.metrica.impl.ob.b.b(1, this.b);
                if (!this.c.equals("")) {
                    iC += com.yandex.metrica.impl.ob.b.b(2, this.c);
                }
                if (!this.d.equals("")) {
                    return iC + com.yandex.metrica.impl.ob.b.b(3, this.d);
                }
                return iC;
            }
        }

        public static final class g extends com.yandex.metrica.impl.ob.d {
            private static volatile g[] e;
            public long b;
            public b c;
            public C0272a[] d;

            public static final class b extends com.yandex.metrica.impl.ob.d {
                public b b;
                public String c;
                public int d;

                public b() {
                    d();
                }

                public b d() {
                    this.b = null;
                    this.c = "";
                    this.d = 0;
                    this.a = -1;
                    return this;
                }

                @Override // com.yandex.metrica.impl.ob.d
                public void a(com.yandex.metrica.impl.ob.b bVar) throws IOException {
                    if (this.b != null) {
                        bVar.a(1, this.b);
                    }
                    bVar.a(2, this.c);
                    if (this.d != 0) {
                        bVar.a(5, this.d);
                    }
                    super.a(bVar);
                }

                @Override // com.yandex.metrica.impl.ob.d
                protected int c() {
                    int iC = super.c();
                    if (this.b != null) {
                        iC += com.yandex.metrica.impl.ob.b.b(1, this.b);
                    }
                    int iB = iC + com.yandex.metrica.impl.ob.b.b(2, this.c);
                    if (this.d != 0) {
                        return iB + com.yandex.metrica.impl.ob.b.d(5, this.d);
                    }
                    return iB;
                }
            }

            /* renamed from: com.yandex.metrica.c$a$g$a, reason: collision with other inner class name */
            public static final class C0272a extends com.yandex.metrica.impl.ob.d {
                private static volatile C0272a[] m;
                public long b;
                public long c;
                public int d;
                public String e;
                public byte[] f;
                public d g;
                public e h;
                public String i;
                public C0270a j;
                public boolean k;
                public int l;

                public static C0272a[] d() {
                    if (m == null) {
                        synchronized (com.yandex.metrica.impl.ob.c.a) {
                            if (m == null) {
                                m = new C0272a[0];
                            }
                        }
                    }
                    return m;
                }

                public C0272a() {
                    e();
                }

                public C0272a e() {
                    this.b = 0L;
                    this.c = 0L;
                    this.d = 1;
                    this.e = "";
                    this.f = com.yandex.metrica.impl.ob.f.b;
                    this.g = null;
                    this.h = null;
                    this.i = "";
                    this.j = null;
                    this.k = false;
                    this.l = 0;
                    this.a = -1;
                    return this;
                }

                @Override // com.yandex.metrica.impl.ob.d
                public void a(com.yandex.metrica.impl.ob.b bVar) throws IOException {
                    bVar.a(1, this.b);
                    bVar.a(2, this.c);
                    bVar.a(3, this.d);
                    if (!this.e.equals("")) {
                        bVar.a(4, this.e);
                    }
                    if (!Arrays.equals(this.f, com.yandex.metrica.impl.ob.f.b)) {
                        bVar.a(5, this.f);
                    }
                    if (this.g != null) {
                        bVar.a(6, this.g);
                    }
                    if (this.h != null) {
                        bVar.a(7, this.h);
                    }
                    if (!this.i.equals("")) {
                        bVar.a(8, this.i);
                    }
                    if (this.j != null) {
                        bVar.a(9, this.j);
                    }
                    if (this.k) {
                        bVar.a(10, this.k);
                    }
                    if (this.l != 0) {
                        bVar.a(12, this.l);
                    }
                    super.a(bVar);
                }

                @Override // com.yandex.metrica.impl.ob.d
                protected int c() {
                    int iC = super.c() + com.yandex.metrica.impl.ob.b.c(1, this.b) + com.yandex.metrica.impl.ob.b.c(2, this.c) + com.yandex.metrica.impl.ob.b.d(3, this.d);
                    if (!this.e.equals("")) {
                        iC += com.yandex.metrica.impl.ob.b.b(4, this.e);
                    }
                    if (!Arrays.equals(this.f, com.yandex.metrica.impl.ob.f.b)) {
                        iC += com.yandex.metrica.impl.ob.b.b(5, this.f);
                    }
                    if (this.g != null) {
                        iC += com.yandex.metrica.impl.ob.b.b(6, this.g);
                    }
                    if (this.h != null) {
                        iC += com.yandex.metrica.impl.ob.b.b(7, this.h);
                    }
                    if (!this.i.equals("")) {
                        iC += com.yandex.metrica.impl.ob.b.b(8, this.i);
                    }
                    if (this.j != null) {
                        iC += com.yandex.metrica.impl.ob.b.b(9, this.j);
                    }
                    if (this.k) {
                        iC += com.yandex.metrica.impl.ob.b.e(10);
                    }
                    if (this.l != 0) {
                        return iC + com.yandex.metrica.impl.ob.b.d(12, this.l);
                    }
                    return iC;
                }
            }

            public static g[] d() {
                if (e == null) {
                    synchronized (com.yandex.metrica.impl.ob.c.a) {
                        if (e == null) {
                            e = new g[0];
                        }
                    }
                }
                return e;
            }

            public g() {
                e();
            }

            public g e() {
                this.b = 0L;
                this.c = null;
                this.d = C0272a.d();
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.d
            public void a(com.yandex.metrica.impl.ob.b bVar) throws IOException {
                bVar.a(1, this.b);
                if (this.c != null) {
                    bVar.a(2, this.c);
                }
                if (this.d != null && this.d.length > 0) {
                    for (int i = 0; i < this.d.length; i++) {
                        C0272a c0272a = this.d[i];
                        if (c0272a != null) {
                            bVar.a(3, c0272a);
                        }
                    }
                }
                super.a(bVar);
            }

            @Override // com.yandex.metrica.impl.ob.d
            protected int c() {
                int iC = super.c() + com.yandex.metrica.impl.ob.b.c(1, this.b);
                if (this.c != null) {
                    iC += com.yandex.metrica.impl.ob.b.b(2, this.c);
                }
                if (this.d != null && this.d.length > 0) {
                    int iB = iC;
                    for (int i = 0; i < this.d.length; i++) {
                        C0272a c0272a = this.d[i];
                        if (c0272a != null) {
                            iB += com.yandex.metrica.impl.ob.b.b(3, c0272a);
                        }
                    }
                    return iB;
                }
                return iC;
            }
        }

        /* renamed from: com.yandex.metrica.c$a$c, reason: collision with other inner class name */
        public static final class C0271c extends com.yandex.metrica.impl.ob.d {
            private static volatile C0271c[] d;
            public String b;
            public String c;

            public static C0271c[] d() {
                if (d == null) {
                    synchronized (com.yandex.metrica.impl.ob.c.a) {
                        if (d == null) {
                            d = new C0271c[0];
                        }
                    }
                }
                return d;
            }

            public C0271c() {
                e();
            }

            public C0271c e() {
                this.b = "";
                this.c = "";
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.d
            public void a(com.yandex.metrica.impl.ob.b bVar) throws IOException {
                bVar.a(1, this.b);
                bVar.a(2, this.c);
                super.a(bVar);
            }

            @Override // com.yandex.metrica.impl.ob.d
            protected int c() {
                return super.c() + com.yandex.metrica.impl.ob.b.b(1, this.b) + com.yandex.metrica.impl.ob.b.b(2, this.c);
            }
        }

        public static final class f extends com.yandex.metrica.impl.ob.d {
            private static volatile f[] d;
            public String b;
            public String c;

            public static f[] d() {
                if (d == null) {
                    synchronized (com.yandex.metrica.impl.ob.c.a) {
                        if (d == null) {
                            d = new f[0];
                        }
                    }
                }
                return d;
            }

            public f() {
                e();
            }

            public f e() {
                this.b = "";
                this.c = "";
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.d
            public void a(com.yandex.metrica.impl.ob.b bVar) throws IOException {
                bVar.a(1, this.b);
                bVar.a(2, this.c);
                super.a(bVar);
            }

            @Override // com.yandex.metrica.impl.ob.d
            protected int c() {
                return super.c() + com.yandex.metrica.impl.ob.b.b(1, this.b) + com.yandex.metrica.impl.ob.b.b(2, this.c);
            }
        }

        public static final class h extends com.yandex.metrica.impl.ob.d {
            private static volatile h[] g;
            public int b;
            public int c;
            public String d;
            public boolean e;
            public String f;

            public static h[] d() {
                if (g == null) {
                    synchronized (com.yandex.metrica.impl.ob.c.a) {
                        if (g == null) {
                            g = new h[0];
                        }
                    }
                }
                return g;
            }

            public h() {
                e();
            }

            public h e() {
                this.b = 0;
                this.c = 0;
                this.d = "";
                this.e = false;
                this.f = "";
                this.a = -1;
                return this;
            }

            @Override // com.yandex.metrica.impl.ob.d
            public void a(com.yandex.metrica.impl.ob.b bVar) throws IOException {
                if (this.b != 0) {
                    bVar.b(1, this.b);
                }
                if (this.c != 0) {
                    bVar.b(2, this.c);
                }
                if (!this.d.equals("")) {
                    bVar.a(3, this.d);
                }
                if (this.e) {
                    bVar.a(4, this.e);
                }
                if (!this.f.equals("")) {
                    bVar.a(5, this.f);
                }
                super.a(bVar);
            }

            @Override // com.yandex.metrica.impl.ob.d
            protected int c() {
                int iC = super.c();
                if (this.b != 0) {
                    iC += com.yandex.metrica.impl.ob.b.e(1, this.b);
                }
                if (this.c != 0) {
                    iC += com.yandex.metrica.impl.ob.b.e(2, this.c);
                }
                if (!this.d.equals("")) {
                    iC += com.yandex.metrica.impl.ob.b.b(3, this.d);
                }
                if (this.e) {
                    iC += com.yandex.metrica.impl.ob.b.e(4);
                }
                if (!this.f.equals("")) {
                    return iC + com.yandex.metrica.impl.ob.b.b(5, this.f);
                }
                return iC;
            }
        }

        public a() {
            d();
        }

        public a d() {
            this.b = null;
            this.c = g.d();
            this.d = C0271c.d();
            this.e = f.d();
            this.f = com.yandex.metrica.impl.ob.f.a;
            this.g = h.d();
            this.a = -1;
            return this;
        }

        @Override // com.yandex.metrica.impl.ob.d
        public void a(com.yandex.metrica.impl.ob.b bVar) throws IOException {
            if (this.b != null) {
                bVar.a(1, this.b);
            }
            if (this.c != null && this.c.length > 0) {
                for (int i2 = 0; i2 < this.c.length; i2++) {
                    g gVar = this.c[i2];
                    if (gVar != null) {
                        bVar.a(3, gVar);
                    }
                }
            }
            if (this.d != null && this.d.length > 0) {
                for (int i3 = 0; i3 < this.d.length; i3++) {
                    C0271c c0271c = this.d[i3];
                    if (c0271c != null) {
                        bVar.a(7, c0271c);
                    }
                }
            }
            if (this.e != null && this.e.length > 0) {
                for (int i4 = 0; i4 < this.e.length; i4++) {
                    f fVar = this.e[i4];
                    if (fVar != null) {
                        bVar.a(8, fVar);
                    }
                }
            }
            if (this.f != null && this.f.length > 0) {
                for (int i5 = 0; i5 < this.f.length; i5++) {
                    String str = this.f[i5];
                    if (str != null) {
                        bVar.a(9, str);
                    }
                }
            }
            if (this.g != null && this.g.length > 0) {
                for (int i6 = 0; i6 < this.g.length; i6++) {
                    h hVar = this.g[i6];
                    if (hVar != null) {
                        bVar.a(10, hVar);
                    }
                }
            }
            super.a(bVar);
        }

        @Override // com.yandex.metrica.impl.ob.d
        protected int c() {
            int iC = super.c();
            if (this.b != null) {
                iC += com.yandex.metrica.impl.ob.b.b(1, this.b);
            }
            if (this.c != null && this.c.length > 0) {
                int iB = iC;
                for (int i2 = 0; i2 < this.c.length; i2++) {
                    g gVar = this.c[i2];
                    if (gVar != null) {
                        iB += com.yandex.metrica.impl.ob.b.b(3, gVar);
                    }
                }
                iC = iB;
            }
            if (this.d != null && this.d.length > 0) {
                int iB2 = iC;
                for (int i3 = 0; i3 < this.d.length; i3++) {
                    C0271c c0271c = this.d[i3];
                    if (c0271c != null) {
                        iB2 += com.yandex.metrica.impl.ob.b.b(7, c0271c);
                    }
                }
                iC = iB2;
            }
            if (this.e != null && this.e.length > 0) {
                int iB3 = iC;
                for (int i4 = 0; i4 < this.e.length; i4++) {
                    f fVar = this.e[i4];
                    if (fVar != null) {
                        iB3 += com.yandex.metrica.impl.ob.b.b(8, fVar);
                    }
                }
                iC = iB3;
            }
            if (this.f != null && this.f.length > 0) {
                int iB4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < this.f.length; i6++) {
                    String str = this.f[i6];
                    if (str != null) {
                        i5++;
                        iB4 += com.yandex.metrica.impl.ob.b.b(str);
                    }
                }
                iC = iC + iB4 + (i5 * 1);
            }
            if (this.g != null && this.g.length > 0) {
                for (int i7 = 0; i7 < this.g.length; i7++) {
                    h hVar = this.g[i7];
                    if (hVar != null) {
                        iC += com.yandex.metrica.impl.ob.b.b(10, hVar);
                    }
                }
            }
            return iC;
        }
    }
}
