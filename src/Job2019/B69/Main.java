package Job2019.B69;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] strings = new String[n];
        for (int i=0;i<n;i++){
            strings[i] = reader.readLine();
        }

        for (int i=0;i<n;i++){
            if (judge(strings[i])){
                //是合理的时间
                System.out.println(strings[i]);
            }else {
                //不是合理的时间
                char[] chars = strings[i].toCharArray();
                if (chars[0] > '2'){
                    chars[0] = '0';
                }
                if (chars[0] == '2' && chars[1] > '3'){
                    chars[0] = '0';
                }
                if (chars[3] > '5'){
                    chars[3] = '0';
                }
                if (chars[6] > '5'){
                    chars[6] = '0';
                }
//                System.out.println();
                for (int j=0;j<chars.length;j++){
                    System.out.print(chars[j]);
                }
                System.out.println();
            }
        }
    }
    public static boolean judge(String string){
        String strDate  = string;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date dateTime = null;
        try {
            dateTime = formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatter.format(dateTime).equals(strDate);
    }
}
