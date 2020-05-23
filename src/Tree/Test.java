package Tree;

public class Test {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(10);
        BinaryTree node1 = new BinaryTree(6);
        BinaryTree node2 = new BinaryTree(14);
        BinaryTree node3 = new BinaryTree(4);
        BinaryTree node4 = new BinaryTree(8);
        BinaryTree node5 = new BinaryTree(12);
        BinaryTree node6 = new BinaryTree(16);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

    }
}
