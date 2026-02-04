package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
class zzah extends zzd {
    private static final byte[] zzTd = "\n".getBytes();
    private final zzaj zzTc;
    private final String zzzN;

    class zza {
        private int zzTe;
        private ByteArrayOutputStream zzTf = new ByteArrayOutputStream();

        public zza() {
        }

        public byte[] getPayload() {
            return this.zzTf.toByteArray();
        }

        public boolean zzj(zzab zzabVar) {
            com.google.android.gms.common.internal.zzx.zzz(zzabVar);
            if (this.zzTe + 1 > zzah.this.zzjn().zzkD()) {
                return false;
            }
            String strZza = zzah.this.zza(zzabVar, false);
            if (strZza == null) {
                zzah.this.zzjm().zza(zzabVar, "Error formatting hit");
                return true;
            }
            byte[] bytes = strZza.getBytes();
            int length = bytes.length;
            if (length > zzah.this.zzjn().zzkv()) {
                zzah.this.zzjm().zza(zzabVar, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.zzTf.size() > 0) {
                length++;
            }
            if (length + this.zzTf.size() > zzah.this.zzjn().zzkx()) {
                return false;
            }
            try {
                if (this.zzTf.size() > 0) {
                    this.zzTf.write(zzah.zzTd);
                }
                this.zzTf.write(bytes);
                this.zzTe++;
                return true;
            } catch (IOException e) {
                zzah.this.zze("Failed to write payload when batching hits", e);
                return true;
            }
        }

        public int zzlE() {
            return this.zzTe;
        }
    }

