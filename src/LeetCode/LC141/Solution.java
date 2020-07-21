package LeetCode.LC141;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.atoi("-117e40091539"));
    }
    public int atoi (String str) {
        // write code here
        if (str == null || str.equals("")){
            return 0;
        }
        char[] chars = str.trim().toCharArray();
        StringBuilder builder = new StringBuilder();
        int count = 0;
        boolean flag = true;
        for (int i=0;i<chars.length;i++){
            if (chars[i] == '+'){
//                flag = true;
                continue;
            }else if (chars[i] == '-'){
//                flag = true;
                count++;
                continue;
            }else {
                if (chars[i] == '0' && flag){
                    continue;
                }else {
                    if (chars[i] > '9' || chars[i] < '0'){
                        break;
                    }
                    builder.append(chars[i] -('1' - 1));
                    flag = false;
                }
            }
        }
        if (count % 2 == 0){
            long l = Long.parseLong(builder.toString());
            if (l > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else {
                return (int)l;
            }
        }else {
            long l = Long.parseLong(builder.toString())*(-1);
            if (l < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else {
                return (int)l;
            }
        }
    }
}
