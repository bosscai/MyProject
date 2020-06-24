package Algorithm.KMP;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
//        int[] arr = kmpnext("AAAAB");
        int arr = kmpSearch(str1, str2, kmpnext(str2));
        System.out.println(arr);
    }

    //写出我们的kmp搜索算法
    /**
     * @param str1  源字符串
     * @param str2  子串
     * @param next  子串对应的部分匹配表
     * @return
     */
    public static int kmpSearch(String str1, String str2, int[] next){
        for (int i=0, j=0;i<str1.length();i++){
            //需要考虑str1.charAt(i) ！= str2.charAt(j)的这种情况
            while (j>0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if (j == str2.length()){
                //找到了，返回下标
                return i-j+1;
            }
        }
        return -1;
    }

    //获取部分匹配值的表
    public static int[] kmpnext(String dest){
        int[] next = new int[dest.length()];

        for (int i=1, j=0;i<dest.length();i++){
            //当dest.charAt(i) != dest.charAt(j),这是kmp算法的核心点
            while (j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)){
                //当这个条件满足时，部分匹配值＋一
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
