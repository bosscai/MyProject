package Job2019.B76;

import java.awt.desktop.PreferencesEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] a = reader.readLine().split(" +");
        int x = Integer.parseInt(a[0]);
        int y = Integer.parseInt(a[1]);
//        int[][] nums = new int[x][y];
        int[] nums = new int[x*y];
        int head = 0;
        for (int i=0;i<x;i++){
            String b = reader.readLine();
            String[] c = b.split(" +");
            for (int j=0;j<y;j++){
//                nums[i][j] = Integer.parseInt(c[j]);
                nums[head] = Integer.parseInt(c[j]);
                head++;
            }
        }
        int res = Integer.parseInt(reader.readLine());
        reader.close();
        Main.mergeSort(nums);
        System.out.println(binarySearch(nums, 0, nums.length - 1, res));
        return;
    }

    public static boolean binarySearch(int[] nums, int left, int right, int res){
        if (left > right) return false;
        int mid = (left + right) / 2;
        if (nums[mid] == res){
            return true;
        }
        if (nums[mid] > res){
            return binarySearch(nums, left, mid - 1, res);
        }
        if (nums[mid] < res){
            return binarySearch(nums, mid + 1, right, res);
        }
        return false;
    }

    public static void mergeSort(int[] arr){
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] data, int left, int right){
        if (left >= right) return;
        int center = (left + right) / 2;
        sort(data, left, center);
        sort(data, center+1, right);
        merge(data, left, center, right);
    }
    public static void merge(int[] data, int left, int center, int right){
        //临时数组
        int[] tmpArr = new int[data.length];
        //右数组第一个元素索引
        int mid = center + 1;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        // 记录临时数组的索引
        int third = left;
        while (left <= center && mid <= right){
            //从两个数组中找到小值
            if (data[left] <= data[mid]){
                tmpArr[third++] = data[left++];
            }else {
                tmpArr[third++] = data[mid++];
            }
        }
        while (left <= center ){
            tmpArr[third++] = data[left++];
        }
        while (mid <= right){
            tmpArr[third++] = data[mid++];
        }
        while (tmp <= right){
            data[tmp] = tmpArr[tmp++];
        }
    }
}
