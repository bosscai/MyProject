package Job2019.B57;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int n = scanner.nextInt();
        int len = chars.length;
        if (n < 0 || n >len){
            System.out.println(-1);
            return;
        }
        for (int i=0;i + n<=len;i++){
            StringBuilder builder = new StringBuilder();
            for (int j=i;j<n+i && i+n <=len;j++){
                builder.append(chars[j]);
            }
            System.out.print(builder);
            System.out.print(" ");
        }
    }
}
