package AVL;

import AVL.Node;

public class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    //删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //找到要删除的节点
            Node targetNode = search(value);
            //如果没有找到要删除的节点
            if (targetNode == null) {
                System.out.println("该节点不存在");
                return;
            }
            //如果targetNode没有父节点，即删除根节点
            //如果我们发现当前的这棵二叉树只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //去找targetNode父节点
            Node parent = searchParent(value);
            //删除非根节点
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                //删除有两棵子树的节点,右边找最小，或者左边找最大
                int min = delRightTreeMin(targetNode.right);
                targetNode.value = min;
            } else {
                //删除只有一颗子树的节点
                //删除的targetNode节点只有左子节点
                if (targetNode.left != null) {
                    if (parent != null){
                        //如果targetNode是parent的左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            //targetNode是parent的右子节点
                            parent.right = targetNode.left;
                        }
                    }else {
                        root = targetNode.left;
                    }
                } else {
                    //删除的targetNode节点只有右子节点
                    //如果targetNode是parent的左子节点
                    if (parent != null){
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            //targetNode是parent的右子节点
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    /**
     * 寻找右子树中最小的节点
     *
     * @param node 传入的节点
     * @return 以node为根节点的最小值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左节点
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    /**
     * 删除左子树中最大的节点
     *
     * @param node
     * @return
     */
    public int delLeftTreeMax(Node node) {
        Node target = node;
        //循环的查找左节点
        while (target.right != null) {
            target = target.right;
        }
        delNode(target.value);
        return target.value;
    }

    //查找要删除的节点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找要删除的父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //添加节点的方法
    public void add(Node node) {
        if (root == null) {
            //如果root为null，直接让node指向root
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历方法
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.print("root为null，无法遍历。");
        }
    }
}
