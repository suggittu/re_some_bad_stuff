package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class PlayerColumnNames {
    public final String name;
    public final String title;
    public final String zzaIA;
    public final String zzaIB;
    public final String zzaIC;
    public final String zzaID;
    public final String zzaIE;
    public final String zzaIF;
    public final String zzaIG;
    public final String zzaIH;
    public final String zzaII;
    public final String zzaIJ;
    public final String zzaIK;
    public final String zzaIL;
    public final String zzaIM;
    public final String zzaIN;
    public final String zzaIO;
    public final String zzaIP;
    public final String zzaIQ;
    public final String zzaIR;
    public final String zzaIS;
    public final String zzaIT;
    public final String zzaIU;
    public final String zzaIV;
    public final String zzaIs;
    public final String zzaIt;
    public final String zzaIu;
    public final String zzaIv;
    public final String zzaIw;
    public final String zzaIx;
    public final String zzaIy;
    public final String zzaIz;

    public PlayerColumnNames(String str) {
        if (TextUtils.isEmpty(str)) {
            this.zzaIs = "external_player_id";
            this.zzaIt = "profile_name";
            this.zzaIu = "profile_icon_image_uri";
            this.zzaIv = "profile_icon_image_url";
            this.zzaIw = "profile_hi_res_image_uri";
            this.zzaIx = "profile_hi_res_image_url";
            this.zzaIy = "last_updated";
            this.zzaIz = "is_in_circles";
            this.zzaIA = "played_with_timestamp";
            this.zzaIB = "current_xp_total";
            this.zzaIC = "current_level";
            this.zzaID = "current_level_min_xp";
            this.zzaIE = "current_level_max_xp";
            this.zzaIF = "next_level";
            this.zzaIG = "next_level_max_xp";
            this.zzaIH = "last_level_up_timestamp";
            this.title = "player_title";
            this.zzaII = "has_all_public_acls";
            this.zzaIJ = "is_profile_visible";
            this.zzaIK = "most_recent_external_game_id";
            this.zzaIL = "most_recent_game_name";
            this.zzaIM = "most_recent_activity_timestamp";
            this.zzaIN = "most_recent_game_icon_uri";
            this.zzaIO = "most_recent_game_hi_res_uri";
            this.zzaIP = "most_recent_game_featured_uri";
            this.zzaIQ = "has_debug_access";
            this.zzaIR = "gamer_tag";
            this.name = "real_name";
            this.zzaIS = "banner_image_landscape_uri";
            this.zzaIT = "banner_image_landscape_url";
            this.zzaIU = "banner_image_portrait_uri";
            this.zzaIV = "banner_image_portrait_url";
            return;
        }
        this.zzaIs = str + "external_player_id";
        this.zzaIt = str + "profile_name";
        this.zzaIu = str + "profile_icon_image_uri";
        this.zzaIv = str + "profile_icon_image_url";
        this.zzaIw = str + "profile_hi_res_image_uri";
        this.zzaIx = str + "profile_hi_res_image_url";
        this.zzaIy = str + "last_updated";
        this.zzaIz = str + "is_in_circles";
        this.zzaIA = str + "played_with_timestamp";
        this.zzaIB = str + "current_xp_total";
        this.zzaIC = str + "current_level";
        this.zzaID = str + "current_level_min_xp";
        this.zzaIE = str + "current_level_max_xp";
        this.zzaIF = str + "next_level";
        this.zzaIG = str + "next_level_max_xp";
        this.zzaIH = str + "last_level_up_timestamp";
        this.title = str + "player_title";
        this.zzaII = str + "has_all_public_acls";
        this.zzaIJ = str + "is_profile_visible";
        this.zzaIK = str + "most_recent_external_game_id";
        this.zzaIL = str + "most_recent_game_name";
        this.zzaIM = str + "most_recent_activity_timestamp";
        this.zzaIN = str + "most_recent_game_icon_uri";
        this.zzaIO = str + "most_recent_game_hi_res_uri";
        this.zzaIP = str + "most_recent_game_featured_uri";
        this.zzaIQ = str + "has_debug_access";
        this.zzaIR = str + "gamer_tag";
        this.name = str + "real_name";
        this.zzaIS = str + "banner_image_landscape_uri";
        this.zzaIT = str + "banner_image_landscape_url";
        this.zzaIU = str + "banner_image_portrait_uri";
        this.zzaIV = str + "banner_image_portrait_url";
    }
}
