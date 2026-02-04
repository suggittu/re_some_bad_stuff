package com.yandex.metrica.impl.ob;

import com.google.android.gms.fitness.FitnessStatusCodes;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* loaded from: classes.dex */
public class dr implements ds {
    protected final HttpClient a;

    public dr(HttpClient httpClient) {
        this.a = httpClient;
    }

    private static void a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    private static void a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, ea<?> eaVar) throws dx {
        byte[] bArrC = eaVar.c();
        if (bArrC != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(bArrC));
        }
    }

    public static final class a extends HttpEntityEnclosingRequestBase {
        public a() {
        }

        public a(String str) {
            setURI(URI.create(str));
        }

        @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
        public String getMethod() {
            return "PATCH";
        }
    }

    @Override // com.yandex.metrica.impl.ob.ds
    public HttpResponse a(ea<?> eaVar) throws dx, IOException {
        HttpRequestBase httpTrace;
        switch (eaVar.d()) {
            case -1:
                byte[] bArrJ = eaVar.j();
                if (bArrJ != null) {
                    HttpPost httpPost = new HttpPost(eaVar.a());
                    httpPost.addHeader("Content-Type", eaVar.i());
                    httpPost.setEntity(new ByteArrayEntity(bArrJ));
                    httpTrace = httpPost;
                    break;
                } else {
                    httpTrace = new HttpGet(eaVar.a());
                    break;
                }
            case 0:
                httpTrace = new HttpGet(eaVar.a());
                break;
            case 1:
                HttpPost httpPost2 = new HttpPost(eaVar.a());
                httpPost2.addHeader("Content-Type", eaVar.m());
                a(httpPost2, eaVar);
                httpTrace = httpPost2;
                break;
            case 2:
                HttpPut httpPut = new HttpPut(eaVar.a());
                httpPut.addHeader("Content-Type", eaVar.m());
                a(httpPut, eaVar);
                httpTrace = httpPut;
                break;
            case 3:
                httpTrace = new HttpDelete(eaVar.a());
                break;
            case 4:
                httpTrace = new HttpHead(eaVar.a());
                break;
            case 5:
                httpTrace = new HttpOptions(eaVar.a());
                break;
            case 6:
                httpTrace = new HttpTrace(eaVar.a());
                break;
            case 7:
                a aVar = new a(eaVar.a());
                aVar.addHeader("Content-Type", eaVar.m());
                a(aVar, eaVar);
                httpTrace = aVar;
                break;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
        a(httpTrace, eaVar.b());
        HttpParams params = httpTrace.getParams();
        int iN = eaVar.n();
        HttpConnectionParams.setConnectionTimeout(params, FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS);
        HttpConnectionParams.setSoTimeout(params, iN);
        return this.a.execute(httpTrace);
    }
}
