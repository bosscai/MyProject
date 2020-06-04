package Sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void HeapSort(int[] arrs){
        int temp = 0;
        System.out.println("堆排序");

        for (int i = arrs.length/2 - 1; i >= 0;i--){
            adjustHeap(arrs, i, arrs.length);
        }
        //从下往上调整
        for (int j=arrs.length-1;j>0;j--){
            //change
            temp = arrs[j];
            arrs[j] = arrs[0];
            arrs[0] = temp;
            adjustHeap(arrs, 0, j);
        }
    }

    //讲一个数组调整成为大顶堆

    /**
     * @param arr       待调整的数组
     * @param i         完成将以i对应的非叶子节点的索引
     * @param length    多少个元素调整，length在减少
     */
    public static void adjustHeap(int[] arr, int i, int length){

        int temp = arr[i];
        //begin adjust
//        k is the i's left
        for (int k = i*2 + 1; k < length; k = k *2 + 1){
            if (k + 1 < length && arr[k] < arr[k + 1]){
                //left is smaller than right, we need a biger one so
                k++;
            }
            if (arr[k] > temp){
                // son node is biger than father node, we need change them.
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}
