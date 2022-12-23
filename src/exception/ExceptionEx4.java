package exception;

import java.io.File;

public class ExceptionEx4 {
    public static void main(String[] args) {
        try {
            File file = createFile(args[0]);
            System.out.println(file.getName() + "파일 생성 완료");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "파일명을 다시 입력하세요.");
        }

    }

    static File createFile(String fileName) throws Exception {
        if (fileName == null || fileName.isEmpty())
            throw new Exception("파일명이 유효하지 않습니다.");
        File file = new File(fileName);
        file.createNewFile();
        return file;
    }
}
