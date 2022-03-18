package com.osu.old;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

@SuppressWarnings("All")
public class Musics {
	File folder;

	ArrayList<Beatmap> beatmapList;

	public Musics(Path musics) throws IOException {
		this.folder = musics.toFile();
		beatmapList = new ArrayList<>();
		for (File beatmap : this.folder.listFiles()) {
			if (beatmap.isDirectory()) {
				beatmapList.add(new Beatmap(beatmap));
			}
		}
	}

	public void copyAudioSongs(Path path) throws IOException {
		for (Beatmap bmp : beatmapList) {
			if (!bmp.dotosuFiles.isEmpty()) {
				String audio = bmp.dotosuFiles.get(0).data.get(dotosu.Sections.General.key).get("AudioFilename");
				String title = bmp.dotosuFiles.get(0).data.get(dotosu.Sections.Metadata.key).get("Title")
						.replaceAll("[\\/:*?\"<>|]", "");
				String audioFormat = audio.substring(audio.length() - 4);

				Path audioPath = bmp.beatmapDir.toPath().resolve(audio);
				Path destPath = path.resolve(title + audioFormat);
				Files.copy(audioPath, destPath, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
			}
		}
		System.out.println("Done!");
	}

}
