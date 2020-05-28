package Job2019.B77;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        br.close();

        long num = Long.parseLong(strs[0]);
        int radix = Integer.parseInt(strs[1]);
        StringBuilder sb = new StringBuilder();

        while (num >= radix) {
            sb.insert(0, num % radix);
            num /= radix;
        }
        sb.insert(0, num);

        System.out.println(sb);
    }
}