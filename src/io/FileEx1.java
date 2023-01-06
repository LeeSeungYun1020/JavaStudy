package io;

import java.io.File;
import java.util.Arrays;

public class FileEx1 {
    public static void main(String[] args) {
        String current = System.getProperty("user.dir");
        File dir = new File(current + File.separator + "src" + File.separator + "io");
        String pattern = "java";
        Arrays.stream(dir.list(((dir1, name) -> {
            return name.indexOf(pattern) != -1;
        }))).sorted().forEach(System.out::println);
    }
}
