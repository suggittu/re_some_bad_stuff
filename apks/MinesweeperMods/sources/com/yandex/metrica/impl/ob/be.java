package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import com.yandex.metrica.impl.ob.bb;

/* loaded from: classes.dex */
public class be {
    private final bb.h a;
    private final bb.h b;
    private final SparseArray<bb.h> c;
    private final bf d;

    public be(bb.h hVar, bb.h hVar2, SparseArray<bb.h> sparseArray, bf bfVar) {
        this.a = hVar;
        this.b = hVar2;
        this.c = sparseArray;
        this.d = bfVar;
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        try {
            if (this.d != null && !this.d.a(sQLiteDatabase)) {
                a(sQLiteDatabase, this.a, this.b);
            }
        } catch (Exception e) {
        }
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
        a(this.a, sQLiteDatabase);
    }

    void a(bb.h hVar, SQLiteDatabase sQLiteDatabase) {
        try {
            hVar.a(sQLiteDatabase);
        } catch (Exception e) {
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        boolean z;
        if (i2 > i) {
            for (int i3 = i + 1; i3 <= i2; i3++) {
                try {
                    bb.h hVar = this.c.get(i3);
                    if (hVar != null) {
                        hVar.a(sQLiteDatabase);
                    }
                } catch (Exception e) {
                    z = true;
                }
            }
            z = false;
        } else {
            z = true;
        }
        if (z | (this.d.a(sQLiteDatabase) ? false : true)) {
            a(sQLiteDatabase, this.a, this.b);
        }
    }

    void a(SQLiteDatabase sQLiteDatabase, bb.h hVar, bb.h hVar2) {
        try {
            hVar2.a(sQLiteDatabase);
        } catch (Exception e) {
        }
        a(hVar, sQLiteDatabase);
    }
}
