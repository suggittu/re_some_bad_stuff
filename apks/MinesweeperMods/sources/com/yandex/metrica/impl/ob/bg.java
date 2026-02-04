package com.yandex.metrica.impl.ob;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class bg implements bf {
    private final HashMap<String, String[]> a;

    public bg(HashMap<String, String[]> map) {
        this.a = map;
    }

    @Override // com.yandex.metrica.impl.ob.bf
    public boolean a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        boolean zA = true;
        try {
            for (Map.Entry<String, String[]> entry : this.a.entrySet()) {
                try {
                    cursorQuery = sQLiteDatabase.query(entry.getKey(), null, null, null, null, null, null);
                    if (cursorQuery == null) {
                        com.yandex.metrica.impl.bk.a(cursorQuery);
                        return false;
                    }
                    try {
                        zA &= a(cursorQuery, entry.getValue());
                        com.yandex.metrica.impl.bk.a(cursorQuery);
                    } catch (Throwable th) {
                        th = th;
                        com.yandex.metrica.impl.bk.a(cursorQuery);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursorQuery = null;
                }
            }
            return zA;
        } catch (Exception e) {
            return false;
        }
    }

    boolean a(Cursor cursor, String[] strArr) {
        String[] columnNames = cursor.getColumnNames();
        Arrays.sort(columnNames);
        Arrays.sort(strArr);
        return Arrays.equals(columnNames, strArr);
    }
}
