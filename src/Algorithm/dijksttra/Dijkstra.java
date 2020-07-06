package Algorithm.dijksttra;

import java.util.Arrays;

public class Dijkstra {
    public static void main(String[] args) {
        char[] vertx = {'A', 'B', 'C', 'D', 'E', 'F','G'};
        final int N = 65535;
        int[][] mattix = {
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N},
        };
        Graph graph = new Graph(vertx, mattix);
        graph.showGraph();
        graph.dsj(6);       //调用迪杰斯塔拉算法
        graph.showDijkstra();
    }
}
class Graph{
    private char[] vertx ;
    private int[][] martix;
    private VisitedVertex visitedVertex;

    public Graph(char[] vertx, int[][] martix) {
        this.vertx = vertx;
        this.martix = martix;
    }

    //显示结果
    public void showDijkstra(){
        visitedVertex.show();
    }

    public void showGraph(){
        for (int[] link : martix){
            System.out.println(Arrays.toString(link));
        }
    }

    public void dsj(int index){
         visitedVertex = new VisitedVertex(vertx.length, index);
         update(index);     //更新index顶点到周围顶点的距离和前驱顶点
         for (int j=1;j<vertx.length;j++){
             index = visitedVertex.updateArr();     //选择并返回新的访问顶点
             update(index);                         //更新index顶点到周围顶点的距离和前驱顶点
         }
    }
    //更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
    private void update(int index){
        int len = 0;
        //根据index选择遍历的行数
        for(int j=0;j<martix[index].length;j++){
            len = visitedVertex.getDis(index) + martix[index][j];
            if(!visitedVertex.in(j) && len < visitedVertex.getDis(j)){
                visitedVertex.updatePre(j, index);  //更新前驱
                visitedVertex.updateDis(j, len);    //更新距离
            }
        }
    }


}
class VisitedVertex{
    //记录各个顶点是否访问过，1表示访问过，0表示没有访问过。动态更新
    public int[] already_arr;
    //每个下标对应的值为前一个顶点的下标，会动态更新
    public int[] pre_visited;
    //记录出发点到其他所有点的距离
    public int[] dis;

    //构造器
    public VisitedVertex(int length, int index){
        already_arr = new int[length];
        pre_visited = new int[length];
        dis = new int[length];
        //初始化dis
        Arrays.fill(dis, 65535);
        this.already_arr[index] = 1;
        this.dis[index] = 0;        //设置出发顶点的距离为0
    }

    //判断index节点是否被访问过
    public boolean in(int index){
        return already_arr[index] == 1;
    }
    //更新dis
    public void updateDis(int index, int len){
        dis[index] = len;
    }
    //更新前驱节点
    public void updatePre(int pre, int index){
        pre_visited[pre] = index;
    }
    //返回出发顶点到index顶点的距离
    public int getDis(int index) {
        return dis[index];
    }
    //继续选择并返回新的访问顶点，比如访问完G之后，要开始访问A
    public int updateArr(){
        int min = 65535, index = 0;
        for (int i=0; i<already_arr.length;i++){
            if (already_arr[i] == 0 && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1;
        return index;
    }
    //显示最后的结果,将数组的结果输出
    public void show(){
        System.out.println("====================================");
        for (int i : already_arr){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : pre_visited){
            System.out.print(i + " ");
        }
        System.out.println();
        char[] vertx = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int count = 0;
        for (int i : dis){
            if (i != 65535){
                System.out.print(vertx[count] + "(" + i + ")");
            }else {
                System.out.print(vertx[count] + "(N)");
            }
            count++;
        }
    }
}
