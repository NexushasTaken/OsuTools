package com.nexus.osu;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@SuppressWarnings("ConstantConditions")
public class Osu implements OsuUtils {
    public Path path;
    public OsuBeatmaps beatmaps;

    public Osu(Path path) throws IOException {
        this.path = path;
        this.beatmaps = new OsuBeatmaps(path.resolve("Songs").toFile());

    }

    @Override
    public void Copy(Path dest) throws IOException {
        for (Beatmap beatmap : this.beatmaps.beatmaps) {
            for (OsuFile osu : beatmap.osuFiles) {
                File file = dest.resolve(osu.title.replaceAll("[\\/:*?\"<>|]", "") + osu.audio.substring(osu.audio.lastIndexOf("."))).toFile();
                if (!file.exists()) Files.copy(beatmap.path.toPath().resolve(osu.audio), file.toPath());
            }
        }
    }
}
