package useful;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Useful7 {
    public static void main(String[] args) {
        String source = "A broken hand works, but not a broken heart.";
        String pattern = "broken";
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        System.out.println("Source: " + source);

        while (m.find()) {
            System.out.println("매칭: " + m.start() + "~" + m.end());
            m.appendReplacement(sb, "drunken");
        }
        m.appendTail(sb);
        System.out.println("result: " + sb.toString());
    }
}
