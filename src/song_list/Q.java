package song_list;
/**
 *【题目描述】小Q有X首长度为A，Y首长度为B的不同歌，现在小Q想用这些歌组成一个总长度正好为K的歌单，
 * 每首最多只能在歌单中出现一次不考虑内曲先后顺序情况下，请问有多少种组成歌单的方法。
 *【输入描述】每个输入包含一个测试用例
 * 每个测试用例的第一行包含一个整数，表示歌单的总长度K(1<=K<=1000)。
 * 接下来的一行包含四个正整数，分别表示歌的第一种长度A(A<=10)和数量X(X<=100)以及歌的第二种长度B(B<=10)和数量Y（Y<=100),A不等于B
 * 【输出描述】输出一个整数，表示组成歌单的方法取模。因为答案可能会很大，输出对1000000007取模
 * 【输入实例】
 *5 2 3 3 3
 * 【输出实例】
 *9
 */

import java.util.Scanner;

public class Q {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a[] = new int[5];
        for (int i=0;i<a.length;i++){
            a[i] = scanner.nextInt();
        }
        Q.song(a);
    }
    public static void song (int a[]){
        int len = a[0];
        int lenA = a[1];
        int numA = a[2];
        int lenB = a[3];
        int numB = a[4];
        int mod = 1000000007;
        int size = 0;
        int ans = 0;
        /**
         * 先找出来有几种方式可以完成歌单长度
         */
        for (int i=0;i<=numA;i++){
            for (int j=0;j<=numB;j++){
                if (lenA*i + lenB*j == len){
                    size ++;
                }
            }
        }
        int Ca[] = new int[size];
        int Cb[] = new int[size];
        int x = 0;
        for (int i=0;i<=numA;i++){
            for (int j=0;j<=numB;j++){
                if (lenA*i + lenB*j == len){
                    Ca[x] = i;
                    Cb[x] = j;
                    x++;
                }
            }
        }
        for (int i=0;i<Ca.length;i++){
            long ansA = Q.factorial(numA)/(Q.factorial(Ca[i]) * Q.factorial(numA-Ca[i]));
            long ansB = Q.factorial(numB)/(Q.factorial(Cb[i]) * Q.factorial(numB-Cb[i]));
            ans = ans + (int)ansA*(int)ansB;
        }

        System.out.println(ans%mod);
    }

    /**
     * 阶乘的实现方式
     * @param n
     * @return
     */
    private static long factorial(int n) {
        long sum = 1;
        while( n > 0 ) {
            sum = sum * n--;
        }
        return sum;
    }
}

