package AVL;

public class AVLTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
        int[] arr = {10, 12, 8, 9, 7, 6};
        AVLTree tree = new AVLTree();
        for (int i=0;i<arr.length;i++){
            tree.add(new Node(arr[i]));
        }
        System.out.println("遍历");
        tree.infixOrder();
        System.out.println();
        System.out.println("根节点=" + tree.getRoot());
        System.out.println("树的高度=" + tree.getRoot().height());
        System.out.println("左子树的高度=" + tree.getRoot().leftHeight());
        System.out.println("右子树的高度=" + tree.getRoot().rightHeight());
    }
}
