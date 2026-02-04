package com.yandex.metrica.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.LocalServerSocket;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.bx;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class o {
    private final Object a;
    private a b;

    /* synthetic */ o(byte b2) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b {
        private static final o a = new o(0);
    }

    private o() {
        this.a = new Object();
        this.b = new a(this, (byte) 0);
    }

    a a() {
        return this.b;
    }

    public String a(Context context) {
        return a(context, context.getPackageName());
    }

    public String a(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (applicationInfo == null) {
                return null;
            }
            String strA = a(context.getFileStreamPath("credentials.dat").getAbsolutePath().replace(context.getApplicationInfo().dataDir, applicationInfo.dataDir));
            if (strA == null) {
                return null;
            }
            return new JSONObject(strA).getString("device_id");
        } catch (JSONException e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    private String a(String str) {
        FileLock fileLockLock;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        RandomAccessFile randomAccessFile2;
        File file = new File(str);
        if (file.exists()) {
            synchronized (this.a) {
                try {
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        FileChannel channel = randomAccessFile.getChannel();
                        fileLockLock = channel.lock(0L, Long.MAX_VALUE, true);
                        try {
                            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) file.length());
                            channel.read(byteBufferAllocate);
                            byteBufferAllocate.flip();
                            String str2 = new String(byteBufferAllocate.array());
                            file.getAbsolutePath();
                            a(fileLockLock);
                            bk.a((Closeable) randomAccessFile);
                            return str2;
                        } catch (IOException e) {
                            fileLock = fileLockLock;
                            randomAccessFile2 = randomAccessFile;
                            file.getAbsolutePath();
                            a(fileLock);
                            bk.a((Closeable) randomAccessFile2);
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            file.getAbsolutePath();
                            a(fileLockLock);
                            bk.a((Closeable) randomAccessFile);
                            throw th;
                        }
                    } catch (IOException e2) {
                        fileLock = null;
                        randomAccessFile2 = randomAccessFile;
                    } catch (Throwable th2) {
                        th = th2;
                        fileLockLock = null;
                    }
                } catch (IOException e3) {
                    fileLock = null;
                    randomAccessFile2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileLockLock = null;
                    randomAccessFile = null;
                }
            }
        }
        return null;
    }

    private static void a(FileLock fileLock) throws IOException {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e) {
            }
        }
    }

    public String b(Context context, String str) throws Throwable {
        String strA = a().a(context, str);
        if (!TextUtils.isEmpty(strA)) {
            c(context, strA);
        }
        return strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, String str) throws JSONException {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileLock fileLock;
        FileOutputStream fileOutputStreamOpenFileOutput;
        FileChannel channel;
        FileLock fileLockLock;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = a(context);
        if (strA != null) {
            str.equals(strA);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", str);
            String string = jSONObject.toString();
            synchronized (this.a) {
                try {
                    fileOutputStreamOpenFileOutput = context.openFileOutput("credentials.dat", 1);
                    try {
                        try {
                            channel = fileOutputStreamOpenFileOutput.getChannel();
                            fileLockLock = channel.lock();
                        } catch (Throwable th2) {
                            fileOutputStream = fileOutputStreamOpenFileOutput;
                            fileLock = null;
                            th = th2;
                        }
                        try {
                            byte[] bytes = string.getBytes();
                            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length);
                            byteBufferAllocate.put(bytes);
                            byteBufferAllocate.flip();
                            channel.write(byteBufferAllocate);
                            channel.force(true);
                            a(fileLockLock);
                            bk.a((Closeable) fileOutputStreamOpenFileOutput);
                        } catch (Throwable th3) {
                            fileOutputStream = fileOutputStreamOpenFileOutput;
                            fileLock = fileLockLock;
                            th = th3;
                            a(fileLock);
                            bk.a((Closeable) fileOutputStream);
                            throw th;
                        }
                    } catch (IOException e) {
                        a((FileLock) null);
                        bk.a((Closeable) fileOutputStreamOpenFileOutput);
                    } catch (SecurityException e2) {
                        a((FileLock) null);
                        bk.a((Closeable) fileOutputStreamOpenFileOutput);
                    }
                } catch (IOException e3) {
                    fileOutputStreamOpenFileOutput = null;
                } catch (SecurityException e4) {
                    fileOutputStreamOpenFileOutput = null;
                } catch (Throwable th4) {
                    fileOutputStream = null;
                    th = th4;
                    fileLock = null;
                }
            }
        } catch (JSONException e5) {
        }
    }

    String b(Context context) throws Throwable {
        String strA;
        String str = null;
        List<ResolveInfo> listA = be.a(context, be.a(context));
        LinkedList linkedList = new LinkedList();
        for (ResolveInfo resolveInfo : listA) {
            String str2 = resolveInfo.serviceInfo.applicationInfo.packageName;
            if (be.a(resolveInfo.serviceInfo) < 29) {
                linkedList.add(resolveInfo.serviceInfo.packageName);
                strA = str;
            } else {
                strA = a(context, str2);
            }
            if (!bi.a(strA)) {
                return strA;
            }
            str = strA;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String strD = d(context, (String) it.next());
            if (!bi.a(strD)) {
                return strD;
            }
        }
        return "";
    }

    public String c(Context context) throws Throwable {
        return this.b.a(context, b(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String d(android.content.Context r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            r3 = 0
            r6 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r1 = ".MetricaContentProvider"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.content.pm.PackageManager r1 = r7.getPackageManager()
            android.content.pm.ProviderInfo r0 = r1.resolveContentProvider(r0, r3)
            if (r0 == 0) goto L23
            boolean r0 = r0.enabled
            if (r0 != 0) goto L25
        L23:
            r0 = r6
        L24:
            return r0
        L25:
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r1 = "content://%s.MetricaContentProvider/DEVICE_ID"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r8
            java.lang.String r1 = java.lang.String.format(r0, r1, r2)
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> L5f
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> L5f
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> L5f
            if (r1 == 0) goto L6a
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
            if (r0 == 0) goto L6a
            java.lang.String r0 = "DEVICE_ID"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
        L54:
            com.yandex.metrica.impl.bk.a(r1)
            goto L24
        L58:
            r0 = move-exception
            r0 = r6
        L5a:
            com.yandex.metrica.impl.bk.a(r0)
            r0 = r6
            goto L24
        L5f:
            r0 = move-exception
            r1 = r6
        L61:
            com.yandex.metrica.impl.bk.a(r1)
            throw r0
        L65:
            r0 = move-exception
            goto L61
        L67:
            r0 = move-exception
            r0 = r1
            goto L5a
        L6a:
            r0 = r6
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.o.d(android.content.Context, java.lang.String):java.lang.String");
    }

    static class a {
        volatile o a;
        private LocalServerSocket b;

        /* synthetic */ a(o oVar, byte b) {
            this(oVar);
        }

        private a(o oVar) {
            this.a = oVar;
        }

        private boolean a() {
            try {
                this.b = new LocalServerSocket("com.yandex.metrica.synchronization.deviceid");
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        public String a(Context context, String str) throws Throwable {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String strB = this.a.b(context);
            if (TextUtils.isEmpty(strB)) {
                bx bxVar = new bx(12);
                while (!a()) {
                    bxVar.a();
                    bxVar.c();
                    if (!bxVar.b()) {
                    }
                }
                String strB2 = this.a.b(context);
                if (TextUtils.isEmpty(strB2)) {
                    this.a.c(context, str);
                } else {
                    str = strB2;
                }
                if (this.b == null) {
                    return str;
                }
                try {
                    this.b.close();
                    this.b = null;
                    return str;
                } catch (IOException e) {
                    return str;
                }
            }
            return strB;
        }
    }
}
