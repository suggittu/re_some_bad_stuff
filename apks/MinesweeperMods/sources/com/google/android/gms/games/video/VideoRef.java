package com.google.android.gms.games.video;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

/* loaded from: classes2.dex */
public final class VideoRef extends zzc implements Video {
    VideoRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.video.Video
    public final int getDuration() {
        return getInteger("duration");
    }

    @Override // com.google.android.gms.games.video.Video
    public final long getFileSize() {
        return getLong("filesize");
    }

    @Override // com.google.android.gms.games.video.Video
    public final String getPackageName() {
        return getString("package");
    }

    @Override // com.google.android.gms.games.video.Video
    public final long getStartTime() {
        return getLong("start_time");
    }

    public final String toString() {
        return VideoEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((VideoEntity) freeze()).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.video.Video
    public final String zzxX() {
        return getString("filepath");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzyg, reason: merged with bridge method [inline-methods] */
    public final Video freeze() {
        return new VideoEntity(this);
    }
}
