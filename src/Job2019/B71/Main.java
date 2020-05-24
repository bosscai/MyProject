package Job2019.B71;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
//    选取右方、下方、或右下45度方向作为单词的延伸方向
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] res = new int[n];
        //以下是循环部分
        for (int i=0;i<n;i++){
            String[] temp = reader.readLine().split(" +");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            char[][] chars = new char[x][y];
            //将输入的
            for (int j=0;j<x;j++){
                chars[j] = reader.readLine().toCharArray();
            }
            String  cur = reader.readLine();
            res[i] = judge(chars,cur);
        }
        for (int i=0;i<n;i++){
            System.out.println(res[i]);
        }
    }
    public static int judge(char[][] chars, String temp){
        char[] cur = temp.toCharArray();
        int curLen = cur.length;
        int head = 0;
        int x = chars.length;
        int y = chars[0].length;
        int res = 0;
        StringBuilder builder;
        for(int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                if (chars[i][j] == cur[head]){
                    builder = new StringBuilder();
                    //向右判断
                    for (int k=j;k<j+curLen && k < y;k++){
                        builder.append(chars[i][k]);
                    }
                    if (builder.toString().equals(temp)){
                        res++;
//                        builder = null;
                    }
                    //向下判断
                    builder = new StringBuilder();
                    for (int k=i;k<i+curLen && k < x;k++){
                        builder.append(chars[k][j]);
                    }
                    if (builder.toString().equals(temp)){
                        res++;
//                        builder = null;
                    }
                    //向右下判断
                    builder = new StringBuilder();
                    for (int k=i,l=j;k < x && k<i+curLen && l < y && l <j + curLen;k++, l++){
                        builder.append(chars[k][l]);
                    }
                    if (builder.toString().equals(temp)){
                        res++;
//                        builder = null;
                    }
                }
            }
        }
        return res;
    }
}
