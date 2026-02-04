package com.google.android.gms.common.images;

/* loaded from: classes2.dex */
public final class Size {
    private final int zzoG;
    private final int zzoH;

    public Size(int i, int i2) {
        this.zzoG = i;
        this.zzoH = i2;
    }

    public static Size parseSize(String str) {
        if (str == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int iIndexOf = str.indexOf(42);
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(120);
        }
        if (iIndexOf < 0) {
            throw zzcC(str);
        }
        try {
            return new Size(Integer.parseInt(str.substring(0, iIndexOf)), Integer.parseInt(str.substring(iIndexOf + 1)));
        } catch (NumberFormatException e) {
            throw zzcC(str);
        }
    }

    private static NumberFormatException zzcC(String str) {
        throw new NumberFormatException("Invalid Size: \"" + str + "\"");
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.zzoG == size.zzoG && this.zzoH == size.zzoH;
    }

    public final int getHeight() {
        return this.zzoH;
    }

    public final int getWidth() {
        return this.zzoG;
    }

    public final int hashCode() {
        return this.zzoH ^ ((this.zzoG << 16) | (this.zzoG >>> 16));
    }

    public final String toString() {
        return this.zzoG + "x" + this.zzoH;
    }
}
