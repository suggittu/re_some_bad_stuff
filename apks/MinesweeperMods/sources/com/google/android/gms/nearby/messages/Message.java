package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.NearbyDevice;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class Message implements SafeParcelable {
    public static final int MAX_CONTENT_SIZE_BYTES = 102400;
    public static final int MAX_TYPE_LENGTH = 32;
    private final byte[] content;
    private final String type;
    final int versionCode;
    private final String zzamD;
    private final NearbyDevice[] zzbbA;
    public static final Parcelable.Creator CREATOR = new zza();
    private static final NearbyDevice[] zzbbz = {NearbyDevice.zzbcd};

    Message(int i, byte[] bArr, String str, String str2, NearbyDevice[] nearbyDeviceArr) {
        this.versionCode = i;
        this.type = (String) zzx.zzz(str2);
        this.zzamD = str == null ? "" : str;
        if (zzR(this.zzamD, this.type)) {
            zzx.zzb(bArr == null, "Content must be null for a device presence message.");
        } else {
            zzx.zzz(bArr);
            zzx.zzb(bArr.length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(bArr.length), Integer.valueOf(MAX_CONTENT_SIZE_BYTES));
        }
        this.content = bArr;
        this.zzbbA = (nearbyDeviceArr == null || nearbyDeviceArr.length == 0) ? zzbbz : nearbyDeviceArr;
        zzx.zzb(str2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(str2.length()), 32);
    }

    public Message(byte[] bArr) {
        this(bArr, "", "");
    }

    public Message(byte[] bArr, String str) {
        this(bArr, "", str);
    }

    public Message(byte[] bArr, String str, String str2) {
        this(bArr, str, str2, zzbbz);
    }

    public Message(byte[] bArr, String str, String str2, NearbyDevice[] nearbyDeviceArr) {
        this(2, bArr, str, str2, nearbyDeviceArr);
    }

    public static boolean zzR(String str, String str2) {
        return str.equals("__reserved_namespace") && str2.equals("__device_presence");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return TextUtils.equals(this.zzamD, message.zzamD) && TextUtils.equals(this.type, message.type) && Arrays.equals(this.content, message.content);
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getNamespace() {
        return this.zzamD;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzamD, this.type, Integer.valueOf(Arrays.hashCode(this.content)));
    }

    public String toString() {
        return "Message{namespace='" + this.zzamD + "', type='" + this.type + "', content=[" + (this.content == null ? 0 : this.content.length) + " bytes], devices=" + Arrays.toString(zzEn()) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public NearbyDevice[] zzEn() {
        return this.zzbbA;
    }
}
