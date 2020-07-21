package LeetCode.LC148;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = {5, 75, 25};
        int target = 100;
        System.out.println(Arrays.toString(solution.twoSum(num, target)));
    }
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] res = new int[2];
        int len = numbers.length;
        if (len < 2){
            return null;
        }
        for (int i=0;i<len;i++){
            for (int j=i+i;j<len;j++){
                if (numbers[i]+numbers[j] == target){
                    if (i <= j){
                        res[0] = i + 1;
                        res[1] = j + 1;
                    }else {
                        res[0] = j + 1;
                        res[1] = i + 1;
                    }
                }
            }
        }
        return res;
    }
}
