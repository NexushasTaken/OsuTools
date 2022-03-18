package com.nexus.osu;

public enum FileExts {
    OSZ(".osz"),	//x-osu-beatmap-archive	osu! beatmap archive
    OSK(".osk"),	//x-osu-skin-archive	osu! skin archive
    OSU(".osu"),	//x-osu-beatmap	osu! beatmap
    OSB(".osb"),	//x-osu-storyboard	osu! storyboard
    OSR(".osr");	//x-osu-replay	osu! replay

    public final String key;
    FileExts(String key){
        this.key = key;
    }
}
