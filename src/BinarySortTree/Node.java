package BinarySortTree;

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    //查找要删除节点的父节点
    /**
     * @param value 要查找的数值
     * @return 要删除节点的父节点
     */
    public Node searchParent(int value){
        if (this.left != null && this.left.value == value || (this.right != null && this.right.value == value) ){
            return this;
        }else {
            //如果查找的值小于当前节点的数值，并且当前节点的左子节点不为空
            if (value < this.value && this.left != null){
                return this.left.searchParent(value);
            }else if (value >= this.value && this.right != null){
                return this.right.searchParent(value);
            }else {
                return null;
            }
        }
    }

    //查找要删除的节点
    /**
     * @param value 希望删除节点的数值
     * @return  返回该节点，否则为null
     */
    public Node search(int value){
        if (value == this.value){
            return this;
        }else if (value < this.value){
            //应该向左边查找
            if (this.left == null){
                return null;
            }
            return this.left.search(value);
        }else {
            //向右边查找
            if (this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    //添加节点
    public void add(Node node){
        if (node == null){
            System.out.println("结点为null，无法添加！");
            return;
        }

        //判断传入的节点值，和当前节点值的关系
        if (node.value < this.value){
            if (this.left == null){
                //如果当前节点左子节点为null
                this.left = node;
            }else {
                //如果当前节点左子节点不为null,递归向左
                this.left.add(node);
            }
        }else {
            //当添加的节点大于当前节点的值
            if (this.right == null){
                //如果当前节点左子节点为null
                this.right = node;
            }else {
                //如果当前节点左子节点不为null,递归向左
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.print(this + " ");
        if (this.right != null){
            this.right.infixOrder();
        }
    }
}