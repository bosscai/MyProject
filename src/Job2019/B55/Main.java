package Job2019.B55;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 广度优先遍历算法
 * [0]             第0层，
 * [1, -1]         第1层，上层的结果 +1，-1
 * [3, -1, 1, -3]  第2层，上层的结果 +2，-2
 * ...             第i层，上层的结果 +i，-i
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(reader.readLine());
        int sum = 0;
        int i = 0;
        while(sum != T){
            i++;
            sum += i;
            if(sum == T){
                System.out.println(i);
                return;
            }
            //sum与T必须同奇同偶，sum的范围是-sum到+sum
            if(sum >= T && (sum - T) % 2 == 0){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
