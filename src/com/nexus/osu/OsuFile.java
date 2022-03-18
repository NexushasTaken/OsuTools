package com.nexus.osu;

import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.util.HashMap;

public final class OsuFile {
    public final String title;
    public final String audio;
    public String version;
    public File file;
    public HashMap<String, HashMap<String, String>> struct;
    //             Section         Option  Value

    // OGeneral-Difficulty
    public OsuFile(File path) throws IOException {
        this.file = path;
        BufferedReader read = new BufferedReader(new FileReader(path));
        struct = new HashMap<>();
        String line = read.readLine();
        if (line.contains("osu file format"))
            getVersion(line);
        while (read.ready()) {
            line = read.readLine();
            if (line.startsWith(Sections.General))
                put(read, Sections.General);
            else if (line.startsWith(Sections.Editor))
                put(read, Sections.Editor);
            else if (line.startsWith(Sections.Metadata))
                put(read, Sections.Metadata);
            else if (line.startsWith(Sections.Difficulty))
                put(read, Sections.Difficulty);
            else if (line.startsWith(Sections.Events))
                break;
        }
        this.title = this.struct.get(Sections.Metadata).get(OMetaData.Title);
        this.audio = this.struct.get(Sections.General).get(OGeneral.AudioFilename);
    }

    private String get(String section) {
        return null;
    }

    private void put(BufferedReader read, String section) throws IOException {
        HashMap<String, String> options = new HashMap<>();
        String temp;
        while (!(temp = read.readLine()).isEmpty()) {
            String[] kv = null;
            {
                String[] tempKV = temp.split(":");
                if (tempKV.length == 1)
                    kv = new String[]{tempKV[0], ""};
                else
                    kv = tempKV;
            }
            options.put(kv[0].trim(), kv[1].trim());
        }
        this.struct.put(section, options);
    }

    private void getVersion(String line) {
        this.version = line.substring(line.lastIndexOf(" ") + 1);
    }
}
