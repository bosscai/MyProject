package Job2019.B72;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String[] b = a.split(" +");
        int[] nums = new int[b.length];
        int len = nums.length;
        for (int i=0;i<len;i++){
            nums[i] = Integer.parseInt(b[i]);
        }
        String c = reader.readLine();
        char[] d = c.toCharArray();
        int x = 1;
        int sum = 0;
        int head = 0;
        while (head < d.length){
            if (sum + nums[d[head] - 97] <= 100){
                sum += nums[d[head] - 97];
                head++;
            }else {
                x++;
                sum = 0;
            }
        }
        System.out.println(x + " " + sum );
        return;
    }
}
