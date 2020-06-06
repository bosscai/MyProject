package BinarySortTree;

public class BinarySortTree {
    private Node root;

    //删除节点
    public void delNode(int value){
        if (root == null){
            return;
        }else {
            //找到要删除的节点
            Node targetNode = search(value);
            //如果没有找到要删除的节点
            if (targetNode == null){
                System.out.println("该节点不存在");
                return;
            }
            //如果targetNode没有父节点，即删除根节点
            //如果我们发现当前的这棵二叉树只有一个节点
            if (root.left == null && root.right == null){
                root = null;
                return;
            }
            //去找targetNode父节点
            Node parent = searchParent(value);
            if (targetNode.left == null && targetNode.right == null){
                if (parent.left != null && parent.left.value == value){
                    parent.left = null;
                }else {
                    parent.right = null;
                }
            }
        }
    }

    //查找要删除的节点
    public Node search(int value){
        if (root == null){
            return null;
        }else {
            return root.search(value);
        }
    }
    //查找要删除的父节点
    public Node searchParent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }
    //添加节点的方法
    public void add(Node node){
        if (root == null){
            //如果root为null，直接让node指向root
            root = node;
        }else {
            root.add(node);
        }
    }
    //中序遍历方法
    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else {
            System.out.print("root为null，无法遍历。");
        }
    }
}
