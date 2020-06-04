package HuffmanTree.HuffmanCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);
        ArrayList<Node> nodes = getNodes(contentBytes);
        System.out.println(nodes);
        Node root = createHuffmanTree(nodes);
        preOrder(root);
    }

    //前序遍历
    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("HuffmanTree is null");
        }
    }

    //将数据转换为Node节点
    private static ArrayList<Node> getNodes(byte[] bytes){

        //先创建一个ArrayList<Node>
        ArrayList<Node> nodes = new ArrayList<>();

        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes){
            if (counts.containsKey(b)){
                counts.put(b,counts.get(b) + 1);
            }else {
                counts.put(b, 1);
            }
        }

        //把键值对转换成node,遍历map
        for (HashMap.Entry<Byte, Integer> entry : counts.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    //生成HuffmanTree
    public static Node createHuffmanTree(ArrayList<Node> nodes){
       while (nodes.size() > 1){
           //排序
           Collections.sort(nodes);
           //第一棵最小的树
           Node leftNode = nodes.get(0);
           //第二棵最小的树
           Node rightNode = nodes.get(1);
           Node parent = new Node(null,leftNode.weight + rightNode.weight);
           parent.left = leftNode;
           parent.right = rightNode;
           nodes.add(parent);
           nodes.remove(leftNode);
           nodes.remove(rightNode);
       }
       return nodes.get(0);
    }
}
