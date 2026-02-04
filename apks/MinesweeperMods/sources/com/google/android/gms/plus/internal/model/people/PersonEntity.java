package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class PersonEntity extends FastSafeParcelableJsonResponse implements Person {
    public static final com.google.android.gms.plus.internal.model.people.zza CREATOR = new com.google.android.gms.plus.internal.model.people.zza();
    private static final HashMap zzbeM;
    final int mVersionCode;
    String zzF;
    String zzWQ;
    String zzaaL;
    final Set zzbeN;
    String zzbfL;
    AgeRangeEntity zzbfM;
    String zzbfN;
    String zzbfO;
    int zzbfP;
    CoverEntity zzbfQ;
    String zzbfR;
    ImageEntity zzbfS;
    boolean zzbfT;
    NameEntity zzbfU;
    String zzbfV;
    int zzbfW;
    List zzbfX;
    List zzbfY;
    int zzbfZ;
    int zzbga;
    String zzbgb;
    List zzbgc;
    boolean zzbgd;
    int zztT;
    String zzyv;

    public final class AgeRangeEntity extends FastSafeParcelableJsonResponse implements Person.AgeRange {
        public static final zzb CREATOR = new zzb();
        private static final HashMap zzbeM;
        final int mVersionCode;
        final Set zzbeN;
        int zzbge;
        int zzbgf;

        static {
            HashMap map = new HashMap();
            zzbeM = map;
            map.put("max", FastJsonResponse.Field.zzi("max", 2));
            zzbeM.put("min", FastJsonResponse.Field.zzi("min", 3));
        }

        public AgeRangeEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        AgeRangeEntity(Set set, int i, int i2, int i3) {
            this.zzbeN = set;
            this.mVersionCode = i;
            this.zzbge = i2;
            this.zzbgf = i3;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            zzb zzbVar = CREATOR;
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof AgeRangeEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            AgeRangeEntity ageRangeEntity = (AgeRangeEntity) obj;
            for (FastJsonResponse.Field field : zzbeM.values()) {
                if (zza(field)) {
                    if (ageRangeEntity.zza(field) && zzb(field).equals(ageRangeEntity.zzb(field))) {
                    }
                    return false;
                }
                if (ageRangeEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public final int getMax() {
            return this.zzbge;
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public final int getMin() {
            return this.zzbgf;
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public final boolean hasMax() {
            return this.zzbeN.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public final boolean hasMin() {
            return this.zzbeN.contains(3);
        }

        public final int hashCode() {
            int iHashCode = 0;
            Iterator it = zzbeM.values().iterator();
            while (true) {
                int i = iHashCode;
                if (!it.hasNext()) {
                    return i;
                }
                FastJsonResponse.Field field = (FastJsonResponse.Field) it.next();
                if (zza(field)) {
                    iHashCode = zzb(field).hashCode() + i + field.zzrs();
                } else {
                    iHashCode = i;
                }
            }
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            zzb zzbVar = CREATOR;
            zzb.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: zzFl, reason: merged with bridge method [inline-methods] */
        public final HashMap zzrl() {
            return zzbeM;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: zzFq, reason: merged with bridge method [inline-methods] */
        public final AgeRangeEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final boolean zza(FastJsonResponse.Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrs()) {
                case 2:
                    return Integer.valueOf(this.zzbge);
                case 3:
                    return Integer.valueOf(this.zzbgf);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public final class CoverEntity extends FastSafeParcelableJsonResponse implements Person.Cover {
        public static final zzc CREATOR = new zzc();
        private static final HashMap zzbeM;
        final int mVersionCode;
        final Set zzbeN;
        CoverInfoEntity zzbgg;
        CoverPhotoEntity zzbgh;
        int zzbgi;

        public final class CoverInfoEntity extends FastSafeParcelableJsonResponse implements Person.Cover.CoverInfo {
            public static final zzd CREATOR = new zzd();
            private static final HashMap zzbeM;
            final int mVersionCode;
            final Set zzbeN;
            int zzbgj;
            int zzbgk;

            static {
                HashMap map = new HashMap();
                zzbeM = map;
                map.put("leftImageOffset", FastJsonResponse.Field.zzi("leftImageOffset", 2));
                zzbeM.put("topImageOffset", FastJsonResponse.Field.zzi("topImageOffset", 3));
            }

            public CoverInfoEntity() {
                this.mVersionCode = 1;
                this.zzbeN = new HashSet();
            }

            CoverInfoEntity(Set set, int i, int i2, int i3) {
                this.zzbeN = set;
                this.mVersionCode = i;
                this.zzbgj = i2;
                this.zzbgk = i3;
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                zzd zzdVar = CREATOR;
                return 0;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof CoverInfoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverInfoEntity coverInfoEntity = (CoverInfoEntity) obj;
                for (FastJsonResponse.Field field : zzbeM.values()) {
                    if (zza(field)) {
                        if (coverInfoEntity.zza(field) && zzb(field).equals(coverInfoEntity.zzb(field))) {
                        }
                        return false;
                    }
                    if (coverInfoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public final int getLeftImageOffset() {
                return this.zzbgj;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public final int getTopImageOffset() {
                return this.zzbgk;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public final boolean hasLeftImageOffset() {
                return this.zzbeN.contains(2);
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public final boolean hasTopImageOffset() {
                return this.zzbeN.contains(3);
            }

            public final int hashCode() {
                int iHashCode = 0;
                Iterator it = zzbeM.values().iterator();
                while (true) {
                    int i = iHashCode;
                    if (!it.hasNext()) {
                        return i;
                    }
                    FastJsonResponse.Field field = (FastJsonResponse.Field) it.next();
                    if (zza(field)) {
                        iHashCode = zzb(field).hashCode() + i + field.zzrs();
                    } else {
                        iHashCode = i;
                    }
                }
            }

            @Override // com.google.android.gms.common.data.Freezable
            public final boolean isDataValid() {
                return true;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i) {
                zzd zzdVar = CREATOR;
                zzd.zza(this, parcel, i);
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            /* renamed from: zzFl, reason: merged with bridge method [inline-methods] */
            public final HashMap zzrl() {
                return zzbeM;
            }

            @Override // com.google.android.gms.common.data.Freezable
            /* renamed from: zzFs, reason: merged with bridge method [inline-methods] */
            public final CoverInfoEntity freeze() {
                return this;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected final boolean zza(FastJsonResponse.Field field) {
                return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected final Object zzb(FastJsonResponse.Field field) {
                switch (field.zzrs()) {
                    case 2:
                        return Integer.valueOf(this.zzbgj);
                    case 3:
                        return Integer.valueOf(this.zzbgk);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
                }
            }
        }

        public final class CoverPhotoEntity extends FastSafeParcelableJsonResponse implements Person.Cover.CoverPhoto {
            public static final zze CREATOR = new zze();
            private static final HashMap zzbeM;
            final int mVersionCode;
            String zzF;
            final Set zzbeN;
            int zzoG;
            int zzoH;

            static {
                HashMap map = new HashMap();
                zzbeM = map;
                map.put("height", FastJsonResponse.Field.zzi("height", 2));
                zzbeM.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                zzbeM.put("width", FastJsonResponse.Field.zzi("width", 4));
            }

            public CoverPhotoEntity() {
                this.mVersionCode = 1;
                this.zzbeN = new HashSet();
            }

            CoverPhotoEntity(Set set, int i, int i2, String str, int i3) {
                this.zzbeN = set;
                this.mVersionCode = i;
                this.zzoH = i2;
                this.zzF = str;
                this.zzoG = i3;
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                zze zzeVar = CREATOR;
                return 0;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof CoverPhotoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverPhotoEntity coverPhotoEntity = (CoverPhotoEntity) obj;
                for (FastJsonResponse.Field field : zzbeM.values()) {
                    if (zza(field)) {
                        if (coverPhotoEntity.zza(field) && zzb(field).equals(coverPhotoEntity.zzb(field))) {
                        }
                        return false;
                    }
                    if (coverPhotoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public final int getHeight() {
                return this.zzoH;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public final String getUrl() {
                return this.zzF;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public final int getWidth() {
                return this.zzoG;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public final boolean hasHeight() {
                return this.zzbeN.contains(2);
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public final boolean hasUrl() {
                return this.zzbeN.contains(3);
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public final boolean hasWidth() {
                return this.zzbeN.contains(4);
            }

            public final int hashCode() {
                int iHashCode = 0;
                Iterator it = zzbeM.values().iterator();
                while (true) {
                    int i = iHashCode;
                    if (!it.hasNext()) {
                        return i;
                    }
                    FastJsonResponse.Field field = (FastJsonResponse.Field) it.next();
                    if (zza(field)) {
                        iHashCode = zzb(field).hashCode() + i + field.zzrs();
                    } else {
                        iHashCode = i;
                    }
                }
            }

            @Override // com.google.android.gms.common.data.Freezable
            public final boolean isDataValid() {
                return true;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i) {
                zze zzeVar = CREATOR;
                zze.zza(this, parcel, i);
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            /* renamed from: zzFl, reason: merged with bridge method [inline-methods] */
            public final HashMap zzrl() {
                return zzbeM;
            }

            @Override // com.google.android.gms.common.data.Freezable
            /* renamed from: zzFt, reason: merged with bridge method [inline-methods] */
            public final CoverPhotoEntity freeze() {
                return this;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected final boolean zza(FastJsonResponse.Field field) {
                return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected final Object zzb(FastJsonResponse.Field field) {
                switch (field.zzrs()) {
                    case 2:
                        return Integer.valueOf(this.zzoH);
                    case 3:
                        return this.zzF;
                    case 4:
                        return Integer.valueOf(this.zzoG);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
                }
            }
        }

        static {
            HashMap map = new HashMap();
            zzbeM = map;
            map.put("coverInfo", FastJsonResponse.Field.zza("coverInfo", 2, CoverInfoEntity.class));
            zzbeM.put("coverPhoto", FastJsonResponse.Field.zza("coverPhoto", 3, CoverPhotoEntity.class));
            zzbeM.put("layout", FastJsonResponse.Field.zza("layout", 4, new StringToIntConverter().zzh("banner", 0), false));
        }

        public CoverEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        CoverEntity(Set set, int i, CoverInfoEntity coverInfoEntity, CoverPhotoEntity coverPhotoEntity, int i2) {
            this.zzbeN = set;
            this.mVersionCode = i;
            this.zzbgg = coverInfoEntity;
            this.zzbgh = coverPhotoEntity;
            this.zzbgi = i2;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            zzc zzcVar = CREATOR;
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof CoverEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            CoverEntity coverEntity = (CoverEntity) obj;
            for (FastJsonResponse.Field field : zzbeM.values()) {
                if (zza(field)) {
                    if (coverEntity.zza(field) && zzb(field).equals(coverEntity.zzb(field))) {
                    }
                    return false;
                }
                if (coverEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public final Person.Cover.CoverInfo getCoverInfo() {
            return this.zzbgg;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public final Person.Cover.CoverPhoto getCoverPhoto() {
            return this.zzbgh;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public final int getLayout() {
            return this.zzbgi;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public final boolean hasCoverInfo() {
            return this.zzbeN.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public final boolean hasCoverPhoto() {
            return this.zzbeN.contains(3);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public final boolean hasLayout() {
            return this.zzbeN.contains(4);
        }

        public final int hashCode() {
            int iHashCode = 0;
            Iterator it = zzbeM.values().iterator();
            while (true) {
                int i = iHashCode;
                if (!it.hasNext()) {
                    return i;
                }
                FastJsonResponse.Field field = (FastJsonResponse.Field) it.next();
                if (zza(field)) {
                    iHashCode = zzb(field).hashCode() + i + field.zzrs();
                } else {
                    iHashCode = i;
                }
            }
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            zzc zzcVar = CREATOR;
            zzc.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: zzFl, reason: merged with bridge method [inline-methods] */
        public final HashMap zzrl() {
            return zzbeM;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: zzFr, reason: merged with bridge method [inline-methods] */
        public final CoverEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final boolean zza(FastJsonResponse.Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrs()) {
                case 2:
                    return this.zzbgg;
                case 3:
                    return this.zzbgh;
                case 4:
                    return Integer.valueOf(this.zzbgi);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public final class ImageEntity extends FastSafeParcelableJsonResponse implements Person.Image {
        public static final zzf CREATOR = new zzf();
        private static final HashMap zzbeM;
        final int mVersionCode;
        String zzF;
        final Set zzbeN;

        static {
            HashMap map = new HashMap();
            zzbeM = map;
            map.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public ImageEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        public ImageEntity(String str) {
            this.zzbeN = new HashSet();
            this.mVersionCode = 1;
            this.zzF = str;
            this.zzbeN.add(2);
        }

        ImageEntity(Set set, int i, String str) {
            this.zzbeN = set;
            this.mVersionCode = i;
            this.zzF = str;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            zzf zzfVar = CREATOR;
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ImageEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageEntity imageEntity = (ImageEntity) obj;
            for (FastJsonResponse.Field field : zzbeM.values()) {
                if (zza(field)) {
                    if (imageEntity.zza(field) && zzb(field).equals(imageEntity.zzb(field))) {
                    }
                    return false;
                }
                if (imageEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Image
        public final String getUrl() {
            return this.zzF;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Image
        public final boolean hasUrl() {
            return this.zzbeN.contains(2);
        }

        public final int hashCode() {
            int iHashCode = 0;
            Iterator it = zzbeM.values().iterator();
            while (true) {
                int i = iHashCode;
                if (!it.hasNext()) {
                    return i;
                }
                FastJsonResponse.Field field = (FastJsonResponse.Field) it.next();
                if (zza(field)) {
                    iHashCode = zzb(field).hashCode() + i + field.zzrs();
                } else {
                    iHashCode = i;
                }
            }
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            zzf zzfVar = CREATOR;
            zzf.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: zzFl, reason: merged with bridge method [inline-methods] */
        public final HashMap zzrl() {
            return zzbeM;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: zzFu, reason: merged with bridge method [inline-methods] */
        public final ImageEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final boolean zza(FastJsonResponse.Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrs()) {
                case 2:
                    return this.zzF;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public final class NameEntity extends FastSafeParcelableJsonResponse implements Person.Name {
        public static final zzg CREATOR = new zzg();
        private static final HashMap zzbeM;
        final int mVersionCode;
        final Set zzbeN;
        String zzbfl;
        String zzbfo;
        String zzbgl;
        String zzbgm;
        String zzbgn;
        String zzbgo;

        static {
            HashMap map = new HashMap();
            zzbeM = map;
            map.put("familyName", FastJsonResponse.Field.zzl("familyName", 2));
            zzbeM.put("formatted", FastJsonResponse.Field.zzl("formatted", 3));
            zzbeM.put("givenName", FastJsonResponse.Field.zzl("givenName", 4));
            zzbeM.put("honorificPrefix", FastJsonResponse.Field.zzl("honorificPrefix", 5));
            zzbeM.put("honorificSuffix", FastJsonResponse.Field.zzl("honorificSuffix", 6));
            zzbeM.put("middleName", FastJsonResponse.Field.zzl("middleName", 7));
        }

        public NameEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        NameEntity(Set set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.zzbeN = set;
            this.mVersionCode = i;
            this.zzbfl = str;
            this.zzbgl = str2;
            this.zzbfo = str3;
            this.zzbgm = str4;
            this.zzbgn = str5;
            this.zzbgo = str6;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            zzg zzgVar = CREATOR;
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof NameEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            NameEntity nameEntity = (NameEntity) obj;
            for (FastJsonResponse.Field field : zzbeM.values()) {
                if (zza(field)) {
                    if (nameEntity.zza(field) && zzb(field).equals(nameEntity.zzb(field))) {
                    }
                    return false;
                }
                if (nameEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final String getFamilyName() {
            return this.zzbfl;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final String getFormatted() {
            return this.zzbgl;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final String getGivenName() {
            return this.zzbfo;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final String getHonorificPrefix() {
            return this.zzbgm;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final String getHonorificSuffix() {
            return this.zzbgn;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final String getMiddleName() {
            return this.zzbgo;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final boolean hasFamilyName() {
            return this.zzbeN.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final boolean hasFormatted() {
            return this.zzbeN.contains(3);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final boolean hasGivenName() {
            return this.zzbeN.contains(4);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final boolean hasHonorificPrefix() {
            return this.zzbeN.contains(5);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final boolean hasHonorificSuffix() {
            return this.zzbeN.contains(6);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final boolean hasMiddleName() {
            return this.zzbeN.contains(7);
        }

        public final int hashCode() {
            int iHashCode = 0;
            Iterator it = zzbeM.values().iterator();
            while (true) {
                int i = iHashCode;
                if (!it.hasNext()) {
                    return i;
                }
                FastJsonResponse.Field field = (FastJsonResponse.Field) it.next();
                if (zza(field)) {
                    iHashCode = zzb(field).hashCode() + i + field.zzrs();
                } else {
                    iHashCode = i;
                }
            }
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            zzg zzgVar = CREATOR;
            zzg.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: zzFl, reason: merged with bridge method [inline-methods] */
        public final HashMap zzrl() {
            return zzbeM;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: zzFv, reason: merged with bridge method [inline-methods] */
        public final NameEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final boolean zza(FastJsonResponse.Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrs()) {
                case 2:
                    return this.zzbfl;
                case 3:
                    return this.zzbgl;
                case 4:
                    return this.zzbfo;
                case 5:
                    return this.zzbgm;
                case 6:
                    return this.zzbgn;
                case 7:
                    return this.zzbgo;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public final class OrganizationsEntity extends FastSafeParcelableJsonResponse implements Person.Organizations {
        public static final zzh CREATOR = new zzh();
        private static final HashMap zzbeM;
        String mName;
        final int mVersionCode;
        int zzabB;
        String zzapg;
        String zzaxl;
        final Set zzbeN;
        String zzbfA;
        String zzbfk;
        String zzbgp;
        String zzbgq;
        boolean zzbgr;

        static {
            HashMap map = new HashMap();
            zzbeM = map;
            map.put("department", FastJsonResponse.Field.zzl("department", 2));
            zzbeM.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            zzbeM.put("endDate", FastJsonResponse.Field.zzl("endDate", 4));
            zzbeM.put("location", FastJsonResponse.Field.zzl("location", 5));
            zzbeM.put("name", FastJsonResponse.Field.zzl("name", 6));
            zzbeM.put("primary", FastJsonResponse.Field.zzk("primary", 7));
            zzbeM.put("startDate", FastJsonResponse.Field.zzl("startDate", 8));
            zzbeM.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            zzbeM.put("type", FastJsonResponse.Field.zza("type", 10, new StringToIntConverter().zzh("work", 0).zzh("school", 1), false));
        }

        public OrganizationsEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        OrganizationsEntity(Set set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.zzbeN = set;
            this.mVersionCode = i;
            this.zzbgp = str;
            this.zzaxl = str2;
            this.zzbfk = str3;
            this.zzbgq = str4;
            this.mName = str5;
            this.zzbgr = z;
            this.zzbfA = str6;
            this.zzapg = str7;
            this.zzabB = i2;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            zzh zzhVar = CREATOR;
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof OrganizationsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            OrganizationsEntity organizationsEntity = (OrganizationsEntity) obj;
            for (FastJsonResponse.Field field : zzbeM.values()) {
                if (zza(field)) {
                    if (organizationsEntity.zza(field) && zzb(field).equals(organizationsEntity.zzb(field))) {
                    }
                    return false;
                }
                if (organizationsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final String getDepartment() {
            return this.zzbgp;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final String getDescription() {
            return this.zzaxl;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final String getEndDate() {
            return this.zzbfk;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final String getLocation() {
            return this.zzbgq;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final String getName() {
            return this.mName;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final String getStartDate() {
            return this.zzbfA;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final String getTitle() {
            return this.zzapg;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final int getType() {
            return this.zzabB;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasDepartment() {
            return this.zzbeN.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasDescription() {
            return this.zzbeN.contains(3);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasEndDate() {
            return this.zzbeN.contains(4);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasLocation() {
            return this.zzbeN.contains(5);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasName() {
            return this.zzbeN.contains(6);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasPrimary() {
            return this.zzbeN.contains(7);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasStartDate() {
            return this.zzbeN.contains(8);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasTitle() {
            return this.zzbeN.contains(9);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasType() {
            return this.zzbeN.contains(10);
        }

        public final int hashCode() {
            int iHashCode = 0;
            Iterator it = zzbeM.values().iterator();
            while (true) {
                int i = iHashCode;
                if (!it.hasNext()) {
                    return i;
                }
                FastJsonResponse.Field field = (FastJsonResponse.Field) it.next();
                if (zza(field)) {
                    iHashCode = zzb(field).hashCode() + i + field.zzrs();
                } else {
                    iHashCode = i;
                }
            }
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean isPrimary() {
            return this.zzbgr;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            zzh zzhVar = CREATOR;
            zzh.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: zzFl, reason: merged with bridge method [inline-methods] */
        public final HashMap zzrl() {
            return zzbeM;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: zzFw, reason: merged with bridge method [inline-methods] */
        public final OrganizationsEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final boolean zza(FastJsonResponse.Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrs()) {
                case 2:
                    return this.zzbgp;
                case 3:
                    return this.zzaxl;
                case 4:
                    return this.zzbfk;
                case 5:
                    return this.zzbgq;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.zzbgr);
                case 8:
                    return this.zzbfA;
                case 9:
                    return this.zzapg;
                case 10:
                    return Integer.valueOf(this.zzabB);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public final class PlacesLivedEntity extends FastSafeParcelableJsonResponse implements Person.PlacesLived {
        public static final zzi CREATOR = new zzi();
        private static final HashMap zzbeM;
        String mValue;
        final int mVersionCode;
        final Set zzbeN;
        boolean zzbgr;

        static {
            HashMap map = new HashMap();
            zzbeM = map;
            map.put("primary", FastJsonResponse.Field.zzk("primary", 2));
            zzbeM.put("value", FastJsonResponse.Field.zzl("value", 3));
        }

        public PlacesLivedEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        PlacesLivedEntity(Set set, int i, boolean z, String str) {
            this.zzbeN = set;
            this.mVersionCode = i;
            this.zzbgr = z;
            this.mValue = str;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            zzi zziVar = CREATOR;
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof PlacesLivedEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PlacesLivedEntity placesLivedEntity = (PlacesLivedEntity) obj;
            for (FastJsonResponse.Field field : zzbeM.values()) {
                if (zza(field)) {
                    if (placesLivedEntity.zza(field) && zzb(field).equals(placesLivedEntity.zzb(field))) {
                    }
                    return false;
                }
                if (placesLivedEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public final String getValue() {
            return this.mValue;
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public final boolean hasPrimary() {
            return this.zzbeN.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public final boolean hasValue() {
            return this.zzbeN.contains(3);
        }

        public final int hashCode() {
            int iHashCode = 0;
            Iterator it = zzbeM.values().iterator();
            while (true) {
                int i = iHashCode;
                if (!it.hasNext()) {
                    return i;
                }
                FastJsonResponse.Field field = (FastJsonResponse.Field) it.next();
                if (zza(field)) {
                    iHashCode = zzb(field).hashCode() + i + field.zzrs();
                } else {
                    iHashCode = i;
                }
            }
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public final boolean isPrimary() {
            return this.zzbgr;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            zzi zziVar = CREATOR;
            zzi.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: zzFl, reason: merged with bridge method [inline-methods] */
        public final HashMap zzrl() {
            return zzbeM;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: zzFx, reason: merged with bridge method [inline-methods] */
        public final PlacesLivedEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final boolean zza(FastJsonResponse.Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrs()) {
                case 2:
                    return Boolean.valueOf(this.zzbgr);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public final class UrlsEntity extends FastSafeParcelableJsonResponse implements Person.Urls {
        public static final zzj CREATOR = new zzj();
        private static final HashMap zzbeM;
        String mValue;
        final int mVersionCode;
        String zzaUO;
        int zzabB;
        final Set zzbeN;
        private final int zzbgs;

        static {
            HashMap map = new HashMap();
            zzbeM = map;
            map.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            zzbeM.put("type", FastJsonResponse.Field.zza("type", 6, new StringToIntConverter().zzh("home", 0).zzh("work", 1).zzh("blog", 2).zzh(Scopes.PROFILE, 3).zzh(FitnessActivities.OTHER, 4).zzh("otherProfile", 5).zzh("contributor", 6).zzh("website", 7), false));
            zzbeM.put("value", FastJsonResponse.Field.zzl("value", 4));
        }

        public UrlsEntity() {
            this.zzbgs = 4;
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        UrlsEntity(Set set, int i, String str, int i2, String str2, int i3) {
            this.zzbgs = 4;
            this.zzbeN = set;
            this.mVersionCode = i;
            this.zzaUO = str;
            this.zzabB = i2;
            this.mValue = str2;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            zzj zzjVar = CREATOR;
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof UrlsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            UrlsEntity urlsEntity = (UrlsEntity) obj;
            for (FastJsonResponse.Field field : zzbeM.values()) {
                if (zza(field)) {
                    if (urlsEntity.zza(field) && zzb(field).equals(urlsEntity.zzb(field))) {
                    }
                    return false;
                }
                if (urlsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public final String getLabel() {
            return this.zzaUO;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public final int getType() {
            return this.zzabB;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public final String getValue() {
            return this.mValue;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public final boolean hasLabel() {
            return this.zzbeN.contains(5);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public final boolean hasType() {
            return this.zzbeN.contains(6);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public final boolean hasValue() {
            return this.zzbeN.contains(4);
        }

        public final int hashCode() {
            int iHashCode = 0;
            Iterator it = zzbeM.values().iterator();
            while (true) {
                int i = iHashCode;
                if (!it.hasNext()) {
                    return i;
                }
                FastJsonResponse.Field field = (FastJsonResponse.Field) it.next();
                if (zza(field)) {
                    iHashCode = zzb(field).hashCode() + i + field.zzrs();
                } else {
                    iHashCode = i;
                }
            }
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            zzj zzjVar = CREATOR;
            zzj.zza(this, parcel, i);
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: zzFl, reason: merged with bridge method [inline-methods] */
        public final HashMap zzrl() {
            return zzbeM;
        }

        @Deprecated
        public final int zzFy() {
            return 4;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: zzFz, reason: merged with bridge method [inline-methods] */
        public final UrlsEntity freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final boolean zza(FastJsonResponse.Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrs()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.zzaUO;
                case 6:
                    return Integer.valueOf(this.zzabB);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public class zza {
        public static int zzfH(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    static {
        HashMap map = new HashMap();
        zzbeM = map;
        map.put("aboutMe", FastJsonResponse.Field.zzl("aboutMe", 2));
        zzbeM.put("ageRange", FastJsonResponse.Field.zza("ageRange", 3, AgeRangeEntity.class));
        zzbeM.put("birthday", FastJsonResponse.Field.zzl("birthday", 4));
        zzbeM.put("braggingRights", FastJsonResponse.Field.zzl("braggingRights", 5));
        zzbeM.put("circledByCount", FastJsonResponse.Field.zzi("circledByCount", 6));
        zzbeM.put("cover", FastJsonResponse.Field.zza("cover", 7, CoverEntity.class));
        zzbeM.put("currentLocation", FastJsonResponse.Field.zzl("currentLocation", 8));
        zzbeM.put("displayName", FastJsonResponse.Field.zzl("displayName", 9));
        zzbeM.put("gender", FastJsonResponse.Field.zza("gender", 12, new StringToIntConverter().zzh("male", 0).zzh("female", 1).zzh(FitnessActivities.OTHER, 2), false));
        zzbeM.put("id", FastJsonResponse.Field.zzl("id", 14));
        zzbeM.put("image", FastJsonResponse.Field.zza("image", 15, ImageEntity.class));
        zzbeM.put("isPlusUser", FastJsonResponse.Field.zzk("isPlusUser", 16));
        zzbeM.put("language", FastJsonResponse.Field.zzl("language", 18));
        zzbeM.put("name", FastJsonResponse.Field.zza("name", 19, NameEntity.class));
        zzbeM.put("nickname", FastJsonResponse.Field.zzl("nickname", 20));
        zzbeM.put("objectType", FastJsonResponse.Field.zza("objectType", 21, new StringToIntConverter().zzh("person", 0).zzh("page", 1), false));
        zzbeM.put("organizations", FastJsonResponse.Field.zzb("organizations", 22, OrganizationsEntity.class));
        zzbeM.put("placesLived", FastJsonResponse.Field.zzb("placesLived", 23, PlacesLivedEntity.class));
        zzbeM.put("plusOneCount", FastJsonResponse.Field.zzi("plusOneCount", 24));
        zzbeM.put("relationshipStatus", FastJsonResponse.Field.zza("relationshipStatus", 25, new StringToIntConverter().zzh("single", 0).zzh("in_a_relationship", 1).zzh("engaged", 2).zzh("married", 3).zzh("its_complicated", 4).zzh("open_relationship", 5).zzh("widowed", 6).zzh("in_domestic_partnership", 7).zzh("in_civil_union", 8), false));
        zzbeM.put("tagline", FastJsonResponse.Field.zzl("tagline", 26));
        zzbeM.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        zzbeM.put("urls", FastJsonResponse.Field.zzb("urls", 28, UrlsEntity.class));
        zzbeM.put("verified", FastJsonResponse.Field.zzk("verified", 29));
    }

    public PersonEntity() {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
    }

    public PersonEntity(String str, String str2, ImageEntity imageEntity, int i, String str3) {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
        this.zzWQ = str;
        this.zzbeN.add(9);
        this.zzyv = str2;
        this.zzbeN.add(14);
        this.zzbfS = imageEntity;
        this.zzbeN.add(15);
        this.zzbfW = i;
        this.zzbeN.add(21);
        this.zzF = str3;
        this.zzbeN.add(27);
    }

    PersonEntity(Set set, int i, String str, AgeRangeEntity ageRangeEntity, String str2, String str3, int i2, CoverEntity coverEntity, String str4, String str5, int i3, String str6, ImageEntity imageEntity, boolean z, String str7, NameEntity nameEntity, String str8, int i4, List list, List list2, int i5, int i6, String str9, String str10, List list3, boolean z2) {
        this.zzbeN = set;
        this.mVersionCode = i;
        this.zzbfL = str;
        this.zzbfM = ageRangeEntity;
        this.zzbfN = str2;
        this.zzbfO = str3;
        this.zzbfP = i2;
        this.zzbfQ = coverEntity;
        this.zzbfR = str4;
        this.zzWQ = str5;
        this.zztT = i3;
        this.zzyv = str6;
        this.zzbfS = imageEntity;
        this.zzbfT = z;
        this.zzaaL = str7;
        this.zzbfU = nameEntity;
        this.zzbfV = str8;
        this.zzbfW = i4;
        this.zzbfX = list;
        this.zzbfY = list2;
        this.zzbfZ = i5;
        this.zzbga = i6;
        this.zzbgb = str9;
        this.zzF = str10;
        this.zzbgc = list3;
        this.zzbgd = z2;
    }

    public static PersonEntity zzv(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        PersonEntity personEntityCreateFromParcel = CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return personEntityCreateFromParcel;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        com.google.android.gms.plus.internal.model.people.zza zzaVar = CREATOR;
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PersonEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PersonEntity personEntity = (PersonEntity) obj;
        for (FastJsonResponse.Field field : zzbeM.values()) {
            if (zza(field)) {
                if (personEntity.zza(field) && zzb(field).equals(personEntity.zzb(field))) {
                }
                return false;
            }
            if (personEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getAboutMe() {
        return this.zzbfL;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final Person.AgeRange getAgeRange() {
        return this.zzbfM;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getBirthday() {
        return this.zzbfN;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getBraggingRights() {
        return this.zzbfO;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final int getCircledByCount() {
        return this.zzbfP;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final Person.Cover getCover() {
        return this.zzbfQ;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getCurrentLocation() {
        return this.zzbfR;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getDisplayName() {
        return this.zzWQ;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final int getGender() {
        return this.zztT;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getId() {
        return this.zzyv;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final Person.Image getImage() {
        return this.zzbfS;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getLanguage() {
        return this.zzaaL;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final Person.Name getName() {
        return this.zzbfU;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getNickname() {
        return this.zzbfV;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final int getObjectType() {
        return this.zzbfW;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final List getOrganizations() {
        return (ArrayList) this.zzbfX;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final List getPlacesLived() {
        return (ArrayList) this.zzbfY;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final int getPlusOneCount() {
        return this.zzbfZ;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final int getRelationshipStatus() {
        return this.zzbga;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getTagline() {
        return this.zzbgb;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getUrl() {
        return this.zzF;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final List getUrls() {
        return (ArrayList) this.zzbgc;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasAboutMe() {
        return this.zzbeN.contains(2);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasAgeRange() {
        return this.zzbeN.contains(3);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasBirthday() {
        return this.zzbeN.contains(4);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasBraggingRights() {
        return this.zzbeN.contains(5);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasCircledByCount() {
        return this.zzbeN.contains(6);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasCover() {
        return this.zzbeN.contains(7);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasCurrentLocation() {
        return this.zzbeN.contains(8);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasDisplayName() {
        return this.zzbeN.contains(9);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasGender() {
        return this.zzbeN.contains(12);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasId() {
        return this.zzbeN.contains(14);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasImage() {
        return this.zzbeN.contains(15);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasIsPlusUser() {
        return this.zzbeN.contains(16);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasLanguage() {
        return this.zzbeN.contains(18);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasName() {
        return this.zzbeN.contains(19);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasNickname() {
        return this.zzbeN.contains(20);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasObjectType() {
        return this.zzbeN.contains(21);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasOrganizations() {
        return this.zzbeN.contains(22);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasPlacesLived() {
        return this.zzbeN.contains(23);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasPlusOneCount() {
        return this.zzbeN.contains(24);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasRelationshipStatus() {
        return this.zzbeN.contains(25);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasTagline() {
        return this.zzbeN.contains(26);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasUrl() {
        return this.zzbeN.contains(27);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasUrls() {
        return this.zzbeN.contains(28);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasVerified() {
        return this.zzbeN.contains(29);
    }

    public final int hashCode() {
        int iHashCode = 0;
        Iterator it = zzbeM.values().iterator();
        while (true) {
            int i = iHashCode;
            if (!it.hasNext()) {
                return i;
            }
            FastJsonResponse.Field field = (FastJsonResponse.Field) it.next();
            if (zza(field)) {
                iHashCode = zzb(field).hashCode() + i + field.zzrs();
            } else {
                iHashCode = i;
            }
        }
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean isPlusUser() {
        return this.zzbfT;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean isVerified() {
        return this.zzbgd;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.plus.internal.model.people.zza zzaVar = CREATOR;
        com.google.android.gms.plus.internal.model.people.zza.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: zzFl, reason: merged with bridge method [inline-methods] */
    public final HashMap zzrl() {
        return zzbeM;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzFp, reason: merged with bridge method [inline-methods] */
    public final PersonEntity freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final boolean zza(FastJsonResponse.Field field) {
        return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final Object zzb(FastJsonResponse.Field field) {
        switch (field.zzrs()) {
            case 2:
                return this.zzbfL;
            case 3:
                return this.zzbfM;
            case 4:
                return this.zzbfN;
            case 5:
                return this.zzbfO;
            case 6:
                return Integer.valueOf(this.zzbfP);
            case 7:
                return this.zzbfQ;
            case 8:
                return this.zzbfR;
            case 9:
                return this.zzWQ;
            case 10:
            case 11:
            case 13:
            case 17:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            case 12:
                return Integer.valueOf(this.zztT);
            case 14:
                return this.zzyv;
            case 15:
                return this.zzbfS;
            case 16:
                return Boolean.valueOf(this.zzbfT);
            case 18:
                return this.zzaaL;
            case 19:
                return this.zzbfU;
            case 20:
                return this.zzbfV;
            case 21:
                return Integer.valueOf(this.zzbfW);
            case 22:
                return this.zzbfX;
            case 23:
                return this.zzbfY;
            case 24:
                return Integer.valueOf(this.zzbfZ);
            case 25:
                return Integer.valueOf(this.zzbga);
            case Place.TYPE_CONVENIENCE_STORE /* 26 */:
                return this.zzbgb;
            case Place.TYPE_COURTHOUSE /* 27 */:
                return this.zzF;
            case Place.TYPE_DENTIST /* 28 */:
                return this.zzbgc;
            case Place.TYPE_DEPARTMENT_STORE /* 29 */:
                return Boolean.valueOf(this.zzbgd);
        }
    }
}
