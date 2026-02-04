package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.yandex.metrica.impl.b;
import com.yandex.metrica.impl.ob.bb;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public class bc extends SQLiteOpenHelper implements Closeable {
    private final ReentrantReadWriteLock a;
    private final Lock b;
    private final Lock c;
    private a d;
    private final be e;
    private final Object f;
    private List<ContentValues> g;
    private ContentValues h;
    private final Context i;
    private j j;
    private volatile long k;

    bc(j jVar) {
        super(jVar.m(), "db_metrica_" + jVar.l(), (SQLiteDatabase.CursorFactory) null, bb.b);
        this.a = new ReentrantReadWriteLock();
        this.b = this.a.readLock();
        this.c = this.a.writeLock();
        this.f = new Object();
        this.i = jVar.m();
        a(jVar);
        this.e = bb.a();
    }

    void a(j jVar) {
        this.j = jVar;
        this.g = new ArrayList(3);
        this.d = new a();
        this.d.setName("DatabaseWorker [" + jVar.l() + "]");
        this.d.start();
    }

    public void b(j jVar) {
        this.d.a(jVar);
    }

    public void a(long j, az azVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(j));
        contentValues.put("start_time", Long.valueOf(System.currentTimeMillis() / 1000));
        contentValues.put("server_time_offset", Long.valueOf(com.yandex.metrica.impl.utils.i.a()));
        contentValues.put("type", Integer.valueOf(azVar.a()));
        new com.yandex.metrica.impl.k(this.i).a(this.j).a(contentValues).a();
        a(contentValues);
    }

    public void a(com.yandex.metrica.impl.g gVar, ax axVar, b.a aVar) {
        ContentValues contentValues = new ContentValues(18);
        contentValues.put("number", Long.valueOf(axVar.c()));
        contentValues.put("time", Long.valueOf(axVar.d()));
        contentValues.put("session_id", Long.valueOf(axVar.a()));
        contentValues.put("session_type", Integer.valueOf(axVar.b().a()));
        new com.yandex.metrica.impl.k(this.i).a(this.j).a(contentValues).a(gVar, aVar);
        b(contentValues);
    }

    private static long a(Cursor cursor) {
        try {
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            com.yandex.metrica.impl.bk.a(cursor);
            return 0L;
        } finally {
            com.yandex.metrica.impl.bk.a(cursor);
        }
    }

    private long a(SQLiteDatabase sQLiteDatabase) {
        this.b.lock();
        try {
            long jA = a(sQLiteDatabase.rawQuery("SELECT count() FROM reports", null));
            this.b.unlock();
            return jA;
        } catch (Exception e) {
            this.b.unlock();
            return 0L;
        } catch (Throwable th) {
            this.b.unlock();
            throw th;
        }
    }

    public void a(ContentValues contentValues) {
        synchronized (this.f) {
            this.h = contentValues;
        }
        synchronized (this.d) {
            this.d.notifyAll();
        }
    }

    public void b(ContentValues contentValues) {
        synchronized (this.f) {
            this.g.add(contentValues);
        }
        synchronized (this.d) {
            this.d.notifyAll();
        }
    }

    public int a(long j) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2;
        Cursor cursorRawQuery;
        int iDelete = 0;
        this.c.lock();
        try {
            if (bb.a.booleanValue()) {
                this.b.lock();
                try {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    cursorRawQuery = readableDatabase.rawQuery(" SELECT DISTINCT id From sessions order by id asc ", new String[0]);
                    try {
                        try {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("All sessions in db: ");
                            while (cursorRawQuery.moveToNext()) {
                                stringBuffer.append(cursorRawQuery.getString(0)).append(", ");
                            }
                            Cursor cursorRawQuery2 = readableDatabase.rawQuery(" SELECT DISTINCT session_id From reports order by session_id asc ", new String[0]);
                            try {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append("All sessions in reports db: ");
                                while (cursorRawQuery2.moveToNext()) {
                                    stringBuffer2.append(cursorRawQuery2.getString(0)).append(", ");
                                }
                                this.b.unlock();
                                com.yandex.metrica.impl.bk.a(cursorRawQuery);
                                com.yandex.metrica.impl.bk.a(cursorRawQuery2);
                            } catch (Throwable th2) {
                                cursor = cursorRawQuery;
                                cursor2 = cursorRawQuery2;
                                th = th2;
                                this.b.unlock();
                                com.yandex.metrica.impl.bk.a(cursor);
                                com.yandex.metrica.impl.bk.a(cursor2);
                                throw th;
                            }
                        } catch (Exception e) {
                            this.b.unlock();
                            com.yandex.metrica.impl.bk.a(cursorRawQuery);
                            com.yandex.metrica.impl.bk.a((Cursor) null);
                            iDelete = getWritableDatabase().delete("sessions", bb.q.c, new String[]{String.valueOf(j)});
                            return iDelete;
                        }
                    } catch (Throwable th3) {
                        cursor = cursorRawQuery;
                        cursor2 = null;
                        th = th3;
                    }
                } catch (Exception e2) {
                    cursorRawQuery = null;
                } catch (Throwable th4) {
                    cursor = null;
                    th = th4;
                    cursor2 = null;
                }
            }
            iDelete = getWritableDatabase().delete("sessions", bb.q.c, new String[]{String.valueOf(j)});
        } catch (Exception e3) {
        } finally {
            this.c.unlock();
        }
        return iDelete;
    }

    public void a(long j, int i, int i2) throws Throwable {
        Cursor cursorA;
        Throwable th;
        ArrayList arrayList;
        Cursor cursor = null;
        arrayList = null;
        ArrayList arrayList2 = null;
        cursor = null;
        if (i2 <= 0) {
            return;
        }
        this.c.lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                String str = String.format(Locale.US, "%1$s = %2$s AND %3$s = %4$s AND %5$s <= (SELECT %5$s FROM %6$s WHERE %1$s = %2$s AND %3$s = %4$s ORDER BY %5$s ASC LIMIT %7$s, 1)", "session_id", Long.toString(j), "session_type", Integer.toString(i), "id", "reports", Integer.toString(i2 - 1));
                if (this.j.p().b()) {
                    cursorA = a(str);
                    if (cursorA != null) {
                        try {
                            if (cursorA.getCount() > 0) {
                                arrayList2 = new ArrayList(cursorA.getCount());
                                while (cursorA.moveToNext()) {
                                    ContentValues contentValues = new ContentValues();
                                    DatabaseUtils.cursorRowToContentValues(cursorA, contentValues);
                                    arrayList2.add(contentValues);
                                }
                            }
                        } catch (Exception e) {
                            cursor = cursorA;
                            com.yandex.metrica.impl.bk.a(cursor);
                            this.c.unlock();
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            com.yandex.metrica.impl.bk.a(cursorA);
                            this.c.unlock();
                            throw th;
                        }
                    }
                    ArrayList arrayList3 = arrayList2;
                    cursor = cursorA;
                    arrayList = arrayList3;
                } else {
                    arrayList = null;
                }
                try {
                    int iDelete = writableDatabase.delete("reports", str, null);
                    if (arrayList != null) {
                        a(arrayList, "Event removed from db");
                    }
                    this.k -= iDelete;
                    com.yandex.metrica.impl.bk.a(cursor);
                    this.c.unlock();
                } catch (Throwable th3) {
                    cursorA = cursor;
                    th = th3;
                    com.yandex.metrica.impl.bk.a(cursorA);
                    this.c.unlock();
                    throw th;
                }
            } catch (Throwable th4) {
                cursorA = null;
                th = th4;
            }
        } catch (Exception e2) {
        }
    }

    private Cursor a(String str) {
        try {
            return getReadableDatabase().query("reports", null, str, null, null, null, null, null);
        } catch (Exception e) {
            return null;
        }
    }

    public Cursor a(Map<String, String> map) {
        this.b.lock();
        try {
            return getReadableDatabase().query("sessions", null, a("id >= ?", map), a(new String[]{Long.toString(0L)}, map), null, null, "id ASC", null);
        } catch (Exception e) {
            return null;
        } finally {
            this.b.unlock();
        }
    }

    public Cursor a(long j, Map<String, String> map) {
        this.b.lock();
        try {
            return getReadableDatabase().query("sessions", null, a("id = ?", map), a(new String[]{Long.toString(j)}, map), null, null, null, null);
        } catch (Exception e) {
            return null;
        } finally {
            this.b.unlock();
        }
    }

    public Cursor b(long j, az azVar) throws SQLiteException {
        this.b.lock();
        try {
            return getReadableDatabase().query("reports", null, "session_id = ? AND session_type = ?", new String[]{Long.toString(j), Integer.toString(azVar.a())}, null, null, "number ASC", null);
        } catch (Exception e) {
            return null;
        } finally {
            this.b.unlock();
        }
    }

    private void a(List<ContentValues> list, String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                a(list.get(i2), str);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<ContentValues> a(Long l) {
        Cursor cursorRawQuery = null;
        ArrayList arrayList = new ArrayList();
        this.b.lock();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            String str = "SELECT DISTINCT report_request_parameters FROM sessions WHERE id >= 0";
            if (l != null) {
                str = String.format(Locale.US, "SELECT DISTINCT report_request_parameters FROM sessions WHERE id = %s", l);
            }
            cursorRawQuery = readableDatabase.rawQuery(str, null);
            while (cursorRawQuery.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(cursorRawQuery, contentValues);
                arrayList.add(contentValues);
            }
        } catch (Exception e) {
            arrayList = new ArrayList();
        } finally {
            com.yandex.metrica.impl.bk.a(cursorRawQuery);
            this.b.unlock();
        }
        return arrayList;
    }

    private static String a(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(str);
        for (String str2 : map.keySet()) {
            sb.append(sb.length() > 0 ? " AND " : "");
            sb.append(str2 + " = ? ");
        }
        if (com.yandex.metrica.impl.bi.a(sb.toString())) {
            return null;
        }
        return sb.toString();
    }

    private static String[] a(String[] strArr, Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(strArr));
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public long a() {
        this.b.lock();
        try {
            return this.k;
        } finally {
            this.b.unlock();
        }
    }

    private class a extends Thread {
        private final List<ContentValues> b = new ArrayList();
        private j c;

        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    synchronized (this) {
                        if (bc.this.c()) {
                            wait();
                        }
                    }
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (bc.this.f) {
                    this.b.clear();
                    this.b.addAll(bc.this.g);
                    bc.this.g.clear();
                    bc.a(bc.this, bc.this.h);
                    bc.a(bc.this, this.b);
                    bc.this.h = null;
                }
                b();
            }
        }

        synchronized void a() {
            interrupt();
            this.c = null;
        }

        synchronized void a(j jVar) {
            this.c = jVar;
        }

        synchronized void b() {
            if (this.c != null && !this.c.o()) {
                this.c.b();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable, java.io.Closeable
    public void close() {
        this.g.clear();
        this.d.a();
    }

    j b() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        boolean z;
        synchronized (this.f) {
            z = this.h == null && this.g.isEmpty();
        }
        return z;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        this.e.a(db);
        this.k = a(db);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase database) {
        this.e.b(database);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        this.e.a(database, oldVersion, newVersion);
    }

    private void a(ContentValues contentValues, String str) {
        Integer asInteger = contentValues.getAsInteger("type");
        if (com.yandex.metrica.impl.q.b(asInteger != null ? asInteger.intValue() : -1)) {
            this.j.p().a("%s: %s", str, com.yandex.metrica.impl.bi.b(contentValues.getAsString("name"), ""));
        }
    }

    static /* synthetic */ void a(bc bcVar, ContentValues contentValues) {
        if (contentValues != null) {
            bcVar.c.lock();
            try {
                bcVar.getWritableDatabase().insertOrThrow("sessions", null, contentValues);
            } catch (Exception e) {
            } finally {
                bcVar.c.unlock();
            }
        }
    }

    static /* synthetic */ void a(bc bcVar, List list) throws Throwable {
        SQLiteDatabase writableDatabase;
        Throwable th;
        SQLiteDatabase sQLiteDatabase = null;
        if (list == null || list.isEmpty()) {
            return;
        }
        bcVar.c.lock();
        try {
            writableDatabase = bcVar.getWritableDatabase();
        } catch (Exception e) {
        } catch (Throwable th2) {
            writableDatabase = null;
            th = th2;
        }
        try {
            writableDatabase.beginTransaction();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ContentValues contentValues = (ContentValues) it.next();
                writableDatabase.insertOrThrow("reports", null, contentValues);
                bcVar.a(contentValues, "Event saved to db");
            }
            writableDatabase.setTransactionSuccessful();
            bcVar.k++;
            com.yandex.metrica.impl.bk.a(writableDatabase);
            bcVar.c.unlock();
        } catch (Exception e2) {
            sQLiteDatabase = writableDatabase;
            com.yandex.metrica.impl.bk.a(sQLiteDatabase);
            bcVar.c.unlock();
        } catch (Throwable th3) {
            th = th3;
            com.yandex.metrica.impl.bk.a(writableDatabase);
            bcVar.c.unlock();
            throw th;
        }
    }
}
