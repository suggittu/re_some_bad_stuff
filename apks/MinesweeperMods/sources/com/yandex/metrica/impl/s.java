package com.yandex.metrica.impl;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
final class s {
    public static String a(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        StringWriter stringWriter = new StringWriter();
        a(inputStreamReader, stringWriter);
        return stringWriter.toString();
    }

    public static String a(String str) throws Throwable {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                String strA = a(fileInputStream);
                bk.a((Closeable) fileInputStream);
                return strA;
            } catch (Throwable th) {
                th = th;
                bk.a((Closeable) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static int a(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[4096];
        int i = 0;
        while (true) {
            int i2 = reader.read(cArr, 0, 4096);
            if (-1 != i2) {
                writer.write(cArr, 0, i2);
                i += i2;
            } else {
                return i;
            }
        }
    }

    public static String b(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        GZIPOutputStream gZIPOutputStream;
        String strEncodeToString = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(str.getBytes("UTF-8"));
                    gZIPOutputStream.finish();
                    strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                    bk.a((Closeable) gZIPOutputStream);
                    bk.a((Closeable) byteArrayOutputStream);
                } catch (Exception e) {
                    bk.a((Closeable) gZIPOutputStream);
                    bk.a((Closeable) byteArrayOutputStream);
                    return strEncodeToString;
                } catch (Throwable th2) {
                    th = th2;
                    bk.a((Closeable) gZIPOutputStream);
                    bk.a((Closeable) byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                gZIPOutputStream = null;
            } catch (Throwable th3) {
                gZIPOutputStream = null;
                th = th3;
            }
        } catch (Exception e3) {
            gZIPOutputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            gZIPOutputStream = null;
        }
        return strEncodeToString;
    }

    public static String c(String str) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        GZIPInputStream gZIPInputStream;
        String strA = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str, 0));
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            } catch (Exception e) {
                gZIPInputStream = null;
            } catch (Throwable th2) {
                gZIPInputStream = null;
                th = th2;
            }
            try {
                strA = a(gZIPInputStream);
                bk.a((Closeable) byteArrayInputStream);
                bk.a((Closeable) gZIPInputStream);
            } catch (Exception e2) {
                bk.a((Closeable) byteArrayInputStream);
                bk.a((Closeable) gZIPInputStream);
                return strA;
            } catch (Throwable th3) {
                th = th3;
                bk.a((Closeable) byteArrayInputStream);
                bk.a((Closeable) gZIPInputStream);
                throw th;
            }
        } catch (Exception e3) {
            gZIPInputStream = null;
            byteArrayInputStream = null;
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            gZIPInputStream = null;
        }
        return strA;
    }

    public static byte[] b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (-1 == i) {
                    return byteArrayOutputStream.toByteArray();
                }
                if (i > 0) {
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            } finally {
                bk.a((Closeable) byteArrayOutputStream);
            }
        }
    }
}
