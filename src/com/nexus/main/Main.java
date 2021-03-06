package com.nexus.main;

import com.nexus.osu.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Osu osu = new Osu(Path.of("C:\\Users\\Nexus\\Desktop\\Osu"));
        Thread t = new Thread(()-> {
            try {
                osu.Copy(Path.of("C:\\Users\\Nexus\\Music\\New folder"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t.setDaemon(true);
        t.start();
        Scanner in = new Scanner(System.in);
        System.out.print("Input: ");
        String str = in.nextLine();
        System.out.println("String: " +str);
    }
}
