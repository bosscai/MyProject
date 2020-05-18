package Job2019.B60;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.charAt(0) == '-'){
            StringBuffer buffer = new StringBuffer(str.substring(1));
//            buffer.reverse();
            System.out.println("-" + buffer.reverse());
            return;
        }else {
            StringBuffer buffer = new StringBuffer(str);
            System.out.println(buffer.reverse());
            return;
        }
    }
}
