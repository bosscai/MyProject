package LeetCode.LC142;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-123));
    }
    public int reverse (int x) {
        long res = 0L;
        if (x >= 0){
            StringBuilder builder = new StringBuilder(String.valueOf(x));
            res = Long.parseLong(builder.reverse().toString());
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return 0;
            }else {
                return (int) res;
            }
        }else {
            x = x*(-1);
            StringBuilder builder = new StringBuilder(String.valueOf(x));
            res = Long.parseLong(builder.reverse().toString()) * (-1);
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return 0;
            }else {
                return (int) res;
            }
        }
    }
}
