package Job2019.B64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String temp = str.substring(1, str.length() - 1);
        String[] temps = temp.split(",+");
        boolean[] flag = new boolean[temps.length];
        flag[0] = true;
        int[] nums = new int[temps.length];
        for (int i=0;i<nums.length;i++){
            nums[i] = Integer.parseInt(temps[i]);
        }
        int position = 0;
        while (true){
            //位置的值为上一个数组的内容
            position = nums[position] + position;
            if (position < 0 || position > nums.length - 1){
                System.out.println(true);
                return;
            }
            if (flag[position]){
                System.out.println(false);
                return;
            }else {
                flag[position] = true;
            }
        }
//        System.out.println(flag[0]);

    }
}
