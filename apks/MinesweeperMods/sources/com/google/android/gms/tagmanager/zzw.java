package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.tagmanager.DataLayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
class zzw implements DataLayer.zzc {
    private static final String zzbiB = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", "expires");
    private final Context mContext;
    private final Executor zzbiC;
    private zza zzbiD;
    private int zzbiE;
    private zzmq zzqW;

    class zza extends SQLiteOpenHelper {
        zza(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private boolean zza(java.lang.String r11, android.database.sqlite.SQLiteDatabase r12) throws java.lang.Throwable {
            /*
                r10 = this;
                r8 = 0
                r9 = 0
                java.lang.String r1 = "SQLITE_MASTER"
                r0 = 1
                java.lang.String[] r2 = new java.lang.String[r0]     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L41
                r0 = 0
                java.lang.String r3 = "name"
                r2[r0] = r3     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L41
                java.lang.String r3 = "name=?"
                r0 = 1
                java.lang.String[] r4 = new java.lang.String[r0]     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L41
                r0 = 0
                r4[r0] = r11     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L41
                r5 = 0
                r6 = 0
                r7 = 0
                r0 = r12
                android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L41
                boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L48 android.database.sqlite.SQLiteException -> L4f
                if (r1 == 0) goto L25
                r1.close()
            L25:
                return r0
            L26:
                r0 = move-exception
                r0 = r9
            L28:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4b
                java.lang.String r2 = "Error querying for table "
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L4b
                java.lang.StringBuilder r1 = r1.append(r11)     // Catch: java.lang.Throwable -> L4b
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L4b
                com.google.android.gms.tagmanager.zzbg.zzaK(r1)     // Catch: java.lang.Throwable -> L4b
                if (r0 == 0) goto L3f
                r0.close()
            L3f:
                r0 = r8
                goto L25
            L41:
                r0 = move-exception
            L42:
                if (r9 == 0) goto L47
                r9.close()
            L47:
                throw r0
            L48:
                r0 = move-exception
                r9 = r1
                goto L42
            L4b:
                r1 = move-exception
                r9 = r0
                r0 = r1
                goto L42
            L4f:
                r0 = move-exception
                r0 = r1
                goto L28
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzw.zza.zza(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        private void zzc(SQLiteDatabase sQLiteDatabase) {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                for (String str : cursorRawQuery.getColumnNames()) {
                    hashSet.add(str);
                }
                cursorRawQuery.close();
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                }
                if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } catch (Throwable th) {
                cursorRawQuery.close();
                throw th;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase writableDatabase = null;
            try {
                writableDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                zzw.this.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return writableDatabase == null ? super.getWritableDatabase() : writableDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            zzal.zzbo(sQLiteDatabase.getPath());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) throws SQLException {
            if (Build.VERSION.SDK_INT < 15) {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    cursorRawQuery.moveToFirst();
                } finally {
                    cursorRawQuery.close();
                }
            }
            if (zza("datalayer", sQLiteDatabase)) {
                zzc(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(zzw.zzbiB);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    class zzb {
        final byte[] zzbiK;
        final String zzvs;

        zzb(String str, byte[] bArr) {
            this.zzvs = str;
            this.zzbiK = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.zzvs + " serialized hash = " + Arrays.hashCode(this.zzbiK);
        }
    }

    public zzw(Context context) {
        this(context, zzmt.zzsc(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    zzw(Context context, zzmq zzmqVar, String str, int i, Executor executor) {
        this.mContext = context;
        this.zzqW = zzmqVar;
        this.zzbiE = i;
        this.zzbiC = executor;
        this.zzbiD = new zza(this.mContext, str);
    }

    private List zzC(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzb zzbVar = (zzb) it.next();
            arrayList.add(new DataLayer.zza(zzbVar.zzvs, zzw(zzbVar.zzbiK)));
        }
        return arrayList;
    }

    private List zzD(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DataLayer.zza zzaVar = (DataLayer.zza) it.next();
            arrayList.add(new zzb(zzaVar.zzvs, zzJ(zzaVar.zzNc)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List zzGr() {
        try {
            zzal(this.zzqW.currentTimeMillis());
            return zzC(zzGs());
        } finally {
            zzGu();
        }
    }

    private List zzGs() {
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (sQLiteDatabaseZzgb == null) {
            return arrayList;
        }
        Cursor cursorQuery = sQLiteDatabaseZzgb.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (cursorQuery.moveToNext()) {
            try {
                arrayList.add(new zzb(cursorQuery.getString(0), cursorQuery.getBlob(1)));
            } finally {
                cursorQuery.close();
            }
        }
        return arrayList;
    }

    private int zzGt() {
        Cursor cursorRawQuery = null;
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for getNumStoredEntries.");
        try {
            if (sQLiteDatabaseZzgb != null) {
                try {
                    cursorRawQuery = sQLiteDatabaseZzgb.rawQuery("SELECT COUNT(*) from datalayer", null);
                    i = cursorRawQuery.moveToFirst() ? (int) cursorRawQuery.getLong(0) : 0;
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (SQLiteException e) {
                    zzbg.zzaK("Error getting numStoredEntries");
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                }
            }
            return i;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    private void zzGu() {
        try {
            this.zzbiD.close();
        } catch (SQLiteException e) {
        }
    }

    private byte[] zzJ(Object obj) throws Throwable {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        byte[] byteArray = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (IOException e) {
            objectOutputStream = null;
        } catch (Throwable th2) {
            objectOutputStream = null;
            th = th2;
        }
        try {
            objectOutputStream.writeObject(obj);
            byteArray = byteArrayOutputStream.toByteArray();
            try {
                objectOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e2) {
            }
        } catch (IOException e3) {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e4) {
                }
            }
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e5) {
                    throw th;
                }
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return byteArray;
    }

    private void zzal(long j) {
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for deleteOlderThan.");
        if (sQLiteDatabaseZzgb == null) {
            return;
        }
        try {
            zzbg.v("Deleted " + sQLiteDatabaseZzgb.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
        } catch (SQLiteException e) {
            zzbg.zzaK("Error deleting old entries.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zzb(List list, long j) {
        try {
            long jCurrentTimeMillis = this.zzqW.currentTimeMillis();
            zzal(jCurrentTimeMillis);
            zzkf(list.size());
            zzc(list, jCurrentTimeMillis + j);
        } finally {
            zzGu();
        }
    }

    private void zzc(List list, long j) {
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for writeEntryToDatabase.");
        if (sQLiteDatabaseZzgb == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzb zzbVar = (zzb) it.next();
            ContentValues contentValues = new ContentValues();
            contentValues.put("expires", Long.valueOf(j));
            contentValues.put("key", zzbVar.zzvs);
            contentValues.put("value", zzbVar.zzbiK);
            sQLiteDatabaseZzgb.insert("datalayer", null, contentValues);
        }
    }

    private void zze(String[] strArr) {
        SQLiteDatabase sQLiteDatabaseZzgb;
        if (strArr == null || strArr.length == 0 || (sQLiteDatabaseZzgb = zzgb("Error opening database for deleteEntries.")) == null) {
            return;
        }
        try {
            sQLiteDatabaseZzgb.delete("datalayer", String.format("%s in (%s)", "ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
        } catch (SQLiteException e) {
            zzbg.zzaK("Error deleting entries " + Arrays.toString(strArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzga(String str) {
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for clearKeysWithPrefix.");
        try {
        } catch (SQLiteException e) {
            zzbg.zzaK("Error deleting entries with key prefix: " + str + " (" + e + ").");
        } finally {
            zzGu();
        }
        if (sQLiteDatabaseZzgb == null) {
            return;
        }
        zzbg.v("Cleared " + sQLiteDatabaseZzgb.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
    }

    private SQLiteDatabase zzgb(String str) {
        try {
            return this.zzbiD.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbg.zzaK(str);
            return null;
        }
    }

    private void zzkf(int i) throws Throwable {
        int iZzGt = (zzGt() - this.zzbiE) + i;
        if (iZzGt > 0) {
            List listZzkg = zzkg(iZzGt);
            zzbg.zzaJ("DataLayer store full, deleting " + listZzkg.size() + " entries to make room.");
            zze((String[]) listZzkg.toArray(new String[0]));
        }
    }

    private List zzkg(int i) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        if (i <= 0) {
            zzbg.zzaK("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for peekEntryIds.");
        try {
            if (sQLiteDatabaseZzgb == null) {
                return arrayList;
            }
            try {
                cursorQuery = sQLiteDatabaseZzgb.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", "ID"), Integer.toString(i));
                try {
                    if (cursorQuery.moveToFirst()) {
                        do {
                            arrayList.add(String.valueOf(cursorQuery.getLong(0)));
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (SQLiteException e) {
                    e = e;
                    zzbg.zzaK("Error in peekEntries fetching entryIds: " + e.getMessage());
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private Object zzw(byte[] bArr) throws Throwable {
        ObjectInputStream objectInputStream;
        Throwable th;
        Object object = null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
        } catch (IOException e) {
            objectInputStream = null;
        } catch (ClassNotFoundException e2) {
            objectInputStream = null;
        } catch (Throwable th2) {
            objectInputStream = null;
            th = th2;
        }
        try {
            object = objectInputStream.readObject();
            try {
                objectInputStream.close();
                byteArrayInputStream.close();
            } catch (IOException e3) {
            }
        } catch (IOException e4) {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e5) {
                }
            }
            byteArrayInputStream.close();
            return object;
        } catch (ClassNotFoundException e6) {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e7) {
                }
            }
            byteArrayInputStream.close();
            return object;
        } catch (Throwable th3) {
            th = th3;
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e8) {
                    throw th;
                }
            }
            byteArrayInputStream.close();
            throw th;
        }
        return object;
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void zza(final DataLayer.zzc.zza zzaVar) {
        this.zzbiC.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzw.2
            @Override // java.lang.Runnable
            public void run() {
                zzaVar.zzB(zzw.this.zzGr());
            }
        });
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void zza(List list, final long j) {
        final List listZzD = zzD(list);
        this.zzbiC.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzw.1
            @Override // java.lang.Runnable
            public void run() {
                zzw.this.zzb(listZzD, j);
            }
        });
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void zzfZ(final String str) {
        this.zzbiC.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzw.3
            @Override // java.lang.Runnable
            public void run() {
                zzw.this.zzga(str);
            }
        });
    }
}
