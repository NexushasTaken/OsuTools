package com.nexus.osu;

public enum Sections {
    General("[General]"),           // General information about the beatmap	key:value pairs
    Editor("[Editor]"),             // Saved settings for the beatmap editor	key:value pairs
    Metadata("[Metadata]"),         // Information used to identify the beatmap	key:value pairs
    Difficulty("[Difficulty]"),     // Difficulty settings	                    key:value pairs
    Events("[Events]"),             // Beatmap and storyboard graphic events	Comma-separated lists
    TimingPoints("[TimingPoints]"),	// Timing and control points	            Comma-separated lists
    Colours("[Colours]"),	        // Combo and skin colours	                key : value pairs
    HitObjects("[HitObjects]");	    // Hit objects                              Comma-separated lists
    final String key;
    Sections(String section){
        this.key = section;
    }
}
