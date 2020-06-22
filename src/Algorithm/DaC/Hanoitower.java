package Algorithm.DaC;

public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }
    //汉诺塔的方法
    public static void hanoiTower(int num, char a, char b, char c){
        //如果只有一个盘子
        if (num == 1){
            System.out.println("第1个盘子" + a + "->" + c);
        }else {
            //1、先把A塔上面的盘子移动到B塔，中途利用到C塔
            hanoiTower(num - 1, a, c, b);
            //2、把最下面的的盘A->C
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            //3、B->C
            hanoiTower(num - 1, b, a, c);
        }
    }
}
