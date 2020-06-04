package HuffmanTree.HuffmanCode;

//创建节点类
//为了让node支持排序，node实现comparable接口
class Node implements Comparable<Node>{
    Byte data;      //存放数据（字符）本身，比如‘a'=>97
    int weight;     //出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node [data = " + data + ", weight = " + weight + "]";
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.weight - o.weight;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
}
