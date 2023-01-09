package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkEx1 {
    public static void main(String[] args) {
        try (
                BufferedReader input = new BufferedReader(
                        new InputStreamReader(
                                new URL("http://www.codechobo.com/main").openStream()
                        )
                )
        ) {
            String line = "";
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
