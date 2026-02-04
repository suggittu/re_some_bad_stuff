package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class bm {
    private static final bu c = new bu("UNDEFINED_");
    protected final String a;
    protected final SharedPreferences b;
    private final Map<String, Object> d = new HashMap();
    private boolean e = false;

    protected abstract String g();

    public bm(Context context, String str) {
        this.a = str;
        this.b = a(context);
        i();
    }

    protected void i() {
        new bu(c.a(), this.a);
    }

    protected SharedPreferences a(Context context) {
        return bv.a(context, g());
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <T extends bm> T a(String str, Object obj) {
        synchronized (this) {
            if (obj != null) {
                this.d.put(str, obj);
            }
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <T extends bm> T i(String str) {
        synchronized (this) {
            this.d.put(str, this);
        }
        return this;
    }

    protected String j() {
        return this.a;
    }

    public void k() {
        synchronized (this) {
            SharedPreferences.Editor editorEdit = this.b.edit();
            if (this.e) {
                editorEdit.clear().commit();
            } else {
                for (Map.Entry<String, Object> entry : this.d.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value == this) {
                        editorEdit.remove(key);
                    } else if (value instanceof String) {
                        editorEdit.putString(key, (String) value);
                    } else if (value instanceof Long) {
                        editorEdit.putLong(key, ((Long) value).longValue());
                    } else if (value instanceof Integer) {
                        editorEdit.putInt(key, ((Integer) value).intValue());
                    } else if (value instanceof Boolean) {
                        editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
                    } else if (value != null) {
                        throw new UnsupportedOperationException();
                    }
                }
                editorEdit.commit();
            }
            this.d.clear();
            this.e = false;
        }
    }
}
