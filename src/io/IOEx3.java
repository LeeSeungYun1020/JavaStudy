package io;

import java.io.*;

public class IOEx3 {
    public static void main(String[] args) {
        int sum = 0;

        try (FileInputStream fis = new FileInputStream("data/score.dat");
             DataInputStream dis = new DataInputStream(fis)) {
            while (true) {
                int score = dis.readInt();
                System.out.println(score);
                sum += score;
            }
        } catch (EOFException e) {
            System.out.println("SUM: " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("data" + File.separator + "score.dat");
             DataInputStream dis = new DataInputStream(fis)) {
            sum = 0;
            while (dis.available() > 0) {
                int score = dis.readInt();
                System.out.println(score);
                sum += score;
            }
            System.out.println("SUM: " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
