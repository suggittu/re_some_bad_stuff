package com.yandex.metrica.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.yandex.metrica.YandexMetrica;

/* loaded from: classes.dex */
public class j {
    private static volatile j b;
    private SQLiteOpenHelper d;
    private static final Object a = new Object();
    private static final int c = YandexMetrica.getLibraryApiLevel();

    public static j a(Context context) {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new j(context);
                }
            }
        }
        return b;
    }

    public j(Context context) {
        this.d = new a(context, "metrica_data.db", null, c);
    }

    void a(byte[] bArr) {
        SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("GeoLocation", bArr);
        writableDatabase.update("GeoLocationInfo", contentValues, null, null);
    }

    Cursor a() {
        return this.d.getReadableDatabase().rawQuery("SELECT * FROM GeoLocationInfo", null);
    }

    private static class a extends SQLiteOpenHelper {
        private final com.yandex.metrica.impl.ob.be a;

        public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
            this.a = com.yandex.metrica.impl.ob.bb.b();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase db) {
            this.a.b(db);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
            this.a.a(database, oldVersion, newVersion);
        }
    }
}
