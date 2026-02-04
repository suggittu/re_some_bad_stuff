package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.nearby.messages.Strategy;

/* loaded from: classes2.dex */
public final class LocationRequest implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    int mPriority;
    private final int mVersionCode;
    boolean zzaBr;
    long zzaND;
    long zzaNY;
    long zzaNZ;
    int zzaOa;
    float zzaOb;
    long zzaOc;

    public LocationRequest() {
        this.mVersionCode = 1;
        this.mPriority = 102;
        this.zzaNY = 3600000L;
        this.zzaNZ = 600000L;
        this.zzaBr = false;
        this.zzaND = Long.MAX_VALUE;
        this.zzaOa = Strategy.TTL_SECONDS_INFINITE;
        this.zzaOb = 0.0f;
        this.zzaOc = 0L;
    }

    LocationRequest(int i, int i2, long j, long j2, boolean z, long j3, int i3, float f, long j4) {
        this.mVersionCode = i;
        this.mPriority = i2;
        this.zzaNY = j;
        this.zzaNZ = j2;
        this.zzaBr = z;
        this.zzaND = j3;
        this.zzaOa = i3;
        this.zzaOb = f;
        this.zzaOc = j4;
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void zzL(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    private static void zzd(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    private static void zzhs(int i) {
        switch (i) {
            case 100:
            case 102:
            case PRIORITY_LOW_POWER /* 104 */:
            case PRIORITY_NO_POWER /* 105 */:
                return;
            case Quests.SELECT_COMPLETED_UNCLAIMED /* 101 */:
            case Quests.SELECT_RECENTLY_FAILED /* 103 */:
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public static String zzht(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case Quests.SELECT_COMPLETED_UNCLAIMED /* 101 */:
            case Quests.SELECT_RECENTLY_FAILED /* 103 */:
            default:
                return "???";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case PRIORITY_LOW_POWER /* 104 */:
                return "PRIORITY_LOW_POWER";
            case PRIORITY_NO_POWER /* 105 */:
                return "PRIORITY_NO_POWER";
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.mPriority == locationRequest.mPriority && this.zzaNY == locationRequest.zzaNY && this.zzaNZ == locationRequest.zzaNZ && this.zzaBr == locationRequest.zzaBr && this.zzaND == locationRequest.zzaND && this.zzaOa == locationRequest.zzaOa && this.zzaOb == locationRequest.zzaOb;
    }

    public final long getExpirationTime() {
        return this.zzaND;
    }

    public final long getFastestInterval() {
        return this.zzaNZ;
    }

    public final long getInterval() {
        return this.zzaNY;
    }

    public final long getMaxWaitTime() {
        long j = this.zzaOc;
        return j < this.zzaNY ? this.zzaNY : j;
    }

    public final int getNumUpdates() {
        return this.zzaOa;
    }

    public final int getPriority() {
        return this.mPriority;
    }

    public final float getSmallestDisplacement() {
        return this.zzaOb;
    }

    final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.zzaNY), Long.valueOf(this.zzaNZ), Boolean.valueOf(this.zzaBr), Long.valueOf(this.zzaND), Integer.valueOf(this.zzaOa), Float.valueOf(this.zzaOb));
    }

    public final LocationRequest setExpirationDuration(long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (j > Long.MAX_VALUE - jElapsedRealtime) {
            this.zzaND = Long.MAX_VALUE;
        } else {
            this.zzaND = jElapsedRealtime + j;
        }
        if (this.zzaND < 0) {
            this.zzaND = 0L;
        }
        return this;
    }

    public final LocationRequest setExpirationTime(long j) {
        this.zzaND = j;
        if (this.zzaND < 0) {
            this.zzaND = 0L;
        }
        return this;
    }

    public final LocationRequest setFastestInterval(long j) {
        zzL(j);
        this.zzaBr = true;
        this.zzaNZ = j;
        return this;
    }

    public final LocationRequest setInterval(long j) {
        zzL(j);
        this.zzaNY = j;
        if (!this.zzaBr) {
            this.zzaNZ = (long) (this.zzaNY / 6.0d);
        }
        return this;
    }

    public final LocationRequest setMaxWaitTime(long j) {
        zzL(j);
        this.zzaOc = j;
        return this;
    }

    public final LocationRequest setNumUpdates(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + i);
        }
        this.zzaOa = i;
        return this;
    }

    public final LocationRequest setPriority(int i) {
        zzhs(i);
        this.mPriority = i;
        return this;
    }

    public final LocationRequest setSmallestDisplacement(float f) {
        zzd(f);
        this.zzaOb = f;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[").append(zzht(this.mPriority));
        if (this.mPriority != 105) {
            sb.append(" requested=");
            sb.append(this.zzaNY).append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.zzaNZ).append("ms");
        if (this.zzaOc > this.zzaNY) {
            sb.append(" maxWait=");
            sb.append(this.zzaOc).append("ms");
        }
        if (this.zzaND != Long.MAX_VALUE) {
            long jElapsedRealtime = this.zzaND - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(jElapsedRealtime).append("ms");
        }
        if (this.zzaOa != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.zzaOa);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        LocationRequestCreator.zza(this, parcel, i);
    }
}
