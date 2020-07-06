package Algorithm.Kruskal;

import java.util.Arrays;

public class KruskalCase {

    private int edgeNum;        //边的个数
    private char[] vertexs;     //顶点数组
    private int[][] matrix;     //邻接矩阵
    //表示两个顶点不能联通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E','F','G'};
        int[][] matrix = {{0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF,  INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}};
        //创建克鲁斯卡尔实例
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
//        kruskalCase.print();
        EData[] edges = kruskalCase.getEdges();
        System.out.println("before sort :" + Arrays.toString(edges));
        kruskalCase.sortEdges(edges);
        System.out.println("after sort :" + Arrays.toString(edges));
        kruskalCase.kruskal();
    }

    public KruskalCase(char[] vertexs, int[][] matrix) {
        //初始化顶点数和边的个数
        int vlen = vertexs.length;
        //初始化顶点,使用的是复制拷贝的方式
        this.vertexs = new char[vlen];
        for (int i=0;i<vlen;i++){
            this.vertexs[i] = vertexs[i];
        }
        this.matrix = matrix;
        //统计边
        for (int i=0;i<matrix.length;i++){
            for (int j=i+1;j<matrix[0].length;j++){
                if (this.matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }
    }
    private void kruskal(){
        int index = 0;      //表示最后结果数组的索引
        int[] ends = new int[edgeNum];      //用于保存“已有最小生成树”中的每个顶点在最小生成树的终点
        //创建结果数组，保存最后的最小生成树
        EData[] res = new EData[edgeNum];
        //获取图中所有边的集合
        EData[] edges = getEdges();
        //排序
        sortEdges(edges);
        //遍历edges数组，将边添加到最小生成树中时，判断准备加入的边是否形成了回路，如果没有就加入到res，否则不能加入。
        for (int i=0;i < edgeNum;i++){
            //获取到第i条边的第一个顶点（起点）
            int p1 = getPosition(edges[i].start);
            //获取到第i条边的第二个顶点（起点）
            int p2 = getPosition(edges[i].end);

            //获取p1这个顶点在已有最小生成树的终点
            int m = getEnd(ends, p1);
            //获取p2这个顶点在已有最小生成树的终点
            int n = getEnd(ends, p2);
            //是否构成回路
            if (m != n){
                ends[m] = n;                //设置m在“已有最小生成树”中的终点
                res[index++] = edges[i];    //有一条边加入到res
            }
        }

        //统计并打印“最小生成树”，输出res
        System.out.println("最小生成树");
        for (int i=0;i<index;i++){
            System.out.println(res[i]);
        }
    }
    //打印数据
    public void print(){
        System.out.println("邻接矩阵：");
        for (int[] temp : matrix){
            System.out.println(Arrays.toString(temp));
        }
    }

    //对边进行排序
    private void sortEdges(EData[] edges){
        for (int i=0;i<edges.length;i++){
            for (int j=i+1;j<edges.length;j++){
                if (edges[j].weight < edges[i].weight){
                    EData temp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = temp;
                }
            }
        }
    }
    //返回对应的下标
    private int getPosition(char ch){
        for (int i=0;i<vertexs.length;i++){
            if (vertexs[i] == ch){
                return i;
            }
        }
        return -1;
    }
    //获取图中的边，放到EData[]中，后面我们遍历该数组
    private EData[] getEdges(){
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i=0;i<vertexs.length;i++){
            for (int j=i+1;j<vertexs.length;j++){
                if (matrix[i][j] != INF){
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }
    //获取下标为i的顶点的终点，用于后面判断两个顶点的终点是否相同
    /**
     * @param ends  记录各个顶点对应的终点是哪个
     * @param i
     * @return
     */
    private int getEnd(int[] ends, int i){
        while (ends[i] != 0){
            i = ends[i];
        }
        return i;
    }
}
//创建一个类，它的实例对象表示为一条边
class EData{
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
