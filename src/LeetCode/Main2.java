package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] nums = new int[n][2];
        for (int i=0;i<n;i++){
            String[] temp = reader.readLine().split(" +");
            nums[i][0] = Integer.parseInt(temp[0]);
            nums[i][1] = Integer.parseInt(temp[1]);
        }
        Arrays.sort(nums, ((o1, o2) -> o1[0] - o2[0]));
        int res = 0;
        if (n == 1){
            System.out.println(nums[0][1]);
            return;
        }
        for (int i=1;i<n;i++){
            if (nums[i][1] < nums[i-1][0]){
                res = res > nums[i][0]+nums[i-1][1] ? res : nums[i][0]+nums[i-1][1];
            }else {
                int temp = nums[i][0] > nums[i][1]+nums[i-1][1] ? nums[i][0] : nums[i][1]+nums[i-1][1];
                res = res > temp ? res : temp;
            }
        }
        System.out.println(res);
    }
}

