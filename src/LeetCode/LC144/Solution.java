package LeetCode.LC144;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.longestPalindrome("abcbadef");
        System.out.println(s);
    }
    public String longestPalindrome (String s) {
        // write code here
        int len = s.length();
        int maxLen = 1;
        int begin = 0;
        if (len < 2){
            return s;
        }
        boolean[][] flags = new boolean[len][len];
        for (int i=0;i<len;i++){
            flags[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int j=1;j<len;j++){
            for (int i=0;i<j;i++){
                if (chars[i] != chars[j]){
                    flags[i][j] = false;
                }else {
                    if (j - i < 3){
                        flags[i][j] = true;
                    }else {
                        flags[i][j] = flags[i+1][j-1];
                    }
                }
                if (flags[i][j] && j-i+1>maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
