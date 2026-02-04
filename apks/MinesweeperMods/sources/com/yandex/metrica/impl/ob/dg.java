package com.yandex.metrica.impl.ob;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
class dg {
    private static dn a;
    private static de b;
    private static dy c;

    static synchronized dn a(dk dkVar) {
        if (a == null) {
            a = new dn(dkVar, b(dkVar), c(dkVar), new dj());
        }
        return a;
    }

    static synchronized de b(dk dkVar) {
        if (b == null) {
            try {
                b = new a(dkVar, (byte) 0);
            } catch (IOException e) {
                b = new cz();
            }
        }
        return b;
    }

    static synchronized dy c(dk dkVar) {
        if (c == null) {
            try {
                c = dkVar.d();
            } catch (IOException e) {
            } catch (GeneralSecurityException e2) {
            }
        }
        return c;
    }

    private static class a implements de {
        private static final String[] a = {"LNFe+yc4/NZbJVynpxAeAd+brU3EPwGbtwF6VeUjI/Y=", "PL1/TTDEe9Cm2lb2X0tixyQC7zaPREm/V0IHJscTCmw=", "+B0DgmKB5hWEuHib00m2jvCJWBlOYI0NGTMmVjaVrJA=", "dy/Myn0WRtYGKBNP8ubn9boJWJi+WWmLzp0V+W9pqfM=", "OB84k4abNNzWpMVBdhI+TSgQmCqTKdPPQrwq6j4YdMU=", "AZQG1XXPKFo8LYu/gTPgz65IOcmcwYFb3yREhyWefNI=", "iZEDYF5LpvyxpOX9+x3+qDBXhdByZOUFatBA3JgW7sY=", "IQBnNBEiFuhj+8x6X8XLgh01V9Ic5/V3IRQLNFFc7v4=", "LvRiGEjRqfzurezaWuj8Wie2gyHMrW5Q06LspMnox7A="};
        private final dh b;
        private final dh c;

        /* synthetic */ a(dk dkVar, byte b) throws IOException {
            this(dkVar);
        }

        private a(dk dkVar) throws IOException {
            ct ctVar = new ct(dkVar.b(), "lib");
            this.b = new dh(ctVar, "LIB-BLACK");
            this.c = new dh(ctVar, "LIB-TRUST", a);
        }

        @Override // com.yandex.metrica.impl.ob.de
        public dh a() {
            return this.b;
        }

        @Override // com.yandex.metrica.impl.ob.de
        public dh b() {
            throw new UnsupportedOperationException("white list isn't supported in shared container");
        }

        @Override // com.yandex.metrica.impl.ob.de
        public dh c() {
            return this.c;
        }
    }
}
