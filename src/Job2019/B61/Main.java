package Job2019.B61;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        while (str1.length() != str2.length()){
            if (str1.length() > str2.length()){
                str2 = "0" + str2;
            }else {
                str1 = "0" + str1;
            }
        }
        int carry = 0;  //保存进位
        int sum = 0;    //保存两位之和
        int opa = 0;
        int opb = 0;
        StringBuilder builder = new StringBuilder();
        for (int i=str1.length()-1;i>=0;i--){
            opa = str1.charAt(i) - '0';
            opb = str2.charAt(i) - '0';
            sum = opa + opb +carry;
            if (sum >=2){
                carry = 1;
                builder.append(sum-2);
            }else {
                carry = 0;
                builder.append(sum);
            }
        }
        if (carry == 1){
            builder.append("1");
        }
        System.out.println(builder.reverse().toString());
   }
}
