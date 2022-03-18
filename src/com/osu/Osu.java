package com.osu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Osu {

	private enum Folders {
		Songs
	}

	Musics musics;
	File osuPath;

	public Osu(Path osu) throws IOException {
		osuPath = osu.toFile();
		if (osuPath.exists()) {
			this.musics = new Musics(osu.resolve(Folders.Songs.toString()));
		} else
			System.out.println("Invalid Osu Path");
	}

}
