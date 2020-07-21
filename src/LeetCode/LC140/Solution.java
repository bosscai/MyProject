package LeetCode.LC140;

public class Solution {
    public boolean isPalindrome (int x) {
        // write code here
        if (x < 0 || (x > 0 && x%10==0)){
            return false;
        }
        int reverse = 0;
        while (x > reverse){
            reverse = reverse *10 + x%10;
            x = x / 10;
        }
        return  (reverse == x || reverse / 10 == x);
    }
}
