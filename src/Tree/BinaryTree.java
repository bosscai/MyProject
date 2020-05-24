package Tree;

public class BinaryTree{
    private Tree root;

    public void setRoot(Tree root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if(root != null){
//            root.postorder();
        }
    }
}

class Tree {
    public int value;
    public Tree left;
    public Tree right;

    public Tree(int value) {
        this.value = value;
    }

    //前序遍历
    public void preorder(Tree p) {
        if (p != null) {
            System.out.print(p.value + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }
    //中序遍历
    public void inorder(Tree p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.value + " ");
            inorder(p.right);
        }
    }
    //后序遍历
    public void postorder(Tree p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.value + " ");
        }
    }
}