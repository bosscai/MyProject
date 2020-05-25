package Job2019.B75;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        long c = Long.parseLong(a);
        long d = Long.parseLong(b);
        scanner.close();
        System.out.println(c*d);
    }
}
