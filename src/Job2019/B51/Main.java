package Job2019.B51;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] a;
    private static int res = 0;

    private static void merge(int[] a, int i, int mid, int j) {
        int[] help = new int[j - i + 1];
        int p = i, q = mid + 1, t = 0;
        while (p < mid + 1 && q < j + 1) {
            if (a[p] <= a[q]) help[t++] = a[p++];
            else {
                res += (mid + 1 - p);
                help[t++] = a[q++];
            }
        }
        while (p < mid + 1) help[t++] = a[p++];
        while (q < j + 1) help[t++] = a[q++];
        System.arraycopy(help, 0, a, i, help.length);
    }

    private static void mergeSort(int[] a, int i, int j) {
        if (i < j) {
            int mid = i + ((j - i) >> 1);
            mergeSort(a, i, mid);
            mergeSort(a, mid + 1, j);
            merge(a, i, mid, j);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(bf.readLine());
        }
        mergeSort(a, 0, a.length - 1);
        System.out.println(res);
    }
}
