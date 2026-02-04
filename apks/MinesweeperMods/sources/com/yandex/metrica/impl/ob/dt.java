package com.yandex.metrica.impl.ob;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* loaded from: classes.dex */
public class dt implements ds {
    private final SSLSocketFactory a;

    public dt() {
        this(null);
    }

    public dt(SSLSocketFactory sSLSocketFactory) {
        this.a = sSLSocketFactory;
    }

    @Override // com.yandex.metrica.impl.ob.ds
    public HttpResponse a(ea<?> eaVar) throws dx, IOException {
        String strA = eaVar.a();
        HashMap map = new HashMap();
        map.putAll(eaVar.b());
        URL url = new URL(strA);
        HttpURLConnection httpURLConnectionA = a(url);
        int iN = eaVar.n();
        httpURLConnectionA.setConnectTimeout(iN);
        httpURLConnectionA.setReadTimeout(iN);
        httpURLConnectionA.setUseCaches(false);
        httpURLConnectionA.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.a != null) {
            ((HttpsURLConnection) httpURLConnectionA).setSSLSocketFactory(this.a);
        }
        for (String str : map.keySet()) {
            httpURLConnectionA.addRequestProperty(str, (String) map.get(str));
        }
        switch (eaVar.d()) {
            case -1:
                byte[] bArrJ = eaVar.j();
                if (bArrJ != null) {
                    httpURLConnectionA.setDoOutput(true);
                    httpURLConnectionA.setRequestMethod("POST");
                    httpURLConnectionA.addRequestProperty("Content-Type", eaVar.i());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnectionA.getOutputStream());
                    dataOutputStream.write(bArrJ);
                    dataOutputStream.close();
                    break;
                }
                break;
            case 0:
                httpURLConnectionA.setRequestMethod("GET");
                break;
            case 1:
                httpURLConnectionA.setRequestMethod("POST");
                a(httpURLConnectionA, eaVar);
                break;
            case 2:
                httpURLConnectionA.setRequestMethod("PUT");
                a(httpURLConnectionA, eaVar);
                break;
            case 3:
                httpURLConnectionA.setRequestMethod("DELETE");
                break;
            case 4:
                httpURLConnectionA.setRequestMethod("HEAD");
                break;
            case 5:
                httpURLConnectionA.setRequestMethod("OPTIONS");
                break;
            case 6:
                httpURLConnectionA.setRequestMethod("TRACE");
                break;
            case 7:
                httpURLConnectionA.setRequestMethod("PATCH");
                a(httpURLConnectionA, eaVar);
                break;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (httpURLConnectionA.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, httpURLConnectionA.getResponseCode(), httpURLConnectionA.getResponseMessage()));
        basicHttpResponse.setEntity(a(httpURLConnectionA));
        for (Map.Entry<String, List<String>> entry : httpURLConnectionA.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader(entry.getKey(), entry.getValue().get(0)));
            }
        }
        return basicHttpResponse;
    }

    private static HttpEntity a(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            errorStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(errorStream);
        basicHttpEntity.setContentLength(httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    protected HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private static void a(HttpURLConnection httpURLConnection, ea<?> eaVar) throws dx, IOException {
        byte[] bArrC = eaVar.c();
        if (bArrC != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", eaVar.m());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bArrC);
            dataOutputStream.close();
        }
    }
}
