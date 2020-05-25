package Job2019.B74;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] a = reader.readLine().split(" +");
        int x = Integer.parseInt(a[0]);
        int y = Integer.parseInt(a[1]);
        int[][] nums = new int[x][y];
        
        reader.close();
    }
}
