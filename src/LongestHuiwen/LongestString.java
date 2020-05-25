package LongestHuiwen;

public class LongestString {
    //T（n2），S（n2）
    public static String longestString(String temp){
        int len = temp.length();
        if (len < 2) return temp;
        int maxLen = 1;
        int begin = 0;

        //dp[i][j]表示s[i...j]是否是回文数
        boolean[][] flag = new boolean[len][len];
        for (int i=0;i<len;i++){
            flag[i][i] = true;
        }
        char[] chars = temp.toCharArray();
        //左下角先填充
        for (int j=1;j<len;j++){
            for (int i=0;i<j;i++){
                if (chars[i] != chars[j]){
                    flag[i][j] = false;
                }else {
                    //去掉头尾之后没有字符就是true
                    if (j - i < 3){
                        flag[i][j] = true;
                    }else {
                        flag[i][j] = flag[i+1][j-1];
                    }
                }
                //只要flag为true，就表示字符串s[i,j]是回文数
                if (flag[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return temp.substring(begin, begin + maxLen);
    }
}
