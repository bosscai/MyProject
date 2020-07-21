package LeetCode.LC147;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1};
        int[] B = {2};
        //[],[1]
        double res = solution.findMedianSortedArrays(A, B);
        System.out.println(res);
    }
    public double findMedianSortedArrays (int[] A, int[] B) {
        // write code here
        int m = A.length, n = B.length;
        int total = m + n;
        if (total % 2 == 1){
            return getkth(A, m, B, n, total/2+1);
        }else {
            return (getkth(A, m, B, n,total/2) + getkth(A, m, B, n,total/2+1))/ 2.0;
        }


//        return (getkth(A, 0, B, 0, l) + getkth(A ,0, B, 0, r)) / 2.0;

    }
    private double getkth(int[] A, int m, int[] B, int n, int k){
        if (m > n){
            return getkth(B, n, A, m, k);
        }
        if (m == 0){
            return B[k-1];
        }
        if (k == 1){
            return Math.min(A[0], B[0]);
        }
        //比较一下，中位数和最短数组的长度
        int pa = Math.min(k/2, m);
        //另一个数组就需要提供剩下的数组长度
        int pb = k - pa;
        if (A[pa - 1] < B[pb - 1]){
            return getkth(A, m-pa, B, n, k-pa);
        }else if (A[pa - 1] > B[pb - 1]){
            return getkth(A, m, B, n - pb, k-pb);
        }else {
            return A[pa-1];
        }
    }
}
