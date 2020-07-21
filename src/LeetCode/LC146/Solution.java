package LeetCode.LC146;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String s= "abcabcbb";
        Solution solution = new Solution();
        int res = solution.lengthOfLongestSubstring(s);
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring (String s) {
        // write code here
       if (s == null || s.length() == 0){
           return 0;
       }
        HashMap<Character, Integer> map = new HashMap<>();
       int leftBond = 0;
       int max = 0;
       for (int i=0;i<s.length();i++){
           char c= s.charAt(i);
           //先判断是否包含，不包含则为0，包含的话取出位置加一是为了向右移一位。
           leftBond = Math.max(leftBond, (map.containsKey(c))?map.get(c)+1:0);
           max = Math.max(max, i - leftBond + 1);
           //将字符和位置重新，放进去
           map.put(c, i);
       }
       return max;
    }
}
