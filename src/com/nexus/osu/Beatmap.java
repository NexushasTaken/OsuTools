package com.nexus.osu;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class Beatmap {
    public final LinkedList<OsuFile> osuFiles;
    public final File path;
    public final Long ID;
    public final LinkedList<File> folders;

    public final LinkedList<String> audios;

    @SuppressWarnings("ConstantConditions")
    public Beatmap(File path) throws IOException {
        this.path = path;
        this.audios = new LinkedList<>();
        this.osuFiles = new LinkedList<>();
        this.folders = new LinkedList<>();
        for (File file : this.path.listFiles()) {
            String tempName = file.getName();
            if (tempName.endsWith(FileExts.OSU.key)) this.osuFiles.add(new OsuFile(file));
            else if (Pattern.compile("(.mp3|.wav|.ogg)").matcher(file.getName()).find()) {
                this.audios.add(file.getName());
            } else if (file.isDirectory()) {
                this.folders.add(file);
            }
        }
        {
            String name = path.getName();
            String ID = name.substring(0, Math.max(name.indexOf(" "), 0));
            this.ID = ID.isEmpty() || ID.isBlank() ? Long.valueOf(0L) : Long.valueOf(ID);
        }
        removeAllBGMusic();
    }

    private void removeAllBGMusic() {
        for (OsuFile file : this.osuFiles)
            audios.remove(file.audio);
    }

    @SuppressWarnings("all")
    public static boolean isBeatmap(File path) {
        for (File file : path.listFiles()) {
            if (file.getName().endsWith(FileExts.OSU.key)) {
                return true;
            }
        }
        return false;
    }
}
