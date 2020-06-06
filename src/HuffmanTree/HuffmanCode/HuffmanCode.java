package HuffmanTree.HuffmanCode;

import java.io.*;
import java.util.*;

public class HuffmanCode {
    //思路：
    //1、将赫夫曼编码表存放在Map<Byte, String>形式
    private static Map<Byte, String> huffmanCodes = new HashMap<>();
    //2、在生成赫夫曼编码表示，需要去拼接路径，定义一个StringBuilder 存储某个叶子节点的路径
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        /*
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
//        System.out.println(contentBytes.length);
//        //测试生成的huffmanTree
        ArrayList<Node> nodes = getNodes(contentBytes);
//        System.out.println(nodes);
        Node root = createHuffmanTree(nodes);
////        preOrder(root);
        //测试生成HuffmanCode
////        System.out.println("测试生成HuffmanCode");
        getCodes(root);
////        System.out.println(huffmanCodes);
//
        byte[] huffmancodebytes = zip(contentBytes, huffmanCodes);
//        System.out.println("huffmancodebytes1 = " + Arrays.toString(huffmancodebytes));
//        System.out.println("huffmancodebytes2 = " + Arrays.toString(huffmanZip(content)));

        //测试byteToString方法
//        System.out.println(byteToBitString((byte) -1 ));
        byte[] source = decode(huffmanCodes, huffmancodebytes);
        System.out.println(new String(source));
         */
        //测试压缩文件
        String src = "C:\\Users\\CCX\\Desktop\\lambda_inter";
        String drc = "C:\\Users\\CCX\\Desktop\\lambda_inter.zip";
//        zipFile(src, drc);
        unZipFile(drc, "C:\\Users\\CCX\\Desktop\\lambda_inter_ccx");

    }

    public static void unZipFile(String zipFile, String dstFile){
        //定义文件的输入流
        InputStream is = null;
        //定义一个对象输入流
        ObjectInputStream ois = null;
        //定义文件的输出流
        OutputStream os = null;
        try {
            //创建文件输入流
            is = new FileInputStream(zipFile);
            ///创建一个与is关联的对象输入流
            ois = new ObjectInputStream(is);
            //读取byte数组huffmanBytes
            byte[] huffmanBytes = (byte[])ois.readObject();
            //读取byte数组huffmanCodes
            HashMap<Byte, String> codes = (HashMap<Byte, String>) ois.readObject();
            //解码
            byte[] decodeBytes = decode(codes, huffmanBytes);
            os = new FileOutputStream(dstFile);
            os.write(decodeBytes);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param srcFile
     * @param dstFile
     */
    public static void zipFile(String srcFile, String dstFile) {
        //创建文件的输入流
        FileInputStream is = null;
        //创建文件的输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            is = new FileInputStream(srcFile);
            //创建一个和源文件大小一样的byte[],available方法返回是可读取的字节数
            byte[] b = new byte[1024];
//            while (is.read(b) != -1) {
//                byte[] huffmanBytes = huffmanZip(b);
//                os = new FileOutputStream(dstFile);
//                oos = new ObjectOutputStream(os);
//                oos.writeObject(huffmanBytes, 0, huffmanBytes.length);
//            }
            //读取文件
            is.read(b);
            //直接对源文件进行压缩
            byte[] huffmanBytes = huffmanZip(b);
            //创建文件的输出流，存放压缩文件
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //把赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            //把赫夫曼编码表也写入压缩文件
            oos.writeObject(huffmanCodes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                is.close();
                os.close();
                oos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //编写一个方法，完成对压缩数据的解码

    /**
     * @param huffmanCodes 原来的Huffman编码
     * @param huffmanBytes 赫夫曼编码得到的字节数
     * @return
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        //1、先得到huffmanBytes对应的二进制字符串
        StringBuilder builder = new StringBuilder();
        //2、将byte数组转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            if (i != huffmanBytes.length - 1) {
                builder.append(byteToBitString(true, huffmanBytes[i]));
            } else {
                builder.append(byteToBitString(false, huffmanBytes[i]));
            }
        }
//        System.out.println("赫夫曼字节数组对应的二进制字符串=" + builder.toString());
        //把字符串安装指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行调换，因为反向查阅a->100, 100->a;
        Map<String, Byte> unDecode = new HashMap<>();
        for (HashMap.Entry<Byte, String> map : huffmanCodes.entrySet()) {
            unDecode.put(map.getValue(), map.getKey());
        }
        //创建集合，存放byte
        List<Byte> list = new ArrayList<>();
        //双指针
        for (int i = 0; i < builder.length(); ) {
            int count = 1;  //第二个指针
//            boolean flag = true;
            Byte temp = null;
            while (true) {
                String key = builder.substring(i, i + count);
                temp = unDecode.get(key);
                if (temp != null) {
                    list.add(temp);
                    break;
//                    flag = false;
                } else {
                    count++;
                }
            }

            i += count;
        }
        byte[] res = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * @param flag 最后一个字节无需补高位
     * @param b
     * @return
     */
    private static String byteToBitString(boolean flag, byte b) {
        //使用变量保存b
        int temp = b;
        //如果是正数，我们需要补高位
        if (flag) {
            temp |= 256;        //按位或256 1 0000 0000 | 0000 0001 => 1 0000 0001
        }
        //返回的是temp对应的二进制的补码
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }

    }

    //将所有方法进行一个封装，便于我们调用
    private static byte[] huffmanZip(byte[] bytes) {
//        if (str.isEmpty()) return null;
//        //将字符串转换为byte数组
//        byte[] contentBytes = str.getBytes();
        byte[] contentBytes = bytes;
        //将byte数组转换为node节点
        ArrayList<Node> nodes = getNodes(contentBytes);
        //将node节点转换为HuffmanTree
        Node root = createHuffmanTree(nodes);
        //根据HuffmanTree对字符串进行编码
        getCodes(root);
        //重新生成byte数组
        byte[] huffmancodebytes = zip(contentBytes, huffmanCodes);
        return huffmancodebytes;
    }


    //将字符串生成对应的byte[]数组，通过生成的HuffmanCode表，返回一个Huffman编码压缩后的byte[]
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //1、利用HuffmanCode将bytes转成赫夫曼编码对应的字符串
        StringBuilder builder = new StringBuilder();
        //遍历bytes数组
        for (byte b : bytes) {
            builder.append(huffmanCodes.get(b));
        }
//        System.out.println("测试stringbuilder=" + builder.toString());

        //统计返回byte[] huffmanCodeBytes长度
        int len = (builder.length() + 7) / 8;
        //创建HuffmanCodeBytes，存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < builder.length(); i += 8) {
            String strByte;
            if (i + 8 < builder.length()) {
                strByte = builder.substring(i, i + 8);
            } else {
                strByte = builder.substring(i);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    //生成HuffmanTree对应的HuffmanCode编码表
    private static void getCodes(Node node) {
        if (node == null) {
            System.out.println("root is null");
        } else {
            getCodes(node, "", stringBuilder);
        }

    }

    /**
     * @param node          根节点
     * @param code          0或者1,0代表向左，1代表向右
     * @param stringBuilder 生成的HuffmanCode
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder res = new StringBuilder(stringBuilder);
//        StringBuilder res = stringBuilder;
        //将code加入到res中
        res.append(code);
        if (node != null) {
            //判断当前node是叶子节点还是非叶子节点
            if (node.data == null) {
                //向左递归调用
                getCodes(node.left, "0", res);
                //向右递归调用
                getCodes(node.right, "1", res);
            } else {
                //叶子节点，表示找到了某个叶子节点
                huffmanCodes.put(node.data, res.toString());
            }
        }
    }


    //前序遍历
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("HuffmanTree is null");
        }
    }

    //将数据转换为Node节点
    private static ArrayList<Node> getNodes(byte[] bytes) {

        //先创建一个ArrayList<Node>
        ArrayList<Node> nodes = new ArrayList<>();

        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            if (counts.containsKey(b)) {
                counts.put(b, counts.get(b) + 1);
            } else {
                counts.put(b, 1);
            }
        }

        //把键值对转换成node,遍历map
        for (HashMap.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    //生成HuffmanTree
    public static Node createHuffmanTree(ArrayList<Node> nodes) {
        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            //第一棵最小的树
            Node leftNode = nodes.get(0);
            //第二棵最小的树
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.add(parent);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
        }
        return nodes.get(0);
    }
}
