package io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOEx2 {
    public static void main(String[] args) {
        int[] score = {100, 90, 85, 95, 77};
        try (FileOutputStream fos = new FileOutputStream("data" + File.separator + "score.dat");
             DataOutputStream dos = new DataOutputStream(fos)) {
            for (int s : score) {
                dos.writeInt(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
