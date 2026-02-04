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
import com.google.android.gms.tagmanager.zzcx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes2.dex */
class zzby implements zzau {
    private static final String zzQR = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time");
    private final Context mContext;
    private final zzb zzbjE;
    private volatile zzac zzbjF;
    private final zzav zzbjG;
    private final String zzbjH;
    private long zzbjI;
    private final int zzbjJ;
    private zzmq zzqW;

    class zza implements zzcx.zza {
        zza() {
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zza(zzaq zzaqVar) {
            zzby.this.zzq(zzaqVar.zzGD());
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zzb(zzaq zzaqVar) {
            zzby.this.zzq(zzaqVar.zzGD());
            zzbg.v("Permanent failure dispatching hitId: " + zzaqVar.zzGD());
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zzc(zzaq zzaqVar) {
            long jZzGE = zzaqVar.zzGE();
            if (jZzGE == 0) {
                zzby.this.zzd(zzaqVar.zzGD(), zzby.this.zzqW.currentTimeMillis());
            } else if (jZzGE + 14400000 < zzby.this.zzqW.currentTimeMillis()) {
                zzby.this.zzq(zzaqVar.zzGD());
                zzbg.v("Giving up on failed hitId: " + zzaqVar.zzGD());
            }
        }
    }

    class zzb extends SQLiteOpenHelper {
        private boolean zzbjL;
        private long zzbjM;

        zzb(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
            this.zzbjM = 0L;
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zzb.zza(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        private void zzc(SQLiteDatabase sQLiteDatabase) {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                for (String str : cursorRawQuery.getColumnNames()) {
                    hashSet.add(str);
                }
                cursorRawQuery.close();
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
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
            if (this.zzbjL && this.zzbjM + 3600000 > zzby.this.zzqW.currentTimeMillis()) {
                throw new SQLiteException("Database creation failed");
            }
            SQLiteDatabase writableDatabase = null;
            this.zzbjL = true;
            this.zzbjM = zzby.this.zzqW.currentTimeMillis();
            try {
                writableDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                zzby.this.mContext.getDatabasePath(zzby.this.zzbjH).delete();
            }
            if (writableDatabase == null) {
                writableDatabase = super.getWritableDatabase();
            }
            this.zzbjL = false;
            return writableDatabase;
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
            if (zza("gtm_hits", sQLiteDatabase)) {
                zzc(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(zzby.zzQR);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    zzby(zzav zzavVar, Context context) {
        this(zzavVar, context, "gtm_urls.db", 2000);
    }

    zzby(zzav zzavVar, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.zzbjH = str;
        this.zzbjG = zzavVar;
        this.zzqW = zzmt.zzsc();
        this.zzbjE = new zzb(this.mContext, this.zzbjH);
        this.zzbjF = new zzcx(this.mContext, new zza());
        this.zzbjI = 0L;
        this.zzbjJ = i;
    }

    private void zzGQ() throws Throwable {
        int iZzGR = (zzGR() - this.zzbjJ) + 1;
        if (iZzGR > 0) {
            List listZzkl = zzkl(iZzGR);
            zzbg.v("Store full, deleting " + listZzkl.size() + " hits to make room.");
            zzf((String[]) listZzkl.toArray(new String[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzd(long j, long j2) {
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for getNumStoredHits.");
        if (sQLiteDatabaseZzgb == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_first_send_time", Long.valueOf(j2));
        try {
            sQLiteDatabaseZzgb.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
        } catch (SQLiteException e) {
            zzbg.zzaK("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
            zzq(j);
        }
    }

    private SQLiteDatabase zzgb(String str) {
        try {
            return this.zzbjE.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbg.zzaK(str);
            return null;
        }
    }

    private void zzh(long j, String str) {
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for putHit");
        if (sQLiteDatabaseZzgb == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_time", Long.valueOf(j));
        contentValues.put("hit_url", str);
        contentValues.put("hit_first_send_time", (Integer) 0);
        try {
            sQLiteDatabaseZzgb.insert("gtm_hits", null, contentValues);
            this.zzbjG.zzax(false);
        } catch (SQLiteException e) {
            zzbg.zzaK("Error storing hit");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzq(long j) {
        zzf(new String[]{String.valueOf(j)});
    }

    @Override // com.google.android.gms.tagmanager.zzau
    public void dispatch() throws Throwable {
        zzbg.v("GTM Dispatch running...");
        if (this.zzbjF.zzGw()) {
            List listZzkm = zzkm(40);
            if (listZzkm.isEmpty()) {
                zzbg.v("...nothing to dispatch");
                this.zzbjG.zzax(true);
            } else {
                this.zzbjF.zzE(listZzkm);
                if (zzGS() > 0) {
                    zzcu.zzHo().dispatch();
                }
            }
        }
    }

    int zzGR() {
        Cursor cursorRawQuery = null;
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for getNumStoredHits.");
        try {
            if (sQLiteDatabaseZzgb != null) {
                try {
                    cursorRawQuery = sQLiteDatabaseZzgb.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                    i = cursorRawQuery.moveToFirst() ? (int) cursorRawQuery.getLong(0) : 0;
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (SQLiteException e) {
                    zzbg.zzaK("Error getting numStoredHits");
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

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    int zzGS() throws java.lang.Throwable {
        /*
            r10 = this;
            r8 = 0
            r9 = 0
            java.lang.String r0 = "Error opening database for getNumStoredHits."
            android.database.sqlite.SQLiteDatabase r0 = r10.zzgb(r0)
            if (r0 != 0) goto Lb
        La:
            return r8
        Lb:
            java.lang.String r1 = "gtm_hits"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: android.database.sqlite.SQLiteException -> L2f java.lang.Throwable -> L3d
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L2f java.lang.Throwable -> L3d
            r3 = 1
            java.lang.String r4 = "hit_first_send_time"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L2f java.lang.Throwable -> L3d
            java.lang.String r3 = "hit_first_send_time=0"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L2f java.lang.Throwable -> L3d
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L44 android.database.sqlite.SQLiteException -> L4b
            if (r1 == 0) goto L2d
            r1.close()
        L2d:
            r8 = r0
            goto La
        L2f:
            r0 = move-exception
            r0 = r9
        L31:
            java.lang.String r1 = "Error getting num untried hits"
            com.google.android.gms.tagmanager.zzbg.zzaK(r1)     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L4e
            r0.close()
            r0 = r8
            goto L2d
        L3d:
            r0 = move-exception
        L3e:
            if (r9 == 0) goto L43
            r9.close()
        L43:
            throw r0
        L44:
            r0 = move-exception
            r9 = r1
            goto L3e
        L47:
            r1 = move-exception
            r9 = r0
            r0 = r1
            goto L3e
        L4b:
            r0 = move-exception
            r0 = r1
            goto L31
        L4e:
            r0 = r8
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zzGS():int");
    }

    void zzf(String[] strArr) {
        SQLiteDatabase sQLiteDatabaseZzgb;
        if (strArr == null || strArr.length == 0 || (sQLiteDatabaseZzgb = zzgb("Error opening database for deleteHits.")) == null) {
            return;
        }
        try {
            sQLiteDatabaseZzgb.delete("gtm_hits", String.format("HIT_ID in (%s)", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
            this.zzbjG.zzax(zzGR() == 0);
        } catch (SQLiteException e) {
            zzbg.zzaK("Error deleting hits");
        }
    }

    @Override // com.google.android.gms.tagmanager.zzau
    public void zzg(long j, String str) throws Throwable {
        zzjN();
        zzGQ();
        zzh(j, str);
    }

    int zzjN() {
        long jCurrentTimeMillis = this.zzqW.currentTimeMillis();
        if (jCurrentTimeMillis <= this.zzbjI + 86400000) {
            return 0;
        }
        this.zzbjI = jCurrentTimeMillis;
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for deleteStaleHits.");
        if (sQLiteDatabaseZzgb == null) {
            return 0;
        }
        int iDelete = sQLiteDatabaseZzgb.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.zzqW.currentTimeMillis() - 2592000000L)});
        this.zzbjG.zzax(zzGR() == 0);
        return iDelete;
    }

    List zzkl(int i) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        if (i <= 0) {
            zzbg.zzaK("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase sQLiteDatabaseZzgb = zzgb("Error opening database for peekHitIds.");
        try {
            if (sQLiteDatabaseZzgb == null) {
                return arrayList;
            }
            try {
                cursorQuery = sQLiteDatabaseZzgb.query("gtm_hits", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(i));
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
                    zzbg.zzaK("Error in peekHits fetching hitIds: " + e.getMessage());
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

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List zzkm(int r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zzkm(int):java.util.List");
    }
}
