package Job2019.B68;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String string = reader.readLine();
        if (N % 3 != 1){
            return;
        }
        char[] res = string.toCharArray();
        int count = 0;
        int x = N / 3 * 2 + 1;
        char[][] chars = new char[N][N];
        int head = 0;
        int tail = x - 1;
        for (int i=0;i<x;i++){
            if (head != tail){
                chars[i][head] = res[count];
                count++;
                chars[i][tail] = res[count];
                count++;
                head++;
                tail--;
            }else {
                chars[i][head] = res[count];
                count++;
            }
        }
        for (int i=0;i<x;i++){
            for (int j=0;j<x;j++){
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }
}
