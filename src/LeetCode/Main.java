package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] nums = new int[n][2];
        for (int i=0;i<n;i++){
            String[] temp = reader.readLine().split(" +");
            nums[i][0] = Integer.parseInt(temp[0]);
            nums[i][1] = Integer.parseInt(temp[1]);
        }
        int temp = 0;
        for (int i=0;i<n;i++){
            if (nums[i][0] > nums[i][1]){
                System.out.println(nums[i][1]);
            }else {
                int numa = nums[i][0] - 1;
                int numb = nums[i][1];
                int numc = numb / numa;
                int numd = numb % numa;
                int res = numc * nums[i][0] + numd;
                if (numd == 0){
                    res--;
                }
                System.out.println(res);
            }
        }
    }
}
