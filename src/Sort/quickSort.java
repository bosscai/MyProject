package Sort;

public class quickSort {
    public static void quickSort(int[] data, int start, int end) {
        if (start >= end)
            return;
        //以起始索引为分界点
        int pivot = data[start];
        int i = start + 1;
        int j = end;
        while (true) {
            while (i <= end && data[i] < pivot) {
                i++;
            }
            while (j > start && data[j] > pivot) {
                j--;
            }
            if (i < j) {
                //保证比pivot小的都在一边
                swap(data, i, j);
            } else {
                break;
            }
        }
        //交换 j和分界点的值
        swap(data, start, j);
//        print(data);
        //递归左子序列
        quickSort(data, start, j - 1);
        //递归右子序列
        quickSort(data, j + 1, end);
    }
    //交换函数
    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
