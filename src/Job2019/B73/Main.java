package Job2019.B73;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String[] b = a.split(" +");
        int len = b.length;
        int[] c = new int[len];
        int res = 0;
        for (int i=0;i<len;i++){
            c[i] = Integer.parseInt(b[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<len;i++){
            if (map.containsKey(c[i])){
                map.put(c[i], map.get(c[i])+1);
            }else {
                map.put(c[i], 1);
            }
        }
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getKey() == 0){
                res += entry.getValue();
            }else {
                res += (entry.getValue() + 1) / 2 * entry.getKey();
            }
        }
        System.out.println(res);
        return;
    }
}
