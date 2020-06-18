package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private ArrayList<String> vertexList;       //存储顶点
    private int[][] edges;                      //存储图对应的邻接矩阵
    private int numOfEdges;                     //表示边的数目
    //定义个数组Boolean[]，记录节点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String[] vertexValue = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        //添加顶点
        for (String value : vertexValue){
            graph.insertVertex(value);
        }
        //添加边 A-B A-C B-C B-D B-E
        graph.insertEdge(0,1, 1);
        graph.insertEdge(0,2, 1);
        graph.insertEdge(1,2, 1);
        graph.insertEdge(1,3, 1);
        graph.insertEdge(1,4, 1);

        graph.showGraph();

        graph.dfs();
    }

    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }
    private void bfs(){
        for (int i=0;i<getNumOfVertex();i++){
            if (!isVisited[i]){
                bfs(isVisited, i);
            }
        }
    }
    //广度优先遍历
    private void bfs(boolean[] isVisited, int i){
        int u;//表示头节点对应的下标
        int w;//表示邻接节点w
        //队列，记录节点的访问顺序
        LinkedList queue = new LinkedList<>();
        //访问节点，输出节点信息
        System.out.print(getValueByIndex(i) + "=>");
        //标记为已访问
        isVisited[i] = true;
        //将节点加入duil
        queue.add(i);
        while (!queue.isEmpty()){
            //取出队列的头节点的下标
            u = (Integer) queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1 ){
                //找到
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "=>");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                //以u为前驱，找w后面的下一个临节点
                w = getNextNeighbor(u, w);
            }
        }
    }
    //对dfs进行重载
    public void dfs(){
        for (int i=0;i<getNumOfVertex();i++){
            if (!isVisited[i]){
                dfs(isVisited, i);
            }
        }
    }
    //深度优先遍历
    public void dfs(boolean[] isVisited, int i){
        //首先我们访问该节点
        System.out.println(getValueByIndex(i) + "->");
        //将节点设置为已经访问
        isVisited[i] = true;
        //查找节点i的第一个邻接点
        int w = getFirstNeighbor(i);
        while(w != -1){
            //说明有
            if (!isVisited[w]){
                dfs(isVisited, w);
            }
            //如果w节点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }
    //根据前一个邻接节点的下标来获取下一个邻接节点的
    public int getNextNeighbor(int v1, int v2){
        for (int j=v2+1;j<vertexList.size();j++){
            if (edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }
    //得到第一个邻接节点的下标w

    /**
     * @param index
     * @return          如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index){
        for (int j=0;j<vertexList.size();j++){
            if (edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }

    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //添加边
    /**
     * @param v1        表示点的下标
     * @param v2        表示另一个点的下标
     * @param weight    表示权重，0的话即为断开
     */
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
    //图中常用的方法
    //返回图中顶点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //返回节点i（下标）对应的数据0->"A"
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph(){
        for (int[] link : edges){
            System.err.println(Arrays.toString(link));
        }
    }
}
