package Algorithm.Dynamic;

import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};
        int[] val = {1500, 3000, 2000};
        int m = 4;  //背包的容量
        int n = val.length;     //物品的数量

        //创建二维数组
        int[][] arr = new int[n + 1][m+1];
        //记录放入情况的二维数组
        int[][] path = new int[n + 1][m+1];

        //将第一行和第一列分别设置为“0”，默认也是“0”
        for (int i=1;i<arr.length;i++){         //第一行全为“0”，不进行处理。
            for (int j=1;j<arr[i].length;j++){  //不处理第一列
                if (w[i-1] > j){                  //因为i是从“1”开始的所以要i-1
                    arr[i][j] = arr[i - 1][j];
                }else {                           //因为i是从“1”开始的所以要i-1
//                    arr[i][j] = Math.max(arr[i - 1][j], val[i-1] + arr[i-1][j - w[i-1]]);
//                    为了记录背包的路径
                    if (arr[i-1][j] < val[i-1] + arr[i-1][j - w[i-1]]){
                        arr[i][j] = val[i-1] + arr[i-1][j - w[i-1]];
                        path[i][j] = 1;
                    }else {
                        arr[i][j] = arr[i-1][j];
                    }
                }
            }
        }

//        for (int i=0;i<arr.length;i++){
//            for (int j=0;j<arr[0].length;j++){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
        for (int[] a : arr){
            System.out.println(Arrays.toString(a));
        }

        int i = arr.length - 1;
        int j = arr[0].length - 1;
        while (i>0 && j>0){
            if (path[i][j] == 1){
                System.out.println("第" + i + "个商品放进了背包");
                j -= w[i - 1];
            }
            i--;
        }
    }
}
