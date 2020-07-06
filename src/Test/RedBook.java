package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedBook {
    //完全背包问题
    private static int a = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" +");
        int num = Integer.parseInt(s[0]);
        String temp = s[1].substring(1,s[1].length()-1);
        String[] split = temp.split(",+");
        int[] res = new int[split.length];
        for (int i=0;i<split.length;i++){
            res[i] = Integer.parseInt(split[i]);
        }
        int[] arr = new int[num + 1];
        arr[0] = 1;
        for(int a : res){
            //a为当前的价格；
            for (int i=a;i<arr.length;i++){
                arr[i] = arr[i] + arr[i - a];
            }
        }
        System.out.println(arr[num]);
//        System.out.println(temp);
    }
}
