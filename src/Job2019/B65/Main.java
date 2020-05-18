package Job2019.B65;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 可以先排序，然后直接取中间的数值。
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String temp = str.substring(1, str.length() - 1);
        String[] temps = temp.split(",+");
        int[] nums = new int[temps.length];
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            nums[i] = Integer.parseInt(temps[i]);
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > len/2 ){
                    System.out.println(nums[i]);
                    return;
                }
            }else {
                map.put(nums[i], 1);
            }
        }
        if (map.size() == 1){
            System.out.println(nums[0]);
            return;
        }
    }
}
