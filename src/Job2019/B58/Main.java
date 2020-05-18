package Job2019.B58;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stringA = reader.readLine();
        String stringB = reader.readLine();
        String[] A = stringA.split(" +");
        String[] B = stringB.split(" +");
        int[] numA = new int[A.length];
        int[] numB = new int[B.length];
        for (int i=0;i<A.length;i++){
            numA[i] = Integer.parseInt(A[i]);
        }
        for (int i=0;i<B.length;i++){
            numB[i] = Integer.parseInt(B[i]);
        }
        int lenA = A.length;
        int lenB = B.length;
        int ahead = 0;
        int bhead = 0;
        while (ahead < lenA && bhead < lenB){
            if (numA[ahead] < numB[bhead]){
                System.out.print(numA[ahead]);
                System.out.print(" ");
                ahead++;
            }else {
                System.out.print(numB[bhead]);
                System.out.print(" ");
                bhead++;
            }
        }
        while (ahead < lenA){
            System.out.print(numA[ahead]);
            System.out.print(" ");
            ahead++;
        }
        while (bhead < lenB){
            System.out.print(numB[bhead]);
            System.out.print(" ");
            bhead++;
        }
    }
}
