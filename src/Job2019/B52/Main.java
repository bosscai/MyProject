package Job2019.B52;

import java.util.Scanner;

public class Main {
    /**
     * N是点数的上限，K是点数的下限，W是随机取点数的上限。
     * 因此当初始点 i位于 [K,N]时，此时的dp[i]就是1。
     * 倘若 K−1+W的值大于N,那么当初始点数是K−1时，就有可能超出上限，
     * 这种情况我们要考虑进去，为了使索引和位置能对应，动态规划的范围就是[0,K−1+W]。
     * 其中当i处于[K,N]时，dp[i]=1;当 i 处于[N+1,K-1+W]时，dp[i]=0。
     * dp[i]=(dp[i+1],.......dp[i+W])/w
     * dp[i−1]=(dp[i],.......dp[i+W−1])/w
     * 计算 dp[i−1]，只需要在 dp[i]的公式基础上加一项 dp[i]， 再减一项 dp[i+W]
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int w = scanner.nextInt();
        double[] dp = new double[w + n + 1];
        for (int i=k;i<=n;i++){
            dp[i] = 1.0;
        }
        double s = Math.min(n-k+1, w);
        for (int i = k - 1; i >= 0; i--) {
            dp[i] = s / w * 1.00000;
            s += dp[i] - dp[i + w];
        }
        double ans = (int) (dp[0] * 100000 + 0.5) /100000.0;
        String string = String.valueOf(ans);
        StringBuilder res = new StringBuilder(string);
//        if (string.length() <= 7){
            for (int i=string.length();i<7;i++){
                res.append(0);
            }
//        }
        System.out.println(res);
    }
}
