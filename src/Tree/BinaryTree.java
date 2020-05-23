package Tree;

public class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
        this.value = value;
    }

    private void preorder(BinaryTree p) {
        if (p != null) {
            System.out.print(p.value + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }
    private void inorder(BinaryTree p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.value + " ");
            inorder(p.right);
        }
    }
    private void postorder(BinaryTree p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.value + " ");
        }
    }
}