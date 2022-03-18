package com.osu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Beatmap {
	
	final File beatmapDir;
	final String ID;
	
	ArrayList<File> audios;
	ArrayList<dotosu> dotosuFiles;

	public Beatmap(File beatmap) throws IOException {
		this.beatmapDir = beatmap;
		this.dotosuFiles = new ArrayList<>();
		this.audios = new ArrayList<File>();
		ID = getId(beatmap.getName());
		for(File files : beatmapDir.listFiles()) {
			if(dotosu.isOsuFile(files)) {
				this.dotosuFiles.add(new dotosu(files));
			}
			else if(Pattern.compile("(.mp3|.wav|.ogg)").matcher(files.getName()).find()) {
				audios.add(files);
			}
		}
	}
	
	private String getId(String name) {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < name.length(); i++) {
			char temp = name.charAt(i);
			if(Character.isDigit(temp) && !Character.isWhitespace(temp))
				str.append(temp);
			else break;
		}
		if(!name.toString().startsWith(str.toString()))
			System.out.println("Something Went Wrong with " + name);
		return str.toString();
	}

}
