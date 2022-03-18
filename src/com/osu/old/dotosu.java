package com.osu.old;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class dotosu {

	String fileFormatV;
	// Section, Options=Data
	public HashMap<String, HashMap<String, String>> data;
	File osuPath;

	public dotosu(File osu) throws IOException {
		this.osuPath = osu;
		BufferedReader read = new BufferedReader(new FileReader(osu.toString()));
		this.data = new HashMap<>();
		String line = null;
		String key = null;
		while ((line = read.readLine().trim()) != null) {
			if (line.equals("")) {
				continue;
			} else if (line.contains("osu file format v")) {
				this.fileFormatV = getFileVersion(line);
				continue;
			} else if (line.startsWith(Sections.General.key)) {
				this.data.put(Sections.General.key, new HashMap<String, String>());
				key = Sections.General.key;
				continue;
			} else if (line.startsWith(Sections.Editor.key)) {
				this.data.put(Sections.Editor.key, new HashMap<String, String>());
				key = Sections.Editor.key;
				continue;
			} else if (line.startsWith(Sections.Metadata.key)) {
				this.data.put(Sections.Metadata.key, new HashMap<String, String>());
				key = Sections.Metadata.key;
				continue;
			} else if (line.startsWith(Sections.Difficulty.key)) {
				this.data.put(Sections.Difficulty.key, new HashMap<String, String>());
				key = Sections.Difficulty.key;
				continue;
			} else if (line.startsWith(Sections.Events.key)) {
				break;
			}
			String[] oD = line.split(":");
			this.data.get(key).put(oD[0].trim(), oD.length == 2 ? oD[1].trim() : "");
		}
		
//		for (String content : data.keySet()) {
//			System.out.println(content);
//			HashMap<String, String> contentTemp = this.data.get(content);
//			for (String option : contentTemp.keySet()) {
//				System.out.println(option + " : " + contentTemp.get(option));
//			}
//		}
	}

	private String getFileVersion(String line) {
		return line.substring(line.lastIndexOf('v') + 1);
	}

	public static boolean isOsuFile(File f) {
		return f.toString().endsWith(".osu");
	}

	static public enum Sections {
		General("[OGeneral]"), Editor("[OEditor]"), Metadata("[Metadata]"), Difficulty("[Difficulty]"),
		Events("[Events]"), TimingPoints("[TimingPoints]");

		String key;

		Sections(String key) {
			this.key = key;
		}
	}
}
