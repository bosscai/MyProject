package Job2019.B67;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" +");
        int nums = Integer.parseInt(strings[0]);
        int V = Integer.parseInt(strings[1]);
        String[] temps = reader.readLine().split(" +");
        int[] cur = new int[nums];
        for (int i=0;i<nums;i++){
            cur[i] = Integer.parseInt(temps[i]);
        }
//        int remain = nums % V;
//        if (remain == 0){
//            //没有余数
//        }else {
//            //存在余数
//        }
        Stack<ArrayList> stack = new Stack<>();
        ArrayList<Integer> list;
        for (int i=0;i<nums;){
            list = new ArrayList<>();
            for (int j=0;j<V && i < nums;j++){
                list.add(cur[i]);
                i++;
            }
            stack.add(list);
        }
        while (!stack.isEmpty()){
            String string = stack.pop().toString().replace(", ", " ");
            string = string.substring(1,string.length() - 1);
            System.out.print(string + " ");
        }

    }
}
