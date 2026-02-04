package com.google.android.gms.internal;

import java.util.Map;

/* loaded from: classes2.dex */
public class zzi {
    public final byte[] data;
    public final int statusCode;
    public final Map zzA;
    public final boolean zzB;
    public final long zzC;

    public zzi(int i, byte[] bArr, Map map, boolean z, long j) {
        this.statusCode = i;
        this.data = bArr;
        this.zzA = map;
        this.zzB = z;
        this.zzC = j;
    }

    public zzi(byte[] bArr, Map map) {
        this(200, bArr, map, false, 0L);
    }
}
