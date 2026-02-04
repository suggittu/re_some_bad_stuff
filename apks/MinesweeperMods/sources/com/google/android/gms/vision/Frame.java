package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class Frame {
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 2;
    public static final int ROTATION_270 = 3;
    public static final int ROTATION_90 = 1;
    private Bitmap mBitmap;
    private Metadata zzbni;
    private ByteBuffer zzbnj;

    public class Builder {
        private Frame zzbnk = new Frame();

        public Frame build() {
            if (this.zzbnk.zzbnj == null && this.zzbnk.mBitmap == null) {
                throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
            }
            return this.zzbnk;
        }

        public Builder setBitmap(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            this.zzbnk.mBitmap = bitmap;
            Metadata metadata = this.zzbnk.getMetadata();
            metadata.zzoG = width;
            metadata.zzoH = height;
            return this;
        }

        public Builder setId(int i) {
            this.zzbnk.getMetadata().mId = i;
            return this;
        }

        public Builder setImageData(ByteBuffer byteBuffer, int i, int i2, int i3) {
            if (byteBuffer == null) {
                throw new IllegalArgumentException("Null image data supplied.");
            }
            if (byteBuffer.capacity() < i * i2) {
                throw new IllegalArgumentException("Invalid image data size.");
            }
            switch (i3) {
                case 16:
                case 17:
                case 842094169:
                    this.zzbnk.zzbnj = byteBuffer;
                    Metadata metadata = this.zzbnk.getMetadata();
                    metadata.zzoG = i;
                    metadata.zzoH = i2;
                    return this;
                default:
                    throw new IllegalArgumentException("Unsupported image format: " + i3);
            }
        }

        public Builder setRotation(int i) {
            this.zzbnk.getMetadata().zzDE = i;
            return this;
        }

        public Builder setTimestampMillis(long j) {
            this.zzbnk.getMetadata().zzaJi = j;
            return this;
        }
    }

    public class Metadata {
        private int mId;
        private int zzDE;
        private long zzaJi;
        private int zzoG;
        private int zzoH;

        public Metadata() {
        }

        public Metadata(Metadata metadata) {
            this.zzoG = metadata.getWidth();
            this.zzoH = metadata.getHeight();
            this.mId = metadata.getId();
            this.zzaJi = metadata.getTimestampMillis();
            this.zzDE = metadata.getRotation();
        }

        public int getHeight() {
            return this.zzoH;
        }

        public int getId() {
            return this.mId;
        }

        public int getRotation() {
            return this.zzDE;
        }

        public long getTimestampMillis() {
            return this.zzaJi;
        }

        public int getWidth() {
            return this.zzoG;
        }

        public void zzIf() {
            if (this.zzDE % 2 != 0) {
                int i = this.zzoG;
                this.zzoG = this.zzoH;
                this.zzoH = i;
            }
            this.zzDE = 0;
        }
    }

    private Frame() {
        this.zzbni = new Metadata();
        this.zzbnj = null;
        this.mBitmap = null;
    }

    private ByteBuffer zzIe() {
        int width = this.mBitmap.getWidth();
        int height = this.mBitmap.getHeight();
        int[] iArr = new int[width * height];
        this.mBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[width * height];
        for (int i = 0; i < iArr.length; i++) {
            bArr[i] = (byte) ((Color.red(iArr[i]) * 0.299f) + (Color.green(iArr[i]) * 0.587f) + (Color.blue(iArr[i]) * 0.114f));
        }
        return ByteBuffer.wrap(bArr);
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public ByteBuffer getGrayscaleImageData() {
        return this.mBitmap != null ? zzIe() : this.zzbnj;
    }

    public Metadata getMetadata() {
        return this.zzbni;
    }
}
