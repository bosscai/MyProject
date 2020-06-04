package HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        preOrder(createHuffmanTree(arr));
    }

    public static Node createHuffmanTree(int[] arr){
        //第一步为了操作方便
        //1、遍历arr数组
        //2、将arr的每一个元素构建成一个node
        //3、将node放入ArrayList
        ArrayList<Node> nodes = new ArrayList<Node>();
        for (int value : arr){
            nodes.add(new Node(value));
        }

        //排序
        while (nodes.size()>1){
            Collections.sort(nodes);

//        System.out.println("nodes = " + nodes);

            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;
            nodes.add(parent);
            nodes.remove(left);
            nodes.remove(right);
        }
        //返回根节点
        return nodes.get(0);
    }

    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("根节点为null");
        }
    }
}

//创建节点类
//为了让node支持排序，node实现comparable接口
class Node implements Comparable<Node>{
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

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.value - o.value;
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
