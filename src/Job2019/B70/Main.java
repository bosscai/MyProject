package Job2019.B70;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //几组数据
        int n = Integer.parseInt(reader.readLine());
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        for (int i=0;i<n;i++){
            map.put(reader.readLine(), reader.readLine());
        }
        String[] res = new String[n];
        for (String value:map.values()) {
            String[] strings = value.split(" +");
            Stack<String> stack = new Stack<>();
            for (int i=0;i<strings.length;i++){
//                if (stack.isEmpty() || !stack.contains(strings[i])){
                    stack.push(strings[i]);
//                }
            }
            StringBuilder builder = new StringBuilder();
            while (!stack.isEmpty()){
                if (builder.toString().contains(stack.peek())){
                    stack.pop();
                }else {
                    builder.append(stack.pop()).append(" ");
                }
            }
            System.out.println(builder.toString());
        }
    }
}
