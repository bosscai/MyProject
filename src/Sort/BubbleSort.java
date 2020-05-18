package Sort;

public class BubbleSort {
    //从小到大
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        boolean flag = true; // 标志位
        for (int i = 0; i < array.length; i++) {
            flag = true;
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
        return array;
    }
}
