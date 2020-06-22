package Algorithm.binarySearch;

public class binarySearch {
    public static void main(String[] args) {

    }

    public static int binarySearch(int[] arr, int target){
        int left =  0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] == target){
                return mid;
            }
            if (arr[mid] > target){
                right = mid - 1;
            }
            if (arr[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }
}
