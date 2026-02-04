package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.dx;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes.dex */
public class dw {
    protected final ds a;

    public dw(ds dsVar) {
        this.a = dsVar;
    }

    public dz a(ea<?> eaVar) throws dx, IOException {
        byte[] bArr;
        HttpResponse httpResponseA;
        byte[] bArrA;
        while (true) {
            Map mapEmptyMap = Collections.emptyMap();
            try {
                try {
                    httpResponseA = this.a.a(eaVar);
                    try {
                        int statusCode = httpResponseA.getStatusLine().getStatusCode();
                        Header[] allHeaders = httpResponseA.getAllHeaders();
                        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                        for (int i = 0; i < allHeaders.length; i++) {
                            treeMap.put(allHeaders[i].getName(), allHeaders[i].getValue());
                        }
                        try {
                            if (httpResponseA.getEntity() != null) {
                                bArrA = a(httpResponseA.getEntity());
                            } else {
                                bArrA = new byte[0];
                            }
                            try {
                                if (statusCode < 200 || statusCode > 299) {
                                    throw new IOException();
                                }
                                return new dz(bArrA, treeMap, (byte) 0);
                            } catch (IOException e) {
                                e = e;
                                bArr = bArrA;
                                mapEmptyMap = treeMap;
                                if (httpResponseA != null) {
                                    int statusCode2 = httpResponseA.getStatusLine().getStatusCode();
                                    if (bArr != null) {
                                        new dz(bArr, mapEmptyMap, (byte) 0);
                                        if (statusCode2 == 401 || statusCode2 == 403) {
                                            dx.a aVar = dx.a.AUTH;
                                            a(eaVar, new dx((byte) 0));
                                        } else {
                                            dx.a aVar2 = dx.a.SERVER;
                                            throw new dx((byte) 0);
                                        }
                                    } else {
                                        dx.a aVar3 = dx.a.NETWORK;
                                        throw new dx((byte) 0);
                                    }
                                } else {
                                    dx.a aVar4 = dx.a.DEFAULT;
                                    throw new dx(e);
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            mapEmptyMap = treeMap;
                            bArr = null;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bArr = null;
                    }
                } catch (IOException e4) {
                    e = e4;
                    bArr = null;
                    httpResponseA = null;
                }
            } catch (MalformedURLException e5) {
                throw new RuntimeException("Bad URL " + eaVar.a(), e5);
            } catch (SocketTimeoutException e6) {
                dx.a aVar5 = dx.a.TIMEOUT;
                a(eaVar, new dx());
            } catch (ConnectTimeoutException e7) {
                dx.a aVar6 = dx.a.NO_CONNECTION;
                a(eaVar, new dx());
            }
        }
    }

    private static void a(ea<?> eaVar, dx dxVar) throws dx {
        try {
            eaVar.o().a(dxVar);
        } catch (dx e) {
            throw e;
        }
    }

    private static byte[] a(HttpEntity httpEntity) throws dx, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max((int) httpEntity.getContentLength(), 256));
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                dx.a aVar = dx.a.SERVER;
                throw new dx();
            }
            byte[] bArr = new byte[1024];
            while (true) {
                int i = content.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
            }
            byteArrayOutputStream.close();
        }
    }

    public static String a(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] strArrSplit = str2.split(";");
            for (int i = 1; i < strArrSplit.length; i++) {
                String[] strArrSplit2 = strArrSplit[i].trim().split("=");
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
            return str;
        }
        return str;
    }
}
