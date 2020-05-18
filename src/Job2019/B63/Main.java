package Job2019.B63;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String[] strings = string.split(";");
        String A = strings[0];
        String B = strings[1];
        for (int i=0;i<A.length();i++){
            if (A.charAt(i) == B.charAt(0)){
                String temp1 = A.substring(0, i);
                String temp2 = A.substring(i);
                if (B.equals(temp2 + temp1)){
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }
}
