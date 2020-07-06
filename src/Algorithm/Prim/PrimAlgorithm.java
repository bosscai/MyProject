package Algorithm.Prim;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        //测试看看图是否创建OK
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verx = data.length;
        //临界矩阵的关系用二维数组描述
        int[][] weight = {{1000, 5, 7, 1000, 1000, 1000, 2},
                {5, 1000, 1000, 9, 1000, 1000, 3},
                {7, 1000, 1000, 1000, 8, 1000, 1000,},
                {1000, 9, 1000, 1000, 1000, 4, 1000},
                {1000, 1000, 8, 1000, 1000, 5, 4},
                {1000, 1000, 1000, 4, 5, 1000, 6},
                {2, 3, 1000, 1000, 4, 6, 1000}};
        MGraph mGraph = new MGraph(verx);
        MinTree tree = new MinTree();
        tree.createGraph(mGraph, verx, data, weight);
        tree.showGraph(mGraph);
        tree.prim(mGraph, 0);
    }
}

class MinTree{
    //创建图的临界矩阵
    /**
     * @param graph 图对象
     * @param verx  图对应的顶点个数
     * @param data  图的各个顶点值
     * @param weight    图的临界矩阵
     */
    public void createGraph(MGraph graph, int verx, char[] data, int[][] weight){
        int i, j;
        for (i=0;i<verx;i++){
            graph.data[i] = data[i];
            for (j=0;j<verx;j++){
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的方法
    public void showGraph(MGraph graph){
        for (int[] link : graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }
    //编写prim算法，得到最小生成树

    /**
     * @param graph 图
     * @param v     选择从哪个节点开始
     */
    public void prim(MGraph graph, int v){
        //标记节点位，是否被访问过
        int[] visited = new int[graph.verx];
        //把当前的节点标记为已访问
        visited[v] = 1;
        //h1和h2标记两个节点的下标
        int h1 = -1;
        int h2 = -1;
        //将minWeight初始化为一个较大的数，后面的过程中会被替换
        int minWeight = 10000;
        for(int k=1;k<graph.verx;k++){
            //因为有这么多个顶点，prim算法后会形成verx-1条边
            //确定生成的子图，确定和哪个节点的距离最近
            for (int i=0;i<graph.verx;i++){     //i节点表示被访问过节点
                for (int j=0;j<graph.verx;j++){ //j节点表示没有访问过的节点
                    if (visited[i] == 1 && visited[j] != 1 && graph.weight[i][j] < minWeight ){
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到最小的一条边
            System.out.println("边< " + graph.data[h1] + ", " + graph.data[h2] + " >，权值为：" + minWeight);
            //重置为了下一次做准备
            visited[h2] = 1;
            minWeight = 10000;
        }

    }
}

class MGraph{
    int verx;       //图的节点个数
    char[] data;    //存放顶点数据
    int[][] weight; //存放边

    public MGraph(int verx) {
        this.verx = verx;
        data = new char[verx];
        weight = new int[verx][verx];
    }
}