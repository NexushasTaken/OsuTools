package com.nexus.osu;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class OsuBeatmaps {
    public final File path;
    public final LinkedList<Beatmap> beatmaps;
    public final LinkedList<File> unknowns;
    @SuppressWarnings("ConstantConditions")
    public OsuBeatmaps(File path) throws IOException {
        this.path = path;
        this.beatmaps = new LinkedList<>();
        this.unknowns = new LinkedList<>();

        for(File file : path.listFiles()){
            if(file.isDirectory()){
                if(Beatmap.isBeatmap(file)){
                    this.beatmaps.add(new Beatmap(file));
                }
            }
            else
                this.unknowns.add(file);
        }
    }
}
