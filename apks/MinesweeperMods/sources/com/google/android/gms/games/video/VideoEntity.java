package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public final class VideoEntity implements SafeParcelable, Video {
    public static final Parcelable.Creator CREATOR = new VideoEntityCreator();
    private final int mVersionCode;
    private final long zzCv;
    private final String zzTJ;
    private final String zzaLv;
    private final long zzaLw;
    private final int zzakd;

    VideoEntity(int i, int i2, String str, long j, long j2, String str2) {
        this.mVersionCode = i;
        this.zzakd = i2;
        this.zzaLv = str;
        this.zzaLw = j;
        this.zzCv = j2;
        this.zzTJ = str2;
    }

    public VideoEntity(Video video) {
        this.mVersionCode = 1;
        this.zzakd = video.getDuration();
        this.zzaLv = video.zzxX();
        this.zzaLw = video.getFileSize();
        this.zzCv = video.getStartTime();
        this.zzTJ = video.getPackageName();
        zzb.zzv(this.zzaLv);
        zzb.zzv(this.zzTJ);
    }

    static int zza(Video video) {
        return zzw.hashCode(Integer.valueOf(video.getDuration()), video.zzxX(), Long.valueOf(video.getFileSize()), Long.valueOf(video.getStartTime()), video.getPackageName());
    }

    static boolean zza(Video video, Object obj) {
        if (!(obj instanceof Video)) {
            return false;
        }
        if (video == obj) {
            return true;
        }
        Video video2 = (Video) obj;
        return zzw.equal(Integer.valueOf(video2.getDuration()), Integer.valueOf(video.getDuration())) && zzw.equal(video2.zzxX(), video.zzxX()) && zzw.equal(Long.valueOf(video2.getFileSize()), Long.valueOf(video.getFileSize())) && zzw.equal(Long.valueOf(video2.getStartTime()), Long.valueOf(video.getStartTime())) && zzw.equal(video2.getPackageName(), video.getPackageName());
    }

    static String zzb(Video video) {
        return zzw.zzy(video).zzg("Duration", Integer.valueOf(video.getDuration())).zzg("File path", video.zzxX()).zzg("File size", Long.valueOf(video.getFileSize())).zzg("Start time", Long.valueOf(video.getStartTime())).zzg("Package name", video.getPackageName()).toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.video.Video
    public final int getDuration() {
        return this.zzakd;
    }

    @Override // com.google.android.gms.games.video.Video
    public final long getFileSize() {
        return this.zzaLw;
    }

    @Override // com.google.android.gms.games.video.Video
    public final String getPackageName() {
        return this.zzTJ;
    }

    @Override // com.google.android.gms.games.video.Video
    public final long getStartTime() {
        return this.zzCv;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        VideoEntityCreator.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.games.video.Video
    public final String zzxX() {
        return this.zzaLv;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzyg, reason: merged with bridge method [inline-methods] */
    public final Video freeze() {
        return this;
    }
}
