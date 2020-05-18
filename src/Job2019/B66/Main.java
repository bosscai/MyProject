package Job2019.B66;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String temp = str.substring(1, str.length() - 1);
        String[] temps = temp.split(",+");
        int[] nums = new int[temps.length];
        int len = nums.length;
        for (int i=0;i<nums.length;i++) {
            nums[i] = Integer.parseInt(temps[i]);
        }
        quickSort(nums, 0, nums.length -1);
        System.out.println(nums[len - 3]);
    }
    public static void quickSort(int[] arr, int start, int end){
        if (start >= end){
            return;
        }
        //以开始为起点
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        while (true){
            while (i <= end && arr[i] < pivot){
                i++;
            }
            while (j > start && arr[j] > pivot){
                j--;
            }
            if (i < j){
                //保证比pivot小的都在一边
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }else {
                break;
            }
        }
        int temp = arr[start];
        arr[start] = arr[j];
        arr[j] = temp;
        quickSort(arr, start, j -1);
        quickSort(arr, j + 1, end);
    }
}
