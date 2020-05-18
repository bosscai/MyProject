package Job2019.B62;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String[] strs = str.split(" +");
        int k = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);
        int[] arb = new int[n*n];
        for (int i=0;i<n*n;){
            String string = reader.readLine();
            String[] strings = string.split(" +");
            for (int j=0;j<n;j++){
                arb[i] = Integer.parseInt(strings[j]);
                i++;
            }
        }
        Arrays.sort(arb);
        System.out.println(arb[k-1]);
    }
}
