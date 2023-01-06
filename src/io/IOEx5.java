package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOEx5 {
    public static void main(String[] args) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            System.out.println("Encoding: " + inputStreamReader.getEncoding());
            String line;
            do {
                System.out.print(" >> ");
                line = bufferedReader.readLine();
                System.out.println(line);
            } while (!"exit".equalsIgnoreCase(line));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
