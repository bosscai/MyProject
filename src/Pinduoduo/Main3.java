package Pinduoduo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] x = reader.readLine().split(" +");
        int n = Integer.parseInt(x[0]);
        int m = Integer.parseInt(x[1]);
        String[] y  = reader.readLine().split(" +");
        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = Integer.parseInt(y[i]);
        }
        Arrays.sort(nums);
//        for (int i=0;i<m;i++){
////            if (nums[n-1] - nums[0] > 1){
////                nums[0]++;
////                nums[n-1]--;
////                Arrays.sort(nums);
////            }else {
////                break;
////            }
////        }
        while (nums[n-1] - nums[0] > 1 && m>0){
            nums[0]++;
            nums[n-1]--;
            Arrays.sort(nums);
            m--;
        }
        System.out.println(nums[n-1] - nums[0]);
    }
}
