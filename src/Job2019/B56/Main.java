package Job2019.B56;

import java.util.Scanner;

/**
 * 一共要走x+y步，结果C x+y x。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int res = 1;
        int num = x + y;
        solution(num, y);
    }
    public static void solution(int x, int y){
        long fenzi = 1;
        long fenmu = 1;
        for (int i=0;i<y;i++){
            fenzi *=x;
            x--;
        }
        for (int i=y;y>1;y--){
            fenmu *=y;
        }
        System.out.println(fenzi / fenmu);
    }
}
