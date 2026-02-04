package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.internal.zzpz;
import com.google.android.gms.internal.zzqb;
import com.google.android.gms.internal.zzsn;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
class zze extends zzz {
    private static final Map zzaVB;
    private final zzc zzaVC;
    private final zzaf zzaVD;

    public class zza {
        long zzaVE;
        long zzaVF;
        long zzaVG;
    }

    interface zzb {
        boolean zza(long j, zzqb.zzb zzbVar);

        void zzc(zzqb.zze zzeVar);
    }

    class zzc extends SQLiteOpenHelper {
        zzc(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @WorkerThread
        private void zza(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map map) throws SQLException {
            if (!zza(sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                zza(sQLiteDatabase, str, str3, map);
            } catch (SQLiteException e) {
                zze.this.zzAo().zzCE().zzj("Failed to verify columns on table that was just created", str);
                throw e;
            }
        }

        @WorkerThread
        private void zza(SQLiteDatabase sQLiteDatabase, String str, String str2, Map map) throws SQLException {
            Set setZzb = zzb(sQLiteDatabase, str);
            for (String str3 : str2.split(",")) {
                if (!setZzb.remove(str3)) {
                    throw new SQLiteException("Table " + str + " is missing required column: " + str3);
                }
            }
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    if (!setZzb.remove(entry.getKey())) {
                        sQLiteDatabase.execSQL((String) entry.getValue());
                    }
                }
            }
            if (!setZzb.isEmpty()) {
                throw new SQLiteException("Table " + str + " table has extra columns");
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
        @android.support.annotation.WorkerThread
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private boolean zza(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) throws java.lang.Throwable {
            /*
                r10 = this;
                r8 = 0
                r9 = 0
                java.lang.String r1 = "SQLITE_MASTER"
                r0 = 1
                java.lang.String[] r2 = new java.lang.String[r0]     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L3e
                r0 = 0
                java.lang.String r3 = "name"
                r2[r0] = r3     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L3e
                java.lang.String r3 = "name=?"
                r0 = 1
                java.lang.String[] r4 = new java.lang.String[r0]     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L3e
                r0 = 0
                r4[r0] = r12     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L3e
                r5 = 0
                r6 = 0
                r7 = 0
                r0 = r11
                android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L26 java.lang.Throwable -> L3e
                boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
                if (r1 == 0) goto L25
                r1.close()
            L25:
                return r0
            L26:
                r0 = move-exception
                r1 = r9
            L28:
                com.google.android.gms.measurement.internal.zze r2 = com.google.android.gms.measurement.internal.zze.this     // Catch: java.lang.Throwable -> L45
                com.google.android.gms.measurement.internal.zzp r2 = r2.zzAo()     // Catch: java.lang.Throwable -> L45
                com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzCF()     // Catch: java.lang.Throwable -> L45
                java.lang.String r3 = "Error querying for table"
                r2.zze(r3, r12, r0)     // Catch: java.lang.Throwable -> L45
                if (r1 == 0) goto L3c
                r1.close()
            L3c:
                r0 = r8
                goto L25
            L3e:
                r0 = move-exception
            L3f:
                if (r9 == 0) goto L44
                r9.close()
            L44:
                throw r0
            L45:
                r0 = move-exception
                r9 = r1
                goto L3f
            L48:
                r0 = move-exception
                goto L28
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzc.zza(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
        }

        @WorkerThread
        private Set zzb(SQLiteDatabase sQLiteDatabase, String str) {
            HashSet hashSet = new HashSet();
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
            try {
                Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
                return hashSet;
            } finally {
                cursorRawQuery.close();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        @WorkerThread
        public SQLiteDatabase getWritableDatabase() {
            if (!zze.this.zzaVD.zzv(zze.this.zzCp().zzBN())) {
                throw new SQLiteException("Database open failed");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e) {
                zze.this.zzaVD.start();
                zze.this.zzAo().zzCE().zzfg("Opening the database failed, dropping and recreating it");
                zze.this.getContext().getDatabasePath(zze.this.zzjQ()).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    zze.this.zzaVD.clear();
                    return writableDatabase;
                } catch (SQLiteException e2) {
                    zze.this.zzAo().zzCE().zzj("Failed to open freshly created database", e2);
                    throw e2;
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        @WorkerThread
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (Build.VERSION.SDK_INT >= 9) {
                File file = new File(sQLiteDatabase.getPath());
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        @WorkerThread
        public void onOpen(SQLiteDatabase sQLiteDatabase) throws SQLException {
            if (Build.VERSION.SDK_INT < 15) {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    cursorRawQuery.moveToFirst();
                } finally {
                    cursorRawQuery.close();
                }
            }
            zza(sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
            zza(sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", null);
            zza(sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zze.zzaVB);
            zza(sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", null);
            zza(sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
            zza(sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", null);
            zza(sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
            zza(sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
            zza(sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        @WorkerThread
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        ArrayMap arrayMap = new ArrayMap(13);
        zzaVB = arrayMap;
        arrayMap.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        zzaVB.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        zzaVB.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        zzaVB.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        zzaVB.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        zzaVB.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        zzaVB.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        zzaVB.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        zzaVB.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        zzaVB.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        zzaVB.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        zzaVB.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        zzaVB.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
    }

    zze(zzw zzwVar) {
        super(zzwVar);
        this.zzaVD = new zzaf(zzjl());
        this.zzaVC = new zzc(getContext(), zzjQ());
    }

    private boolean zzCw() {
        return getContext().getDatabasePath(zzjQ()).exists();
    }

    @WorkerThread
    @TargetApi(11)
    static int zza(Cursor cursor, int i) {
        if (Build.VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        if (window.isNull(position, i)) {
            return 0;
        }
        if (window.isLong(position, i)) {
            return 1;
        }
        if (window.isFloat(position, i)) {
            return 2;
        }
        if (window.isString(position, i)) {
            return 3;
        }
        return window.isBlob(position, i) ? 4 : -1;
    }

    @WorkerThread
    private long zza(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = getWritableDatabase().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    j = cursorRawQuery.getLong(0);
                } else if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzAo().zzCE().zze("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    @WorkerThread
    private void zza(String str, zzpz.zza zzaVar) {
        boolean z = false;
        zzjv();
        zzjk();
        com.google.android.gms.common.internal.zzx.zzcM(str);
        com.google.android.gms.common.internal.zzx.zzz(zzaVar);
        com.google.android.gms.common.internal.zzx.zzz(zzaVar.zzaZt);
        com.google.android.gms.common.internal.zzx.zzz(zzaVar.zzaZs);
        if (zzaVar.zzaZr == null) {
            zzAo().zzCF().zzfg("Audience with no ID");
            return;
        }
        int iIntValue = zzaVar.zzaZr.intValue();
        for (zzpz.zzb zzbVar : zzaVar.zzaZt) {
            if (zzbVar.zzaZv == null) {
                zzAo().zzCF().zze("Event filter with no ID. Audience definition ignored. appId, audienceId", str, zzaVar.zzaZr);
                return;
            }
        }
        for (zzpz.zze zzeVar : zzaVar.zzaZs) {
            if (zzeVar.zzaZv == null) {
                zzAo().zzCF().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", str, zzaVar.zzaZr);
                return;
            }
        }
        boolean z2 = true;
        zzpz.zzb[] zzbVarArr = zzaVar.zzaZt;
        int length = zzbVarArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (!zza(str, iIntValue, zzbVarArr[i])) {
                z2 = false;
                break;
            }
            i++;
        }
        if (z2) {
            for (zzpz.zze zzeVar2 : zzaVar.zzaZs) {
                if (!zza(str, iIntValue, zzeVar2)) {
                    break;
                }
            }
            z = z2;
        } else {
            z = z2;
        }
        if (z) {
            return;
        }
        zzB(str, iIntValue);
    }

    @WorkerThread
    private boolean zza(String str, int i, zzpz.zzb zzbVar) {
        zzjv();
        zzjk();
        com.google.android.gms.common.internal.zzx.zzcM(str);
        com.google.android.gms.common.internal.zzx.zzz(zzbVar);
        if (TextUtils.isEmpty(zzbVar.zzaZw)) {
            zzAo().zzCF().zze("Event filter had no event name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(zzbVar.zzaZv));
            return false;
        }
        try {
            byte[] bArr = new byte[zzbVar.getSerializedSize()];
            zzsn zzsnVarZzE = zzsn.zzE(bArr);
            zzbVar.writeTo(zzsnVarZzE);
            zzsnVarZzE.zzJo();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzbVar.zzaZv);
            contentValues.put("event_name", zzbVar.zzaZw);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    zzAo().zzCE().zzfg("Failed to insert event filter (got -1)");
                }
                return true;
            } catch (SQLiteException e) {
                zzAo().zzCE().zzj("Error storing event filter", e);
                return false;
            }
        } catch (IOException e2) {
            zzAo().zzCE().zzj("Configuration loss. Failed to serialize event filter", e2);
            return false;
        }
    }

    @WorkerThread
    private boolean zza(String str, int i, zzpz.zze zzeVar) {
        zzjv();
        zzjk();
        com.google.android.gms.common.internal.zzx.zzcM(str);
        com.google.android.gms.common.internal.zzx.zzz(zzeVar);
        if (TextUtils.isEmpty(zzeVar.zzaZL)) {
            zzAo().zzCF().zze("Property filter had no property name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(zzeVar.zzaZv));
            return false;
        }
        try {
            byte[] bArr = new byte[zzeVar.getSerializedSize()];
            zzsn zzsnVarZzE = zzsn.zzE(bArr);
            zzeVar.writeTo(zzsnVarZzE);
            zzsnVarZzE.zzJo();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzeVar.zzaZv);
            contentValues.put("property_name", zzeVar.zzaZL);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzAo().zzCE().zzfg("Failed to insert property filter (got -1)");
                return false;
            } catch (SQLiteException e) {
                zzAo().zzCE().zzj("Error storing property filter", e);
                return false;
            }
        } catch (IOException e2) {
            zzAo().zzCE().zzj("Configuration loss. Failed to serialize property filter", e2);
            return false;
        }
    }

    @WorkerThread
    private long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = getWritableDatabase().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzAo().zzCE().zze("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String zzjQ() {
        if (zzCp().zzkr() && !zzCp().zzks()) {
            zzAo().zzCG().zzfg("Using secondary database");
            return zzCp().zzkS();
        }
        return zzCp().zzkR();
    }

    @WorkerThread
    public void beginTransaction() {
        zzjv();
        getWritableDatabase().beginTransaction();
    }

    @WorkerThread
    public void endTransaction() {
        zzjv();
        getWritableDatabase().endTransaction();
    }

    @WorkerThread
    SQLiteDatabase getWritableDatabase() {
        zzjk();
        try {
            return this.zzaVC.getWritableDatabase();
        } catch (SQLiteException e) {
            zzAo().zzCF().zzj("Error opening database", e);
            throw e;
        }
    }

    @WorkerThread
    public void setTransactionSuccessful() {
        zzjv();
        getWritableDatabase().setTransactionSuccessful();
    }

    @WorkerThread
    public void zzA(String str, int i) throws SQLException {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        zzjk();
        zzjv();
        try {
            getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(i)});
        } catch (SQLiteException e) {
            zzAo().zzCE().zze("Error pruning currencies", str, e);
        }
    }

    void zzB(String str, int i) {
        zzjv();
        zzjk();
        com.google.android.gms.common.internal.zzx.zzcM(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
        writableDatabase.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    com.google.android.gms.internal.zzqb.zzf zzC(java.lang.String r10, int r11) {
        /*
            r9 = this;
            r8 = 0
            r9.zzjv()
            r9.zzjk()
            com.google.android.gms.common.internal.zzx.zzcM(r10)
            android.database.sqlite.SQLiteDatabase r0 = r9.getWritableDatabase()
            java.lang.String r1 = "audience_filter_values"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L80
            r3 = 0
            java.lang.String r4 = "current_results"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L80
            java.lang.String r3 = "app_id=? AND audience_id=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L80
            r5 = 0
            r4[r5] = r10     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L80
            r5 = 1
            java.lang.String r6 = java.lang.String.valueOf(r11)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L80
            r4[r5] = r6     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L80
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L80
            boolean r0 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            if (r0 != 0) goto L3b
            if (r1 == 0) goto L39
            r1.close()
        L39:
            r0 = r8
        L3a:
            return r0
        L3b:
            r0 = 0
            byte[] r0 = r1.getBlob(r0)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            com.google.android.gms.internal.zzsm r2 = com.google.android.gms.internal.zzsm.zzD(r0)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            com.google.android.gms.internal.zzqb$zzf r0 = new com.google.android.gms.internal.zzqb$zzf     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            r0.<init>()     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            r0.mergeFrom(r2)     // Catch: java.io.IOException -> L52 android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
        L4c:
            if (r1 == 0) goto L3a
            r1.close()
            goto L3a
        L52:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzp r3 = r9.zzAo()     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzCE()     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            java.lang.String r4 = "Failed to merge filter results"
            r3.zze(r4, r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            goto L4c
        L61:
            r0 = move-exception
        L62:
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzAo()     // Catch: java.lang.Throwable -> L7e
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzCE()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = "Database error querying filter results"
            r2.zzj(r3, r0)     // Catch: java.lang.Throwable -> L7e
            if (r1 == 0) goto L74
            r1.close()
        L74:
            r0 = r8
            goto L3a
        L76:
            r0 = move-exception
            r1 = r8
        L78:
            if (r1 == 0) goto L7d
            r1.close()
        L7d:
            throw r0
        L7e:
            r0 = move-exception
            goto L78
        L80:
            r0 = move-exception
            r1 = r8
            goto L62
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzC(java.lang.String, int):com.google.android.gms.internal.zzqb$zzf");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    @android.support.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String zzCq() {
        /*
            r5 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.getWritableDatabase()
            java.lang.String r2 = "select app_id from queue where app_id not in (select app_id from apps where measurement_enabled=0) order by rowid limit 1;"
            r3 = 0
            android.database.Cursor r2 = r1.rawQuery(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L23 java.lang.Throwable -> L38
            boolean r1 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L41 android.database.sqlite.SQLiteException -> L43
            if (r1 == 0) goto L1d
            r1 = 0
            java.lang.String r0 = r2.getString(r1)     // Catch: java.lang.Throwable -> L41 android.database.sqlite.SQLiteException -> L43
            if (r2 == 0) goto L1c
            r2.close()
        L1c:
            return r0
        L1d:
            if (r2 == 0) goto L1c
            r2.close()
            goto L1c
        L23:
            r1 = move-exception
            r2 = r0
        L25:
            com.google.android.gms.measurement.internal.zzp r3 = r5.zzAo()     // Catch: java.lang.Throwable -> L41
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzCE()     // Catch: java.lang.Throwable -> L41
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzj(r4, r1)     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L1c
            r2.close()
            goto L1c
        L38:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L3b:
            if (r2 == 0) goto L40
            r2.close()
        L40:
            throw r0
        L41:
            r0 = move-exception
            goto L3b
        L43:
            r1 = move-exception
            goto L25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzCq():java.lang.String");
    }

    @WorkerThread
    void zzCr() {
        zzjk();
        zzjv();
        if (zzCw()) {
            long j = zzCo().zzaXm.get();
            long jElapsedRealtime = zzjl().elapsedRealtime();
            if (Math.abs(jElapsedRealtime - j) > zzCp().zzBR()) {
                zzCo().zzaXm.set(jElapsedRealtime);
                zzCs();
            }
        }
    }

    @WorkerThread
    void zzCs() {
        int iDelete;
        zzjk();
        zzjv();
        if (zzCw() && (iDelete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzjl().currentTimeMillis()), String.valueOf(zzCp().zzBQ())})) > 0) {
            zzAo().zzCK().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
        }
    }

    @WorkerThread
    public long zzCt() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    @WorkerThread
    public long zzCu() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public boolean zzCv() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
    @android.support.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.measurement.internal.zzi zzI(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r10 = 0
            com.google.android.gms.common.internal.zzx.zzcM(r13)
            com.google.android.gms.common.internal.zzx.zzcM(r14)
            r12.zzjk()
            r12.zzjv()
            android.database.sqlite.SQLiteDatabase r0 = r12.getWritableDatabase()     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            java.lang.String r1 = "events"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            r3 = 0
            java.lang.String r4 = "lifetime_count"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            r3 = 1
            java.lang.String r4 = "current_bundle_count"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            r3 = 2
            java.lang.String r4 = "last_fire_timestamp"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            java.lang.String r3 = "app_id=? and name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            r5 = 0
            r4[r5] = r13     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            r5 = 1
            r4[r5] = r14     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L73 java.lang.Throwable -> L89
            boolean r0 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            if (r0 != 0) goto L44
            if (r11 == 0) goto L42
            r11.close()
        L42:
            r1 = r10
        L43:
            return r1
        L44:
            r0 = 0
            long r4 = r11.getLong(r0)     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            r0 = 1
            long r6 = r11.getLong(r0)     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            r0 = 2
            long r8 = r11.getLong(r0)     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            com.google.android.gms.measurement.internal.zzi r1 = new com.google.android.gms.measurement.internal.zzi     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            r2 = r13
            r3 = r14
            r1.<init>(r2, r3, r4, r6, r8)     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            boolean r0 = r11.moveToNext()     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            if (r0 == 0) goto L6d
            com.google.android.gms.measurement.internal.zzp r0 = r12.zzAo()     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzCE()     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
            java.lang.String r2 = "Got multiple records for event aggregates, expected one"
            r0.zzfg(r2)     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L96
        L6d:
            if (r11 == 0) goto L43
            r11.close()
            goto L43
        L73:
            r0 = move-exception
            r1 = r10
        L75:
            com.google.android.gms.measurement.internal.zzp r2 = r12.zzAo()     // Catch: java.lang.Throwable -> L93
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzCE()     // Catch: java.lang.Throwable -> L93
            java.lang.String r3 = "Error querying events"
            r2.zzd(r3, r13, r14, r0)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L87
            r1.close()
        L87:
            r1 = r10
            goto L43
        L89:
            r0 = move-exception
        L8a:
            if (r10 == 0) goto L8f
            r10.close()
        L8f:
            throw r0
        L90:
            r0 = move-exception
            r10 = r11
            goto L8a
        L93:
            r0 = move-exception
            r10 = r1
            goto L8a
        L96:
            r0 = move-exception
            r1 = r11
            goto L75
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzI(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzi");
    }

    @WorkerThread
    public void zzJ(String str, String str2) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        com.google.android.gms.common.internal.zzx.zzcM(str2);
        zzjk();
        zzjv();
        try {
            zzAo().zzCK().zzj("Deleted user attribute rows:", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzAo().zzCE().zzd("Error deleting user attribute", str, str2, e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    @android.support.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.measurement.internal.zzai zzK(java.lang.String r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            r9 = this;
            r8 = 0
            com.google.android.gms.common.internal.zzx.zzcM(r10)
            com.google.android.gms.common.internal.zzx.zzcM(r11)
            r9.zzjk()
            r9.zzjv()
            android.database.sqlite.SQLiteDatabase r0 = r9.getWritableDatabase()     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L7f
            java.lang.String r1 = "user_attributes"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L7f
            r3 = 0
            java.lang.String r4 = "set_timestamp"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L7f
            r3 = 1
            java.lang.String r4 = "value"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L7f
            java.lang.String r3 = "app_id=? and name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L7f
            r5 = 0
            r4[r5] = r10     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L7f
            r5 = 1
            r4[r5] = r11     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L7f
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L7f
            boolean r0 = r7.moveToFirst()     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8c
            if (r0 != 0) goto L3f
            if (r7 == 0) goto L3d
            r7.close()
        L3d:
            r1 = r8
        L3e:
            return r1
        L3f:
            r0 = 0
            long r4 = r7.getLong(r0)     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8c
            r0 = 1
            java.lang.Object r6 = r9.zzb(r7, r0)     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8c
            com.google.android.gms.measurement.internal.zzai r1 = new com.google.android.gms.measurement.internal.zzai     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8c
            r2 = r10
            r3 = r11
            r1.<init>(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8c
            boolean r0 = r7.moveToNext()     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8c
            if (r0 == 0) goto L63
            com.google.android.gms.measurement.internal.zzp r0 = r9.zzAo()     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8c
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzCE()     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8c
            java.lang.String r2 = "Got multiple records for user property, expected one"
            r0.zzfg(r2)     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8c
        L63:
            if (r7 == 0) goto L3e
            r7.close()
            goto L3e
        L69:
            r0 = move-exception
            r1 = r8
        L6b:
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzAo()     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzCE()     // Catch: java.lang.Throwable -> L89
            java.lang.String r3 = "Error querying user property"
            r2.zzd(r3, r10, r11, r0)     // Catch: java.lang.Throwable -> L89
            if (r1 == 0) goto L7d
            r1.close()
        L7d:
            r1 = r8
            goto L3e
        L7f:
            r0 = move-exception
        L80:
            if (r8 == 0) goto L85
            r8.close()
        L85:
            throw r0
        L86:
            r0 = move-exception
            r8 = r7
            goto L80
        L89:
            r0 = move-exception
            r8 = r1
            goto L80
        L8c:
            r0 = move-exception
            r1 = r7
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzK(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzai");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.util.Map zzL(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            r9 = 0
            r10.zzjv()
            r10.zzjk()
            com.google.android.gms.common.internal.zzx.zzcM(r11)
            com.google.android.gms.common.internal.zzx.zzcM(r12)
            android.support.v4.util.ArrayMap r8 = new android.support.v4.util.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r10.getWritableDatabase()
            java.lang.String r1 = "event_filters"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> La9 android.database.sqlite.SQLiteException -> Lb3
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch: java.lang.Throwable -> La9 android.database.sqlite.SQLiteException -> Lb3
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch: java.lang.Throwable -> La9 android.database.sqlite.SQLiteException -> Lb3
            java.lang.String r3 = "app_id=? AND event_name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> La9 android.database.sqlite.SQLiteException -> Lb3
            r5 = 0
            r4[r5] = r11     // Catch: java.lang.Throwable -> La9 android.database.sqlite.SQLiteException -> Lb3
            r5 = 1
            r4[r5] = r12     // Catch: java.lang.Throwable -> La9 android.database.sqlite.SQLiteException -> Lb3
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> La9 android.database.sqlite.SQLiteException -> Lb3
            boolean r0 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            if (r0 != 0) goto L47
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            if (r1 == 0) goto L46
            r1.close()
        L46:
            return r0
        L47:
            r0 = 1
            byte[] r0 = r1.getBlob(r0)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            com.google.android.gms.internal.zzsm r0 = com.google.android.gms.internal.zzsm.zzD(r0)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            com.google.android.gms.internal.zzpz$zzb r2 = new com.google.android.gms.internal.zzpz$zzb     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            r2.<init>()     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            r2.mergeFrom(r0)     // Catch: java.io.IOException -> L85 android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            r0 = 0
            int r3 = r1.getInt(r0)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            java.lang.Object r0 = r8.get(r0)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            java.util.List r0 = (java.util.List) r0     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            if (r0 != 0) goto L75
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            r0.<init>()     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            r8.put(r3, r0)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
        L75:
            r0.add(r2)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
        L78:
            boolean r0 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            if (r0 != 0) goto L47
            if (r1 == 0) goto L83
            r1.close()
        L83:
            r0 = r8
            goto L46
        L85:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzAo()     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzCE()     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            java.lang.String r3 = "Failed to merge filter"
            r2.zze(r3, r11, r0)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            goto L78
        L94:
            r0 = move-exception
        L95:
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzAo()     // Catch: java.lang.Throwable -> Lb1
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzCE()     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r3 = "Database error querying filters"
            r2.zzj(r3, r0)     // Catch: java.lang.Throwable -> Lb1
            if (r1 == 0) goto La7
            r1.close()
        La7:
            r0 = r9
            goto L46
        La9:
            r0 = move-exception
            r1 = r9
        Lab:
            if (r1 == 0) goto Lb0
            r1.close()
        Lb0:
            throw r0
        Lb1:
            r0 = move-exception
            goto Lab
        Lb3:
            r0 = move-exception
            r1 = r9
            goto L95
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzL(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.util.Map zzM(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            r9 = 0
            r10.zzjv()
            r10.zzjk()
            com.google.android.gms.common.internal.zzx.zzcM(r11)
            com.google.android.gms.common.internal.zzx.zzcM(r12)
            android.support.v4.util.ArrayMap r8 = new android.support.v4.util.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r10.getWritableDatabase()
            java.lang.String r1 = "property_filters"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> La9 android.database.sqlite.SQLiteException -> Lb3
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch: java.lang.Throwable -> La9 android.database.sqlite.SQLiteException -> Lb3
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch: java.lang.Throwable -> La9 android.database.sqlite.SQLiteException -> Lb3
            java.lang.String r3 = "app_id=? AND property_name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> La9 android.database.sqlite.SQLiteException -> Lb3
            r5 = 0
            r4[r5] = r11     // Catch: java.lang.Throwable -> La9 android.database.sqlite.SQLiteException -> Lb3
            r5 = 1
            r4[r5] = r12     // Catch: java.lang.Throwable -> La9 android.database.sqlite.SQLiteException -> Lb3
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> La9 android.database.sqlite.SQLiteException -> Lb3
            boolean r0 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            if (r0 != 0) goto L47
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            if (r1 == 0) goto L46
            r1.close()
        L46:
            return r0
        L47:
            r0 = 1
            byte[] r0 = r1.getBlob(r0)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            com.google.android.gms.internal.zzsm r0 = com.google.android.gms.internal.zzsm.zzD(r0)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            com.google.android.gms.internal.zzpz$zze r2 = new com.google.android.gms.internal.zzpz$zze     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            r2.<init>()     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            r2.mergeFrom(r0)     // Catch: java.io.IOException -> L85 android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            r0 = 0
            int r3 = r1.getInt(r0)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            java.lang.Object r0 = r8.get(r0)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            java.util.List r0 = (java.util.List) r0     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            if (r0 != 0) goto L75
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            r0.<init>()     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            r8.put(r3, r0)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
        L75:
            r0.add(r2)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
        L78:
            boolean r0 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            if (r0 != 0) goto L47
            if (r1 == 0) goto L83
            r1.close()
        L83:
            r0 = r8
            goto L46
        L85:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzAo()     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzCE()     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            java.lang.String r3 = "Failed to merge filter"
            r2.zze(r3, r11, r0)     // Catch: android.database.sqlite.SQLiteException -> L94 java.lang.Throwable -> Lb1
            goto L78
        L94:
            r0 = move-exception
        L95:
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzAo()     // Catch: java.lang.Throwable -> Lb1
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzCE()     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r3 = "Database error querying filters"
            r2.zzj(r3, r0)     // Catch: java.lang.Throwable -> Lb1
            if (r1 == 0) goto La7
            r1.close()
        La7:
            r0 = r9
            goto L46
        La9:
            r0 = move-exception
            r1 = r9
        Lab:
            if (r1 == 0) goto Lb0
            r1.close()
        Lb0:
            throw r0
        Lb1:
            r0 = move-exception
            goto Lab
        Lb3:
            r0 = move-exception
            r1 = r9
            goto L95
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzM(java.lang.String, java.lang.String):java.util.Map");
    }

    @WorkerThread
    public void zzZ(long j) {
        zzjk();
        zzjv();
        if (getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            zzAo().zzCE().zzfg("Deleted fewer rows from queue than expected");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ea  */
    @android.support.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.measurement.internal.zze.zza zza(long r12, java.lang.String r14, boolean r15, boolean r16) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zza(long, java.lang.String, boolean, boolean):com.google.android.gms.measurement.internal.zze$zza");
    }

    @WorkerThread
    void zza(ContentValues contentValues, String str, Object obj) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        com.google.android.gms.common.internal.zzx.zzz(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (!(obj instanceof Float)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put(str, (Float) obj);
        }
    }

    @WorkerThread
    public void zza(zzqb.zze zzeVar) {
        zzjk();
        zzjv();
        com.google.android.gms.common.internal.zzx.zzz(zzeVar);
        com.google.android.gms.common.internal.zzx.zzcM(zzeVar.appId);
        com.google.android.gms.common.internal.zzx.zzz(zzeVar.zzbaq);
        zzCr();
        long jCurrentTimeMillis = zzjl().currentTimeMillis();
        if (zzeVar.zzbaq.longValue() < jCurrentTimeMillis - zzCp().zzBQ() || zzeVar.zzbaq.longValue() > zzCp().zzBQ() + jCurrentTimeMillis) {
            zzAo().zzCF().zze("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(jCurrentTimeMillis), zzeVar.zzbaq);
        }
        try {
            byte[] bArr = new byte[zzeVar.getSerializedSize()];
            zzsn zzsnVarZzE = zzsn.zzE(bArr);
            zzeVar.writeTo(zzsnVarZzE);
            zzsnVarZzE.zzJo();
            byte[] bArrZzg = zzCk().zzg(bArr);
            zzAo().zzCK().zzj("Saving bundle, size", Integer.valueOf(bArrZzg.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzeVar.appId);
            contentValues.put("bundle_end_timestamp", zzeVar.zzbaq);
            contentValues.put("data", bArrZzg);
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) == -1) {
                    zzAo().zzCE().zzfg("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                zzAo().zzCE().zzj("Error storing bundle", e);
            }
        } catch (IOException e2) {
            zzAo().zzCE().zzj("Data loss. Failed to serialize bundle", e2);
        }
    }

    @WorkerThread
    public void zza(com.google.android.gms.measurement.internal.zza zzaVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzaVar);
        zzjk();
        zzjv();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzaVar.zzwK());
        contentValues.put("app_instance_id", zzaVar.zzBj());
        contentValues.put("gmp_app_id", zzaVar.zzBk());
        contentValues.put("resettable_device_id_hash", zzaVar.zzBl());
        contentValues.put("last_bundle_index", Long.valueOf(zzaVar.zzBr()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzaVar.zzBm()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzaVar.zzBn()));
        contentValues.put("app_version", zzaVar.zzli());
        contentValues.put("app_store", zzaVar.zzBo());
        contentValues.put("gmp_version", Long.valueOf(zzaVar.zzBp()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzaVar.zzBq()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzaVar.zzAr()));
        contentValues.put("day", Long.valueOf(zzaVar.zzBv()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzaVar.zzBw()));
        contentValues.put("daily_events_count", Long.valueOf(zzaVar.zzBx()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzaVar.zzBy()));
        contentValues.put("config_fetched_time", Long.valueOf(zzaVar.zzBs()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzaVar.zzBt()));
        try {
            if (getWritableDatabase().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzAo().zzCE().zzfg("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            zzAo().zzCE().zzj("Error storing app", e);
        }
    }

    public void zza(zzh zzhVar, long j) {
        zzjk();
        zzjv();
        com.google.android.gms.common.internal.zzx.zzz(zzhVar);
        com.google.android.gms.common.internal.zzx.zzcM(zzhVar.zzaUa);
        zzqb.zzb zzbVar = new zzqb.zzb();
        zzbVar.zzbag = Long.valueOf(zzhVar.zzaVN);
        zzbVar.zzbae = new zzqb.zzc[zzhVar.zzaVO.size()];
        Iterator it = zzhVar.zzaVO.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            zzqb.zzc zzcVar = new zzqb.zzc();
            zzbVar.zzbae[i] = zzcVar;
            zzcVar.name = str;
            zzCk().zza(zzcVar, zzhVar.zzaVO.get(str));
            i++;
        }
        try {
            byte[] bArr = new byte[zzbVar.getSerializedSize()];
            zzsn zzsnVarZzE = zzsn.zzE(bArr);
            zzbVar.writeTo(zzsnVarZzE);
            zzsnVarZzE.zzJo();
            zzAo().zzCK().zze("Saving event, name, data size", zzhVar.mName, Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzhVar.zzaUa);
            contentValues.put("name", zzhVar.mName);
            contentValues.put("timestamp", Long.valueOf(zzhVar.zzaez));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insert("raw_events", null, contentValues) == -1) {
                    zzAo().zzCE().zzfg("Failed to insert raw event (got -1)");
                }
            } catch (SQLiteException e) {
                zzAo().zzCE().zzj("Error storing raw event", e);
            }
        } catch (IOException e2) {
            zzAo().zzCE().zzj("Data loss. Failed to serialize event params/data", e2);
        }
    }

