package com.google.android.gms.vision;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.vision.Frame;
import java.lang.Thread;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class CameraSource {

    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_BACK = 0;

    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_FRONT = 1;
    private Context mContext;
    private int zzDE;
    private Camera zzbmA;
    private int zzbmB;
    private Size zzbmC;
    private float zzbmD;
    private int zzbmE;
    private int zzbmF;
    private boolean zzbmG;
    private SurfaceView zzbmH;
    private SurfaceTexture zzbmI;
    private boolean zzbmJ;
    private Thread zzbmK;
    private zzb zzbmL;
    private Map zzbmM;
    private final Object zzbmz;

    public class Builder {
        private final Detector zzbmN;
        private CameraSource zzbmO = new CameraSource();

        public Builder(Context context, Detector detector) {
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            }
            if (detector == null) {
                throw new IllegalArgumentException("No detector supplied.");
            }
            this.zzbmN = detector;
            this.zzbmO.mContext = context;
        }

        public CameraSource build() {
            CameraSource cameraSource = this.zzbmO;
            CameraSource cameraSource2 = this.zzbmO;
            cameraSource2.getClass();
            cameraSource.zzbmL = cameraSource2.new zzb(this.zzbmN);
            return this.zzbmO;
        }

        public Builder setAutoFocusEnabled(boolean z) {
            this.zzbmO.zzbmG = z;
            return this;
        }

        public Builder setFacing(int i) {
            if (i != 0 && i != 1) {
                throw new IllegalArgumentException("Invalid camera: " + i);
            }
            this.zzbmO.zzbmB = i;
            return this;
        }

        public Builder setRequestedFps(float f) {
            if (f <= 0.0f) {
                throw new IllegalArgumentException("Invalid fps: " + f);
            }
            this.zzbmO.zzbmD = f;
            return this;
        }

        public Builder setRequestedPreviewSize(int i, int i2) {
            if (i <= 0 || i > 1000000 || i2 <= 0 || i2 > 1000000) {
                throw new IllegalArgumentException("Invalid preview size: " + i + "x" + i2);
            }
            this.zzbmO.zzbmE = i;
            this.zzbmO.zzbmF = i2;
            return this;
        }
    }

    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    public interface ShutterCallback {
        void onShutter();
    }

    class zza implements Camera.PreviewCallback {
        private zza() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraSource.this.zzbmL.zza(bArr, camera);
        }
    }

    class zzb implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled;
        private Detector zzbmN;
        private long zzbmR;
        private ByteBuffer zzbmT;
        private long zzRD = SystemClock.elapsedRealtime();
        private final Object zzpV = new Object();
        private boolean zzbmQ = true;
        private int zzbmS = 0;

        static {
            $assertionsDisabled = !CameraSource.class.desiredAssertionStatus();
        }

        zzb(Detector detector) {
            this.zzbmN = detector;
        }

        @SuppressLint({"Assert"})
        void release() {
            if (!$assertionsDisabled && CameraSource.this.zzbmK.getState() != Thread.State.TERMINATED) {
                throw new AssertionError();
            }
            this.zzbmN.release();
            this.zzbmN = null;
        }

        @Override // java.lang.Runnable
        @SuppressLint({"InlinedApi"})
        public void run() {
            Frame frameBuild;
            ByteBuffer byteBuffer;
            while (true) {
                synchronized (this.zzpV) {
                    if (this.zzbmQ && this.zzbmT == null) {
                        try {
                            this.zzpV.wait();
                        } catch (InterruptedException e) {
                            Log.d("CameraSource", "Frame processing loop terminated.", e);
                            return;
                        }
                    }
                    if (!this.zzbmQ) {
                        return;
                    }
                    frameBuild = new Frame.Builder().setImageData(this.zzbmT, CameraSource.this.zzbmC.getWidth(), CameraSource.this.zzbmC.getHeight(), 17).setId(this.zzbmS).setTimestampMillis(this.zzbmR).setRotation(CameraSource.this.zzDE).build();
                    byteBuffer = this.zzbmT;
                    this.zzbmT = null;
                }
                try {
                    this.zzbmN.receiveFrame(frameBuild);
                } catch (Throwable th) {
                    Log.e("CameraSource", "Exception thrown from receiver.", th);
                } finally {
                    CameraSource.this.zzbmA.addCallbackBuffer(byteBuffer.array());
                }
            }
        }

        void setActive(boolean z) {
            synchronized (this.zzpV) {
                this.zzbmQ = z;
                this.zzpV.notifyAll();
            }
        }

        void zza(byte[] bArr, Camera camera) {
            synchronized (this.zzpV) {
                if (this.zzbmT != null) {
                    camera.addCallbackBuffer(this.zzbmT.array());
                    this.zzbmT = null;
                }
                this.zzbmR = SystemClock.elapsedRealtime() - this.zzRD;
                this.zzbmS++;
                this.zzbmT = (ByteBuffer) CameraSource.this.zzbmM.get(bArr);
                this.zzpV.notifyAll();
            }
        }
    }

    class zzc implements Camera.PictureCallback {
        private PictureCallback zzbmU;

        private zzc() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            if (this.zzbmU != null) {
                this.zzbmU.onPictureTaken(bArr);
            }
            synchronized (CameraSource.this.zzbmz) {
                if (CameraSource.this.zzbmA != null) {
                    CameraSource.this.zzbmA.startPreview();
                }
            }
        }
    }

    class zzd implements Camera.ShutterCallback {
        private ShutterCallback zzbmV;

        private zzd() {
        }

        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            if (this.zzbmV != null) {
                this.zzbmV.onShutter();
            }
        }
    }

    class zze {
        private Size zzbmW;
        private Size zzbmX;

        public zze(Camera.Size size, Camera.Size size2) {
            this.zzbmW = new Size(size.width, size.height);
            this.zzbmX = new Size(size2.width, size2.height);
        }

        public Size zzIc() {
            return this.zzbmW;
        }

        public Size zzId() {
            return this.zzbmX;
        }
    }

    private CameraSource() {
        this.zzbmz = new Object();
        this.zzbmB = 0;
        this.zzbmD = 30.0f;
        this.zzbmE = 1024;
        this.zzbmF = 768;
        this.zzbmG = false;
        this.zzbmM = new HashMap();
    }

    @SuppressLint({"InlinedApi"})
    private Camera zzIb() {
        int iZzkp = zzkp(this.zzbmB);
        if (iZzkp == -1) {
            throw new RuntimeException("Could not find requested camera.");
        }
        Camera cameraOpen = Camera.open(iZzkp);
        zze zzeVarZza = zza(cameraOpen, this.zzbmE, this.zzbmF);
        if (zzeVarZza == null) {
            throw new RuntimeException("Could not find suitable preview size.");
        }
        Size sizeZzId = zzeVarZza.zzId();
        this.zzbmC = zzeVarZza.zzIc();
        int[] iArrZza = zza(cameraOpen, this.zzbmD);
        if (iArrZza == null) {
            throw new RuntimeException("Could not find suitable preview frames per second range.");
        }
        Camera.Parameters parameters = cameraOpen.getParameters();
        parameters.setPictureSize(sizeZzId.getWidth(), sizeZzId.getHeight());
        parameters.setPreviewSize(this.zzbmC.getWidth(), this.zzbmC.getHeight());
        parameters.setPreviewFpsRange(iArrZza[0], iArrZza[1]);
        parameters.setPreviewFormat(17);
        zza(cameraOpen, parameters, iZzkp);
        if (this.zzbmG) {
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            } else {
                Log.i("CameraSource", "Camera auto focus is not supported on this device.");
            }
        }
        cameraOpen.setParameters(parameters);
        cameraOpen.setPreviewCallbackWithBuffer(new zza());
        cameraOpen.addCallbackBuffer(zza(this.zzbmC));
        cameraOpen.addCallbackBuffer(zza(this.zzbmC));
        cameraOpen.addCallbackBuffer(zza(this.zzbmC));
        cameraOpen.addCallbackBuffer(zza(this.zzbmC));
        return cameraOpen;
    }

    private static zze zza(Camera camera, int i, int i2) {
        int i3;
        zze zzeVar;
        List<zze> listZza = zza(camera);
        zze zzeVar2 = null;
        int i4 = Strategy.TTL_SECONDS_INFINITE;
        for (zze zzeVar3 : listZza) {
            Size sizeZzIc = zzeVar3.zzIc();
            int iAbs = Math.abs(sizeZzIc.getHeight() - i2) + Math.abs(sizeZzIc.getWidth() - i);
            if (iAbs < i4) {
                zzeVar = zzeVar3;
                i3 = iAbs;
            } else {
                i3 = i4;
                zzeVar = zzeVar2;
            }
            i4 = i3;
            zzeVar2 = zzeVar;
        }
        return zzeVar2;
    }

    private static List zza(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : supportedPreviewSizes) {
            float f = size.width / size.height;
            Iterator<Camera.Size> it = supportedPictureSizes.iterator();
            while (true) {
                if (it.hasNext()) {
                    Camera.Size next = it.next();
                    if (Math.abs(f - (next.width / next.height)) < 0.01f) {
                        arrayList.add(new zze(size, next));
                        break;
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            Log.w("CameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
            Iterator<Camera.Size> it2 = supportedPreviewSizes.iterator();
            while (it2.hasNext()) {
                arrayList.add(new zze(it2.next(), null));
            }
        }
        return arrayList;
    }

    private void zza(Camera camera, Camera.Parameters parameters, int i) {
        int i2;
        int i3;
        int i4;
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        switch (rotation) {
            case 0:
                i2 = 0;
                break;
            case 1:
                i2 = 90;
                break;
            case 2:
                i2 = 180;
                break;
            case 3:
                i2 = 270;
                break;
            default:
                Log.e("CameraSource", "Bad rotation value: " + rotation);
                i2 = 0;
                break;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == 1) {
            i4 = (i2 + cameraInfo.orientation) % 360;
            i3 = (360 - i4) % 360;
        } else {
            i3 = ((cameraInfo.orientation - i2) + 360) % 360;
            i4 = i3;
        }
        this.zzDE = i4 / 90;
        camera.setDisplayOrientation(i3);
        parameters.setRotation(i4);
    }

    @SuppressLint({"InlinedApi"})
    private byte[] zza(Size size) {
        byte[] bArr = new byte[((int) Math.ceil((ImageFormat.getBitsPerPixel(17) * (size.getHeight() * size.getWidth())) / 8.0d)) + 1];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (!byteBufferWrap.hasArray() || byteBufferWrap.array() != bArr) {
            throw new IllegalStateException("Failed to create valid buffer for camera source.");
        }
        this.zzbmM.put(bArr, byteBufferWrap);
        return bArr;
    }

    @SuppressLint({"InlinedApi"})
    private int[] zza(Camera camera, float f) {
        int i;
        int[] iArr;
        int i2 = (int) (1000.0f * f);
        int[] iArr2 = null;
        int i3 = Strategy.TTL_SECONDS_INFINITE;
        for (int[] iArr3 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int iAbs = Math.abs(i2 - iArr3[0]) + Math.abs(i2 - iArr3[1]);
            if (iAbs < i3) {
                iArr = iArr3;
                i = iAbs;
            } else {
                i = i3;
                iArr = iArr2;
            }
            i3 = i;
            iArr2 = iArr;
        }
        return iArr2;
    }

    private static int zzkp(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    public int getCameraFacing() {
        return this.zzbmB;
    }

    public Size getPreviewSize() {
        return this.zzbmC;
    }

    public void release() {
        synchronized (this.zzbmz) {
            stop();
            this.zzbmL.release();
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start() {
        synchronized (this.zzbmz) {
            if (this.zzbmA == null) {
                this.zzbmA = zzIb();
                if (Build.VERSION.SDK_INT >= 11) {
                    this.zzbmI = new SurfaceTexture(100);
                    this.zzbmA.setPreviewTexture(this.zzbmI);
                    this.zzbmJ = true;
                } else {
                    this.zzbmH = new SurfaceView(this.mContext);
                    this.zzbmA.setPreviewDisplay(this.zzbmH.getHolder());
                    this.zzbmJ = false;
                }
                this.zzbmA.startPreview();
                this.zzbmK = new Thread(this.zzbmL);
                this.zzbmL.setActive(true);
                this.zzbmK.start();
            }
        }
        return this;
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start(SurfaceHolder surfaceHolder) {
        synchronized (this.zzbmz) {
            if (this.zzbmA == null) {
                this.zzbmA = zzIb();
                this.zzbmA.setPreviewDisplay(surfaceHolder);
                this.zzbmA.startPreview();
                this.zzbmK = new Thread(this.zzbmL);
                this.zzbmL.setActive(true);
                this.zzbmK.start();
                this.zzbmJ = false;
            }
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0019 A[Catch: all -> 0x0046, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000d, B:8:0x0013, B:9:0x0015, B:11:0x0019, B:12:0x0024, B:14:0x0028, B:15:0x002e, B:25:0x0049, B:28:0x0051, B:16:0x0036, B:17:0x003b, B:20:0x003e), top: B:33:0x0003, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036 A[Catch: all -> 0x0046, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000d, B:8:0x0013, B:9:0x0015, B:11:0x0019, B:12:0x0024, B:14:0x0028, B:15:0x002e, B:25:0x0049, B:28:0x0051, B:16:0x0036, B:17:0x003b, B:20:0x003e), top: B:33:0x0003, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void stop() {
        /*
            r5 = this;
            java.lang.Object r1 = r5.zzbmz
            monitor-enter(r1)
            com.google.android.gms.vision.CameraSource$zzb r0 = r5.zzbmL     // Catch: java.lang.Throwable -> L46
            r2 = 0
            r0.setActive(r2)     // Catch: java.lang.Throwable -> L46
            java.lang.Thread r0 = r5.zzbmK     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L15
            java.lang.Thread r0 = r5.zzbmK     // Catch: java.lang.InterruptedException -> L3d java.lang.Throwable -> L46
            r0.join()     // Catch: java.lang.InterruptedException -> L3d java.lang.Throwable -> L46
        L12:
            r0 = 0
            r5.zzbmK = r0     // Catch: java.lang.Throwable -> L46
        L15:
            android.hardware.Camera r0 = r5.zzbmA     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L36
            android.hardware.Camera r0 = r5.zzbmA     // Catch: java.lang.Throwable -> L46
            r0.stopPreview()     // Catch: java.lang.Throwable -> L46
            android.hardware.Camera r0 = r5.zzbmA     // Catch: java.lang.Throwable -> L46
            r2 = 0
            r0.setPreviewCallbackWithBuffer(r2)     // Catch: java.lang.Throwable -> L46
            boolean r0 = r5.zzbmJ     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L50
            if (r0 == 0) goto L49
            android.hardware.Camera r0 = r5.zzbmA     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L50
            r2 = 0
            r0.setPreviewTexture(r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L50
        L2e:
            android.hardware.Camera r0 = r5.zzbmA     // Catch: java.lang.Throwable -> L46
            r0.release()     // Catch: java.lang.Throwable -> L46
            r0 = 0
            r5.zzbmA = r0     // Catch: java.lang.Throwable -> L46
        L36:
            java.util.Map r0 = r5.zzbmM     // Catch: java.lang.Throwable -> L46
            r0.clear()     // Catch: java.lang.Throwable -> L46
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L46
            return
        L3d:
            r0 = move-exception
            java.lang.String r0 = "CameraSource"
            java.lang.String r2 = "Frame processing thread interrupted on release."
            android.util.Log.d(r0, r2)     // Catch: java.lang.Throwable -> L46
            goto L12
        L46:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L49:
            android.hardware.Camera r0 = r5.zzbmA     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L50
            r2 = 0
            r0.setPreviewDisplay(r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L50
            goto L2e
        L50:
            r0 = move-exception
            java.lang.String r2 = "CameraSource"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L46
            java.lang.String r4 = "Failed to clear camera preview: "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L46
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch: java.lang.Throwable -> L46
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L46
            android.util.Log.e(r2, r0)     // Catch: java.lang.Throwable -> L46
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.stop():void");
    }

    public void takePicture(ShutterCallback shutterCallback, PictureCallback pictureCallback) {
        synchronized (this.zzbmz) {
            if (this.zzbmA != null) {
                zzd zzdVar = new zzd();
                zzdVar.zzbmV = shutterCallback;
                zzc zzcVar = new zzc();
                zzcVar.zzbmU = pictureCallback;
                this.zzbmA.takePicture(zzdVar, null, null, zzcVar);
            }
        }
    }
}
