package AVL;

class Node {
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

    //返回左子树高度
    public int leftHeight(){
        if (left != null){
            return left.height();
        }else {
            return 0;
        }
    }

    //返回右子树高度
    public int rightHeight(){
        if (right != null){
            return right.height();
        }else {
            return 0;
        }
    }

    //返回以当前节点为root节点的树的高度
    public int height(){
        return Math.max(this.left == null ? 0 :this.left.height(),
                this.right == null ? 0 : this.right.height()) + 1;
    }

    //左旋方法
    private void leftRotate(){
        //创建新的节点，以当前节点的值
        Node newNode = new Node(value);
        //把新的节点的左子树设置为当前节点的左子树
        newNode.left = this.left;
        //把新的节点的右子树设置为当前节点的右子树的左子树
        newNode.right = this.right.left;
        //把当前节点的值替换成右子节点的值
        this.value = this.right.value;
        //把当前节点的右子树，设置为当前节点的右子树的右子树
        this.right = this.right.right;
        //把当前节点的左子节点设置成新的节点
        this.left = newNode;
    }

    //右旋方法
    private void rightRotate(){
        //创建新的节点，以当前节点的值
        Node newNode = new Node(value);
        //把新的节点的右子树设置为当前节点的右子树
        newNode.right = this.right;
        //把新的节点的左子树设置为当前节点的左子树的右子树
        newNode.left = this.left.right;
        //把当前节点的值替换成左子节点的值
        this.value = this.left.value;
        //把当前节点的左子树，设置为当前节点的左子树的左子树
        this.left = this.left.left;
        //把当前节点的右子节点设置成新的节点
        this.right = newNode;
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
        //当添加完一个节点后，右子树的节点 - 左子树的节点 > 1，左旋转
        if (this.rightHeight() - this.leftHeight() > 1){
            //如果它的右子树的左子树的高度大于其右子树的高度，需要进行右旋调整
            if (this.right != null && this.right.leftHeight() > this.right.rightHeight()){
                //先对当前节点的左节点进行一下右旋转
                this.right.rightRotate();
            }
            this.leftRotate();
            return;
        }
        if (this.leftHeight() - this.rightHeight() > 1){
            //如果它的左子树的右子树的高度大于其左子树的高度，需要进行左旋调整
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight()){
                //先对当前节点的左节点进行一下左旋转
                this.left.leftRotate();
            }
            this.rightRotate();
            return;
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