    zzah(zzf zzfVar) {
        super(zzfVar);
        this.zzzN = zza("GoogleAnalytics", zze.VERSION, Build.VERSION.RELEASE, zzam.zza(Locale.getDefault()), Build.MODEL, Build.ID);
        this.zzTc = new zzaj(zzfVar.zzjl());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int zza(java.net.URL r6, byte[] r7) throws java.lang.Throwable {
        /*
            r5 = this;
            r1 = 0
            com.google.android.gms.common.internal.zzx.zzz(r6)
            com.google.android.gms.common.internal.zzx.zzz(r7)
            java.lang.String r0 = "POST bytes, url"
            int r2 = r7.length
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5.zzb(r0, r2, r6)
            boolean r0 = r5.zzhp()
            if (r0 == 0) goto L21
            java.lang.String r0 = "Post payload\n"
            java.lang.String r2 = new java.lang.String
            r2.<init>(r7)
            r5.zza(r0, r2)
        L21:
            java.net.HttpURLConnection r2 = r5.zzc(r6)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L7e
            r0 = 1
            r2.setDoOutput(r0)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            int r0 = r7.length     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r2.setFixedLengthStreamingMode(r0)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r2.connect()     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            java.io.OutputStream r1 = r2.getOutputStream()     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r1.write(r7)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r5.zzb(r2)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            int r0 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 != r3) goto L49
            com.google.android.gms.analytics.internal.zzb r3 = r5.zziH()     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r3.zzjh()     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
        L49:
            java.lang.String r3 = "POST status"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            r5.zzb(r3, r4)     // Catch: java.lang.Throwable -> L92 java.io.IOException -> L94
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.io.IOException -> L5d
        L57:
            if (r2 == 0) goto L5c
            r2.disconnect()
        L5c:
            return r0
        L5d:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.zze(r3, r1)
            goto L57
        L64:
            r0 = move-exception
            r2 = r1
        L66:
            java.lang.String r3 = "Network POST connection error"
            r5.zzd(r3, r0)     // Catch: java.lang.Throwable -> L92
            if (r1 == 0) goto L70
            r1.close()     // Catch: java.io.IOException -> L77
        L70:
            if (r2 == 0) goto L75
            r2.disconnect()
        L75:
            r0 = 0
            goto L5c
        L77:
            r0 = move-exception
            java.lang.String r1 = "Error closing http post connection output stream"
            r5.zze(r1, r0)
            goto L70
        L7e:
            r0 = move-exception
            r2 = r1
        L80:
            if (r1 == 0) goto L85
            r1.close()     // Catch: java.io.IOException -> L8b
        L85:
            if (r2 == 0) goto L8a
            r2.disconnect()
        L8a:
            throw r0
        L8b:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.zze(r3, r1)
            goto L85
        L92:
            r0 = move-exception
            goto L80
        L94:
            r0 = move-exception
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzah.zza(java.net.URL, byte[]):int");
    }

    private static String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", str, str2, str3, str4, str5, str6);
    }

    private void zza(StringBuilder sb, String str, String str2) {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private int zzb(URL url) {
        com.google.android.gms.common.internal.zzx.zzz(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnectionZzc = null;
        try {
            try {
                httpURLConnectionZzc = zzc(url);
                httpURLConnectionZzc.connect();
                zzb(httpURLConnectionZzc);
                int responseCode = httpURLConnectionZzc.getResponseCode();
                if (responseCode == 200) {
                    zziH().zzjh();
                }
                zzb("GET status", Integer.valueOf(responseCode));
                if (httpURLConnectionZzc == null) {
                    return responseCode;
                }
                httpURLConnectionZzc.disconnect();
                return responseCode;
            } catch (IOException e) {
                zzd("Network GET connection error", e);
                if (httpURLConnectionZzc != null) {
                    httpURLConnectionZzc.disconnect();
                }
                return 0;
            }
        } catch (Throwable th) {
            if (httpURLConnectionZzc != null) {
                httpURLConnectionZzc.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int zzb(java.net.URL r9, byte[] r10) throws java.lang.Throwable {
        /*
            r8 = this;
            r1 = 0
            com.google.android.gms.common.internal.zzx.zzz(r9)
            com.google.android.gms.common.internal.zzx.zzz(r10)
            byte[] r0 = zzg(r10)     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            java.lang.String r2 = "POST compressed size, ratio %, url"
            int r3 = r0.length     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            r4 = 100
            int r6 = r0.length     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            long r6 = (long) r6     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            long r4 = r4 * r6
            int r6 = r10.length     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            long r6 = (long) r6     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            long r4 = r4 / r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            r8.zza(r2, r3, r4, r9)     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            int r2 = r0.length     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            int r3 = r10.length     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            if (r2 <= r3) goto L34
            java.lang.String r2 = "Compressed payload is larger then uncompressed. compressed, uncompressed"
            int r3 = r0.length     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            int r4 = r10.length     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            r8.zzc(r2, r3, r4)     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
        L34:
            boolean r2 = r8.zzhp()     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            if (r2 == 0) goto L53
            java.lang.String r2 = "Post payload"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            java.lang.String r4 = "\n"
            r3.<init>(r4)     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            java.lang.String r4 = new java.lang.String     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            r4.<init>(r10)     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            java.lang.String r3 = r3.toString()     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            r8.zza(r2, r3)     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
        L53:
            java.net.HttpURLConnection r3 = r8.zzc(r9)     // Catch: java.io.IOException -> L94 java.lang.Throwable -> Lae
            r2 = 1
            r3.setDoOutput(r2)     // Catch: java.lang.Throwable -> Lc2 java.io.IOException -> Lca
            java.lang.String r2 = "Content-Encoding"
            java.lang.String r4 = "gzip"
            r3.addRequestProperty(r2, r4)     // Catch: java.lang.Throwable -> Lc2 java.io.IOException -> Lca
            int r2 = r0.length     // Catch: java.lang.Throwable -> Lc2 java.io.IOException -> Lca
            r3.setFixedLengthStreamingMode(r2)     // Catch: java.lang.Throwable -> Lc2 java.io.IOException -> Lca
            r3.connect()     // Catch: java.lang.Throwable -> Lc2 java.io.IOException -> Lca
            java.io.OutputStream r2 = r3.getOutputStream()     // Catch: java.lang.Throwable -> Lc2 java.io.IOException -> Lca
            r2.write(r0)     // Catch: java.lang.Throwable -> Lc4 java.io.IOException -> Lcd
            r2.close()     // Catch: java.lang.Throwable -> Lc4 java.io.IOException -> Lcd
            r8.zzb(r3)     // Catch: java.lang.Throwable -> Lc2 java.io.IOException -> Lca
            int r0 = r3.getResponseCode()     // Catch: java.lang.Throwable -> Lc2 java.io.IOException -> Lca
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 != r2) goto L85
            com.google.android.gms.analytics.internal.zzb r2 = r8.zziH()     // Catch: java.lang.Throwable -> Lc2 java.io.IOException -> Lca
            r2.zzjh()     // Catch: java.lang.Throwable -> Lc2 java.io.IOException -> Lca
        L85:
            java.lang.String r2 = "POST status"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> Lc2 java.io.IOException -> Lca
            r8.zzb(r2, r4)     // Catch: java.lang.Throwable -> Lc2 java.io.IOException -> Lca
            if (r3 == 0) goto L93
            r3.disconnect()
        L93:
            return r0
        L94:
            r0 = move-exception
            r2 = r1
        L96:
            java.lang.String r3 = "Network compressed POST connection error"
            r8.zzd(r3, r0)     // Catch: java.lang.Throwable -> Lc7
            if (r1 == 0) goto La0
            r1.close()     // Catch: java.io.IOException -> La7
        La0:
            if (r2 == 0) goto La5
            r2.disconnect()
        La5:
            r0 = 0
            goto L93
        La7:
            r0 = move-exception
            java.lang.String r1 = "Error closing http compressed post connection output stream"
            r8.zze(r1, r0)
            goto La0
        Lae:
            r0 = move-exception
            r3 = r1
        Lb0:
            if (r1 == 0) goto Lb5
            r1.close()     // Catch: java.io.IOException -> Lbb
        Lb5:
            if (r3 == 0) goto Lba
            r3.disconnect()
        Lba:
            throw r0
        Lbb:
            r1 = move-exception
            java.lang.String r2 = "Error closing http compressed post connection output stream"
            r8.zze(r2, r1)
            goto Lb5
        Lc2:
            r0 = move-exception
            goto Lb0
        Lc4:
            r0 = move-exception
            r1 = r2
            goto Lb0
        Lc7:
            r0 = move-exception
            r3 = r2
            goto Lb0
        Lca:
            r0 = move-exception
            r2 = r3
            goto L96
        Lcd:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L96
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzah.zzb(java.net.URL, byte[]):int");
    }

    private URL zzb(zzab zzabVar, String str) {
        try {
            return new URL(zzabVar.zzlt() ? zzjn().zzkF() + zzjn().zzkH() + "?" + str : zzjn().zzkG() + zzjn().zzkH() + "?" + str);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void zzb(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    zze("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    zze("Error closing http connection input stream", e2);
                }
            }
            throw th;
        }
    }

    private boolean zzg(zzab zzabVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzabVar);
        String strZza = zza(zzabVar, !zzabVar.zzlt());
        if (strZza == null) {
            zzjm().zza(zzabVar, "Error formatting hit for upload");
            return true;
        }
        if (strZza.length() <= zzjn().zzku()) {
            URL urlZzb = zzb(zzabVar, strZza);
            if (urlZzb != null) {
                return zzb(urlZzb) == 200;
            }
            zzbh("Failed to build collect GET endpoint url");
            return false;
        }
        String strZza2 = zza(zzabVar, false);
        if (strZza2 == null) {
            zzjm().zza(zzabVar, "Error formatting hit for POST upload");
            return true;
        }
        byte[] bytes = strZza2.getBytes();
        if (bytes.length > zzjn().zzkw()) {
            zzjm().zza(zzabVar, "Hit payload exceeds size limit");
            return true;
        }
        URL urlZzh = zzh(zzabVar);
        if (urlZzh != null) {
            return zza(urlZzh, bytes) == 200;
        }
        zzbh("Failed to build collect POST endpoint url");
        return false;
    }

    private static byte[] zzg(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private URL zzh(zzab zzabVar) {
        try {
            return new URL(zzabVar.zzlt() ? zzjn().zzkF() + zzjn().zzkH() : zzjn().zzkG() + zzjn().zzkH());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private String zzi(zzab zzabVar) {
        return String.valueOf(zzabVar.zzlq());
    }

    private URL zzlC() {
        try {
            return new URL(zzjn().zzkF() + zzjn().zzkI());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    String zza(zzab zzabVar, boolean z) {
        com.google.android.gms.common.internal.zzx.zzz(zzabVar);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry entry : zzabVar.zzn().entrySet()) {
                String str = (String) entry.getKey();
                if (!"ht".equals(str) && !"qt".equals(str) && !"AppUID".equals(str) && !"z".equals(str) && !"_gmsv".equals(str)) {
                    zza(sb, str, (String) entry.getValue());
                }
            }
            zza(sb, "ht", String.valueOf(zzabVar.zzlr()));
            zza(sb, "qt", String.valueOf(zzjl().currentTimeMillis() - zzabVar.zzlr()));
            if (zzjn().zzkr()) {
                zza(sb, "_gmsv", zze.VERSION);
            }
            if (z) {
                long jZzlu = zzabVar.zzlu();
                zza(sb, "z", jZzlu != 0 ? String.valueOf(jZzlu) : zzi(zzabVar));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    List zza(List list, boolean z) {
        com.google.android.gms.common.internal.zzx.zzac(!list.isEmpty());
        zza("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        zza zzaVar = new zza();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzab zzabVar = (zzab) it.next();
            if (!zzaVar.zzj(zzabVar)) {
                break;
            }
            arrayList.add(Long.valueOf(zzabVar.zzlq()));
        }
        if (zzaVar.zzlE() == 0) {
            return arrayList;
        }
        URL urlZzlC = zzlC();
        if (urlZzlC == null) {
            zzbh("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int iZzb = z ? zzb(urlZzlC, zzaVar.getPayload()) : zza(urlZzlC, zzaVar.getPayload());
        if (200 == iZzb) {
            zza("Batched upload completed. Hits batched", Integer.valueOf(zzaVar.zzlE()));
            return arrayList;
        }
        zza("Network error uploading hits. status code", Integer.valueOf(iZzb));
        if (zzjn().zzkL().contains(Integer.valueOf(iZzb))) {
            zzbg("Server instructed the client to stop batching");
            this.zzTc.start();
        }
        return Collections.emptyList();
    }

    HttpURLConnection zzc(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(zzjn().zzkU());
        httpURLConnection.setReadTimeout(zzjn().zzkV());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.zzzN);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
        zza("Network initialized. User agent", this.zzzN);
    }

    public boolean zzlB() {
        NetworkInfo activeNetworkInfo;
        zzjk();
        zzjv();
        try {
            activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbd("No network connectivity");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List zzq(java.util.List r9) {
        /*
            r8 = this;
            r1 = 1
            r2 = 0
            r8.zzjk()
            r8.zzjv()
            com.google.android.gms.common.internal.zzx.zzz(r9)
            com.google.android.gms.analytics.internal.zzr r0 = r8.zzjn()
            java.util.Set r0 = r0.zzkL()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L2c
            com.google.android.gms.analytics.internal.zzaj r0 = r8.zzTc
            com.google.android.gms.analytics.internal.zzr r3 = r8.zzjn()
            long r4 = r3.zzkE()
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r6
            boolean r0 = r0.zzv(r4)
            if (r0 != 0) goto L35
        L2c:
            r0 = r2
        L2d:
            r1 = r2
        L2e:
            if (r0 == 0) goto L51
            java.util.List r0 = r8.zza(r9, r1)
        L34:
            return r0
        L35:
            com.google.android.gms.analytics.internal.zzr r0 = r8.zzjn()
            com.google.android.gms.analytics.internal.zzm r0 = r0.zzkJ()
            com.google.android.gms.analytics.internal.zzm r3 = com.google.android.gms.analytics.internal.zzm.NONE
            if (r0 == r3) goto L4f
            r0 = r1
        L42:
            com.google.android.gms.analytics.internal.zzr r3 = r8.zzjn()
            com.google.android.gms.analytics.internal.zzo r3 = r3.zzkK()
            com.google.android.gms.analytics.internal.zzo r4 = com.google.android.gms.analytics.internal.zzo.GZIP
            if (r3 != r4) goto L2d
            goto L2e
        L4f:
            r0 = r2
            goto L42
        L51:
            java.util.List r0 = r8.zzr(r9)
            goto L34
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzah.zzq(java.util.List):java.util.List");
    }

    List zzr(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzab zzabVar = (zzab) it.next();
            if (!zzg(zzabVar)) {
                break;
            }
            arrayList.add(Long.valueOf(zzabVar.zzlq()));
            if (arrayList.size() >= zzjn().zzkC()) {
                break;
            }
        }
        return arrayList;
    }
}
