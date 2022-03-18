package com.nexus.main;

import com.nexus.osu.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        Osu osu = new Osu(Path.of("C:\\Users\\Nexus\\Desktop\\Osu"));
        osu.Copy(Path.of("C:\\Users\\Nexus\\Music\\New folder"));

    }
}
