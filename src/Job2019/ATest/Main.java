package Job2019.ATest;

import Sort.BubbleSort;
import Sort.mergeSort;
import Sort.quickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5,2,3,4,8,5,6,9};
        quickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
