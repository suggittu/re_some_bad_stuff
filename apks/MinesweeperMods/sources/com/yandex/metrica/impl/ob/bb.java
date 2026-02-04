package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import com.yandex.metrica.YandexMetrica;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class bb {
    public static final Boolean a = false;
    public static final int b = YandexMetrica.getLibraryApiLevel();
    static final SparseArray<h> c;
    static final SparseArray<h> d;
    static final HashMap<String, String[]> e;

    public static final class p {
        public static final String[] a = {"id", "number", "name", "value", "type", "time", "session_id", "wifi_network_info", "cell_info", "location_info", "error_environment", "user_info", "session_type", "app_environment", "app_environment_revision", "truncated", "connection_type", "cellular_connection_type"};
        static final String b = "CREATE TABLE IF NOT EXISTS reports (id INTEGER PRIMARY KEY,name TEXT,value TEXT,number INTEGER,type INTEGER,time INTEGER,session_id TEXT,wifi_network_info TEXT DEFAULT '',cell_info TEXT DEFAULT '',location_info TEXT DEFAULT '',error_environment TEXT,user_info TEXT,session_type INTEGER DEFAULT " + az.FOREGROUND.a() + ",app_environment TEXT DEFAULT '{}',app_environment_revision INTEGER DEFAULT 0,truncated INTEGER DEFAULT 0,connection_type INTEGER DEFAULT 2,cellular_connection_type TEXT )";
    }

    public static final class q {
        public static final String[] a = {"id", "start_time", "network_info", "report_request_parameters", "server_time_offset", "type"};
        static final String b = "CREATE TABLE IF NOT EXISTS sessions (id INTEGER,start_time INTEGER,network_info TEXT,report_request_parameters TEXT,server_time_offset INTEGER,type INTEGER DEFAULT " + az.FOREGROUND.a() + " )";
        public static final String c = String.format(Locale.US, "(select count(%s.%s) from %s where %s.%s = %s.%s) = 0 and %s != ?", "reports", "id", "reports", "reports", "session_id", "sessions", "id", "id");
    }

    static {
        byte b2 = 0;
        SparseArray<h> sparseArray = new SparseArray<>();
        c = sparseArray;
        sparseArray.put(6, new n(b2));
        c.put(7, new o(b2));
        c.put(14, new i(b2));
        c.put(29, new j(b2));
        c.put(37, new k(b2));
        c.put(39, new l(b2));
        c.put(45, new m(b2));
        SparseArray<h> sparseArray2 = new SparseArray<>();
        d = sparseArray2;
        sparseArray2.put(12, new e(b2));
        d.put(14, new f(b2));
        d.put(29, new g(b2));
        HashMap<String, String[]> map = new HashMap<>();
        e = map;
        map.put("reports", p.a);
        e.put("sessions", q.a);
    }

    public static be a() {
        byte b2 = 0;
        return new be(new a(b2), new b(b2), c, new bg(e));
    }

    public static be b() {
        byte b2 = 0;
        return new be(new c(b2), new d(b2), d, new ba());
    }

    static abstract class h {
        protected abstract void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException;

        h() {
        }
    }

    private static class n extends h {
        private n() {
        }

        /* synthetic */ n(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.ob.bb.h
        protected void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
            sQLiteDatabase.execSQL("ALTER TABLE sessions ADD COLUMN wifi_network_info TEXT DEFAULT ''");
        }
    }

    private static class o extends h {
        private o() {
        }

        /* synthetic */ o(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.ob.bb.h
        protected void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
            sQLiteDatabase.execSQL("ALTER TABLE sessions ADD COLUMN report_request_parameters TEXT DEFAULT ''");
        }
    }

    private static class i extends h {
        private i() {
        }

        /* synthetic */ i(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.ob.bb.h
        protected void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException, android.database.SQLException {
            Cursor cursorRawQuery = null;
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sessions_BACKUP (id INTEGER,start_time INTEGER,connection_type INTEGER,network_type TEXT,country_code INTEGER,operator_id INTEGER,lac INTEGER,report_request_parameters TEXT );");
            StringBuilder sb = new StringBuilder();
            sb.append("id,");
            sb.append("start_time,");
            sb.append("connection_type,");
            sb.append("network_type,");
            sb.append("country_code,");
            sb.append("operator_id,");
            sb.append("lac,");
            sb.append("report_request_parameters");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("INSERT INTO sessions_BACKUP");
            sb2.append(" SELECT ").append((CharSequence) sb);
            sb2.append(" FROM sessions;");
            sQLiteDatabase.execSQL(sb2.toString());
            sQLiteDatabase.execSQL("DROP TABLE sessions;");
            sQLiteDatabase.execSQL(q.b);
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM sessions_BACKUP", null);
                while (cursorRawQuery.moveToNext()) {
                    ContentValues contentValues = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursorRawQuery, contentValues);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("id");
                    arrayList.add("start_time");
                    arrayList.add("report_request_parameters");
                    ContentValues contentValues2 = new ContentValues(contentValues);
                    for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                        if (!arrayList.contains(entry.getKey())) {
                            contentValues2.remove(entry.getKey());
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        contentValues.remove((String) it.next());
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("conn_type", contentValues.getAsInteger("connection_type"));
                    jSONObject.putOpt("net_type", contentValues.get("network_type"));
                    jSONObject.putOpt("operator_id", contentValues.get("operator_id"));
                    jSONObject.putOpt("lac", contentValues.get("lac"));
                    jSONObject.putOpt("country_code", contentValues.get("country_code"));
                    contentValues2.put("network_info", jSONObject.toString());
                    sQLiteDatabase.insertOrThrow("sessions", null, contentValues2);
                }
                com.yandex.metrica.impl.bk.a(cursorRawQuery);
                sQLiteDatabase.execSQL("DROP TABLE sessions_BACKUP;");
                sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN wifi_network_info TEXT DEFAULT ''");
                sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN cell_info TEXT DEFAULT ''");
                sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN location_info TEXT DEFAULT ''");
            } catch (Throwable th) {
                com.yandex.metrica.impl.bk.a(cursorRawQuery);
                throw th;
            }
        }
    }

    private static class j extends h {
        private j() {
        }

        /* synthetic */ j(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.ob.bb.h
        protected void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN environment TEXT ");
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN user_info TEXT ");
            StringBuilder sb = new StringBuilder();
            sb.append("ALTER TABLE reports");
            sb.append(" ADD COLUMN session_type");
            sb.append(" INTEGER DEFAULT ").append(az.FOREGROUND.a());
            sQLiteDatabase.execSQL(sb.toString());
            sQLiteDatabase.execSQL("UPDATE reports SET session_type = " + az.BACKGROUND.a() + " WHERE session_id = -2");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ALTER TABLE sessions");
            sb2.append(" ADD COLUMN server_time_offset");
            sb2.append(" INTEGER ");
            sQLiteDatabase.execSQL(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ALTER TABLE sessions");
            sb3.append(" ADD COLUMN type");
            sb3.append(" INTEGER DEFAULT ").append(az.FOREGROUND.a());
            sQLiteDatabase.execSQL(sb3.toString());
            sQLiteDatabase.execSQL("UPDATE sessions SET type = " + az.BACKGROUND.a() + " WHERE id = -2");
        }
    }

    private static class e extends h {
        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.ob.bb.h
        protected void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS api_level_info (API_LEVEL INT )");
            ContentValues contentValues = new ContentValues();
            contentValues.put("API_LEVEL", Integer.valueOf(YandexMetrica.getLibraryApiLevel()));
            sQLiteDatabase.insert("api_level_info", "API_LEVEL", contentValues);
        }
    }

    private static class f extends h {
        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.ob.bb.h
        protected void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS GeoLocationInfo (GeoLocation BLOB )");
            sQLiteDatabase.insert("GeoLocationInfo", "GeoLocation", new ContentValues());
        }
    }

    private static class g extends h {
        private g() {
        }

        /* synthetic */ g(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.ob.bb.h
        protected void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS api_level_info");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS device_id_info");
        }
    }

    private static class k extends h {
        private static final String a = "CREATE TABLE IF NOT EXISTS reports (id INTEGER PRIMARY KEY,name TEXT,value TEXT,number INTEGER,type INTEGER,time INTEGER,session_id TEXT,wifi_network_info TEXT DEFAULT '',cell_info TEXT DEFAULT '',location_info TEXT DEFAULT '',error_environment TEXT,user_info TEXT,session_type INTEGER DEFAULT " + az.FOREGROUND.a() + ",app_environment TEXT DEFAULT '{}',app_environment_revision INTEGER DEFAULT 0 )";

        private k() {
        }

        /* synthetic */ k(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.ob.bb.h
        protected void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN app_environment TEXT DEFAULT '{}'");
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN app_environment_revision INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE reports RENAME TO reports_backup");
            sQLiteDatabase.execSQL(a);
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM reports_backup", null);
            while (cursorRawQuery.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(cursorRawQuery, contentValues);
                String asString = contentValues.getAsString("environment");
                contentValues.remove("environment");
                contentValues.put("error_environment", asString);
                sQLiteDatabase.insert("reports", null, contentValues);
            }
            sQLiteDatabase.execSQL("DROP TABLE reports_backup");
        }
    }

    private static class l extends h {
        private l() {
        }

        /* synthetic */ l(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.ob.bb.h
        protected void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN truncated INTEGER DEFAULT 0");
        }
    }

    private static class m extends h {
        private m() {
        }

        /* synthetic */ m(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.ob.bb.h
        protected void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException, android.database.SQLException {
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN connection_type INTEGER DEFAULT 2");
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN cellular_connection_type TEXT ");
        }
    }

    private static class a extends h {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.ob.bb.h
        protected void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
            sQLiteDatabase.execSQL(p.b);
            sQLiteDatabase.execSQL(q.b);
        }
    }

    private static class b extends h {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.ob.bb.h
        protected void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS reports");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sessions");
        }
    }

    private static class c extends h {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.ob.bb.h
        protected void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS GeoLocationInfo (GeoLocation BLOB )");
            sQLiteDatabase.insert("GeoLocationInfo", "GeoLocation", new ContentValues());
        }
    }

    private static class d extends h {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.yandex.metrica.impl.ob.bb.h
        protected void a(SQLiteDatabase sQLiteDatabase) throws SQLException, android.database.SQLException {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS device_id_info");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS GeoLocationInfo");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS api_level_info");
        }
    }
}
