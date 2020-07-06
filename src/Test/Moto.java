package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Moto {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line1 = reader.readLine();
        String[] split1 = line1.split(" +");
        //col N row M
        int N = Integer.parseInt(split1[0]);
        int M = Integer.parseInt(split1[1]);
        int[][] temp = new int[N][M];
        int K = Integer.parseInt(split1[2]);
        String[] line2 = new String[K];
        for (int i=0;i<K;i++){
            line2[i] = reader.readLine();
        }
        //将有数的存在HashMap中
        HashMap<String, String> map = new HashMap<>();
        for (int i=0;i<K;i++){
            map.put(line2[i].substring(0, 3),line2[i].substring(4));
        }
        //操作次数
        int Q = Integer.parseInt(reader.readLine());
//        String[] line3 = new String[Q];
        for (int i=0;i<Q;i++){
            String s = reader.readLine();
            String temp1 = s.substring(0,1);
            String temp2 = s.substring(2);
            switch (temp1){
                case "0":
                    charge(temp2);
                    break;
                case "1":
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Error!!!");
                    return;
            }
        }

    }

    private static void charge(String temp) {
//        if ()
    }
}
