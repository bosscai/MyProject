package BinarySortTree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree tree = new BinarySortTree();
        for (int i=0;i<arr.length;i++){
            tree.add(new Node(arr[i]));
        }
        tree.infixOrder();
        tree.delNode(2);
        tree.delNode(5);
        tree.delNode(9);
        tree.delNode(12);
        tree.delNode(7);
        tree.delNode(3);
        tree.delNode(10);
        tree.delNode(1);
//        tree.delNode(10);
        System.out.println();
        tree.infixOrder();
    }
}
