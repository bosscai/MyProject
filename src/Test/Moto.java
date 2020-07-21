package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Moto {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" +");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        String[] split1 = reader.readLine().split(" +");
        int x = Integer.parseInt(split1[0]);
        int y = Integer.parseInt(split1[1]);
        char[][] chars = new char[m][n];
        for (int i=0;i<m;i++){
            char[] split2 = reader.readLine().toCharArray();
            for (int j=0;j<n;j++){
                chars[i][j] = split2[j];
            }
        }
        boolean[][] flags = new boolean[m][n];
        //宽度优先遍历
        Queue<int[]> lists = new LinkedList<>();
        if (chars[x][y] == '*'){
            System.out.println("GG");
        }else {
            addNum(x, y, lists, flags);
        }
        //不等于空的时候开始遍历
        while (!lists.isEmpty()){
            int[] temp = lists.poll();
            //周围地雷的个数
            int count = bfs(temp[0], temp[1], chars);
            if (count != 0){

            }else {

            }
            //左上
            if (temp[0]-1 >= 0 && temp[1]-1 >= 0){
                if (chars[temp[0]-1][temp[1]-1]=='*'){
                    count++;
                }else{
                    addNum(temp[0]-1, temp[1]-1, lists, flags);
                }
            }
            if (temp[0]-1 >= 0){
                //上
                if (chars[temp[0]-1][temp[1]]=='*'){
                    count++;
                }else {
                    addNum(temp[0]-1, temp[1], lists, flags);
                }
            }
            if (temp[0]-1 >= 0 && temp[1] + 1 < n){
                //右上
                if (chars[temp[0]-1][temp[1]+1]=='*'){
                    count++;
                }else {
                    addNum(temp[0]-1, temp[1]+1, lists, flags);
                }
            }
            if (temp[1]+1 < n){
                //右
                if (chars[temp[0]][temp[1]+1]=='*'){
                    count++;
                }else {
                    addNum(temp[0], temp[1]+1, lists, flags);
                }
            }
            if (temp[0]+1 < m && temp[1]+1 < n){
                //右下
                if (chars[temp[0]+1][temp[1]+1]=='*'){
                    count++;
                }else {
                    addNum(temp[0]+1, temp[1]+1, lists, flags);
                }
            }
            if (temp[0]+1 < m){
                //下
                if (chars[temp[0]+1][temp[1]]=='*'){
                    count++;
                }else {
                    addNum(temp[0] + 1, temp[1], lists, flags);
                }
            }
            if (temp[0]+1 < m && temp[1]-1 >= 0){
                //左下
                if (chars[temp[0]+1][temp[1]-1]=='*'){
                    count++;
                }else {
                    addNum(temp[0] + 1, temp[1] - 1, lists, flags);
                }
            }
            if (temp[1]-1 >= 0){
                //左
                if (chars[temp[0]][temp[1]-1]=='*'){
                    count++;
                }else {
                    addNum(temp[0], temp[1]-1, lists, flags);
                }
            }
            chars[temp[0]][temp[1]] = (char)('1' - 1 + count);
        }
        for (char[] temp : chars){
            System.out.println(Arrays.toString(temp));
        }
    }
    public static void addNum(int x, int y, Queue<int[]> lists, boolean[][] flags){
        if (!flags[x][y]){
            int[] temp = new int[2];
            temp[0] = x;
            temp[1] = y;
            lists.add(temp);
            flags[x][y] = true;
        }
    }
    public static int bfs(int x, int y, char[][] chars){
        int m = chars.length;
        int n = chars[0].length;
        int count = 0;
        //左上
        if (x-1 >= 0 && y-1 >= 0){
            if (chars[x-1][y-1]=='*'){
                count++;
            }
        }
        if (x-1 >= 0){
            //上
            if (chars[x-1][y] == '*'){
                count++;
            }
        }
        if (x -1 >= 0 && y + 1 < n){
            //右上
            if (chars[x - 1][y + 1]=='*'){
                count++;
            }
        }
        if (y+1 < n){
            //右
            if (chars[x][y+1] == '*'){
                count++;
            }
        }
        if (x+1 < m && y+1 < n){
            //右下
            if (chars[x+1][y+1] == '*'){
                count++;
            }
        }
        if (x+1 < m){
            //下
            if (chars[x+1][y]=='*'){
                count++;
            }
        }
        if (x+1 < m && y-1 >= 0){
            //左下
            if (chars[x+1][y-1] == '*'){
                count++;
            }
        }
        if (y-1 >= 0){
            //左
            if (chars[x][y-1] == '*'){
                count++;
            }
        }
        chars[x][y] = (char)('1' - 1 + count);
        return count;
    }
}