    @WorkerThread
    public void zza(zzi zziVar) {
        com.google.android.gms.common.internal.zzx.zzz(zziVar);
        zzjk();
        zzjv();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zziVar.zzaUa);
        contentValues.put("name", zziVar.mName);
        contentValues.put("lifetime_count", Long.valueOf(zziVar.zzaVP));
        contentValues.put("current_bundle_count", Long.valueOf(zziVar.zzaVQ));
        contentValues.put("last_fire_timestamp", Long.valueOf(zziVar.zzaVR));
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzAo().zzCE().zzfg("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            zzAo().zzCE().zzj("Error storing event aggregates", e);
        }
    }

    void zza(String str, int i, zzqb.zzf zzfVar) {
        zzjv();
        zzjk();
        com.google.android.gms.common.internal.zzx.zzcM(str);
        com.google.android.gms.common.internal.zzx.zzz(zzfVar);
        try {
            byte[] bArr = new byte[zzfVar.getSerializedSize()];
            zzsn zzsnVarZzE = zzsn.zzE(bArr);
            zzfVar.writeTo(zzsnVarZzE);
            zzsnVarZzE.zzJo();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("current_results", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    zzAo().zzCE().zzfg("Failed to insert filter results (got -1)");
                }
            } catch (SQLiteException e) {
                zzAo().zzCE().zzj("Error storing filter results", e);
            }
        } catch (IOException e2) {
            zzAo().zzCE().zzj("Configuration loss. Failed to serialize filter results", e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0064 A[Catch: all -> 0x0194, SQLiteException -> 0x0196, TRY_LEAVE, TryCatch #7 {SQLiteException -> 0x0196, all -> 0x0194, blocks: (B:14:0x003f, B:16:0x0064, B:28:0x009b, B:29:0x00a8, B:30:0x00ab, B:32:0x00b1, B:33:0x00be, B:40:0x010e), top: B:79:0x003f, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11, types: [com.google.android.gms.measurement.internal.zzp$zza] */
    /* JADX WARN: Type inference failed for: r3v14, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void zza(java.lang.String r15, long r16, com.google.android.gms.measurement.internal.zze.zzb r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zza(java.lang.String, long, com.google.android.gms.measurement.internal.zze$zzb):void");
    }

    @WorkerThread
    public boolean zza(zzai zzaiVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzaiVar);
        zzjk();
        zzjv();
        if (zzK(zzaiVar.zzaUa, zzaiVar.mName) == null) {
            if (zzaj.zzfq(zzaiVar.mName)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzaiVar.zzaUa}) >= zzCp().zzBL()) {
                    return false;
                }
            } else if (zzb("select count(1) from user_attributes where app_id=?", new String[]{zzaiVar.zzaUa}) >= zzCp().zzBM()) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzaiVar.zzaUa);
        contentValues.put("name", zzaiVar.mName);
        contentValues.put("set_timestamp", Long.valueOf(zzaiVar.zzaZp));
        zza(contentValues, "value", zzaiVar.zzNc);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzAo().zzCE().zzfg("Failed to insert/update user property (got -1)");
            }
        } catch (SQLiteException e) {
            zzAo().zzCE().zzj("Error storing user property", e);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String zzaa(long r8) {
        /*
            r7 = this;
            r0 = 0
            r7.zzjk()
            r7.zzjv()
            android.database.sqlite.SQLiteDatabase r1 = r7.getWritableDatabase()     // Catch: android.database.sqlite.SQLiteException -> L3f java.lang.Throwable -> L54
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: android.database.sqlite.SQLiteException -> L3f java.lang.Throwable -> L54
            r4 = 0
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch: android.database.sqlite.SQLiteException -> L3f java.lang.Throwable -> L54
            r3[r4] = r5     // Catch: android.database.sqlite.SQLiteException -> L3f java.lang.Throwable -> L54
            android.database.Cursor r2 = r1.rawQuery(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L3f java.lang.Throwable -> L54
            boolean r1 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            if (r1 != 0) goto L34
            com.google.android.gms.measurement.internal.zzp r1 = r7.zzAo()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            com.google.android.gms.measurement.internal.zzp$zza r1 = r1.zzCK()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            java.lang.String r3 = "No expired configs for apps with pending events"
            r1.zzfg(r3)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            if (r2 == 0) goto L33
            r2.close()
        L33:
            return r0
        L34:
            r1 = 0
            java.lang.String r0 = r2.getString(r1)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            if (r2 == 0) goto L33
            r2.close()
            goto L33
        L3f:
            r1 = move-exception
            r2 = r0
        L41:
            com.google.android.gms.measurement.internal.zzp r3 = r7.zzAo()     // Catch: java.lang.Throwable -> L5d
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzCE()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r4 = "Error selecting expired configs"
            r3.zzj(r4, r1)     // Catch: java.lang.Throwable -> L5d
            if (r2 == 0) goto L33
            r2.close()
            goto L33
        L54:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L57:
            if (r2 == 0) goto L5c
            r2.close()
        L5c:
            throw r0
        L5d:
            r0 = move-exception
            goto L57
        L5f:
            r1 = move-exception
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzaa(long):java.lang.String");
    }

    public long zzb(zzqb.zze zzeVar) throws NoSuchAlgorithmException, IOException {
        zzjk();
        zzjv();
        com.google.android.gms.common.internal.zzx.zzz(zzeVar);
        com.google.android.gms.common.internal.zzx.zzcM(zzeVar.appId);
        try {
            byte[] bArr = new byte[zzeVar.getSerializedSize()];
            zzsn zzsnVarZzE = zzsn.zzE(bArr);
            zzeVar.writeTo(zzsnVarZzE);
            zzsnVarZzE.zzJo();
            long jZzr = zzCk().zzr(bArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzeVar.appId);
            contentValues.put("metadata_fingerprint", Long.valueOf(jZzr));
            contentValues.put("metadata", bArr);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return jZzr;
            } catch (SQLiteException e) {
                zzAo().zzCE().zzj("Error storing raw event metadata", e);
                throw e;
            }
        } catch (IOException e2) {
            zzAo().zzCE().zzj("Data loss. Failed to serialize event metadata", e2);
            throw e2;
        }
    }

    @WorkerThread
    Object zzb(Cursor cursor, int i) {
        int iZza = zza(cursor, i);
        switch (iZza) {
            case 0:
                zzAo().zzCE().zzfg("Loaded invalid null value from database");
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                zzAo().zzCE().zzfg("Loaded invalid blob type value, ignoring it");
                break;
            default:
                zzAo().zzCE().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(iZza));
                break;
        }
        return null;
    }

    @WorkerThread
    void zzb(String str, zzpz.zza[] zzaVarArr) {
        zzjv();
        zzjk();
        com.google.android.gms.common.internal.zzx.zzcM(str);
        com.google.android.gms.common.internal.zzx.zzz(zzaVarArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            zzfb(str);
            for (zzpz.zza zzaVar : zzaVarArr) {
                zza(str, zzaVar);
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @WorkerThread
    public void zzd(String str, byte[] bArr) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        zzjk();
        zzjv();
        new ContentValues().put("remote_config", bArr);
        try {
            if (getWritableDatabase().update("apps", r0, "app_id = ?", new String[]{str}) == 0) {
                zzAo().zzCE().zzfg("Failed to update remote config (got 0)");
            }
        } catch (SQLiteException e) {
            zzAo().zzCE().zzj("Error storing remote config", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009e  */
    @android.support.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List zzeX(java.lang.String r12) {
        /*
            r11 = this;
            r10 = 0
            com.google.android.gms.common.internal.zzx.zzcM(r12)
            r11.zzjk()
            r11.zzjv()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch: java.lang.Throwable -> L9b android.database.sqlite.SQLiteException -> La8
            java.lang.String r1 = "user_attributes"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L9b android.database.sqlite.SQLiteException -> La8
            r3 = 0
            java.lang.String r4 = "name"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L9b android.database.sqlite.SQLiteException -> La8
            r3 = 1
            java.lang.String r4 = "set_timestamp"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L9b android.database.sqlite.SQLiteException -> La8
            r3 = 2
            java.lang.String r4 = "value"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L9b android.database.sqlite.SQLiteException -> La8
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L9b android.database.sqlite.SQLiteException -> La8
            r5 = 0
            r4[r5] = r12     // Catch: java.lang.Throwable -> L9b android.database.sqlite.SQLiteException -> La8
            r5 = 0
            r6 = 0
            java.lang.String r7 = "rowid"
            com.google.android.gms.measurement.internal.zzd r8 = r11.zzCp()     // Catch: java.lang.Throwable -> L9b android.database.sqlite.SQLiteException -> La8
            int r8 = r8.zzBM()     // Catch: java.lang.Throwable -> L9b android.database.sqlite.SQLiteException -> La8
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L9b android.database.sqlite.SQLiteException -> La8
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L9b android.database.sqlite.SQLiteException -> La8
            boolean r0 = r7.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L85 java.lang.Throwable -> La2
            if (r0 != 0) goto L50
            if (r7 == 0) goto L4e
            r7.close()
        L4e:
            r0 = r9
        L4f:
            return r0
        L50:
            r0 = 0
            java.lang.String r3 = r7.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L85 java.lang.Throwable -> La2
            r0 = 1
            long r4 = r7.getLong(r0)     // Catch: android.database.sqlite.SQLiteException -> L85 java.lang.Throwable -> La2
            r0 = 2
            java.lang.Object r6 = r11.zzb(r7, r0)     // Catch: android.database.sqlite.SQLiteException -> L85 java.lang.Throwable -> La2
            if (r6 != 0) goto L7b
            com.google.android.gms.measurement.internal.zzp r0 = r11.zzAo()     // Catch: android.database.sqlite.SQLiteException -> L85 java.lang.Throwable -> La2
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzCE()     // Catch: android.database.sqlite.SQLiteException -> L85 java.lang.Throwable -> La2
            java.lang.String r1 = "Read invalid user property value, ignoring it"
            r0.zzfg(r1)     // Catch: android.database.sqlite.SQLiteException -> L85 java.lang.Throwable -> La2
        L6e:
            boolean r0 = r7.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L85 java.lang.Throwable -> La2
            if (r0 != 0) goto L50
            if (r7 == 0) goto L79
            r7.close()
        L79:
            r0 = r9
            goto L4f
        L7b:
            com.google.android.gms.measurement.internal.zzai r1 = new com.google.android.gms.measurement.internal.zzai     // Catch: android.database.sqlite.SQLiteException -> L85 java.lang.Throwable -> La2
            r2 = r12
            r1.<init>(r2, r3, r4, r6)     // Catch: android.database.sqlite.SQLiteException -> L85 java.lang.Throwable -> La2
            r9.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L85 java.lang.Throwable -> La2
            goto L6e
        L85:
            r0 = move-exception
            r1 = r7
        L87:
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzAo()     // Catch: java.lang.Throwable -> La5
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzCE()     // Catch: java.lang.Throwable -> La5
            java.lang.String r3 = "Error querying user properties"
            r2.zze(r3, r12, r0)     // Catch: java.lang.Throwable -> La5
            if (r1 == 0) goto L99
            r1.close()
        L99:
            r0 = r10
            goto L4f
        L9b:
            r0 = move-exception
        L9c:
            if (r10 == 0) goto La1
            r10.close()
        La1:
            throw r0
        La2:
            r0 = move-exception
            r10 = r7
            goto L9c
        La5:
            r0 = move-exception
            r10 = r1
            goto L9c
        La8:
            r0 = move-exception
            r1 = r10
            goto L87
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzeX(java.lang.String):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x016f  */
    @android.support.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.measurement.internal.zza zzeY(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzeY(java.lang.String):com.google.android.gms.measurement.internal.zza");
    }

    public long zzeZ(String str) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        zzjk();
        zzjv();
        try {
            return getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(zzCp().zzeW(str))});
        } catch (SQLiteException e) {
            zzAo().zzCE().zzj("Error deleting over the limit events", e);
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    @android.support.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] zzfa(java.lang.String r10) throws java.lang.Throwable {
        /*
            r9 = this;
            r8 = 0
            com.google.android.gms.common.internal.zzx.zzcM(r10)
            r9.zzjk()
            r9.zzjv()
            android.database.sqlite.SQLiteDatabase r0 = r9.getWritableDatabase()     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L68
            java.lang.String r1 = "apps"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L68
            r3 = 0
            java.lang.String r4 = "remote_config"
            r2[r3] = r4     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L68
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L68
            r5 = 0
            r4[r5] = r10     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L68
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L68
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteException -> L72
            if (r0 != 0) goto L34
            if (r1 == 0) goto L32
            r1.close()
        L32:
            r0 = r8
        L33:
            return r0
        L34:
            r0 = 0
            byte[] r0 = r1.getBlob(r0)     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteException -> L72
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteException -> L72
            if (r2 == 0) goto L4c
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzAo()     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteException -> L72
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzCE()     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteException -> L72
            java.lang.String r3 = "Got multiple records for app config, expected one"
            r2.zzfg(r3)     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteException -> L72
        L4c:
            if (r1 == 0) goto L33
            r1.close()
            goto L33
        L52:
            r0 = move-exception
            r1 = r8
        L54:
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzAo()     // Catch: java.lang.Throwable -> L70
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzCE()     // Catch: java.lang.Throwable -> L70
            java.lang.String r3 = "Error querying remote config"
            r2.zze(r3, r10, r0)     // Catch: java.lang.Throwable -> L70
            if (r1 == 0) goto L66
            r1.close()
        L66:
            r0 = r8
            goto L33
        L68:
            r0 = move-exception
            r1 = r8
        L6a:
            if (r1 == 0) goto L6f
            r1.close()
        L6f:
            throw r0
        L70:
            r0 = move-exception
            goto L6a
        L72:
            r0 = move-exception
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzfa(java.lang.String):byte[]");
    }

    @WorkerThread
    void zzfb(String str) {
        zzjv();
        zzjk();
        com.google.android.gms.common.internal.zzx.zzcM(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("property_filters", "app_id=?", new String[]{str});
        writableDatabase.delete("event_filters", "app_id=?", new String[]{str});
    }

    public void zzfc(String str) throws SQLException {
        try {
            getWritableDatabase().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            zzAo().zzCE().zzj("Failed to remove unused event metadata", e);
        }
    }

    public long zzfd(String str) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    @Override // com.google.android.gms.measurement.internal.zzz
    protected void zziJ() {
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00d9  */
    @android.support.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List zzn(java.lang.String r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzn(java.lang.String, int, int):java.util.List");
    }

    public void zzz(List list) {
        com.google.android.gms.common.internal.zzx.zzz(list);
        zzjk();
        zzjv();
        StringBuilder sb = new StringBuilder("rowid in (");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(((Long) list.get(i2)).longValue());
            i = i2 + 1;
        }
        sb.append(")");
        int iDelete = getWritableDatabase().delete("raw_events", sb.toString(), null);
        if (iDelete != list.size()) {
            zzAo().zzCE().zze("Deleted fewer rows from raw events table than expected", Integer.valueOf(iDelete), Integer.valueOf(list.size()));
        }
    }
}
