package com.nexus.osu;

import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.util.HashMap;

public final class OsuFile {
    private String version;
    private HashMap<Sections, HashMap<String, String>> struct;

    // General-Difficulty
    public OsuFile(File path) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(path));
        struct = new HashMap<>();
        String line = read.readLine();
        if (line.contains("osu file format"))
            getVersion(line);
        while (read.ready()) {
            line = read.readLine();
            if(line.isBlank() || line.isEmpty())
                continue;
//            else if (line.startsWith(Sections.General.key))
//                put(read, Sections.General);
//            else if (line.startsWith(Sections.Editor.key))
//                put(read, Sections.Editor);
//            else if (line.startsWith(Sections.Metadata.key))
//                put(read, Sections.Metadata);
//            else if (line.startsWith(Sections.Difficulty.key))
//                put(read, Sections.Difficulty);
//            else if (line.startsWith(Sections.Events.key))
//                break;

            // Temporary Code
            for (Sections sec : Sections.values()) {
                if(isSectionKV(sec))
                    put(read, sec);
                else if(sec.equals(Sections.Events))
                    break;
            }

        }
    }

    private boolean isSectionKV(Sections sec) {
        return sec.equals(Sections.General) ||
                sec.equals(Sections.Editor) ||
                sec.equals(Sections.Metadata) ||
                sec.equals(Sections.Difficulty);
    }

    private void put(BufferedReader read, Sections section) throws IOException {
        HashMap<String, String> options = new HashMap<>();
        String temp = read.readLine();
        while (!temp.isBlank()) {
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
